package com.aiokleo.threads.termination;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

class DownloadingStatus extends Thread {
    private volatile boolean beating = true;

    @Override
    public void run() {
        String[] dots = {
                ".", "..", "...", "....", "....."
        };

        while (beating) {
            for (String dot : dots) {
                System.out.println(dot);

                try {
                    Thread.sleep(50); // Making in waiting state main Thread.
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }
        }
    }

    public void shutdown() {
        this.beating = false;
    }

}

class FileDownloader extends Thread {
    private String url;
    private String fileName;

    public FileDownloader(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            System.out.println("Started to Download: " + fileName);

            URL resourceDownload = new URL(url);

            URLConnection connection = resourceDownload.openConnection();

            InputStream input = connection.getInputStream();

            File fileSaveTo = new File(fileName);
            Files.copy(input, fileSaveTo.toPath(), StandardCopyOption.REPLACE_EXISTING);

            input.close();

        } catch (IOException e) {
            System.err.println("Failed to Download the file: " + e.getMessage());
        }
    }

}

public class ThreadJoin {
    public static void main(String[] agrs) throws InterruptedException {
        FileDownloader image = new FileDownloader(
                "https://allthatsinteresting.com/thumb/630.501.https://allthatsinteresting.com/wordpress/wp-content/uploads/2014/03/photographs-buddhist-monk.jpg",
                "burning_buddha.jpg");
        FileDownloader image2 = new FileDownloader("https://zupimages.net/up/21/32/7cfy.jpg",
                "after_world_war_first_thing_to_do.jpg");

        DownloadingStatus status = new DownloadingStatus();

        image.start();
        image2.start();

        status.start();

        try {
            image.join(); // Could have use a flag that would work there are uncertainties
            image2.join();

            status.shutdown();
            status.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Download Completed");
    }
}
