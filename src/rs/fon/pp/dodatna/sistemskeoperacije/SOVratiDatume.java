package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Projekcija;
//ova nam metoda ver ne treba

public class SOVratiDatume {

	public static LinkedList<String> vratiDatume(LinkedList<Projekcija> projekcije) {
		
		LinkedList<String> datumi = new LinkedList<String>();
		for (int i = 0; i < projekcije.size(); i++) {
			String datum = projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.DAY_OF_MONTH) + "/" +
					projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.MONTH) + "/" +
					projekcije.get(i).getDatumPrikazivanja().get(GregorianCalendar.YEAR);
			if(datumi.isEmpty() || !(datumi.contains(datum))) {
				datumi.add(datum);
			}
			else 
				continue;
		}
		return datumi;
	}
}