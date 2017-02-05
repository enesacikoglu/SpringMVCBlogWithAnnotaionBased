<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog Posts</title>
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

		<c:if test="${empty blogposts}">
   No BlogPosts found<br />
		</c:if>

		<br /> <a href="${pageContext.request.contextPath}/newblogpost.html">New
			Blog Post</a>


<br /> <a href="${pageContext.request.contextPath}/draftblogposts">Find Draft
			Blog Post</a>


          <form action="${pageContext.request.contextPath}/searchByTitle"
			method="post">
			
			<table style="width: 650px" class="table table-striped">
				<tr>
					<td>Blog Title :</td>
					<td><input type="text" name="title" required autofocus /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Search" /></td>
				</tr>
			</table>
			
			
			</form>


		<c:if test="${ not empty blogposts}">
			<table style="width: 650px" class="table table-striped">
				<c:forEach var="blogpost" items="${blogposts}">
					<tr>
						<td>Blog Post Id</td>
						<td><c:out value="${blogpost.id}" /></td>
					</tr>
					<tr>
						<td>Title</td>
						<td><c:out value="${blogpost.title}" /></td>
					</tr>
					<tr>
						<td>Content</td>
						<td><div style="white-space: pre">
								<c:out value="${blogpost.content}" />
							</div></td>
					</tr>

					<tr>
						<td>Draft</td>
						<td><c:out value="${blogpost.draft}" /></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td></td>
						<td colspan="2"></td>
					</tr>

				</c:forEach>

			</table>

		</c:if>



		<h1>Blog Posts</h1>

		<a href="${pageContext.request.contextPath}">Back</a>

	</div>
	<!-- /.container -->

</body>
</html>