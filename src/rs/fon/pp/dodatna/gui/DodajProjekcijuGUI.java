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

import rs.fon.pp.dodatna.bioskop.Film;
import rs.fon.pp.dodatna.bioskop.Raspored;
import rs.fon.pp.dodatna.bioskop.Sala;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

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
	private JLabel lblProjekcija;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner_3;
	private JSpinner spinner_4;
	private JLabel lblDan;
	private JLabel lblMesec;
	private JLabel lblGodina;
	private JLabel lblSat;
	private JLabel lblMinut;
	private JTextField textField;
	private JLabel lblSifra;


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
		contentPane.add(getLblProjekcija());
		contentPane.add(getSpinner());
		contentPane.add(getSpinner_1());
		contentPane.add(getSpinner_2());
		contentPane.add(getSpinner_3());
		contentPane.add(getSpinner_4());
		contentPane.add(getLblDan());
		contentPane.add(getLblMesec());
		contentPane.add(getLblGodina());
		contentPane.add(getLblSat());
		contentPane.add(getLblMinut());
		contentPane.add(getTextField());
		contentPane.add(getLblSifra());
		this.glavniProzor = glavniProzor;
	}

	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				GUIKontroler.unesiProjekciju(Integer.parseInt(textField.getText()),
							comboBox.getSelectedItem().toString(),
							(Integer)spinner_2.getValue(),(Integer) spinner_1.getValue(),
							(Integer) spinner.getValue(), (Integer) spinner_3.getValue(), 
							(Integer) spinner_4.getValue(), comboBox.getSelectedItem().toString(), chckbxd.isSelected(), 
							Double.parseDouble(textFieldCena.getText()));
				dispose();
				}
			});
			btnDodaj.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnDodaj.setBounds(12, 210, 142, 31);
		}
		return btnDodaj;
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
			btnOdustani.setBounds(198, 210, 142, 31);
		}
		return btnOdustani;
	}
	
	private JLabel getLblFilm() {
		if (lblFilm == null) {
			lblFilm = new JLabel("Film");
			lblFilm.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblFilm.setBounds(12, 11, 142, 22);
		}
		return lblFilm;
	}
	private JLabel getLblSala() {
		if (lblSala == null) {
			lblSala = new JLabel("Sala");
			lblSala.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblSala.setBounds(12, 78, 142, 22);
		}
		return lblSala;
	}
	private JComboBox getComboBox_1() {
		if (comboBoxSala == null) {
			comboBoxSala = new JComboBox();
			comboBoxSala.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			comboBoxSala.setBounds(12, 105, 142, 31);
		}
		return comboBoxSala;
	}
	private JCheckBox getChckbxd() {
		if (chckbxd == null) {
			chckbxd = new JCheckBox("3D");
			chckbxd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			chckbxd.setBounds(294, 164, 46, 22);
		}
		return chckbxd;
	}
	private JLabel getLblCena() {
		if (lblCena == null) {
			lblCena = new JLabel("Cena");
			lblCena.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblCena.setBounds(198, 11, 142, 22);
		}
		return lblCena;
	}
	private JTextField getTextFieldCena() {
		if (textFieldCena == null) {
			textFieldCena = new JTextField();
			textFieldCena.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			textFieldCena.setBounds(198, 36, 142, 31);
			textFieldCena.setColumns(10);
		}
		return textFieldCena;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			comboBox.setBounds(12, 36, 142, 31);
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
	private JLabel getLblProjekcija() {
		if (lblProjekcija == null) {
			lblProjekcija = new JLabel("Vreme");
			lblProjekcija.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblProjekcija.setBounds(198, 78, 142, 22);
		}
		return lblProjekcija;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
			spinner.setBounds(198, 123, 39, 20);
		}
		return spinner;
	}
	private JSpinner getSpinner_1() {
		if (spinner_1 == null) {
			spinner_1 = new JSpinner();
			spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			spinner_1.setBounds(237, 123, 39, 20);
		}
		return spinner_1;
	}
	private JSpinner getSpinner_2() {
		if (spinner_2 == null) {
			spinner_2 = new JSpinner();
			spinner_2.setModel(new SpinnerNumberModel(2015, 2000, 2100, 1));
			spinner_2.setBounds(276, 123, 64, 20);
		}
		return spinner_2;
	}
	private JSpinner getSpinner_3() {
		if (spinner_3 == null) {
			spinner_3 = new JSpinner();
			spinner_3.setModel(new SpinnerNumberModel(0, 0, 23, 1));
			spinner_3.setBounds(198, 168, 39, 20);
		}
		return spinner_3;
	}
	private JSpinner getSpinner_4() {
		if (spinner_4 == null) {
			spinner_4 = new JSpinner();
			spinner_4.setModel(new SpinnerNumberModel(0, 0, 59, 1));
			spinner_4.setBounds(237, 168, 39, 20);
		}
		return spinner_4;
	}
	private JLabel getLblDan() {
		if (lblDan == null) {
			lblDan = new JLabel("Dan");
			lblDan.setBounds(198, 105, 46, 14);
		}
		return lblDan;
	}
	private JLabel getLblMesec() {
		if (lblMesec == null) {
			lblMesec = new JLabel("Mesec");
			lblMesec.setBounds(237, 105, 46, 14);
		}
		return lblMesec;
	}
	private JLabel getLblGodina() {
		if (lblGodina == null) {
			lblGodina = new JLabel("Godina");
			lblGodina.setBounds(276, 105, 46, 14);
		}
		return lblGodina;
	}
	private JLabel getLblSat() {
		if (lblSat == null) {
			lblSat = new JLabel("Sat");
			lblSat.setBounds(198, 154, 46, 14);
		}
		return lblSat;
	}
	private JLabel getLblMinut() {
		if (lblMinut == null) {
			lblMinut = new JLabel("Minut");
			lblMinut.setBounds(237, 154, 46, 14);
		}
		return lblMinut;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			textField.setColumns(10);
			textField.setBounds(12, 168, 142, 31);
		}
		return textField;
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
			lblSifra.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblSifra.setBounds(12, 141, 142, 22);
		}
		return lblSifra;
	}

	
}