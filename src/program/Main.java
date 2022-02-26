package program;

import java.util.Scanner;
import java.sql.*;

public class Main {
	public static void main(String args[]) throws Exception {
		
		Scanner keyboard = new Scanner(System.in);
		
		RestartIfInactive restart = new RestartIfInactive(3000);
		new Thread(new Runnable() {
		    public void run() {
		        //restart.run();
		    }
		}).start();
		restart.active();
		
		boolean again=true; 
		while(again) {
			
			System.out.println("				Welcome!			");
			System.out.println("									");
			System.out.println("		1. Vezi filmele disponibile	");
			System.out.println("		2. Cauta un film			");
			System.out.println("		3. Inchiriaza un film		");
			System.out.println("		4. Returneaza un film		");
			System.out.println("		0. Iesire					");
			System.out.println("									");
			System.out.println("		Introduceti optiunea:		");
			
			again=false;
			int option = keyboard.nextInt();
			restart.active();
			
			switch(option) {
			  	case 1:
			  		System.out.println("	Vezi Filmele Disponibile	");
			  		ShowMovies.ShowAllMovies();
			  		again=true;
			  		break;
			  	case 2:
			  		boolean again1 = true;
			  		while (again1) {
			  			again1=false;
				  		System.out.println("			Cauta Film			");
				  		System.out.println("								");
				  		System.out.println("		1. Dupa Nume			");
				  		System.out.println("		2. Dupa Gen				");
				  		System.out.println("		3. Dupa Producator		");
				  		System.out.println("		0. Inapoi				");
				  		int searchoption = keyboard.nextInt();
				  		restart.active();
				  		switch(searchoption) {
				  			case 1:
				  				System.out.println("Dati numele filmului: "); 
				  				String nume = keyboard.next();
				  				restart.active();
				  				ShowMovies.ShowMoviesByName(nume);
				  				again1=true;
				  				break;
				  			case 2:
				  				boolean again2 = true;
						  		while (again2) {
						  			again2=false;
					  				System.out.println("		Cauta Film dupa gen		");
							  		System.out.println("								");
							  		System.out.println("		1. Actiune				");
							  		System.out.println("		2. Comedie				");
							  		System.out.println("		3. Drama				");
							  		System.out.println("		4. Fantasy				");
							  		System.out.println("		5. Horror				");
							  		System.out.println("		6. Romance				");
							  		System.out.println("		7. Thriller				");
							  		System.out.println("		8. Western				");
							  		System.out.println("		9. 				");
							  		System.out.println("		0. Inapoi				");
					  				
							  		int searchoption1 = keyboard.nextInt();
							  		restart.active();
							  		switch(searchoption1) {
							  			case 1:
							  				ShowMovies.ShowMoviesByGenre("Actiune");
							  				again2=true;
							  				break;
							  			case 2:
							  				ShowMovies.ShowMoviesByGenre("Comedie");
							  				again2=true;
							  				break;
							  			case 3:
							  				ShowMovies.ShowMoviesByGenre("Drama");
							  				again2=true;
							  				break;
							  			case 4:
							  				ShowMovies.ShowMoviesByGenre("Fantasy");
							  				again2=true;
							  				break;
							  			case 5:
							  				ShowMovies.ShowMoviesByGenre("Horror");
							  				again2=true;
							  				break;
							  			case 6:
							  				ShowMovies.ShowMoviesByGenre("Romance");
							  				again2=true;
							  				break;
							  			case 7:
							  				ShowMovies.ShowMoviesByGenre("Thriller");
							  				again2=true;
							  				break;
							  			case 8:
							  				ShowMovies.ShowMoviesByGenre("Western");
							  				again2=true;
							  				break;
							  			case 9:
							  				ShowMovies.ShowMoviesByGenre("Desene");
							  				again2=true;
							  				break;
							  			case 0:
							  				again1=true;
							  				break;
							  			default:
							  				System.out.println("Nu exista aceasta optiune.");
							  				again2=true;
							  				break;
							  		}
							  	}
						  		break;
				  			
				  			case 3:
				  				System.out.println("Dati numele producatorului: "); 
				  				String prod = keyboard.next();
				  				restart.active();
				  				ShowMovies.ShowMoviesByProducer(prod);
				  				again1=true;
				  				break;
				  			case 0:
				  				again=true;
				  				break;
				  			default:
				  				System.out.println("Nu exista aceasta optiune.");
				  				again1=true;
				  				break;
				  		}
			  		}
			  		
			  		break;
			  	case 3:
			  		//System.out.println("inchiriaza un film");
			  		boolean again2 = true;
			  		while (again2) {
			  			again2=false;
				  		System.out.println("			Inchiriaza un film			");
				  		System.out.println("										");
				  		System.out.println("		Dati numele filmului:			");
				  		String nume = keyboard.next();
				  		restart.active();
		  				if(ShowMovies.ShowMoviesByNameinc(nume)) {
		  					boolean again3 = true;
					  		while (again3) {
					  			again3 = false;
					  			System.out.println("			Sunteti client nou?			");
					  			System.out.println("										");
					  			System.out.println("				1.DA					");
					  			System.out.println("				2.NU					");
					  			int searchoption1 = keyboard.nextInt();
					  			restart.active();
						  		switch(searchoption1) {
						  		case 1:
						  			System.out.println("			Va rugam introduceti		");
						  			System.out.println("										");
						  			System.out.println("				Numele:					");
						  			String numepers = keyboard.next();
						  			restart.active();
						  			System.out.println("				Prenumele:				");
						  			String prenumepers = keyboard.next();
						  			restart.active();
						  			System.out.println("				CNP:   					");
						  			String CNPpers = keyboard.next();
						  			restart.active();
						  			System.out.println("				Nr.Telefon				");
						  			String telpers = keyboard.next();
						  			restart.active();
						  			if(Client.Checknrtel(telpers)) {
						  				Client.AddClienttoDB(numepers,prenumepers,CNPpers,telpers);
						  				boolean again4 = true;
						  				while (again4) {
						  					again4 = false;
						  					System.out.println("			Cum doriti sa platiti?			");
						  					System.out.println("											");
						  					System.out.println("				1.Cash la Ghiseu			");
						  					System.out.println("				2.Card						");
						  					int searchoption2 = keyboard.nextInt();
						  					restart.active();
									  		switch(searchoption2) {
									  			case 1:
									  				String total = Transactions.HiredMovie(CNPpers, nume, 0);
									  				Transactions.Printreceip(numepers, prenumepers, nume, 0, total);
									  				break;
									  			case 2:
									  				total = Transactions.HiredMovie(CNPpers, nume, 1);
									  				Client.addCard(CNPpers);
									  				Transactions.Printreceip(numepers, prenumepers, nume, 1, total);
									  				break;
									  			default:
									  				System.out.println("Nu exista aceasta optiune.");
											    	again4=true;
											    	break;
									  				
									  		}
							  			}
						  			}
						  			else {
						  				System.out.println("Nu s-a reusit confirmarea numarului de telefon");
						  				System.out.println("Verificati numarul de telefon si mai incercati o data.");
						  			}
						  			break;
						  		case 2:
						  			System.out.println("			Va rugam introduceti		");
						  			System.out.println("										");
						  			System.out.println("				CNP:					");
						  			CNPpers = keyboard.next();
						  			restart.active();
						  			Client a = new Client();
						  			if(a.FindbyCNP(CNPpers)) {
							  			boolean again5 = true;
						  				while (again5) {
						  					again5 = false;
						  					System.out.println("			Cum doriti sa platiti?			");
						  					System.out.println("											");
						  					System.out.println("				1.Cash la Ghiseu			");
						  					System.out.println("				2.Card						");
						  					int searchoption2 = keyboard.nextInt();
						  					restart.active();
									  		switch(searchoption2) {
									  			case 1:
									  				String total = Transactions.HiredMovie(CNPpers, nume, 0);
									  				Transactions.Printreceip(a.getNumepers(), a.getPrenumepers(), nume, 0, total);
									  				break;
									  			case 2:
									  				if(Client.checkCard(CNPpers)) {
									  					total =Transactions.HiredMovie(CNPpers, nume, 1);
									  					if(Transactions.CheckCVV(CNPpers))
									  						Transactions.Printreceip(a.getNumepers(), a.getPrenumepers(), nume, 1, total);
									  					else
									  						System.out.println("CVV-ul nu este corect");
									  				}
									  				else {
									  					total = Transactions.HiredMovie(CNPpers, nume, 1);
									  					Client.addCard(CNPpers);
									  					Transactions.Printreceip(a.getNumepers(), a.getPrenumepers(), nume, 1, total);
									  				}
									  				break;
									  			default:
									  				System.out.println("Nu exista aceasta optiune.");
											    	again5=true;
									  		}
						  				}
						  			}
						  			else
						  				again3=true;
						  			break;
						  		default:
						  			System.out.println("Nu exista aceasta optiune.");
							    	again3=true;
						  		}
					  		}
		  				}
		  				else {
		  					System.out.println("	Doriti sa inchiriati alt film?		");
		  					System.out.println("										");
		  					System.out.println("				1.DA					");
		  					System.out.println("				2.NU					");
		  					int optiune = keyboard.nextInt();
		  					restart.active();
		  					if(optiune==1)
		  						again2=true;
		  					else
		  						again=true;
		  				}
		  				
				    }
			  		break;
			  	case 4:
			  		System.out.println("Introduceti CNP-ul");
			  		String CNPpers = keyboard.next();
			  		restart.active();
			  		System.out.println("Introduceti numele filmului pe care doriti sa il returnati:");
			  		String name = keyboard.next();
			  		restart.active();
			  		if(Transactions.SearchinH(CNPpers, name)) {
			  			Transactions.ReturnInTime(CNPpers, name);
			  		}
			  		else
			  			if(Transactions.SearchinU(CNPpers, name)) {
			  				Transactions.ReturnLate(CNPpers, name);
			  			}
			  			else
			  				System.out.println("Acest film nu exista in lista de filme inchiriate");
			  		
			  		again=true;
				    break;
			  	case 1234567890:
			  		System.out.println("Congrats you are admin now");
			  		break;
			  	case 0:
				    break;
			  	default: 
			    	System.out.println("Nu exista aceasta optiune.");
			    	again=true;
			}
		
		
		}
		keyboard.close();
		getConnection();
		
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
		
} 