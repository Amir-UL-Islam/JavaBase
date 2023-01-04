#### The moment I ```extend``` a normal Class with ```HttpServlet``` that class became Servlet Class.
#### If You want to work with only POST Request You should use ```doPost()``` method Instead of ```service()``` method.
>### RequestDispatcher
> - Use the Same Request and Response Objects
```
RequestDispatcher requestDispatcher = request.getRequestDispatcher("Square"); 
requestDispatcher.forward(request, response);
```
