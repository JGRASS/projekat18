package rs.fon.pp.dodatna.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajSaluGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblBrojKolona;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblBrojRedova;
	private JLabel lblifra;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnOdustani;
	private BioskopGUI glavniProzor;



	/**
	 * Create the frame.
	 * @param glavniProzor 
	 */
	public DodajSaluGUI(BioskopGUI glavniProzor) {
		createContents();
		this.glavniProzor = glavniProzor;
	}
	private void createContents() {
		setTitle("Dodaj salu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel_1(), BorderLayout.CENTER);
		
	}
	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLabel_1());
			panel.add(getTextField());
			panel.add(getLblBrojKolona());
			panel.add(getTextField_1());
			panel.add(getTextField_2());
			panel.add(getLblBrojRedova());
			panel.add(getLblifra());
			panel.add(getTextField_3());
			panel.add(getBtnNewButton());
			panel.add(getBtnOdustani());
		}
		return panel;
	}
	private JLabel getLabel_1() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Naziv sale");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(22, 26, 117, 27);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(22, 54, 124, 27);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblBrojKolona() {
		if (lblBrojKolona == null) {
			lblBrojKolona = new JLabel("Broj kolona");
			lblBrojKolona.setHorizontalAlignment(SwingConstants.CENTER);
			lblBrojKolona.setBounds(232, 26, 104, 27);
		}
		return lblBrojKolona;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(340, 26, 60, 27);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(340, 66, 60, 27);
		}
		return textField_2;
	}
	private JLabel getLblBrojRedova() {
		if (lblBrojRedova == null) {
			lblBrojRedova = new JLabel("Broj redova");
			lblBrojRedova.setHorizontalAlignment(SwingConstants.CENTER);
			lblBrojRedova.setBounds(232, 66, 104, 27);
		}
		return lblBrojRedova;
	}
	private JLabel getLblifra() {
		if (lblifra == null) {
			lblifra = new JLabel("\u0160ifra");
			lblifra.setHorizontalAlignment(SwingConstants.CENTER);
			lblifra.setBounds(22, 102, 117, 27);
		}
		return lblifra;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(22, 131, 124, 27);
		}
		return textField_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Dodaj");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.unesiSalu(textField.getText(), Integer.parseInt(textField_3.getText()),
							Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()));	
					dispose();
				}
			});
			btnNewButton.setBounds(231, 122, 169, 45);
		}
		return btnNewButton;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setBounds(231, 185, 169, 45);
		}
		return btnOdustani;
	}
}
