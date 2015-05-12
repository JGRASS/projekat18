package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Sala;

public class SODodajSalu {
	
	public static void dodajSalu(String naziv, int sifra, int brojSedista, int brojRedova, LinkedList<Sala> sale) {
		Sala sala = new Sala();
		sala.setNaziv(naziv);
		sala.setSifra(sifra);
		sala.setSedista(brojSedista);
		sala.setBrojRedova(brojRedova);
		if(!(sale.contains(sala)))
		sale.add(sala);
		else
			throw new RuntimeException("Sala je već uneta u sistem.");
	}

}
