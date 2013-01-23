package Amino_acids;

import java.util.ArrayList;

public class PeptideMass {
	public ArrayList <String> ProteinSequenceSplit;
	public double [] average_mass;
	public double [] monoisotopic_mass;
	public double total_monoisotopic_mass;
	public double total_average_mass;
	
	public PeptideMass(ArrayList <String> s){
		
	this.ProteinSequenceSplit=s;
	this.average_mass= new double[s.size()];
	this.monoisotopic_mass= new double[s.size()];
	this.total_average_mass=0;
	this.total_monoisotopic_mass=0;
	}
}
