import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class RgetMtrix {
	public static double[][] getMatrix(){
		Rengine re=new Rengine (new String [] {"--vanilla"}, false, null);
		 REXP x;
		 re.eval("library(msdata)");
	        re.eval("library(mzR)");
	        re.eval("mzxml <- system.file('threonine/testDataSet.mzXML',package = 'msdata')");
	        re.eval("aa <- openMSfile(mzxml)") ;
	        re.eval("pl <- peaks(aa,10)");
	        re.eval("peaksCount(aa,10)");
	        System.out.println(x=re.eval("head(pl)"));   
	        double matrix [][] =x.asMatrix();
	        for(int i=0; i<matrix.length; i++){
	        	 for(int j=0; j<matrix[i].length; j++){
	 	        	System.out.println(matrix[i][j]);
	 	        }
	        }
	       
	        
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
		double [][] matrix= getMatrix();
		for(int i=0; i<matrix.length; i++){
       	 for(int j=0; j<matrix[i].length; j++){
	        	System.out.println(matrix[i][j]);
	        }
       }
    }
}
