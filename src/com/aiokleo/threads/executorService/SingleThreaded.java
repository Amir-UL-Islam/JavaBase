//package com.aiokleo.threads.executorService.SingleThreaded;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreaded {

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

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8089);
        while (true) {
            Socket connection = serverSocket.accept();
            serverRequest(connection);
        }
    }

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
}
