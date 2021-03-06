<%@page isELIgnored="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registration Result</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" media="screen and (min-width:360px) and (max-width:999px)" href="${pageContext.request.contextPath}/css/css2.css" />
		<link rel="stylesheet" type="text/css" media="screen and (min-width:1000px)" href="${pageContext.request.contextPath}/css/css.css" />
    </head>
    <body>
    	<div id="resultBody">
	    	<h1><c:out value="Registration Successfull!" /></h1>
	    	<img class="img2" src="${pageContext.request.contextPath}/img/db.png" alt="database">
       	</div>
       	<div id="resultBody">
       		<h3>${requestScope.user}</h3>
       	</div>
       	<div class="link">
			<a href="${pageContext.request.contextPath}/register/registrationForm">Go back to Registration Form</a>
		</div>
       	<div class="link">
			<a href="${pageContext.request.contextPath}/security/login">Go back to login page</a>
		</div>
    </body>
</html>
