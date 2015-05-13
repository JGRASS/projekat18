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
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	private BioskopGUI glavniProzor;
	private JButton btnNewButton;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	
	public RezervisiGUI(BioskopGUI glavniProzor) {
		setTitle("Rezervi\u0161i");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 364);
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
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnOdustani());
		this.glavniProzor = glavniProzor;
		
	}
	private JLabel getLblImeKupca() {
		if (lblImeKupca == null) {
			lblImeKupca = new JLabel("Ime kupca");
			lblImeKupca.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblImeKupca.setIcon(null);
			lblImeKupca.setBounds(23, 29, 94, 27);
		}
		return lblImeKupca;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			textField.setBounds(129, 26, 116, 30);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Broj karata");
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel.setBounds(23, 72, 94, 27);
		}
		return lblNewLabel;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			textField_1.setBounds(129, 69, 116, 30);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 138, 473, 126);
			scrollPane.setViewportView(getComboBox());
		}
		return scrollPane;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			
		}
		return comboBox;
	}
	private JLabel getLblProjekcija() {
		if (lblProjekcija == null) {
			lblProjekcija = new JLabel("Lista projekcija");
			lblProjekcija.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblProjekcija.setBounds(23, 112, 379, 24);
		}
		return lblProjekcija;
	}
	private JLabel getLblFilmovi() {
		if (lblFilmovi == null) {
			lblFilmovi = new JLabel("Filmovi");
			lblFilmovi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblFilmovi.setBounds(257, 29, 75, 27);
		}
		return lblFilmovi;
	}
	private JComboBox<String> getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox<String>();
			comboBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		comboBox_1.setBounds(330, 26, 122, 30);

		}
		return comboBox_1;
	}
	private JComboBox<String> getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox<String>();
			comboBox_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			GregorianCalendar d = new GregorianCalendar();
			for (int i = 0; i < 14; i++) {
				int dan = d.get(GregorianCalendar.DAY_OF_MONTH) + i;
				int mesec = d.get(GregorianCalendar.MONTH) + 1;
				int godina = d.get(GregorianCalendar.YEAR);
				String datum = dan + "/" + mesec + "/" + godina;
				comboBox_2.addItem(datum);
			}
			comboBox_2.setBounds(330, 69, 122, 30);
		}
		return comboBox_2;
	}
	private JLabel getLblDatum() {
		if (lblDatum == null) {
			lblDatum = new JLabel("Datum");
			lblDatum.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblDatum.setBounds(257, 69, 75, 27);
		}
		return lblDatum;
	}
	
	protected void izlistajFilmove(LinkedList<String> filmoviString) {
		for (int i = 0; i < filmoviString.size(); i++) {
			comboBox_1.addItem(filmoviString.get(i));
		}
	}
	
	protected void izlistajProjekcije(LinkedList<Projekcija> izabrane) {
		for (int i = 0; i < izabrane.size(); i++) {
			comboBox.addItem(izabrane.get(i).toString());
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
	
	protected Projekcija vratiIzabranuProjekciju() {
		Projekcija p = (Projekcija) comboBox.getSelectedItem();
		return p;
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Sa\u010Duvaj uneto i izaberi sedi\u0161te za kupca\r\n");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziIzaberiSedisteGUI((Projekcija) comboBox.getSelectedItem());
				}
			});
			btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnNewButton.setBounds(147, 277, 338, 27);
		}
		return btnNewButton;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOdustani.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnOdustani.setBounds(12, 277, 115, 26);
		}
		return btnOdustani;
	}
}