package com.example.demoservlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MathO extends HttpServlet {
    // Have to Use the Service Method in order to add any Service LIKE here adding Numbers
    // Have to User HttpServletRequest and HttpServletResponse to get the Request and Response from the Client
//    This Line of Code is also Valid for both GET and POST
//    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Only for Post Request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // catching the Request from the Client
        // Getting the Query String from the Request
        int i = Integer.parseInt(request.getParameter("N1"));
        int j = Integer.parseInt(request.getParameter("N2"));

        int k = i + j;
        System.out.println(k);

        // You have to set the Flow in web.xml file

        // Printing data Server to Client
        PrintWriter out = response.getWriter();
        out.println("Result is " + k);
    }
}
