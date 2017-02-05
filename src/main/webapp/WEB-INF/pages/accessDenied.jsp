<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>	
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access is Denied</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/starter-template.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/js/jquery-3.1.0.min.js"
	type="text/javascript">
<link
	href="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
	type="text/javascript">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">

<h1>Access is denied.</h1>
	</div>
	<!-- /.container -->

<footer class="navbar navbar-fixed-bottom">
		<div class="container">
			<p class="muted credit">
				<b>Enes Acikoglu Made on 2016</b>
			</p>
			<a href="<%=request.getContextPath()%>?language=en">EN</a> 
			<a href="<%=request.getContextPath()%>?language=de">DE</a>
			<a href="<%=request.getContextPath()%>?language=tr">TR</a>
		<spring:message code="language"/>
		<font color="green" ><b><spring:message code="welcome.text" /></b></font>
		</div>
	</footer>

</body>
</html>