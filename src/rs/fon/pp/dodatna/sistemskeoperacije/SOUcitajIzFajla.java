package rs.fon.pp.dodatna.sistemskeoperacije;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Film;
import rs.fon.pp.dodatna.bioskop.Projekcija;
import rs.fon.pp.dodatna.bioskop.Sala;

public class SOUcitajIzFajla {
	
	public static void ucitajIzFajla(String putanja, LinkedList<Projekcija> projekcije, LinkedList<Film> filmovi,
			LinkedList<Sala> sale) {
		try{
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(putanja)));
			
			@SuppressWarnings("unchecked")
			LinkedList<Projekcija> projekcije1 = (LinkedList<Projekcija>)(in.readObject());
			projekcije.clear();
			projekcije.addAll(projekcije1);
			
			@SuppressWarnings("unchecked")
			LinkedList<Film> filmovi1= (LinkedList<Film>)(in.readObject());
			filmovi.clear();
			filmovi.addAll(filmovi1);
			
			@SuppressWarnings("unchecked")
			LinkedList<Sala> sale1 = (LinkedList<Sala>)(in.readObject());
			sale.clear();
			sale.addAll(sale1);
			
			
			in.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
