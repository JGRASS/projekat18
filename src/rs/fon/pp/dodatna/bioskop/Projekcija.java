package rs.fon.pp.dodatna.bioskop;

import java.io.Serializable;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Projekcija implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Film film;
	GregorianCalendar DatumIVremePrikazivanja;
	Sala sala;
	boolean daLiJe3D;
	double cena;
	boolean[] sedista; //e ljudi, ovde sam zastala, u trenutku sam shvatila kako nam ovo povezano sa int brojevima sedista i sad sam zbunjena
	LinkedList<Kupac> kupci;
	
	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		if(film == null || !(film instanceof Film))
			throw new RuntimeException("Uneli ste prazan objekat ili dati objekat nije zaista tipa Film");
		this.film = film;
	}

	public GregorianCalendar getDatumPrikazivanja() {
		return DatumIVremePrikazivanja;
	}

	public void setDatumPrikazivanja(int godina, int mesec, int dan, int sat, int minuti) {
		if(godina < 2015 || mesec < 0 || mesec > 12 || dan < 1 || dan > 31)
			throw new RuntimeException("Pogrešno uneti godina mesec ili dan.");
		if(sat < 0 || sat >= 24 || minuti < 0 || minuti > 59)
			throw new RuntimeException("Pogrešno uneti sat ili minuti.");
		GregorianCalendar datum = new GregorianCalendar(godina, mesec -1, dan, sat, minuti);
		DatumIVremePrikazivanja = datum;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		if(sala == null || !(sala instanceof Sala))
			throw new RuntimeException("Uneli ste prazan objekat ili dati objekat nije zaista tipa Sala");
		this.sala = sala;
	}

	public boolean isDaLiJe3D() {
		return daLiJe3D;
	}

	public void setDaLiJe3D(boolean daLiJe3D) {
		if(daLiJe3D != true || daLiJe3D != false)
			throw new RuntimeException("Greška.");
		this.daLiJe3D = daLiJe3D;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		if(cena <= 0)
			throw new RuntimeException("Cena mora biti pozitivan broj.");
		this.cena = cena;
	}

	public boolean[] getSedista() {
		return sedista;
	}

	public void setSedista(int brojSedista) {
		if(brojSedista < 0)
			throw new RuntimeException("Broj sedišta ne može biti nula.");
		this.sedista = new boolean[brojSedista];
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((DatumIVremePrikazivanja == null) ? 0
						: DatumIVremePrikazivanja.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cena);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (daLiJe3D ? 1231 : 1237);
		result = prime * result + ((film == null) ? 0 : film.hashCode());
		result = prime * result + ((kupci == null) ? 0 : kupci.hashCode());
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
		result = prime * result + Arrays.hashCode(sedista);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projekcija p = (Projekcija) obj;
		if(DatumIVremePrikazivanja.get(GregorianCalendar.HOUR) == p.getDatumPrikazivanja().get(GregorianCalendar.HOUR)
				&& DatumIVremePrikazivanja.get(GregorianCalendar.MINUTE) == p.getDatumPrikazivanja().get(GregorianCalendar.MINUTE)
				&& sala.getSifra() == p.getSala().getSifra())
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		//ovo moze da se jos dopise, ali videcemo tek kad dodamo i metode za izracunavanje broja kupljenih karata ili nes tako
		return "Tražena projekcija ima sledeće podatke - " + "\nFilm - " + film.toString() +
				"\nDatum i vreme prikazivanja: " + DatumIVremePrikazivanja.getTime() +
				"\nSala - " + sala.getNaziv();
	}
	
	

}
