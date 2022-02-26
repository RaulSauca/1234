package program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Inchiriaza extends JFrame {

	private JPanel contentPane;
	private JTextField txtInchiriazaUnFilm;
	private JTextField txtIntroducetiNumeleFilmului;
	private JTextField textField;
	public JTextArea textArea;
	public JButton btnNewButton, btnNu, btnNewButton1, btnNu1;
	private JPanel panel_1;
	private JTextField txtSuntetiUtilizatorNou;
	private JTextField txtNumeleDeFamilie;
	private JTextField txtPrenumele;
	private JTextField txtCnp;
	private JTextField txtNumarTelefon;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JButton btnNewButton_1;
	private JPanel panel_2;
	private JTextField txtCumDoritiSa;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private String numefilm, nume,prenume,cnp,tel;
	public JTextArea textArea_1;
	private JTextField textField_1;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private Boolean Utilizator=false;
	Client a = new Client();
	private JTextField txtVaRugamIntorduceti;
	private JTextField txtNumarulCardului;
	private JTextField txtLunaExpirarii;
	private JTextField txtAnulExpirarii;
	private JTextField txtCvvcvv;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_9;
	private JButton btnNewButton_8;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inchiriaza frame = new Inchiriaza();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/movie_rental_system";
			String username = "root";
			String password = "1234";
				
			Connection conn = DriverManager.getConnection(url,username,password);
			return conn;
				
		} catch(Exception e) {System.out.println(e);}
		return null;
	}
	
	/**
	 * Create the frame.
	 */
	public Inchiriaza() {
		setBackground(new Color(178, 34, 34));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtInchiriazaUnFilm = new JTextField();
		txtInchiriazaUnFilm.setBackground(new Color(178, 34, 34));
		txtInchiriazaUnFilm.setEditable(false);
		txtInchiriazaUnFilm.setHorizontalAlignment(SwingConstants.CENTER);
		txtInchiriazaUnFilm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtInchiriazaUnFilm.setForeground(Color.BLACK);
		txtInchiriazaUnFilm.setText("Inchiriaza un film");
		txtInchiriazaUnFilm.setBounds(100, 11, 250, 40);
		contentPane.add(txtInchiriazaUnFilm);
		txtInchiriazaUnFilm.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(0, 62, 434, 299);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtIntroducetiNumeleFilmului = new JTextField();
		txtIntroducetiNumeleFilmului.setBounds(110, 0, 229, 30);
		panel.add(txtIntroducetiNumeleFilmului);
		txtIntroducetiNumeleFilmului.setText("Introduceti numele filmului:");
		txtIntroducetiNumeleFilmului.setHorizontalAlignment(SwingConstants.CENTER);
		txtIntroducetiNumeleFilmului.setForeground(Color.CYAN);
		txtIntroducetiNumeleFilmului.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtIntroducetiNumeleFilmului.setColumns(10);
		txtIntroducetiNumeleFilmului.setBackground(new Color(178, 34, 34));
		
		textField = new JTextField();
		textField.setBounds(80, 41, 280, 30);
		panel.add(textField);
		textField.setForeground(Color.CYAN);
		textField.setColumns(10);
		textField.setBackground(Color.LIGHT_GRAY);
		
		btnNewButton = new JButton("DA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(160, 247, 70, 30);
		btnNewButton.setVisible(false);
		panel.add(btnNewButton);
		
		btnNu = new JButton("NU");
		btnNu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				btnNewButton.setVisible(false);
				btnNu.setVisible(false);
			}
		});
		btnNu.setForeground(Color.CYAN);
		btnNu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNu.setBackground(Color.DARK_GRAY);
		btnNu.setBounds(240, 247, 70, 30);
		btnNu.setVisible(false);
		panel.add(btnNu);
		
		JButton btnNewButton_4 = new JButton("Cauta");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(null);
					numefilm = textField.getText();
					if(ShowMovies.ShowMoviesByNameinc(numefilm, textArea, btnNewButton, btnNu))
					{
						
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(180, 85, 89, 23);
		panel.add(btnNewButton_4);
		btnNewButton_4.setForeground(Color.CYAN);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setForeground(Color.CYAN);
		textArea.setBackground(new Color(178, 34, 34));
		textArea.setBounds(10, 186, 280, 153);
		
		JScrollPane scroll = new JScrollPane ( textArea );
		scroll.setBounds(59, 119, 330, 117);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add ( scroll );
		panel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(178, 34, 34));
		panel_2.setBounds(0, 62, 434, 299);
		panel_2.setVisible(false);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		panel_1.setBounds(0, 62, 434, 299);
		panel_1.setVisible(false);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(178, 34, 34));
		panel_3.setBounds(0, 62, 434, 299);
		panel_3.setVisible(false);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Salvati datele cardului");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox.setBackground(new Color(178, 34, 34));
		chckbxNewCheckBox.setForeground(Color.CYAN);
		chckbxNewCheckBox.setBounds(33, 210, 166, 23);
		chckbxNewCheckBox.setVisible(false);
		panel_3.add(chckbxNewCheckBox);
		
		JButton btnNewButton_7 = new JButton("Inaitne");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnp = textField_5.getText();
				System.out.println(cnp);
				
	  			try {
					if(a.FindbyCNP(cnp)) {
						panel_1.setVisible(false);
						panel_2.setVisible(true);
						Utilizator=true;
					}
					else {
						textField_5.setText(null);
						txtSuntetiUtilizatorNou.setText("CNP-ul introdus nu exista:");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7.setBackground(Color.DARK_GRAY);
		btnNewButton_7.setForeground(Color.CYAN);
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_7.setBounds(175, 119, 102, 36);
		btnNewButton_7.setVisible(false);
		panel_1.add(btnNewButton_7);
		
		txtSuntetiUtilizatorNou = new JTextField();
		txtSuntetiUtilizatorNou.setText("Sunteti utilizator nou?");
		txtSuntetiUtilizatorNou.setHorizontalAlignment(SwingConstants.CENTER);
		txtSuntetiUtilizatorNou.setForeground(Color.CYAN);
		txtSuntetiUtilizatorNou.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtSuntetiUtilizatorNou.setEditable(false);
		txtSuntetiUtilizatorNou.setColumns(10);
		txtSuntetiUtilizatorNou.setBackground(new Color(178, 34, 34));
		txtSuntetiUtilizatorNou.setBounds(100, 0, 250, 40);
		panel_1.add(txtSuntetiUtilizatorNou);
		
		btnNewButton1 = new JButton("DA");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton1.setVisible(false);
				btnNu1.setVisible(false);
				txtSuntetiUtilizatorNou.setText("Va rugam introduceti:");
				txtNumeleDeFamilie.setVisible(true);
				txtPrenumele.setVisible(true);
				txtCnp.setVisible(true);
				txtNumarTelefon.setVisible(true);
				textField_5.setVisible(true);
				textField_6.setVisible(true);
				textField_7.setVisible(true);
				textField_8.setVisible(true);
				btnNewButton_1.setVisible(true);
			}
		});
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton1.setForeground(Color.CYAN);
		btnNewButton1.setBackground(Color.DARK_GRAY);
		btnNewButton1.setBounds(150, 51, 70, 30);
		panel_1.add(btnNewButton1);
		
		btnNu1 = new JButton("NU");
		btnNu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton1.setVisible(false);
				btnNu1.setVisible(false);
				txtSuntetiUtilizatorNou.setText("Va rugam introduceti:");
				txtNumeleDeFamilie.setText("CNP:");
				txtNumeleDeFamilie.setVisible(true);
				textField_5.setVisible(true);
				btnNewButton_7.setVisible(true);
			}
		});
		btnNu1.setForeground(Color.CYAN);
		btnNu1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNu1.setBackground(Color.DARK_GRAY);
		btnNu1.setBounds(230, 51, 70, 30);
		panel_1.add(btnNu1);
		
		txtNumeleDeFamilie = new JTextField();
		txtNumeleDeFamilie.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNumeleDeFamilie.setText("Numele de familie:");
		txtNumeleDeFamilie.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeleDeFamilie.setEditable(false);
		txtNumeleDeFamilie.setForeground(Color.CYAN);
		txtNumeleDeFamilie.setBackground(new Color(178, 34, 34));
		txtNumeleDeFamilie.setBounds(10, 80, 130, 30);
		txtNumeleDeFamilie.setVisible(false);
		panel_1.add(txtNumeleDeFamilie);
		txtNumeleDeFamilie.setColumns(10);
		
		txtPrenumele = new JTextField();
		txtPrenumele.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtPrenumele.setText("Prenumele:");
		txtPrenumele.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrenumele.setEditable(false);
		txtPrenumele.setForeground(Color.CYAN);
		txtPrenumele.setBackground(new Color(178, 34, 34));
		txtPrenumele.setBounds(10, 121, 130, 30);
		txtPrenumele.setVisible(false);
		panel_1.add(txtPrenumele);
		txtPrenumele.setColumns(10);
		
		txtCnp = new JTextField();
		txtCnp.setText("CNP:");
		txtCnp.setHorizontalAlignment(SwingConstants.CENTER);
		txtCnp.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtCnp.setEditable(false);
		txtCnp.setForeground(Color.CYAN);
		txtCnp.setBackground(new Color(178, 34, 34));
		txtCnp.setBounds(10, 162, 130, 30);
		txtCnp.setVisible(false);
		panel_1.add(txtCnp);
		txtCnp.setColumns(10);
		
		txtNumarTelefon = new JTextField();
		txtNumarTelefon.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNumarTelefon.setText("Numar Telefon:");
		txtNumarTelefon.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumarTelefon.setEditable(false);
		txtNumarTelefon.setForeground(Color.CYAN);
		txtNumarTelefon.setBackground(new Color(178, 34, 34));
		txtNumarTelefon.setBounds(10, 203, 130, 30);
		txtNumarTelefon.setVisible(false);
		panel_1.add(txtNumarTelefon);
		txtNumarTelefon.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(150, 85, 200, 20);
		textField_5.setVisible(false);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(150, 126, 200, 20);
		textField_6.setVisible(false);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(150, 167, 200, 20);
		textField_7.setVisible(false);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(150, 208, 200, 20);
		textField_8.setVisible(false);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		btnNewButton_1 = new JButton("Inainte");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nume = textField_5.getText();
				prenume = textField_6.getText();
				cnp = textField_7.getText();
				tel = textField_8.getText();
				try {
					Client.AddClienttoDB(nume,prenume,cnp,tel);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				
			}
		});
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.CYAN);
		btnNewButton_1.setBounds(175, 252, 102, 36);
		btnNewButton_1.setVisible(false);
		panel_1.add(btnNewButton_1);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtCumDoritiSa = new JTextField();
		txtCumDoritiSa.setText("Cum doriti sa platiti?");
		txtCumDoritiSa.setHorizontalAlignment(SwingConstants.CENTER);
		txtCumDoritiSa.setForeground(Color.CYAN);
		txtCumDoritiSa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCumDoritiSa.setEditable(false);
		txtCumDoritiSa.setColumns(10);
		txtCumDoritiSa.setBackground(new Color(178, 34, 34));
		txtCumDoritiSa.setBounds(10, 0, 414, 40);
		panel_2.add(txtCumDoritiSa);
		
		btnNewButton_2 = new JButton("Cash");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCumDoritiSa.setText("Pe cate zile ati dori sa inchiriati filmul (5$/zi)");
				btnNewButton_2.setVisible(false);
				btnNewButton_3.setVisible(false);
				textField_1.setVisible(true);
				btnNewButton_5.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setForeground(Color.CYAN);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(187, 51, 73, 30);
		panel_2.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Card");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCumDoritiSa.setText("Pe cate zile ati dori sa inchiriati filmul (5$/zi)");
				btnNewButton_2.setVisible(false);
				btnNewButton_3.setVisible(false);
				textField_1.setVisible(true);
				btnNewButton_6.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setForeground(Color.CYAN);
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setBounds(187, 85, 73, 30);
		panel_2.add(btnNewButton_3);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textArea_1.setBounds(99, 40, 250, 259);
		textArea_1.setVisible(false);
		panel_2.add(textArea_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setBounds(167, 51, 115, 30);
		textField_1.setVisible(false);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_5 = new JButton("Inchiriaza!");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setVisible(true);
				btnNewButton_5.setVisible(false);
				int zile = Integer.parseInt(textField_1.getText());
				String total = Transactions.HiredMovie(cnp, numefilm, 0, zile);
				txtCumDoritiSa.setText("Va rugam sa prezentati bonul la Ghiseu");
				Transactions.Printreceip(nume, prenume, numefilm, 0, total, textArea_1);
			}
		});
		btnNewButton_5.setForeground(Color.CYAN);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_5.setBackground(Color.DARK_GRAY);
		btnNewButton_5.setBounds(152, 85, 155, 30);
		btnNewButton_5.setVisible(false);
		panel_2.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("Inchiriaza!");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					panel_2.setVisible(false);
					panel_3.setVisible(true);
					btnNewButton_6.setVisible(false);
					if(Client.checkCard(cnp)) {
						txtCvvcvv.setVisible(true);
						textField_9.setVisible(true);
					}
					else
					{
						txtNumarulCardului.setVisible(true);
	  					txtLunaExpirarii.setVisible(true);
	  					txtAnulExpirarii.setVisible(true);
	  					txtCvvcvv.setVisible(true);
	  					textField_2.setVisible(true);
	  					textField_3.setVisible(true);
	  					textField_4.setVisible(true);
	  					textField_9.setVisible(true);
	  					chckbxNewCheckBox.setVisible(true);
					}
				
				//int zile = Integer.parseInt(textField_1.getText());
