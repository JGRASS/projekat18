package rs.fon.pp.dodatna.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import rs.fon.pp.dodatna.bioskop.Film;
import rs.fon.pp.dodatna.bioskop.Projekcija;
import rs.fon.pp.dodatna.bioskop.Raspored;
import rs.fon.pp.dodatna.bioskop.RasporedInterface;

import javax.swing.JFrame;


public class GUIKontroler {
	
	public static BioskopGUI glavniProzor;
	public static RasporedInterface bioskop;
	public static RezervisiGUI prozor; //!!!!!!!!!
	
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
	
	public static void prikaziRezervisiGUI() {
		RezervisiGUI prozor = new RezervisiGUI(glavniProzor);
		prozor.setLocationRelativeTo(glavniProzor.getContentPane());
		prozor.setVisible(true); 
		//za comboBox je potrebna metoda vratiFilmove koja vraca listu Stringova naziva filmova,
		//medjutim kako god sam probala nije htelo da funkcionise!!!
	}
	
	public static void prikaziIzaberiSedisteGUI(LinkedList<Projekcija> projekcije, Projekcija projekcija) {
		IzaberiSedisteGUI izaberiProzor = new IzaberiSedisteGUI(prozor, projekcije, prozor.vratiIzabranuProjekciju(projekcije));
		izaberiProzor.setLocationRelativeTo(glavniProzor.getContentPane());
		izaberiProzor.setVisible(true);
		izaberiProzor.prikaziSalu(projekcija.getSala().getBrojRedova(), projekcija.getSala().getBrojKolona());
	}
	
	public static void prikaziDodajFilmGUI() {
		DodajFilmGUI dodajFilmProzor = new DodajFilmGUI(glavniProzor);
		dodajFilmProzor.setLocationRelativeTo(glavniProzor.getContentPane());
		dodajFilmProzor.setVisible(true);
		
	}
	
	public static void prikaziDodajProjekcijuGUI() {
		DodajProjekcijuGUI dodajProjekcijuProzor = new DodajProjekcijuGUI(glavniProzor);
		dodajProjekcijuProzor.setLocationRelativeTo(glavniProzor.getContentPane());
		dodajProjekcijuProzor.setVisible(true);
		dodajProjekcijuProzor.izlistajSveSale(bioskop.vratiSveSale());
		dodajProjekcijuProzor.izlistajSveFilmove(bioskop.vratiSveFilmove());
		
	}
	
	public static void unesiFilm(String naziv, String zanr, int trajanje, int godina1, int mesec1, int dan1, int godina2, int mesec2, int dan2) {
		try {
			Film film = new Film();
			film.setNaziv(naziv);
			film.setVremeTrajanja(trajanje);
			film.setZanr(zanr);
			film.setDatumPocetka(godina1, mesec1, dan1);
			film.setDatumZavrsetka(godina2, mesec2, dan2);
			bioskop.dodajFilm(film);
			
			glavniProzor.textArea.setText("Uspešno je unet - " + vratiFilmove().getLast().toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(),
					"Greška!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static LinkedList<String> vratiFilmove() {
		
			LinkedList<String> filmoviString = new LinkedList<String>();
			for (int i = 0; i < Raspored.filmovi.size(); i++) {
				if(filmoviString.isEmpty() || !(filmoviString.contains(Raspored.filmovi.get(i))))
					filmoviString.add(Raspored.filmovi.get(i).getNaziv());
				else 
							continue;
			}
			return filmoviString;
		}
	
	public static String[] vratiNizFilmova() {
		
		String [] filmoviNiz = new String [Raspored.filmovi.size()];
		LinkedList<String> filmoviString = vratiFilmove();
		for (int i = 0; i < filmoviString.size(); i++) {
			filmoviNiz[i]= filmoviString.get(i);
		}
		return filmoviNiz;
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
					"Greška!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static boolean sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(glavniProzor.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				bioskop.sacuvajUFajl(file.getAbsolutePath());
				return true;		
			}
			
			return false;
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e1.getMessage(),
					"Greška!", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	//prozor.izlistajFilmove(bioskop.vratiFilmove());
	//prozor.izlistajDatume(bioskop.vratiDatume());
	//prozor.izlistajProjekcije(bioskop.pronadjiProjekcijeFilmDatum(prozor.vratiFilm(), prozor.vratiDatum()));
}