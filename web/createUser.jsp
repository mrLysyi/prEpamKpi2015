<%-- 
    Document   : createUser
    Created on : May 31, 2015, 2:51:27 PM
    Author     : Lysyi Andrii <your.name at your.org>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registration</title>

    <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/freelancer.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">
    
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top">(\/)(O_o)(\/)</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="createUser.jsp" >Register new User</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#about">About</a>
                    </li>
                    <li class="page-scroll">
                        <a href="controller?command=logout">logout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
            
    <!-- Login Section -->
    <section id="login" style="padding-top: 150px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Registration</h2>
                    <hr class="star-primary">
                </div>
            </div>         
    
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <form  name="registration" method="POST" action="controller"> 
                        <input type="hidden" name="command" value="registration" />
                        
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>First Name</label>
                                <input class="form-control" placeholder="First Name" type="text" name="firstname" value="${firstname}">
                                <p class="help-block text-danger">${wrongData}</p>
                            </div>
                        </div>    
                            
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Last Name</label>
                                <input class="form-control" placeholder="Last Name" type="text" name="lastname" value="${lastname}" >
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>        
                        
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Patronymic</label>
                                <input class="form-control" placeholder="Patronymic" type="text" name="patronymic" value="${patronymic}" >
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>        
                            
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Password</label>
                                <input class="form-control" placeholder="Password" type="password" name="password" value="">
                                <p class="help-block text-danger">${pass12}</p>
                            </div>
                        </div>
                            
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Re-type password</label>
                                <input class="form-control" placeholder="Re-type passwors" type="password" name="password2" value="">
                            </div>
                        </div>
                            
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label> e-mail</label>
                                <input class="form-control" placeholder=" e-mail" type="mail" name="mail" value="${mail}" >
                                <p class="help-block text-danger">${emailError}</p>
                            </div>
                        </div>
                            
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>City</label>
                                <input class="form-control" placeholder="City" type="text" name="city" value="${city}"  >
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                            
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Country</label>
                                <input class="form-control" placeholder="Country" type="text" name="country" value="${country}" >
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>    
                            
                        <div class="row pull-right" style="margin-top: 25 px !important;">
                            <div class="form-group col-xs-12" style="margin-top: 25 px;">
                                <input type="submit" class="btn btn-success btn-lg" value="SUBMIT" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="text-center">        
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        Copyright &copy; Your Website 2014
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll visible-xs visible-sm">
        <a class="btn btn-primary" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>


    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>

    <script src="js/jqBootstrapValidation.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/freelancer.js"></script>

</body>

</html>

