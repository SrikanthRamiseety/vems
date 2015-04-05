<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add New Vendor</title>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	function conformcancel() {
		if ($("input").val() != null) {
			var con = confirm("All unsaved data will be lost. Are you sure you want to continue?");
			if (con) {
				$("input").each(function() {
					$(this).val('');
					$(".alert").remove();
					$(".item").prop("class", "item form-group");
				});
				$("select").each(function() {
					$(this).val('');
				});

				$("textarea").each(function() {
					$(this).val('');
				});
			}
		}
	}

	function trimSpaces(x) {
		return x.trim();
	}
</script>
<link rel="stylesheet" href="css/addvendor.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<ol class="breadcrumb" id="bd">
		<li><a href="landingpage.jsp">Home</a></li>

		<li class="active">Add Vendor</li>
	</ol>


	<div class="container">
		<div class="row">
			<c:if test="${addedsuccessfully eq false }">
				<div class="alert alert-success" align="center" id="alert">
					Your data has been added successfully</div>
			</c:if>

			<div class="panel panel-primary" id="body">
				<div class="panel-heading">
					<div class="panel-title">
						<h4>Add Vendor</h4>
					</div>
				</div>

				<div class="panel-body">
					<form action="addvendor.vms" method="post"
						class="form form-horizontal" role="form" novalidate>

						<div class="item form-group" id="sel">
							<label class="col-sm-4 col-md-4 col-xs-4 col-lg-4 control-label">Vendor
								Type<em>*</em> <span> </span>
							</label>
							<div class="col-sm-6 col-md-6 col-xs-6 col-lg-6">

								<c:if test="${vendor eq null }">
									<select class="required form-control" name="vendorType"
										id="vendortype">
										<option selected="selected" value="">Select Vendor
											Type</option>
										<option value="Service"><b>S</b>ervice
										</option>
										<option value="Supply"><b>S</b>upply
										</option>
									</select>
								</c:if>
								<c:if test="${vendor ne null }">
									<select class="required form-control" name="vendorType"
										id="vendortype">
										<option selected="selected"><c:out
												value="${vendor.vendorType }"></c:out>
										</option>
										<option value="Service"><b>S</b>ervice
										</option>
										<option value="Supply"><b>S</b>upply
										</option>
									</select>
								</c:if>

							</div>
							<div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
										Select a <i>Vendor Type</i>
									</p>
								</div>
							</div>
						</div>
						<div class="item form-group" id="sel">
							<label class="col-sm-4 col-md-4 col-xs-4 col-lg-4 control-label">Vendor
								Category <em>*</em><span> </span>
							</label>
							<div class="col-sm-6 col-md-6 col-xs-6 col-lg-6">
								<select class="required form-control" name="vendorCategory"
									id="vendorcategory">
									<c:if test="${vendor eq null }">
										<option selected="selected" value="">Select Vendor
											Category</option>
										<option value="Computers">Computer</option>
										<option value="Furniture">Furniture</option>
										<option value="AC">AC</option>
										<option value="Projector">Projector</option>
										<option value="Servers">Servers</option>
									</c:if>
									<c:if test="${vendor ne null }">
										<option selected="selected">
											<c:out value="${vendor.vendorCategory }"></c:out></option>
										<option value="Computers">Computer</option>
										<option value="Furniture">Furniture</option>
										<option value="AC">AC</option>
										<option value="Projector">Projector</option>
										<option value="Servers">Servers</option>
									</c:if>
								</select>
							</div>
							<div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
										Select a <i>Vendor Category</i>
									</p>
								</div>

							</div>
						</div>

						<div class=" item form-group">
							<label class="col-sm-4 col-md-4 col-xs-4 col-lg-4 control-label">Vendor
								Name<em>*</em>
							</label>
							<div class="col-sm-6 col-md-6 col-xs-6 col-lg-6">
								<input type="text" id="vendorname" name="vendorName"
									pattern="alpha" required="required"
									class=" required form-control"
									placeholder="Enter the Vendor Name"
									onblur="this.value = trimSpaces(this.value);"
									value="${vendor.vendorName }">
							</div>
							<div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
										<i>Vendor Name</i> should have alphabets or numbers or
										combination of both
									</p>
								</div>
							</div>

						</div>
						<div class="item form-group">
							<label class="col-sm-4 col-md-4 col-xs-4 col-lg-4 control-label">Mobile<em>*</em></label>
							<div class="col-sm-2 col-md-2 col-xs-2 col-lg-2">
								<c:if test="${vendor eq null }">
									<input type="text" id="code" name="mobileCode"
										required="required" class="form-control" maxlength="5"
										value="+91">
								</c:if>
								<c:if test="${vendor ne null }">
									<input type="text" id="code" name="mobileCode"
										required="required" class="form-control" maxlength="5"
										value="${vendorMobileCode }">
								</c:if>
							</div>
							<div class="col-sm-4 col-md-4 col-xs-4 col-lg-4">
								<input type="tel" id="mobile" name="vendorMobileNumber"
									required="required" class="form-control" maxlength="10"
									placeholder="Enter Mobile number" maxlength="10"
									data-validate-length-range="10" value="${vendorMobileNumber }">
							</div>
							<div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
										<i>Mobile</i> number should have only numbers with 10 digits.
									</p>
								</div>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-sm-4 col-md-4 col-xs-4 col-lg-4 control-label">Landline</label>
							<div class="col-sm-2 col-md-2 col-xs-2 col-lg-2">
								<input type="tel" id="std" name="landlineCode"
									value="${vendorLandlineCode }" class="form-control"
									placeholder="STD">
							</div>
							<div class="col-sm-4 col-md-4 col-xs-4 col-lg-4">
								<input type="tel" id="number" name="vendorLandlineNumber"
									class="form-control" placeholder="Enter LandLine number"
									maxlength="8" data-validate-length-range="4"
									value="${vendorLandlineNumber }">
							</div>
							<div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
										Enter <i>Landline</i> number should have only numbers.
									</p>
								</div>
							</div>
						</div>
						<div class=" item form-group">
							<label class="col-sm-4 col-md-4 col-xs-4 col-lg-4 control-label">Web
								Site </label>
							<div class="col-sm-6 col-md-6 col-xs-6 col-lg-6">
								<input type="url" id="website" name="vendorWebsite"
									class="form-control" placeholder="Enter URL"
									value="${vendor.vendorWebsite }">
							</div>
							<div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
										Enter <i>URL</i>
									</p>
								</div>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-sm-4 col-md-4 col-xs-4 col-lg-4 control-label">Address<em>*</em></label>
							<div class="col-sm-6 col-md-6 col-xs-6 col-lg-6">
								<c:if test="${vendor eq null }">
									<textarea rows="3" cols="7" class="form-control"
										onblur="this.value = trimSpaces(this.value);"
										name="vendorAddress" placeholder="Enter Address"
										required="required" id="address"></textarea>
								</c:if>
								<c:if test="${vendor ne null }">
									<textarea rows="3" cols="7" class="form-control"
										onblur="this.value = trimSpaces(this.value);"
										name="vendorAddress" placeholder="Enter Address"
										required="required" id="address"><c:out
											value="${vendor.vendorAddress }"></c:out> </textarea>
								</c:if>
							</div>
							<div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
										Enter a valid <i>Address</i>
									</p>
								</div>
							</div>
						</div>

						<div class="item form-group">
							<br>
							<div
								class="col-md-offset-3 col-sm-offset-3 col-xs-offset-3 col-lg-offset-3 col-sm-4 col-md-4 col-xs-4 col-lg-4">
								<button type="submit" class="btn btn-primary btn-xl"
									id="maintainContactInfo">Maintain Contact Information</button>
							</div>
							<div
								class="col-md-offset-1 col-sm-offset-1 col-xs-offset-1 col-lg-offset-1 col-sm-3 col-md-3 col-xs-3 col-lg-3">
								<button type="button" class="btn btn-primary btn-xl re"
									onclick="conformcancel()" id="reset">Reset</button>

							</div>

						</div>
						<p id="mandatory">
							All fields marked in<span><em> * </em></span>are mandatory
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="js/validator.js"></script>
	<script type="text/javascript" src="js/loader.js"></script>

</body>
</html>