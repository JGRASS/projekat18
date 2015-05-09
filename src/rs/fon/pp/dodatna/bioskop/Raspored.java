package rs.fon.pp.dodatna.bioskop;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Raspored implements RasporedInterface{
	
	LinkedList<Projekcija> projekcije;

	public void dodajProjekciju(int sifra, Film film, int godina, int mesec, int dan, int sat, int minuti, Sala sala, boolean daLiJe3D, double cena) {
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
	
	public Projekcija pronadjiProjekcijuFilmDatum(String film, GregorianCalendar datum) {
		int pom = 0;
		try {

			for (int i = 0; i < projekcije.size(); i++) {
				if(projekcije.get(i).getFilm().getNaziv().indexOf(film) != -1 &&
						datum.get(GregorianCalendar.YEAR) == projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.YEAR) &&
						datum.get(GregorianCalendar.MONTH) == projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.MONTH) &&
						datum.get(GregorianCalendar.DAY_OF_MONTH) == projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.DAY_OF_MONTH))
					pom = i;
			}
		} catch (Exception e) {
			throw new RuntimeException("Nije nađena projekcija, greška!");
		}
		return projekcije.get(pom);
	}
	
	public void rezervisi(String ime, int brojKarata, Projekcija p, int[] redniBrojeviSedista) {
		Kupac k = new Kupac();
		k.setIme(ime);
		k.setBrojKarata(brojKarata);
		k.setBrojSedista(redniBrojeviSedista);
		for (int i = 0; i < projekcije.size(); i++) {
			if(projekcije.get(i).equals(p))
				projekcije.get(i).getKupci().add(k);
			for (int j = 0; j < redniBrojeviSedista.length; j++) {
				if(projekcije.get(i).sedista[j] == true)
					throw new RuntimeException("Ne možete rezervisati već zauzeto mesto.");
				else
					projekcije.get(i).sedista[j] = true;
			}
		}
	}
	
	
	
}

