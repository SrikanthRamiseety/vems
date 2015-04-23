
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
			
			$.post("../../common/searchview.vms?pagenumber=" + $(this).val()+"&page=notfirst", show);
			
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
</style>

<script type="text/javascript">
	$(function() {
	//	$(".tbl-row").hide();
	});
</script>
</head>
<body>
	<c:if test="${(banklist eq null) or (fn:length(banklist) eq 0) }">
		<h2>Sorry! No Data Found..</h2>
	</c:if>
	<c:if test="${(banklist ne null) or (fn:length(banklist) ne 0) }">
		<input type="hidden" id="hidden" name="hidden"
			value="${banklist.size() }">
			<div class="row"> 
		<c:forEach items="${banklist }" var="i">
			<div class="col-md-3">
			<br>
			<strong>vandorName:</strong><c:out value="${i.getVendorName() }"></c:out><br>
				<strong>BankName:</strong><c:out value="${i.getBankName() }"></c:out><br>
					<strong>Ac Number:</strong><c:out value="${i.getAcno() }"></c:out><br>
						<strong>Ac_Name:</strong><c:out value="${i.getAcName() }"></c:out><br>
							<strong>Iscf Code:</strong><c:out value="${i.getIcfcode() }"></c:out><br>
							
			</div>
			</c:forEach>
			</div>
			
		</c:if> 

</body>
</html>