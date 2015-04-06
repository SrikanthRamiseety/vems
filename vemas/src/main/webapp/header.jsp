<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Header</title>

<link rel="stylesheet" href="css/header.css">

<!-- /* col-sm-2 col-md-2 col-xs-2 */ -->

</head>
<body>
	<nav class="navbar navbar-inverse navbar-static-top header"
		role="navigation">
		<div class="container" id="container">
			<div class="row">
				<div class="navbar-header col-sm-3 col-md-3 col-xs-3 col-lg-3">
					<a class="navbar-brand" href="#"> <img alt="logo"
						src="images/About_Spaneos.png" id="logo">
					</a>
				</div>
				<div class="navbar-header col-sm-6 col-md-6 col-xs-8 col-lg-6">
					<a class="navbar-brand title" href="#">
						<center><h1 id="title">Vendor Management System</h1></center>
					</a>
				</div>
				<c:if test="${loggedIn eq true }">
					<div class="col-sm-3 col-md-3 col-xs-3 col-lg-3">
						<p class="navbar-text pull-right user" id="user_welcome_msg">
							Welcome <c:out value="${user.firstname }"></c:out> <br> <a href="logout.vms"
								class="pull-right">Logout</a>
						</p>
					</div>
				</c:if>
				<c:if test="${loggedIn ne true }">
					<div class="col-sm-3 col-md-3 col-xs-3 col-lg-3">
						<p class="navbar-text pull-right user" id="welcome_msg">Welcome</p>
					</div>
				</c:if>
			</div>
		</div>
	</nav>
</body>
</html>