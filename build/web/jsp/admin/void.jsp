<%-- 
    Document   : void
    Created on : Jun 9, 2015, 10:31:09 PM
    Author     : Lysyi Andrii 
--%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
    
     <body>
             <sql:query var="users" dataSource="jdbc/pr">
                SELECT * FROM pr4.user
                
            </sql:query>
             <c:forEach var="id" items="${users.columnNames}">
                    <tr>
                         <td><c:out value="${id}"   /> </td>
                    </tr>
            </c:forEach>  
    </body>
</html>
