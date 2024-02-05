<%-- 
    Document   : actor
    Created on : Feb 4, 2024, 6:53:59 PM
    Author     : ashevkar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actor</title>
    </head>
    <body>
        <br>
        <h1>Create a new Sakila Sample Database Actor</h1>

        <c:if test="${not empty violations}">
            <h2>Constraint Violations</h2>
            <table border=1>
                <tr>
                    <th>Name</th>
                    <th>Value</th>
                </tr>
                <c:forEach var="v" items="${requestScope.violations}">
                    <tr>
                        <td><c:out value="${v.propertyPath}"/></td>
                        <td><c:out value="${v.message}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
            <br>
           <div>
        <form method="post" action="/ashevkar-fp/actor">
            <div>
                <label for="actId">Actor ID :</label>
                <input type="text" id="actId" name="actId" value="${requestScope.actor.id}" />
            </div>
            
            <div>
                <label for="fn">First name :</label>
                <input type="text" id="fn" name="firstName" value="${requestScope.actor.firstName}" />
            </div>
            
            <div>
                <label for="ln">Last name :</label>
                <input type="text" id="ln" name="lastName" value="${requestScope.actor.lastName}"/> 
            </div><br>
            
            <button type="submit">Create button</button>
            
        </form>
            </div>
    </body>
    <style>
input[type=text], select {
  width: 200%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

button[type=submit] {
  width: 90%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  width: 40%;
}
table, th, td {
  border: 1px solid;
  border-collapse: collapse;
  padding: 7px;
  width: 30%;
  text-align: center;
}
</style>

</html>
