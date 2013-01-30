package GenerateImage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYImageAnnotation;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.DefaultIntervalXYDataset;

/**
 * Servlet implementation class DrawImagesServlet
 */
public class DrawImagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrawImagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public BufferedImage createResizedCopy(Image originalImage, 
    		int scaledWidth, int scaledHeight, 
    		boolean preserveAlpha)
    {
    	//System.out.println("resizing...");
    	int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
    	BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
    	Graphics2D g = scaledBI.createGraphics();
    	if (preserveAlpha) {
    		g.setComposite(AlphaComposite.Src);
    	}
    	g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
    	g.dispose();
    	return scaledBI;
    }
 public void Histograms(double [] x, double [] y) throws IOException{
		
	// System.out.println("sssssssssssssssssssssssssss");
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
		String [] x_image  = new String [images.size()];
		String [] y_image  = new String [images.size()];
		
		for(int i=0; i<images.size(); i++){
			
			String[] temp;
			String delimiter = "_";
			temp = images.get(i).split(delimiter);
			x_image[i] = temp[0];
			y_image[i] = temp[1];
			y_image[i] = y_image[i].replaceAll("[^0-9]", "");
			
		}
		
		for(String s: x_image){
			System.out.println(s);
			
		}
		for(String s: y_image){
			System.out.println(s);
			
		}
		
		for(int i=0; i<images.size(); i++){
			System.out.println(images.get(i));
			double x_temp = Double.parseDouble(x_image[i]);
			double y_temp = Double.parseDouble(y_image[i]);
		
			ImageIcon icon = new ImageIcon("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages/"+images.get(i));
			Image image2 = icon.getImage();
			Image image=createResizedCopy(image2,180,128,true);
			XYImageAnnotation a1 = new XYImageAnnotation(x_temp, y_temp, image);
			plot.addAnnotation(a1);
		}
		
		
		*/
		
		
		for(int i=0; i<x.length; i++){
			int count=1;
			for(int j=0; j<images.size(); j++){
				
				if(images.get(j).substring(0,images.get(j).indexOf("_")+1).equals(Integer.toString(i+1)+"_")){
					
					ImageIcon icon = new ImageIcon("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages/"+images.get(j));
					Image image2 = icon.getImage();
					Image image=createResizedCopy(image2,186,134,true);
					
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
	//	renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
	//	renderer.setBaseItemLabelsVisible(true);
		//chart background color
		plot.setBackgroundPaint(Color.white);
		
		
		ChartFrame frame = new ChartFrame("First", chart);
		
		
		frame.pack();
		frame.setVisible(true);
		
		
		
	/*
		try {
			ChartUtilities.saveChartAsPNG(new File("C:/Job/Milestones/BarChartWithImage/WebContent/image/result.png"), chart, 500, 500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
 public void Histograms(double [] x, double [] y, double[] x_axis, double[] y_axis, int [] zs, LinkedList <String []> structureIDs) throws IOException{
		
		
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
		
		
		
		/* ************************ Only display important value**************************************
		double maxs = x_axis[0];
		
		
		
		 for (int counter = 1; counter < x_axis.length; counter++)
			{
			     if (x_axis[counter] > maxs)
			     {
			      maxs = x_axis[counter];
			     }
		
			} 
		 
		double [] x_2 ={maxs+30};
		double[] y_2 = {value+6}; 
		double[][] data2 = new double[][] {x_2, x_2, x_2, y_2, y_2, y_2};
		
		 */
		
		
		
		
		
		double [] x_axis_start = new double [x_axis.length];
		double [] x_axis_end = new double [x_axis.length];
		for(int i=0; i<x_axis_start.length;i++){
			x_axis_start[i] = x_axis[i]-0.3;
			 x_axis_end[i] =  x_axis[i]+0.3;
		}
		
		LinkedList <Integer> number_of_zs = new LinkedList <Integer>();
		LinkedList <Integer> AtZ = new LinkedList <Integer>();
		int at=0;
		for(int i=0; i<zs.length;i++){
			if(zs[i]!=0){
				number_of_zs.add(zs[i]);
				AtZ.add(i+1);
				at=i+1;
			}
		}
		double[][] highlightdata = null ;	
		double[][] highlightdata2 = null ;	
		double[][] highlightdata3 = null ;
		double[][] highlightdata4 = null ;
		
		
		if(number_of_zs.size()==1){		
		
			highlightdata = new double[][] {x_axis, x_axis_start, x_axis_end, y_axis, y_axis, y_axis};
		
		}else if(number_of_zs.size()>1){
		    
			double [] x_axis_1 = new double[number_of_zs.get(0)];
			double [] x_axis_start_1 = new double[number_of_zs.get(0)];
			double [] x_axis_end_1 = new double[number_of_zs.get(0)];
			double [] y_axis_1 = new double[number_of_zs.get(0)];
			
			double [] x_axis_2 = new double[number_of_zs.get(1)];
			double [] x_axis_start_2 = new double[number_of_zs.get(1)];
			double [] x_axis_end_2 = new double[number_of_zs.get(1)];
			double [] y_axis_2 = new double[number_of_zs.get(1)];
			
			double [] x_axis_3 = null;
			double [] x_axis_start_3=null;
			double [] x_axis_end_3=null;
			double [] y_axis_3=null; 
			
			double [] x_axis_4 = null;
			double [] x_axis_start_4=null;
			double [] x_axis_end_4=null;
			double [] y_axis_4=null; 
			
			if(number_of_zs.size()>2){
				x_axis_3 = new double[number_of_zs.get(2)];
				x_axis_start_3 = new double[number_of_zs.get(2)];
				x_axis_end_3 = new double[number_of_zs.get(2)];
				y_axis_3 = new double[number_of_zs.get(2)];	
			}
			if(number_of_zs.size()==4){
				
				
				x_axis_4 = new double[number_of_zs.get(3)];
				x_axis_start_4 = new double[number_of_zs.get(3)];
				x_axis_end_4 = new double[number_of_zs.get(3)];
				y_axis_4 = new double[number_of_zs.get(3)];	
			}
			
			
			for(int i=0; i<number_of_zs.get(0); i++){
				x_axis_1 [i] = x_axis [i];
				x_axis_start_1 [i] = x_axis_start[i];
				x_axis_end_1 [i] = x_axis_end[i];
				y_axis_1 [i] = y_axis [i];
		
				
			}
			int index=0;
			for(int i=number_of_zs.get(0); i<(number_of_zs.get(0)+number_of_zs.get(1)) ; i++){
				x_axis_2 [index] = x_axis[i];
				x_axis_start_2 [index] = x_axis_start[i];
				x_axis_end_2 [index] = x_axis_end[i];
				y_axis_2 [index] = y_axis[i];
				index++;
			}
			
			if(number_of_zs.size()>2){
				index=0;
				for(int i=number_of_zs.get(0)+number_of_zs.get(1); i<(number_of_zs.get(0)+number_of_zs.get(1)+number_of_zs.get(2)) ; i++){
					x_axis_3 [index] = x_axis[i];
					x_axis_start_3 [index] = x_axis_start[i];
					x_axis_end_3 [index] = x_axis_end[i];
					y_axis_3 [index] = y_axis[i];
					index++;
				}
			}
			
			if(number_of_zs.size()==4){
				index=0;
				for(int i=number_of_zs.get(0)+number_of_zs.get(1)+number_of_zs.get(2); i<(number_of_zs.get(0)+number_of_zs.get(1)+number_of_zs.get(2)+number_of_zs.get(3)) ; i++){
					x_axis_4 [index] = x_axis[i];
					x_axis_start_4 [index] = x_axis_start[i];
					x_axis_end_4 [index] = x_axis_end[i];
					y_axis_4 [index] = y_axis[i];
					index++;
				}
			}
			highlightdata = new double[][] {x_axis_1, x_axis_start_1, x_axis_end_1, y_axis_1, y_axis_1, y_axis_1};
			highlightdata2 = new double[][] {x_axis_2, x_axis_start_2, x_axis_end_2, y_axis_2, y_axis_2, y_axis_2};
			if(number_of_zs.size()>2){
			highlightdata3 = new double[][] {x_axis_3, x_axis_start_3, x_axis_end_3, y_axis_3, y_axis_3, y_axis_3};
			}
			if(number_of_zs.size()==4){
				highlightdata4 = new double[][] {x_axis_4, x_axis_start_4, x_axis_end_4, y_axis_4, y_axis_4, y_axis_4};
			}
		}
		
		
			dataset.addSeries("Series 1", data);
			dataset.addSeries("Series 2", data2);
			if(number_of_zs.size()==1){
				dataset.addSeries("Z="+at, highlightdata);
			}else if(number_of_zs.size()>1){
				dataset.addSeries("Z="+AtZ.get(0), highlightdata);
				dataset.addSeries("Z="+AtZ.get(1), highlightdata2);
			
				if(number_of_zs.size()>2){
					dataset.addSeries("Z="+AtZ.get(2), highlightdata3);
				}
				if(number_of_zs.size()==4){
					dataset.addSeries("Z="+AtZ.get(3), highlightdata4);
				}
			}
			
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
			renderer.setSeriesPaint(0, Color.LIGHT_GRAY);
			renderer.setSeriesPaint(2, Color.red);
			if(number_of_zs.size()>1){
				renderer.setSeriesPaint(3, Color.GREEN);
				if(number_of_zs.size()>2){
					renderer.setSeriesPaint(4, Color.blue);
				}
				if(number_of_zs.size()==4){
					renderer.setSeriesPaint(5, Color.yellow);
				}
			}
		
		
		
		
		
		/* get file names from a folder */
		ArrayList <String> images = new ArrayList<String>(); 
		
		//File folder = new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages");
		File folder = new File("C:/Users/wenhao/git/glyco/glycoSpectrumScan/WebContent/loadimages");
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  images.add(listOfFiles[i].getName().toString());
		       
		      } 
		}
		//System.out.println("Image size: "+ images.size());
		/*
		for(int i=0; i<structureIDs.size(); i++){
			String [] structureID = structureIDs.get(i);
			double count = 15;
			for(String s: structureID){
				System.out.println(s);
				for(int j=0; j<images.size(); j++){
									
					if(s.equals(images.get(j))){
						System.out.println("here");
						ImageIcon icon = new ImageIcon("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages/"+images.get(j));
						Image image2 = icon.getImage();
						Image image=image2;
						XYImageAnnotation a1 = new XYImageAnnotation(x_axis[i], y_axis[i]+count, image);
						plot.addAnnotation(a1);
						count +=15;
					}
				}
			}
		}
		*/
		LinkedList <Double> x_axis_check = new LinkedList <Double> ();
		x_axis_check.add(0.0);
		
		for(int i=0; i<structureIDs.size(); i++){
			
			String [] structureID = structureIDs.get(i);
			double count =40;
			
			for(String s: structureID){
				
				for(int j=0; j<images.size(); j++){
				
					if(s.equals(images.get(j).toString())){
						
						//ImageIcon icon = new ImageIcon("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages/"+images.get(j));
						ImageIcon icon = new ImageIcon("C:/Users/wenhao/git/glyco/glycoSpectrumScan/WebContent/loadimages/"+images.get(j));
						Image image2 = icon.getImage();
					//	Image image = image2;
						Image image=createResizedCopy(image2,80,50,true);
								//createResizedCopy(image2,80,50,true);
								//createResizedCopy(image2,80,50,true);
							
							boolean check= true;
							for(Double d: x_axis_check  ){
								if(x_axis[i]<d+5 && x_axis[i]>d-5){
								
									check = false;
								}
								if(x_axis[i] == d ){
									check = true;
								}
							}
							
							if(check){
								
								
								
								XYImageAnnotation a1 = new XYImageAnnotation(x_axis[i], y_axis[i]+count, image);
								
								x_axis_check.add(x_axis[i]);
								
								plot.addAnnotation(a1);
								
								count +=30;
								
								break;
							}
						
						
						/*
						XYImageAnnotation a1 = new XYImageAnnotation(x_axis[i], y_axis[i]+count, image);
						plot.addAnnotation(a1);
						x_axis_check.add(x_axis[i]);
						count +=40;
						*/
					}
				}
				
			}
			
			
		}
		
		/*
		for(int i=0; i<x.length; i++){
			int count=1;
			for(int j=0; j<images.size(); j++){
				if(images.get(j).substring(0,images.get(j).indexOf("_")+1).equals(Integer.toString(i+1)+"_")){
					ImageIcon icon = new ImageIcon("C:/Job/Milestones/glycoSpectrumScan/WebContent/loadimages/"+images.get(j));
					Image image2 = icon.getImage();
					Image image=createResizedCopy(image2,24,24,true);
					
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
		
		XYItemLabelGenerator generator = new StandardXYItemLabelGenerator();
		renderer.setSeriesItemLabelGenerator(2, generator);
		renderer.setSeriesItemLabelsVisible(2, true);
		if(number_of_zs.size()>1){
			renderer.setSeriesItemLabelGenerator(3, generator);
			renderer.setSeriesItemLabelsVisible(3, true);
		
			if(number_of_zs.size()>2){
				renderer.setSeriesItemLabelGenerator(4, generator);
				renderer.setSeriesItemLabelsVisible(4, true);
			}
			if(number_of_zs.size()==4){
				renderer.setSeriesItemLabelGenerator(5, generator);
				renderer.setSeriesItemLabelsVisible(5, true);
			}
			
		}
		/* show all labels
		renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);
		*/
		
		//chart background color
		plot.setBackgroundPaint(Color.white);
		
		
		ChartFrame frame = new ChartFrame("First", chart);
		
		
		frame.pack();
		frame.setVisible(true);
	/*
		try {
			ChartUtilities.saveChartAsPNG(new File("C:/Job/Milestones/BarChartWithImage/WebContent/image/result.png"), chart, 500, 500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	
	 	String DataforSequence= request.getParameter("DataforSequence"); 
	 	String [] numberof_x_axis_for_each_z	=request.getParameterValues("numberof_x_axis_for_each_z");	
	 	String ChargeState =  request.getParameter("ChargeState");
		String Range = request.getParameter("Range");
		int[] zs = null;
		
		String[] X_Axis_string =request.getParameterValues("X-Axis");	
		String[] Y_Axis_string =request.getParameterValues("Y-Axis");	
		double[] X_Axis = new double[X_Axis_string.length];
		double[] Y_Axis = new double[Y_Axis_string.length];
		
		
		if(request.getParameterValues("numberof_x_axis_for_each_z")!=null){
			 zs = new int[numberof_x_axis_for_each_z.length];
			
			for(int i=0; i<zs.length; i++){
				zs[i]=Integer.parseInt(numberof_x_axis_for_each_z[i]);
		//		System.out.println(zs[i]);
			}
		}
		
		for(int i=0;i<X_Axis_string.length; i++){
			X_Axis[i] = new Double(X_Axis_string[i]);
			Y_Axis[i] = new Double(Y_Axis_string[i]);
			
		}
		
		
		if(request.getParameterValues("for_X_axis")!=null){
			 String [] combination_a_mass = request.getParameterValues("Combination_a_mass"); 
		//	 System.out.println("xxxxxxxxxxxxxxxxxx");
			 String[] Highlight= request.getParameterValues("for_X_axis");
			 double [] Highlight_X = new double [Highlight.length];
			 double [] Highlight_Y = new double [Highlight.length];
			 double [] combination_average_mass = new double[combination_a_mass.length];
			 
			 for(int i=0; i<combination_average_mass.length; i++){
				 combination_average_mass[i] = Double.parseDouble(combination_a_mass[i]);
			 }
			 for(int i=0; i<Highlight.length; i++){
			 		Highlight_X[i] = Double.parseDouble(Highlight[i]);
			 //		 System.out.println(Highlight_X[i] );
			 		
			 }
			 
			 for(int i=0; i<Highlight_X.length; i++){
				 for(int j=0; j<X_Axis.length; j++){
					 if(Highlight_X[i]==X_Axis[j]){
						 Highlight_Y[i] = Y_Axis[j];
					 }
				 }
			 }
			 
			 /*here*****************************************************************************************/
			 for(int i=0; i<combination_average_mass.length; i++){
//				 System.out.print(Highlight_X[i] +" "+  Highlight_Y[i] +" "+ combination_average_mass[i] );
//				 System.out.println();
			 }
			 LinkedList <String []> structureIDs =new LinkedList <String[]> (); 
			 for(int i=0; i<combination_average_mass.length; i++){
				 DatabaseMethods dbM = new DatabaseMethods();
				 String [] CompositionID = dbM.GetCompositionID(combination_average_mass[i]);
				 if(CompositionID != null){
					 /* Structure ID from database */
					 String [] structureID = dbM.getStructureID(CompositionID);
					 for(int j=0; j<structureID.length; j++){
						 //structureID[j] = "_"+structureID[j]+".png";
						 structureID[j] = structureID[j]+".png";
					 }
					 structureIDs.add(structureID);
				 }else{
					 String [] structureID = {"null"};
					 structureIDs.add(structureID);
				 }
			 }
	//		 System.out.println(structureIDs.size());
	//		 System.out.println(Highlight_X.length);
	//		 System.out.println(combination_average_mass.length);
			 for(String[] s: structureIDs){
				 for(String ss: s){
					
	//				 System.out.print(ss+" ");
				 }
	//			 System.out.println();
			 }
			 
			 Histograms(X_Axis, Y_Axis,Highlight_X,Highlight_Y,zs,structureIDs);
			 
			 
		}else{
			Histograms(X_Axis, Y_Axis);
		}
		
		/* get all files name from folder */
		ArrayList <String> images = new ArrayList<String>(); 
		
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
