package GenerateImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadImagesServlet
 */
public class UploadImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private static final String UPLOAD_DIRECTORY = "C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages";
	    private static final int THRESHOLD_SIZE = 1024 * 1024 * 10; // 10MB
	    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	    private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	    
    public UploadImagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList <String> X_Axis_string2 = new ArrayList <String>();
		ArrayList <String> Y_Axis_string2= new ArrayList <String>();
		String[] X_Axis_string ;	
		String[] Y_Axis_string ;	
		double[] X_Axis; 
		double[] Y_Axis; 
		String DataforSequence="";
		if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            return;
        }
		 DiskFileItemFactory factory = new DiskFileItemFactory();
	     factory.setSizeThreshold(THRESHOLD_SIZE);
	     factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	     ServletFileUpload upload = new ServletFileUpload(factory);
	     upload.setFileSizeMax(MAX_FILE_SIZE);
	     upload.setSizeMax(REQUEST_SIZE);
	     String uploadPath = UPLOAD_DIRECTORY;
	     File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	     }
	        try {
	        	String ChargeState="";
	        	String Range="";
	        	 List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		            
		        	for (FileItem item : items) {
		        		if (item.isFormField()) {
			        		String fieldname = item.getFieldName();
			                String fieldvalue = item.getString();
			                if(fieldname.equals("X-Axis")){
			                	X_Axis_string2.add(fieldvalue);
			                }
			                if(fieldname.equals("Y-Axis")){
			                	Y_Axis_string2.add(fieldvalue);
			                }
			                if(fieldname.equals("ChargeState")){
			                	ChargeState +=fieldvalue;
			                }if(fieldname.equals("Range")){
			                	Range +=fieldvalue;
			                }if(fieldname.equals("DataforSequence")){
			                	DataforSequence = fieldvalue;
			                	
			                }
		        		}else{
		        			String fileName = new File(item.getName()).getName();
		        			if(fileName.equals("")) continue;
		                    String filePath = uploadPath + File.separator + fileName;
		                    File storeFile = new File(filePath);
		                    
		                    // saves the file on disk
		                    item.write(storeFile);
		                    
		        		}
		                
		        	}	        	
		        	
		        	X_Axis_string = new String [X_Axis_string2.size()];
		        	Y_Axis_string = new String [Y_Axis_string2.size()];
		        	for(int i=0; i<X_Axis_string2.size(); i++){
		        		X_Axis_string[i]=X_Axis_string2.get(i);
		        		Y_Axis_string[i]=Y_Axis_string2.get(i);
		        	}
		        	X_Axis = new double [X_Axis_string.length];
		    		Y_Axis = new double [Y_Axis_string.length];
		    		for(int i=0;i<X_Axis_string.length; i++){
		    			X_Axis[i] = new Double(X_Axis_string[i]);
		    			Y_Axis[i] = new Double(Y_Axis_string[i]);	
		    			
		    		}
	        	
	        	
	            // parses the request's content to extract file data
	      /* 
		    	List formItems = upload.parseRequest(request);
	           Iterator iter = formItems.iterator();
	             
	           
	            // iterates over form's fields
	            while (iter.hasNext()) {
	            	
	                FileItem item = (FileItem) iter.next();
	                // processes only fields that are not form fields
	                if (!item.isFormField()) {
	                    String fileName = new File(item.getName()).getName();
	                    String filePath = uploadPath + File.separator + fileName;
	                    File storeFile = new File(filePath);
	                    
	                    // saves the file on disk
	                    item.write(storeFile);
	                  }
	                
	            }
	           
	    	*/	
	            
	            /* get all files name from folder */
				ArrayList <String> images = new ArrayList<String>(); 
				File folder = new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages");
				File[] listOfFiles = folder.listFiles();
				for (int i = 0; i < listOfFiles.length; i++) {
				      if (listOfFiles[i].isFile()) {
				    	  images.add(listOfFiles[i].getName().toString());
				       
				      } 
				}
				if(images.size()==0){
					images.add("No images in the system !!!");
				}
				if(ChargeState.equals("")) ChargeState = null;
				if(Range.equals("")) Range=null;
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
	        
	        
	        
	        
	        } catch (Exception ex) {
	           
	        } 
	    	
	        
	}

}
