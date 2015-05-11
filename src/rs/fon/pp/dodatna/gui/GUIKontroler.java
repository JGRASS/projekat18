package rs.fon.pp.dodatna.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
		prozor.izlistajFilmove(bioskop.vratiFilmove(projekcije));
		prozor.izlistajDatume(bioskop.vratiDatume(projekcije));
		prozor.izlistajProjekcije(bioskop.pronadjiProjekcijeFilmDatum(prozor.vratiFilm(), prozor.vratiDatum()));
	}
	
	
	
	public static void ucitajIzFajla() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				bioskop.ucitajIzFajla(file.getAbsolutePath());
				glavniProzor.prikaziSveProjekcije(bioskop.vratiSveProjekcije());
			}	
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e1.getMessage(),
					"Gre�ka!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				bioskop.sacuvajUFajl(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e1.getMessage(),
					"Gre�ka!", JOptionPane.ERROR_MESSAGE);
		}
	}
}