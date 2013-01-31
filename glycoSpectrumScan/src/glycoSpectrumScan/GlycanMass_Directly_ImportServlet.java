package glycoSpectrumScan;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import Amino_acids.glycans;

/**
 * Servlet implementation class GlycanMass_Directly_ImportServlet
 */
public class GlycanMass_Directly_ImportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private static final String UPLOAD_DIRECTORY = "C:/Job/Milestones/glycoSpectrumScan/WebContent/upload";
	private static final String UPLOAD_DIRECTORY = "C:/Users/wenhao/git/glyco/glycoSpectrumScan/WebContent/upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    public GlycanMass_Directly_ImportServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = "";
		if (!ServletFileUpload.isMultipartContent(request)) {
	            // if not, we stop here
	            return;
	        }
	         
	        // configures some settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        factory.setSizeThreshold(THRESHOLD_SIZE);
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	         
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	        upload.setSizeMax(REQUEST_SIZE);
	         
	        // constructs the directory path to store upload file
	        String uploadPath = UPLOAD_DIRECTORY;
	        // creates the directory if it does not exist
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	        String theString = "";
	        try {
	            // parses the request's content to extract file data
	            List formItems = upload.parseRequest(request);
	            Iterator iter = formItems.iterator();
	             
	            // iterates over form's fields
	            while (iter.hasNext()) {
	                FileItem item = (FileItem) iter.next();
	                // processes only fields that are not form fields
	                if (!item.isFormField()) {
	                    String fileName = new File(item.getName()).getName();
	                    
	                    
	                    /*
	                     * Without save file to disk, read data directly. 
	                     */
	                    
	                    InputStreamReader reader = new InputStreamReader(item.getInputStream());
	                    StringWriter writer = new StringWriter();
	                    IOUtils.copy(reader, writer);
	                    theString = writer.toString();
	                   // System.out.println(theString);
	                   
	               
	                }
	                
	            }
	            
	         theString =theString.replaceAll("[\\t\\n\\r\\s]","-" );
	         theString =theString.replaceAll("--","-" );
	         
	         ArrayList <Double> M_M = new ArrayList<Double>();
		     ArrayList <Double> A_M = new ArrayList<Double>();
	         
	         String [] temp;
	         String delimiter="-";
	         temp = theString.split(delimiter);
	         
	        
	         for(int i=0; i<temp.length; i++){
	        	  
	        	  if( (i+1) %2==0){
	        		  A_M.add(     Double.parseDouble(temp[i]));
	        		//  System.out.println(i+": "+ Double.parseDouble(temp[i]));
	        	  }else{
	        		  M_M.add(Double.parseDouble(temp[i]));
	        	  }
	          }
	        
	         ArrayList <glycans> glycanss = new ArrayList();
	         for(int i=0; i<M_M.size(); i++){
	 			glycans g = new glycans();
	 			g.Monoisotopic_Mass = M_M.get(i);
	 			g.Average_Mass = A_M.get(i);
	 			glycanss.add(g);
	 		}
	        double total_monoisotopic_mass =0;
	 		double total_average_mass=0;
	 		for(glycans g: glycanss){
	 			total_monoisotopic_mass += g.Monoisotopic_Mass;
	 			total_average_mass +=g.Average_Mass;
	 			
	 		}
	 		request.setAttribute("total_monoisotopic_mass", total_monoisotopic_mass);
			request.setAttribute("total_average_mass", total_average_mass);
			request.setAttribute("glycanss",glycanss);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("GlycanMassResult.jsp");
			if (dispatcher != null){

				  dispatcher.forward(request, response);

			} 
	        
	        } catch (Exception ex) {
	           
	        }
	        
	        
	        
	}

}
