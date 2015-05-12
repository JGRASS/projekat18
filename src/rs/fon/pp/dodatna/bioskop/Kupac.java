package rs.fon.pp.dodatna.bioskop;

import java.io.Serializable;
/**
 * Ova klasa predstavlja jednog kupca.
 * @author team18
 * @version 1.0
 *
 */
public class Kupac implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Ime kupca
	 */
	String ime;

	/**
	 * Broj rezervisanh karata 
	 */
	int brojKarata; 

	/**
	 * broj rezervisanih sedista 
	 */
	int [] brojSedista;// ja sam ovo kao napravila, umesto brojSedista(zbog te mogucnosti grupe), ali mislim da su nam potrebni samo ova dva atributa,
	//a nikakav broj sedita, jer to cemo u metodi kada rezervisemo karte, umesto da gledamo true ili false gledacemo da li je null ili nije null

	/**
	 * Metoda koja vraca naziv kupca.
	 * @return ime kupca kao String
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Metoda koja postavlja ime kupca na unetu vrednost.
	 * @param ime, nov naziv kupca
	 * @throws java.lang.RuntimeException ako je uneto ime
	 * prazan String ili  null
	 */
	public void setIme(String ime) {
		if(ime.isEmpty() || ime == null)
			this.ime = "Nepoznato - kupljeno na licu mesta";
		else
			this.ime = ime;
	}

	/**
	 * Metoda koja vraca broj rezervisanih karata.
	 * @return broj karata koje su rezervisane
	 */
	public int getBrojKarata() {
		return brojKarata;
	}

	/**
	 * Metoda koja postavlja broj karata na unetu vrednost.
	 * @param brojKarata, 
	 * @throws java.lang.RuntimeException ako je unet broj karata
	 * manji ili jednak nuli
	 */
	public void setBrojKarata(int brojKarata) {
		if(brojKarata <= 0)
			throw new RuntimeException("Rezervisani broj karata mora biti veÄ‡i od 0");
		this.brojKarata = brojKarata;
	} 

	/**
	 * Metoda koja vraca broj rezervisanih sedista.
	 * @return broj rezervisanih sedista kao niz
	 */
	public int[] getBrojSedista() {
		return brojSedista;
	}

	/**
	 * Metoda koja koja postavlja broj sedista na unetu vrednost.
	 * @param brojSedista, broj rezervisanih sedista
	 * @throws java.lang.RuntimeException ako je broj sedista
	 * manji od nula
	 */
	public void setBrojSedista(int[] brojSedista) {
		for (int i = 0; i < brojSedista.length; i++) {
			if(brojSedista[i] < 0)
				throw new RuntimeException("Broj sediĹˇta u sali je pozitivan broj.");
		}
		this.brojSedista = brojSedista;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojKarata;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
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
		Kupac other = (Kupac) obj;
		if (brojKarata != other.brojKarata)
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (ime.indexOf(other.ime) == -1)
			return false;
		return true;
	}
	
	/**
	 * Metoda koja vraca ime kupca, broj rezervisanih karata i broj sedista koja su rezervisana. 
	 */
	@Override
	public String toString() {
		return "Kupac [ime=" + ime + ", brojKarata=" + brojKarata
				+ ", brojSedista=" + "]";
	}








}
