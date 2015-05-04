<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>


</title>
<script type="text/javascript">
$(function(){
	$("#b").click(function(){
		 var date=$("#date_r").val();
		 $.post("admin/date_s?pagenumber=1&date="+date+"&page=first",
					show);
			function show(data) {
				$("#disply").html("");
				$("#disply").html(data);
				
			}
	})
})

</script>
 
</head>
<body>
	<div class="container">
		<div class="row">
			 
			<div class="col-md-8">
				<div class="panel panel-primary " id="panel">
					<div class="panel-heading">
						<div class="panel-title">
							<h4>Date</h4>
						</div>
					</div>
					<div class="panel-body">
						<form action="admin/date_s" method="post" novalidate
							class="form-horizontal">

							<div class="item form-group">
								<label class="col-sm-4 control-label">DATE<em>*</em></label>
								<div class="col-sm-5" id="1">
									<input type="date" id="date_r" name="date_r"
										class="form-control" required placeholder="Enter the Date"
										>
								</div>
								 							</div>

 


							 
							<br>
							<div class="form-group" id="bttns">
								<div class="col-sm-offset-3 col-sm-4">
									 <button type="button"
											class="btn btn-md btn-primary pull-right" id="b">Submit</button></a>
								</div>
								 
							</div>
						</form>
						 
					</div>
				</div>
			</div>
		</div>
		<div id="disply">
		
		
		</div>
		
	</div>
</body>
</html>