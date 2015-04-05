<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign-up</title>
<!-- <link rel="stylesheet" href="css/fv.css" type="text/css" /> -->


<script type="text/javascript"
	src="http://docs/docs/jquery_json/jquery-1.11.1.js"></script>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/signupform1.css" rel="stylesheet">
<link href="css/signupform.css" rel="stylesheet">

<script type="text/javascript" src="js/pwdstrength.js"></script>
<script type="text/javascript">
	function trimSpaces(x) {
		return x.trim();
	}
</script>
</head>
<body>
	<%@include file="header.jsp"%>
	<br>
	<ol class="breadcrumb" id="bd">
		<li><a href="loginpage.jsp">Login</a></li>
		<li class="active">Sign Up</li>
	</ol>
	<br>
	<div id="sform">
		<div class="row">

			<div class="col-md-8" id="wid">
				<div class="panel panel-primary " id="panel">
					<div class="panel-heading">
						<div class="panel-title">
							<h4>Sign-Up</h4>
						</div>
					</div>
					<div class="panel-body">
						<form action="signup.vms" method="post" novalidate
							class="form-horizontal">

							<div class="item form-group">
								<label class="col-sm-4 control-label">First Name<em>*</em></label>
								<div class="col-sm-5" id="1">
									<input type="text" id="firstname" name="firstname"
										class="form-control" required placeholder="First Name"
										pattern="alpha" onblur="this.value = trimSpaces(this.value);">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>First Name</i> should contains only Alphabets
										</p>
									</div>
								</div>
							</div>


							<div class="item form-group">
								<label class="col-sm-4 control-label">Middle Name</label>
								<div class="col-sm-5" id="2">
									<input type="text" id="middlename" name="middlename"
										class="form-control optional" placeholder="Middle Name"
										pattern="alpha" onblur="this.value = trimSpaces(this.value);">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											(optional) <i>Middle Name</i> should contains only Alphabets
										</p>
									</div>
								</div>
							</div>


							<div class="item form-group">
								<label class="col-sm-4 control-label">Last Name</label>
								<div class="col-sm-5" id="3">
									<input type="text" id="lastname" name="lastname"
										class="form-control optional" placeholder="Last Name"
										pattern="alpha" onblur="this.value = trimSpaces(this.value);">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											(optional) <i>Last Name</i> should contains only Alphabets
										</p>
									</div>
								</div>
							</div>

							<div class="item form-group">
								<label class="col-sm-4 control-label">Email<em>*</em></label>
								<div class="col-sm-5" id="4">
									<input type="email" id="email" name="email"
										class="form-control" placeholder="Email" required>
								</div>
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
								<label class="col-sm-4 control-label">Mobile<em>*</em></label>
								<div class="col-sm-5" id="9">
									<input type="tel" id="mobile" class="form-control"
										name="mobile" maxlength="10" required placeholder="Mobile"
										data-validate-length-range="10"
										data-validate-pattren="numeric">
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
								<label class="col-sm-4 control-label">Password<em>*</em></label>
								<div class="col-sm-5" id="5">
									<!-- <input type="password" id="password" name="password"
									class="form-control" placeholder="Password" required> -->
									<input type="password" id="password" name="password"
										class="form-control" placeholder="Password" required />
								</div>

								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>Password</i> can be a combination of upper-case and
											lower-case letters, numbers and special-characters.
										</p>
									</div>
								</div>
							</div>

							<div class="item form-group">

								<label for="passwordStrength" class="col-sm-4 control-label">Password
									Strength</label>
								<div id="passwordDescription"></div>
								<div id="passwordStrength" class="strength0 col-sm-5 "></div>

							</div>

							<div class="item form-group">
								<label class="col-sm-4 control-label">Re-Confirm-Password<em>*</em></label>
								<div class="col-sm-5" id="6">
									<input type="password" id="rpassword" name="rpassword"
										class="form-control" placeholder="Re-Confirm-Password"
										required data-validate-linked="password">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>Re-enter you above entered password for confirmation.</p>
									</div>
								</div>
							</div>


							<div class="item form-group" id="sel">
								<label class="col-sm-4 control-label"> <span>Security
										Question<em>*</em>
								</span></label>
								<div class="col-sm-5">
									<select class="required form-control" name="selectquestion">
										<option value="">-------------Select one
											question------------</option>
										<option value="o1">1.What is your father's place of
											birth?</option>
										<option value="o2">2.Which is the first car you
											bought?</option>
										<option value="o3">3.What is your mother's maiden
											Name?</option>
										<option value="o4">4.Which is the first school you
											attended?</option>
									</select>
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											Select a <i>Security Question</i>
										</p>
									</div>
								</div>
							</div>

							<div class="item form-group">
								<label class="col-sm-4 control-label">Answer<em>*</em></label>
								<div class="col-sm-5" id="8">
									<input type="text" id="answer" name="answer"
										class="form-control" required placeholder="Answer"
										onblur="this.value = trimSpaces(this.value);">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>
											<i>Answer</i> to the above selected question
										</p>
									</div>
								</div>
							</div>

							<br>
							<div class="form-group" id="bttns">
								<div class="col-sm-offset-2 col-sm-4">
									<a href="loginpage.jsp"><button type="submit"
											class="btn btn-md btn-primary pull-right" id="b">Sign-Up</button></a>
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
	<script src="js/jquery-1.11.0.min.js"></script>

	<script src="js/validator.js"></script>
	<script src="js/signuploader.js"></script>
	<!--sign up loader  -->
</body>
</html>