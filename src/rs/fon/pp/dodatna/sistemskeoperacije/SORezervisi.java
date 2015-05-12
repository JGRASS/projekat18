package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Kupac;
import rs.fon.pp.dodatna.bioskop.Projekcija;

public class SORezervisi {
	
	public static void rezervisi(String ime, int brojKarata, Projekcija p, int[] redniBrojeviSedista, LinkedList<Projekcija> projekcije) {
		Kupac k = new Kupac();
		k.setIme(ime);
		k.setBrojKarata(brojKarata);
		k.setBrojSedista(redniBrojeviSedista);
		for (int i = 0; i < projekcije.size(); i++) {
			if(projekcije.get(i).equals(p))
				projekcije.get(i).getKupci().add(k);
			for (int j = 0; j < redniBrojeviSedista.length; j++) {
			/*	if(projekcije.get(i).getSedista()[j] == true)
					throw new RuntimeException("Ne možete rezervisati već zauzeto mesto.");
				else
					projekcije.get(i).getSedista()[j] = true;*/
			}
		}
	}
}
