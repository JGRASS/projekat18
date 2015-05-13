package rs.fon.pp.dodatna.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import rs.fon.pp.dodatna.bioskop.Film;
import rs.fon.pp.dodatna.bioskop.Projekcija;
import rs.fon.pp.dodatna.bioskop.Raspored;
import rs.fon.pp.dodatna.bioskop.RasporedInterface;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class RezervisiGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblImeKupca;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JScrollPane scrollPane;
	private JComboBox<String> comboBox;
	private JLabel lblProjekcija;
	private JLabel lblFilmovi;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	private JLabel lblDatum;
	private LinkedList<Projekcija> projekcije; //iskreno nemam pojma da li ovo moze ovako, ali kao ako je mogla valuta u menjacnici, moze i ovo?
	private BioskopGUI glavniProzor;

	/**
	 * Create the frame.
	 */
	
	public RezervisiGUI(BioskopGUI glavniProzor) {
		setTitle("Rezervi\u0161i");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblImeKupca());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField_1());
		contentPane.add(getScrollPane());
		contentPane.add(getLblProjekcija());
		contentPane.add(getLblFilmovi());
		contentPane.add(getComboBox_1());
		contentPane.add(getComboBox_2());
		contentPane.add(getLblDatum());
		this.glavniProzor = glavniProzor;
		
	}
	private JLabel getLblImeKupca() {
		if (lblImeKupca == null) {
			lblImeKupca = new JLabel("Ime kupca");
			lblImeKupca.setIcon(null);
			lblImeKupca.setBounds(23, 29, 80, 16);
		}
		return lblImeKupca;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(129, 26, 116, 22);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Broj karata");
			lblNewLabel.setBounds(23, 72, 80, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(129, 69, 116, 22);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(27, 123, 305, 117);
			scrollPane.setViewportView(getComboBox());
		}
		return scrollPane;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
		}
		return comboBox;
	}
	private JLabel getLblProjekcija() {
		if (lblProjekcija == null) {
			lblProjekcija = new JLabel("Lista projekcija");
			lblProjekcija.setBounds(23, 101, 100, 16);
		}
		return lblProjekcija;
	}
	private JLabel getLblFilmovi() {
		if (lblFilmovi == null) {
			lblFilmovi = new JLabel("Filmovi");
			lblFilmovi.setBounds(274, 29, 56, 16);
		}
		return lblFilmovi;
	}
	private JComboBox<String> getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox<String>();
			//comboBox_1.setModel(new DefaultComboBoxModel<String>(GUIKontroler.vratiNizFilmova()));
		comboBox_1.setBounds(320, 26, 80, 22);

		}
		return comboBox_1;
	}
	private JComboBox<String> getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox<String>();
			GregorianCalendar d = new GregorianCalendar();
			for (int i = 0; i < 14; i++) {
				int dan = d.get(GregorianCalendar.DAY_OF_MONTH) + i;
				int mesec = d.get(GregorianCalendar.MONTH) + 1;
				int godina = d.get(GregorianCalendar.YEAR);
				String datum = dan + "/" + mesec + "/" + godina;
				comboBox_2.addItem(datum);
			}
			comboBox_2.setBounds(320, 69, 80, 22);
		}
		return comboBox_2;
	}
	private JLabel getLblDatum() {
		if (lblDatum == null) {
			lblDatum = new JLabel("Datum");
			lblDatum.setBounds(274, 72, 48, 16);
		}
		return lblDatum;
	}
	
	
	protected void izlistajProjekcije(LinkedList<Projekcija> izabrane) {
		for (int i = 0; i < izabrane.size(); i++) {
			comboBox.addItem(izabrane.toString());
		}
	}
	
	protected String vratiFilm() {
		String s = (String) comboBox_1.getSelectedItem();
		return s;
	}
	
	protected GregorianCalendar vratiDatum() {
		String s = (String) comboBox_2.getSelectedItem();
		String d = s.split("/")[0];
		int dan = Integer.parseInt(d);
		String m = s.split("/")[1];
		int mesec = Integer.parseInt(m);
		String g = s.split("/")[2];
		int godina = Integer.parseInt(g);
		GregorianCalendar datum = new GregorianCalendar(dan, mesec, godina);
		return datum;
	}
	
	protected Projekcija vratiIzabranuProjekciju(LinkedList<Projekcija> projekcije) {
		Projekcija izabranaP = new Projekcija();
		String izabrana = (String) comboBox.getSelectedItem();
		for (int i = 0; i < projekcije.size(); i++) {
			if(izabrana.indexOf(projekcije.get(i).toString()) != -1)
				izabranaP = projekcije.get(i);
		}
		return izabranaP;
	}
}