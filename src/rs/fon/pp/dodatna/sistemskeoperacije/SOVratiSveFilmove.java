package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Film;

public class SOVratiSveFilmove {
	
	public static LinkedList<String> vratiSveFilmove(LinkedList<Film> filmovi) {
		LinkedList<String> filmoviString = new LinkedList<String>();
		for (int i = 0; i < filmovi.size(); i++) {
			String s = filmovi.get(i).getNaziv();
			filmoviString.add(s);
		}
		return filmoviString;
	}
}
