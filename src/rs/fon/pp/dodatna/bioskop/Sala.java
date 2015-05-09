package rs.fon.pp.dodatna.bioskop;

import java.io.Serializable;
import java.util.Arrays;

public class Sala implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String naziv;
	int sifra;
	int [] sedista; //ovde sam promenila u niz, tako mi je bilo na kraju logicnije, kad sam pocela da razmisljam o metodama, aaa, recite ako ne valja -.-
	int brojRedova;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if(naziv.isEmpty() || naziv == null)
			throw new RuntimeException("Morate uneti naziv sale.");
		this.naziv = naziv;
	}
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		if(sifra < 0)
			throw new RuntimeException("�ifra predstavlja pozitivan broj");
		this.sifra = sifra;
	}
	
	public int[] getSedista() {
		return sedista;
	}
	public void setSedista(int brojSedista) {
		if(brojSedista < 0)
			throw new RuntimeException("Broj sedi�ta u sali je pozivan broj.");
		int[] s = new int[brojSedista];
		for (int i = 0; i < s.length; i++) {
			s[i] = i;
		}
		this.sedista = s;
	}
	public int getBrojRedova() {
		return brojRedova;
	}
	//za sad sam stavila ovako, jer cemo ipak najverovatnije ostaviti da sala moze da bude samo pravougaona
	public void setBrojRedova(int brojRedova) {
		if(brojRedova < 1 || sedista.length % brojRedova == 0)
			throw new RuntimeException("Broj redova mora biti pozitivan broj i broj koji deli broj sedi�ta.");
		this.brojRedova = brojRedova;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojRedova;
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
	@Override
	public String toString() {
		return "Naziv sale: " + naziv + ", njena �ifra je: " + sifra + ", a broj sedi�ta je: " + sedista.length;  
	}
	
	
	
}
