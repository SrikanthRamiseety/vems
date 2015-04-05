<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forgot password</title>

<!-- <link rel="stylesheet" href="css/fv.css" type="text/css" /> -->

<!-- <script type="text/javascript"
	src="http://docs/docs/References/08_Bootstrap/bootstrap-3.3.1-dist/dist/js/bootstrap.min.js"></script> -->


<link rel="stylesheet" href="css/bootstrap.min.css">

<link href="css/forgotpwd.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp"%>
	<ol class="breadcrumb" id="bd">
		<li><a href="loginpage.jsp">Login</a></li>

		<li class="active">Forgot Password</li>
	</ol>



	<div id="sform">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary " id="panel">
					<div class="panel-heading">
						<h4 class="">Forgot Password</h4>
					</div>
					<div class="panel-body" align="center">
						<br>
						<form action="forgotpwd.vms" method="post"
							class="form form-horizontal" role="form" novalidate>

							<div class="item form-group">
								<label class="col-sm-4 control-label">Email</label>
								<div class="col-sm-5" id="4">
									<input type="email" id="email" name="email"
										class="form-control" placeholder="Email Id"
										value="${param.email }" readonly="readonly">
								</div>
								<div class='tooltip help'>
									<span>?</span>
									<div class='content'>
										<b></b>
										<p>This is a read-only field from the previous page.</p>
									</div>
								</div>
							</div>
							<div class="item form-group" id="sel">
								<label class="col-sm-4 control-label"> <span>Security
										Question </span><em>*</em></label>
								<div class="col-sm-5">
									<select class="required form-control" name="seq_question">
										<option value="">--Select one question--</option>
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
										class="form-control" required placeholder="Answer">
								</div>
								<div class='item tooltip help'>
									<span>?</span>
									<div class="item tooltip content">
										<b></b>
										<p>
											<i>Answer</i> to the above selected question
										</p>
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-4" style="margin-left: 28%;">
									<button type="submit" class="btn btn-md btn-primary pull-right"
										id="b">Submit</button>
								</div>


							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-offset-2 col-sm-7" id="invalid">
			<c:if test="${incorrectAnswer eq false }">
				<div class="alert alert-success" align="center" id="alert">
					Your password is: "${password }" <a
						href="loginpage.jsp?email=${param.email }" id="ok"
						class="btn btn-md pull-right" style="">OK</a>

				</div>
			</c:if>

			<c:if test="${incorrectAnswer eq true }">
				<div class="alert alert-danger" align="center">The question or
					answer for your account does not match. Please try again.</div>
			</c:if>


		</div>
		<div></div>
	</div>

	<%@ include file="footer.jsp"%>
	<script src="js/jquery-1.11.0.min.js"></script>

	<script src="multifield.js"></script>
	<script src="js/validator.js"></script>
	<!-- <script type="text/javascript" src="js/loader.js"></script> -->
	<script type="text/javascript" src="js/loader.js"></script>
</body>
</html>