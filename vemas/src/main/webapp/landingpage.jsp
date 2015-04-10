<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Landing page</title>
<script type="text/javascript"
	src="http://docs/docs/jquery_json/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="http://docs/docs/References/08_Bootstrap/bootstrap-3.3.1-dist/dist/js/bootstrap.min.js">
	
</script>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/landingpage.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Font Awesome CSS -->
        <link href="css/font-awesome.min.css" rel="stylesheet">
		
		<!-- Custom CSS -->
        <link href="css/animate.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/style.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>


        <!-- Template js -->
        <script src="js/jquery-2.1.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="js/jquery.appear.js"></script>
        <script src="js/contact_me.js"></script>
        <script src="js/jqBootstrapValidation.js"></script>
        <script src="js/modernizr.custom.js"></script>
        <script src="js/script.js"></script>

<style type="text/css">
#search {
	margin-left: 19%;
	width: 66%;
}
</style>
</head>
<body>

	<%@ include file="header.jsp"%>
	<ol class="breadcrumb">
		<li class="active">Home</li>
	</ol>
	        <div class="mainbody-section text-center">
            <div class="container">
                <div class="row">
                    
                    <div class="col-md-3">
                        
                        <div class="menu-item blue">
                            <a href="addvendor.jsp"  >
                                <i class="fa fa-magic"></i>
                                <p>Add Vendor</p>
                            </a>
                        </div>
                        
                        <div class="menu-item green">
                            <a href="#portfolio-modal"  >
                                <i class="fa fa-file-photo-o"></i>
                                <p>Add Vendor type</p>
                            </a>
                        </div>
                        
                        <div class="menu-item light-red">
                            <a href="search.jsp"  >
                                <i class="fa fa-user"></i>
                                <p>Search vendor</p>
                            </a>
                        </div>
                        
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
                                        <img src="images/4.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="item">
                                        <img src="images/5.jpg" class="img-responsive" alt="">
                                    </div>
                                    <div class="item">
                                        <img src="images/6.jpg" class="img-responsive" alt="">
                                    </div>

                                </div>

                            </div>
                        </div>
                        <!-- Start Carousel Section -->
                        
                        <div class="row">
                            <div class="col-md-6">
                                <div class="menu-item color responsive">
                                    <a href="#service-modal" data-toggle="modal">
                                        <i class="fa fa-area-chart"></i>
                                        <p>Services</p>
                                    </a>
                                </div>
                            </div>
                            
                            <div class="col-md-6">
                                <div class="menu-item light-orange responsive-2">
                                    <a href="#team-modal" data-toggle="modal">
                                        <i class="fa fa-users"></i>
                                        <p>Team</p>
                                    </a>
                                </div>
                            </div>
                            
                        </div>
                        
                    </div>
                    
                    <div class="col-md-3">
                        
                        <div class="menu-item light-red">
                            <a href="#contact-modal" data-toggle="modal">
                                <i class="fa fa-envelope-o"></i>
                                <p>Contact</p>
                            </a>
                        </div>
                        
                        <div class="menu-item color">
                            <a href="#testimonial-modal" data-toggle="modal">
                                <i class="fa fa-comment-o"></i>
                                <p>Testimonial</p>
                            </a>
                        </div>
                        
                        <div class="menu-item blue">
                            <a href="#news-modal" data-toggle="modal">
                                <i class="fa fa-mortar-board"></i>
                                <p>Latest News</p>
                            </a>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
	<br>
	<br>
	<%@ include file="footer.jsp"%>
</body>
</html>