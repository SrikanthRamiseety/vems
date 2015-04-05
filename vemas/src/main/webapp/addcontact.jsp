<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Add Contact</title>


</head>
<body>
	<c:if test="${editContact ne null }">
		<form action="updatecontact.vms" class="from form-horizontal"
			novalidate role="form" method="post">
			<div class="panel panel-primary" id="body">
				<div class="panel-heading">
					<div class="panel-title">
						<h4>Update Contact Information</h4>
					</div>
				</div>
	</c:if>
	<c:if test="${editContact eq null }">
		<form action="addcontact.vms" class="form form-horizontal" novalidate
			role="form" method="post">
			<div class="panel panel-primary" id="body">
				<div class="panel-heading">
					<div class="panel-title">
						<h4>Add Contact Information</h4>
					</div>
				</div>
	</c:if>
	<div class="panel-body">
		<div class="row">
			<div class="col-sm-6 pull-left" id="vendor_info">
				<div class="form-group">
					<label class="col-sm-5 control-label">Vendor Type</label>
					<div class="col-sm-7">
						<input type="text" id="vendorType" placeholder="Vendor Type"
							name="vendorType" class="form-control"
							value="${vendor.vendorType }" readonly>
					</div>

				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Vendor Category</label>
					<div class="col-sm-7">
						<input type="text" id="vendorCategory" name="vendorCategory"
							class="form-control" placeholder="Vendor Category"
							value="${vendor.vendorCategory }" readonly>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-5 control-label">Vendor Name</label>
					<div class="col-sm-7">
						<input type="text" id="vendorName" name="vendorName"
							class="form-control" placeholder="Vendor Name"
							value="${vendor.vendorName }" readonly>
					</div>
				</div>
				<c:if test="${fn:length(contactList) eq 0  }">
					<div class="form-group" id="save_vendor">
						<div class="col-sm-offset-3">
							<button class="btn btn-primary" id="savevendor" type="button">Save
								Vendor</button>
						</div>
					</div>
				</c:if>
			</div>

			<div class="col-sm-6 pull-right" id="contact_form">


				<div class="item form-group">
					<!-- <div class="col-sm-1"></div> -->
					<label class="col-sm-4 control-label contact-label">Contact
						Name <em>*</em>
					</label>
					<div class="com-sm-1"></div>
					<div class="col-sm-5">
						<input type="text" id="contactName" pattern="alpha"
							name="contactName" class="form-control contact_info"
							placeholder="Enter Contact Name" value="${editContact.name }"
							required>
					</div>
					<div class='tooltip help'>
						<span>?</span>
						<div class='content'>
							<b></b>
							<p>
								<i>Contact Name</i> should have only alphabets
							</p>
						</div>
					</div>
				</div>
				<div class="item form-group">
					<label class="col-sm-4 control-label contact-label">Designation
						<em>*</em>
					</label>
					<div class="col-sm-5">
						<input type="text" id="designation" name="designation"
							class="form-control contact_info" pattern="alpha"
							placeholder="Enter Designation" data-validate-words="1"
							value="${editContact.designation }" required>
					</div>
					<div class='tooltip help'>
						<span>?</span>
						<div class='content'>
							<b></b>
							<p>
								<i>Designation</i> should have only alphabets
							</p>
						</div>
					</div>
				</div>
				<div class="item form-group">
					<label class="col-sm-4 control-label contact-label">Mobile
						<em>*</em>
					</label>
					<div class="col-sm-5">
						<input type="tel" id="mobile" name="mobile" required
							class="form-control contact_info" maxlength="10"
							placeholder="Enter Mobile Number" data-validate-length-range="10"
							value="${editContact.mobile }">
					</div>

					<div class='tooltip help'>
						<span>?</span>
						<div class='content'>
							<b></b>
							<p>
								<i>Mobile</i> should have only numbers with 10 digits
							</p>
						</div>
					</div>
				</div>
				<div class="item form-group">
					<label class="col-sm-4 control-label contact-label">Email <em>*</em></label>
					<c:if test="${editContact eq null}">
						<div class="col-sm-5">
							<input type="email" id="email" name="email"
								class="form-control contact_info" placeholder="Enter Email"
								required value="${editContact.email }">
						</div>
					</c:if>
					<c:if test="${editContact ne null}">
						<div class="col-sm-5">
							<input type="email" id="email" name="email"
								class="form-control contact_info" placeholder="Enter Email"
								required value="${editContact.email }" readonly>
						</div>
					</c:if>
					<div class='tooltip help'>
						<span>?</span>
						<div class='content'>
							<b></b>
							<p>
								Example: <br> vms@spaneos.com
							</p>
						</div>
					</div>
				</div>
				<div class="item form-group">
					<label class="col-sm-4 control-label">Employment Status <em>
					</em></label>
					<div class="col-sm-5 contact-label">
						<select id="status" name="employmentStatus" class="form-control"
							required>
							<option value="Active" selected="selected">Active</option>
							<option value="Inactive">Inactive</option>
						</select>
					</div>
					<div class='tooltip help'>
						<span>?</span>
						<div class='content'>
							<b></b>
							<p>Active(Default) / Inactive</p>
						</div>
					</div>
				</div>
				<div class="item form-group">
					<label class="col-sm-4 control-label">Reporting Manager <em>
					</em></label>
					<div class="col-sm-5 contact-label">
						<input type="text" pattern="alpha" id="manager" name="manager"
							class="form-control contact_info"
							placeholder="Enter manager name"
							value="${editContact.reportingManager }"
							data-validate-minmax="5,200">
					</div>
					<div class='tooltip help'>
						<span>?</span>
						<div class='content'>
							<b></b>
							<p>
								Please enter <i>Reporting Manager</i> name (Optional)
							</p>
						</div>
					</div>
				</div>
				<p id="mandatory">
					All fields marked in<span><em> * </em></span> are mandatory
				</p>
			</div>
		</div>

	</div>
	</div>
	<hr>
	<div class="row" id="buttons">
		<div class="col-sm-2"></div>
		<div class="col-sm-3">
			<c:if test="${editContact ne null}">
				<button type="submit" class="btn btn-primary" id="add-update">Update
					Contact</button>
			</c:if>
			<c:if test="${editContact eq null}">
				<button type="submit" class="btn btn-primary" id="add-update">Add
					Contact</button>
			</c:if>
		</div>
		<div class="col-sm-3">
			<c:if test="${editContact eq null}">
				<button type="button" class="btn btn-primary" id="reset">Clear</button>
			</c:if>
			<c:if test="${editContact ne null}">
				<a class="btn btn-primary" type="button" href="contactmanager.jsp"
					id="reset-cancel">Cancel</a>
			</c:if>
		</div>
		<div class="col-sm-3">
			<button type="button" class="btn btn-primary" id="maintainVendorInfo">Maintain
				Vendor Information</button>
		</div>
	</div>
	</form>

	<script type="text/javascript" src="js/loader.js"></script>
</body>
</html>