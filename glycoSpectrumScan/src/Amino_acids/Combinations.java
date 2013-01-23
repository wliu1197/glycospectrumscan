package Amino_acids;

import java.util.ArrayList;
import java.util.LinkedList;

public class Combinations {
	public LinkedList <String> Combination = new LinkedList();
	public double [] m_mass;
	public double [] a_mass;
	
	public void CalculateMass(int size, ArrayList <glycans> glycans){
		m_mass = new double[size];
		a_mass = new double[size];
	
		
		if(glycans.size()!=0){
			for(int i=0; i<Combination.size(); i++){
				String com = Combination.get(i);		
				String[] temp;
				String delimiter = " ";
				temp = com.split(delimiter);
				double m=0;
				double a=0;
				for(String s : temp){
					int Glycan_Number = Integer.parseInt(s) -1;
					m += glycans.get(Glycan_Number).Monoisotopic_Mass;
					a += glycans.get(Glycan_Number).Average_Mass;
				}
				
				m_mass[i] =m;
				a_mass[i] =a;
			}
		}
	}
}
