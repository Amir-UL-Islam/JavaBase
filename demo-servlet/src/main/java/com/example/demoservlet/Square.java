package com.example.demoservlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Square extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Getting the Attribute from the Request
        int kSquare = (int) request.getAttribute("keyOfSum");
        kSquare = kSquare * kSquare;

        // Printing data Server to Client
        PrintWriter out = response.getWriter();
        out.println("Result is " + kSquare);

        // Have to specify the servlet name and the url pattern in web.xml file
    }
}
