package rs.fon.pp.dodatna.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import rs.fon.pp.dodatna.bioskop.Raspored;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class DodajProjekcijuGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private JComboBox comboBoxFilm;
	private BioskopGUI glavniProzor;
	private JLabel lblFilm;
	private JLabel lblSala;
	private JComboBox comboBoxSala;
	private JCheckBox chckbxd;
	private JLabel lblCena;
	private JTextField textFieldCena;


	/**
	 * Create the frame.
	 * @param glavniProzor 
	 */
	public DodajProjekcijuGUI(BioskopGUI glavniProzor) {
		setResizable(false);
		setTitle("Dodaj projekciju");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 325, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		contentPane.add(getComboBoxFilm());
		contentPane.add(getLblFilm());
		contentPane.add(getLblSala());
		contentPane.add(getComboBox_1());
		contentPane.add(getChckbxd());
		contentPane.add(getLblCena());
		contentPane.add(getTextFieldCena());
		this.glavniProzor = glavniProzor;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.setBounds(23, 142, 119, 23);
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setBounds(165, 142, 119, 23);
		}
		return btnOdustani;
	}
	private JComboBox getComboBoxFilm() {
		if (comboBoxFilm == null) {
			comboBoxFilm = new JComboBox();
			String[] lista = new String [Raspored.filmovi.size()];
			for (int i = 0; i < Raspored.filmovi.size(); i++) {
				lista[i] = Raspored.filmovi.get(i).getNaziv();
			}
			
			comboBoxFilm.setModel(new DefaultComboBoxModel(lista));
			comboBoxFilm.setBounds(23, 47, 119, 20);
		}
		return comboBoxFilm;
	}
	private JLabel getLblFilm() {
		if (lblFilm == null) {
			lblFilm = new JLabel("Film");
			lblFilm.setBounds(23, 22, 119, 14);
		}
		return lblFilm;
	}
	private JLabel getLblSala() {
		if (lblSala == null) {
			lblSala = new JLabel("Sala");
			lblSala.setBounds(23, 78, 119, 14);
		}
		return lblSala;
	}
	private JComboBox getComboBox_1() {
		if (comboBoxSala == null) {
			comboBoxSala = new JComboBox();
			comboBoxSala.setBounds(23, 103, 119, 20);
		}
		return comboBoxSala;
	}
	private JCheckBox getChckbxd() {
		if (chckbxd == null) {
			chckbxd = new JCheckBox("3D");
			chckbxd.setBounds(165, 102, 119, 23);
		}
		return chckbxd;
	}
	private JLabel getLblCena() {
		if (lblCena == null) {
			lblCena = new JLabel("Cena");
			lblCena.setBounds(165, 22, 119, 14);
		}
		return lblCena;
	}
	private JTextField getTextFieldCena() {
		if (textFieldCena == null) {
			textFieldCena = new JTextField();
			textFieldCena.setBounds(165, 47, 119, 20);
			textFieldCena.setColumns(10);
		}
		return textFieldCena;
	}
}
