package program;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JTextArea;

public class Transactions {
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

	public static void Printreceip(String numepers, String prenumepers, String nume, int i, String total, JTextArea textArea) {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT Name FROM movies WHERE LOCATE('" + nume + "' ,Name)>0 ORDER BY Name");
			
			ResultSet result = statement.executeQuery();
			result.next();
		
			String plata = "Card";
			if(i==0)
				plata="Cash";
			int nrbon = 1000000 + new Random().nextInt(9000000);
			textArea.append("_________________________\n");
			textArea.append("|	MR System		\n");
			textArea.append("|						\n");
			textArea.append("|Client:"+numepers+" \n");
			textArea.append("|   "+prenumepers+"	\n");
			textArea.append("|						\n");
			textArea.append("|Film:				\n");
			textArea.append("|"+result.getString("Name")+"\n");
			textArea.append("|						\n");
			textArea.append("|   Tip Plata: "+plata+"\n");
			textArea.append("|   Total: "+total+"$	\n");
			textArea.append("|						\n");
			textArea.append("|	"+nrbon+"			\n");
			textArea.append("________________________");
		
		}catch(Exception e) {System.out.println(e);}
		
	}

	public static String HiredMovie(String CNPpers, String nume, int pm, int zile) {
		
		int pret = 5*zile;
		String total =  String.valueOf(pret);
		String PaymentMethod = "Card";
		if(pm==0) {
			PaymentMethod = "Cash";
		}
		
		int idmovies;
		try {
			Connection conn = getConnection();
			PreparedStatement idfilm = conn.prepareStatement("SELECT idMovies FROM movies WHERE LOCATE('" + nume + "' ,Name)>0");
			ResultSet result = idfilm.executeQuery();
			result.next();
			idmovies = result.getInt("idMovies");

			PreparedStatement update = conn.prepareStatement("UPDATE movies SET nrCopiesHired = nrCopiesHired+1 WHERE idMovies ="+ idmovies +" AND nrCopiesHired<nrCopies");
			update.executeUpdate();
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("");  
			LocalDateTime date = LocalDateTime.now();
			PreparedStatement insert = conn.prepareStatement("INSERT INTO hmovies (idmovies, CNPClient, HDate, HPeriod, PaymentMethod) VALUES ("+idmovies+",'"+CNPpers+"','"+date+"',"+zile+",'"+PaymentMethod+"')");
			insert.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		
		return total;
	}

	public static boolean SearchinH(String CNPpers, String name) {
		try {
			Connection conn = getConnection();
			PreparedStatement cnpsearch = conn.prepareStatement("SELECT * FROM hmovies T join movies TT on T.idmovies = TT.idMovies WHERE T.CNPClient = ? AND LOCATE(? , TT.Name)>0");
			//PreparedStatement cnpsearch = conn.prepareStatement("SELECT * FROM hmovies");
			cnpsearch.setString(1, CNPpers);
			cnpsearch.setString(2, name);
			ResultSet result = cnpsearch.executeQuery();
			if(result.next())
				return true;
//			while(result.next()) {
//				PreparedStatement moviesearch = conn.prepareStatement("SELECT idMovies FROM movies WHERE idMovies='" + result.getString("idMovies") + "' AND LOCATE('" + name + "' ,Name)>0");
//				ResultSet result1 = moviesearch.executeQuery();
//					if(result1.next())
//						return true;
	//		}
		}catch(Exception e) {/*System.out.println(e);*/ e.printStackTrace();}
		return false;
	}

	public static boolean SearchinU(String CNPpers, String name) {
		try {
			Connection conn = getConnection();
			PreparedStatement cnpsearch = conn.prepareStatement("SELECT idmovies FROM umovies WHERE CNPClient='" + CNPpers + "'");
			ResultSet result = cnpsearch.executeQuery();
			
			while(result.next()) {
				PreparedStatement moviesearch = conn.prepareStatement("SELECT idMovies FROM movies WHERE idMovies='" + result.getString("idMovies") + "' AND LOCATE('" + name + "' ,Name)>0");
				ResultSet result1 = moviesearch.executeQuery();
					if(result1.next())
						return true;
			}
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
	
	public static void ReturnInTime(String CNPpers, String name, JTextArea TextArea) {
		TextArea.setText(null);
		TextArea.append("Nu aveti zile intarziere\n");
		TextArea.append("Va multumim!");
		int id=0;
		try {
			Connection conn = getConnection();
			PreparedStatement cnpsearch = conn.prepareStatement("SELECT idmovies FROM hmovies WHERE CNPClient='" + CNPpers + "'");
			ResultSet result = cnpsearch.executeQuery();
			while(result.next()) {
				PreparedStatement moviesearch = conn.prepareStatement("SELECT idMovies FROM movies WHERE idMovies='" + result.getString("idMovies") + "' AND LOCATE('" + name + "' ,Name)>0");
				ResultSet result1 = moviesearch.executeQuery();
				if(result1.next())
					id = result1.getInt("idMovies");
			}
			
			PreparedStatement forhistoryinfo = conn.prepareStatement("SELECT * FROM hmovies WHERE CNPClient='" + CNPpers + "' AND idmovies = " + id);
			result = forhistoryinfo.executeQuery();
			result.next();
			int idmovies=result.getInt("idmovies");
			String hdate=result.getString("HDate");
			long dayslost=0;
			String paymentmethod=result.getString("PaymentMethod");
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("");  
			LocalDateTime rdate = LocalDateTime.now();
			
			PreparedStatement history = conn.prepareStatement("INSERT INTO history (idmovies,CNPClient,Hdate,Rdate,DaysLost,PaymentMethod) VALUES ("+ idmovies + ", '" + CNPpers + "', '"+ hdate + "', '" + rdate +"',"+ dayslost +",'"+ paymentmethod +"')");
			history.executeUpdate();
			
			PreparedStatement delete = conn.prepareStatement("DELETE FROM hmovies WHERE CNPClient='" + CNPpers + "' AND idmovies = " + id);
			delete.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
	}
	
	public static void ReturnLate(String CNPpers, String name, JTextArea TextArea) {
		int id=0;
		TextArea.setText(null);
		try {
			Connection conn = getConnection();
			PreparedStatement cnpsearch = conn.prepareStatement("SELECT idmovies FROM umovies WHERE CNPClient='" + CNPpers + "'");
			ResultSet result = cnpsearch.executeQuery();
			while(result.next()) {
				PreparedStatement moviesearch = conn.prepareStatement("SELECT idMovies FROM movies WHERE idMovies='" + result.getString("idMovies") + "' AND LOCATE('" + name + "' ,Name)>0");
				ResultSet result1 = moviesearch.executeQuery();
				if(result1.next())
					id = result1.getInt("idMovies");
			}
			
			PreparedStatement forhistoryinfo = conn.prepareStatement("SELECT * FROM umovies WHERE CNPClient='" + CNPpers + "' AND idmovies = " + id);
			result = forhistoryinfo.executeQuery();
			result.next();
			int idmovies=result.getInt("idmovies");
			String hdate=result.getString("HDate");
			long dayslost=0;
			String paymentmethod=result.getString("PaymentMethod");
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
			LocalDateTime rdate = LocalDateTime.now();
			
			String formattedDateTime = rdate.format(dtf);
			LocalDate dateBefore = LocalDate.parse(hdate);
			LocalDate dateAfter = LocalDate.parse(formattedDateTime);
			dayslost = ChronoUnit.DAYS.between(dateBefore, dateAfter);
			
			
			
			
			
			
			PreparedStatement history = conn.prepareStatement("INSERT INTO history (idmovies,CNPClient,Hdate,Rdate,DaysLost,PaymentMethod) VALUES ("+ idmovies + ", '" + CNPpers + "', '"+ hdate + "', '" + rdate +"',"+ dayslost +",'"+ paymentmethod +"')");
			history.executeUpdate();
			
			PreparedStatement delete = conn.prepareStatement("DELETE FROM umovies WHERE CNPClient='" + CNPpers + "' AND idmovies = " + id);
			delete.executeUpdate();
			
			TextArea.append("Ati intarziat " + dayslost + " zile\n");
			TextArea.append("Tariful este de 8$/zi intarziata\n\n");
			
			long total = 8*dayslost;
			if(paymentmethod=="Cash" || !Client.checkCard(CNPpers))
				TextArea.append("Aveti de platit " + total + "$ la ghiseu\n");
			else
				TextArea.append( total+ "$ au fost extrasi de pe card pentru a plati intarzierea\n");
			TextArea.append("Va multumim!");
		}catch(Exception e) {System.out.println(e);}
	}

	public static boolean CheckCVV(String CNPpers, String CVV) {

		try {
			Connection conn = getConnection();
			PreparedStatement cvv = conn.prepareStatement("SELECT CVV FROM creditcards WHERE CNPOwner=?");
			cvv.setString(1, CNPpers);
			ResultSet result = cvv.executeQuery();
			
			result.next();
			String a = result.getString("CVV");
			System.out.println(a);
			if(CVV.equals(result.getString("CVV")))
				return true;
		}catch(Exception e) {System.out.println(e);}
		return false;
	}
}
