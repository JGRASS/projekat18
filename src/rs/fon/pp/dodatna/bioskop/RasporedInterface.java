package rs.fon.pp.dodatna.bioskop;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface RasporedInterface {
	
	public void dodajProjekciju(Projekcija p);
	public void dodajSalu(Sala sala);
	public void dodajFilm(Film film);
	public void ucitajIzFajla(String putanja);
	public void sacuvajUFajl(String putanja);
	
	public LinkedList<Projekcija> pronadjiProjekcijeFilmDatum(String film, GregorianCalendar datum);
	public void rezervisi(String ime, int brojKarata, Projekcija p, int[] redniBrojeviSedista);
	
	public LinkedList<Projekcija> vratiProjekcije();
	public LinkedList<Sala> vratiSale();	
	public LinkedList<Film> vratiFilmove();
	
	public LinkedList<String> vratiFilmoveString();
	public LinkedList<String> vratiDatumeString();
	
	public LinkedList<String> vratiSveFilmoveString();
	public LinkedList<String> vratiSveSaleString();

}
