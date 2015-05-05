<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.contact-info{

height: auto;

}


</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
 


</title>
</head>
<body>
	<div class="panel panel-primary" id="table">
		<div class="panel-heading">
			<div class="panel-title">
				<h4>Vendor Contact Information</h4>
			</div>
		</div>
		<div class="panel-body">
			<table class="table table-hover" id="contact-info">
				<tr>
					<th>Name</th>
					<th>Designation</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>Employment Status</th>
					<th>Reporting Manager</th>
					<th>Edit</th>
					<th>Delete</th>
					<th><input type="checkbox" id="deleteall" style="margin-left: -100%;"></th>
				</tr>

				<c:forEach items="${contactList }" var="contact">
					<tr>
						<td>${contact.name }</td>
						<td>${contact.designation }</td>
						<td>${contact.mobile },
						${contact.mobile1 }
						,${contact.mobile2 }</td>
						<td>${contact.email },
						${contact.email1 }
						,${contact.email2 }</td>
						<td>${contact.employmentStatus }</td>
						<td>${contact.reportingManager }</td>
						<td><input type="radio" name="edit" class="edit"
							id="${contact.email }" style="margin-left: 22%;"></td>
						<td><input type="checkbox" class="delete"
							id="${contact.email }" style="margin-left: 31%;">
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="row" id="buttons">
		<div class="col-sm-2"></div>
		<div class="col-sm-3">
			<button type="button" class="btn btn-primary saveExit" id="saveexit">Save
				& Exit</button>
		</div>
		<div class="col-sm-3">
			<button class="btn btn-primary" type="button" id="deletebtn">Delete</button>
		</div>
		<div class="col-sm-3">
			<button type="button" class="btn btn-primary" id="cancel">Cancel</button>
		</div>
	</div>
	<hr>
</body>
</html>