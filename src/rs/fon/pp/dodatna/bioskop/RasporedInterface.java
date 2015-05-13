package rs.fon.pp.dodatna.bioskop;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface RasporedInterface {
	
	public void dodajProjekciju(int sifra, Film film, int godina, int mesec, int dan, int sat, int minuti,
			Sala sala, boolean daLiJe3D, double cena);
	public LinkedList<Projekcija> pronadjiProjekcijeFilmDatum(String film, GregorianCalendar datum);
	public void rezervisi(String ime, int brojKarata, Projekcija p, int[] redniBrojeviSedista);
	public void ucitajIzFajla(String putanja);
	public void sacuvajUFajl(String putanja);
	public LinkedList<Projekcija> vratiSveProjekcije();
	public LinkedList<String> vratiFilmove();
	public LinkedList<String> vratiDatume();
	public void dodajSalu(String naziv, int sifra, int brojSedista, int brojRedova);
	public void dodajFilm(Film film);
	public LinkedList<String> vratiSveFilmove();
	public LinkedList<String> vratiSveSale();
	public LinkedList<Sala> vratiSale();
}
