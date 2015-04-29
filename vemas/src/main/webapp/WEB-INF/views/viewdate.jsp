<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<div class="row">
 
<c:if test="${(fn:length(bill) eq 0) }">
		<h2>Sorry! No Bills Uploaded..</h2>
	</c:if>
<div class="col-md-9">
	<c:if test="${(fn:length(bill) ne 0) }">
		<input type="hidden" id="hidden" name="hidden"
			value="${bill.size() }">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h4>Bills</h4>

			</div>
			<div class="panel-body" id="vendor-table">
				<table class="table table-bordered">
					<thead>
						<tr>
						 
							<th>BillNo</th>
							<th>VendorName</th>
							 <th>amount</th>
							<th>Name</th>
							<th>Mobile</th>
							<th>Images</th>
							<th>Date</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach items="${bill}" var="i">
							<tr>
							  
								<td><c:out value="${i.getBillNo()}"></c:out></td>
								<td><c:out value="${i.getShopName()}"></c:out></td>
								 <td><c:out value="${i.getAmount()}"></c:out></td>
								<td><c:out value="${i.getName()}"></c:out></td>
								<td><c:out value="${i.getMobile()}"></c:out></td>
 							   	 
											<td><img alt="loading..." src="../upload/${i. imageName}"
							height="100px" width="200px"></td>
 							    <td><c:out value="${i.getDate1()}"></c:out></td>
								
								

							</tr>

							 
							 									
									


								</c:forEach>


							</tbody>


						 

					



				</table>
			</div>
				</div>
	</c:if>
		


</div>


</div>
</div>

</body>
</html>