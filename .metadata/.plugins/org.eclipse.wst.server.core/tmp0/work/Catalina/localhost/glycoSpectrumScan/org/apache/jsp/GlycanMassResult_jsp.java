package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.util.*;
import Amino_acids.*;
import glycoSpectrumScan.*;

public final class GlycanMassResult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t");

	ArrayList <glycans> gs  = (ArrayList <glycans>)request.getAttribute("glycanss");
	double total_monoisotopic_mass= new Double(request.getAttribute("total_monoisotopic_mass").toString());
	double total_average_mass= new Double(request.getAttribute("total_average_mass").toString());
	request.setAttribute("glycanss", gs);
	request.setAttribute("total_monoisotopic_mass", total_monoisotopic_mass);
	request.setAttribute("total_average_mass",total_average_mass);
	
	request.getSession().setAttribute("glycanss",gs);
	
	
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t \r\n");
      out.write("\t \t<div class=\"hero-unit\">\r\n");
      out.write("\t \t\t\t<h1>Clycan Mass Results</h1><br>\r\n");
      out.write("\t \t\t<!-- <a>Total monoisotopic mass is:</a>");
      out.print(total_monoisotopic_mass );
      out.write("<a>/Total average mass is:</a>");
      out.print(total_average_mass );
      out.write("<br> -->\t\r\n");
      out.write("\t\t\t \t<table border='1' width=\"100%\">\r\n");
      out.write("\t\t\t \t\t<tr>\r\n");
      out.write("\t\t\t \t\t\t<td><a>Glycan number</a></td>\r\n");
      out.write("\t\t\t \t\t\t<td><a>Total monoisotopic</a></td>\r\n");
      out.write("\t\t\t \t\t\t<td><a>Total average</a></td>\r\n");
      out.write("\t\t\t \t\t</tr>\r\n");
      out.write("\t\t\t \t\t");

			 		DecimalFormat df = new DecimalFormat("#.####");
			 		for(int i=0; i<gs.size();i++){
			 			String MM = df.format(gs.get(i).Monoisotopic_Mass);
			 			String AM = df.format(gs.get(i).Average_Mass);
			 			
			 		
      out.write("\r\n");
      out.write("\t\t\t \t\t<tr>\r\n");
      out.write("\t\t\t \t\t\t<td>");
      out.print(i+1 );
      out.write("</td>\r\n");
      out.write("\t\t\t \t\t\t<td>");
      out.print(MM );
      out.write("</td>\r\n");
      out.write("\t\t\t \t\t\t<td>");
      out.print(AM );
      out.write("</td>\r\n");
      out.write("\t\t\t \t\t</tr>\r\n");
      out.write("\t\t\t \t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t \t</table><br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t <br>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "ProteinSequence.jsp", out, true);
      out.write("\r\n");
      out.write("\r\n");
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
