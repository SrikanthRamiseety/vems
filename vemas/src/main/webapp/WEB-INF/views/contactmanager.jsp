<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Contact Information</title>

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/addcontact.css">
<script type="text/javascript"
	src=js/bootstrap.min.js"></script>
	<style type="text/css">
	#disply{
	background-image: url("../images/117.jpg");
	}
	</style>
</head>
<body>
<div id ="disply">
	<%@ include file="header_l.jsp"%>
	 
	<div class="container">
		<div id="addcontactform">
			<%@ include file="addcontact.jsp"%>
		</div>
		<hr>
		<div id="showcontacts">
			<c:if test="${fn:length(contactList) ne 0 }">
				<hr>
				<%@ include file="viewcontacts.jsp"%>
			</c:if>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</div>
	<script type="text/javascript" src="../js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="../js/validator.js"></script>
	<script type="text/javascript" src="../js/loader.js"></script>
	<script type="text/javascript" src="../js/addcontact.js"></script>
	
</body>
</html>