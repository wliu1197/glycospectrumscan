package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.util.*;
import Amino_acids.*;
import glycoSpectrumScan.*;

public final class GlycanMass_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <style type=\"text/css\">\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("      body {\r\n");
      out.write("      \t\r\n");
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
      out.write("\t\t<!--  <li><a href=\"GlycanMass.jsp\">GlycanMass</a></li> --> \r\n");
      out.write("\t\t  <li><a href=\"ProteinSequence.jsp\">PeptideMass</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<ul class=\"nav pull-right\" >\r\n");
      out.write("\t        \t   <li class=\"dropdown\">\r\n");
      out.write("\t        \t   \t<a href =\"#\"  data-toggle=\"dropdown\">GlycanMass<b class=\"caret\"></b></a>\t\r\n");
      out.write("\t        \t\t <ul class=\"dropdown-menu\">\r\n");
      out.write("\t        \t\t\t<li><a href=\"GlycanMass.jsp\">By glycan composition\t</a></li>\r\n");
      out.write("\t        \t\t\t<li><a href=\"DirectlyInputGlycanMass.jsp\">Directly input mass\t</a></li>\r\n");
      out.write("\t        \t\t </ul>\r\n");
      out.write("\t        \t   </li>\t\r\n");
      out.write("\t    </ul>\r\n");
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
      out.write("\t <div class=\"container\">\r\n");
      out.write("\t \r\n");
      out.write("\t \t<div class=\"hero-unit\">\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t\t<form action=\"GlycanMass_Servlet\" method=\"post\" name=\"TableForm\" >\r\n");
      out.write("\t \t\t\t<table id=\"Creat_table\" border=\"0\">\r\n");
      out.write("\t \t\t\t\t<tr>\r\n");
      out.write("\t \t\t\t\t\t<td>\r\n");
      out.write("\t \t\t\t\t\t<h1>Glycan Mass by composition</h1><br>\r\n");
      out.write("\t \t\t\t\t\tSelect the number of glycans for mass calculating: \r\n");
      out.write("\t \t\t\t\t\t<select  name=\"Nglycans\" id=\"Nglycans\" >\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"6\">6</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"7\">7</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"8\">8</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"9\">9</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"10\">10</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"11\">11</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"12\">12</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"13\">13</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"14\">14</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"15\">15</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"16\">16</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"17\">17</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"18\">18</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"19\">19</option>\r\n");
      out.write("\t \t\t\t\t\t\t<option value=\"20\">20</option>\r\n");
      out.write("\t \t\t\t\t\t</select>\r\n");
      out.write("\t \t\t\t\t\t<br>\r\n");
      out.write("\t \t\t\t\t\t<br><input class=\"btn btn-primary btn-medium\" type=\"submit\" value=\"Submit\">\r\n");
      out.write("\t \t\t\t\t\t</td>\r\n");
      out.write("\t \t\t\t\t</tr>\r\n");
      out.write("\t \t\t\t</table>\r\n");
      out.write("\t \t\t</form>\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t\t<br>\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t\t<table border=\"0\" >\r\n");
      out.write("\t \t\t<tr>\r\n");
      out.write("\t \t\t<td>\r\n");
      out.write("\t \t\t<a>Or import text file here:</a>   \r\n");
      out.write("\t \t\t</td>\r\n");
      out.write("\t \t\t<td  style=\"text-align: right; width: 500px\">\r\n");
      out.write("\t \t\t\r\n");
      out.write("        \t</td>\r\n");
      out.write("        \t</tr>\r\n");
      out.write("\t \t\t</table>\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t\t<form method=\"post\" action=\"GlycanMass_ImportServlet\"  enctype=\"multipart/form-data\">\r\n");
      out.write("\t \t\t\tSelect file to import: <input type=\"file\" name=\"dataFile\" id=\"fileChooser\" />\r\n");
      out.write("\t \t\t\t<a href=\".\\upload\\ExampleGlycanData123321.txt\" target=\"_blank\">Example data format</a><br>\t\r\n");
      out.write("\t \t\t\t\r\n");
      out.write("\t \t\t<!--  \r\n");
      out.write("\t \t\t\t<a href=\"#\" rel=\"tooltip\"  data-placement=\"right\" title=\"Example data format below:  <br />\r\n");
      out.write("\t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t         Glycan Number 1 <br />\r\n");
      out.write("\t \t\t\t\t\t\t\t\t\t\t\t \t\t\t\t\t\t Hexose\t5 \r\n");
      out.write("\t \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  HexNAc\t2\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t      Deoxyhexose\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Pentose\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  NeuAc\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  NeuGc\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Phosphate\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t  \t\t\t\t\t\t Sulphate\" ></a>\r\n");
      out.write("\t \t\t-->\t\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t\t\t\r\n");
      out.write("\t \t\t\t<br >\r\n");
      out.write("        \t\t<br > <input class=\"btn btn-primary btn-medium\" type=\"submit\" value=\"Import\" />\r\n");
      out.write("        \t\t\r\n");
      out.write("\t\r\n");
      out.write("\t \t\t</form>\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t</div>\r\n");
      out.write("\t \t");

