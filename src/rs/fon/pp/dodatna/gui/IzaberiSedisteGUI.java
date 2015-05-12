package rs.fon.pp.dodatna.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;

import rs.fon.pp.dodatna.bioskop.Projekcija;
import rs.fon.pp.dodatna.bioskop.Raspored;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class IzaberiSedisteGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private Projekcija projekcija;
	
	/**
	 * Create the frame.
	 */
		
	
	public IzaberiSedisteGUI(RezervisiGUI prozor, LinkedList<Projekcija> projekcije, Projekcija projekcija) {
		createContents();
	}
	private void createContents() {
		setTitle("Izaberi sedi\u0161te");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
		this.projekcija = projekcija;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
		}
		return panel;
	}

	
	public void prikaziSalu (int redovi, int kolone) {
		kolone = 5;
		redovi = 4;
		panel.setLayout(new GridLayout(kolone, redovi));
		 for (int red = 0; red < redovi; redovi++) {
	            for (int kolona = 0; kolona < kolone; kolone++) {
	                final JToggleButton button = new JToggleButton("Red: " + red+1 + " Sedište: " + kolona+1);
	                button.addActionListener(new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent actionEvent) {
	                        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
	                        boolean selected = abstractButton.getModel().isSelected();
	                        if (selected) {
	                            button.setIcon(new ImageIcon(IzaberiSedisteGUI.class.getResource("/Icons/slike/Close-2-icon.png")));
	                        } else {
	                            button.setIcon(null);
	                        }
	                    }
	                });
	                panel.add(button);
	            }
		 }
	}
}