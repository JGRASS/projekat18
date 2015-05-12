package rs.fon.pp.dodatna.sistemskeoperacije;

import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Sala;

public class SOVratiSveSale {

	public static LinkedList<String> vratiSveSale(LinkedList<Sala> sale) {
		LinkedList<String> saleString = new LinkedList<String>();
		for (int i = 0; i < sale.size(); i++) {
			String s = sale.get(i).getNaziv();
			saleString.add(s);
		}
		return saleString;
	}
}