	 	int Number_of_glycans =0;
	 	String Number_of_glycanss="";
	 	if( request.getAttribute("Number_of_glycans")!=null){
	 	Number_of_glycanss = request.getAttribute("Number_of_glycans").toString();
	 	Number_of_glycans=Integer.parseInt(Number_of_glycanss);
	 	}
	 	
	 	
      out.write("\r\n");
      out.write("\t \t<!-- row of columns -->\r\n");
      out.write("\t \t");
  int index =1;
	 		if(Number_of_glycans!=0){ 
      out.write("\r\n");
      out.write("\t \t\t<form action=\"GlycanMass_Calculate_Servlet\" method=\"post\" name=\"TableForm\">\r\n");
      out.write("\t \t\t");
for(;;){
	 		 if(Number_of_glycans==0)break;
	 		
      out.write("\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t \t\t <div class=\"row\">\r\n");
      out.write("\t \t\t\t\t");
for(int i=0; i<4; i++){
	 					if(Number_of_glycans==0)break;
      out.write("\r\n");
      out.write("\t \t\t\t\t\t\r\n");
      out.write("\t \t\t\t\t\t<div class=\"span3\">\r\n");
      out.write("\t \t\t\t\t\t<h2>Glycan_");
      out.print(index );
      out.write("</h2>\r\n");
      out.write("\t \t\t\t\t\t<table >\r\n");
      out.write("\t \t\t\t\t\t   <tr>\t\r\n");
      out.write("\t \t\t\t\t\t   \t<td><a>Number of Hexose(Hex):</a></td><td> <input type=\"text\"  style=\"width: 80px; height: 15px\" name=\"Hexose\" /></td>\r\n");
      out.write("\t \t\t\t\t\t   </tr>\t\r\n");
      out.write("\t \t\t\t\t\t   <tr>\t\r\n");
      out.write("\t \t\t\t\t\t   \t<td><a>Number of HexNAc:</a></td><td> <input type=\"text\"  style=\"width: 80px; height: 15px\" name=\"HexNAc\" /></td> \r\n");
      out.write("\t \t\t\t\t\t   </tr>\r\n");
      out.write("\t \t\t\t\t\t    <tr>\t\r\n");
      out.write("\t \t\t\t\t\t   \t<td><a>Number of Deoxyhexose:</a></td><td> <input type=\"text\"  style=\"width: 80px; height: 15px\" name=\"Deoxyhexose\" /></td> \r\n");
      out.write("\t \t\t\t\t\t   </tr>\r\n");
      out.write("\t \t\t\t\t\t    <tr>\t\r\n");
      out.write("\t \t\t\t\t\t   \t<td><a>Number of Pentose:</a></td><td> <input type=\"text\"  style=\"width: 80px; height: 15px\" name=\"Pentose\" /></td> \r\n");
      out.write("\t \t\t\t\t\t   </tr>\r\n");
      out.write("\t \t\t\t\t\t    <tr>\t\r\n");
      out.write("\t \t\t\t\t\t   \t<td><a>Number of NeuAc:</a></td><td> <input type=\"text\"  style=\"width: 80px; height: 15px\" name=\"NeuAc\" /></td> \r\n");
      out.write("\t \t\t\t\t\t   </tr>\r\n");
      out.write("\t \t\t\t\t\t    <tr>\t\r\n");
      out.write("\t \t\t\t\t\t   \t<td><a>Number of NeuGc:</a></td><td> <input type=\"text\"  style=\"width: 80px; height: 15px\" name=\"NeuGc\" /></td> \r\n");
      out.write("\t \t\t\t\t\t   </tr>\r\n");
      out.write("\t \t\t\t\t\t    <tr>\t\r\n");
      out.write("\t \t\t\t\t\t   \t<td><a>Number of Phosphate:</a></td><td> <input type=\"text\"  style=\"width: 80px; height: 15px\" name=\"Phosphate\" /></td> \r\n");
      out.write("\t \t\t\t\t\t   </tr>\r\n");
      out.write("\t \t\t\t\t\t    <tr>\t\r\n");
      out.write("\t \t\t\t\t\t   \t<td><a>Number of Sulphate:</a></td><td> <input type=\"text\"  style=\"width: 80px; height: 15px\" name=\"Sulphate\" /></td>\r\n");
      out.write("\t \t\t\t\t\t   </tr>\r\n");
      out.write("\t \t\t\t\t\t</table>\r\n");
      out.write("\t \t\t\t\t\t</div>\r\n");
      out.write("\t \t\t\t\t");
 Number_of_glycans--;
	 				   index++;} 
      out.write("\r\n");
      out.write("\t\t \t </div>\r\n");
      out.write("\t \t");
	}
      out.write("\r\n");
      out.write("\t \t\r\n");
      out.write("\t \t\t<br><input class=\"btn btn-primary btn-medium\" type=\"submit\" value=\"Calculate\"> \t\r\n");
      out.write("\t \t    </form>\r\n");
      out.write("\t \t");
} 
      out.write("\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("        <p>&copy; Macquarie University 2012</p>\r\n");
      out.write("\t </div>\r\n");
      out.write("\t \r\n");
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
