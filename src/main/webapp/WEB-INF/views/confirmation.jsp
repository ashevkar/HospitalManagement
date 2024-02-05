<%-- 
    Document   : confirmation
    Created on : Feb 5, 2024, 12:32:51 AM
    Author     : ashevkar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation Page</title>
    </head>
    <body>
        <h1>Actor Confirmation Page </h1>
        
        <ul>
            <li>${requestScope.actor.id}</li>
            <li>${requestScope.actor.firstName}</li>
            <li>${requestScope.actor.lastName}</li>
            
            
            
        </ul>
    </body>
</html>
