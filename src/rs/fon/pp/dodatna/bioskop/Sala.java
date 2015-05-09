package rs.fon.pp.dodatna.bioskop;

public class Sala {
	
	String naziv;
	int sifra;
	int brojSedista;
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
			throw new RuntimeException("Šifra predstavlja pozitivan broj");
		this.sifra = sifra;
	}
	public int getBrojSedista() {
		return brojSedista;
	}
	public void setBrojSedista(int brojSedista) {
		if(brojSedista < 1)
			throw new RuntimeException("Broj sedišta mora biti pozitivan broj.");
		this.brojSedista = brojSedista;
	}
	public int getBrojRedova() {
		return brojRedova;
	}
	public void setBrojRedova(int brojRedova) {
		if(brojRedova < 1)
			throw new RuntimeException("Broj redova mora biti pozitivan broj.");
		this.brojRedova = brojRedova;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brojRedova;
		result = prime * result + brojSedista;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
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
		return "Naziv sale: " + naziv + ", njena šifra je: " + sifra + ", a broj sedišta je: " + brojSedista;  
	}
	
	
	
}
