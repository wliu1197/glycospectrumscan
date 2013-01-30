package GenerateImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChargeStateServlet
 */
public class ChargeStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargeStateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] X_Axis_string =request.getParameterValues("X-Axis");	
		String[] Y_Axis_string =request.getParameterValues("Y-Axis");	
		String ChargeState =  request.getParameter("Charge_State");
		String Range = request.getParameter("Range");
		String DataforSequence= request.getParameter("DataforSequence"); 
		
		Range=Range.replaceAll("[^0-9\\.]", "");
	//	System.out.println(Range);
		
		double[] X_Axis = new double[X_Axis_string.length];
		double[] Y_Axis = new double[Y_Axis_string.length];
		
		
		for(int i=0;i<X_Axis_string.length; i++){
			X_Axis[i] = new Double(X_Axis_string[i]);
			Y_Axis[i] = new Double(Y_Axis_string[i]);
			
		}
		/* get all files name from folder */
		ArrayList <String> images = new ArrayList<String>(); 
		// C:\Users\wenhao\git\glyco\glycoSpectrumScan\WebContent\loadimages
		
		//File folder = new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages");
		File folder = new File("C:/Users/wenhao/git/glyco/glycoSpectrumScan/WebContent/loadimages");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  images.add(listOfFiles[i].getName().toString());
		       
		      } 
		}
		
		if(images.size()==0){
			images.add("No images in the system !!!");
		}
		
		
		request.setAttribute("X_Axis", X_Axis);
		request.setAttribute("Y_Axis", Y_Axis);
		request.setAttribute("images", images);
		request.setAttribute("ChargeState", ChargeState);
		request.setAttribute("Range", Range);
		request.setAttribute("DataforSequence", DataforSequence);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ImageResult.jsp");
		if (dispatcher != null){

			  dispatcher.forward(request, response);

		} 
		
	}

}
