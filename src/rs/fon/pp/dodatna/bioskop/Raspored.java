package rs.fon.pp.dodatna.bioskop;


import java.util.GregorianCalendar;
import java.util.LinkedList;

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
	protected LinkedList<Film> filmovi = new LinkedList<Film>();
	protected LinkedList<Sala> sale = new LinkedList<Sala>();
	
	public void dodajProjekciju(Projekcija projekcija) {
		SODodajProjekciju.dodajProjekciju(projekcija, projekcije);
	}
	
	public LinkedList<String> vratiFilmoveString() {
		return(SOVratiFilmove.vratiFilmove(projekcije));
	}
	
	public LinkedList<String> vratiDatumeString() {
		return (SOVratiDatume.vratiDatume(projekcije));
	}
	
	public LinkedList<Projekcija> pronadjiProjekcijeFilmDatum(String film, GregorianCalendar datum) {
		return(SOPronadjiProjekcijeFilmDatum.pronadjiProjekcijeFilmDatum(film, datum, projekcije));
	}
	
	public void rezervisi(String ime, int brojKarata, Projekcija p, int[] redniBrojeviSedista) {
		SORezervisi.rezervisi(ime, brojKarata, p, redniBrojeviSedista, projekcije);
	}
	
	public void sacuvajUFajl(String putanja) {
		SOSacuvajUFajl.sacuvajUFajl(putanja, projekcije, filmovi, sale);
	}
	
	public void ucitajIzFajla(String putanja) {
		SOUcitajIzFajla.ucitajIzFajla(putanja, projekcije, filmovi, sale);
	}
	
	public void dodajSalu(Sala sala) {
		SODodajSalu.dodajSalu(sala, sale);
	}
	
	public void dodajFilm(Film film) {
		SODodajFilm.dodajFilm(film, filmovi);
	}
	public LinkedList<String> vratiSveFilmoveString() {
		return(SOVratiSveFilmove.vratiSveFilmove(filmovi));
	}
	
	public LinkedList<String> vratiSveSaleString() {
		return(SOVratiSveSale.vratiSveSale(sale));
	}
	
	public LinkedList<Sala> vratiSale() {
		return sale;
	}

	public LinkedList<Projekcija> vratiProjekcije() {
		return projekcije;
	}
	public LinkedList<Film> vratiFilmove() {
		return filmovi;
	}
}

