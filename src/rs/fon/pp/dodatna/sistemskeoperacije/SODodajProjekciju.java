package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Film;
import rs.fon.pp.dodatna.bioskop.Projekcija;
import rs.fon.pp.dodatna.bioskop.Sala;

public class SODodajProjekciju {
	
	public static void dodajProjekciju(int sifra, Film film, int godina, int mesec, int dan, int sat, int minuti,
			Sala sala, boolean daLiJe3D, double cena, LinkedList<Projekcija> projekcije) {
		
		Projekcija p = new Projekcija();
		p.setFilm(film);
		p.setDatumPrikazivanja(godina, mesec, dan, sat, minuti);
		p.setSala(sala);
		p.setSedista(sala.getSedista().length);
		p.setDaLiJe3D(daLiJe3D);
		p.setCena(cena);
		p.setSifra(sifra);
		projekcije.add(p);
	}
}
