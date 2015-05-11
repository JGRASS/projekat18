package rs.fon.pp.dodatna.bioskop;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface RasporedInterface {
	
	public void dodajProjekciju(int sifra, Film film, int godina, int mesec, int dan, int sat, int minuti, Sala sala, boolean daLiJe3D, double cena);
	public int pronadjiProjekcijuSifra(int sifra);
	public LinkedList<Projekcija> pronadjiProjekcijeFilmDatum(String film, GregorianCalendar datum);
	public void rezervisi(String ime, int brojKarata, Projekcija p, int[] redniBrojeviSedista);
	public void ucitajIzFajla(String putanja);
	public void sacuvajUFajl(String putanja);
	public LinkedList<Projekcija> vratiSveProjekcije();
	public LinkedList<String> vratiFilmove(LinkedList<Projekcija> projekcije);
	public LinkedList<String> vratiDatume(LinkedList<Projekcija> projekcije);
	
	
}
