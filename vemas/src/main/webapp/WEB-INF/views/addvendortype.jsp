	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Vendor Type</title>
<!-- <link rel="stylesheet" href="css/fv.css" type="text/css" /> -->

<style type="text/css">
#body{
background-image: url("../images/120.jpg");
}

</style>

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
 

<link rel="stylesheet" href="../css/bootstrap.min.css">
 
<script type="text/javascript" src="js/pwdstrength.js"></script>
<script type="text/javascript">
	function trimSpaces(x) {
		return x.trim();
	}
</script>
</head>
<body id="body">
	<%@include file="header.jsp"%>
	<br>
	 
	<br>
	<div id="sform">
		<div class="row">
<div class="col-md-3"></div>
			<div class="col-md-7" id="wid">
				<div class="panel panel-primary " id="panel">
					<div class="panel-heading">
						<div class="panel-title">
							<h4>Add Vendor Type</h4>
						</div>
					</div>
					<div class="panel-body">
						<form action="addtype.vms" method="post" novalidate
							class="form-horizontal">

							<div class="item form-group">
								<label class="col-sm-4 control-label">Vender Category<em>*</em></label>
								<div class="col-sm-5" id="9">
									<input type="text" id="vendorcategory" name="vendorcategory"
										class="form-control" required placeholder="Enter the Vendorcategory"
										pattern="alpha">
										</div>
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
								<label class="col-sm-4 control-label">Vendor Type</label>
								<div class="col-sm-5" id="9">
									<input type="text" id="vendortype" name="vendortype"
										class="form-control requried"  required="required" placeholder="Middle Name"
										pattern="">
								</div>
							
							</div>


							 
							<br>
							<div class="form-group" id="bttns">
								<div class="col-sm-offset-2 col-sm-4">
									 <button type="submit"
											class="btn btn-md btn-primary pull-right" id="b">Add Vendor Type</button></a>
								</div>
								<div class="col-sm-2">

									<button type="button" class="btn btn-md btn-primary pull-right"onclick="conformcancel()"
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
	<script src="../js/jquery-2.1.1.min.js"></script>

	<script src="../js/validator.js"></script>
	<script src="../js/signuploader.js"></script>
	<!--sign up loader  -->
</body>
</html>