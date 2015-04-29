<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Date</title>
<script type="text/javascript">
$(function(){
	$("#b").click(function(){
		 var month=$("#b").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b1").click(function(){
		 var month=$("#b1").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b2").click(function(){
		 var month=$("#b2").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b3").click(function(){
		 var month=$("#b3").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b4").click(function(){
		 var month=$("#b4").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b5").click(function(){
		 var month=$("#b5").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b6").click(function(){
		 var month=$("#b6").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b7").click(function(){
		 var month=$("#b7").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b8").click(function(){
		 var month=$("#b8").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b9").click(function(){
		 var month=$("#b9").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b10").click(function(){
		 var month=$("#b10").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
$(function(){
	$("#b11").click(function(){
		 var month=$("#b11").val();
		 $.post("admin/month_v?month="+month,
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	});
});
 

</script>
 <style type="text/css">
 .col-md-3{
 padding: 10px;
 border: 2px;
 
 }
 
 fieldset{
 background-color:aqua;
 color: white;
 }
 .btn{
 color: white;
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
							<h4>Months</h4>
						</div>
					</div>
					<div class="panel-body">
						 <div class="row">
						 <div class="col-md-3">
						 <fieldset>
						 <br>
					<center><button id="b" class="btn btn-info" value="1" >January </button>  </center>
					<br>
						 
						 </fieldset>
						 
						 </div>
						  <div class="col-md-3">
						<fieldset>
						 <br>
					<center><button id="b1" class="btn btn-info" value="2" >February</button>  </center>
					<br>
						 
						 </fieldset>
						 
						 </div>
						  <div class="col-md-3">
						 <fieldset>
						  <br>
				<center><button id="b2" class="btn btn-info" value="3" >March</button>  </center>
					<br>
						 
						 </fieldset>
						 
						 </div>
						  <div class="col-md-3">
						<fieldset>
						 <br>
				<center><button id="b3" class="btn btn-info" value="4" >April</button>  </center>
					<br>
						 
						 </fieldset>
						 
						 </div>
						 
						 
						 </div>
						  <div class="row">
						 <div class="col-md-3">
						<fieldset>
						 <br>
					<center><button id="b4" class="btn btn-info" value="5" >May</button>  </center>
					<br>
						 
						 </fieldset>
						 </div>
						  <div class="col-md-3">
						<fieldset>
						 <br>
				<center><button id="b5" class="btn btn-info" value="6" >June</button>  </center>
					<br>
						 
						 </fieldset>
						 </div>
						  <div class="col-md-3">
						<fieldset>
						 <br>
					<center><button id="b6" class="btn btn-info" value="7" >July</button>  </center>
					<br>
						 
						 </fieldset>
						 </div>
						  <div class="col-md-3">
						<fieldset>
						 <br>
					<center><button id="b7" class="btn btn-info" value="8" >August</button>  </center>
					<br>
						 
						 </fieldset>
						 </div>
						 
						 
						 </div>
						  <div class="row">
						 <div class="col-md-3">
						 <fieldset>
						  <br>
					<center><button id="b8" class="btn btn-info" value="9" >September</button>  </center>
					<br>
						 
						 </fieldset>
						 </div>
						  <div class="col-md-3">
						<fieldset>
						 <br>
					<center><button id="b9" class="btn btn-info" value="10" >October</button>  </center>
					<br>
						 
						 </fieldset>
						 </div>
						  <div class="col-md-3">
						 <fieldset>
						  <br>
					<center><button id="b10" class="btn btn-info" value="11" >November</button>  </center>
					<br>
						 
						 </fieldset>
						 </div>
						  <div class="col-md-3">
						<fieldset>
						 <br>
					<center><button id="b11" class="btn btn-info" value="12" >December</button>  </center>
					<br>
						 
						 </fieldset>
						 
						 </div>
						 
						 
						 </div>
						 
					</div>
				</div>
			</div>
		</div>
		<div id="disply">
		
		
		</div>
		
	</div>
</body>
</html>