<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>month</title>
</head>
<script type="text/javascript">
	$(function() {
		$("#b").click(function() {
		
			$.post("admin/month_v?month=1", show);

			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
				 

		});
	
	});
	$(function() {
		$("#b1").click(function() {
			 
			$.post("admin/month_v?month=2", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
	$(function() {
		$("#b2").click(function() {
			 
			$.post("admin/month_v?month=3", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
	$(function() {
		$("#b3").click(function() {
			 
			$.post("admin/month_v?month=4", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
	$(function() {
		$("#b4").click(function() {
		4
			$.post("admin/month_v?month=5", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
	$(function() {
		$("#b5").click(function() {
		 
			$.post("admin/month_v?month=6", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
	$(function() {
		$("#b6").click(function() {
			 
			$.post("admin/month_v?month=7", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
	$(function() {
		$("#b7").click(function() {
			 
			$.post("admin/month_v?month=8", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
	$(function() {
		$("#b8").click(function() {
 			$.post("admin/month_v?month=9", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
	$(function() {
		$("#b9").click(function() {
			 
			$.post("admin/month_v?month=10", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
	$(function() {
		$("#b10").click(function() {
			 
			$.post("admin/month_v?month=11", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
	$(function() {
		$("#b11").click(function() {
			 
			$.post("admin/month_v?month=12", show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);

			}
		});
	});
</script>
<script type="text/javascript">
 $("#ju").hide();
 $("#jy").hide();
 $("#ag").hide();
 $("#se").hide();
 $("#oc").hide();
 $("#no").hide();
 $("#de").hide();
 





</script>
<script>

 
var d = new Date();
 if(d.getMonth()+1==6){
	 $("#ju").show();
 }else if(d.getMonth()+1==7){
	 $("#jy").show();
	 $("#ju").show();
 }else if(d.getMonth()+1==8){
	 $("#ag").show();
	 $("#jy").show();
	 $("#ju").show();
 }else if(d.getMonth()+1==9){
	 $("#se").show();
	 $("#ag").show();
	 $("#jy").show();
	 $("#ju").show();
 }else if(d.getMonth()+1==10){
	 $("#oc").show();
	 $("#se").show();
	 $("#ag").show();
	 $("#jy").show();
	 $("#ju").show();
 }else if(d.getMonth()+1==11){
	 $("#no").show();
	 $("#oc").show();
	 $("#se").show();
	 $("#ag").show();
	 $("#jy").show();
	 $("#ju").show();
 }else if(d.getMonth()+1==12){
	 $("#de").show();
	 $("#no").show();
	 $("#oc").show();
	 $("#se").show();
	 $("#ag").show();
	 $("#jy").show();
	 $("#ju").show();
 }
 
</script>
<body>
	<div class="panel-body" id="total">
		<div id="div"></div>
		<div class="row">
			<div class="col-md-3">


				<fieldset>
					<br>
					<center>
					<a  id="b">	January</a>
					</center>
					<br>

				</fieldset>

			</div>
			<div class="col-md-3">
				<fieldset>
					<br>
					<center>
						<a id="b1">February</a>
					</center>
					<br>

				</fieldset>

			</div>
			<div class="col-md-3">
				<fieldset>
					<br>
					<center>
						<a id="b2"  >March</a>
					</center>
					<br>

				</fieldset>

			</div>
			<div class="col-md-3">
				<fieldset>
					<br>
					<center>
						<a id="b3">April</a>
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
						<a id="b4" >May</a>
					</center>
					<br>

				</fieldset>
			</div>

			<div class="col-md-3" id="ju">
				<fieldset>
					<br>
					<center>
						<a id="b5">June</a>
					</center>
					<br>

				</fieldset>
			</div>
			<div class="col-md-3" id="jy">
				<fieldset>
					<br>
					<center>
						<a id="b6" >July</a>
					</center>
					<br>

				</fieldset>
			</div>
			<div class="col-md-3" id="ag">
				<fieldset>
					<br>
					<center>
						<a id="b7"  >August</a>
					</center>
					<br>

				</fieldset>
			</div>


		</div>
		<div class="row">
			<div class="col-md-3" id="se">
				<fieldset>
					<br>
					<center>
						<a id="b8">September</a>
					</center>
					<br>

				</fieldset>
			</div>
			<div class="col-md-3" id="oc">
				<fieldset>
					<br>
					<center>
						<a id="b9">October</a>
					</center>
					<br>

				</fieldset>
			</div>
			<div class="col-md-3" id="no">
				<fieldset>
					<br>
					<center>
						<a id="b10">November</a>
					</center>
					<br>

				</fieldset>
			</div>
			<div class="col-md-3" id="de">
				<fieldset>
					<br>
					<center>
						<a id="b11">December</a>
					</center>
					<br>

				</fieldset>

			</div>
		</div>

	</div>

</body>
</html>