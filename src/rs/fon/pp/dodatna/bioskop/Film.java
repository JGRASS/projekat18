package rs.fon.pp.dodatna.bioskop;

import java.util.GregorianCalendar;

public class Film {
	
	String naziv, zanr;
	int vremeTrajanja;
	GregorianCalendar datumPocetka, datumZavrsetka;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if(naziv.isEmpty() || naziv == null) 
			throw new RuntimeException("Morate uneti naziv filma.");
		this.naziv = naziv;
	}
	public String getZanr() {
		return zanr;
	}
	public void setZanr(String zanr) {
		if(naziv.isEmpty() || naziv == null)
			throw new RuntimeException("Morate uneti žanr filma.");
		this.zanr = zanr;
	}
	public int getVremeTrajanja() {
		return vremeTrajanja;
	}
	public void setVremeTrajanja(int vremeTrajanja) {
		if(vremeTrajanja <= 0)
			throw new RuntimeException("Vreme trajanja mora biti pozitivan broj.");
		this.vremeTrajanja = vremeTrajanja;
	}
	public GregorianCalendar getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(int godina, int mesec, int dan) {
		if(godina < 2015 || mesec < 0 || mesec > 12 || dan < 1 || dan > 31)
			throw new RuntimeException("Pogrešno uneti godina, mesec ili dan, pokušajte ponovo.");
		GregorianCalendar datum = new GregorianCalendar(godina, mesec - 1, dan);
		if(datum.after(getDatumZavrsetka()))
			throw new RuntimeException("Datum početka prikazivanja mora biti pre datuma završetka prikazivanja filma.");
		this.datumPocetka = datum;
	}
	public GregorianCalendar getDatumZavrsetka() {
		return datumZavrsetka;
	}
	public void setDatumZavrsetka(int godina, int mesec, int dan) {
		if(godina < 2015 || mesec < 0 || mesec > 12 || dan < 1 || dan > 31)
			throw new RuntimeException("Pogrešno uneti godina, mesec ili dan, pokušajte ponovo.");
		GregorianCalendar datum = new GregorianCalendar(godina, mesec - 1, dan);
		if(datumZavrsetka.before(getDatumPocetka()))
			throw new RuntimeException("Datum završetka prikazivanja mora biti posle datum početka prikazivanja filma.");
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
	@Override
	public String toString() {
		return "Naziv filma: " + naziv + ", žanr filma: " + zanr + ", vreme trajanja: " + vremeTrajanja + 
				", datum početka prikazivanja filma: " + datumPocetka.getTime() +
				", datum završetka prikazivanja filma: " + datumZavrsetka.getTime();
	}
	
	
	

	
	
}
