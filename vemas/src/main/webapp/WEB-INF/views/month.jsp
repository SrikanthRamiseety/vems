<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Date</title>
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script src="../js/jquery-2.1.1.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
 
<style type="text/css">
.col-md-3 {
	padding: 10px;
	border: 2px;
}

fieldset {
	background-color: #367;
	color: white;
}

.btn {
	color: green;
}

#b {
	
}
</style>
</head>
<body>


	<div class="container">
		<div class="row">

			<div class="col-md-8">
				<div class="panel panel-primary " id="panel">
					<div class="panel-heading">
						<div class="panel-title">
							<h4>
								Months Of 
							</h4>
						</div>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3">
							<select>
									<option selected="selected" value="2015">2015</option>
									<option value="2014">2014</option>
									<option value="2014">2013</option>
								</select>
								<fieldset>
									<br>
									<center>
										<button id="b" class="btn btn-primary" value="1">January
										</button>
									</center>
									<br>

								</fieldset>

							</div>
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b1" class="btn btn-" value="2">February</button>
									</center>
									<br>

								</fieldset>

							</div>
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b2" class="btn btn-" value="3">March</button>
									</center>
									<br>

								</fieldset>

							</div>
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b3" class="btn btn-" value="4">April</button>
									</center>
									<br>

								</fieldset>

							</div>


						</div>
						<div class="row">
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b4" class="btn btn-" value="5">May</button>
									</center>
									<br>

								</fieldset>
							</div>
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b5" class="btn btn-" value="6">June</button>
									</center>
									<br>

								</fieldset>
							</div>
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b6" class="btn btn-" value="7">July</button>
									</center>
									<br>

								</fieldset>
							</div>
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b7" class="btn btn-" value="8">August</button>
									</center>
									<br>

								</fieldset>
							</div>


						</div>
						<div class="row">
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b8" class="btn btn-" value="9">September</button>
									</center>
									<br>

								</fieldset>
							</div>
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b9" class="btn btn-" value="10">October</button>
									</center>
									<br>

								</fieldset>
							</div>
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b10" class="btn btn-" value="11">November</button>
									</center>
									<br>

								</fieldset>
							</div>
							<div class="col-md-3">
								<fieldset>
									<br>
									<center>
										<button id="b11" class="btn btn-" value="12">December</button>
									</center>
									<br>

								</fieldset>

							</div>


						</div>

					</div>
				</div>
			</div>
		</div>
		<div id="disply"></div>

	</div>
</body>
</html>