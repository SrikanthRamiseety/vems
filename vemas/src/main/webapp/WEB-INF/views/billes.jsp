<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>billes</title>
<!-- <link rel="stylesheet" href="css/fv.css" type="text/css" /> -->
<script type="text/javascript " src="../js/jquery.validate.js"></script>
<script type="text/javascript" src="../js/jquery.timepicker.js"></script>

<script type="text/javascript" src="../js\query-ui.js"></script>
<style type="text/css">
#body{
background-image: url("../images/119.jpg");
}

</style>
   <script type="text/javascript">
   $(function(){
	   alert("coming");
	var pickerOpts = {
		minDate : new Date(),
		maxDate : "+30",
		beforeShowDay : function(date) {
			var day = date.getDay();
			return [ (day != 0), '' ];
		}
	};
	$(function() {
		$("#datepicker").datepicker(
		pickerOpts
		);
	});
   });
	</script>
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
<link href="../css/signupform1.css" rel="stylesheet">
<link href="../css/signupform.css" rel="stylesheet">

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

			<div class="col-md-8" id="wid">
				<div class="panel panel-primary " id="panel">
					<div class="panel-heading">
						<div class="panel-title">
							<h4>Up loading billes</h4>
						</div>
					</div>
					<div class="panel-body">
						<form action="billadd.vms" method="post" novalidate
							class="form-horizontal" >

							<div class="item form-group">
								<label class="col-sm-4 control-label">Bill No<em>*</em></label>
								<div class="col-sm-5" id="9">
									<input type="text" id="billno" name="billno"
										class="form-control" required placeholder="bill No"
										pattern="" onblur="this.value = trimSpaces(this.value);">
								</div>
									<div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
									<i>BillId</i>
									</p>
								</div>
							</div>
								 
							</div>


							<div class="item form-group">
								<label class="col-sm-4 control-label">VendorName</label>
								<div class="col-sm-5" id="9">
									<input type="text" id="shopname" name="shopname"
										class="form-control optional" placeholder="Shop Name"
										pattern="alpha" onblur="this.value = trimSpaces(this.value);">
								</div>
								<div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
									<i>VendorName</i>
									</p>
								</div>
							</div>
									 
							</div>


							 
							<div class="item form-group">
								<label class="col-sm-4 control-label">Amount<em>*</em></label>
								<div class="col-sm-5" id="9">
									<input type="text" id="amount" class="form-control"
										name="amount" maxlength="" required placeholder="amount"
										 pattern="numeric" 
										 >
								</div>
								 <div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
									<i>Amount</i>
									</p>
								</div>
							</div>
							</div>

							<div class="item form-group">
								<label class="col-sm-4 control-label">Who Upload<em>*</em></label>
								<div class="col-sm-5" id="9">
									<!-- <input type="password" id="password" name="password"
									class="form-control" placeholder="Password" required> -->
									<input type="text" id="name" name="name"
										class="form-control" pattern="alpha" placeholder="Name" />
								</div>

								 <div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
									<i>Name</i>
									</p>
								</div>
							</div>
							</div>

							<div class="item form-group">
								<label class="col-sm-4 control-label">Mobile<em>*</em></label>
								<div class="col-sm-5" id="9">
									<input type="tel" id="moblie"  class="form-control"
										name="mobile" maxlength="" required placeholder="Mobile"
										data-validate-length-range="10"
										data-validate-pattren="numeric" pattern="numeric" >
								</div>
								<div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
									<i>Mobile</i>
									</p>
								</div>
							</div>
								</div>
								<div class="item form-group">
								<label class="col-sm-4 control-label">Date<em>*</em></label>
								<div class="col-sm-5" id="9">
									<input type="date" data-date-format="yyyy-mm-dd"
									id="date" name="date" required="required"
									 >
								</div>
								
								 <div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
									<i>Date</i>
									</p>
								</div>
							</div>
							</div>
														<div class="item form-group">
								<label class="col-sm-4 control-label">Bill Image<em>*</em></label>
								<div class="col-sm-5" id="9">
									 <input type="file" name="filename" accept="image/gif, image/jpeg, image/png" required="required">
									 
								</div>
								 <div class='col-sm-2 col-md-2 col-xs-2 tooltip help'>
								<span>?</span>
								<div class='content'>
									<b></b>
									<p>
									<i>Images</i>
									</p>
								</div>
							</div>
							</div>
							<img src="" width="200" style="display:none;" />
							<div id="disp_tmp_path"></div>
							
							

							 							<br>
							<div class="form-group" id="bttns">
								<div class="col-sm-offset-2 col-sm-4">
									<a href="loginpage.jsp"><button type="submit"
											class="btn btn-md btn-primary pull-right" id="b">UPLOAD</button></a>
								</div>
								<div class="col-sm-2">

									<button type="button" class="btn btn-md btn-primary pull-right"
									onclick="conformcancel()"	id="a">Reset</button>
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