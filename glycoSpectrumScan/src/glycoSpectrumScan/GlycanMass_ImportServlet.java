package glycoSpectrumScan;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.*;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import Amino_acids.glycan_value;
import Amino_acids.glycan_value_list;
import Amino_acids.glycans;

/**
 * Servlet implementation class GlycanMass_ImportServlet
 */
public class GlycanMass_ImportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private static final String UPLOAD_DIRECTORY = "C:/Job/Milestones/glycoSpectrumScan/WebContent/upload";
	private static final String UPLOAD_DIRECTORY = "C:/Users/wenhao/git/glyco/glycoSpectrumScan/WebContent/upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
       
    
    public GlycanMass_ImportServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public int [] getValues(String output,String s,int length){
		ArrayList <String> temp = new ArrayList();
		output +="      ";
		int [] result = new int[length];
		
		for (int i = -1; (i = output.indexOf(s, i + 1)) != -1; ) {
			String sfind = output.substring(i+s.length(), i+s.length()+5);
		
			sfind = sfind.replaceAll("[^0-9]", "");
		    temp.add(sfind);
        } 
		
		for(int i=0; i<result.length; i++){
			
			if(temp.get(i).equals("")){
				result[i] = 0;
			}else{
			result[i] = Integer.parseInt(temp.get(i));
			}
		}
		
		
		return result;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println("Hi");
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
	                     *
	                     */
	                    InputStreamReader reader = new InputStreamReader(item.getInputStream());
	                    StringWriter writer = new StringWriter();
	                    IOUtils.copy(reader, writer);
	                    output = writer.toString();
	                  //  System.out.println(theString);
	                   
	                    
	                    
	                    
	                    
	                //    String filePath = uploadPath + File.separator + fileName;
	               //     File storeFile = new File(filePath);
	                   
	                   
	                    // saves the file on disk
	                 //   item.write(storeFile);
	                  //  output= new Scanner(new File(UPLOAD_DIRECTORY+"/"+fileName)).useDelimiter("\\Z").next();
	                }
	                
	            }
	            
	        } catch (Exception ex) {
	           
	        }
	        output=output.replaceAll("[^a-zA-Z0-9]", "");
	     //   System.out.println("" + output);
	        String ClycanNumber = "ClycanNumber";
	        int count=0;
	        for (int i = -1; (i = output.indexOf(ClycanNumber, i + 1)) != -1; ) {
	            count++;
	           	//System.out.println(output.charAt(i+ClycanNumber.length()));
	        } 
	       
	        int [] Hexoses = getValues(output,"Hexose",count);	int [] Deoxyhexoses =  getValues(output,"Deoxyhexose",count);
			int [] HexNAcs = getValues(output,"HexNAc",count);	int [] Pentoses = getValues(output,"Pentose",count);
			int [] NeuAcs  = getValues(output,"NeuAc",count);	int [] Phosphates = getValues(output,"Phosphate",count);	
			int [] NeuGcs  = getValues(output,"NeuGc",count);	int [] Sulphates = getValues(output,"Sulphate",count);
			
			
			ArrayList <glycans> glycanss = new ArrayList();
			for(int i=0; i<Hexoses.length; i++){
				glycans g = new glycans();
				g.Hexose = Hexoses[i];
				g.HexNAc = HexNAcs[i];
				g.NeuAc = NeuAcs[i];
				g.NeuGc = NeuGcs[i];
				g.Deoxyhexose = Deoxyhexoses[i];
				g.Pentose = Pentoses[i];
				g.Phosphate = Phosphates[i];
				g.Sulphate = Sulphates[i];
				glycanss.add(g);
			}
			glycan_value_list gvl = new glycan_value_list();
			
			for(glycans g: glycanss){
				
				glycan_value gv_Hexose = (glycan_value)gvl.glycan_value_list.get("Hexose");
				double gv_Hexose_monoisotopic = gv_Hexose.monoisotopic;
				double gv_Hexose_average = gv_Hexose.average;
				
				glycan_value gv_HexNAc = (glycan_value)gvl.glycan_value_list.get("HexNAc");
				double gv_HexNAc_monoisotopic = gv_HexNAc.monoisotopic;
				double gv_HexNAc_average = gv_HexNAc.average;
				
				glycan_value gv_Deoxyhexose = (glycan_value)gvl.glycan_value_list.get("Deoxyhexose");
				double gv_Deoxyhexose_monoisotopic = gv_Deoxyhexose.monoisotopic;
				double gv_Deoxyhexose_average = gv_Deoxyhexose.average;
				
				glycan_value gv_Pentose = (glycan_value)gvl.glycan_value_list.get("Pentose");
				double gv_Pentose_monoisotopic = gv_Pentose.monoisotopic;
				double gv_Pentose_average = gv_Pentose.average;
				
				glycan_value gv_NeuAc = (glycan_value)gvl.glycan_value_list.get("NeuAc");
				double gv_NeuAc_monoisotopic = gv_NeuAc.monoisotopic;
				double gv_NeuAc_average = gv_NeuAc.average;
				
				glycan_value gv_NeuGc = (glycan_value)gvl.glycan_value_list.get("NeuGc");
				double gv_NeuGc_monoisotopic = gv_NeuGc.monoisotopic;
				double gv_NeuGc_average = gv_NeuGc.average;
				
				glycan_value gv_Phosphate = (glycan_value)gvl.glycan_value_list.get("Phosphate");
				double gv_Phosphate_monoisotopic = gv_Phosphate.monoisotopic;
				double gv_Phosphate_average = gv_Phosphate.average;
				
				glycan_value gv_Sulphate = (glycan_value)gvl.glycan_value_list.get("Sulphate");
				double gv_Sulphate_monoisotopic = gv_Sulphate.monoisotopic;
				double gv_Sulphate_average = gv_Sulphate.average;
				
				g.Average_Mass = g.Hexose * gv_Hexose_average + g.HexNAc * gv_HexNAc_average + g.Deoxyhexose * gv_Deoxyhexose_average + g.Pentose * gv_Pentose_average + g.NeuAc * gv_NeuAc_average + g.NeuGc * gv_NeuGc_average + g.Phosphate * gv_Phosphate_average + g.Sulphate * gv_Sulphate_average;
				g.Monoisotopic_Mass= g.Hexose * gv_Hexose_monoisotopic + g.HexNAc * gv_HexNAc_monoisotopic + g.Deoxyhexose * gv_Deoxyhexose_monoisotopic + g.Pentose * gv_Pentose_monoisotopic + g.NeuAc * gv_NeuAc_monoisotopic + g.NeuGc * gv_NeuGc_monoisotopic + g.Phosphate * gv_Phosphate_monoisotopic + g.Sulphate * gv_Sulphate_monoisotopic;
			//	System.out.println(g.Average_Mass);
			//	System.out.println(g.Monoisotopic_Mass);
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
	}

}
