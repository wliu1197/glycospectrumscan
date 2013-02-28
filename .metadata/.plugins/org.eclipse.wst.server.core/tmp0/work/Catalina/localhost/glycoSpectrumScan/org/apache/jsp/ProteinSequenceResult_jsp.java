package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.util.*;
import Amino_acids.*;
import glycoSpectrumScan.*;

public final class ProteinSequenceResult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t<div align=\"left\"><img src=\"img/logo.png\" class=\"bg\"></div>\r\n");
      out.write("\t\t<div class=\"hero-unit\">\r\n");
      out.write("\t\t\t");

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
				
			
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<a>Input Sequence is : </a><br>\r\n");
      out.write("\t\t\t");
 for(int i=0; i<ProteinSequence.length();i++){ 
				String oneLetter =String.valueOf(ProteinSequence.charAt(i));
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(oneLetter);
      out.write("\r\n");
      out.write("\t\t\t");
 }
      out.write("<br>\r\n");
      out.write("\t\t\t<a>GlycoSequences are: </a> <br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 for(int i=0; i<gs.glyco_sequence.size();i++){ 
      out.write("\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t");
      out.print(gs.glyco_sequence.get(i) );
      out.write("  <br>\r\n");
      out.write("\t\t\t\t<a>Glycosylation_site(k) is: </a>");
      out.print(gs.Glycosylation_site[i] );
      out.write("<br>\r\n");
      out.write("\t\t\t\t<a>Number of glycans is:</a>");
      out.print(No_glycans );
      out.write("<br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<a>Possible combinations (C) is:</a>");
      out.print(gs.Possible_Combination_C[i] );
      out.write("<br>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t<!--\r\n");
      out.write("\t\t\t\t<a>Total glycan monoisotopic mass is:</a>");
      out.print(total_monoisotopic_mass );
      out.write("<br>\r\n");
      out.write("\t\t\t\t<a>Total glycan average mass is:</a>");
      out.print(total_average_mass );
      out.write("<br>\r\n");
      out.write("\t\t\t -->\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
 
				DecimalFormat df = new DecimalFormat("#.##");
				String AMm = df.format(PM.total_average_mass);
				String MMm = df.format(PM.total_monoisotopic_mass);
			
			
      out.write("\r\n");
      out.write("\t\t\t<a>Theoretical pI: 3.42 / Mw (average mass): </a>");
      out.print(AMm );
      out.write("\r\n");
      out.write("\t\t\t<a> / Mw (monoisotopic mass): </a>");
      out.print(MMm );
      out.write("<br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table class=\"table table-striped\" id=\"table\" border=\"1\" width=\"100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><a>peptide sequence</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a>#MC</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a>Average mass</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a>Monoisotopic mass</a></td>\r\n");
      out.write("\t\t\t<!--  \t<td><a>Average mass with Glycan</a></td>\r\n");
      out.write("\t\t\t\t\t<td><a>Monoisotopic mass with Glycan</a></td> -->\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");

					String error= "Wrong input from protein sequence page";
					for(int i=0; i<PM.ProteinSequenceSplit.size(); i++){
					
					
					String AM = df.format(PM.average_mass[i]);
					String MM = df.format(PM.monoisotopic_mass[i]);
					
					
					
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
 if(PM.ProteinSequenceSplit.get(i).equals("")){
      out.write("\r\n");
      out.write("\t\t\t\t\t  <td> ");
      out.print(error );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
}else{
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(PM.ProteinSequenceSplit.get(i) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t");
 }
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(MC[i] );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(AM );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(MM );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t<!--  \t");

						int check = 0;
						 
							for(int j=0; j<gs.glyco_sequence.size(); j++){
								if(gs.glyco_sequence.get(j).equals(PM.ProteinSequenceSplit.get(i))){
									double Average_mass_with_Glycan =0;
									double Monoisotopic_mass_with_Glycan=0;
									Average_mass_with_Glycan = PM.average_mass[i] + gs.Possible_Combination_C[j]*total_average_mass;
									Monoisotopic_mass_with_Glycan = PM.monoisotopic_mass[i] + gs.Possible_Combination_C[j]*total_monoisotopic_mass;
									if(Average_mass_with_Glycan == PM.average_mass[i] ||  Monoisotopic_mass_with_Glycan == PM.monoisotopic_mass[i]) break;
									check ++;
									
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(Average_mass_with_Glycan);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print(Monoisotopic_mass_with_Glycan);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
  
								}
								
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t  ");
}
						
      out.write("\r\n");
      out.write("\t\t\t\t  ");
 if(check == 0){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>no change</td>\r\n");
      out.write("\t\t\t\t\t<td>no change</td>  \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t");
 	}
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t-->\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<!--  <a href=\".\\upload\\Result.txt\" target=\"_blank\">Download new mass result for GlycoSequences</a><br>\t<br>-->\t\r\n");
      out.write("\t\t\t<div align=\"right\">\r\n");
      out.write("\t\t\t<a class=\"btn btn-small\" href=\"GenerateImage.jsp\"><i class=\"icon-circle-arrow-right \"></i> Mass Spectrum </a><br>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"span12\">\t\r\n");
      out.write("\t\t<!--  \r\n");
      out.write("\t\t");
 for(int i=0; i<gs_NM.size(); i++){ 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<a>Mass adding to: </a> ");
      out.print(gs.glyco_sequence.get(i) );
      out.write("</a><br>\r\n");
      out.write("\t\t\t");
for(int j=0; j<gs_NM.get(i).new_m_mass.size(); j++){ 
      out.write("\t\r\n");
      out.write("\t\t\t\t");
      out.print(gs.Combination.get(i).Combination.get(j));
      out.write(" <a>Combination Average_mass </a>");
      out.print(gs.Combination.get(i).a_mass[j] );
      out.write("  <a>: New Monoisotopic mass:</a> ");
      out.print(gs_NM.get(i).new_m_mass.get(j));
      out.write(" <a>New Average mass:</a> ");
      out.print(gs_NM.get(i).new_a_mass.get(j));
      out.write(" <br> \r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t-->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("        <p>&copy; Macquarie University 2012</p>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
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
