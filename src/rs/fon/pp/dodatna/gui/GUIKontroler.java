package rs.fon.pp.dodatna.gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import rs.fon.pp.dodatna.bioskop.Projekcija;
import rs.fon.pp.dodatna.bioskop.Raspored;
import rs.fon.pp.dodatna.bioskop.RasporedInterface;


public class GUIKontroler {
	
	public static BioskopGUI glavniProzor;
	public static RasporedInterface bioskop;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bioskop = new Raspored();
					glavniProzor = new BioskopGUI();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void prikaziRezervisiGUI(BioskopGUI glavniProzor, LinkedList<Projekcija> projekcije) {
		RezervisiGUI prozor = new RezervisiGUI(glavniProzor, projekcije);
		prozor.setLocationRelativeTo(glavniProzor.getContentPane());
		prozor.setVisible(true);
	}
	
	public static void izlistajFilmove() {
	}
}