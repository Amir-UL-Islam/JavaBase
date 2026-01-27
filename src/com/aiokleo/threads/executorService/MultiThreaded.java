package com.aiokleo.threads.executorService;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MultiThreaded{
    private static final String DOCUMENT = "" +
            "<html>" +
            "    <head>" +
            "        <title> SingleThreaded Application Test</title>" +
            "    </head>" +
            "    <body>" +
            "       <p> Working Now</p>" +
            "     </body>" +
            "</html>";

    private static final String HEADER = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: " + DOCUMENT.length() + "\r\n\r\n";

    /**
     * @param connection
     */
    private static void serverRequest(Socket connection) {
        System.out.println("New Connection request from: " + connection.toString());
        try (OutputStream os = connection.getOutputStream();
                PrintWriter out = new PrintWriter(os)) {
            out.write(HEADER);
            out.write(DOCUMENT);
        } catch (IOException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
    public static void main(String[] args) throws IOException{
        ServerSocket socket = new ServerSocket(8089);


        Executor executor = Executors.newFixedThreadPool(10);
        while(true){
            Socket connection = socket.accept();

            executor.execute(new Runnable() {
                @Override
                public void run(){
                    serverRequest(connection);
                }
            });
        }
    }
    
}
