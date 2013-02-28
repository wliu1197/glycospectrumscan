package GenerateImage;

import java.util.ArrayList;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class RgetMtrix {
	public double[][] getMatrix(String Path){
		Rengine re=new Rengine (new String [] {"--vanilla"}, false, null);
		 REXP x;
		re.eval("library(msdata)");
	     re.eval("library(mzR)");
	     
	     //Change default working directory
	   //  re.eval("setwd(file='C:/Users/wenhao/git/glyco/glycoSpectrumScan/R')");
	       
	   //  re.eval("mzxml <-list.files(path='C:/Users/wenhao/git/glyco/glycoSpectrumScan/R/win-library/2.15/msdata/threonine/testDataSet.mzXML',all.files = TURE)") ;  
	     //   C:\Users\wenhao\git\glyco\glycoSpectrumScan\R\win-library\2.15\msdata\threonine\testDataSet.mzXML
	    // C:\Users\wenhao\git\glyco\glycoSpectrumScan\R\win-library\2.15\msdata\threonine\testDataSet.mzXML
	        
	       re.eval("mzxml <- system.file('"+Path+"',package = 'msdata',mustWork=TRUE)");
	       //  re.eval("mzxml <- source('C:/Users/wenhao/git/glyco/glycoSpectrumScan/R/win-library/2.15/msdata/threonine/testDataSet.mzXML')");
	        re.eval("aa <- openMSfile(mzxml)") ;
	        re.eval("pl <- peaks(aa,10)");
	        re.eval("peaksCount(aa,10)");
	        System.out.println(x=re.eval("head(pl)"));   
	        double matrix [][] =x.asMatrix();
	      
	        /*
	        for(int i=0; i<matrix.length; i++){
	        	 for(int j=0; j<matrix[i].length; j++){
	 	        	System.out.println(matrix[i][j]);
	 	        }
	        }*/
	       
	        
		   //      re.eval("aa <- openMSfile(mzxml)");
		   //      re.eval("pl <- peaks(aa,10)");
		   //     System.out.println(x=re.eval("peaksCount(aa,10)"));
		   //      System.out.println(x=re.eval("runInfo(aa)"));
		       
		      
		        
		   //      System.out.println (n);
		        
		
			
	      //  System.out.println (re.eval ("runif(1)").asDouble ());
	        re.end();
	        return matrix;
	}
	
	public static void main (String[] args)
    {
		RgetMtrix Rm= new RgetMtrix();
		double [][] matrix= Rm.getMatrix("threonine/testDataSet.mzXML");
		ArrayList <Double> x_axis = new ArrayList<Double>();
	    ArrayList <Double> y_axis = new ArrayList<Double>();
		for(int i=0; i<matrix.length; i++){
       	
		 for(int j=0; j<matrix[i].length; j++){
	        	if(j==0){
	        		x_axis.add(matrix[i][j]);
	        		
	        	}else if(j==1){
	        		
	        		y_axis.add(matrix[i][j]);
	        	}
	        
       	 	}
        }
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
					System.out.println(X_Axis[i]+" "+Y_Axis[i]);
			}
	       
			
		
		
    }

}
