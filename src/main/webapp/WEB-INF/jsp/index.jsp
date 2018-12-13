<%-- 
    Document   : teste
    Created on : 12/12/2018, 17:02:25
    Author     : romulo.douro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <link href="/resources/css/estilo.css" rel="stylesheet" type="text/css"/>
 </head>
 <body>
  <c:url value="/resources/text.txt" var="url"/>
  <spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
  Spring URL: ${springUrl} at ${time}
  <br>
  JSTL URL: ${url}
  <br>
  Message: ${message}
 </body>
</html>
