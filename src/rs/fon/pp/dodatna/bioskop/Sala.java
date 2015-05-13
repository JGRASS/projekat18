package rs.fon.pp.dodatna.bioskop;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Ova klasa predstavlja bioskopsku salu.
 * @author team18
 * @version 1.0
 *
 */
public class Sala implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Naziv sale
	 */
	String naziv;

	/**
	 * Sifra sale
	 */
	int sifra;

	/**
	 * Sedista sale
	 */
	int [] sedista; //ovde sam promenila u niz, tako mi je bilo na kraju logicnije, kad sam pocela da razmisljam o metodama, aaa, recite ako ne valja -.-

	/**
	 * Broj redova u sali
	 */
	int brojRedova;

	/**
	 * Broj kolona u sali
	 */
	int brojKolona;

	/**
	 * Metoda koja vraca naziv sale.
	 * @return naziv sale kao String
	 */
	public String getNaziv() {
		return naziv;
	}

	/**
	 * Metoda koja postavlja naziv sale na unetu vrednost.
	 * @param naziv, naziv sale
	 * @throws java.lang.RuntimeException ako je uneti naziv
	 * prazan String ili null
	 */
	public void setNaziv(String naziv) {
		if(naziv.isEmpty() || naziv == null)
			throw new RuntimeException("Morate uneti naziv sale.");
		this.naziv = naziv;
	}

	/**
	 * Metoda koja vraca sifru sale.
	 * @return sifru sale
	 */
	public int getSifra() {
		return sifra;
	}

	/**
	 * Metoda koja postavlja sifru sale na unetu vrednost.
	 * @param sifra, sifra bioskopske sale
	 * @throws java.lang.RuntimeException ako je uneta sifra
	 * broj manji od nule
	 */
	public void setSifra(int sifra) {
		if(sifra < 0)
			throw new RuntimeException("Šifra predstavlja pozitivan broj");
		this.sifra = sifra;
	}

	/**
	 * Metoda koja vraca
	 * @return sedista u sali kao niz
	 */
	//Ani 
	public int[] getSedista() {
		return sedista;
	}
	public void setSedista(int brojSedista) {
		if(brojSedista < 0)
			throw new RuntimeException("Broj sedišta u sali je pozivan broj.");
		int[] s = new int[brojSedista];
		for (int i = 0; i < s.length; i++) {
			s[i] = i;
		}
		this.sedista = s;
	}

	/**
	 * Metoda koja vraca broj redova u sali.
	 * @return broj redova u sali
	 */
	public int getBrojRedova() {
		return brojRedova;
	}
	
	//za sad sam stavila ovako, jer cemo ipak najverovatnije ostaviti da sala moze da bude samo pravougaona
	/**
	 * Metoda koja postavlja broj redova u sali na unetu vrednost.
	 * @param brojRedova, broj redova u sali
	 * @throws java.lang.RuntimeException ako je uneti broj redova
	 * manji od jedan ili deljiv sa brojem sedista u sali
	 */
	public void setBrojRedova(int brojRedova) {
		if(brojRedova < 1 ||!( sedista.length % brojRedova == 0))
			throw new RuntimeException("Broj redova mora biti pozitivan broj i broj koji deli broj sedišta.");
		this.brojRedova = brojRedova;
	}

	/**
	 * Metoda koja vraca broj kolona u sali.
	 * @return broj kolona u sali
	 */
	public int getBrojKolona() {
		return brojKolona;
	}

	/**
	 * Metoda koja postavlja broj kolona u sali na unetu vrednost.
	 * @param brojKolona, broj kolona u sali
	 * @throws java.lang.RuntimeException ako je uneti broj kolona 
	 * manji ili jednak nuli
	 */
	public void setBrojKolona(int brojKolona) {
		if(brojKolona <= 0)
			throw new RuntimeException("Broj kolona u sali je pozitivan broj");
		this.brojKolona = brojKolona;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojRedova;
		result = prime * result + brojKolona;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + Arrays.hashCode(sedista);
		result = prime * result + sifra;
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
		Sala s = (Sala) obj;
		if(sifra == s.getSifra())
			return true;
		else
			return false;

	}

	/**
	 * Metoda koja vraca naziv, sifru sale i broj sedista u sali.
	 */
	@Override
	public String toString() {
		return "Naziv sale: " + naziv + ", njena šifra je: " + sifra + ", a broj sedišta je: " + sedista.length;  
	}



}
