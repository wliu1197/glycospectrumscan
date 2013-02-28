<%@ include file="Header.jsp" %>
<body>
	<div class="container">
	<div align="left"><img src="img/logo.png" class="bg"></div>
		<div class="hero-unit">
			<%
				PeptideMass PM = (PeptideMass)request.getAttribute("PeptideMass");
				
				glyco_sequence gs = (glyco_sequence)request.getAttribute("glyco_sequence");
				LinkedList <NewMass_GS> gs_NM=(LinkedList <NewMass_GS>)request.getAttribute("gs_NM");
				
				String ProteinSequence=(String)request.getAttribute("ProteinSequence");
				String No_glycans=(String)request.getAttribute("Num_Glycans");
				int [] MC =(int [])request.getAttribute("MC");
				double total_monoisotopic_mass= new Double(request.getAttribute("total_monoisotopic_mass").toString());
				double total_average_mass= new Double(request.getAttribute("total_average_mass").toString());
				if(No_glycans.equals("")){
					No_glycans ="0";
				}
				
				request.getSession().setAttribute("gs",gs);
				request.getSession().setAttribute("gs_NM",gs_NM);
				
			%>
		
			
			<a>Input Sequence is : </a><br>
			<% for(int i=0; i<ProteinSequence.length();i++){ 
				String oneLetter =String.valueOf(ProteinSequence.charAt(i));%>
				<%=oneLetter%>
			<% }%><br>
			<a>GlycoSequences are: </a> <br>
				
				<% for(int i=0; i<gs.glyco_sequence.size();i++){ %>
				 
				<%=gs.glyco_sequence.get(i) %>  <br>
				<a>Glycosylation_site(k) is: </a><%=gs.Glycosylation_site[i] %><br>
				<a>Number of glycans is:</a><%=No_glycans %><br>
				
				
				<a>Possible combinations (C) is:</a><%=gs.Possible_Combination_C[i] %><br>					
				<%} %>
			<!--
				<a>Total glycan monoisotopic mass is:</a><%=total_monoisotopic_mass %><br>
				<a>Total glycan average mass is:</a><%=total_average_mass %><br>
			 -->	
			
			
			<% 
				DecimalFormat df = new DecimalFormat("#.##");
				String AMm = df.format(PM.total_average_mass);
				String MMm = df.format(PM.total_monoisotopic_mass);
			
			%>
			<a>Theoretical pI: 3.42 / Mw (average mass): </a><%=AMm %>
			<a> / Mw (monoisotopic mass): </a><%=MMm %><br>
			
			
			<table class="table table-striped" id="table" border="1" width="100%">
				<tr>
					<td><a>peptide sequence</a></td>
					<td><a>#MC</a></td>
					<td><a>Average mass</a></td>
					<td><a>Monoisotopic mass</a></td>
			<!--  	<td><a>Average mass with Glycan</a></td>
					<td><a>Monoisotopic mass with Glycan</a></td> -->
				</tr>
				
					<%
					String error= "Wrong input from protein sequence page";
					for(int i=0; i<PM.ProteinSequenceSplit.size(); i++){
					
					
					String AM = df.format(PM.average_mass[i]);
					String MM = df.format(PM.monoisotopic_mass[i]);
					
					
					%>
				<tr>
				
					<% if(PM.ProteinSequenceSplit.get(i).equals("")){%>
					  <td> <%=error %></td>
						
					<%}else{%>
					
					<td><%=PM.ProteinSequenceSplit.get(i) %></td>
					<% }%>
					<td><%=MC[i] %></td>
					<td><%=AM %></td>
					<td><%=MM %></td>
				
			<!--  	<%
						int check = 0;
						 
							for(int j=0; j<gs.glyco_sequence.size(); j++){
								if(gs.glyco_sequence.get(j).equals(PM.ProteinSequenceSplit.get(i))){
									double Average_mass_with_Glycan =0;
									double Monoisotopic_mass_with_Glycan=0;
									Average_mass_with_Glycan = PM.average_mass[i] + gs.Possible_Combination_C[j]*total_average_mass;
									Monoisotopic_mass_with_Glycan = PM.monoisotopic_mass[i] + gs.Possible_Combination_C[j]*total_monoisotopic_mass;
									if(Average_mass_with_Glycan == PM.average_mass[i] ||  Monoisotopic_mass_with_Glycan == PM.monoisotopic_mass[i]) break;
									check ++;
									
								%>
								<td><%=Average_mass_with_Glycan%></td>
								<td><%=Monoisotopic_mass_with_Glycan%></td>
								<%  
								}
								%>	
								
						  <%}
						%>
				  <% if(check == 0){ %>
					<td>no change</td>
					<td>no change</td>  
					
				<% 	}%>
					
					-->
					
				</tr>
					<%} %>
			</table>
			
		<!--  <a href=".\upload\Result.txt" target="_blank">Download new mass result for GlycoSequences</a><br>	<br>-->	
			<div align="right">
			<a class="btn btn-small" href="GenerateImage.jsp"><i class="icon-circle-arrow-right "></i> Mass Spectrum </a><br>
			</div>
			</div>
		
		
		<div class="row">
		<div class="span12">	
		<!--  
		<% for(int i=0; i<gs_NM.size(); i++){ %>
		
			<a>Mass adding to: </a> <%=gs.glyco_sequence.get(i) %></a><br>
			<%for(int j=0; j<gs_NM.get(i).new_m_mass.size(); j++){ %>	
				<%=gs.Combination.get(i).Combination.get(j)%> <a>Combination Average_mass </a><%=gs.Combination.get(i).a_mass[j] %>  <a>: New Monoisotopic mass:</a> <%=gs_NM.get(i).new_m_mass.get(j)%> <a>New Average mass:</a> <%=gs_NM.get(i).new_a_mass.get(j)%> <br> 
			<%} %>
		<%} %>
		-->
		</div>
		
	</div>
	<br>
		<footer>
        <p>&copy; Macquarie University 2012</p>
		</footer>
	</div>
	
</body>
</html>