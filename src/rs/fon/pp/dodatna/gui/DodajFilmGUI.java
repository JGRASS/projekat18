package rs.fon.pp.dodatna.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.fon.pp.dodatna.bioskop.Film;
import rs.fon.pp.dodatna.bioskop.Raspored;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DodajFilmGUI extends JFrame {

	private JPanel contentPane;
	
	private JTextField nazivFilma;
	private JLabel lblNazivFilma;
	private JLabel labelZanr;
	private JComboBox comboBoxZanr;
	private JLabel lblOstalo;
	private JTextField textField;
	private JLabel lblVremeTrajanja;
	private JSpinner spinner;
	private JLabel lblDatumPocetkaPrikazivanja;
	private JLabel lblDatumZavretkaPrikazivanja;
	private JButton btnDodaj;
	private JButton btnOdustani;
	private JSpinner danP;
	private JSpinner mesecP;
	private JSpinner godinaP;
	private JSpinner danZ;
	private JSpinner mesecZ;
	private JSpinner godinaZ;
	private BioskopGUI glavniProzor;
	/**
	 * Create the frame.
	 */
	public DodajFilmGUI(BioskopGUI glavniProzor) {
		setResizable(false);
		setTitle("Dodaj film");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, -48, 472, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getNazivFilma());
		contentPane.add(getLblNazivFilma());
		contentPane.add(getLabelZanr());
		contentPane.add(getComboBoxZanr());
		contentPane.add(getLblOstalo());
		contentPane.add(getTextField());
		contentPane.add(getLblVremeTrajanja());
		contentPane.add(getSpinner());
		contentPane.add(getLblDatumPocetkaPrikazivanja());
		contentPane.add(getLblDatumZavretkaPrikazivanja());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		contentPane.add(getSpinner_1_1());
		contentPane.add(getSpinner_2_1());
		contentPane.add(getGodinaP());
		contentPane.add(getDanZ());
		contentPane.add(getMesecZ());
		contentPane.add(getGodinaZ());
		this.glavniProzor = glavniProzor;
	}
	private JTextField getNazivFilma() {
		if (nazivFilma == null) {
			nazivFilma = new JTextField();
			nazivFilma.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			nazivFilma.setBounds(26, 47, 164, 28);
			nazivFilma.setColumns(10);
		}
		return nazivFilma;
	}
	private JLabel getLblNazivFilma() {
		if (lblNazivFilma == null) {
			lblNazivFilma = new JLabel("Naziv filma");
			lblNazivFilma.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNazivFilma.setBounds(26, 13, 164, 34);
		}
		return lblNazivFilma;
	}
	private JLabel getLabelZanr() {
		if (labelZanr == null) {
			labelZanr = new JLabel("\u017Danr");
			labelZanr.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			labelZanr.setBounds(26, 75, 164, 28);
		}
		return labelZanr;
	}
	private JComboBox getComboBoxZanr() {
		if (comboBoxZanr == null) {
			comboBoxZanr = new JComboBox();
			comboBoxZanr.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			comboBoxZanr.setModel(new DefaultComboBoxModel(new String[] {"Akcija", "Drama", "Komedija", "Triler", "Horor", "Mjuzikl", "Naucno-fantasticni", "Ratni", "Ostalo"}));
			comboBoxZanr.setBounds(26, 106, 164, 28);
			comboBoxZanr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBoxZanr.getSelectedItem().equals("Ostalo")){
						textField.setEditable(true);
					}
					else textField.setEditable(false);
				}
			});
		}
		return comboBoxZanr;
	}
	private JLabel getLblOstalo() {
		if (lblOstalo == null) {
			lblOstalo = new JLabel("Ostalo");
			lblOstalo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblOstalo.setBounds(26, 143, 164, 28);
		}
		return lblOstalo;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			textField.setEditable(false);
			textField.setBounds(26, 171, 164, 28);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblVremeTrajanja() {
		if (lblVremeTrajanja == null) {
			lblVremeTrajanja = new JLabel("Vreme trajanja");
			lblVremeTrajanja.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblVremeTrajanja.setBounds(239, 13, 164, 34);
		}
		return lblVremeTrajanja;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			spinner.setModel(new SpinnerNumberModel(new Integer(100), null, null, new Integer(1)));
			spinner.setBounds(239, 47, 82, 28);
		}
		return spinner;
	}
	private JLabel getLblDatumPocetkaPrikazivanja() {
		if (lblDatumPocetkaPrikazivanja == null) {
			lblDatumPocetkaPrikazivanja = new JLabel("Datum po\u010Detka prikazivanja");
			lblDatumPocetkaPrikazivanja.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblDatumPocetkaPrikazivanja.setBounds(239, 69, 215, 40);
		}
		return lblDatumPocetkaPrikazivanja;
	}
	private JLabel getLblDatumZavretkaPrikazivanja() {
		if (lblDatumZavretkaPrikazivanja == null) {
			lblDatumZavretkaPrikazivanja = new JLabel("Datum zavr\u0161etka prikazivanja");
			lblDatumZavretkaPrikazivanja.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblDatumZavretkaPrikazivanja.setBounds(239, 137, 215, 40);
		}
		return lblDatumZavretkaPrikazivanja;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String zanr;
					if (comboBoxZanr.getSelectedItem().equals("Ostalo")){
						zanr = textField.getText();
					}
					else zanr = (String) comboBoxZanr.getSelectedItem();
					GUIKontroler.unesiFilm(nazivFilma.getText(), zanr, (Integer) spinner.getValue(), 
							(Integer) godinaP.getValue(),(Integer) mesecP.getValue(), 
							(Integer)danP.getValue(), (Integer)godinaZ.getValue(),
							(Integer)mesecZ.getValue(), (Integer)danZ.getValue());	
					dispose();
					
					
				}
			});
			btnDodaj.setBounds(26, 212, 164, 40);
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(239, 212, 164, 40);
		}
		return btnOdustani;
	}
	private JSpinner getSpinner_1_1() {
		if (danP == null) {
			danP = new JSpinner();
			danP.setModel(new SpinnerNumberModel(1, 1, 31, 1));
			danP.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			danP.setBounds(239, 106, 45, 28);
		}
		return danP;
	}
	private JSpinner getSpinner_2_1() {
		if (mesecP == null) {
			mesecP = new JSpinner();
			mesecP.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			mesecP.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			mesecP.setBounds(288, 106, 43, 28);
		}
		return mesecP;
	}
	private JSpinner getGodinaP() {
		if (godinaP == null) {
			godinaP = new JSpinner();
			godinaP.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			godinaP.setModel(new SpinnerNumberModel(2015, 2015, 2100, 1));
			godinaP.setBounds(343, 106, 60, 28);
		}
		return godinaP;
	}
	private JSpinner getDanZ() {
		if (danZ == null) {
			danZ = new JSpinner();
			danZ.setModel(new SpinnerNumberModel(1, 1, 31, 1));
			danZ.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			danZ.setBounds(239, 171, 45, 28);
		}
		return danZ;
	}
	private JSpinner getMesecZ() {
		if (mesecZ == null) {
			mesecZ = new JSpinner();
			mesecZ.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			mesecZ.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			mesecZ.setBounds(288, 171, 43, 28);
		}
		return mesecZ;
	}
	private JSpinner getGodinaZ() {
		if (godinaZ == null) {
			godinaZ = new JSpinner();
			godinaZ.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			godinaZ.setModel(new SpinnerNumberModel(2015, 2015, 2100, 1));
			godinaZ.setBounds(343, 171, 60, 28);
		}
		return godinaZ;
	}
}
