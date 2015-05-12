package rs.fon.pp.dodatna.sistemskeoperacije;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Film;
import rs.fon.pp.dodatna.bioskop.Projekcija;
import rs.fon.pp.dodatna.bioskop.Sala;

public class SOSacuvajUFajl {
	
	public static void sacuvajUFajl(String putanja, LinkedList<Projekcija> projekcije, LinkedList<Film> filmovi, LinkedList<Sala> sale) {
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(putanja)));
			
			out.writeObject(projekcije);
			out.writeObject(filmovi);
			out.writeObject(sale);
			
			out.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
