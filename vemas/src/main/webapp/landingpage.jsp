<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Landing page</title>
<script type="text/javascript"
	src="http://docs/docs/jquery_json/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="http://docs/docs/References/08_Bootstrap/bootstrap-3.3.1-dist/dist/js/bootstrap.min.js">
	
</script>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/landingpage.css">

<style type="text/css">
#search {
	margin-left: 19%;
	width: 66%;
}
</style>
</head>
<body>

	<%@ include file="header.jsp"%>
	<ol class="breadcrumb">
		<li class="active">Home</li>
	</ol>
	<div id="body">
		<div id="landing_page">
			<div class="panel panel-primary">
				<br> <br> <a href="addvendor.jsp"
					class=" btn btn-primary btn-lg btn-lp" id="add">Add Vendor</a> <br>
				<br> <a href="search.jsp" class="btn btn-primary btn-lg btn-lp"
					id="search">Search Vendor</a> <br> <br> <br> <br>
			</div>
		</div>
	</div>
	<br>
	<br>
	<%@ include file="footer.jsp"%>
</body>
</html>