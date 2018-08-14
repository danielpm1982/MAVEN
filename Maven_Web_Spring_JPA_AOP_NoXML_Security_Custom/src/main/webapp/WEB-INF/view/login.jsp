<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Login Custom Page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
        	body{
				font-family: sans-serif;
				text-align: center;
				background-color: black;
				color: blanchedalmond;
			}
			form.login {
				font-size: 2em;
				border: thin white dashed;
				width: 50%;
				margin: auto;
				margin-top: 4em;
				padding: 1em;
			}
			input[type="text"], input[type="password"]{
				font-family: monospace;
				font-size: 1.1em;
				padding: 0.4em;
				width: 15em;
				margin-top: 1em;
				margin-bottom: 1em;
			}
			input[type="submit"]{
				font-family: monospace;
				font-size: 1.1em;
				font-weight: bolder;
				padding: 0.4em;
				width: 7em;
				margin-top: 2em;
				margin-bottom: 1em;
				margin-left: 1em;
				margin-right: 1em;
			}
			h3.errors{
				font-family: monospace;
				color: red;
				background-color: yellow;
				margin-bottom: 1.5em;
			}
			h3.logout{
				font-family: monospace;
				color: black;
				background-color: lightGreen;
				margin-bottom: 1.5em;
			}
        </style>
	</head>
	<body>
		<form:form class="login" action="${pageContext.request.contextPath}/customLoginPageResult" method="post">
       		<c:if test="${param.error ne null}">
       			<h3 class=errors>Authentication failed! Invalid username/password!</h3>
       		</c:if>
       		<c:if test="${param.logout ne null}">
       			<h3 class=logout>You have logged out sucessfully!</h3>
       		</c:if>
       		<label for="userName">User Name:</label>
       		<br>
       		<input type="text" name="username" id="userName" title="type your userName" />
       		<br>
       		<label for="userPassword">User Password:</label>
       		<br>
       		<input type="password" name="password" id="userPassword" title="type your userPassword" />
       		<br>
       		<input type="submit" value="Login">
<%--        		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>
<%-- 			<security:csrfInput /> --%>
       	</form:form>
	</body>
</html>

<!-- 
Resources are not authorized unless user is authenticated, so the css of the login page must be 
set in the style and not link type fashion.  
-->

<!-- 
This main login page will be redirected to in error and logout cases, with the 'error' or 'logout'
value appended as a request url parameter. Both can be treated, if not null, for showing the 
corresponding messages to the user. 
-->

<!--
For avoiding Cross-site request forgery - CSRF atacks, you would have to use a hidden input with 
the name="${_csrf.parameterName}" and the value="${_csrf.token}" (or <security:csrfInput /> tag) 
if using a normal html request form. Spring would generate a random token and put it in place of 
the "_csrf.token" value above, at the generated html page. When the form data is submitted, Spring 
validates or not that token along with the cookie for that user session. 
Spring forms, on the other hand, already implement that hidden input and token automatically, besides 
cookies. So, Spring forms are preferred, rather than traditional forms. 
This hidden input with a token would have to be manually implemented for each and every request form, 
throughout the entire application. If no manual implementation is used, or an invalid token value is sent, 
Spring answers with a 403 Forbidden message, and the user wouldn't be able to access the application. 
One way or another, the token value generation and validation are done internally by Spring.
See the form.jsp comments for more about security taglibs.
-->
