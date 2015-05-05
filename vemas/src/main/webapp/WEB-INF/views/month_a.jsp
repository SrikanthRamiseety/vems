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

<script type="text/javascript">
$(function(){
	 
	$( "#month_e" )
	  .change(function() {
	    var str = "";
	    $( "select option:selected" ).each(function() {
	      str += $( this ).text() + " ";
	    $.post("admin/year_a?year=" + str, show);
	    });
	   
	    $( "#div" ).text( str );
		function show(data) {
			$("#total").html("");
			$("#total").html(data);
		}
	  })
	  .trigger( "change" );
});

</script>
<style type="text/css">
.col-md-3 {
	padding: 10px;
	border: 2px;
}

fieldset {
	background-color:#456;
	color: white;
}

.btn {
	color: green;
}

#b {
	
}
#total{
  	

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
					<div id="section">
					<select id="month_e">
									<option selected="selected"  value="2015">2015</option>
									<option value="2014">2014</option>
									<option value="2014">2013</option>
									<option value="2012">2012</option>
								</select>
					
					</div>
					<div class="panel-body"  id="total">
					<div id="div"></div>
						 
						 

					</div>
					
				</div>
			</div>
			</div>
		</div>
		<div id="disply"></div>

	 
</body>
</html>