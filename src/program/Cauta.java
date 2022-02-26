package program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Component;

public class Cauta extends JFrame {

	public JFrame frame;
	private JPanel contentPane;
	private JTextField txtCautaFilm;
	private JTextField txtIntroducetiNumele;
	private JTextField txtCautaDupaNume;
	private JTextField textField;
	public JTextArea textArea, textArea2, textArea3;
	private JTextField txtCautaDupaGen;
	private JTextField txtIntroducetiNumeleProducatorului;
	private JTextField txtCautaDupaProducator;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cauta frame = new Cauta();
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
	public Cauta() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(178, 34, 34));
		frame.setBounds(100, 100, 569, 462);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		setBackground(new Color(178, 34, 34));
		setBounds(100, 100, 384, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		panel.setBounds(30, 0, 300, 378);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		panel_1.setBounds(30, 0, 300, 378);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(178, 34, 34));
		panel_2.setBounds(30, 0, 300, 378);
		contentPane.add(panel_2);
		panel_2.setVisible(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(178, 34, 34));
		panel_3.setBounds(30, 0, 300, 378);
		contentPane.add(panel_3);
		panel_3.setVisible(false);
		
		JButton btnNewButton = new JButton("Dupa Nume");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(0, 86, 300, 60);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dupa Gen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(true);
				panel.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.CYAN);
		btnNewButton_1.setBounds(0, 157, 300, 60);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Dupa Producator");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setForeground(Color.CYAN);
		btnNewButton_2.setBounds(0, 228, 300, 60);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Inapoi");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.CYAN);
		btnNewButton_3.setBounds(55, 299, 200, 40);
		panel.add(btnNewButton_3);
		
		txtCautaFilm = new JTextField();
		txtCautaFilm.setText("Cauta Film");
		txtCautaFilm.setHorizontalAlignment(SwingConstants.CENTER);
		txtCautaFilm.setForeground(Color.BLACK);
		txtCautaFilm.setFont(new Font("Times New Roman", Font.BOLD, 30));
		txtCautaFilm.setEditable(false);
		txtCautaFilm.setColumns(1);
		txtCautaFilm.setBackground(new Color(178, 34, 34));
		txtCautaFilm.setBounds(0, 11, 300, 51);
		panel.add(txtCautaFilm);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textArea.setForeground(Color.CYAN);
		textArea.setBackground(new Color(178, 34, 34));
		textArea.setBounds(10, 186, 280, 153);
		//panel_1.add(textArea);
		
		JScrollPane scroll = new JScrollPane ( textArea );
		scroll.setBounds(10, 186, 280, 153);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_1.add ( scroll );
		
				
				txtIntroducetiNumele = new JTextField();
				txtIntroducetiNumele.setForeground(Color.CYAN);
				txtIntroducetiNumele.setFont(new Font("Tahoma", Font.BOLD, 15));
				txtIntroducetiNumele.setBackground(new Color(178, 34, 34));
				txtIntroducetiNumele.setHorizontalAlignment(SwingConstants.CENTER);
				txtIntroducetiNumele.setText("Introduceti numele");
				txtIntroducetiNumele.setBounds(56, 73, 200, 30);
				panel_1.add(txtIntroducetiNumele);
				txtIntroducetiNumele.setColumns(10);
				
				txtCautaDupaNume = new JTextField();
				txtCautaDupaNume.setText("Cauta dupa Nume");
				txtCautaDupaNume.setHorizontalAlignment(SwingConstants.CENTER);
				txtCautaDupaNume.setForeground(Color.BLACK);
				txtCautaDupaNume.setFont(new Font("Times New Roman", Font.BOLD, 30));
				txtCautaDupaNume.setEditable(false);
				txtCautaDupaNume.setColumns(1);
				txtCautaDupaNume.setBackground(new Color(178, 34, 34));
				txtCautaDupaNume.setBounds(0, 11, 300, 51);
				panel_1.add(txtCautaDupaNume);
				
				textField = new JTextField();
				textField.setForeground(Color.CYAN);
				textField.setBackground(Color.LIGHT_GRAY);
				textField.setBounds(10, 114, 280, 30);
				panel_1.add(textField);
				textField.setColumns(10);
				
				JButton btnNewButton_4 = new JButton("Cauta");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String numeintrodus = textField.getText();
						try {
							textArea.setText(null);
							ShowMovies.ShowMoviesByName(numeintrodus, textArea);
							
						} catch (Exception e1) {e1.printStackTrace();}
					}
				});
				btnNewButton_4.setBackground(Color.DARK_GRAY);
				btnNewButton_4.setForeground(Color.CYAN);
				btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnNewButton_4.setBounds(108, 155, 89, 23);
				panel_1.add(btnNewButton_4);
				
				JButton btnNewButton_5 = new JButton("Inapoi");
				btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnNewButton_5.setBackground(Color.DARK_GRAY);
				btnNewButton_5.setForeground(Color.CYAN);
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textArea.setText(null);
						panel_1.setVisible(false);
						panel.setVisible(true);
						
					}
				});
				btnNewButton_5.setBounds(108, 344, 89, 23);
				panel_1.add(btnNewButton_5);
				
				JButton btnNewButton_3_1 = new JButton("Inapoi");
				btnNewButton_3_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textArea2.setText(null);
						panel_2.setVisible(false);
						panel.setVisible(true);
					}
				});
				btnNewButton_3_1.setForeground(Color.CYAN);
				btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_3_1.setBackground(Color.DARK_GRAY);
				btnNewButton_3_1.setBounds(50, 218, 200, 40);
				panel_2.add(btnNewButton_3_1);
				
				txtCautaDupaGen = new JTextField();
				txtCautaDupaGen.setText("Cauta dupa Gen");
				txtCautaDupaGen.setHorizontalAlignment(SwingConstants.CENTER);
				txtCautaDupaGen.setForeground(Color.BLACK);
				txtCautaDupaGen.setFont(new Font("Times New Roman", Font.BOLD, 30));
				txtCautaDupaGen.setEditable(false);
				txtCautaDupaGen.setColumns(1);
				txtCautaDupaGen.setBackground(new Color(178, 34, 34));
				txtCautaDupaGen.setBounds(0, 11, 300, 51);
				panel_2.add(txtCautaDupaGen);
				
				JButton btnNewButton_6 = new JButton("Actiune");
				btnNewButton_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							textArea2.setText(null);
							ShowMovies.ShowMoviesByGenre("Actiune", textArea2);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_6.setBackground(Color.DARK_GRAY);
				btnNewButton_6.setForeground(Color.CYAN);
				btnNewButton_6.setBounds(10, 73, 115, 33);
				panel_2.add(btnNewButton_6);
				
				JButton btnNewButton_7 = new JButton("Comedie");
				btnNewButton_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							textArea2.setText(null);
							ShowMovies.ShowMoviesByGenre("Comedie", textArea2);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_7.setForeground(Color.CYAN);
				btnNewButton_7.setBackground(Color.DARK_GRAY);
				btnNewButton_7.setBounds(10, 107, 115, 33);
				panel_2.add(btnNewButton_7);
				
				JButton btnNewButton_8 = new JButton("Drama");
				btnNewButton_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							textArea2.setText(null);
							ShowMovies.ShowMoviesByGenre("Drama", textArea2);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_8.setForeground(Color.CYAN);
				btnNewButton_8.setBackground(Color.DARK_GRAY);
				btnNewButton_8.setBounds(10, 141, 115, 33);
				panel_2.add(btnNewButton_8);
				
				JButton btnNewButton_9 = new JButton("Fantasy");
				btnNewButton_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							textArea2.setText(null);
							ShowMovies.ShowMoviesByGenre("Fantasy", textArea2);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_9.setBackground(Color.DARK_GRAY);
				btnNewButton_9.setForeground(Color.CYAN);
				btnNewButton_9.setBounds(10, 175, 115, 33);
				panel_2.add(btnNewButton_9);
				
				JButton btnNewButton_10 = new JButton("Horror");
				btnNewButton_10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							textArea2.setText(null);
							ShowMovies.ShowMoviesByGenre("Horror", textArea2);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_10.setForeground(Color.CYAN);
				btnNewButton_10.setBackground(Color.DARK_GRAY);
				btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_10.setBounds(175, 73, 115, 33);
				panel_2.add(btnNewButton_10);
				
				JButton btnNewButton_11 = new JButton("Thriller");
				btnNewButton_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							textArea2.setText(null);
							ShowMovies.ShowMoviesByGenre("Thriller", textArea2);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_11.setBackground(Color.DARK_GRAY);
				btnNewButton_11.setForeground(Color.CYAN);
				btnNewButton_11.setBounds(175, 107, 115, 33);
				panel_2.add(btnNewButton_11);
				
				JButton btnNewButton_12 = new JButton("Western");
				btnNewButton_12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							textArea2.setText(null);
							ShowMovies.ShowMoviesByGenre("Western", textArea2);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_12.setBackground(Color.DARK_GRAY);
				btnNewButton_12.setForeground(Color.CYAN);
				btnNewButton_12.setBounds(175, 141, 115, 33);
				panel_2.add(btnNewButton_12);
				
				JButton btnNewButton_13 = new JButton("Romance");
				btnNewButton_13.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							textArea2.setText(null);
							ShowMovies.ShowMoviesByGenre("Romance", textArea2);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_13.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_13.setBackground(Color.DARK_GRAY);
				btnNewButton_13.setForeground(Color.CYAN);
				btnNewButton_13.setBounds(175, 175, 115, 33);
				panel_2.add(btnNewButton_13);
				
				textArea2 = new JTextArea();
				textArea2.setEditable(false);
				textArea2.setFont(new Font("Monospaced", Font.PLAIN, 15));
				textArea2.setForeground(Color.CYAN);
				textArea2.setBackground(new Color(178, 34, 34));
				textArea2.setBounds(10, 186, 280, 153);
				
				JScrollPane scroll2 = new JScrollPane ( textArea2 );
				scroll2.setBounds(10, 258, 280, 120);
				scroll2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				panel_2.add ( scroll2 );
				panel_3.setLayout(null);
				
				textArea3 = new JTextArea();
				textArea3.setEditable(false);
				textArea3.setFont(new Font("Monospaced", Font.PLAIN, 15));
				textArea3.setForeground(Color.CYAN);
				textArea3.setBackground(new Color(178, 34, 34));
				textArea3.setBounds(10, 186, 280, 153);
				
				JScrollPane scroll3 = new JScrollPane ( textArea3 );
				scroll3.setBounds(10, 186, 280, 153);
				scroll3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				panel_3.add ( scroll3 );
				
				txtIntroducetiNumeleProducatorului = new JTextField();
				txtIntroducetiNumeleProducatorului.setText("Introduceti numele producatorului");
				txtIntroducetiNumeleProducatorului.setHorizontalAlignment(SwingConstants.CENTER);
				txtIntroducetiNumeleProducatorului.setForeground(Color.CYAN);
				txtIntroducetiNumeleProducatorului.setFont(new Font("Tahoma", Font.BOLD, 15));
				txtIntroducetiNumeleProducatorului.setColumns(10);
				txtIntroducetiNumeleProducatorului.setBackground(new Color(178, 34, 34));
				txtIntroducetiNumeleProducatorului.setBounds(10, 73, 280, 30);
				panel_3.add(txtIntroducetiNumeleProducatorului);
				
				txtCautaDupaProducator = new JTextField();
				txtCautaDupaProducator.setText("Cauta dupa Producator");
				txtCautaDupaProducator.setHorizontalAlignment(SwingConstants.CENTER);
				txtCautaDupaProducator.setForeground(Color.BLACK);
				txtCautaDupaProducator.setFont(new Font("Times New Roman", Font.BOLD, 30));
				txtCautaDupaProducator.setEditable(false);
				txtCautaDupaProducator.setColumns(1);
				txtCautaDupaProducator.setBackground(new Color(178, 34, 34));
				txtCautaDupaProducator.setBounds(0, 11, 300, 51);
				panel_3.add(txtCautaDupaProducator);
				
				textField_3 = new JTextField();
				textField_3.setForeground(Color.CYAN);
				textField_3.setColumns(10);
				textField_3.setBackground(Color.LIGHT_GRAY);
				textField_3.setBounds(10, 114, 280, 30);
				panel_3.add(textField_3);
				
				JButton btnNewButton_4_1 = new JButton("Cauta");
				btnNewButton_4_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String numeintrodus = textField_3.getText();
						try {
							textArea3.setText(null);
							ShowMovies.ShowMoviesByProducer(numeintrodus, textArea3);
							
						} catch (Exception e1) {e1.printStackTrace();}
					}
				});
				btnNewButton_4_1.setForeground(Color.CYAN);
				btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnNewButton_4_1.setBackground(Color.DARK_GRAY);
				btnNewButton_4_1.setBounds(108, 155, 89, 23);
				panel_3.add(btnNewButton_4_1);
				
				JButton btnNewButton_5_1 = new JButton("Inapoi");
				btnNewButton_5_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_3.setVisible(false);
						panel.setVisible(true);
					}
				});
				btnNewButton_5_1.setForeground(Color.CYAN);
				btnNewButton_5_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnNewButton_5_1.setBackground(Color.DARK_GRAY);
				btnNewButton_5_1.setBounds(108, 344, 89, 23);
				panel_3.add(btnNewButton_5_1);
	}
}
