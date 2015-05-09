package rs.fon.pp.dodatna.bioskop;

import java.util.GregorianCalendar;

public interface RasporedInterface {
	
	public void dodajProjekciju(int sifra, Film film, int godina, int mesec, int dan, int sat, int minuti, Sala sala, boolean daLiJe3D, double cena);
	public int pronadjiProjekcijuSifra(int sifra);
	public Projekcija pronadjiProjekcijuFilmDatum(String film, GregorianCalendar datum);
	public void rezervisi(String ime, int brojKarata, Projekcija p, int[] redniBrojeviSedista);
	
	
}
