<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ADMIN</title>
<!-- BOOTSTRAP STYLES-->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="css/font-awesome.css" rel="stylesheet" />
<!-- MORRIS CHART STYLES-->
<link href="js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="css/custom.css" rel="stylesheet" />
<link rel="stylesheet" href="css/header.css">
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<script src="js/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#date").click(function() {
			$("#show").load("admin/date");
		});
		$("#vendor").click(function() {
			$.post("admin/vendor_s", show);
	 
			function show(data) {
				$("#show").html(data);
			}
		});
		$("#bank").click(function() {
			$.post("admin/bankview.vms", show);
	 
			function show(data) {
				$("#show").html(data);
			}
		});
		
		 
	});
	/* function addbike() {
		alert("Hi");
	} */
</script>

</head>
<body id="img">

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
					<a class="navbar-brand title" href="loginpage.jsp">
						<center>
							<h1 id="title">Vendor Management System</h1>
						</center>
					</a>
				</div>
				<div id="right">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					
					<p id="test">	Welcome : ${pageContext.request.userPrincipal.name}</p> <a
							href="<c:url value="/logout" />"> Logout</a>
					
				</c:if>
				</div>
			 	</div>
		</div>
	</nav>
		<!-- /. NAV TOP  -->
	<div id="wrapper">
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><img src="images/find_user.png"
						class="user-image img-responsive" />
					<li>
						<button id="date" class="btn btn-info admin_btn">
							<i class="fa fa-plus fa-2x"></i>&nbsp;DATE
						</button>
					</li>
					<li>
						<button id="vendor" class="btn btn-info admin_btn">
							<i class="fa fa-eye fa-2x"></i>&nbsp;VENDOR
						</button>
					</li>
					<li>
						<button id="bank" class="btn btn-info admin_btn">
							<i class="fa fa-money fa-2x"></i>&nbsp;Bank
						</button>
					</li>
					 
				</ul>


			</div>

		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						 
						<h5>Welcome<c:if test="${pageContext.request.userPrincipal.name != null}">
					
					<p id="test"> ${pageContext.request.userPrincipal.name}</p> 
				</c:if> </h5>
					</div>

				</div>
				<!-- /. ROW  -->
				<hr />
				<div class="row">
					<div class="col-md-12" id="show"></div>
				</div>
			</div>

			<!-- /. PAGE WRAPPER  -->
		</div>
		<!-- /. WRAPPER  -->
		<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
		<!-- JQUERY SCRIPTS -->
		<script src="js/jquery-1.10.2.js"></script>
		<!-- BOOTSTRAP SCRIPTS -->
		<script src="js/bootstrap.min.js"></script>
		<!-- METISMENU SCRIPTS -->
		<script src="js/jquery.metisMenu.js"></script>
		<!-- MORRIS CHART SCRIPTS -->
		<script src="js/morris/raphael-2.1.0.min.js"></script>
		<script src="js/morris/morris.js"></script>
		<!-- CUSTOM SCRIPTS -->
		<script src="js/custom.js"></script>

	</div>
</body>
</html>