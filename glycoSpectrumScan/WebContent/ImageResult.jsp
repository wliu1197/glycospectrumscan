<%@ include file="Header.jsp" %>
<body >
	<%
	
	glyco_sequence gs = (glyco_sequence) request.getSession().getAttribute("gs");
	LinkedList <NewMass_GS> gs_NM=(LinkedList <NewMass_GS>)request.getSession().getAttribute("gs_NM");
	ArrayList <glycans> glycanss =  (ArrayList <glycans>)request.getSession().getAttribute("glycanss");
	
	String DataforSequence = request.getAttribute("DataforSequence").toString();
	
	//request.setAttribute("Data_for_Sequence", DataforSequence);
	//DataforSequence = request.getSession().getAttribute("Data_for_Sequence").toString();
	
	
	%>
	<a name=top></a>
	<div class="container">
	 <div align="left"><img src="img/logo.png" class="bg"></div>
	 	<div class="hero-unit">
	 		<h1>Generate Mass Spectrum</h1><br>
	<%
	
	double [] X_Axis =(double [])request.getAttribute("X_Axis");
	double [] Y_Axis =(double [])request.getAttribute("Y_Axis");
	ArrayList <String> images =(ArrayList <String>)request.getAttribute("images");
	%>
	
	<table id="Creat_table" border="0" cellpadding="20"  >
	
    <tr>
   	<td>
	 <a>Charge state for sequence: </a> <%=DataforSequence %> 		
	<br>
	<br>
	<form method="post" action="ChargeStateServlet"  onsubmit="return testRange(this);" >
		<% for(int i=0; i<X_Axis.length; i++){ %>
			<input type="hidden" name="X-Axis" value=<%=X_Axis[i]%>>
			<input type="hidden" name="Y-Axis" value=<%=Y_Axis[i]%>>
		<%} %>
			<input type="hidden" name="DataforSequence" value=<%=DataforSequence %>>
		
		
		<a> Select Charge State: </a> 
		<select  name="Charge_State" id="Charge_State"  style="width: 120px" >	
				<option value="all">1-4</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				
		</select><br><br>
		<a> Range:</a> <input type="text" name="Range" ><br><br>
		<input class="btn btn-primary btn-medium" type="submit" value="Get Result" /> 
	</form>
	</td>
	</tr>
	</table>
	
	<br> 	
	<a class="btn btn-small" href="GenerateImage.jsp"><i class="icon-circle-arrow-left "></i> Back </a><br>
	</div>
	<%if(request.getAttribute("ChargeState")!=null){
		
		String ChargeState = (String)request.getAttribute("ChargeState");
		String Range = (String)request.getAttribute("Range");
		double chargestateZ = 0;
		double [] chargestateZs={0.0,0.0,0.0,0.0};
		if(ChargeState.equals("all")){
			chargestateZs[0] = 1;
			chargestateZs[1] = 2;
			chargestateZs[2] = 3;
			chargestateZs[3] = 4;
		}else{
			 chargestateZ = Double.parseDouble(ChargeState);
		}
		
		double Ranges =0;
		%>
	
		<%
		if(!Range.equals("")){
		
		 Ranges =Double.parseDouble(Range);	
		}
		
				
				LinkedList <String> glyco_sequence = new LinkedList<String>();
				LinkedList <String> Combination = new LinkedList<String>();
				LinkedList <Double> m_mass = new  LinkedList<Double>();
				LinkedList <Double> a_mass = new  LinkedList<Double>();
				LinkedList <Double> for_X_axis =  new  LinkedList<Double>();
				LinkedList <Double> for_Y_axis =  new  LinkedList<Double>();
				LinkedList <Double> new_value = new LinkedList<Double>();
				int [] numberof_x_axis_for_each_z = {0,0,0,0};
				LinkedList <Double> Zs = new LinkedList<Double>();
				LinkedList <Double> for_X_axis_y_less_2 =new LinkedList <Double> ();
				LinkedList <Double> Combination_a_mass = new LinkedList <Double> ();
				
				
				
				if(chargestateZ == 0){
					for(double d_d: chargestateZs){
						
						 chargestateZ = d_d;
						
						 for(int i=0; i<gs_NM.size(); i++){
							
							 for(int j=0; j<gs_NM.get(i).new_m_mass.size(); j++){
								
								 for(int m=0; m<X_Axis.length; m++){
									 
								 
									 if( (gs_NM.get(i).new_a_mass.get(j)/chargestateZ )<  X_Axis[m]+Ranges && (gs_NM.get(i).new_a_mass.get(j)/chargestateZ ) > X_Axis[m]-Ranges){
											
										  if( gs.glyco_sequence.get(i).equals(DataforSequence)){
											
											glyco_sequence.add(gs.glyco_sequence.get(i));
											
											Combination.add(gs.Combination.get(i).Combination.get(j));
											
											
											
											m_mass.add(gs_NM.get(i).new_m_mass.get(j));
											
											a_mass.add(gs_NM.get(i).new_a_mass.get(j));
											
											
											for_X_axis.add(X_Axis[m]);
											
											for_Y_axis.add(Y_Axis[m]);
											
											if(Y_Axis[m]>=2){
											Combination_a_mass.add(gs.Combination.get(i).a_mass[j]);
											for_X_axis_y_less_2.add(X_Axis[m]);
											}
											
											new_value.add((gs_NM.get(i).new_a_mass.get(j)/chargestateZ ));
											
											Zs.add(chargestateZ);
											
											if(Y_Axis[m]>=2){
											numberof_x_axis_for_each_z[(int)(chargestateZ-1)] +=1;
											}
										  }
									 }
								}
							 }
						}
					}
					
						
				}else{
						for(int i=0; i<gs_NM.size(); i++){
								
							for(int j=0; j<gs_NM.get(i).new_m_mass.size(); j++){
								
								for(int m=0; m<X_Axis.length; m++){
								
								if( (gs_NM.get(i).new_a_mass.get(j)/chargestateZ )<  X_Axis[m]+Ranges && (gs_NM.get(i).new_a_mass.get(j)/chargestateZ ) > X_Axis[m]-Ranges){
									
									if( gs.glyco_sequence.get(i).equals(DataforSequence)){
										
										glyco_sequence.add(gs.glyco_sequence.get(i));
										
										Combination.add(gs.Combination.get(i).Combination.get(j));
											
										m_mass.add(gs_NM.get(i).new_m_mass.get(j));
										
										a_mass.add(gs_NM.get(i).new_a_mass.get(j));
										
										
										for_X_axis.add(X_Axis[m]);
										
										for_Y_axis.add(Y_Axis[m]);
										
										if(Y_Axis[m]>=2){
											for_X_axis_y_less_2.add(X_Axis[m]);
											Combination_a_mass.add(gs.Combination.get(i).a_mass[j]);
											}
										
										new_value.add((gs_NM.get(i).new_a_mass.get(j)/chargestateZ ));
										
										Zs.add(chargestateZ);
										
										if(Y_Axis[m]>=2){
										numberof_x_axis_for_each_z[(int)(chargestateZ-1)] +=1;
										}
									}
								}
							}
						}
					}
				}
			
				
				String states [] = new String[Combination.size()];
				for(int i=0; i<states.length; i++){
					states[i] ="(Charge States:";
				}
				for(int i=0; i<Combination.size(); i++){
					String combin = Combination.get(i);
					 for(int j=0; j<Combination.size(); j++){
						 if(combin.equals(Combination.get(j))){
							 if(!states[i].contains(Integer.toString(  Zs.get(j).intValue() ) )){
							 states[i] += (Integer.toString(Zs.get(j).intValue())+" ");
							 }
						 }
						 if(j==Combination.size()-1){
							 states[i] +=(")");
						 }
					 }
					
				}
				
				
				
			%>
			
		
			
			<%	
			if(glyco_sequence.size()!=0){	
			%>
				<div class="row">
					<div class="span12">
					 <a class="btn btn-small" href='#Bottom'><i class="icon-arrow-down"> </i>Go Bottom</a>
					
					<p align="center" style="font-size:30px;"> <a>Result</a>	
					<table class="table table-striped" align="center" id="Creat_table" border="1" cellpadding="10">
							<tr>
								<td>Glyco Sequence</td>
								<td>Combination</td>
								
								<td>Glycan Composition</td>
								<td>Monoisotopic mass</td>
								<td>Average mass</td>
								<td>X-axis</td>
								<td>Y-axis</td>
								<td>Mass / charge_state</td>
								<td>Range</td>
								<td>Charge State</td>
							</tr>
					
					<%
					
					DecimalFormat df = new DecimalFormat("#.##");
					for(int i=0;i<glyco_sequence.size();i++) {%>
						
							<tr>
								<td><%=glyco_sequence.get(i) %></td>
								<td><%=Combination.get(i) %><%=states[i] %></td>
								
								<% 
								String compositions="";
								
								String[] temp;
								
								String delimiter = " ";
								
								String Com=Combination.get(i);
								
								temp = Com.split(delimiter);
								
								int [] tempInt = new int[temp.length];
								
								int [] glyc=new int[8];
								
								for(int s=0; s<glyc.length; s++){
									glyc[s]=0;
								}
								
							    for(int s=0; s<temp.length;s++){
									
									tempInt[s]= Integer.parseInt(temp[s]);
									
									if(glycanss.get(tempInt[s]-1).Hexose!=0){
										glyc[0] += glycanss.get(tempInt[s]-1).Hexose;
									//	compositions += Integer.toString(glycanss.get(tempInt[s]-1).Hexose) +"-"+"Hexose <br>";
																		
									}
									if (glycanss.get(tempInt[s]-1).HexNAc!=0){
										glyc[1] += glycanss.get(tempInt[s]-1).HexNAc;
									//	compositions += Integer.toString(glycanss.get(tempInt[s]-1).HexNAc) +"-"+"HexNAc <br>";
									}
									if (glycanss.get(tempInt[s]-1).Deoxyhexose!=0){
										glyc[2] += glycanss.get(tempInt[s]-1).Deoxyhexose;
									//	compositions += Integer.toString(glycanss.get(tempInt[s]-1).HexNAc) +"-"+"HexNAc <br>";
									}
									if (glycanss.get(tempInt[s]-1).Pentose!=0){
										glyc[3] += glycanss.get(tempInt[s]-1).Pentose;
									//	compositions += Integer.toString(glycanss.get(tempInt[s]-1).HexNAc) +"-"+"HexNAc <br>";
									}
									if (glycanss.get(tempInt[s]-1).NeuAc!=0){
										glyc[4] += glycanss.get(tempInt[s]-1).NeuAc;
									//	compositions += Integer.toString(glycanss.get(tempInt[s]-1).HexNAc) +"-"+"HexNAc <br>";
									}
									if (glycanss.get(tempInt[s]-1).NeuGc!=0){
										glyc[5] += glycanss.get(tempInt[s]-1).NeuGc;
									//	compositions += Integer.toString(glycanss.get(tempInt[s]-1).HexNAc) +"-"+"HexNAc <br>";
									}
									if (glycanss.get(tempInt[s]-1).Phosphate!=0){
										glyc[6] += glycanss.get(tempInt[s]-1).Phosphate;
									//	compositions += Integer.toString(glycanss.get(tempInt[s]-1).HexNAc) +"-"+"HexNAc <br>";
									}
									if (glycanss.get(tempInt[s]-1).Sulphate!=0){
										glyc[7] += glycanss.get(tempInt[s]-1).Sulphate;
									//	compositions += Integer.toString(glycanss.get(tempInt[s]-1).HexNAc) +"-"+"HexNAc <br>";
									}
								}
							    if(glyc[0]!=0) compositions += Integer.toString(glyc[0]) +"-"+"Hexose <br>";
							    if(glyc[1]!=0) compositions += Integer.toString(glyc[1]) +"-"+"HexNAc <br>";
							    if(glyc[2]!=0) compositions += Integer.toString(glyc[2]) +"-"+"Deoxyhexose <br>";
							    if(glyc[3]!=0) compositions += Integer.toString(glyc[3]) +"-"+"Pentose <br>";
							    if(glyc[4]!=0) compositions += Integer.toString(glyc[4]) +"-"+"NeuAc <br>";
							    if(glyc[5]!=0) compositions += Integer.toString(glyc[5]) +"-"+"NeuGc <br>";
							    if(glyc[6]!=0) compositions += Integer.toString(glyc[6]) +"-"+"Phosphate <br>";
							    if(glyc[7]!=0) compositions += Integer.toString(glyc[7]) +"-"+"Sulphate <br>";
							    
							    
							    String MM = df.format(m_mass.get(i));
							    String AM = df.format(a_mass.get(i));
							    String XA = df.format(for_X_axis.get(i));
							    String YA = df.format(for_Y_axis.get(i));
								String NV = df.format(new_value.get(i));
								
								%>
							
								<td><%=compositions%></td>
								
								
								
								<td><%=MM %></td>
								<td><%=AM %></td>
								<td><%=for_X_axis.get(i) %></td>
								<td><%=for_Y_axis.get(i) %>
								<td><%=NV %></td>
								<td>(+/-)<%=Ranges %></td>
								<td><%=Zs.get(i) %></td>
								
							</tr>
						
					
					<% }%>
					</table>
			
			
			<a name=Bottom></a>
			
			<form  method="post" action="DrawImagesServlet" >
			
			
			<% if(request.getAttribute("ChargeState")!=null){
	    		
	    		%>
	    		<input type="hidden" name="ChargeState" value=<%=ChargeState%>>
	    		<input type="hidden" name="Range" value=<%=Range%>>
	    		
	    	<%	}%>
	    	<% for(int i=0; i<Combination_a_mass.size(); i++){ %>
	    		<input type="hidden" name="Combination_a_mass" value=<%=Combination_a_mass.get(i) %>>
	    	<%} %>
	    	<%	for(int i=0; i<X_Axis.length; i++){ %>
				<input type="hidden" name="X-Axis" value=<%=X_Axis[i]%>>
				<input type="hidden" name="Y-Axis" value=<%=Y_Axis[i]%>>
			<%} %>
				<%for(double d: for_X_axis_y_less_2) {%>
					<input type="hidden" name="for_X_axis" value=<%=d %>>
				<% }%>
				<% for(int i: numberof_x_axis_for_each_z){
					%>
						<input type="hidden" name="numberof_x_axis_for_each_z" value=<%=i %>>
					
				<%}%>
				 <input type="hidden" name="DataforSequence" value=<%=DataforSequence %>>
				<br>
				
				<p style="padding-left: 0px"><input class="btn btn-primary btn-medium" type="submit" value="Highlight" /> </p>
			 <a class="btn btn-small" href='#top'><i class="icon-arrow-up"> </i>Go Top</a>
			</form>	
			
			</div>
		</div>
	<%} %>
	
	<%}%><br>
	 
	<br>
		<footer>
        <p>&copy; Macquarie University 2012</p>
	</footer>
</div>
</body>
</html>