<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*" import= "Amino_acids.*" import="glycoSpectrumScan.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

<script src="js/jquery-1.8.2.min.js"></script>
	
<!-- Tooltip -->	
	<script src="tooltip/tooltip.js" type="text/javascript"></script>
    <link href="tooltip/tooltip.css" rel="stylesheet" type="text/css" />
   
    

<script src="js/bootstrap.min.js"></script>
<script src="js/CheckProteinSequenceInput.js" type="text/javascript"></script>
<script src="add_delectRow.js" type="text/javascript"></script>

<link href="css/bootstrap.css" rel="stylesheet">

 <style type="text/css">
      body {
      	
        padding-top: 60px;
        padding-bottom: 40px;
      }
</style>
<link href="css/bootstrap-responsive.css" rel="stylesheet">

<title>Insert title here</title>

</head>
<div class="navbar navbar-inverse navbar-fixed-top">
	 <div class="navbar-inner">
	 	<div class="container">
		 	<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	        </a>
	        <a class="brand" href="#">GlycoSpectrumScan</a>  
	        <div class="nav-collapse collapse">
	        	<ul class="nav">
	        		<li class="active"><a href="#"><i class="icon-home icon-white"></i>Home</a></li>
	        		<li><a href="ProteinSequence.jsp">PeptideMass</a></li>
	        		<li><a href="GlycanMass.jsp">GlycanMass</a></li>
	        	</ul>
	        	<form class="navbar-search pull-right">
  				<input type="text" class="search-query" placeholder="Search">
				</form>
	        	<ul class="nav pull-right" >
	        	   <li class="dropdown">
	        	   	<a href ="#" class="dropdown-toggle" data-toggle="dropdown">Utility<b class="caret"></b></a>	
	        		 <ul class="dropdown-menu">
	        			<li><a href="#">link1	</a></li>
	        			<li><a href="#">link1	</a></li>
	        		 </ul>
	        	   </li>	
	        	</ul>
	        </div>
	 	</div>
	 </div>
	 
</div>