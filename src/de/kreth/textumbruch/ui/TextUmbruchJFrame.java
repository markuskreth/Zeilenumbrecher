package de.kreth.textumbruch.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.kreth.textumbruch.business.TextUmbrecher;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

public class TextUmbruchJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldZeichenAnzahl;
	private final TextUmbrecher umbrecher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextUmbruchJFrame frame = new TextUmbruchJFrame();
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
	public TextUmbruchJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 543);
		initComponentes();
		umbrecher = new TextUmbrecher();
	}

	private void initComponentes() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.PAGE_AXIS));
		
		JLabel lblNewLabel = new JLabel("Vorher");
		panelCenter.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panelCenter.add(scrollPane_1);
		
		JTextArea textAreaInput = new JTextArea();
		scrollPane_1.setViewportView(textAreaInput);
		
		JLabel lblNewLabel_1 = new JLabel("Nachher");
		panelCenter.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panelCenter.add(scrollPane);
		
		JTextArea textAreaOutput = new JTextArea();
		scrollPane.setViewportView(textAreaOutput);
		textAreaOutput.setEditable(false);
		
		JPanel panel = new JPanel();
		panelCenter.add(panel);
		
		JLabel lblBreiteInZeichen = new JLabel("Breite in Zeichen:");
		panel.add(lblBreiteInZeichen);
		
		textFieldZeichenAnzahl = new JTextField();
		panel.add(textFieldZeichenAnzahl);
		textFieldZeichenAnzahl.setColumns(10);
		textFieldZeichenAnzahl.setInputVerifier(new IntegerInputVerifier());
		
		JButton btnUmbreche = new JButton("Umbreche");
		btnUmbreche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int lineLength = Integer.parseInt(textFieldZeichenAnzahl.getText());
					textAreaOutput.setText(umbrecher.umbruch(textAreaInput.getText(), lineLength));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(TextUmbruchJFrame.this, "Bitte geben Sie eine gültige Anzahl von Zeichen ein!");
					textFieldZeichenAnzahl.requestFocus();
				}
			}
		});
		panel.add(btnUmbreche);
	}

	private class IntegerInputVerifier extends InputVerifier {

		@Override
		public boolean verify(JComponent input) {
			String inputText = ((JTextField)input).getText().trim();
			if (inputText.matches("\\d*"))
				return true;
			return false;
		}
		
	}
}
