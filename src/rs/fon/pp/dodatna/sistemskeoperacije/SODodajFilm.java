package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Film;

public class SODodajFilm {
	
	public static void dodajFilm(Film film, LinkedList<Film> filmovi) {
		if(!(filmovi.contains(film)) && film != null)
		filmovi.add(film);
		else
			throw new RuntimeException("Film je već unet u sistem ili ste pokušali uneti null objekat.");
	}
}
