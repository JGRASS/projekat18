package rs.fon.pp.dodatna.bioskop;

import java.util.LinkedList;

//treba da napravimo interfejs za sve metode koje ce biti u klasi Projekcija, a mozda nam i treba jos jedna klasa koja se odnosi na ove "manje" metode, koje ce biti 
//koriscene tamo ili... nisam sigurna, samo u svim primerima koje smo radili u toj "glavnoj" klasi
//su samo te metode koje se odnose na objekte iz liste odn. projekcije.
public class PomocnaZaMetode {
	
	public static Film dodajFilm(String naziv, String zanr, int trajanje, int godina1, int mesec1, int dan1, int godina2, int mesec2, int dan2) {
		Film film = new Film();
		film.setNaziv(naziv);
		film.setZanr(zanr);
		film.setVremeTrajanja(trajanje);
		film.setDatumPocetka(godina1, mesec1, dan1);
		film.setDatumZavrsetka(godina2, mesec2, dan2);
		return film;
		
	}
	
	private void dodajSalu(String naziv, int sifra, int brojSedista, int brojRedova) {
		Sala sala = new Sala();
		sala.setNaziv(naziv);
		sala.setSifra(sifra);
		sala.setSedista(brojSedista);
		sala.setBrojRedova(brojRedova);
	}
}