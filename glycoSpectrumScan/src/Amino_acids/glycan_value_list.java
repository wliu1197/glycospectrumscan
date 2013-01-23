package Amino_acids;

import java.util.HashMap;

public class glycan_value_list {
	public HashMap glycan_value_list = new HashMap();
	public glycan_value_list(){
		glycan_value a = new glycan_value();
		a.name="Hexose";
		a.monoisotopic=162.0528;
		a.average=162.1424;
		glycan_value_list.put("Hexose", a);
		
		glycan_value b = new glycan_value();
		b.name="HexNAc";
		b.monoisotopic=203.0794;
		b.average=203.1950;
		glycan_value_list.put("HexNAc", b);
		
		glycan_value c = new glycan_value(); 
		c.name="Deoxyhexose";
		c.monoisotopic = 146.0579;
		c.average = 146.1430;
		glycan_value_list.put("Deoxyhexose", c);
		
		glycan_value d = new glycan_value();
		d.name="Pentose";
		d.monoisotopic=132.0423;
		d.average=132.1161;
		glycan_value_list.put("Pentose", d);
		
		glycan_value e = new glycan_value();
		e.name="NeuAc";
		e.monoisotopic=291.0954;
		e.average=291.2579;
		glycan_value_list.put("NeuAc", e);
		
		glycan_value f = new glycan_value();
		f.name="NeuGc";
		f.monoisotopic=307.0903;
		f.average=307.2573;
		glycan_value_list.put("NeuGc", f);
		
		glycan_value g = new glycan_value();
		g.name="Phosphate";
		g.monoisotopic=79.9663;
		g.average=79.9799;
		glycan_value_list.put("Phosphate", g);
		
		glycan_value h = new glycan_value();
		h.name="Sulphate";
		h.monoisotopic=79.9568;
		h.average=80.0642;
		glycan_value_list.put("Sulphate", h);
	}
	
}
