<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bank</title>
<!-- <link rel="stylesheet" href="css/fv.css" type="text/css" /> -->


<script type="text/javascript"
	src="../js/jquery-2.1.1.min.js"></script>

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="../css/signupform1.css" rel="stylesheet">
<link href="../css/signupform.css" rel="stylesheet">

<script type="text/javascript" src="../js/pwdstrength.js"></script>
<script type="text/javascript">
	function trimSpaces(x) {
		return x.trim();
	}
</script>
<script type="text/javascript">
$(function(){
	
	$("#other").hide();
});
$(function(){
	$("#otherbank").click(function(){
		$("#other").show();
	});
	
});


</script>
</head>
<body>
	<%@include file="../header_l.jsp"%>
	<br>
	<ol class="breadcrumb" id="bd">
		<li><a href="landingpage.jsp">Home</a></li>
		<li class="active">Bank Detiles</li>
	</ol>
	<br>
	<div id="sform">
		<div class="row">

			<div class="col-md-8" id="wid">
				<div class="panel panel-primary " id="panel">
					<div class="panel-heading">
						<div class="panel-title">
							<h4>Bank</h4>
						</div>
					</div>
					<div class="panel-body">
						<form action="../common/bank.vms" method="post" novalidate
							class="form-horizontal">

							<div class="item form-group">
								<label class="col-sm-4 control-label">Vendor Name<em>*</em></label>
								<div class="col-sm-5" id="1">
									<input type="text" id="vendorname" name="vendorname"
										class="form-control" required placeholder="VendorName"
										pattern="" onblur="this.value = trimSpaces(this.value);">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>Vendor</i> Name
										</p>
									</div>
								</div>
							</div>


							<div class="item form-group">
								<label class="col-sm-4 control-label">Bank Name</label>
								<div class="col-sm-5" id="2">
									<input type="text" id="bankName" name="bankname"
										class="form-control" required placeholder="BankName"
										pattern="alpha" onblur="this.value = trimSpaces(this.value);">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>Bank</i> Name
										</p>
									</div>
								</div>
							</div>


							<div class="item form-group">
								<label class="col-sm-4 control-label">Acccount Number</label>
								<div class="col-sm-5" id="3">
									<input type="text" id="acn" name="acn" class="form-control"
										required placeholder="Account Number" maxlength="11"
										data-validate-length-range="11"
										data-validate-pattren="numeric" pattern="numeric"
										onblur="this.value = trimSpaces(this.value);">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>Account</i>Number
										</p>
									</div>
								</div>
							</div>

							<div class="item form-group">
								<label class="col-sm-4 control-label">Account Name<em>*</em></label>
								<div class="col-sm-5" id="4">
									<input type="text" id="acname" name="acname"
										class="form-control" placeholder="Account Name" required>
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											Account <br> Name
										</p>
									</div>
								</div>
							</div>

							<div class="item form-group">
								<label class="col-sm-4 control-label">ISCF CODE<em>*</em></label>
								<div class="col-sm-5" id="9">
									<input type="text" id="iscfcode" class="form-control"
										name="iscfcode" maxlength="" required placeholder="iscfcode"
										data-validate-length-range="" data-validate-pattren="numeric">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>ISCF</i> Number
										</p>
									</div>
								</div>
							</div>

							<div class="item form-group">
								<button class="btn btn-info btn-xs" id="otherbank">Other Bank</button>
								<div class="col-sm-5" id="1">
								</div>
 							</div>

							<div id="other">
							<div class="item form-group">
								<label class="col-sm-4 control-label">Bank Name</label>
								<div class="col-sm-5" id="2">
									<input type="text" id="bankName_1" name="bankname_1"
										class="form-control" required placeholder="BankName"
										pattern="alpha" onblur="this.value = trimSpaces(this.value);">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>Bank</i> Name
										</p>
									</div>
								</div>
							</div>


							<div class="item form-group">
								<label class="col-sm-4 control-label">Acccount Number</label>
								<div class="col-sm-5" id="3">
									<input type="text" id="acn_1" name="acn_1" class="form-control"
										required placeholder="Account Number" maxlength="11"
										data-validate-length-range="11"
										data-validate-pattren="numeric" pattern="alpha"
										onblur="this.value = trimSpaces(this.value);">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>Account</i>Number
										</p>
									</div>
								</div>
							</div>

							<div class="item form-group">
								<label class="col-sm-4 control-label">Account Name<em>*</em></label>
								<div class="col-sm-5" id="4">
									<input type="text" id="acname_1" name="acname_1"
										class="form-control" placeholder="Account Name" required>
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											Account <br> Name
										</p>
									</div>
								</div>
							</div>

							<div class="item form-group">
								<label class="col-sm-4 control-label">ISCF CODE<em>*</em></label>
								<div class="col-sm-5" id="9">
									<input type="text" id="iscfcode_1" class="form-control"
										name="iscfnumber_1" maxlength="" required placeholder="iscfcode"
										data-validate-length-range="" data-validate-pattren="numeric">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>ISCF</i> Number
										</p>
									</div>
								</div>
							</div>
							</div>

							<br>
							<div class="form-group" id="bttns">
								<div class="col-sm-offset-2 col-sm-4">
									<a href="loginpage.jsp"><button type="submit"
											class="btn btn-md btn-primary pull-right" id="b">Add_Bank</button></a>
								</div>
								<div class="col-sm-2">

									<button type="button" class="btn btn-md btn-primary pull-right"
										id="a">Reset</button>
								</div>
							</div>
						</form>
						<p id="mandatory" class="pull-right">
							All fields marked in<span><em> * </em></span> are mandatory
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>
	<br>
	<br>
	<%@include file="footer.jsp"%>
	<script src="../js/jquery-1.11.0.min.js"></script>

	<script src="../js/validator.js"></script>
	<script src="../js/signuploader.js"></script>
	<!--sign up loader  -->
</body>
</html>