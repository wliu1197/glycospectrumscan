package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.util.*;
import Amino_acids.*;
import glycoSpectrumScan.*;

public final class ImageResult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/Header.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write(" \t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/jquery-1.8.2.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"js/CheckProteinSequenceInput.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"add_delectRow.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"css/bootstrap-responsive.css\" media=\"screen\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/stylesnewlayout.css\" media=\"screen\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/bootstrapnewlayout.css\" media=\"screen\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/bootstrap.css\" media=\"screen\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <style type=\"text/css\">\r\n");
      out.write("  \r\n");
      out.write("\timg.bg {\r\n");
      out.write("\t    width: 30%;\r\n");
      out.write("\t    }\r\n");
      out.write("      body {\r\n");
      out.write("      \r\n");
      out.write("      \tbackground: url(\"img/background7.jpg\") no-repeat;\r\n");
      out.write("\t\tbackground-size: 100%;\r\n");
      out.write("      \r\n");
      out.write("        padding-top: 60px;\r\n");
      out.write("        padding-bottom: 40px;\r\n");
      out.write("     \r\n");
      out.write("      }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>GlycoSpectrumScan</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <div class=\"topbar\">\r\n");
      out.write("    <div class=\"topbar-inner\">\r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("        <a class=\"brand\" href=\"#\">GlycoSpectrumScan</a>\r\n");
      out.write("       \r\n");
      out.write("  \r\n");
      out.write("        <ul class=\"nav\">\r\n");
      out.write("          <li class=\"active\"><a href=\"GlycanMass.jsp\"><i class=\"icon-home icon-white\"></i>Home</a></li>\r\n");
      out.write("\t\t  <li><a href=\"GlycanMass.jsp\">GlycanMass</a></li> \r\n");
      out.write("\t\t  <li><a href=\"ProteinSequence.jsp\">PeptideMass</a></li> \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"headersearch\" class=\"pull-right\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t          <li><a href=\"#\">About</a></li>\r\n");
      out.write("\t\t          <li><a href=\"#\">Contact</a></li>\r\n");
      out.write("\t\t        </ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body >\r\n");
      out.write("\t");

	
	glyco_sequence gs = (glyco_sequence) request.getSession().getAttribute("gs");
	LinkedList <NewMass_GS> gs_NM=(LinkedList <NewMass_GS>)request.getSession().getAttribute("gs_NM");
	ArrayList <glycans> glycanss =  (ArrayList <glycans>)request.getSession().getAttribute("glycanss");
	
	String DataforSequence = request.getAttribute("DataforSequence").toString();
	
	//request.setAttribute("Data_for_Sequence", DataforSequence);
	//DataforSequence = request.getSession().getAttribute("Data_for_Sequence").toString();
	
	
	
      out.write("\r\n");
      out.write("\t<a name=top></a>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t <div align=\"left\"><img src=\"img/logo.png\" class=\"bg\"></div>\r\n");
      out.write("\t \t<div class=\"hero-unit\">\r\n");
      out.write("\t \t\t<h1>Generate Mass Spectrum</h1><br>\r\n");
      out.write("\t");

	
	double [] X_Axis =(double [])request.getAttribute("X_Axis");
	double [] Y_Axis =(double [])request.getAttribute("Y_Axis");
	ArrayList <String> images =(ArrayList <String>)request.getAttribute("images");
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<table id=\"Creat_table\" border=\"0\" cellpadding=\"20\"  >\r\n");
      out.write("\t\r\n");
      out.write("    <tr>\r\n");
      out.write("   \t<td>\r\n");
      out.write("\t <a>Charge state for sequence: </a> ");
      out.print(DataforSequence );
      out.write(" \t\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<form method=\"post\" action=\"ChargeStateServlet\"  onsubmit=\"return testRange(this);\" >\r\n");
      out.write("\t\t");
 for(int i=0; i<X_Axis.length; i++){ 
      out.write("\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"X-Axis\" value=");
      out.print(X_Axis[i]);
      out.write(">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"Y-Axis\" value=");
      out.print(Y_Axis[i]);
      out.write(">\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"DataforSequence\" value=");
      out.print(DataforSequence );
      out.write(">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<a> Select Charge State: </a> \r\n");
      out.write("\t\t<select  name=\"Charge_State\" id=\"Charge_State\"  style=\"width: 120px\" >\t\r\n");
      out.write("\t\t\t\t<option value=\"all\">1-4</option>\r\n");
      out.write("\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t</select><br><br>\r\n");
      out.write("\t\t<a> Range:</a> <input type=\"text\" name=\"Range\" ><br><br>\r\n");
      out.write("\t\t<input class=\"btn btn-primary btn-medium\" type=\"submit\" value=\"Get Result\" /> \r\n");
      out.write("\t</form>\r\n");
      out.write("\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<br> \t\r\n");
      out.write("\t<a class=\"btn btn-small\" href=\"GenerateImage.jsp\"><i class=\"icon-circle-arrow-left \"></i> Back </a><br>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
if(request.getAttribute("ChargeState")!=null){
		
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
		
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t");

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
				
				
				
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
	
			if(glyco_sequence.size()!=0){	
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"span12\">\r\n");
      out.write("\t\t\t\t\t <a class=\"btn btn-small\" href='#Bottom'><i class=\"icon-arrow-down\"> </i>Go Bottom</a>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<p align=\"center\" style=\"font-size:30px;\"> <a>Result</a>\t\r\n");
      out.write("\t\t\t\t\t<table class=\"table table-striped\" align=\"center\" id=\"Creat_table\" border=\"1\" cellpadding=\"10\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Glyco Sequence</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Combination</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Glycan Composition</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Monoisotopic mass</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Average mass</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>X-axis</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Y-axis</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Mass / charge_state</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Range</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Charge State</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");

					
					DecimalFormat df = new DecimalFormat("#.##");
					for(int i=0;i<glyco_sequence.size();i++) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(glyco_sequence.get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(Combination.get(i) );
      out.print(states[i] );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 
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
								
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(compositions);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(MM );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(AM );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(for_X_axis.get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(for_Y_axis.get(i) );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(NV );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>(+/-)");
      out.print(Ranges );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(Zs.get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
 }
      out.write("\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<a name=Bottom></a>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<form  method=\"post\" action=\"DrawImagesServlet\" >\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
 if(request.getAttribute("ChargeState")!=null){
	    		
	    		
      out.write("\r\n");
      out.write("\t    \t\t<input type=\"hidden\" name=\"ChargeState\" value=");
      out.print(ChargeState);
      out.write(">\r\n");
      out.write("\t    \t\t<input type=\"hidden\" name=\"Range\" value=");
      out.print(Range);
      out.write(">\r\n");
      out.write("\t    \t\t\r\n");
      out.write("\t    \t");
	}
      out.write("\r\n");
      out.write("\t    \t");
 for(int i=0; i<Combination_a_mass.size(); i++){ 
      out.write("\r\n");
      out.write("\t    \t\t<input type=\"hidden\" name=\"Combination_a_mass\" value=");
      out.print(Combination_a_mass.get(i) );
      out.write(">\r\n");
      out.write("\t    \t");
} 
      out.write("\r\n");
      out.write("\t    \t");
	for(int i=0; i<X_Axis.length; i++){ 
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"X-Axis\" value=");
      out.print(X_Axis[i]);
      out.write(">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"Y-Axis\" value=");
      out.print(Y_Axis[i]);
      out.write(">\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t");
for(double d: for_X_axis_y_less_2) {
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"for_X_axis\" value=");
      out.print(d );
      out.write(">\r\n");
      out.write("\t\t\t\t");
 }
      out.write("\r\n");
      out.write("\t\t\t\t");
 for(int i: numberof_x_axis_for_each_z){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"numberof_x_axis_for_each_z\" value=");
      out.print(i );
      out.write(">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t <input type=\"hidden\" name=\"DataforSequence\" value=");
      out.print(DataforSequence );
      out.write(">\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<p style=\"padding-left: 0px\"><input class=\"btn btn-primary btn-medium\" type=\"submit\" value=\"Highlight\" /> </p>\r\n");
      out.write("\t\t\t <a class=\"btn btn-small\" href='#top'><i class=\"icon-arrow-up\"> </i>Go Top</a>\r\n");
      out.write("\t\t\t</form>\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
}
      out.write("<br>\r\n");
      out.write("\t \r\n");
      out.write("\t<br>\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("        <p>&copy; Macquarie University 2012</p>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
