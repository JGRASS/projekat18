package rs.fon.pp.dodatna.bioskop;


import java.util.GregorianCalendar;
import java.util.LinkedList;

import rs.fon.pp.dodatna.sistemskeoperacije.SOPronadjiProjekcijeFilmDatum;
import rs.fon.pp.dodatna.sistemskeoperacije.SORezervisi;
import rs.fon.pp.dodatna.sistemskeoperacije.SOSacuvajUFajl;
import rs.fon.pp.dodatna.sistemskeoperacije.SOUcitajIzFajla;


public class Raspored implements RasporedInterface{
	public static LinkedList<Film> filmovi = new LinkedList<Film>();
	protected LinkedList<Projekcija> projekcije;
	
	public void dodajFilm(String naziv, String zanr, int trajanje, int godina1, int mesec1, int dan1, int godina2, int mesec2, int dan2) {
		Film film = new Film();
		film.setNaziv(naziv);
		film.setZanr(zanr);
		film.setVremeTrajanja(trajanje);
		film.setDatumPocetka(godina1, mesec1, dan1);
		film.setDatumZavrsetka(godina2, mesec2, dan2);
	}
	
	public void dodajSalu(String naziv, int sifra, int brojSedista, int brojRedova) {
		Sala sala = new Sala();
		sala.setNaziv(naziv);
		sala.setSifra(sifra);
		sala.setSedista(brojSedista);
		sala.setBrojRedova(brojRedova);
	}

	public void dodajProjekciju(int sifra, Film film, int godina, int mesec, int dan, int sat, int minuti, Sala sala, boolean daLiJe3D, double cena) {
		Projekcija p = new Projekcija();
		p.setFilm(film);
		p.setDatumPrikazivanja(godina, mesec, dan, sat, minuti);
		p.setSala(sala);
	//	p.setSedista(sala.getSedista().length);
		p.setDaLiJe3D(daLiJe3D);
		p.setCena(cena);
		p.setSifra(sifra);
		projekcije.add(p);
	}
	
	public int pronadjiProjekcijuSifra(int sifra) {
		try {
			int pom = 0;
			for (int i = 0; i < projekcije.size(); i++) {
				if(projekcije.get(i).getSifra() == sifra)
					pom = i;
			}
			return pom;
		} catch (Exception e) {
			throw new RuntimeException("Projekcija nije nađena.");
		}
	}
	
	public LinkedList<String> vratiFilmove(LinkedList<Projekcija> projekcije) {
		LinkedList<String> filmovi = new LinkedList<String>();
		for (int i = 0; i < projekcije.size(); i++) {
			if(filmovi.isEmpty())
				filmovi.add(projekcije.get(i).getFilm().getNaziv());
			else {
				if(filmovi.contains(projekcije.get(i).getFilm().getNaziv()))
						continue;
			}	
		}
		return filmovi;
	}
	
	public LinkedList<String> vratiDatume(LinkedList<Projekcija> projekcije) {
		LinkedList<String> datumi = new LinkedList<String>();
		for (int i = 0; i < projekcije.size(); i++) {
			String datum = projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.DAY_OF_MONTH) + "/" +
					projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.MONTH) + "/" +
					projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.YEAR);
			if(datumi.isEmpty() || !(datumi.contains(datum))) {
				datumi.add(datum);
			}
			else 
				continue;
		}
		return datumi;
	}
	
	public LinkedList<Projekcija> pronadjiProjekcijeFilmDatum(String film, GregorianCalendar datum) {
		return(SOPronadjiProjekcijeFilmDatum.pronadjiProjekcijeFilmDatum(film, datum, projekcije));
	}
	
	public void rezervisi(String ime, int brojKarata, Projekcija p, int[] redniBrojeviSedista) {
		SORezervisi.rezervisi(ime, brojKarata, p, redniBrojeviSedista, projekcije);
	}
	
	public void sacuvajUFajl(String putanja) {
		SOSacuvajUFajl.sacuvajUFajl(putanja, projekcije);
	}
	
	public void ucitajIzFajla(String putanja) {
		SOUcitajIzFajla.ucitajIzFajla(putanja, projekcije);
	}
		
	public LinkedList<Projekcija> vratiSveProjekcije() {
		return projekcije;
	}
}

