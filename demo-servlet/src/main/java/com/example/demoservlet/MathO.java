package com.example.demoservlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MathO extends HttpServlet {
    // Have to Use the Service Method in order to add any Service LIKE here adding Numbers
    // Have to User HttpServletRequest and HttpServletResponse to get the Request and Response from the Client
    public void service(HttpServletRequest request, HttpServletResponse response){
        int i = Integer.parseInt(request.getParameter("N1"));
        int j = Integer.parseInt(request.getParameter("N2"));

        int k = i + j;
        System.out.println(k);

        // You have to set the Flow in web.xml file
    }
}
