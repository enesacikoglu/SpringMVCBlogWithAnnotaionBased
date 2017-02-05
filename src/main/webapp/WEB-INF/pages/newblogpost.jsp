<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Blog Post</title>
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

		<c:if test="${not empty message}">
   ${message} <br />
   
   <a href="${pageContext.request.contextPath}/blogposts">Blog Posts</a>
   
		</c:if>

		<form action="${pageContext.request.contextPath}/saveBlogPost"
			method="post">

			<table style="width: 650px" class="table table-striped">
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" required autofocus /></td>
				</tr>
				<tr>
					<td>Content</td>
					<td><textarea style="width: 400px" name="content"
							maxlength="4000" rows="10" required></textarea></td>
				</tr>
				<tr>
					<td>Draft</td>
					<td><input type="checkbox" name="draft" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="save" /></td>
				</tr>


			</table>



		</form>

		<h1>New Blog Post</h1>


		<a href="${pageContext.request.contextPath}">Back</a>


	</div>
	<!-- /.container -->

</body>
</html>