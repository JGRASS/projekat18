package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Projekcija;

public class SOVratiSveProjekcije {
	
	public static LinkedList<String> vratiSveProjekcije(LinkedList<Projekcija> projekcije) {
		LinkedList<String> projekcijeString = new LinkedList<String>();
		for (int i = 0; i < projekcije.size(); i++) {
			String s = projekcije.get(i).getFilm().getNaziv()+ "\n"+" "+ projekcije.get(i).getDatumPrikazivanja().DAY_OF_MONTH
					+"."+projekcije.get(i).getDatumPrikazivanja().MONTH + "."+projekcije.get(i).getDatumPrikazivanja().YEAR+"\n"
					+ "Cena:"+ projekcije.get(i).getCena();
			projekcijeString.add(s);
		}
		return projekcijeString;
	}

}
