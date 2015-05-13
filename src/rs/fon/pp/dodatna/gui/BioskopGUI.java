package rs.fon.pp.dodatna.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;

import rs.fon.pp.dodatna.bioskop.Projekcija;
import rs.fon.pp.dodatna.bioskop.Raspored;
import rs.fon.pp.dodatna.bioskop.RasporedInterface;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Panel;

import javax.swing.SwingConstants;

import java.awt.Label;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Button;
import java.util.LinkedList;
import java.awt.Font;

public class BioskopGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmDodajNoviFilm;
	private JMenuItem mntmDodajizmeniSalu;
	private JMenuItem mntmDodajProjekciju;
	private JScrollPane scrollPane;
	private JButton btnDodajNoviFilm;
	private JButton btnDodajProjekciju;
	private JButton btnNewButton;
	private JMenu mnDatotek;
	private JMenuItem mntmSauvaj;
	private JMenuItem mntmOtvori;
	private JButton btnSauvajSvePromene;
	protected JTextArea textArea;
	private JList list;
	protected Raspored bioskop;
	private JMenuItem mntmOtvori_1;
	private JMenuItem mntmIzaiIzAplikacije;


	/**
	 * Create the frame.
	 */
	public BioskopGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.ugasiAplikaciju();
			}
		});
		createContents();
	}
	private void createContents() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setTitle("Rezervacija bioskopskih karata");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 494);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnDodajNoviFilm());
		contentPane.add(getBtnDodajProjekciju());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnSauvajSvePromene());
		bioskop = new Raspored();
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnDatotek());
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Napravi izmene");
			mnNewMenu.add(getMntmDodajNoviFilm());
			mnNewMenu.add(getMntmDodajizmeniSalu());
			mnNewMenu.add(getMntmDodajProjekciju());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmDodajNoviFilm() {
		if (mntmDodajNoviFilm == null) {
			mntmDodajNoviFilm = new JMenuItem("Dodaj novi film");
			mntmDodajNoviFilm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziDodajFilmGUI();
				}
			});
		}
		return mntmDodajNoviFilm;
	}
	private JMenuItem getMntmDodajizmeniSalu() {
		if (mntmDodajizmeniSalu == null) {
			mntmDodajizmeniSalu = new JMenuItem("Dodaj/izmeni salu");
			mntmDodajizmeniSalu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
		}
		return mntmDodajizmeniSalu;
	}
	private JMenuItem getMntmDodajProjekciju() {
		if (mntmDodajProjekciju == null) {
			mntmDodajProjekciju = new JMenuItem("Dodaj projekciju");
			mntmDodajProjekciju.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.prikaziDodajProjekcijuGUI();
				}
			});
		}
		return mntmDodajProjekciju;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 191, 509, 196);
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	private JButton getBtnDodajNoviFilm() {
		if (btnDodajNoviFilm == null) {
			btnDodajNoviFilm = new JButton("Dodaj novi film");
			btnDodajNoviFilm.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnDodajNoviFilm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziDodajFilmGUI();
				}
			});
			btnDodajNoviFilm.setBounds(12, 13, 175, 31);
		}
		return btnDodajNoviFilm;
	}
	private JButton getBtnDodajProjekciju() {
		if (btnDodajProjekciju == null) {
			btnDodajProjekciju = new JButton("Dodaj projekciju");
			btnDodajProjekciju.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			btnDodajProjekciju.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziDodajProjekcijuGUI();
				}
			});
			btnDodajProjekciju.setBounds(12, 51, 175, 31);
		}
		return btnDodajProjekciju;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Rezervi\u0161i kartu");
			btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.prikaziRezervisiGUI();
				}
			});
			btnNewButton.setBounds(12, 106, 175, 54);
		}
		return btnNewButton;
	}
	private JMenu getMnDatotek() {
		if (mnDatotek == null) {
			mnDatotek = new JMenu("Datoteka");
			mnDatotek.add(getMntmOtvori_1());
			mnDatotek.add(getMntmSauvaj());
			mnDatotek.add(getMntmOtvori());
			mnDatotek.add(getMntmIzaiIzAplikacije());
		}
		return mnDatotek;
	}
	private JMenuItem getMntmSauvaj() {
		if (mntmSauvaj == null) {
			mntmSauvaj = new JMenuItem("Sa\u010Duvaj");
			mntmSauvaj.setIcon(new ImageIcon(BioskopGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
			mntmSauvaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.sacuvajUFajl();
				}
			});
		}
		return mntmSauvaj;
	}
	private JMenuItem getMntmOtvori() {
		if (mntmOtvori == null) {
			mntmOtvori = new JMenuItem("Prikaži raspored projekcija");
			mntmOtvori.setIcon(new ImageIcon(BioskopGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
			mntmOtvori.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
		}
		return mntmOtvori;
	}
	private JButton getBtnSauvajSvePromene() {
		if (btnSauvajSvePromene == null) {
			btnSauvajSvePromene = new JButton("Sa\u010Duvaj sve promene");
			btnSauvajSvePromene.setFont(new Font("Segoe UI", Font.ITALIC, 16));
			btnSauvajSvePromene.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (GUIKontroler.sacuvajUFajl()){
					textArea.setText("Podaci su uspešno sačuvani!");
					}
				}
			});
			btnSauvajSvePromene.setBounds(330, 1, 191, 46);
		}
		return btnSauvajSvePromene;
	}
	JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	
	protected void prikaziSveProjekcije(LinkedList<Projekcija> projekcije) {
		list.setListData(projekcije.toArray());

	}
	private JMenuItem getMntmOtvori_1() {
		if (mntmOtvori_1 == null) {
			mntmOtvori_1 = new JMenuItem("Otvori");
			mntmOtvori_1.setIcon(new ImageIcon(BioskopGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
			mntmOtvori_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ucitajIzFajla();
				}
			});
		}
		return mntmOtvori_1;
	}
	private JMenuItem getMntmIzaiIzAplikacije() {
		if (mntmIzaiIzAplikacije == null) {
			mntmIzaiIzAplikacije = new JMenuItem("Izađi iz aplikacije");
			mntmIzaiIzAplikacije.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
		}
		return mntmIzaiIzAplikacije;
	}
}
