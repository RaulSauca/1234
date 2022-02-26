package program;

import java.sql.*;
import java.util.Scanner;

public class Client {
	private String numepers;
	private String prenumepers;
	
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
	
	public static boolean Checknrtel(String nrtel) {
		Integer checkPIN = (int)(Math.random()*9000)+1000;
														
		SMS a = new SMS(0);
		a.sendMessage(nrtel, checkPIN.toString());
		
		boolean againcl=true; 
		while(againcl) {
			againcl=false;
			System.out.println("Va rugam asteptati. Daca nu primiti un cod prin sms in aprox 1 min apasati 2");
			System.out.println("																			 ");
			System.out.println("	1.Introduceti pinul primit prin SMS			");
			System.out.println("	2.Trimiteti alt SMS							");
			System.out.println("	3.Anulati									");
			Scanner keyboard = new Scanner(System.in);
			int option = keyboard.nextInt();
			switch(option) {
			case 1:
				int PIN = keyboard.nextInt();
				if(PIN == checkPIN) {
					return true;
				}else
					System.out.println("Pinul nu corespunde cu cel trimis");
				againcl=true;
			case 2:
				checkPIN = (int)(Math.random()*9000)+1000;																																																
				a.sendMessage(nrtel, checkPIN.toString());
				againcl=true;
				break;
			case 3:
				return false;
			default:
				System.out.println("Nu exista aceasta optiune.");
		    	againcl=true;
			}
			keyboard.close();
		}
		
		return false;
	}

	public static void addCard(String CNPpers, String cardNr, String CVV , String lunaEx, String anEx) {
		 String an = null, luna = null, tip = null;
		
		boolean ok = true;
		while(ok) {
			ok=false;

			int check = Integer.parseInt(cardNr.substring(0,2));
			cardNr.replaceAll("\\s+","");
			if(cardNr.length()>16 || cardNr.length()<16) {
				ok=true;
			}
			else if(check == 54 || check == 22) {
				tip="MasterCard";
			}
			else if(check == 42 || check == 40) {
				tip="Visa";
			}
			else {
				ok=true;
			}
		}
		ok=true;
		while(ok) {
			ok=false;
			if(anEx.length()>4 || anEx.length()<2 || anEx.length() == 3) {
				ok = true;
			}
			else {
				if(anEx.length() == 4 )
					an = anEx.substring(2,4);
				else if(anEx.length() == 2)
					an = anEx;
			}
		}
		ok=true;
		while(ok) {
			ok=false;
			int check = Integer.parseInt(lunaEx);
			if(lunaEx.length()>2 || lunaEx.length()<1 || !(check>0 && check<13)) {
				ok = true;
			}
			else {
				if(lunaEx.length() == 1)
					luna = "0"+lunaEx;
				else if(lunaEx.length() == 2)
					luna = lunaEx;
			}
		}
		String expDate;
		expDate = luna + "/" + an;
		ok=true;
		while(ok) {
			ok=false;
			if(CVV.length()>3 || CVV.length()<3) {
				ok = true;
			}
			else if(CVV.matches("[0-9]+")==false) {
					ok = true;
			}
		}

				try {
					Connection conn = getConnection();
					PreparedStatement insert = conn.prepareStatement("INSERT INTO creditcards (CNPOwner, Tip, Number, eDate, CVV) VALUES ('"+ CNPpers + "', '" + tip + "', '"+ cardNr + "', '" + expDate +"', '" + CVV + "')");
					insert.executeUpdate();
				}catch(Exception e) {System.out.println(e);}
	}

	public static void AddClienttoDB(String numepers, String prenumepers, String CNPpers, String telpers) throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement insert = conn.prepareStatement("INSERT INTO clienti (Nume, Prenume, CNP, NumarTel) VALUES ('"+ numepers + "', '" + prenumepers + "', '"+ CNPpers + "', '" + telpers +"')");
			insert.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		
	}

	public boolean FindbyCNP(String CNPpers) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT Nume,Prenume FROM clienti WHERE CNP='" + CNPpers + "'");
			
			ResultSet result = statement.executeQuery();
			if (result.next() == false) {
				return false;
			}
			else {
				this.numepers=result.getString("Nume");
				this.prenumepers=result.getString("Prenume");
				return true;
			}
		}catch(Exception e) {System.out.println(e);}
		return false;
		
	}

	public static boolean checkCard(String CNPpers) {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT id FROM creditcards WHERE CNPOwner='" + CNPpers + "'");
			
			ResultSet result = statement.executeQuery();
			if (result.next() == false) {
				System.out.println("Nu aveti nici un card salvat");
				return false;
			}
		}catch(Exception e) {System.out.println(e);}
		return true;
	}

	public String getNumepers() {
		return this.numepers;
	}

	public String getPrenumepers() {
		return this.prenumepers;
	}
}
