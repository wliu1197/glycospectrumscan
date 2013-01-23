package Amino_acids;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class glyco_sequence {
	/* all the sequence with Nx(S|T) but x can't be P */
	public ArrayList <String> glyco_sequence;
	public int[] Glycosylation_site;
	public double [] Possible_Combination_C;
	public LinkedList <Combinations> Combination = new LinkedList();
	
   	
	public glyco_sequence(ArrayList<String> ProteinSequenceSplit,int GlycansN,ArrayList <glycans> glycans){
		this.glyco_sequence = FindGlycoSequence(ProteinSequenceSplit);
		this.Glycosylation_site=new int[glyco_sequence.size()];
		this.Possible_Combination_C=new double[glyco_sequence.size()];
		Count_Glycosylation_site(glyco_sequence);
		Calculate_Possible_Combination_C(GlycansN);
		
		
		for(int i=0; i<Glycosylation_site.length; i++){
			
			Combination.add(FindCombinations(Possible_Combination_C[i],Glycosylation_site[i],GlycansN));
		
		}
		for(Combinations m: Combination){
			m.CalculateMass(m.Combination.size(), glycans);
		}
		
		
	}
	public Combinations FindCombinations(double C, int sites, int glycan_number){
		Combinations com = new Combinations();
		LinkedList <String> combination_c = new LinkedList();
		
		for(;;){
			if(combination_c.size()==C) break;
	    	int check =0;
	    	String combination="";
	    	int [] numbers = new int[sites];
	    	
		    for(int i=0; i<sites; i++){
				int randomNum = 1 + (int)(Math.random()*glycan_number); 
				numbers [i] = randomNum;
								    
		    }
		    Arrays.sort(numbers);
		    for(int i: numbers){
		    	String s=Integer.toString(i);
		    	combination += s+" ";
		    }
		
		    if(combination_c.size()==0) {
        	  combination_c.add(combination);
		    }else{
			    for(String s: combination_c){
			    	if(combination.equals(s)){
			    		check =0;
			    		break;
			    	}else{
			    		check =1;
			    	}
			    }
			    if(check==1){
			    	combination_c.add(combination);
			    }
		    }
		    	
    	}
     
	    com.Combination.addAll(combination_c);
	    
	    return com;
	}
	
	
	
	public ArrayList<String> FindGlycoSequence(ArrayList<String> ProteinSequenceSplit ){
		ArrayList<String> result = new ArrayList();
		
		Pattern p = Pattern.compile("N[^P][ST]");
		int index=0;
		for(String s: ProteinSequenceSplit){
			
			Matcher m = p.matcher(s);	
			int count =0;
			if(m.find()){
				result.add(s);
			}
			
		}	
		
		
		return result;
	}
	public void Count_Glycosylation_site(ArrayList <String> glyco_sequence){
		Pattern p = Pattern.compile("N[^P][ST]");
		for(int i=0; i<glyco_sequence.size(); i++){
			Matcher m = p.matcher(glyco_sequence.get(i));
			int count=0;
			while(m.find()){
				count++;
			}
			Glycosylation_site[i]=count;
		}
		
	}
	
	public void Calculate_Possible_Combination_C(int GlycansN){
		if(GlycansN==0){
			for(int i=0;i<Possible_Combination_C.length; i++){
				Possible_Combination_C[i]=0;
			}
		}else{
			for(int i=0;i<Possible_Combination_C.length; i++){
				Possible_Combination_C[i]=Calculate_Possible_Combination_C_equation(GlycansN,Glycosylation_site[i]);
			}
		}
	}
	public double Calculate_Possible_Combination_C_equation(int GlycansN, int Glycosylation_site_k){
	 	
		double Possible_Combination;
		if(GlycansN == 18){
			long temp  = factorial(17+Glycosylation_site_k-1)/factorial(Glycosylation_site_k);
					
			long temp2 = temp /factorial(GlycansN-1);
			
			long temp3 = temp2 * (18+Glycosylation_site_k-1);
		
		    Possible_Combination =(double)temp3;
		    
		}else if(GlycansN == 19){
			if( Glycosylation_site_k ==1){
				Possible_Combination = 19.0;
			}else if(Glycosylation_site_k == 2){
				Possible_Combination = 190.0;
			}else if(Glycosylation_site_k == 3){
				Possible_Combination = 1330.0;
			}else if(Glycosylation_site_k == 4){
				Possible_Combination = 7315.0;
			}else{
				long n =(long) GlycansN+Glycosylation_site_k-1;
			 	long numerator =factorial(n);
			 	long denominator = factorial(Glycosylation_site_k)*factorial(GlycansN-1);
			    Possible_Combination=((double)numerator)/denominator;
			}
			
		}else if(GlycansN == 20){
			if( Glycosylation_site_k ==1){
				Possible_Combination = 20.0;
			}else if(Glycosylation_site_k == 2){
				Possible_Combination = 210.0;
			}else if(Glycosylation_site_k == 3){
				Possible_Combination = 1540.0;
			}else if(Glycosylation_site_k == 4){
				Possible_Combination = 8855.0;
			}else{
				long n =(long) GlycansN+Glycosylation_site_k-1;
			 	long numerator =factorial(n);
			 	long denominator = factorial(Glycosylation_site_k)*factorial(GlycansN-1);
			    Possible_Combination=((double)numerator)/denominator;
			}
		}else if(GlycansN >20){
			BigInteger numerator = factorials(GlycansN+Glycosylation_site_k-1);
			BigInteger denominator = factorials(Glycosylation_site_k).multiply( factorials(GlycansN-1));
			Possible_Combination  = numerator.divide(denominator).doubleValue() ;
		}else{
		
		
	 	long n =(long) GlycansN+Glycosylation_site_k-1;
	 	long numerator =factorial(n);
	 	long denominator = factorial(Glycosylation_site_k)*factorial(GlycansN-1);
	    Possible_Combination=((double)numerator)/denominator;
		}
		
		return Possible_Combination;
		
	}
	public long factorial(long n) {
        long result =1;
        for (int i = 1; i < n+1; i++) {
            result = result* i;
        }
        return result;
    }
	public BigInteger factorials(int n){
		
		BigInteger result = BigInteger.valueOf(1);;
		
		for (int i = 1; i < n+1; i++) {
            result = result.multiply(BigInteger.valueOf(i)); 
        }
		
		return result;
	}
	
	
}
