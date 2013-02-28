<%@ include file="Header.jsp" %>

<body>
	<%
	
	String message= (request.getAttribute("glycan_NoInDB").toString());
	
	
	%>
	<div class="container">
		<div align="left"><img src="img/logo.png" class="bg"></div>
		<div class="hero-unit">	
			<div class="alert alert-error">
			 <h4>Error!</h4>
				Input mass for Glycan number <%=message %> is incorrect or the composition corresponding to the input mass is undefined in the database !!!
			
			</div>
			
			
		<a class="btn btn-small" href="DirectlyInputGlycanMass.jsp"><i class="icon-circle-arrow-left "></i> Back </a><br>	
		</div>
	</div>
</body>