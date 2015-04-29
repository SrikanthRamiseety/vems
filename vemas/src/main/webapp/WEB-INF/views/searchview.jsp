			
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
<script type="text/javascript">
	$(function() {
			var page=$("#previous").val();
		if(page == 0){
			$("#previous").addClass("disabled");
			 
			
		}
		 var size1=$("#hidden").val();
		 if(size1<=4){
			 $("#previous").hide();
			 $("#next").hide();
			 
		 }
		 var size=$("#hidden").val();
		 var number=$("#next").val();
		 
		 if(number==Math.round(size/3)+1){
			 $("#next"). addClass("disabled");
		 }
		$(".page").click(function() {
			var pagenumber=$(this).val();
			
			$.post("searchview.vms?pagenumber=" + $(this).val()+"&page=notfirst", show);
			
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
h2{
color: red;
}
</style>

<script type="text/javascript">
	$(function() {
	//	$(".tbl-row").hide();
	});
</script>
</head>
<body>
	<c:if test="${(vender eq null) or (fn:length(vender) eq 0) }">
	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
		<center><h2>Sorry! No Data Found..</h2></center>
	</c:if>
	<c:if test="${(vender ne null) or (fn:length(vender) ne 0) }">
		<input type="hidden" id="hidden" name="hidden"
			value="${vender.size() }">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Vendor</h4>

			</div>
			<div class="panel-body" id="vendor-table">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>S.No</th>
							<th>Type</th>
							<th>Category</th>
							<th>Company Name</th>
							<th>Address</th>
							<th>Contact #</th>
							<th>Web Site</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach begin="${(param.pagenumber-1) *  4 }"
							items="${vender }" end="${(param.pagenumber * 4 )-1 }" var="i">
							<tr class="clickable" data-toggle="collapse"
								id="view${i.getId()}" data-target=".view${i.getId()}">
								<td><c:out value="${i.getId()}"></c:out></td>
								<td><c:out value="${i.getVendorType()}"></c:out></td>
								<td><c:out value="${i.getVendorCategory() }"></c:out></td>
								<td><c:out value="${i.getVendorName() }"></c:out></td>
								<td><c:out value="${i.getVendorAddress()}"></c:out></td>
								<td><c:out value="${i.getVendorMobileNumber()}"></c:out></td>
								<td><c:out value="${i.getVendorWebsite()}"></c:out></td>


							</tr>

							<thead>
								<tr class="collapse view${i.getId()}" id="child-head">

									<th class="success">S.No</th>
									<th class="success">Name</th>
									<th class="success">Designation</th>
									<th class="success">Contact #</th>
									<th class="success">Email</th>
									<th class="success">Employee Status</th>
									<th class="success">Reporting Manager</th>

								</tr>

							</thead>

							<tbody>
								<c:forEach items="${ i.vendorContacts}" var="contact">
									<tr class="collapse view${i.getId()}" id="child-table">
										<td class="info"><c:out value="${contact.getId() }"></c:out></td>
										<td class="info"><c:out value="${contact.getName() }"></c:out></td>
										<td class="info"><c:out
												value="${contact.getDesignation() }"></c:out></td>
										<td class="info"><c:out value="${contact.getMobile() }"></c:out></td>
										<td class="info"><c:out value="${contact.getEmail() }"></c:out></td>
										<td class="info"><c:out
												value="${contact.getEmploymentStatus() }"></c:out></td>
										<td class="info"><c:out
												value="${contact.getReportingManager() }"></c:out></td>

									</tr>


								</c:forEach>


							</tbody>


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

</body>
</html>