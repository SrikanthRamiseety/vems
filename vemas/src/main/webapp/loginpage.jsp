<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript"
	src="http://docs/docs/References/08_Bootstrap/bootstrap-3.3.1-dist/dist/js/bootstrap.min.js">
	
</script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/loginpage.css">
</head>

<body>
	<%@ include file="header.jsp"%>
	<div id="display">
	<br>
	<br>
	
		<div class="panel panel-primary" id="login">
			<div class="panel-heading">
				<h4 class="">Login</h4>
			</div>
			<div class="panel-body" align="center">
				<br>
				<form action="login.vms" class="from form-horizontal" novalidate
					role="form" method="post">

					<div class="item form-group">
						<label class="col-sm-3 control-label">Email <em>*</em></label>
						<div class="col-sm-6">
							<input type="email" id="email" name="email" class="form-control"
								placeholder="Enter Email" required value="${param.email }">
						</div>
						<div class='tooltip help'>
							<span>?</span>
							<div class='content'>
								<b></b>
								<p>
									Enter your registered email ID.<br> Example:
									vms@spaneos.com
								</p>
							</div>
						</div>
					</div>
					<div class="item form-group">
						<label class="col-sm-3 control-label"> Password<%-- <div class="row">
					<div class="col-sm-offset-2 col-sm-6">
						<c:if test="${incorrectCredentials eq true }">
							<!-- <div class="col-sm-offset-2" id="invalid_div">
								<span id="invalid"><b> Invalid Email ID or Password! </b> </span>
							</div> -->


							<div id="invalid" class="alert alert-danger">Warning ! Dont submit this.</div>
						</c:if>
				</div>
			</div> --%><em>*</em>
						</label>
						<div class="col-sm-6">
							<input type="password" class="form-control pass" id="password"
								name="password" placeholder="Enter Password" required><br>
						</div>
						<div class='tooltip help'>
							<span>?</span>
							<div class='content'>
								<b></b>
								<p>Enter the password registered with your email ID</p>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-0 col-sm-0">
							<button id="login_id" name="Login" type="submit"
								class="btn btn-primary ">Login</button>
							<button id="cancel" name="cancel" type="reset"
								class="btn btn-primary col-sm-offset-1">Cancel</button>
						</div>
					</div>
					<div class="col-sm-4">
						<button type="button" id="forgotpwd" class="btn btn-link">Forgot
							Password</button>
					</div>
					 
				</form>
				<br>
				<div class="row">
					<div class="col-sm-6"></div>
					<div class="col-sm-6">

						<span id="mandatory" class="pull-right">All fields marked
							in<em> * </em> are mandatory
						</span>

					</div>
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-offset-2 col-sm-7" id="invalid">
				<c:if test="${incorrectCredentials eq true }">
					<div class="alert alert-danger" align="center">
						 Invalid Email ID or Password! 
					</div>
				</c:if>
			</div>
		</div>

	</div>
	<%@ include file="footer.jsp"%>

	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/validator.js"></script>
	<script type="text/javascript" src="js/loader.js"></script>
	<script type="text/javascript" src="js/loginpage.js"></script>

	<script type="text/javascript">
		$(function() {
			$(".pass").keyup(function() {
				$("#invalid").hide();
			});
			
			$("#email").keyup(function() {
				$("#invalid").hide();
			});
		});
	</script>
</body>
</html>