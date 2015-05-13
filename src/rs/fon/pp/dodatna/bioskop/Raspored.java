package rs.fon.pp.dodatna.bioskop;


import java.util.GregorianCalendar;
import java.util.LinkedList;

import rs.fon.pp.dodatna.gui.GUIKontroler;
import rs.fon.pp.dodatna.sistemskeoperacije.SODodajFilm;
import rs.fon.pp.dodatna.sistemskeoperacije.SODodajProjekciju;
import rs.fon.pp.dodatna.sistemskeoperacije.SODodajSalu;
import rs.fon.pp.dodatna.sistemskeoperacije.SOPronadjiProjekcijeFilmDatum;
import rs.fon.pp.dodatna.sistemskeoperacije.SORezervisi;
import rs.fon.pp.dodatna.sistemskeoperacije.SOSacuvajUFajl;
import rs.fon.pp.dodatna.sistemskeoperacije.SOUcitajIzFajla;
import rs.fon.pp.dodatna.sistemskeoperacije.SOVratiDatume;
import rs.fon.pp.dodatna.sistemskeoperacije.SOVratiFilmove;
import rs.fon.pp.dodatna.sistemskeoperacije.SOVratiSveFilmove;
import rs.fon.pp.dodatna.sistemskeoperacije.SOVratiSveSale;


public class Raspored implements RasporedInterface{
	
	protected LinkedList<Projekcija> projekcije = new LinkedList<Projekcija>();
	public static LinkedList<Film> filmovi = new LinkedList<Film>();
	protected LinkedList<Sala> sale = new LinkedList<Sala>();
	
	public void dodajProjekciju(int sifra, Film film, int godina, int mesec, int dan, int sat, int minuti,
			Sala sala, boolean daLiJe3D, double cena) {
		SODodajProjekciju.dodajProjekciju(sifra, film, godina, mesec, dan, sat, minuti, sala, daLiJe3D, cena, projekcije);
	}
	
	/*public int pronadjiProjekcijuSifra(int sifra) {
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
	}*/
	
	public LinkedList<String> vratiFilmove() {
		return(SOVratiFilmove.vratiFilmove(projekcije));
	}
	
	public LinkedList<String> vratiDatume() {
		return (SOVratiDatume.vratiDatume(projekcije));
	}
	
	public LinkedList<Projekcija> pronadjiProjekcijeFilmDatum(String film, GregorianCalendar datum) {
		return(SOPronadjiProjekcijeFilmDatum.pronadjiProjekcijeFilmDatum(film, datum, projekcije));
	}
	
	public void rezervisi(String ime, int brojKarata, Projekcija p, int[] redniBrojeviSedista) {
		SORezervisi.rezervisi(ime, brojKarata, p, redniBrojeviSedista, projekcije);
	}
	
	public void sacuvajUFajl(String putanja) {
		SOSacuvajUFajl.sacuvajUFajl(putanja, projekcije, getFilmovi(), sale);
	}
	
	public void ucitajIzFajla(String putanja) {
		SOUcitajIzFajla.ucitajIzFajla(putanja, projekcije, getFilmovi(), sale);
	}
		
	public LinkedList<Projekcija> vratiSveProjekcije() {
		return projekcije;
	}
	
	public void dodajSalu(String naziv, int sifra, int brojSedista, int brojRedova) {
		SODodajSalu.dodajSalu(naziv, sifra, brojSedista, brojRedova, sale);
	}
	
	public void dodajFilm(Film film) {
		SODodajFilm.dodajFilm(film, filmovi);
	}
	public LinkedList<String> vratiSveFilmove() {
		return(SOVratiSveFilmove.vratiSveFilmove(getFilmovi()));
	}
	
	public LinkedList<String> vratiSveSale() {
		return(SOVratiSveSale.vratiSveSale(sale));
	}

	public static LinkedList<Film> getFilmovi() {
		return filmovi;
	}

	public void setFilmovi(LinkedList<Film> filmovi) {
		this.filmovi = filmovi;
	}
	
	public LinkedList<Sala> vratiSale() {
		return sale;
	}
}

