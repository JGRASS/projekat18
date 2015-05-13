package rs.fon.pp.dodatna.bioskop;

import java.io.Serializable;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Ova klasa predstavlja projekciju jednog filma u bioskopu.
 *@author team18
 *@version 1.0
 */
public class Projekcija implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Sifra projekcije
	 */
	private int sifra;
	
	/**
	 * Film koji se prikazuje
	 */
	Film film;
	
	/**
	 * Datum i vreme prikazivanja filma
	 */
	GregorianCalendar DatumIVremePrikazivanja;
	
	/**
	 * Bioskopska sala
	 */
	Sala sala;
	
	/**
	 * Da li je film 3D
	 */
	boolean daLiJe3D;
	/**
	 * Cena karte
	 */
	double cena;
	
	/**
	 * Rezervisana sedista u sali
	 */
	boolean[] sedista; 
	
	/**
	 * lista kupaca
	 */
	LinkedList<Kupac> kupci = new LinkedList<Kupac>();

	/**
	 * Metoda koja vraca sifru projekcije.
	 * @return sifru projecije
	 */
	public int getSifra() {
		return sifra;
	}

	/**
	 * Metoda koja postavlja sifru projekcije na unetu vrednost.
	 * @param sifra, sifra projekcije
	 * @throws java.lang.RuntimeException ako je uneta sifra
	 * broj manji od nule
	 */
	public void setSifra(int sifra) {
		if(sifra < 0)
			throw new RuntimeException("Šifra mora biti pozitivan broj.");
		this.sifra = sifra;
	}
	
	/**
	 * Metoda koja vraca film koji se prikazuje.
	 * @return film kao atribut klase Film 
	 */
	public Film getFilm() {
		return film;
	}

	/**
	 * Metoda koja postavlja vrednost filma na unetu vrednost.
	 * @param film, jedan novi film tj.atribut klase Film
	 * @throws java.lang.RuntimeException ako je uneti film
	 * null ili nije objekat klase Film
	 */
	public void setFilm(Film film) {
		if(film == null || !(film instanceof Film))
			throw new RuntimeException("Uneli ste prazan objekat ili dati objekat nije zaista tipa Film");
		this.film = film;
	}

	/**
	 * Metoda koja vraca datum i vreme prikazivanja filma.
	 * @return datum i vreme kada se prikazuje film
	 */
	public GregorianCalendar getDatumPrikazivanja() {
		return DatumIVremePrikazivanja;
	}

	/**
	 * Metoda koja postavlja datum i vreme prikazivanja filma na unetu vrednost.
	 * @param godina, godina prikazivanja filma
	 * @param mesec, mesec prikazivanja filma
	 * @param dan, dan prikazivanja filma
	 * @param sat, sat prikazivanja filma
	 * @param minuti, minuti prikazivanja filma
	 * @throws java.lang.RuntimeException ako je uneta godina manja od 2015 ili 
	 * mesec manji od nula ili veci od 12 ili dan manji od jedan ili veci od 31
	 * ili sat manji od nula ili veci ili jednak 24 
	 */
	public void setDatumPrikazivanja(int godina, int mesec, int dan, int sat, int minuti) {
		if(godina < 2015 || mesec < 0 || mesec > 12 || dan < 1 || dan > 31)
			throw new RuntimeException("Pogrešno uneti godina mesec ili dan.");
		if(sat < 0 || sat >= 24 || minuti < 0 || minuti > 59)
			throw new RuntimeException("Pogrešno uneti sat ili minuti.");
		GregorianCalendar datum = new GregorianCalendar(godina, mesec -1, dan, sat, minuti);
		DatumIVremePrikazivanja = datum;
	}

	/**
	 * Metoda koja vraca salu u kojoj se prikazuje film.
	 * @return salu kao atribut klase Sala
	 */
	public Sala getSala() {
		return sala;
	}
	
	/**
	 * Metoda koja postavlja salu na unetu vrednost.
	 * @param sala, atribut klase Sala
	 * @throws java.lang.RuntimeException ako je uneta sala
	 * null ili nije objekat tipa Sala
	 */
	public void setSala(Sala sala) {
		if(sala == null || !(sala instanceof Sala))
			throw new RuntimeException("Uneli ste prazan objekat ili dati objekat nije zaista tipa Sala");
		this.sala = sala;
	}

	/**
	 * Meroda koja provera da li je film 3D.
	 * @return da li je 3D film tipa boolean
	 */
	public boolean isDaLiJe3D() {
		return daLiJe3D;
	}

	/**
	 * Metoda koja postavlja da li je film 3D na osnovu unosa.
	 * @param daLiJe3D
	 * @throws java.lang.RuntimeException ako unet parametar nije
	 * iskljucivo true ili false
	 */
	public void setDaLiJe3D(boolean daLiJe3D) {
		if(daLiJe3D != true || daLiJe3D != false)
			throw new RuntimeException("Greška.");
		this.daLiJe3D = daLiJe3D;
	}
	
	/**
	 * Metoda koja vraca cenu karte.
	 * @return cenu karte.
	 */
	public double getCena() {
		return cena;
	}

	/**
	 * Metoda koja postavlja cenu karte na unetu vrednost.
	 * @param cena, cena rezervisane karte
	 * @throws java.lang.RuntimeException ako je uneta cena
	 * manja ili jednaka nuli
	 */
	public void setCena(double cena) {
		if(cena <= 0)
			throw new RuntimeException("Cena mora biti pozitivan broj.");
		this.cena = cena;
	}
	
	/**
	 * Metoda koja vraca niz rezervisanih sedista.
	 * @return rezervisana sedista kao niz
	 */
	public boolean[] getSedista() {
		return sedista;
	}

	/**
	 * Metoda koja postavlja broj zauzetih sedista na unetu vrednost.
	 * @param brojSedista, broj rezervisanih sedista
	 * @throws java.lang.RuntimeException ako je unet broj sedista
	 * manji od 0
	 */
	public void setSedista(int brojSedista) {
		if(brojSedista < 0)
			throw new RuntimeException("Broj sedišta ne može biti nula.");
		this.sedista = new boolean[brojSedista];
	}

	/**
	 * Mertoda koja vraca listu kupaca.
	 * @return kupce koji su rezervisali kao listu
	 */
	public LinkedList<Kupac> getKupci() {
		return kupci;
	}
	
	public void setKupci(LinkedList<Kupac> kupci) {
		this.kupci = kupci;
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
		if(sifra == p.getSifra())
			return true;
		else
			return false;
	}
	/**
	 * Metoda koja vraca sifru trazene Projekcije, film koji se prikazuje, datum i vreme njegovog prikazivanja i salu.
	 */
	@Override
	public String toString() {
		//ovo moze da se jos dopise, ali videcemo tek kad dodamo i metode za izracunavanje broja kupljenih karata ili nes tako
		return "Tražena projekcija ima sledeće podatke - " + " Šifra: " + sifra + "\nFilm - " + film.toString() +
				"\nDatum i vreme prikazivanja: " + DatumIVremePrikazivanja.getTime() +
				"\nSala - " + sala.getNaziv();
	}
	
	

}