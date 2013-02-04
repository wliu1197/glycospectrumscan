package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import java.util.*;
import Amino_acids.*;
import glycoSpectrumScan.*;

public final class ProteinSequence_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t\t\t");
 
				
				if(request.getAttribute("glycanss")!=null){
					ArrayList <glycans> gs  = (ArrayList <glycans>)request.getAttribute("glycanss");
				
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t  ");
} else{
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write(" \t\t<div class=\"container\">\r\n");
      out.write(" \t\r\n");
      out.write(" \t\t\t<div class=\"hero-unit\">\r\n");
      out.write(" \t");
} 
      out.write("\r\n");
      out.write(" \t\t\t\t<a href=\"#\" rel=\"tooltip\"  data-placement=\"right\" title=\"All whitespace, and  all characters different from letters are ignored\" >Please read me first</a>\r\n");
      out.write("\t\t\t\t\t<script>\r\n");
      out.write("\t \t\t\t\t\t$('[rel=\"tooltip\"]').tooltip('toggle');\r\n");
      out.write("\t \t\t\t\t\t$('[rel=\"tooltip\"]').tooltip('hide');\r\n");
      out.write("\t \t\r\n");
      out.write("\t \t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\t</script>\t\t\t\t\t\t\t  \t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"ProteinSequence_Servlet\" onsubmit=\"return CheckProteinSequenceInput(this);\" method=\"post\" name=\"TableForm\">\r\n");
      out.write("\t\t\t<table id=\"Creat_table\" border=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t<h1> PeptideMass</h1>\r\n");
      out.write("\t\t\t\t\t\t<a>Protein Sequence: </a> <p> </p><textarea id=\"ProteinSequence\" name=\"ProteinSequence\" style=\"height:200px;width:350px;\" cols=\"40\" rows=\"5\"></textarea> </br>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<a>with cysteines treated with: </a>\r\n");
      out.write("\t\t\t\t\t\t<select  name=\"Treat\" id=\"Treat\" >\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Nothing\">Nothing</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Lodoacetamid\">Lodoacetamid</option>\r\n");
      out.write("\t\t\t\t\t\t</select><br>\r\n");
      out.write("\t\t\t\t\t\t<a> Enzyme: </a> \r\n");
      out.write("\t\t\t\t\t\t<select  name=\"Enzyme\" id=\"Enzyme\" >\r\n");
      out.write("\t\t\t\t\t            <option value=\"Trypsin\">Trypsin</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"Trypsin_evenP\">Trypsin (C-term to K/R, even before P)</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"TrypsinH\">Trypsin (higher specificity)</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"Proteinase_K\">Proteinase K</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"LYS_C\">Lys C</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"LYS_N\">Lys N</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"CNBR\">CNBr</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"ARG_C\">Arg C</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"ASPN\">Asp N</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"ASPN_LYSC\">Asp N / Lys C</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"ASPN_NTERMINA_GLU\">Asp N + N-terminal Glu</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"ASPN_GLUC\">Asp N / Glu C (bicarbonate)</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"GLU_C_BICARBONATE\">Glu C (bicarbonate)</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"GLU_C_P\">Glu C (phosphate)</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"GLU_C_P_LYS_C\">Glu C (phosphate) + Lys C</option> \r\n");
      out.write("\t\t\t\t\t            <option value=\"MICROWAVE_A_F_A_H\">Microwave-assisted formic acid hydrolysis (C-term to D)</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"CHYMOTRYPSIN\">Chymotrypsin (C-term to F/Y/W/M/L, not before P, not after Y if P is C-term to Y)</option>\r\n");
      out.write("\t\t\t\t\t            <option\tvalue=\"CHYMOTRYPSIN_FYW\">Chymotrypsin (C-term to F/Y/W/, not before P, not after Y if P is C-term to Y)</option>\r\n");
      out.write("\t\t\t\t\t            <option\tvalue=\"TRYPSIN_CHYMOTRYPSIN\">Trypsin/Chymotrypsin (C-term to K/R/F/Y/W, not before P, not after Y if P is C-term to Y)</option>\r\n");
      out.write("\t\t\t\t\t            <option\tvalue=\"PEPSIN\">Pepsin (pH 1.3)</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"PEPSIN_PH_2\">Pepsin (pH > 2)</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"THERMOLYSIN\">Thermolysin</option>\r\n");
      out.write("\t\t\t\t\t    </select>\r\n");
      out.write("\t\t\t\t\t    <br>\r\n");
      out.write("\t\t\t\t\t    <a> Method: </a>\r\n");
      out.write("\t\t\t\t\t    <select  name=\"Method\" id=\"Method\" >\r\n");
      out.write("\t\t\t\t\t            <option value=\"M+H\">[M+H]^+</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"M\"> [M]</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"M-H\"> [M-H]^-</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"M+2H\"> [M+2H]^2+</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"M+3H\"> [M+3H]^3+</option>\r\n");
      out.write("\t\t\t\t\t    </select>\r\n");
      out.write("\t\t\t\t\t    <br>\r\n");
      out.write("\t\t\t\t\t    <a>Allow for </a> <select  name=\"missed_cleavages\" id=\"missed_cleavages\" >\r\n");
      out.write("\t\t\t\t\t            <option value=\"0\">0</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"1\">1</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"2\">2</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"3\">3</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"4\">4</option>\r\n");
      out.write("\t\t\t\t\t            <option value=\"5\">5</option>\r\n");
      out.write("\t\t\t\t\t    </select><a>missed cleavages.</a><br>\r\n");
      out.write("\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t    <br>\r\n");
      out.write("\t\t\t\t\t    ");
