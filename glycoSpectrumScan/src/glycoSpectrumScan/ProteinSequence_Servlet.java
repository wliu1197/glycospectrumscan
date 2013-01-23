package glycoSpectrumScan;

import Amino_acids.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.*;

import uk.ac.ebi.kraken.interfaces.uniprot.UniProtEntry;
import uk.ac.ebi.kraken.uuw.services.remoting.Attribute;
import uk.ac.ebi.kraken.uuw.services.remoting.EntryRetrievalService;
import uk.ac.ebi.kraken.uuw.services.remoting.UniProtJAPI;


/**
 * Servlet implementation class ProteinSequence_Servlet
 */
public class ProteinSequence_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProteinSequenceSplit PSS = new ProteinSequenceSplit();
	ArrayList <String> ProteinSequenceSplit;
	
    public ProteinSequence_Servlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public int [] setMC(int Missed_cleavages){
		int [] MC;
		int [] MC_index = new int [Missed_cleavages+1];
		for(int i=0; i<MC_index.length; i++){
			MC_index[i] = ProteinSequenceSplit.size() - (Missed_cleavages-i);
		}
		ProteinSequenceSplit = PSS.missed_cleavages(ProteinSequenceSplit, Missed_cleavages);
		MC = new int [ProteinSequenceSplit.size()];
		MC = PSS.GetMC(MC_index, Missed_cleavages, MC);
		return MC;
	}
	public static String getSequence(String accession){
			String sequence="";
			EntryRetrievalService entryRetrievalService = UniProtJAPI.factory.getEntryRetrievalService();
		//	UniProtEntry entry = (UniProtEntry) entryRetrievalService.getUniProtEntry(accession);
			//If entry with a given accession number is not found, entry will be equal null
		//	if (entry != null) {
				Object attribute = UniProtJAPI.factory.getEntryRetrievalService().getUniProtAttribute(accession ,  "ognl:sequence.value");
				sequence = attribute.toString();
			
		//	}
		
			return sequence;
	}	
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ProteinSequence = request.getParameter("ProteinSequence").toString().toUpperCase();
		String Enzyme = request.getParameter("Enzyme").toString().toUpperCase();
		String Method = request.getParameter("Method").toString().toUpperCase();
		String NumberOfGlycans = request.getParameter("glycans").toString();
		String missed_cleavages = request.getParameter("missed_cleavages").toString();
		String total_monoisotopic_masss = request.getParameter("total_monoisotopic_mass").toString();
		String total_average_masss = request.getParameter("total_average_mass").toString();
		String Treat = request.getParameter("Treat").toString().toUpperCase();
		
		System.out.println(Treat);
		ArrayList <glycans> glycans = new ArrayList();
		if(request.getParameterValues("gs_monoisotopic_mass")!=null){
			String [] gs_monoisotopic_mass = request.getParameterValues("gs_monoisotopic_mass");	
			String [] gs_average_mass = request.getParameterValues("gs_average_mass");		
			
			
			
			for(int i=0; i<gs_monoisotopic_mass.length; i++){
				glycans g = new glycans();
				g.Monoisotopic_Mass = Double.parseDouble(gs_monoisotopic_mass[i]);
				g.Average_Mass=Double.parseDouble(gs_average_mass[i]);
				glycans.add(g);
			}
			
			
			
		}
		if(total_monoisotopic_masss.equals("")){
			total_monoisotopic_masss ="0";
		}
		if(total_average_masss.equals("")){
			total_average_masss ="0";
			
		}
		
		double total_monoisotopic_mass = new Double(total_monoisotopic_masss);
		double total_average_mass = new Double(total_average_masss);
		
		int [] MC;
		int Missed_cleavages;
		Missed_cleavages = Integer.parseInt(missed_cleavages);
		
		int Num_Glycans;
		if(NumberOfGlycans.equals("")){
			Num_Glycans = 0;	
		}else{
		    Num_Glycans =Integer.parseInt(NumberOfGlycans);
		}
		
		EntryRetrievalService entryRetrievalService = UniProtJAPI.factory.getEntryRetrievalService();
		UniProtEntry entry = (UniProtEntry) entryRetrievalService.getUniProtEntry(ProteinSequence);
		//If entry with a given accession number is not found, entry will be equal null
		
		if(entry!=null){
			String s = getSequence(ProteinSequence);
			ProteinSequence = s ;
		
		}else{
			ProteinSequence=ProteinSequence.replaceAll("[^A-Z]", "");
			ProteinSequence=ProteinSequence.replaceAll("[B]", "");
			ProteinSequence=ProteinSequence.replaceAll("[J]", "");
			ProteinSequence=ProteinSequence.replaceAll("[X]", "");
			ProteinSequence=ProteinSequence.replaceAll("[Z]", "");
		
		}
		
	/*	
		if(ProteinSequence.matches(".*\\d.*") ){
			String s = getSequence(ProteinSequence);
			ProteinSequence = s ;
	//		System.out.println(ProteinSequence);
				if(ProteinSequence.equals("")){
				 ProteinSequence = request.getParameter("ProteinSequence").toString().toUpperCase();
				 ProteinSequence=ProteinSequence.replaceAll("[^A-Z]", "");
				}
			
			} else{
				ProteinSequence=ProteinSequence.replaceAll("[^A-Z]", "");
			}
	//	System.out.println(ProteinSequence);
		*/
		
		
					
		if(Enzyme.equals("TRYPSIN")){
			ProteinSequenceSplit = PSS.ProteinSequence_Trypsin(ProteinSequence);
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("TRYPSIN_EVENP")){
			ProteinSequenceSplit = PSS.ProteinSequence_Trypsin_even_before_P(ProteinSequence);
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
		
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
			
		}else if(Enzyme.equals("TRYPSINH")){
			ProteinSequenceSplit = PSS.ProteinSequence_Trypsin_H(ProteinSequence);
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
		
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("PROTEINASE_K")){
			ProteinSequenceSplit = PSS.ProteinSequence_Proteinase_K(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
		
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		}else if(Enzyme.equals("LYS_C")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_LYS_C(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("LYS_N")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_LYS_N(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("CNBR")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_CNBR(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("ARG_C")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_ARGC(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("ASPN")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_ASPN(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("ASPN_LYSC")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_ASPN_LYSC(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("ASPN_NTERMINA_GLU")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_ASPN_NTERMINA_GLU(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("ASPN_GLUC")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_ASPN_GLUC(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("GLU_C_BICARBONATE")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_GLU_C_BICARBONATE(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("GLU_C_P")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_Glu_C_P(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("GLU_C_P_LYS_C")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_GLU_C_P_LYS_C(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("MICROWAVE_A_F_A_H")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_MICROWAVE_A_F_A_H(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("CHYMOTRYPSIN")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_CHYMOTRYPSIN(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("CHYMOTRYPSIN_FYW")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_CHYMOTRYPSIN_FYW(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("TRYPSIN_CHYMOTRYPSIN")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_TRYPSIN_CHYMOTRYPSIN(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("PEPSIN")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_PEPSIN(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("PEPSIN_PH_2")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_PEPSIN_PH_2(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else if(Enzyme.equals("THERMOLYSIN")){
			
			ProteinSequenceSplit = PSS.ProteinSequence_THERMOLYSIN(ProteinSequence);
			
			if(ProteinSequenceSplit.size() <= Missed_cleavages){
				Missed_cleavages = ProteinSequenceSplit.size()-1;
			}
			MC = setMC(Missed_cleavages);
			request.setAttribute("MC",MC);
		
		}else {
			ProteinSequenceSplit=null;
		}
		
		
				
		PeptideMass PM=PSS.getPeptideMass(ProteinSequenceSplit,Method);
		glyco_sequence gs = new glyco_sequence(PM.ProteinSequenceSplit,Num_Glycans,glycans);
		
		if(Treat.equals("LODOACETAMID")){
			/* count how many time c appear in sequence*/
			
			for(int i=0; i<PM.ProteinSequenceSplit.size(); i++){
				int count = 0;
			    int idx = 0;
				System.out.println(PM.ProteinSequenceSplit.get(i));
				System.out.print(PM.average_mass[i]+" ");
				System.out.println(PM.monoisotopic_mass[i]);
				
				while ((idx = PM.ProteinSequenceSplit.get(i).indexOf("C", idx)) != -1)
			     {
			        idx++;
			        count++;
			     }
				PM.average_mass[i] = PM.average_mass[i] + count*57.052;
				PM.monoisotopic_mass[i] = PM.monoisotopic_mass[i]+count*57.02146;
				
				System.out.println(PM.ProteinSequenceSplit.get(i));
				System.out.print(PM.average_mass[i]+" ");
				System.out.println(PM.monoisotopic_mass[i]);
				
			}
		}
		
	
		double [] glyco_sequence_m_mass = new double [gs.glyco_sequence.size()];
		double [] glyco_sequence_a_mass = new double [gs.glyco_sequence.size()];
		
		for(int i=0; i<gs.glyco_sequence.size();i++){
			for(int j=0; j<PM.ProteinSequenceSplit.size();j++)
				if(gs.glyco_sequence.get(i).equals(PM.ProteinSequenceSplit.get(j))){
					glyco_sequence_m_mass[i] = PM.monoisotopic_mass[j];
					glyco_sequence_a_mass[i] = PM.average_mass[j];
					
				}
		}
		
		LinkedList <NewMass_GS> gs_NM = new LinkedList();
		
		for(int i=0; i<gs.Combination.size();i++){
		//	System.out.println("Mass before adding to " +gs.glyco_sequence.get(i)+" is:"+ glyco_sequence_m_mass[i]+" "+ glyco_sequence_a_mass[i]);
			
			NewMass_GS ngs = new NewMass_GS();
			
			for(int j=0; j<gs.Combination.get(i).Combination.size(); j++){
				ngs.new_m_mass.add(glyco_sequence_m_mass[i]+gs.Combination.get(i).m_mass[j]);
				ngs.new_a_mass.add(glyco_sequence_a_mass[i]+gs.Combination.get(i).a_mass[j]);
				
		//		System.out.println(gs.Combination.get(i).Combination.get(j)+" : " +gs.Combination.get(i).m_mass[j]+" "+ gs.Combination.get(i).a_mass[j]);
			}
			gs_NM.add(ngs);
		}
		
		
		
		String write_file="";
		
		for(int i=0; i<gs_NM.size(); i++){
			write_file += "Mass before adding to " +gs.glyco_sequence.get(i)+" is:"+ glyco_sequence_m_mass[i]+" "+ glyco_sequence_a_mass[i]+"\n";
		//	System.out.println("Mass before adding to " +gs.glyco_sequence.get(i)+" is:"+ glyco_sequence_m_mass[i]+" "+ glyco_sequence_a_mass[i]);
			
			for(int j=0; j<gs_NM.get(i).new_m_mass.size(); j++){
				write_file += gs.Combination.get(i).Combination.get(j)+": New Monoisotopic mass:"+gs_NM.get(i).new_m_mass.get(j)+" New Average mass:"+gs_NM.get(i).new_a_mass.get(j)+"\n"; 
			//	System.out.println(gs.Combination.get(i).Combination.get(j)+" : " +gs.Combination.get(i).m_mass[j]+" "+ gs.Combination.get(i).a_mass[j]);
			//	System.out.println("new m mass is : "+ gs_NM.get(i).new_m_mass.get(j)+" new a mass is: "+ gs_NM.get(i).new_a_mass.get(j)  );
			}
			
		}
		
		
		String tempFile = "C:/Job/Milestones/glycoSpectrumScan/WebContent/upload/Result.txt";
		//Delete if tempFile exists
		File fileTemp = new File(tempFile);
		if (fileTemp.exists()){
		    fileTemp.delete();
		}
		
		FileUtils.writeStringToFile(new File("C:/Job/Milestones/glycoSpectrumScan/WebContent/upload/Result.txt"), write_file);
		
		
	//	System.out.println(write_file);
		request.setAttribute("total_monoisotopic_mass", total_monoisotopic_mass);
		request.setAttribute("total_average_mass", total_average_mass);
		request.setAttribute("Num_Glycans",NumberOfGlycans);
		request.setAttribute("ProteinSequence",ProteinSequence);
		request.setAttribute("PeptideMass",PM);
		request.setAttribute("glyco_sequence",gs);
		request.setAttribute("gs_NM",gs_NM);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProteinSequenceResult.jsp");
		if (dispatcher != null){

			  dispatcher.forward(request, response);

		} 
		
		
	
		
	
	}

}
