
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
			
			$.post("month_v?pagenumber=" + $(this).val()+"&page=notfirst", show);
			
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
#body{
background-image: url("images/100.jpg");

}
</style>

<script type="text/javascript">
	$(function() {
	//	$(".tbl-row").hide();
	});
</script>
</head>
<body id="body">
	 
<div class="container">
<div class="row">
 

<div class="col-md-10">
	<c:if test="${(fn:length(bl) eq 0) }">
		<h2>Sorry! No Bills Uploaded..</h2>
	</c:if>
	<c:if test="${(fn:length(bl) ne 0) }">
		<input type="hidden" id="hidden" name="hidden"
			value="${bl.size() }">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Bills</h4>

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

									<c:forEach items="${bl }" var="i">
										<tr>
 <td><c:out value="${i.date1}"></c:out></td>
											<td><c:out value="${i.getBillNo()}"></c:out></td>
											<td><c:out value="${i.getShopName()}"></c:out></td>
											<td><c:out value="${i.getAmount()}"></c:out></td>
											<td><c:out value="${i.getName()}"></c:out></td>
											<td><c:out value="${i.getMobile()}"></c:out></td>
											 	 
											<td><img alt="loading..." src="../upload/${i. imageName}"
							height="100px" width="100px"></td> 



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




 
</body>
</html>