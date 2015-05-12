package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Film;

public class SODodajFilm {
	
	public static void dodajFilm(String naziv, String zanr, int trajanje, int godina1, int mesec1, int dan1, 
			int godina2, int mesec2, int dan2, LinkedList<Film> filmovi) {
		Film film = new Film();
		film.setNaziv(naziv);
		film.setZanr(zanr);
		film.setVremeTrajanja(trajanje);
		film.setDatumPocetka(godina1, mesec1, dan1);
		film.setDatumZavrsetka(godina2, mesec2, dan2);
		if(!(filmovi.contains(film)))
		filmovi.add(film);
		else
			throw new RuntimeException("Film je već unet u sistem.");
	}
}
