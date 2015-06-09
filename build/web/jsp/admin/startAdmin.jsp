<%-- 
    Document   : startAdmin
    Created on : Jun 4, 2015, 10:27:15 AM
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
                        <br/>
                        <form name="getUserList" method="POST" action="controller" >
                           <input type="hidden" name="command" value="admin"/>
                            <input type="hidden" name="whatDo" value="allUsers" />                     
                           <input type="submit" name="submit" value="getUserList">
                        </form> 
                         <br/>
                        <form name="getUserList" method="POST" action="controller" >
                           <input type="hidden" name="command" value="admin"/>
                            <input type="hidden" name="whatDo" value="selectedUsers" />                     
                           <input type="submit" name="submit" value="getUserList (INCOURSE)">
                        </form> 
                        <br/>
                          <form name="getUserList" method="POST" action="controller" >
                           <input type="hidden" name="command" value="admin"/>
                            <input type="hidden" name="whatDo" value="concursUsers" /> 
                            <input type="number" name="minGrade" value="" /> 
                            <input type="submit" name="submit" value="getUserList (winers)">
                        </form> 
                        ${error}
                        <br/>
                        <table>
                            <c:forEach items="${list}" var="item">
                                <tr>
                                    <td><c:out value="${item}"   /> </td>
                                </tr>
                            </c:forEach>    
                        </table>
                        <table>
                            <c:forEach items="${ufList}" var="item">
                                <tr>
                                    <td><c:out value="${item}"   /> </td>
                                </tr>
                            </c:forEach>    
                        </table>
                        
                         <table>
                            <c:forEach items="${userList}" var="user">
                                
                                    <td><c:out value="${user.id}"   /> </td>                                
                               
                                    <td><c:out value="${user.firstName}"   /> </td>                              
                                
                                    <td><c:out value="${user.lastName}"   /> </td>
                                    
                                    <td><c:out value="${user.email}"   /> </td>                                
                               
                                    <td><c:out value="${user.city}"   /> </td>                              
                                
                                    <td><c:out value="${user.country}"   /> </td>
                                    
                                    <td><c:out value="${user.creationDate}"   /> </td>
                                    
                                <tr> </tr>
                            </c:forEach>    
                        </table>
                        <br/>
                         <form name="setUserIncourse" method="POST" action="controller" >
                           <input type="hidden" name="command" value="admin"/>
                            <input type="hidden" name="whatDo" value="setUserIncourse" />   
                            <input type="number" name="userId" value="" /> 
                            <input type="submit" name="submit" value="Set user INCOURSE (enter user ID)">
                        </form> 
                        ${setRezult}
                        <br/>
             
                        <form name="logout" method="POST" action="controller" >
                             <input type="hidden" name="command" value="logout"/>          
                             <input type="submit" name="submit" value="LOGOUT">
                        </form> 
</html>
