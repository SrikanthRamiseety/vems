
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>table</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">

<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Font Awesome CSS -->
<link href="../css/font-awesome.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/animate.css" rel="stylesheet">

<!-- Custom CSS -->


<!-- Custom Fonts -->
<link href='http://fonts.googleapis.com/css?family=Lobster'
	rel='stylesheet' type='text/css'>
<link href="../fonts" type="" rel="text/css">

<!-- Template js -->
<script src="../js/jquery-2.1.1.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../js/jquery.appear.js"></script>
<script src=" ../js/contact_me.js"></script>
<script src="../ js/jqBootstrapValidation.js"></script>
<script src="../ js/modernizr.custom.js"></script>
<script src=" ../js/script.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript">
	$(function() {
		var page = $("#previous").val();
		if (page == 0) {
			$("#previous").addClass("disabled");

		}
		var size1 = $("#hidden").val();
		if (size1 <= 4) {
			$("#previous").hide();
			$("#next").hide();

		}
		var size = $("#hidden").val();
		var number = $("#next").val();

		if (number == Math.round(size / 3) + 1) {
			$("#next").addClass("disabled");
		}
		$(".page").click(
				function() {
					var pagenumber = $(this).val();

					$.post("searchview.vms?pagenumber=" + $(this).val()
							+ "&page=notfirst", show);

					function show(data) {
						$("#show").html(data);
					}
					$(".pa").css("color", "#303030");
				});
	});
</script>
<style type="text/css">
#pagination {
	color: #337AB7;
	background-color: transparent;
	box-sizing: border-box;
	font-family: "Open Sans", sans-serif;
	font-size: 14px;
	text-align: center;
}

body {
	color: white;
}

.clickable {
	border: 1px;
}

#view {
	overflow: auto;
}

th {
	background-color: silver;
}

.no-line, #no-line {
	border-bottom-style: hidden;
	border-bottom-width: 0em;
	background-color: white;
}

table.collapse.in {
	display: table-row;
}

#vendor-table {
	max-height: 300px;
	overflow: auto;
}

.btn {
	border-radius: 74px;
}

.active {
	color: aqua;
}

strong {
	color: lime;
}

hr {
	border-bottom-color: black;
}

#body {
	background-image: url("../images/898.jpg");
}
</style>

<script type="text/javascript">
	$(function() {
		//	$(".tbl-row").hide();
	});
</script>
</head>
<body id="body">
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-11">
				<h3 style="color: rgb(5, 234, 130);">VendorName:${vendor}</h3>
				<c:if test="${(fn:length(vlist) eq 0) }">
					<h2>Sorry! No Data Found..</h2>
				</c:if>
				<c:if test="${(fn:length(vlist) ne 0) }">
					<input type="hidden" id="hidden" name="hidden"
						value="${vlist.size() }">
					<h1 style="color: red">Employee details</h1>
					<br>



					<hr>
					<div class="row">
						<c:forEach items="${vlist }" var="i">
							<c:forEach items="${i.vendorContacts }" var="contact">

								<div class="col-md-4">
									<strong>Name</strong>:${contact.name}<br> <strong>Designation</strong>:${contact.designation}<br>
									<strong>Mobile</strong>:${contact.mobile},${contact.mobile1},<br>${contact.mobile2}<br>
									<strong>Email</strong>:${contact.email}<br>${contact.email1}<br>${contact.email2}<br>

									<hr>
								</div>





							</c:forEach>
						</c:forEach>
					</div>
					<br>


				</c:if>
				<br>
				<h1 style="color: red;">Bank details</h1>
				<hr>
				<c:if test="${(fn:length(blist) eq 0) }">
					<h2>sorry! no Bank Details Are Uploaded...!</h2>

				</c:if>
				<c:if test="${(fn:length(blist) ne 0) }">
					<div class="row">
						<c:forEach items="${blist }" var="i">
							<div class="col-md-4">
								<strong>BankName</strong>:${i.bankName }<br> <strong>Account
									Name</strong>:${i.getAcno()}<br> <strong>Account Name</strong>:${i.getAcName() }<br>
								<strong>Ifc Code</strong>:${i.icfcode }<br>
							</div>
						</c:forEach>
					</div>
				</c:if>
				<br>
			</div>
		</div>
	</div>
</body>
</html>