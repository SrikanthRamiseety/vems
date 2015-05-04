
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>table</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">


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

					$.post("search.vms?pagenumber=" + $(this).val()
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

.btn {
	border-radius: 74px;
}

.active {
	color: aqua;
}

#body {
	background-image: url("../images/1920.jpg");
}
</style>

<script type="text/javascript">
	$(function() {
		//	$(".tbl-row").hide();
	});
</script>
</head>
<body id="body">
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>

			<div class="col-md-10">
				<c:if
					test="${(billeslist eq null) or (fn:length(billeslist) eq 0) }">
					<h2>Sorry! No Billes Uploaded..</h2>
				</c:if>
				<c:if
					test="${(billeslist ne null) or (fn:length(billeslist) ne 0) }">
					<input type="hidden" id="hidden" name="hidden"
						value="${vender.size() }">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h4>Billes</h4>

						</div>
						<div class="panel-body" id="vendor-table">
							<table class="table table-bordered">
								<thead>
									<tr>





										<th>Date</th>
										<th>BillNo</th>
										<th>VendorName</th>
										<th>amount</th>
										<th>Name</th>
										<th>Mobile</th>
										<th>Images</th>

									</tr>
								</thead>
								<tbody>

									<c:forEach items="${billeslist }" var="i">
										<tr>
											<td data-date-format="yyyy-dd-mm"><c:out
													value="${i.date1}"></c:out></td>
											<td><c:out value="${i.billNo}"></c:out></td>
											<td><c:out value="${i.shopName}"></c:out></td>
											<td><c:out value="${i.amount}"></c:out></td>
											<td><c:out value="${i.name}"></c:out></td>
											<td><c:out value="${i.mobile}"></c:out></td>

											<td id="img"><img alt="loading..."
												src="../upload/${i. imageName}" height="100px" width="200px">
												 

													 </td>
										</tr>






									</c:forEach>


								</tbody>








							</table>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>




	<%@ include file="footer.jsp"%>
</body>
<script src="../js/jquery.prettyPhoto.js"></script>
<link href="../css/prettyPhoto.css" rel="stylesheet">
<link href="../css/maind.css" rel="stylesheet">
</html>