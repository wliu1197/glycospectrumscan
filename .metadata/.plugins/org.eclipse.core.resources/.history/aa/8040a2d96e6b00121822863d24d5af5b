package glycoSpectrumScan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Amino_acids.glycans;

/**
 * Servlet implementation class GlycanMass_Directly_Servlet
 */
public class GlycanMass_Directly_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public GlycanMass_Directly_Servlet() {
        super();
       
    }

    public double [] ConvertStringToDoubleArray(String [] s){
    	double  [] result = new double [s.length];
		for(int i=0; i<result.length; i++){
			s[i]=s[i].replaceAll("[^0-9]", "");
			
			if(s[i].equals("")){
				result[i]=0;
			}else{
				result[i]= Double.parseDouble(s[i]);
			}
		}
		return result;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] M_M=request.getParameterValues("Monoisotopic_Mass"); 
		String[] A_M=request.getParameterValues("Average_Mass");
		
		double [] Monoisotopic_Mass = ConvertStringToDoubleArray(M_M);
		double [] Average_Mass = ConvertStringToDoubleArray(A_M);
		
		for(int i=0; i<A_M.length; i++){
			System.out.print(Monoisotopic_Mass[i]+ " "+ Average_Mass[i]+ " " + "\n");
			
		}
		ArrayList <glycans> glycanss = new ArrayList();
		for(int i=0; i<Monoisotopic_Mass.length; i++){
			glycans g = new glycans();
			g.Monoisotopic_Mass = Monoisotopic_Mass[i];
			g.Average_Mass = Average_Mass[i];
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
		
	}

}
