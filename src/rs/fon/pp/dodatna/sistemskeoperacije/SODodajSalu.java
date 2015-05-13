package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Sala;

public class SODodajSalu {
	
	public static void dodajSalu(Sala sala, LinkedList<Sala> sale) {
		if(!(sale.contains(sala)) && sala != null)
		sale.add(sala);
		else
			throw new RuntimeException("Sala je već uneta u sistem ili ste pokušali uneti null objekat.");
	}

}
