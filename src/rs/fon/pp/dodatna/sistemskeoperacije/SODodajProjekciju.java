package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;
import rs.fon.pp.dodatna.bioskop.Projekcija;


public class SODodajProjekciju {
	
	public static void dodajProjekciju(Projekcija projekcija, LinkedList<Projekcija> projekcije) {
		if(projekcija != null && !(projekcije.contains(projekcija)))
			projekcije.add(projekcija);
		else
			throw new RuntimeException("Projekcija je već uneta u sistem ili ste pokušali uneti null objekat.");
	}
}
