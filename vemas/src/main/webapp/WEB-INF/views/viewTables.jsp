<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Table</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/font-awesome.min.css" rel="stylesheet">
<link href="../css/prettyPhoto.css" rel="stylesheet">
<link href="../css/animate.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<link href="../css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>

<script type="text/javascript">
	$(function() {
		var page = $("#previous").val();
		if (page == 0) {
			$("#previous").addClass("disabled");

		}
		var size1 = $("#hidden").val();
		if (size1 <= 3) {
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

					$.post("billesview?pagenumber=" + $(this).val()
							+ "&page=notfirst", show);

					function show(data) {
						$("#body").html(data);
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
<body id="body">
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>

			<div class="col-md-10" id="list">
				<c:if
					test="${(billeslist eq null) or (fn:length(billeslist) eq 0) }">
					<h2>Sorry! No Billes Uploaded..</h2>
				</c:if>
				<c:if
					test="${(billeslist ne null) or (fn:length(billeslist) ne 0) }">
					 
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


									<c:forEach begin="${(param.pagenumber-1) * 2 }"
										items="${ billeslist }" end="${(param.pagenumber * 2 )-1 }"
										var="i">
										<tr>
											<td data-date-format="yyyy-dd-mm"><c:out
													value="${i.date1}"></c:out></td>
											<td><c:out value="${i.billNo}"></c:out></td>
											<td><c:out value="${i.shopName}"></c:out></td>
											<td><c:out value="${i.amount}"></c:out></td>
											<td><c:out value="${i.name}"></c:out></td>
											<td><c:out value="${i.mobile}"></c:out></td>

											<td>
												<section id="portfolio">


													<img class="img-responsive" src="../upload/${i. imageName}"
														alt="" height="100px" width="200px">
													<div class="overlay">
														<div class="recent-work-inner">


															<a class="preview" href="../upload/${i. imageName}"
																rel="prettyPhoto"><i class="fa fa-eye"></i> View</a>
														</div>
													</div>
												</section>
											</td>
										</tr>






									</c:forEach>


								</tbody>








							</table>
						</div>
						<div id="pagination">


							<ul class="pager">

								<li><button class="btn btn-primary btn-sm page "
										value="${(param.pagenumber)-1 }" name="previous" id="previous">Previous</button></li>

								<li><button class="btn btn-primary btn-sm page"
										value="${(param.pagenumber)+1 }" name="next" id="next">next</button></li>

							</ul>

						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>





</body>




<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.prettyPhoto.js"></script>
<script src="../js/jquery.isotope.min.js"></script>
<script src="../js/main.js"></script>
<script src="../js/wow.min.js"></script>
</body>
</html>
