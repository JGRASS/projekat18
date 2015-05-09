package rs.fon.pp.dodatna.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;

import rs.fon.pp.dodatna.bioskop.Raspored;
import rs.fon.pp.dodatna.bioskop.RasporedInterface;

public class BioskopGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmDodajNoviFilm;
	private JMenuItem mntmDodajizmeniSalu;
	private JMenuItem mntmDodajProjekciju;
	private JButton btnNewButton;
	private JButton btnPrkaiRasporedProjekcija;


	/**
	 * Create the frame.
	 */
	public BioskopGUI() {
		createContents();
	}
	private void createContents() {
		setTitle("Rezervacija bioskopskih karata");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 343);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnPrkaiRasporedProjekcija());
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
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
		}
		return mntmDodajNoviFilm;
	}
	private JMenuItem getMntmDodajizmeniSalu() {
		if (mntmDodajizmeniSalu == null) {
			mntmDodajizmeniSalu = new JMenuItem("Dodaj/izmeni salu");
		}
		return mntmDodajizmeniSalu;
	}
	private JMenuItem getMntmDodajProjekciju() {
		if (mntmDodajProjekciju == null) {
			mntmDodajProjekciju = new JMenuItem("Dodaj projekciju");
		}
		return mntmDodajProjekciju;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Rezervi\u0161i");
			btnNewButton.setBounds(24, 13, 97, 25);
		}
		return btnNewButton;
	}
	private JButton getBtnPrkaiRasporedProjekcija() {
		if (btnPrkaiRasporedProjekcija == null) {
			btnPrkaiRasporedProjekcija = new JButton("Prika\u017Ei raspored projekcija za odre\u0111eni dan");
			btnPrkaiRasporedProjekcija.setBounds(146, 13, 281, 25);
		}
		return btnPrkaiRasporedProjekcija;
	}
}
