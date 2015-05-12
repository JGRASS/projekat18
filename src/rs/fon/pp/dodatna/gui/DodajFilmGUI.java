package rs.fon.pp.dodatna.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.fon.pp.dodatna.bioskop.Film;
import rs.fon.pp.dodatna.bioskop.PomocnaZaMetode;
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

public class DodajFilmGUI extends JFrame {

	private JPanel contentPane;
	//private LinkedList<Film> filmovi = new LinkedList<Film>();
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajFilmGUI frame = new DodajFilmGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DodajFilmGUI() {
		setTitle("Dodaj film");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, -48, 450, 300);
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
	}
	private JTextField getNazivFilma() {
		if (nazivFilma == null) {
			nazivFilma = new JTextField();
			nazivFilma.setBounds(26, 47, 164, 20);
			nazivFilma.setColumns(10);
		}
		return nazivFilma;
	}
	private JLabel getLblNazivFilma() {
		if (lblNazivFilma == null) {
			lblNazivFilma = new JLabel("Naziv filma");
			lblNazivFilma.setBounds(26, 22, 164, 14);
		}
		return lblNazivFilma;
	}
	private JLabel getLabelZanr() {
		if (labelZanr == null) {
			labelZanr = new JLabel("\u017Danr");
			labelZanr.setBounds(26, 81, 164, 14);
		}
		return labelZanr;
	}
	private JComboBox getComboBoxZanr() {
		if (comboBoxZanr == null) {
			comboBoxZanr = new JComboBox();
			comboBoxZanr.setModel(new DefaultComboBoxModel(new String[] {"Akcija", "Drama", "Komedija", "Triler", "Horor", "Mjuzikl", "Naucno-fantasticni", "Ratni", "Ostalo"}));
			comboBoxZanr.setBounds(26, 106, 164, 20);
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
			lblOstalo.setBounds(26, 137, 164, 14);
		}
		return lblOstalo;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(26, 162, 164, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblVremeTrajanja() {
		if (lblVremeTrajanja == null) {
			lblVremeTrajanja = new JLabel("Vreme trajanja");
			lblVremeTrajanja.setBounds(239, 22, 164, 14);
		}
		return lblVremeTrajanja;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(100), null, null, new Integer(1)));
			spinner.setBounds(239, 47, 61, 20);
		}
		return spinner;
	}
	private JLabel getLblDatumPocetkaPrikazivanja() {
		if (lblDatumPocetkaPrikazivanja == null) {
			lblDatumPocetkaPrikazivanja = new JLabel("Datum po\u010Detka prikazivanja");
			lblDatumPocetkaPrikazivanja.setBounds(239, 81, 164, 14);
		}
		return lblDatumPocetkaPrikazivanja;
	}
	private JLabel getLblDatumZavretkaPrikazivanja() {
		if (lblDatumZavretkaPrikazivanja == null) {
			lblDatumZavretkaPrikazivanja = new JLabel("Datum zavr\u0161etka prikazivanja");
			lblDatumZavretkaPrikazivanja.setBounds(239, 137, 164, 14);
		}
		return lblDatumZavretkaPrikazivanja;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String zanr;
					if (comboBoxZanr.getSelectedItem().equals("Ostalo")){
						zanr = textField.getText();
					}
					else zanr = (String) comboBoxZanr.getSelectedItem();
					
					Film f = PomocnaZaMetode.dodajFilm(nazivFilma.getText(), zanr,
							(Integer) spinner.getValue(),
							(Integer) godinaP.getValue(),
									(Integer) mesecP.getValue(),
									(Integer)danP.getValue(),
											(Integer)godinaZ.getValue(),
													(Integer)mesecZ.getValue(), 
															(Integer)danZ.getValue());
					
					Raspored.filmovi.add(f);
					dispose();
					
					
				}
			});
			btnDodaj.setBounds(26, 212, 164, 23);
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(239, 212, 164, 23);
		}
		return btnOdustani;
	}
	private JSpinner getSpinner_1_1() {
		if (danP == null) {
			danP = new JSpinner();
			danP.setBounds(239, 106, 39, 20);
		}
		return danP;
	}
	private JSpinner getSpinner_2_1() {
		if (mesecP == null) {
			mesecP = new JSpinner();
			mesecP.setBounds(288, 106, 45, 20);
		}
		return mesecP;
	}
	private JSpinner getGodinaP() {
		if (godinaP == null) {
			godinaP = new JSpinner();
			godinaP.setModel(new SpinnerNumberModel(2015, 2015, 2100, 1));
			godinaP.setBounds(343, 106, 60, 20);
		}
		return godinaP;
	}
	private JSpinner getDanZ() {
		if (danZ == null) {
			danZ = new JSpinner();
			danZ.setBounds(239, 162, 39, 20);
		}
		return danZ;
	}
	private JSpinner getMesecZ() {
		if (mesecZ == null) {
			mesecZ = new JSpinner();
			mesecZ.setBounds(288, 162, 45, 20);
		}
		return mesecZ;
	}
	private JSpinner getGodinaZ() {
		if (godinaZ == null) {
			godinaZ = new JSpinner();
			godinaZ.setModel(new SpinnerNumberModel(2015, 2015, 2100, 1));
			godinaZ.setBounds(343, 162, 60, 20);
		}
		return godinaZ;
	}
}
