import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;






public class JRItest {
	
	  public static void main (String[] args)
	    {
		  RgetMtrix Rm = new RgetMtrix();
	        // new R-engine
	        Rengine re=new Rengine (new String [] {"--vanilla"}, false, null);
	        if (!re.waitForR())
	        {
	            System.out.println ("Cannot load R");
	            return;
	        }
	        
	        // print a random number from uniform distribution
	       
	        REXP x;
	        /*
	        re.eval("source('http://bioconductor.org/biocLite.R')");
	        re.eval("biocLite('mzR')");
	        re.eval("source('http://bioconductor.org/biocLite.R')");
	        re.eval("biocLite('msdata')");
	        */
	        re.eval("library(msdata)");
	        re.eval("library(mzR)");
	      //  C:\Users\wenhao\git\glyco\Combination\MZXML
	     //   C:/Users/wenhao/Documents/R/win-library/2.15/msdata/threonine
	   //     C:/Users/wenhao/git/glyco/Combination/R/win-library/2.15/msdata/threonine
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
	        
	        // done...
	       
	    }
	  
}
