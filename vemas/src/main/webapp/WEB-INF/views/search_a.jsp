<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Search</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript"
	src="http://docs/docs/jquery_json/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="http://docs/docs/References/08_Bootstrap/tutorial%20and%20libs/dist/js/bootstrap.min.js"></script>	
<script type="text/javascript">
	$(function() {

		$("#vender_s").click(function() {
		var value=	$("#search").val();
			 
			$.post("searchview_a.vms?search="+value,
					show);
			function show(data) {
				$("#show_v").html("");
				$("#show_v").html(data);
				
			}
		});

	});
	 
</script>
<style type="text/css">
#vender{
	border-radius: 38px;
}
#div {
	height: 700px;	 
}
#bd>li+li:before {
	content: "> >";
	color: gray;
}
/* #show {
	max-height: 300px;
	overflow: auto;
} */
 #div {
 background-image: url("images/18.jpg");
 }
</style>
</head>
<body>
 


	 
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-7">
			 <form> 
					<div class="form-group">
					<label class=" control-label">
					<button  id="vender_s"type="button" class="btn btn-primary glyphicon glyphicon-search">Search</button>
					</label>
					<div class="col-sm-8">
						<input type="text" id="search" name="search"  
							class="form-control" placeholder="Enter the Vendor Name">
					</div>
				</div>
				</form>
			</div>
			<div class="col-md-2"></div>

		<hr>
		 
		<div id="show_v" class="continar">
		
		
		
		</div>


		</div>

	</div>
	 
</body>
</html>