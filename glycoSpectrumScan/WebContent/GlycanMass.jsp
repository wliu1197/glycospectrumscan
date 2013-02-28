<%@ include file="Header.jsp" %>


<body>

		
		
		
	 	<div class="container">
	 	
		<div align="left"><img src="img/logo.png" class="bg"></div> 
	 	<ul class= "nav nav-tabs ">
				<li  class="active" ><a  href="GlycanMass.jsp">Glycan composition mass</a></li>
				<li><a   href="DirectlyInputGlycanMass.jsp">Directly input glycan mass</a></li>
			
		
		</ul>
	 	
	  
	 	<div class="hero-unit">
	 		
	 		<form  action="GlycanMass_Servlet" method="post" name="TableForm" >
	 			<table id="Creat_table" border="0">
	 				<tr>
	 					<td>
	 					<h1>Glycan Mass by composition</h1><br>
	 					Select the number of glycans for mass calculating: 
	 					<select  name="Nglycans" id="Nglycans" >
	 						<option value="1">1</option>
	 						<option value="2">2</option>
	 						<option value="3">3</option>
	 						<option value="4">4</option>
	 						<option value="5">5</option>
	 						<option value="6">6</option>
	 						<option value="7">7</option>
	 						<option value="8">8</option>
	 						<option value="9">9</option>
	 						<option value="10">10</option>
	 						<option value="11">11</option>
	 						<option value="12">12</option>
	 						<option value="13">13</option>
	 						<option value="14">14</option>
	 						<option value="15">15</option>
	 						<option value="16">16</option>
	 						<option value="17">17</option>
	 						<option value="18">18</option>
	 						<option value="19">19</option>
	 						<option value="20">20</option>
	 					</select>
	 					
	 					<input class="btn btn-primary btn-medium" type="submit" value="Submit">
	 					</td>
	 					
	 				</tr>
	 				
	 			</table>
	 		</form>
	 		
	 		
	 		<br>
	 		
	 		
	 		<table border="0" >
	 		<tr>
	 		<td>
	 		
	 		</td>
	 		<td  style="text-align: right; width: 500px">
	 		
        	</td>
        	</tr>
	 		</table>
	 		
	 		
	 		<form method="post" action="GlycanMass_ImportServlet"  enctype="multipart/form-data">
	 			Select file to import: <input type="file" name="dataFile" id="fileChooser" />
	 			<input class="btn btn-primary btn-medium" type="submit" value="Import" />
	 			<br>
	 			<br>
	 			<a href=".\upload\ExampleGlycanData123321.txt" target="_blank">Example data format</a><br>	
	 			
	 		<!--  
	 			<a href="#" rel="tooltip"  data-placement="right" title="Example data format below:  <br />
	 															         Glycan Number 1 <br />
	 											 						 Hexose	5 
	 																	  HexNAc	2
																	      Deoxyhexose	
																		  Pentose
																		  NeuAc
																		  NeuGc
																		  Phosphate	
												  						 Sulphate" ></a>
	 		-->	
	 		
	 			
	 			
	
	 		</form>
	 		
	 	</div>
	 	<%
	 	int Number_of_glycans =0;
	 	String Number_of_glycanss="";
	 	if( request.getAttribute("Number_of_glycans")!=null){
	 	Number_of_glycanss = request.getAttribute("Number_of_glycans").toString();
	 	Number_of_glycans=Integer.parseInt(Number_of_glycanss);
	 	}
	 	
	 	%>
	 	<!-- row of columns -->
	 	<%  int index =1;
	 		if(Number_of_glycans!=0){ %>
	 		<form action="GlycanMass_Calculate_Servlet" method="post" name="TableForm">
	 		<%for(;;){
	 		 if(Number_of_glycans==0)break;
	 		%>
	 		
	 		 <div class="row">
	 				<%for(int i=0; i<4; i++){
	 					if(Number_of_glycans==0)break;%>
	 					
	 					<div class="span3">
	 					<h2>Glycan_<%=index %></h2>
	 					<table >
	 					   <tr>	
	 					   	<td><a>Number of Hexose(Hex):</a></td><td> <input type="text"  style="width: 80px; height: 15px" name="Hexose" /></td>
	 					   </tr>	
	 					   <tr>	
	 					   	<td><a>Number of HexNAc:</a></td><td> <input type="text"  style="width: 80px; height: 15px" name="HexNAc" /></td> 
	 					   </tr>
	 					    <tr>	
	 					   	<td><a>Number of Deoxyhexose:</a></td><td> <input type="text"  style="width: 80px; height: 15px" name="Deoxyhexose" /></td> 
	 					   </tr>
	 					    <tr>	
	 					   	<td><a>Number of Pentose:</a></td><td> <input type="text"  style="width: 80px; height: 15px" name="Pentose" /></td> 
	 					   </tr>
	 					    <tr>	
	 					   	<td><a>Number of NeuAc:</a></td><td> <input type="text"  style="width: 80px; height: 15px" name="NeuAc" /></td> 
	 					   </tr>
	 					    <tr>	
	 					   	<td><a>Number of NeuGc:</a></td><td> <input type="text"  style="width: 80px; height: 15px" name="NeuGc" /></td> 
	 					   </tr>
	 					    <tr>	
	 					   	<td><a>Number of Phosphate:</a></td><td> <input type="text"  style="width: 80px; height: 15px" name="Phosphate" /></td> 
	 					   </tr>
	 					    <tr>	
	 					   	<td><a>Number of Sulphate:</a></td><td> <input type="text"  style="width: 80px; height: 15px" name="Sulphate" /></td>
	 					   </tr>
	 					</table>
	 					</div>
	 				<% Number_of_glycans--;
	 				   index++;} %>
		 	 </div>
	 	<%	}%>
	 	
	 		<br><input class="btn btn-primary btn-medium" type="submit" value="Calculate"> 	
	 	    </form>
	 	<%} %>
	 	
	
		<footer>
        <p>&copy; Macquarie University 2012</p>
	 </div>
	 
</body>
</html>