//				String total = Transactions.HiredMovie(cnp, numefilm, 1, zile);
//				if(!Utilizator) {
//				String nr,cvv,luna,an;
//				panel_2.setVisible(false);
//				panel_3.setVisible(true);
//				
//				
//				
//				
//				//Client.addCard(cnp,nr,cvv,luna,an);
//				
//				txtCumDoritiSa.setText("Tranzactie reusita! Va multumim!");
//				Transactions.Printreceip(nume, prenume, numefilm, 1, total, textArea_1);
//				}
//				else {
//					if(Client.checkCard(cnp)) {
//	  					total =Transactions.HiredMovie(cnp, numefilm, 1,zile);
//	  					if(Transactions.CheckCVV(cnp)) {
//	  						txtCumDoritiSa.setText("Tranzactie reusita! Va multumim!");
//	  						textArea_1.setVisible(true);
//	  						Transactions.Printreceip(a.getNumepers(), a.getPrenumepers(), nume, 1, total, textArea_1);
//	  					}
//	  					else {
//	  						txtCumDoritiSa.setText("CVV-ul nu este corect");
//	  					}
//	  				}
//	  				else {
//	  					total = Transactions.HiredMovie(cnp, numefilm, 1, zile);
//	  					//Client.addCard(cnpnr,cvv,luna,an);
//	  					textArea_1.setVisible(true);
//	  					Transactions.Printreceip(a.getNumepers(), a.getPrenumepers(), nume, 1, total, textArea_1);
//	  				}
//				}
//					
				
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6.setForeground(Color.CYAN);
		btnNewButton_6.setBackground(Color.DARK_GRAY);
		btnNewButton_6.setBounds(152, 85, 155, 30);
		btnNewButton_6.setVisible(false);
		panel_2.add(btnNewButton_6);
		
		txtVaRugamIntorduceti = new JTextField();
		txtVaRugamIntorduceti.setText("Va Rugam intorduceti datele cardului");
		txtVaRugamIntorduceti.setHorizontalAlignment(SwingConstants.CENTER);
		txtVaRugamIntorduceti.setForeground(Color.CYAN);
		txtVaRugamIntorduceti.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtVaRugamIntorduceti.setEditable(false);
		txtVaRugamIntorduceti.setColumns(10);
		txtVaRugamIntorduceti.setBackground(new Color(178, 34, 34));
		txtVaRugamIntorduceti.setBounds(10, 0, 414, 40);
		panel_3.add(txtVaRugamIntorduceti);
		
		txtNumarulCardului = new JTextField();
		txtNumarulCardului.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumarulCardului.setText("Numarul Cardului:");
		txtNumarulCardului.setEditable(false);
		txtNumarulCardului.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNumarulCardului.setForeground(Color.CYAN);
		txtNumarulCardului.setBackground(new Color(178, 34, 34));
		txtNumarulCardului.setBounds(10, 51, 150, 30);
		txtNumarulCardului.setVisible(false);
		panel_3.add(txtNumarulCardului);
		txtNumarulCardului.setColumns(10);
		
		txtLunaExpirarii = new JTextField();
		txtLunaExpirarii.setEditable(false);
		txtLunaExpirarii.setBackground(new Color(178, 34, 34));
		txtLunaExpirarii.setForeground(Color.CYAN);
		txtLunaExpirarii.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtLunaExpirarii.setText("Luna Expirarii:");
		txtLunaExpirarii.setHorizontalAlignment(SwingConstants.CENTER);
		txtLunaExpirarii.setBounds(10, 90, 150, 30);
		txtLunaExpirarii.setVisible(false);
		panel_3.add(txtLunaExpirarii);
		txtLunaExpirarii.setColumns(10);
		
		txtAnulExpirarii = new JTextField();
		txtAnulExpirarii.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtAnulExpirarii.setEditable(false);
		txtAnulExpirarii.setBackground(new Color(178, 34, 34));
		txtAnulExpirarii.setForeground(Color.CYAN);
		txtAnulExpirarii.setText("Anul Expirarii:");
		txtAnulExpirarii.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnulExpirarii.setBounds(10, 130, 150, 30);
		txtAnulExpirarii.setVisible(false);
		panel_3.add(txtAnulExpirarii);
		txtAnulExpirarii.setColumns(10);
		
		txtCvvcvv = new JTextField();
		txtCvvcvv.setText("CVV/CVV2:");
		txtCvvcvv.setHorizontalAlignment(SwingConstants.CENTER);
		txtCvvcvv.setForeground(Color.CYAN);
		txtCvvcvv.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtCvvcvv.setEditable(false);
		txtCvvcvv.setBackground(new Color(178, 34, 34));
		txtCvvcvv.setBounds(10, 170, 150, 30);
		txtCvvcvv.setVisible(false);
		panel_3.add(txtCvvcvv);
		txtCvvcvv.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(170, 55, 200, 20);
		textField_2.setVisible(false);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(170, 95, 200, 20);
		textField_3.setVisible(false);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(170, 136, 200, 20);
		textField_4.setVisible(false);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(170, 175, 200, 20);
		textField_9.setVisible(false);
		panel_3.add(textField_9);
		textField_9.setColumns(10);
		
		btnNewButton_8 = new JButton("Plateste!");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int zile = Integer.parseInt(textField_1.getText());
				String nr,cvv,luna,an;
		
				if(Client.checkCard(cnp)) {
  					String total = Transactions.HiredMovie(cnp, numefilm, 1,zile);
  					cvv = textField_9.getText();
  					if(Transactions.CheckCVV(cnp, cvv)) {
  						txtCumDoritiSa.setText("Tranzactie reusita! Va multumim!");
  						textArea_1.setVisible(true);
  						Transactions.Printreceip(a.getNumepers(), a.getPrenumepers(), numefilm, 1, total, textArea_1);
  						panel_3.setVisible(false);
  						panel_2.setVisible(true);
  					}
  					else {
  						txtVaRugamIntorduceti.setText("CVV-ul nu este corect");
  						System.out.println(cnp);
  					}
  				}
  				else {
  					String total = Transactions.HiredMovie(cnp, numefilm, 1, zile);
  					chckbxNewCheckBox.setVisible(true);
  					nr = textField_2.getText();
  					luna = textField_3.getText();
  					an = textField_4.getText();
  					cvv = textField_9.getText();
  					if(chckbxNewCheckBox.isSelected())
  					{
  						Client.addCard(cnp, nr, cvv, luna, an);
  					}
  					textArea_1.setVisible(true);
  					Transactions.Printreceip(a.getNumepers(), a.getPrenumepers(), numefilm, 1, total, textArea_1);
  					panel_3.setVisible(false);
					panel_2.setVisible(true);
  				}
			}
		});
		btnNewButton_8.setBackground(Color.DARK_GRAY);
		btnNewButton_8.setForeground(Color.CYAN);
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_8.setBounds(150, 240, 130, 30);
		panel_3.add(btnNewButton_8);
		
		
	}
}
