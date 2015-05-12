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
import java.util.LinkedList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import rs.fon.pp.dodatna.bioskop.Raspored;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import java.awt.Font;

public class DodajProjekcijuGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private BioskopGUI glavniProzor;
	private JLabel lblFilm;
	private JLabel lblSala;
	private JComboBox comboBoxSala;
	private JCheckBox chckbxd;
	private JLabel lblCena;
	private JTextField textFieldCena;
	private JComboBox comboBox;


	/**
	 * Create the frame.
	 * @param glavniProzor 
	 */
	public DodajProjekcijuGUI(BioskopGUI glavniProzor) {
		setResizable(false);
		setTitle("Dodaj projekciju");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 366, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		contentPane.add(getLblFilm());
		contentPane.add(getLblSala());
		contentPane.add(getComboBox_1());
		contentPane.add(getChckbxd());
		contentPane.add(getLblCena());
		contentPane.add(getTextFieldCena());
		contentPane.add(getComboBox());
		this.glavniProzor = glavniProzor;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnDodaj.setBounds(12, 202, 142, 39);
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnOdustani.setBounds(198, 202, 142, 39);
		}
		return btnOdustani;
	}
	
	private JLabel getLblFilm() {
		if (lblFilm == null) {
			lblFilm = new JLabel("Film");
			lblFilm.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblFilm.setBounds(12, 20, 142, 31);
		}
		return lblFilm;
	}
	private JLabel getLblSala() {
		if (lblSala == null) {
			lblSala = new JLabel("Sala");
			lblSala.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblSala.setBounds(12, 115, 142, 31);
		}
		return lblSala;
	}
	private JComboBox getComboBox_1() {
		if (comboBoxSala == null) {
			comboBoxSala = new JComboBox();
			comboBoxSala.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			comboBoxSala.setBounds(12, 147, 142, 31);
		}
		return comboBoxSala;
	}
	private JCheckBox getChckbxd() {
		if (chckbxd == null) {
			chckbxd = new JCheckBox("3D");
			chckbxd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			chckbxd.setBounds(198, 142, 142, 36);
		}
		return chckbxd;
	}
	private JLabel getLblCena() {
		if (lblCena == null) {
			lblCena = new JLabel("Cena");
			lblCena.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblCena.setBounds(198, 20, 142, 31);
		}
		return lblCena;
	}
	private JTextField getTextFieldCena() {
		if (textFieldCena == null) {
			textFieldCena = new JTextField();
			textFieldCena.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			textFieldCena.setBounds(198, 64, 142, 31);
			textFieldCena.setColumns(10);
		}
		return textFieldCena;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			comboBox.setBounds(12, 64, 142, 31);
		}
		return comboBox;
	}
	
	protected void izlistajSveFilmove(LinkedList<String> filmoviString) {
		for (int i = 0; i < filmoviString.size(); i++) {
			comboBox.addItem(filmoviString.get(i));
		}
	}
	
	protected void izlistajSveSale(LinkedList<String> saleString) {
		for (int i = 0; i < saleString.size(); i++) {
			comboBoxSala.addItem(saleString.get(i));
		}
	}
}