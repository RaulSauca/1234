package program;

import java.sql.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class ShowMovies {
		
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
	
	public static void ShowAllMovies(Showm frame) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement =con.prepareStatement("SELECT Name,Genre,Length FROM movies WHERE nrCopies>nrCopiesHired ORDER BY Name");
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				frame.textArea.append(result.getString("Name") + ";	Gen: " + result.getString("Genre") + ";		Durata: " + result.getString("Length") + "m\n");
			}
		}catch(Exception e) {System.out.println(e);}
	}
	
	public static void ShowMoviesByName(String nume, JTextArea textArea) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT Name,Genre,Length,nrCopies,nrCopiesHired FROM movies WHERE LOCATE('" + nume + "' ,Name)>0 ORDER BY Name");
			
			ResultSet result = statement.executeQuery();
			if (result.next() == false)
				textArea.append("Nu exista filme care contin '"+nume+"' in nume.");
			else
				{if(result.getInt("nrCopies")>result.getInt("nrCopiesHired"))
					textArea.append(result.getString("Name") + ";	Gen: " + result.getString("Genre") + ";		Durata: " + result.getString("Length") + "m;		Availabe: YES\n");
				else
					textArea.append(result.getString("Name") + ";	Gen: " + result.getString("Genre") + ";		Durata: " + result.getString("Length") + "m;		Availabe: NO\n");

				while(result.next()) {
					if(result.getInt("nrCopies")>result.getInt("nrCopiesHired"))
						textArea.append(result.getString("Name") + ";	Gen: " + result.getString("Genre") + ";		Durata: " + result.getString("Length") + "m;		Availabe: YES\n");
					else
						textArea.append(result.getString("Name") + ";	Gen: " + result.getString("Genre") + ";		Durata: " + result.getString("Length") + "m;		Availabe: NO\n");
				}
			}
		}catch(Exception e) {System.out.println(e);}
		
	}
	
	public static void ShowMoviesByGenre(String gen, JTextArea textArea) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT Name,Length,nrCopies,nrCopiesHired FROM movies WHERE Genre='"+ gen +"' ORDER BY Name");
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				if(result.getInt("nrCopies")-result.getInt("nrCopiesHired")>0)
					textArea.append(result.getString("Name") + ";		Durata: " + result.getString("Length") + "m;		Availabe: YES\n");
				else
					textArea.append(result.getString("Name") + ";		Durata: " + result.getString("Length") + "m;		Availabe: NO\n");
			}
		}catch(Exception e) {System.out.println(e);}
		
	}
	
	public static void ShowMoviesByProducer(String prod, JTextArea textArea) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement =con.prepareStatement("SELECT Name,Genre,Length,nrCopies,nrCopiesHired,Producer FROM movies WHERE LOCATE('" + prod +"' ,Producer)>0 ORDER BY Name");
			
			ResultSet result = statement.executeQuery();
			if (result.next() == false)
				textArea.append("Nu exista nici un producator cu numele '"+prod+"'.");
			else {
				textArea.append("Filmele producatorului " + result.getString("Producer") + " sunt: \n");
				if(result.getInt("nrCopies")>result.getInt("nrCopiesHired"))
					textArea.append(result.getString("Name") + ";		Gen: " + result.getString("Genre") + ";			Durata: " + result.getString("Length") + "m;		Availabe: YES\n");
				else
					textArea.append(result.getString("Name") + ";		Gen: " + result.getString("Genre") + ";			Durata: " + result.getString("Length") + "m;		Availabe: NO\n");
				while(result.next()) {
					if(result.getInt("nrCopies")>result.getInt("nrCopiesHired"))
						textArea.append(result.getString("Name") + ";		Gen: " + result.getString("Genre") + ";			Durata: " + result.getString("Length") + "m;		Availabe: YES\n");
					else
						textArea.append(result.getString("Name") + ";		Gen: " + result.getString("Genre") + ";			Durata: " + result.getString("Length") + "m;		Availabe: NO\n");
				}
			}
		}catch(Exception e) {System.out.println(e);}
		
	}
	
	public static boolean ShowMoviesByNameinc(String nume, JTextArea textArea, JButton jb1, JButton jb2) throws Exception{
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT Name,Genre,Length,nrCopies,nrCopiesHired FROM movies WHERE LOCATE('" + nume + "' ,Name)>0 ORDER BY Name");
			
			ResultSet result = statement.executeQuery();
			if (result.next() == false)
				textArea.append("Nu detinem acest film.");
			else
				{if(result.getInt("nrCopies")>result.getInt("nrCopiesHired")) {
					textArea.append("Filmul " + result.getString("Name") + " este disponibil.\n");
			  		textArea.append("\nAcesta este filmul pe care doriti sa il inchiriati?\n");
			  		jb1.setVisible(true);
			  		jb2.setVisible(true);
			  		return true;
			  		}	
				else {
					textArea.append("Filmul " + result.getString("Name") + " nu este disponibil.");
					return false;
					}
			}
		}catch(Exception e) {System.out.println(e);}
		return false;
		
	}
}
