<%@ include file="Header.jsp" %>


<body>
	<%
	ArrayList <glycans> gs  = (ArrayList <glycans>)request.getAttribute("glycanss");
	double total_monoisotopic_mass= new Double(request.getAttribute("total_monoisotopic_mass").toString());
	double total_average_mass= new Double(request.getAttribute("total_average_mass").toString());
	request.setAttribute("glycanss", gs);
	request.setAttribute("total_monoisotopic_mass", total_monoisotopic_mass);
	request.setAttribute("total_average_mass",total_average_mass);
	
	request.getSession().setAttribute("glycanss",gs);
	
	
	%>
		
	<div class="container">
	 <div align="left"><img src="img/logo.png" class="bg"></div>
	 	<div class="hero-unit">
	 	
	 			<h1>Glycan Mass Results</h1><br>
	 		<!-- <a>Total monoisotopic mass is:</a><%=total_monoisotopic_mass %><a>/Total average mass is:</a><%=total_average_mass %><br> -->	
			 	<table class="table table-striped" border='1' width="100%">
			 		<tr>
			 			<td><a>Glycan number</a></td>
			 			<td><a>Composition</a></td>
			 			<td><a>Total monoisotopic</a></td>
			 			<td><a>Total average</a></td>
			 		</tr>
			 		<%
			 		
			 		
			 		
			 		DecimalFormat df = new DecimalFormat("#.##");
			 		for(int i=0; i<gs.size();i++){
			 			String MM = df.format(gs.get(i).Monoisotopic_Mass);
			 			String AM = df.format(gs.get(i).Average_Mass);
			 			
			 			String composition="";
			 			if(gs.get(i).Hexose!=0) composition += String.valueOf(gs.get(i).Hexose)+"-Hexose"+" <br>"; 
			 			if(gs.get(i).HexNAc!=0) composition += String.valueOf(gs.get(i).HexNAc)+"-HexNAc"+" <br>"; 
			 			if(gs.get(i).Deoxyhexose!=0) composition += String.valueOf(gs.get(i).Deoxyhexose)+"-Deoxyhexose"+" <br>"; 
			 			if(gs.get(i).Pentose!=0) composition += String.valueOf(gs.get(i).Pentose)+"-Pentose"+" <br>"; 
			 			if(gs.get(i).NeuAc!=0) composition += String.valueOf(gs.get(i).NeuAc)+"-NeuAc"+" <br>"; 
			 			if(gs.get(i).NeuGc!=0) composition += String.valueOf(gs.get(i).NeuGc)+"-NeuGc"+" <br>"; 
			 			if(gs.get(i).Phosphate!=0) composition += String.valueOf(gs.get(i).Phosphate)+"-Phosphate"+" <br>"; 
			 			if(gs.get(i).Sulphate!=0) composition += String.valueOf(gs.get(i).Sulphate)+"-Sulphate"+" <br>"; 
			 			
			 			
			 		
			 		%>
			 		<tr>
			 			<td><%=i+1 %></td>
			 			<td><%=composition %></td>
			 			<td><%=MM %></td>
			 			<td><%=AM %></td>
			 		
			 			
			 			
			 		</tr>
			 		<%} %>
			 	</table><br>
			
			
	 <br>
	<jsp:include page="ProteinSequence.jsp" flush="true" />

</body>
</html>