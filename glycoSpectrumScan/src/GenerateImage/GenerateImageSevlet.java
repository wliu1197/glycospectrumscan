package GenerateImage;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.DefaultIntervalXYDataset;

/**
 * Servlet implementation class GenerateImageSevlet
 */
public class GenerateImageSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateImageSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

public void Histograms(double [] x, double [] y) throws IOException{
		
		
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
		File folder = new File("C:/Users/wenhao/git/glyco/glycoSpectrumScan/WebContent/loadimages");
	//	File folder = new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  images.add(listOfFiles[i].getName().toString());
		       
		      } 
		}
		
		/*
		for(int i=0; i<x.length; i++){
			int count=1;
			for(int j=0; j<images.size(); j++){
				if(images.get(j).contains(Integer.toString(i+1)+"_")){
					ImageIcon icon = new ImageIcon("C:/Job/Milestones/BarChartWithImage/WebContent/loadimages/"+images.get(j));
					Image image = icon.getImage();
					if(max > 6 && max < 20){
						count = count + 5;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max >19 && max < 70 ){
						count = count + 15;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 69 && max < 120){
						count = count + 20;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 119 && max < 200){
						count = count + 28;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 199 && max < 300){
						count = count + 50;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 299 && max < 500){
						count = count + 100;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 499 && max < 700){
						count = count + 150;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 699 && max < 900){
						count = count + 200;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 899 && max < 1200){
						count = count + 250;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 1199 && max < 1500){
						count = count + 300;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 1499 && max < 2000){
						count = count + 400;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 1999 && max < 2500){
						count = count + 500;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 2499 && max < 3000){
						count = count + 600;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 2999 && max < 3500){
						count = count + 700;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 3499 && max < 4000){
						count = count + 800;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 3999 && max < 4500){
						count = count + 900;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 4499 && max < 5000){
						count = count + 1000;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}else if(max > 4999){
						count = count + 1500;
						XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
						plot.addAnnotation(a1);
					}
					
					else{
					XYImageAnnotation a1 = new XYImageAnnotation(x[i], y[i]+count, image);
					plot.addAnnotation(a1);
					count ++;
					}
				}
			}
		}
		*/
		
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
		String[] X_Axis_string =request.getParameterValues("X-Axis");	
		String[] Y_Axis_string =request.getParameterValues("Y-Axis");	
		double[] X_Axis = new double[X_Axis_string.length];
		double[] Y_Axis = new double[Y_Axis_string.length];
		
		for(int i=0;i<X_Axis_string.length; i++){
			X_Axis[i] = new Double(X_Axis_string[i]);
			Y_Axis[i] = new Double(Y_Axis_string[i]);
			
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
		
		request.setAttribute("X_Axis", X_Axis);
		request.setAttribute("Y_Axis", Y_Axis);
		request.setAttribute("images", images);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ImageResult.jsp");
		if (dispatcher != null){
	
			  dispatcher.forward(request, response);
	
		} 
		
	}
	
}
