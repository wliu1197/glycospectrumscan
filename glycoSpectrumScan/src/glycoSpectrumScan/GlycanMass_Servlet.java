package glycoSpectrumScan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GlycanMass_Servlet
 */
public class GlycanMass_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GlycanMass_Servlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selected = request.getParameter("Nglycans").toString();
		
		request.setAttribute("Number_of_glycans",selected);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("GlycanMass.jsp");
		if (dispatcher != null){

			  dispatcher.forward(request, response);

		} 
		
		
	}

}
