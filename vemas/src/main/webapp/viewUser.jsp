
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

<!-- <script type="text/javascript">
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
			
			$.post("search.vms?pagenumber=" + $(this).val()+"&page=notfirst", show);
			
			function show(data) {
				$("#show").html(data);
			}
			$(".pa").css("color", "#303030");
		});
	});
</script>
 --><style type="text/css">
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
</style>

<script type="text/javascript">
	$(function() {
	//	$(".tbl-row").hide();
	});
</script>
</head>
<body>
	<%@include file="../header_l.jsp"%>

	<c:if test="${(userslist eq null) or (fn:length(userslist) eq 0) }">
		<h2>Sorry! No Billes Uploaded..</h2>
	</c:if>
	<c:if test="${(userslist ne null) or (fn:length(userslist) ne 0) }">
		<input type="hidden" id="hidden" name="hidden"
			value="${userslist.size() }">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Contacts</h4>

			</div>
			<div class="panel-body" id="vendor-table">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							
							
							<th>Email</th>
							<th>MobileNumber</th>
							   
							 
						</tr>
					</thead>
					<tbody>

						<c:forEach 
							items="${userslist }" var="i">
							<tr>
								
								<td><c:out value="${i.getFirstname()}"></c:out></td>
								<td><c:out value="${i.getEmail()}"></c:out></td>
								<td><c:out value="${i.getMobile() }"></c:out></td>
								 

							</tr>

							 
							 									
									


								</c:forEach>


							</tbody>


						 

					



				</table>
			</div>
				</div>
	</c:if>





<%@ include file="../../footer.jsp" %>
</body>
</html>