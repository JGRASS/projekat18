package rs.fon.pp.dodatna.bioskop;

public class Kupac {
	
	String ime;
	int brojKarata;
	int brojSedista;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		if(ime.isEmpty() || ime == null)
			this.ime = "Nepoznato - kupljeno na licu mesta";
		else
		this.ime = ime;
	}
	public int getBrojKarata() {
		return brojKarata;
	}
	public void setBrojKarata(int brojKarata) {
		if(brojKarata <= 0)
			throw new RuntimeException("Rezervisani broj karata mora biti veći od 0");
		this.brojKarata = brojKarata;
	}
	public int getBrojSedista() {
		return brojSedista;
	}
	public void setBrojSedista(int brojSedista) {
		/*ovde sam samo proverila da li je manje od nule, mada ako biramo mesto iz sale, ne bi trebalo da bude problema
		 * 
		 */
		if(brojSedista < 0)
			throw new RuntimeException("Broj sedišta nije negativan broj.");
		this.brojSedista = brojSedista;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojKarata;
		result = prime * result + brojSedista;
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
		if (brojSedista != other.brojSedista)
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (ime.indexOf(other.ime) == -1 )
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Kupac [ime=" + ime + ", brojKarata=" + brojKarata
				+ ", brojSedista=" + brojSedista + "]";
	}
	
	
	
	
	
	
	
	
}
