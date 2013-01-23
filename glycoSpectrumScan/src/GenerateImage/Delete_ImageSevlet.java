package GenerateImage;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYImageAnnotation;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.DefaultIntervalXYDataset;

/**
 * Servlet implementation class Delete_ImageSevlet
 */
public class Delete_ImageSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_ImageSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

public void Histograms(double [] x, double [] y) throws IOException{
		
		
		double max = y[0];
		for(int i=0; i<y.length; i++){
			if(y[i]>max){
				max=y[i];
			}
		}
		
		DefaultIntervalXYDataset dataset = new DefaultIntervalXYDataset();
		
		double[][] data = new double[][] {x, x, x, y, y, y};
		
		//ADD one more invisible series
		double[] x_2 ={x[x.length-1]+1};
		
		double[] y_2 = {max+5};
				
		double[][] data2 = new double[][] {x_2, x_2, x_2, y_2, y_2, y_2};
		
		dataset.addSeries("Series 1", data);
		dataset.addSeries("Series 2", data2);
		
		JFreeChart chart = ChartFactory.createXYBarChart(
				"Mass Spectrum", // chart title
				"X-axis", // domain axis label
				false, 
				 "Y-axis", // range axis label
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
		File folder = new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  images.add(listOfFiles[i].getName().toString());
		       
		      } 
		}
		
		for(int i=0; i<x.length; i++){
			int count=1;
			for(int j=0; j<images.size(); j++){
				if(images.get(j).contains(Integer.toString(i+1)+"_")){
					ImageIcon icon = new ImageIcon("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages/"+images.get(j));
					Image image = icon.getImage();
					XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
					plot.addAnnotation(a1);
					count ++;
				}
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


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ChargeState =  request.getParameter("ChargeState");
		String DataforSequence= request.getParameter("DataforSequence"); 
		String Range = request.getParameter("Range");
		File directory = new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages");
		File[] files = directory.listFiles();
		for (File file : files){
			file.delete();
			if (!file.delete()){
		//		System.out.println("Failed to delete "+file);
			}
		}
		
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
		
		String[] X_Axis_string =request.getParameterValues("X-Axis");	
		String[] Y_Axis_string =request.getParameterValues("Y-Axis");	
		double[] X_Axis = new double[X_Axis_string.length];
		double[] Y_Axis = new double[Y_Axis_string.length];
		
		for(int i=0;i<X_Axis_string.length; i++){
			X_Axis[i] = new Double(X_Axis_string[i]);
			Y_Axis[i] = new Double(Y_Axis_string[i]);
			
		}
		
		
		
	//	Histograms(X_Axis, Y_Axis);
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
