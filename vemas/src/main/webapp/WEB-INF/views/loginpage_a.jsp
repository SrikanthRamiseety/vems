<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Font Awesome CSS -->
        <link href="css/font-awesome.min.css" rel="stylesheet">
		
		<!-- Custom CSS -->
        <link href="css/animate.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/style.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
<link href="fonts" type="" rel="text/css">
  <script src="js/jquery-2.1.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
      
</head>
<body onload='document.loginForm.username.focus();'>
<%@ include file="header_v.jsp" %>
<br>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				 

					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>
					<div class="panel panel-info">
						<div class="panel-heading">
							<h4 class="">Login</h4>
						</div>
						<div class="panel-body" align="center">
							<form name='loginForm'
								action="admin/landingpage_vendor"
								 class="from form-horizontal" novalidate
					role="form" method="post">

								<table>
									<tr>
									
										<td>User:</td>
										<td><input type='text' name='username'></td>
									</tr>
									<tr>
										<td>Password:</td>
										<td><input type='password' name='password' /></td>
									</tr>
									<br>
									<tr>
										<td colspan='2'><input name="submit" type="submit"
											value="submit" /></td>
									</tr>
								</table>

								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />

							</form>
							 
						</div>
					</div>
				</div>
			</div>
		</div>
	 
</body>
</html>