package rs.fon.pp.dodatna.bioskop;

import java.io.Serializable;
import java.util.GregorianCalendar;
/**
 * 
 * Ova klasa predstavlja jedan film.
 * 
 * @author team18
 * @version 1.0
 * 
 *
 */
public class Film implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Naziv filma.
	 */
	String naziv;

	/**
	 * Zanr filma.
	 */
	String zanr;

	/**
	 * Vreme trajanja filma.
	 */
	int vremeTrajanja;

	/**
	 * Datum pocetka prikazivanja filma.
	 */
	GregorianCalendar datumPocetka;

	/**
	 * Datum zavrsetka prikazivanja filma.
	 */
	GregorianCalendar datumZavrsetka;; 

	/*	
	 * vidm ima metoda dodajFilm al tek na kraju
	 * Film (String naziv, String zanr, int vremeTrajanja, int danP, int mesecP, int godinaP
			, int danZ, int mesecZ, int godinaZ){
		setNaziv(naziv);
		setZanr(zanr);
		setVremeTrajanja(vremeTrajanja);
		setDatumPocetka(godinaP, mesecP, danP);
		setDatumZavrsetka(godinaZ, mesecZ, danZ);


	}*/

	/**
	 * Metoda koja vraca naziv filma, tj.vrednost atributa naziv.
	 * @return naziv filma kao String
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Metoda koja postavlja naziv filma na unetu vrednost.
	 * @param naziv, nov naziv filma
	 * @throws java.lang.RuntimeException ako je unet naziv 
	 * prazan String ili null
	 */
	public void setNaziv(String naziv) {
		if(naziv.isEmpty() || naziv == null) 
			throw new RuntimeException("Morate uneti naziv filma.");
		this.naziv = naziv;
	}

	/**
	 * Metoda koja vraca naziv zanra.
	 * @return naziv zanra kao String
	 */
	public String getZanr() {
		return zanr;
	}

	/**
	 * Metoda koja postavlja naziv zanra na unetu vrednost.
	 * @param zanr, nov naziv zanra
	 * @throws java.lang.RuntimeException ako je unet zanr 
	 * prazan String ili null
	 */
	public void setZanr(String zanr) {
		if(naziv.isEmpty() || naziv == null)
			throw new RuntimeException("Morate uneti Ĺľanr filma.");
		this.zanr = zanr;
	}

	/**
	 * Metoda koja vraca vreme trajanja filma.
	 * @return vreme trajanja filma 
	 */
	public int getVremeTrajanja() {
		return vremeTrajanja;
	}

	/**
	 * Metoda koja postavlja vreme trajanja filma na unetu vrednost.
	 * @param vremeTrajanja, vreme trajanja filma
	 * @throws java.lang.RuntimeException ako je uneto vremeTrajanja
	 * manje ili jednako nuli
	 */
	public void setVremeTrajanja(int vremeTrajanja) {
		if(vremeTrajanja <= 0)
			throw new RuntimeException("Vreme trajanja mora biti pozitivan broj.");
		this.vremeTrajanja = vremeTrajanja;
	}

	/**
	 * Metoda koja vraca datum pocetka prikazivanja filma.
	 * @return datum pocetka prikazivanja filma 
	 */
	public GregorianCalendar getDatumPocetka() {
		return datumPocetka;
	}

	/**
	 * Metoda koja postavlja datum pocetka prikazivanja filma na unetu vrednost.
	 * @param godina, godina pocetka prikazivanja filma
	 * @param mesec, mesec pocetka prikazivanja filma
	 * @param dan, dan pocetka prikazivanja filma
	 * @throws java.lang.RuntimeException ako je uneta godina manja od 2015
	 * ili uneti mesec manji od 0 ili veci od 12
	 * ili uneti dan dan manji od jedan ili veci od 31
	 * ili ako je datumPocetka posle datumaZarvsetka
	 * 
	 */
	public void setDatumPocetka(int godina, int mesec, int dan) {
		if(godina < 2015 || mesec < 0 || mesec > 12 || dan < 1 || dan > 31)
			throw new RuntimeException("PogreĹˇno uneti godina, mesec ili dan, pokuĹˇajte ponovo.");
		GregorianCalendar datum = new GregorianCalendar(godina, mesec - 1, dan);
		if(datum.after(getDatumZavrsetka()))
			throw new RuntimeException("Datum poÄŤetka prikazivanja mora biti pre datuma zavrĹˇetka prikazivanja filma.");
		this.datumPocetka = datum;
	}

	/**
	 * Metoda koja vraca datum zavrsetka prikazivanja filma.
	 * @return datum zavrsetka prikazivanja filma
	 */
	public GregorianCalendar getDatumZavrsetka() {
		return datumZavrsetka;
	}

	/**
	 * Metoda koja postavlja datum zavrsetka prikazivanja filma na unetu vrednost.
	 * @param godina, godina zavrsetka prikazivanja filma
	 * @param mesec, mesec zavrsetka prikazivanja filma
	 * @param dan, dan zavrsetka prikazivanja filma
	 * @throws java.lang.RuntimeException ako je uneta godina manja od 2015
	 * ili uneti mesec manji od 0 ili veci od 12
	 * ili uneti dan dan manji od jedan ili veci od 31
	 */
	public void setDatumZavrsetka(int godina, int mesec, int dan) {
		if(godina < 2015 || mesec < 0 || mesec > 12 || dan < 1 || dan > 31)
			throw new RuntimeException("PogreĹˇno uneti godina, mesec ili dan, pokuĹˇajte ponovo.");
		GregorianCalendar datum = new GregorianCalendar(godina, mesec - 1, dan);
		//if(datumZavrsetka.before(getDatumPocetka()))
		//	throw new RuntimeException("Datum zavrĹˇetka prikazivanja mora biti posle datum poÄŤetka prikazivanja filma.");
		this.datumZavrsetka = datum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((datumPocetka == null) ? 0 : datumPocetka.hashCode());
		result = prime * result
				+ ((datumZavrsetka == null) ? 0 : datumZavrsetka.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + vremeTrajanja;
		result = prime * result + ((zanr == null) ? 0 : zanr.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Film) {
			Film f = (Film) obj;
			if (naziv.indexOf(f.getNaziv())!= -1 && vremeTrajanja == f.getVremeTrajanja())
				return true;
		}
		return false;
	}
	
	/**
	 * Metoda koja vraca naziv filma, zanr, vreme trajanja, datum pocetka i datum zavrsetka prikazivanja filma.
	 */
	@Override
	public String toString() {
		return "Naziv filma: " + naziv + ", Ĺľanr filma: " + zanr + ", vreme trajanja: " + vremeTrajanja + 
				", datum poÄŤetka prikazivanja filma: " + datumPocetka.getTime() +
				", datum zavrĹˇetka prikazivanja filma: " + datumZavrsetka.getTime();
	}






}
