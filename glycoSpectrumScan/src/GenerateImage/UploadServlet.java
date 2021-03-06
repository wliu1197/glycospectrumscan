package GenerateImage;

import java.awt.Color;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.DefaultIntervalXYDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// private static final String UPLOAD_DIRECTORY = "C:/Job/Milestones/glycoSpectrumScan/WebContent/upload";
	 private static final String UPLOAD_DIRECTORY = "C:/Users/wenhao/git/glyco/glycoSpectrumScan/WebContent/upload";
	 private static final int THRESHOLD_SIZE = 1024 * 1024 * 10; // 10MB
	 private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	 private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	    
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

		
	public  void Histograms(double [] x, double [] y) throws IOException{
		double max = y[0];
		double value= 0;
		for(int i=0; i<y.length; i++){
			if(y[i]>max){
				max=y[i];
			}
		}
		
		value = max;
		
		if(max > 6 && max < 20){
			
			value =value + 30;
		}else if(max >19 && max < 70 ){
			value =value + 70;
		}else if(max > 69 && max < 120){
			value = value + 100;
		}else if(max > 119 && max < 200){
			value = value + 140;
		}else if(max > 199 && max < 300){
			value = value + 270;
		}else if(max > 299 && max < 500){
			value = value + 600;
		}else if(max > 499 && max < 700){
			value = value + 800;
		}else if(max > 699 && max < 900){
			value = value +1000;
		}else if(max > 899 && max < 1200){
			value = value +1250;
		}else if(max > 1199 && max < 1500){
			value = value +1500;
		}else if(max > 1499 && max < 2000){
			value = value +2000;
		}else if(max > 1999 && max < 2500){
			value = value +2500;
		}else if(max > 2499 && max < 3000){
			value = value +3000;
		}else if(max > 2999 && max < 3500){
			value= value +3500;
		}else if(max > 3499 && max < 4000){
			value= value +4000;
		}else if(max > 3999 && max < 4500){
			value= value +4500;
		}else if(max > 4499 && max < 5000){
			value= value +5000;
		}else if(max >4999){
			value= value +8000;
		}
		
		
		DefaultIntervalXYDataset dataset = new DefaultIntervalXYDataset();
		
		double[][] data = new double[][] {x, x, x, y, y, y};
		
		//ADD one more invisible series
		double[] x_2 ={x[x.length-1]+1};
		
		double[] y_2 = {value+6}; //add y-axis high
				
		double[][] data2 = new double[][] {x_2, x_2, x_2, y_2, y_2, y_2};
		
		dataset.addSeries("Series 1", data);
		dataset.addSeries("Series 2", data2);
		
		JFreeChart chart = ChartFactory.createXYBarChart(
				"Mass Spectrum", // chart title
				"Mass(m/z)", // domain axis label
				false, 
				 "Intensity", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips?
				false // URLs?
				);
		
		XYPlot plot = (XYPlot) chart.getPlot();
		XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
		// make seriesinvisible
		renderer.setSeriesVisible(1, false);
		renderer.setSeriesPaint(0, Color.gray);	
				
		/* get filenames frome a folder */
		
		ArrayList <String> images = new ArrayList<String>(); 
		File folder = new File("C:/Users/wenhao/git/glyco/glycoSpectrumScan/WebContent/loadimages");
		//File folder = new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  images.add(listOfFiles[i].getName().toString());
		       
		      } 
		}
		
		
		
		/*
		//add image into chart
		ImageIcon icon = new ImageIcon("C:/Users/wenhao/Desktop/3.png");
		Image image = icon.getImage();
		XYImageAnnotation a1 = new XYImageAnnotation(x[0], y[0]+2, image);
		XYImageAnnotation a2 = new XYImageAnnotation(x[x.length-1], y[y.length-1]+2, image);
		plot.addAnnotation(a1);
		plot.addAnnotation(a2);
		
		*/
		
		//labels
		renderer.setShadowVisible(false);
		renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		//chart background color
		plot.setBackgroundPaint(Color.white);
		
		
		ChartFrame frame = new ChartFrame("First", chart);
		
		
		frame.pack();
		frame.setVisible(true);
		
		
		
	/*
		try {
			ChartUtilities.saveChartAsPNG(new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/image/result.png"), chart, 500, 500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
    	File directory = new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages");
		File[] files = directory.listFiles();
		for (File file : files){
			file.delete();
			if (!file.delete()){
		//		System.out.println("Failed to delete "+file);
			}
		}
		*/
    //	System.out.println("HI");
		ArrayList <String> filenames = new ArrayList <String>();
		String output = "";
		String DataforSequence ="";
		
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
	                    String filePath = uploadPath + File.separator + fileName;
	                    File storeFile = new File(filePath);
	                    filenames.add(fileName);
	                   
	                    /*
	                     * Without save to disk
	                     */
	                    InputStreamReader reader = new InputStreamReader(item.getInputStream());
	                    StringWriter writer = new StringWriter();
	                    IOUtils.copy(reader, writer);
	                    output = writer.toString();
	                    
	                    
	                    // saves the file on disk
	                //    item.write(storeFile);
	                  //  output = new Scanner(new File("C:/Users/wenhao/git/glyco/glycoSpectrumScan/WebContent/upload/"+fileName)).useDelimiter("\\Z").next();
	                    
	                }else{
	                	String fieldname = item.getFieldName();
		                String fieldvalue = item.getString();
		                
	                	if(fieldname.equals("SelectedSequence")){
	                		DataforSequence = fieldvalue;
		                }
	                }
	                
	                
	            }
	            
	       //     System.out.println(DataforSequence);
	        } catch (Exception ex) {
	           
	        }
	       
	      ArrayList <Double> x_axis = new ArrayList<Double>();
	      ArrayList <Double> y_axis = new ArrayList<Double>();
	    
          output = output.replaceAll("[\\t\\n\\r\\s]","-" );
          output = output.replaceAll("--", "-");
       //   System.out.println(output);
        //  System.out.println(output);
          String [] temp;
          String delimiter="-";
          temp = output.split(delimiter);
          
          for(int i=0; i<temp.length; i++){
        	  
        	  if( (i+1) %2==0){
        		  y_axis.add(     Double.parseDouble(temp[i]));
        		//  System.out.println(i+": "+ Double.parseDouble(temp[i]));
        	  }else{
        	      x_axis.add(Double.parseDouble(temp[i]));
        	  }
          }
         
          
          
          
      	     //  System.out.println(output);
	     /*
	       for(int i=0; i< output.length(); i++){
	    	   
	    	   if(output.charAt(i)=='X' || output.charAt(i)=='x') {
	    		   int j=0;
	    		   for( j=i; ; j++){
	    			   if(output.charAt(j)=='Y' || output.charAt(j)=='y') break;
	    		   }
	    		//   System.out.println(Double.parseDouble(output.substring(i+2,j)));
	    		   x_axis.add(Double.parseDouble(output.substring(i+2,j)));
	    	   }
	    	   if(output.charAt(i)=='Y' || output.charAt(i)=='y'){
	    		   int j=0;
	    		   for(j=i;  ;j++){
	    			   if(output.charAt(j)=='X' || output.charAt(j)=='x') break;
	    			   if(j==output.length()-1) break;
	    		   }
	    		   if(j==output.length()-1){
	    		//   System.out.println(Double.parseDouble(output.substring(i+2,j+1)));
	    		   y_axis.add(Double.parseDouble(output.substring(i+2,j+1)));
	    		   }else{
	    		//   System.out.println(Double.parseDouble(output.substring(i+2,j)));
	    		   y_axis.add(Double.parseDouble(output.substring(i+2,j)));
	    		   }
	    	   }
	       }
	       */
	      
	      
	       
	       
	       double[] X_Axis = new double[x_axis.size()];
		   double[] Y_Axis = new double[x_axis.size()];
	       for(int i=0; i<x_axis.size(); i++){
	    	   X_Axis[i]=x_axis.get(i);
	    	   Y_Axis[i]=y_axis.get(i);
	       }
	   	double [][] x_y=new double [X_Axis.length][2];
		for(int i=0; i<X_Axis.length; i++){
			x_y[i][0] = X_Axis[i];
			x_y[i][1] = Y_Axis[i];
		
		}
		java.util.Arrays.sort(x_y, new java.util.Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
		        return Double.compare(o1[0], o2[0]);
		    }
		});
		for(int i=0; i<x_y.length; i++){
			
			for(int j=0; j<x_y[0].length;j++){
				if(j==0){
					X_Axis[i]=x_y[i][j];
				}else{
					Y_Axis[i]=x_y[i][j];
				}
			}
		}
		
		for(int i=0; i< X_Axis.length; i++){
	//		System.out.println(X_Axis[i]+" "+Y_Axis[i]);
		}
		
		
		Histograms(X_Axis, Y_Axis);
		
		/* get all files name from folder */
		ArrayList <String> images = new ArrayList<String>(); 
		File folder = new File("C:/Users/wenhao/git/glyco/glycoSpectrumScan/WebContent/loadimages");
	//	File folder = new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  images.add(listOfFiles[i].getName().toString());
		       
		      } 
		}
		
		if(images.size()==0){
			images.add("No images in the system !!!");
		}
		
		request.setAttribute("DataforSequence", DataforSequence); 
		request.setAttribute("X_Axis", X_Axis);
		request.setAttribute("Y_Axis", Y_Axis);
		request.setAttribute("images", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ImageResult.jsp");
		if (dispatcher != null){

			  dispatcher.forward(request, response);

		} 		
		          
	               
	       
	  }
       
    
	

}
