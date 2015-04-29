<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add-vendor</title>
<!-- <link rel="stylesheet" href="css/fv.css" type="text/css" /> -->


<script type="text/javascript"
	src="http://docs/docs/jquery_json/jquery-1.11.1.js"></script>

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="../css/signupform1.css" rel="stylesheet">
<link href="../css/signupform.css" rel="stylesheet">

<script type="text/javascript" src="../js/pwdstrength.js"></script>
<script type="text/javascript">
	function trimSpaces(x) {
		return x.trim();
	}
</script>
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
</head>
<body id="body">
	<%@include file="header.jsp"%>
	<br>
 	<br>
	<div id="sform">
		<div class="row">

			<div class="col-md-8" id="wid">
				<div class="panel panel-primary " id="panel">
					<div class="panel-heading">
						<div class="panel-title">
							<h4>vendortype</h4>
						</div>
					</div>
					<div class="panel-body">
						<form action="addtype.vms" method="post" novalidate
							class="form-horizontal">

							<div class="item form-group">
								<label class="col-sm-4 control-label">Vendorcategory<em>*</em></label>
								<div class="col-sm-5" id="1">
									<input type="text" id="vendorcategory" name="vendorcategory"
										class="form-control" required placeholder="Enter the Vendorcategory"
										pattern="alpha">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>Vendor</i>Category
										</p>
									</div>
								</div>
							</div>


							 

                            <div class="item form-group">
								<label class="col-sm-4 control-label">VendorType<em>*</em></label>
								<div class="col-sm-5" id="4">
									<input type="text" id="vendortype" name="vendortype"
										class="form-control" placeholder="vendortype" required>
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
										 <i>VendorType</i>
										</p>
									</div>
								</div>
							</div>
							 
							<br>
							<div class="form-group" id="bttns">
								<div class="col-sm-offset-2 col-sm-4">
									<a href="loginpage.jsp"><button type="submit"
											class="btn btn-md btn-primary pull-right" id="b">ADD</button></a>
								</div>
								<div class="col-sm-2">

									<button type="button" class="btn btn-md btn-primary pull-right"
										onclick="conformcancel()"id="a">Reset</button>
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