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
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;

public class IzaberiSedisteGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	
	/**
	 * Create the frame.
	 */
		
	
	public IzaberiSedisteGUI(RezervisiGUI prozor) {
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
		contentPane.add(getPanel_1(), BorderLayout.EAST);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
		}
		return panel;
	}

	public void prikaziSalu (int redovi, int kolone) {
		panel.setLayout(new GridLayout(redovi, kolone, 0, 0));
		 for (int red = 0; red < redovi; red++) {
	            for (int kolona = 0; kolona < kolone; kolona++) {
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
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(80, 10));
			panel_1.setLayout(null);
			panel_1.add(getBtnNewButton());
		}
		return panel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("OK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnNewButton.setBounds(12, 45, 56, 44);
		}
		return btnNewButton;
	}
}