package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.util.*;
import Amino_acids.*;
import glycoSpectrumScan.*;

public final class GenerateImage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	
	glyco_sequence gs = (glyco_sequence) request.getSession().getAttribute("gs");
	LinkedList <NewMass_GS> gs_NM=(LinkedList <NewMass_GS>)request.getSession().getAttribute("gs_NM");
	
	
      out.write("\r\n");
      out.write(" <div class=\"container\">\r\n");
      out.write("\t \r\n");
      out.write("\t \t<div class=\"hero-unit\">\r\n");
      out.write("\t \t<h1>Mass Spectrum</h1><br><br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<p style=\"font-size:30px;\"> <a>Upload data here:</a></p><br><br>\t\r\n");
      out.write("\t\t\t\t<form method=\"post\" action=\"UploadServlet\" onsubmit=\"return testImportDataSet(this);\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t        Select file to upload: <input type=\"file\" name=\"dataFile\"\r\n");
      out.write("\t\t\t\t            id=\"fileChooser\" />\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<a href=\".\\upload\\ExampleChartData123321.txt\" target=\"_blank\">Example data format</a>   \r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t<br><br>   \r\n");
      out.write("\t\t\t\t<a>Selected for Sequence:</a>\r\n");
      out.write("\t\t\t\t<select  name=\"SelectedSequence\" id=\"SelectedSequence\" >\r\n");
      out.write("\t\t\t\t\t");
 for(int i=0; i<gs_NM.size(); i++){
      out.write("\r\n");
      out.write("\t\t\t\t\t\t <option value=");
      out.print(gs.glyco_sequence.get(i) );
      out.write('>');
      out.print(gs.glyco_sequence.get(i));
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t       \r\n");
      out.write("\t\t\t\t        <br /> <input class=\"btn btn-primary btn-medium\" type=\"submit\" value=\"Upload\" />\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"span12\">\t\r\n");
      out.write("\t\t<!--  \r\n");
      out.write("\t\t");
 for(int i=0; i<gs_NM.size(); i++){ 
      out.write("\r\n");
      out.write("\t\t\t<a>Mass adding to: </a> ");
      out.print(gs.glyco_sequence.get(i) );
      out.write("</a><br>\r\n");
      out.write("\t\t\t");
for(int j=0; j<gs_NM.get(i).new_m_mass.size(); j++){ 
      out.write("\t\r\n");
      out.write("\t\t\t\t");
      out.print(gs.Combination.get(i).Combination.get(j));
      out.write(" <a>: New Monoisotopic mass:</a> ");
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
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("        <p>&copy; Macquarie University 2012</p>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</div>\t\t\t    \r\n");
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
