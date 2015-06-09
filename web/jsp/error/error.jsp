<%-- 
    Document   : error
    Created on : May 31, 2015, 4:31:04 PM
    Author     : Lysyi Andrii <your.name at your.org>
--%>

<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Error Page</title></head>
    <body>
        Request from ${pageContext.errorData.requestURI} is failed
        <br/>
        Servlet name or type: ${pageContext.errorData.servletName}
        <br/>
        Status code: ${pageContext.errorData.statusCode}
        <br/>
        Exception: ${pageContext.errorData.throwable}
    </body></html>