if(request.getAttribute("glycanss")!=null){ 
					    ArrayList <glycans> gs  = (ArrayList <glycans>)request.getAttribute("glycanss");
					   
					    double total_monoisotopic_mass= new Double(request.getAttribute("total_monoisotopic_mass").toString());
						double total_average_mass= new Double(request.getAttribute("total_average_mass").toString());
					   
					    
      out.write("\r\n");
      out.write("\t\t\t\t\t    <a>Number of glycans (n): </a>  ");
      out.print(gs.size());
      out.write(" <input type=\"hidden\" name=\"glycans\" value=");
      out.print(gs.size());
      out.write("> \r\n");
      out.write("\t\t\t\t\t    <input type=\"hidden\" name=\"total_monoisotopic_mass\" value=");
      out.print(total_monoisotopic_mass);
      out.write("> \r\n");
      out.write("\t\t\t\t\t    <input type=\"hidden\" name=\"total_average_mass\" value=");
      out.print(total_average_mass);
      out.write("> \r\n");
      out.write("\t\t\t\t\t    \t");
 for(int i=0; i<gs.size(); i++){
      out.write("\r\n");
      out.write("\t\t\t\t\t    \t\t <input type=\"hidden\" name=\"gs_monoisotopic_mass\" value=");
      out.print(gs.get(i).Monoisotopic_Mass);
      out.write(" > \r\n");
      out.write("\t\t\t\t\t    \t     <input type=\"hidden\" name=\"gs_average_mass\" value=");
      out.print( gs.get(i).Average_Mass);
      out.write("  >\r\n");
      out.write("\t\t\t\t\t    \t\t\r\n");
      out.write("\t\t\t\t\t    \t");
 }
      out.write("\r\n");
      out.write("\t\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t    ");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t    <a>Number of glycans (n): </a>  <input type=\"text\" name=\"glycans\" />\r\n");
      out.write("\t\t\t\t\t    <input type=\"hidden\" name=\"total_monoisotopic_mass\" > \r\n");
      out.write("\t\t\t\t\t    <input type=\"hidden\" name=\"total_average_mass\" > \r\n");
      out.write("\t\t\t\t\t    ");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t    <br><input class=\"btn btn-primary btn-small\" type=\"submit\" value=\"Submit\"><br>\r\n");
      out.write("\t\t\t\t\t    <br><br>\r\n");
      out.write("\t\t\t\t\t    <a class=\"btn btn-small\" href=\"GlycanMass.jsp\"><i class=\"icon-circle-arrow-left \"></i> Back </a><br>\r\n");
      out.write("\t\t\t\t   </td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<footer>\r\n");
      out.write("        <p>&copy; Macquarie University 2012</p>\r\n");
      out.write("\t</footer>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$('.some-class').tooltip({ selector: \"a\" });\r\n");
      out.write("</script>\r\n");
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
