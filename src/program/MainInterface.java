package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

public class MainInterface {

	private JFrame frame;
	private JTextField txtBineAtiVenit;
	private JTextField textField;
	private JTextField txtIntroducetiCnpul;
	private JTextField textField_1;
	private JTextField txtIntroducetiNumeleFilmului;
	private JTextField textField_2;
	public JTextArea TextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface window = new MainInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.setBounds(100, 100, 569, 462);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		panel_1.setBounds(130, 70, 300, 322);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(0, 70, 553, 353);
		panel.setVisible(false);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton Filme_Disponibile = new JButton("Afiseaza toate filmele disponibile");
		Filme_Disponibile.setBounds(0, 0, 300, 60);
		panel_1.add(Filme_Disponibile);
		Filme_Disponibile.setFont(new Font("Tahoma", Font.BOLD, 15));
		Filme_Disponibile.setForeground(Color.CYAN);
		Filme_Disponibile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Showm frame_1 = new Showm();
					ShowMovies.ShowAllMovies(frame_1);
					frame_1.setVisible(true);
				} catch (Exception e1) {e1.printStackTrace();}
			}
		});
		Filme_Disponibile.setBackground(Color.DARK_GRAY);
		
		JButton Cauta_film = new JButton("Cauta un film");
		Cauta_film.setBounds(0, 70, 300, 60);
		panel_1.add(Cauta_film);
		Cauta_film.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cauta frame_2 = new Cauta();
				frame_2.setVisible(true);
			}
		});
		Cauta_film.setFont(new Font("Tahoma", Font.BOLD, 15));
		Cauta_film.setBackground(Color.DARK_GRAY);
		Cauta_film.setForeground(Color.CYAN);
		
		JButton btnNewButton = new JButton("Inchiriaza un film");
		btnNewButton.setBounds(0, 140, 300, 60);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inchiriaza frame_3 = new Inchiriaza();
				frame_3.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnNewButton_3 = new JButton("Returneaza un film");
		btnNewButton_3.setBounds(0, 211, 300, 60);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setForeground(Color.CYAN);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		
		JButton btnNewButton_2 = new JButton("Iesire");
		btnNewButton_2.setBounds(50, 282, 200, 40);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setForeground(Color.CYAN);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		txtIntroducetiCnpul = new JTextField();
		txtIntroducetiCnpul.setText("Introduceti CNP-ul:");
		txtIntroducetiCnpul.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntroducetiCnpul.setForeground(Color.CYAN);
		txtIntroducetiCnpul.setBackground(new Color(178, 34, 34));
		txtIntroducetiCnpul.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtIntroducetiCnpul.setEditable(false);
		txtIntroducetiCnpul.setBounds(180, 11, 201, 30);
		panel.add(txtIntroducetiCnpul);
		txtIntroducetiCnpul.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_1.setBounds(141, 52, 290, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		txtIntroducetiNumeleFilmului = new JTextField();
		txtIntroducetiNumeleFilmului.setText("Introduceti Numele Filmului:");
		txtIntroducetiNumeleFilmului.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntroducetiNumeleFilmului.setForeground(Color.CYAN);
		txtIntroducetiNumeleFilmului.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtIntroducetiNumeleFilmului.setEditable(false);
		txtIntroducetiNumeleFilmului.setColumns(10);
		txtIntroducetiNumeleFilmului.setBackground(new Color(178, 34, 34));
		txtIntroducetiNumeleFilmului.setBounds(139, 88, 290, 30);
		panel.add(txtIntroducetiNumeleFilmului);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_2.setColumns(10);
		textField_2.setBounds(141, 130, 290, 25);
		panel.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("Returneaza!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextArea.setText(null);
				String cnp = textField_1.getText();
				String numefilm = textField_2.getText();
				if(Transactions.SearchinH(cnp, numefilm)) {
		  			Transactions.ReturnInTime(cnp, numefilm, TextArea);
		  		}
		  		else
		  			if(Transactions.SearchinU(cnp, numefilm)) {
		  				Transactions.ReturnLate(cnp, numefilm, TextArea);
		  			}
		  		else
		  				TextArea.append("Acest film nu exista in lista de filme inchiriate");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.CYAN);
		btnNewButton_1.setBounds(205, 169, 150, 30);
		panel.add(btnNewButton_1);
		
		TextArea = new JTextArea();
		TextArea.setFont(new Font("Monospaced", Font.BOLD, 14));
		TextArea.setForeground(Color.CYAN);
		TextArea.setBackground(new Color(178, 34, 34));
		TextArea.setEditable(false);
		TextArea.setBounds(10, 238, 533, 66);
		panel.add(TextArea);
		
		txtBineAtiVenit = new JTextField();
		txtBineAtiVenit.setBackground(new Color(178, 34, 34));
		txtBineAtiVenit.setEditable(false);
		txtBineAtiVenit.setForeground(new Color(0, 0, 0));
		txtBineAtiVenit.setHorizontalAlignment(SwingConstants.CENTER);
		txtBineAtiVenit.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtBineAtiVenit.setText("Bine ati Venit!");
		txtBineAtiVenit.setBounds(130, 11, 300, 51);
		frame.getContentPane().add(txtBineAtiVenit);
		txtBineAtiVenit.setColumns(1);
		
	}
}
