<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Landing page</title>
 
 
 

<!-- <link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/landingpage.css">
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">

        Font Awesome CSS
        <link href="../css/font-awesome.min.css" rel="stylesheet">
		
		Custom CSS
        <link href="../css/animate.css" rel="stylesheet">

        Custom CSS
        <link href="../css/style.css" rel="stylesheet">

        Custom Fonts
        <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>


        Template js
        <script src="../js/jquery-2.1.1.min.js"></script>
        <script src="../bootstrap/js/bootstrap.min.js"></script>
        <script src="../js/jquery.appear.js"></script>
        <script src="../js/contact_me.js"></script>
        <script src="../js/jqBootstrapValidation.js"></script>
        <script src="../js/modernizr.custom.js"></script>
        <script src="../js/script.js"></script>
 -->
<style type="text/css">
#search {
	margin-left: 19%;
	width: 66%;
}
#body{
background-image: url("../images/97.jpg");

}
</style>
 
</head>
<body id="body">

	<%@ include file="header.jsp"%>
	 
	 <c:if test="${role== 'USER'}">
	 
	        <div class="mainbody-section text-center" >
            <div class="container">
                <div class="row">
                    
                    <div class="col-md-3">
                        
                        <div class="menu-item blue">
                            <a href="type.vms"  >
                                <i class="fa fa-magic"></i>
                                <p>Add Vendor</p>
                            </a>
                        </div>
                        
                        <div class="menu-item green">
                            <a href="typevendor.vms"  >
                                <i class="fa fa-file-photo-o"></i>
                                <p>Add Vendor type</p>
                            </a>
                        </div>
                        
<!--                         <div class="menu-item light-red">
                            <a href="search.jsp"  >
                                <i class="fa fa-user"></i>
                                <p>Search vendor</p>
                            </a>
                        </div>
 -->                        
                    </div>
                    
                    <div class="col-md-6">
                        
                        <!-- Start Carousel Section -->
                        <div class="home-slider">
                            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="padding-bottom: 30px;">
                                <!-- Indicators -->
                                <ol class="carousel-indicators">
                                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                                </ol>

                                <!-- Wrapper for slides -->
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <img src="../images/111.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="item">
                                        <img src="../images/112.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="item">
                                        <img src="../images/6.jpg" class="img-responsive" alt="">
                                    </div>

                                </div>

                            </div>
                        </div>
                        <!-- Start Carousel Section -->
                        
                        <div class="row">
                         
                            <div class="col-md-12">
                                <div class="menu-item color responsive">
                                    <a href="search_v">
                                        <i class="fa fa-search"></i>
                                        <p>Search Vendor</p>
                                    </a>
                                </div>
                            </div>
                            
                            <!-- <div class="col-md-6">
                                <div class="menu-item light-orange responsive-2">
                                    <a href="#team-modal" data-toggle="modal">
                                        <i class="fa fa-users"></i>
                                        <p>Team</p>
                                    </a>
                                </div>
                            </div>
 -->                            
                        </div>
                        
                    </div>
                    
                    <div class="col-md-3">
                        
                        <div class="menu-item light-red">
                            <a href="allvendors?pagenumber=1&page=first">
                                <i class="fa fa-envelope-o"></i>
                                <p>All Vendor</p>
                            </a>
                        </div>
                        
                        <div class="menu-item color">
                            <a href="billes.vms">
                                <i class="fa fa-comment-o"></i>
                                <p>Uploading Bills</p>
                            </a>
                        </div>
                        
<!--                         <div class="menu-item blue">
                            <a href="http:www.youtub.com/todaynews" data-toggle="modal">
                                <i class="fa fa-mortar-board"></i>
                                <p>Latest News</p>
                            </a>
                        </div>
 -->                        
                    </div>
                </div>
            </div>
        </div>
	<br>
	<br>
	<%@ include file="footer.jsp"%>
	</c:if>
	 <c:if test="${role == 'ADMIN'}">
	 <div class="mainbody-section text-center">
		<div class="container">
			<div class="row">

				<div class="col-md-3">

					<div class="menu-item blue">
						<a href="../admin/a_type_a"> <i class="fa fa-magic"></i>
							<p>Add Vendor</p>
						</a>
					</div>

                        <div class="menu-item red">
						<a href="../admin/addBank.vms"> <i class="fa  fa-road"></i>
							<p>Add new vendor Bank Details</p>
						</a>
					</div>

					<div class="menu-item light-red">
						<a href="../admin/v_search"> <i class="fa fa-search"></i>
							<p>Search vendor</p>
						</a>
					</div>
					
				</div>

				<div class="col-md-6">

					<!-- Start Carousel Section -->
					<div class="home-slider">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel" style="padding-bottom: 30px;">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>

							<!-- Wrapper for slides -->
							<div class="carousel-inner">
								<div class="item active">
									<img src="../images/1001.jpg" class="img-responsive" alt="">
								</div>
								<div class="item">
									<img src="../images/765.jpg" height="500px" width="330px"
										class="img-responsive" alt="">
								</div>
								<div class="item">
									<img src="../images/6.jpg" class="img-responsive" alt="">
								</div>

							</div>

						</div>
					</div>
					<!-- Start Carousel Section -->

					<div class="row">
						 

						<div class="col-md-12">
							<div class="menu-item light-orange responsive-2">
								<a href="../admin/reporting.vms"> <i class="fa fa-refresh fa-spin"></i>
									<p>Reporting</p>
								</a>
							</div>
						</div>

					</div>

				</div>

				<div class="col-md-3">

					<div class="menu-item light-red">
						<a href="../admin/billes.vms"> <i class="fa fa-comment-o"></i>
							<p>Upload Bills</p>
						</a>
					</div>

					<div class="menu-item color">
						<a href="../admin/adduser.vms"> <i class=" fa fa-money"></i>
							<p>Adding New User</p>
						</a>
					</div>
					<div class="menu-item green">
						<a href="../admin/typevendor"> <i class="fa fa-file-photo-o"></i>
							<p>Add Vendor type</p>
						</a>
					</div>


				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<%@ include file="footer.jsp"%>
	 </c:if>
	 <div class="container">
	<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-10">
	  <c:if test="${role eq null }">
	 <h1 style="color: red;"> Sorry!</h1><h1 style="color: blue;">${name }</h1> <h1 style="color: red;">your not authorization member to access <br> 
	 Please Logout......</h1>
	 </c:if>
	
	
	</div>
	
	</div>
	 
	 </div>
	
	 
	 
</body>
</html>