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
#body{


 
}
#right{
height: 100%;
width: 40%;
float: right;


}
#lift{
height: 100%;
width: 60%;
float: left;	
 background-image: url('images/22.jpg');
}
</style>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">

        <!-- Font Awesome CSS -->
        <link href="css/font-awesome.min.css" rel="stylesheet">
		
		<!-- Custom CSS -->
        <link href="css/animate.css" rel="stylesheet">

        <!-- Custom CSS -->
       

        <!-- Custom Fonts -->
         
        <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
<link href="fonts" type="" rel="text/css">
  <script src="js/jquery-2.1.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
      
</head>
<body id="body" onload='document.loginForm.username.focus();'>
 

	 
		<div class="row">
			<div class="col-md-" style=";"  id="lift">
<%@ include file="header_v.jsp" %>
			</div>
			
			<div class="col-md-"  id="right">
				 
<br>
<br>
<br>
<br>
<br>
<br>
<div class="row">
<div class="col-md-2"></div>
<div class="col-md-6">
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>
					 
							<h1 style="color: rgb(83, 131, 178);" class="">Login</h1>
						 <br>
						 <br>
					 <h4 style="color: lime;" >Sign in with your Spaneos Ids </h4>
					 <br>
							<form name='loginForm'
								action="<c:url value='/j_spring_security_check' />"
								 class="from form-horizontal" novalidate
					role="form" method="post">

								<table>
									<tr>
									
										<td>User:</td>
										<td><input type='text' name='username' required="required"></td>
										</tr>
										<tr>
										<td>&nbsp;</td>
										
									</tr>
									<tr>
										<td>Password:</td>
										<td><input type='password' name='password' required="required" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										
									</tr>
 									<tr>
 									
 									<td>
									&nbsp;
 									</td>
									<center>	<td colspan='7'><input class="btn btn-info btn-xs"   name="submit" type="submit"
											value="Log-In" />
											 <input class="btn btn-info btn-xs"   name="reset" type="reset"
											 > </td></center>
									</tr>
								</table>

								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />

							</form>
					 
						</div>
					</div>
				 </div>
				 </div>
	 
</body>
</html>