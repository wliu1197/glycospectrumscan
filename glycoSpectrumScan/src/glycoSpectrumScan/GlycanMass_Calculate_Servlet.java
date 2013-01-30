package glycoSpectrumScan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Amino_acids.*;

import java.io.*;
import java.util.*;

/**
 * Servlet implementation class GlycanMass_Calculate_Servlet
 */
public class GlycanMass_Calculate_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GlycanMass_Calculate_Servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public int [] ConvertStringToIntArray(String [] s){
		int [] result = new int[s.length];
		for(int i=0; i<result.length; i++){
			s[i]=s[i].replaceAll("[^0-9]", "");
			
			if(s[i].equals("")){
				result[i]=0;
			}else{
				result[i]= Integer.parseInt(s[i]);
			}
		}
		return result;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println("HI");
		String[] Hexose=request.getParameterValues("Hexose"); String[] Deoxyhexose=request.getParameterValues("Deoxyhexose");
		String[] HexNAc=request.getParameterValues("HexNAc"); String[] Pentose=request.getParameterValues("Pentose");
		String[] NeuAc=request.getParameterValues("NeuAc");	  String[] Phosphate=request.getParameterValues("Phosphate");
		String[] NeuGc=request.getParameterValues("NeuGc");	  String[] Sulphate=request.getParameterValues("Sulphate");
		
		int [] Hexoses = ConvertStringToIntArray(Hexose);	  int [] Deoxyhexoses =  ConvertStringToIntArray(Deoxyhexose);
		int [] HexNAcs = ConvertStringToIntArray(HexNAc);	  int [] Pentoses =  ConvertStringToIntArray(Pentose);	
		int [] NeuAcs  = ConvertStringToIntArray(NeuAc);	  int [] Phosphates = ConvertStringToIntArray(Phosphate);	
		int [] NeuGcs  = ConvertStringToIntArray(NeuGc);	  int [] Sulphates = ConvertStringToIntArray(Sulphate);	
		
		
		
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
