<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

					$.post("admin/date_s?pagenumber=" + $(this).val()
							+ "&page=notfirst", show);

					function show(data) {
						$("#show").html(data);
					}
					$(".pa").css("color", "#303030");
				});
	});
</script>
<style type="text/css">
.T-I-JN {
	-webkit-border-radius: 0;
	border-radius: 0;
	border: 1px solid transparent;
	font-size: 13px;
	font-weight: normal;
	height: 21px;
	line-height: 21px;
	margin-right: 1px;
	min-width: 0;
	padding: 0;
}
</style>
</head>
<body>
	<div class="container">

		<div class="row">

			<c:if test="${(fn:length(bill) eq 0) }">
				<h2>Sorry! No Bills Uploaded..</h2>
			</c:if>
			<div class="col-md-9">
				<c:if test="${(fn:length(bill) ne 0) }">
					<input type="hidden" id="hidden" name="hidden"
						value="${bill.size() }">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h4>Bills</h4>

						</div>
						<div class="panel-body" id="vendor-table">
							<table class="table table-bordered">
								<thead>
									<tr>

										<th>BillNo</th>
										<th>VendorName</th>
										<th>amount</th>
										<th>Name</th>
										<th>Mobile</th>
										<th>Images</th>
										<th>Date</th>

									</tr>
								</thead>
								<tbody>

									<c:forEach begin="${(param.pagenumber-1) * 4 }"
										items="${bill }" end="${(param.pagenumber * 4 )-1 }" var="i">
										<tr>

											<td><c:out value="${i.getBillNo()}"></c:out></td>
											<td><c:out value="${i.getShopName()}"></c:out></td>
											<td><c:out value="${i.getAmount()}"></c:out></td>
											<td><c:out value="${i.getName()}"></c:out></td>
											<td><c:out value="${i.getMobile()}"></c:out></td>

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
											<td><c:out
													value="${i.date1}"></c:out></td>



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
<script src="../js/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.prettyPhoto.js"></script>
<script src="../js/jquery.isotope.min.js"></script>
<script src="../js/main.js"></script>
<script src="../js/wow.min.js"></script>
</body>
</html>