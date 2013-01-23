package glycoSpectrumScan;

import java.util.ArrayList;
import java.util.HashMap;

import Amino_acids.*;

public class ProteinSequenceSplit {
	
	public ArrayList <String> ProteinSequence_Trypsin(String s){
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		int index=0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == 'K' || s.charAt(i) == 'R')
			{
				if(i!=s.length()-1){
					if(s.charAt(i+1)!='P' ){
						String s2 = s.substring(index, i+1);
						ProteinSequenceSplit.add(s2);
						index=i+1;
					}
				}
			}
				
		}
		String left = s.substring(index, s.length());
		ProteinSequenceSplit.add(left);
		return ProteinSequenceSplit;
		
	}
	public ArrayList <String> ProteinSequence_Trypsin_H(String s){
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		String[] temp;
		s=s.replaceAll("KP", "kP");
		s=s.replaceAll("RP", "rP");
		s=s.replaceAll("CKY", "CkY");
		s=s.replaceAll("DKD", "DkD");
		s=s.replaceAll("CKH","CkH");
		s=s.replaceAll("CKD", "CkD");
		s=s.replaceAll("KKR","kkR");
		s=s.replaceAll("RRH","rrH");
		s=s.replaceAll("DRD", "DrD");
		
		int start=0;
		int end =0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='R' && s.charAt(i+1)=='R' && s.charAt(i+2)=='R'){
				start = i;
				for(int j=i; j<s.length(); j++){
					if(s.charAt(j)!='R'){
						end=j;
						i=j;
						break;
					}
				}
				StringBuilder myString = new StringBuilder(s);
				for(int j=start+1 ; j<end-1; j++){
					myString.setCharAt(j, 'r');
				}
				s=myString.toString();
				
			}
			
		}
	//	System.out.println(s);
	/*	String R=s.substring(start, end);
		StringBuilder myString = new StringBuilder(s);
		for(int i=start+1 ; i<end-2; i++){
			myString.setCharAt(i, 'r');
		}
		
		
		s=myString.toString(); */
		s=s.replaceAll("CRK","CrK");
		s=s.replaceAll("RRF","rrF");
		s=s.replaceAll("KRR","KrR");
		String delimiter = "(?<=K)|(?<=R)";
		temp = s.split(delimiter);
		
		
		for(int i=0; i<temp.length; i++){
		
			temp[i]=temp[i].toUpperCase();
			
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
			return ProteinSequenceSplit;
		
	}
	
	public ArrayList<String> ProteinSequence_LYS_C(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		int index=0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == 'K' )
			{
				if(i!=s.length()-1){
		
						String s2 = s.substring(index, i+1);
						ProteinSequenceSplit.add(s2);
						index=i+1;
	
				}
			}
				
		}
		String left = s.substring(index, s.length());
		ProteinSequenceSplit.add(left);
		return ProteinSequenceSplit;
	}
	public ArrayList<String> ProteinSequence_LYS_N(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		
		String[] temp;
		String delimiter = "(?=K)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		return ProteinSequenceSplit;
	}
	public ArrayList<String> ProteinSequence_CNBR(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		
		String[] temp;
		String delimiter = "(?<=M)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		return ProteinSequenceSplit;
		
	}
	
	public ArrayList<String> ProteinSequence_ARGC(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		int index=0;
		for(int i=0; i<s.length(); i++){
			if( s.charAt(i) == 'R')
			{
				if(i!=s.length()-1){
					if(s.charAt(i+1)!='P' ){
						String s2 = s.substring(index, i+1);
						ProteinSequenceSplit.add(s2);
						index=i+1;
					}
				}
			}
				
		}
		String left = s.substring(index, s.length());
		ProteinSequenceSplit.add(left);
		return ProteinSequenceSplit;
	}
	
	public ArrayList<String> ProteinSequence_ASPN(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		
		String[] temp;
		String delimiter = "(?=D)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		return ProteinSequenceSplit;
	}
	public ArrayList<String> ProteinSequence_ASPN_LYSC(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		
		String[] temp;
		String delimiter = "(?=D)|(?<=K)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		return ProteinSequenceSplit;
	}
	public ArrayList<String> ProteinSequence_ASPN_NTERMINA_GLU(String s) {
		
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		
		String[] temp;
		String delimiter = "(?=D)|(?=E)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		
		return ProteinSequenceSplit;
	}
	
	public ArrayList<String> ProteinSequence_ASPN_GLUC(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		
		String[] temp;
		String delimiter = "(?=D)|(?<=E)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		
		return ProteinSequenceSplit;
	}
	
	
	public ArrayList<String> ProteinSequence_GLU_C_BICARBONATE(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		int start=0;
		int end =0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='E' && s.charAt(i+1)=='E'){
				start = i;
				for(int j=i; j<s.length(); j++){
					if(s.charAt(j)!='E'){
						end=j;
						i=j;
						break;
					}
				}
				
				StringBuilder myString = new StringBuilder(s);
				for(int v=start ; v<end-1; v++){
					
						myString.setCharAt(v, 'e');
					
				}
				s=myString.toString();
				
			}
			
			
		}
		
		s=s.replaceAll("EP", "eP");
				
		String[] temp;
		String delimiter = "(?<=E)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		
		return ProteinSequenceSplit;
	}
	
	
	public ArrayList<String> ProteinSequence_Glu_C_P(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		
		int start=0;
		int end =0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='E' && s.charAt(i+1)=='E'){
				start = i;
				for(int j=i; j<s.length(); j++){
					if(s.charAt(j)!='E'){
						end=j;
						i=j;
						break;
					}
				}
				
				StringBuilder myString = new StringBuilder(s);
				for(int v=start ; v<end-1; v++){
					
						myString.setCharAt(v, 'e');
					
				}
				s=myString.toString();
				
			}
			
			
		}
	
		s=s.replaceAll("EP", "eP");
		s=s.replaceAll("DP", "dP");
		s=s.replaceAll("DE", "de");
		s=s.replaceAll("De", "de");
		
		
		String[] temp;
		String delimiter = "(?<=E)|(?<=D)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		
		return ProteinSequenceSplit;
	}
	
	
	public ArrayList<String> ProteinSequence_CHYMOTRYPSIN(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		s=s.replaceAll("FP", "fP");
		s=s.replaceAll("LP", "lP");
		s=s.replaceAll("MP", "mP");
		s=s.replaceAll("WP", "wP");
		s=s.replaceAll("YP", "yP");
		s=s.replaceAll("PY", "Py");
		
		String[] temp;
		String delimiter = "(?<=F)|(?<=L)|(?<=M)|(?<=W)|(?<=Y)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		
		return ProteinSequenceSplit;
	}
	
	public ArrayList<String> ProteinSequence_CHYMOTRYPSIN_FYW(String s) {
		// C-terminal side of F, Y, W	if P is C-term to F, Y, W, if P is N-term to Y
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		s=s.replaceAll("FP", "fP");
		s=s.replaceAll("YP", "yP");
		s=s.replaceAll("WP", "wP");
		s=s.replaceAll("PY", "Py");
		
		String[] temp;
		String delimiter = "(?<=F)|(?<=W)|(?<=Y)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		return ProteinSequenceSplit;
	}
	
	
	
	
	public ArrayList<String> ProteinSequence_GLU_C_P_LYS_C(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		
		int start=0;
		int end =0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)=='E' && s.charAt(i+1)=='E'){
				start = i;
				for(int j=i; j<s.length(); j++){
					if(s.charAt(j)!='E'){
						end=j;
						i=j;
						break;
					}
				}
				
				StringBuilder myString = new StringBuilder(s);
				for(int v=start ; v<end-1; v++){
					
						myString.setCharAt(v, 'e');
					
				}
				s=myString.toString();
				
			}
			
			
		}
		
		s=s.replaceAll("EP", "eP");
		s=s.replaceAll("DP", "dP");
		s=s.replaceAll("DE", "de");
		s=s.replaceAll("De", "de");
		
		
		String[] temp;
		String delimiter = "(?<=E)|(?<=D)|(?<=K)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		
		return ProteinSequenceSplit;
	}
	
	public ArrayList<String> ProteinSequence_MICROWAVE_A_F_A_H(String s) {
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		int index=0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == 'D' )
			{
				if(i!=s.length()-1){
		
						String s2 = s.substring(index, i+1);
						ProteinSequenceSplit.add(s2);
						index=i+1;
	
				}
			}
				
		}
		String left = s.substring(index, s.length());
		ProteinSequenceSplit.add(left);
		return ProteinSequenceSplit;
	}
	
	
	
	public ArrayList<String> ProteinSequence_TRYPSIN_CHYMOTRYPSIN(String s) {
		// C-terminal side of K, R, F, Y, W	if P is C-term to K, R, F, Y, W, if P is N-term to Y
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		s=s.replaceAll("KP", "kP");
		s=s.replaceAll("RP", "rP");
		s=s.replaceAll("FP", "fP");
		s=s.replaceAll("YP", "yP");
		s=s.replaceAll("WP", "wP");
		s=s.replaceAll("PY", "Py");
		
		String[] temp;
		String delimiter = "(?<=K)|(?<=R)|(?<=F)|(?<=Y)|(?<=W)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		
		return ProteinSequenceSplit;
		
	}
	public ArrayList<String> ProteinSequence_PEPSIN(String s) {
		// C-terminal side of F, L
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		String[] temp;
		String delimiter = "(?<=F)|(?<=L)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		
		return ProteinSequenceSplit;
	}
	
	
	public ArrayList<String> ProteinSequence_PEPSIN_PH_2(String s) {
		//C-terminal side of F, L, W, Y, A, E, Q	
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		String[] temp;
		String delimiter = "(?<=F)|(?<=L)|(?<=W)|(?<=Y)|(?<=A)|(?<=E)|(?<=Q)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		
		return ProteinSequenceSplit;
	}
	
	public ArrayList<String> ProteinSequence_THERMOLYSIN(String s) {
		// N-terminal side of A, F, I, L, M, V	if D or E is N-term to A, F, I, L, M, V
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		s=s.replaceAll("DA","Da");
		s=s.replaceAll("DF","Df");
		s=s.replaceAll("DI","Di");
		s=s.replaceAll("DL","Dl");
		s=s.replaceAll("DM","Dm");
		s=s.replaceAll("DV","Dv");
		
		s=s.replaceAll("EA","Ea");
		s=s.replaceAll("EF","Ef");
		s=s.replaceAll("EI","Ei");
		s=s.replaceAll("EL","El");
		s=s.replaceAll("EM","Em");
		s=s.replaceAll("EV","Ev");
		
		
		String[] temp;
		String delimiter = "(?=A)|(?=F)|(?=I)|(?=L)|(?=M)|(?=V)";
		temp = s.split(delimiter);
		
		for(int i=0; i<temp.length; i++){
			
			temp[i]=temp[i].toUpperCase();
			
			if(!temp[i].equals(""))
			ProteinSequenceSplit.add(temp[i]);
			
		}
		
		
		return ProteinSequenceSplit;
	}
	
	
		
	public ArrayList <String> ProteinSequence_Trypsin_even_before_P(String s){
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		int index=0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == 'K' || s.charAt(i) == 'R')
			{
				if(i!=s.length()-1){
		
						String s2 = s.substring(index, i+1);
						ProteinSequenceSplit.add(s2);
						index=i+1;
	
				}
			}
				
		}
		String left = s.substring(index, s.length());
		ProteinSequenceSplit.add(left);
		
		
		
		return ProteinSequenceSplit;
	}
	public ArrayList <String> ProteinSequence_Proteinase_K(String s){
		//A, F, Y, W, L, I, V
		ArrayList <String> ProteinSequenceSplit = new ArrayList();
		int index=0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == 'A' || s.charAt(i) == 'F' || s.charAt(i) == 'Y' || s.charAt(i) == 'W' || s.charAt(i) == 'L' || s.charAt(i) == 'I' || s.charAt(i) == 'V' ){
				if(i!=s.length()-1){
					String s2 = s.substring(index, i+1);
					ProteinSequenceSplit.add(s2);
					index=i+1;
				}
			}
			
		}
		String left = s.substring(index, s.length());
		ProteinSequenceSplit.add(left);
		return ProteinSequenceSplit;
		
	}
	
	public ArrayList<String> missed_cleavages(ArrayList <String> ProteinSequenceSplit, int Missed_cleavages){
		ArrayList <String> result = new ArrayList();
		result.addAll(ProteinSequenceSplit);
		
		if(Missed_cleavages == 0){
			return ProteinSequenceSplit;
		}else if(Missed_cleavages == 1 ){
			
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages));
			
		}else if(Missed_cleavages == 2){
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages-1));
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages));
		}else if(Missed_cleavages == 3){
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages-2));
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages-1));
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages));
		}else if(Missed_cleavages == 4){
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages-3));
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages-2));
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages-1));
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages));
		}else if(Missed_cleavages == 5){
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages-4));
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages-3));
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages-2));
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages-1));
			result.addAll(0,missed_cleavages_calculate(ProteinSequenceSplit,Missed_cleavages));
		}
			
		return result;
	}
	public ArrayList<String> missed_cleavages_calculate(ArrayList <String> ProteinSequenceSplit, int Missed_cleavages){
		ArrayList <String> result = new ArrayList();
		
		
		if(ProteinSequenceSplit.size() > Missed_cleavages )
			for(int i=0;i<ProteinSequenceSplit.size();i++){
		//		System.out.println(i);
				if(i==ProteinSequenceSplit.size()-Missed_cleavages) break;
				String s="";
				for(int j=0; j<Missed_cleavages+1; j++){
					s += ProteinSequenceSplit.get(i+j);
				}
				result.add(s);
			}
			return result;
		
		
	}
	
	public int[] GetMC(int [] MC_index, int Missed_cleavages,int [] MC){
		
		int start=0;
		for(int index: MC_index){
			
			index += start;
			for(int i=start; i<index; i++){
				MC[i] = Missed_cleavages;
			}
		//	System.out.println("index "+index);
			start = index;
			
			Missed_cleavages --;
		}
		return MC;
	}
	
	public PeptideMass getPeptideMass(ArrayList <String> ProteinSequenceSplit, String Method){
		AminoAcids A_a = new AminoAcids();
		HashMap Amino_acids_list=A_a.Amino_acids_list;
		
		PeptideMass PM = new PeptideMass(ProteinSequenceSplit);
		
		for(int i=0; i< ProteinSequenceSplit.size(); i++){
			String SubSequence = ProteinSequenceSplit.get(i);
			for(int j=0; j<SubSequence.length();j++){
				char Am = SubSequence.charAt(j);
				Amino A = (Amino)Amino_acids_list.get(Character.toString(Am));
				PM.monoisotopic_mass[i] += A.monoisotopic;
				PM.average_mass[i] += A.average;
				
			}
			PM.total_monoisotopic_mass +=PM.monoisotopic_mass[i];
			PM.total_average_mass += PM.average_mass[i];
			
			if(Method.equals("M+H")){
				PM.monoisotopic_mass[i] += 19;
				PM.average_mass[i] += 19;
			}else if(Method.equals("M")){
				PM.monoisotopic_mass[i] += 18;
				PM.average_mass[i] += 18;
			}else if(Method.equals("M-H")){
				PM.monoisotopic_mass[i] += 17;
				PM.average_mass[i] += 17;
			}else if(Method.equals("M+2H")){
				PM.monoisotopic_mass[i] += 20;
				PM.average_mass[i] += 20;
				PM.monoisotopic_mass[i] = PM.monoisotopic_mass[i]/2;
				PM.average_mass[i] = PM.average_mass[i]/2;
			}else if(Method.equals("M+3H")){
				PM.monoisotopic_mass[i] += 21;
				PM.average_mass[i] += 21;
				PM.monoisotopic_mass[i]  =PM.monoisotopic_mass[i] /3;
				PM.average_mass[i] = PM.average_mass[i]/3; 
			}
			
		}
		PM.total_monoisotopic_mass += 18;
		PM.total_average_mass +=18;
		
		
		
			
		return PM;
		
	}
	
	
	
	
	
	
	
	
	
}
