package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Projekcija;

public class SOPronadjiProjekcijeFilmDatum {
	
	public static LinkedList<Projekcija> pronadjiProjekcijeFilmDatum(String film, GregorianCalendar datum, LinkedList<Projekcija> projekcije) {
		LinkedList<Projekcija> izabrane = new LinkedList<Projekcija>();
		try {

			for (int i = 0; i < projekcije.size(); i++) {
				if(projekcije.get(i).getFilm().getNaziv().indexOf(film) != -1 &&
						datum.get(GregorianCalendar.YEAR) == projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.YEAR) &&
						datum.get(GregorianCalendar.MONTH) == projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.MONTH) &&
						datum.get(GregorianCalendar.DAY_OF_MONTH) == projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.DAY_OF_MONTH))
					izabrane.add(projekcije.get(i));
			}
		} catch (Exception e) {
			throw new RuntimeException("Nije nađena projekcija, greška!");
		}
		return izabrane;
	}
}
