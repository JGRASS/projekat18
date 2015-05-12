package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Projekcija;

public class SOVratiFilmove {
	
	public static LinkedList<String> vratiFilmove(LinkedList<Projekcija> projekcije) {
		
		LinkedList<String> filmovi = new LinkedList<String>();
		for (int i = 0; i < projekcije.size(); i++) {
			if(filmovi.isEmpty() || !(filmovi.contains(projekcije.get(i).getFilm().getNaziv())))
				filmovi.add(projekcije.get(i).getFilm().getNaziv());
			else 
						continue;
		}
		return filmovi;
	}
}