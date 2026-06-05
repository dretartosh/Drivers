/**
 * Kuze Chatbot Engine
 * @author Tye Tosh
 * Description:
 * 		Kuze is a simple chatbot engine used to generate personalized
 * 		questions, statements, and excitement responses for a 
 * 		job application tracking program
 * */

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CopenhagenTransit {
	
	
	 /* declaration of variables for the class to use */
	 
	public String userInputString;
	public int userInputNum;
	
	public double [][] busRate;
	public double [][]trainRate;
	public double [][] airplaneRate;
	public double [][] helicopterRate;
	public double [][] boatRate;
	
	private String currency;
	private final double TAX = 0.25;
	private final int zoneSize = 5;
	private final int zoneRange = 2;

	public  CopenhagenTransit()
	{
		/*
		 * Constructor creation
		 * initialization of declared variables 
		 */
		 
		
		userInputString = "";
		userInputNum = 0;
		currency = "USD";
		
		busRate = new double[zoneSize][zoneRange];
		trainRate = new double[zoneSize][zoneRange];
		airplaneRate = new double[zoneSize][zoneRange];
		helicopterRate = new double[zoneSize][zoneRange];
		boatRate = new double[zoneSize][zoneRange];
		
		populateRatesArr(); // loads Rates of Transportation
		
	}
	public static void main(String[] args)
	{
			
	}
	public void populateRatesArr()
	{
		busRate = 
			new double[][]{
				/* Adult - Child */
				{23.0, 11.5},
				{23.0, 11.5},
				{34.5, 23.0},
				{46.0, 23.0},
				{57.5, 28.5}
			};
		
		trainRate =
			new double [][]{
				
				{28.0, 14.0},
				{35.0, 17.5},
				{49.0, 24.5},
				{63.0, 31.5},
				{77.0, 38.5}	
			};
		
		
		airplaneRate =
				new double [][]{ 
				
				{350.0, 175.0},
				{420.0, 210.0},
				{560.0, 280.0},
				{700.0, 350.0},
				{840.0, 420.0}	
			};;
		

		helicopterRate =
				new double [][]{
				
				{850.0, 425.0},
				{1020.0, 510.0},
				{1360.0, 680.0},
				{1700.0, 850.0},
				{2040.0, 1020.0}	
			};
		
		
		boatRate = 
				new double [][]{
				
				{45.0, 22.5},
				{60.0, 30.0},
				{80.0, 40.0},
				{100.0, 50.0},
				{120.0, 60.0}	
			};
			
			/* future steps: get from db */
	}
	
	//getters
	public double getTransportationFare(String passenger, int zoneR, String transport)
	{
		/**
		 * 	This method will get 3 parameters to calculate the Fare that will be charged
		 *  It will be stored as a double. The fare is stored in a arrays (2D arr).
		 *  
		 *  
		 * @param passengertype as a string, zone Num as integer, transporttype as a string
		 * @return the selected rate from the correct transportation array
		 */
		
		int  c = 0;
		double  tFare = 0.0;
		
		if(passenger.equalsIgnoreCase("Adult"))	{c = 0;}
		else if(passenger.equalsIgnoreCase("Child")) {c = 1;}
		else {return 0.0;};
		
		switch(transport)
		{
		case "boat" -> {/* System.out.println("Boat Rate: " + boatRate[zoneR - 1][c]); */ tFare = boatRate[zoneR][c];}
		case "bus" -> {/* System.out.println("Bus Rate: " + busRate[zoneR - 1][c]); */tFare = busRate[zoneR][c];}
		case "train" -> {/* System.out.println("Train Rate: " + trainRate[zoneR - 1][c]); */ tFare = trainRate[zoneR][c];}
		case "airplane" -> {/* System.out.println("Plane Rate: " + airplaneRate[zoneR - 1][c]); */ tFare = airplaneRate[zoneR][c];}
		case "helicopter" -> {/* System.out.println("Helicopter Rate: " + helicopterRate[zoneR - 1][c]); */tFare = helicopterRate[zoneR][c];}
				default -> {return -1.0;}
		}
		
		
		
		return tFare;
	}
	
	public String getLocalDate() {
		
		/**
		 * Generates the local date and format to specific standards.
		 * 
		 * @return a String formatted date 
		 */
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
		
		return today.format(formatter);
	}
	
	public String getLocalTime()
	{
		/**
		 * Generates the local time and format to specific standards.
		 * 
		 * @return a String formatted time 
		 */
		
		LocalTime now = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	    return now.format(formatter);
	}
	
	public String getTransportType(Scanner scnr)
	{
		/**
		 * User input for the type of transportation  which is later used.
		 * input is validated, and loops until acceptable input
		 * 
		 * @param Scanner object for user input
		 * @return a trimmed string user input 
		 */
				do 
				{
					System.out.print("Enter transport type (Bus/Train/Boat/Airplane/Helicopter): ");
					userInputString = scnr.nextLine();	
				}while(!validateTransportType(userInputString.trim()));
				
		return userInputString.trim();
	}
	
	
	
	public int getZoneNumber(Scanner scnr)
	{
		/**
		 * User input for the Zone Number which is later used.
		 * consume newline which happens whenever nextInt() is used
		 * input is validated, and loops until acceptable input
		 * 
		 * @param Scanner object for user input
		 * @return a integer
		 */
			do
			{
				System.out.print("Enter zone number (1-5): ");
				userInputNum = scnr.nextInt();
				scnr.nextLine();// consume leftover newline
			}while(!validateZoneNumber(userInputNum));
			
			return userInputNum;
	}
	
	public String getPassengerType(Scanner scnr)
	{
		/**
		 * User input for the passenger class/type which is later used.
		 * input is validated, and loops until acceptable input
		 * 
		 * @param Scanner object for user input
		 * @return a trimmed string user input
		 */
		do
		{
			System.out.print("Enter passenger type (Adult/Child): ");
			userInputString = scnr.nextLine();
		}while(!validatePassengerType(userInputString.trim()));
		
		return userInputString.trim();
	}
	
	private boolean validateZoneNumber(int zNum)
	{
		/**
		 *  validation of input. check if Zone number is between Min: 1 to Max: 5.
		 *  output error message
		 *  
		 *  @param int zoneNumber
		 *  @return if validation is true or false
		 */
		
		if(zNum >= 1 && zNum <= 5) {return true;}
		else {System.out.println("Invalid input.");return false;}
		
	}
	private boolean validateTransportType(String tType)
	{
		/**
		 *  validation of input. check if transportation type is one of the acceptable option or null
		 *  output error message
		 *  
		 *  @param String transport
		 *  @return if validation is true or false
		 */
		
			if(tType == null) {System.out.println("Invalid input."); return false;}
			else if (tType.equalsIgnoreCase("Bus") || tType.equalsIgnoreCase("Train") || tType.equalsIgnoreCase("Airplane")|| tType.equalsIgnoreCase("Boat")|| tType.equalsIgnoreCase("Helicopter"))
			{
				return true;
			}
			else {System.out.println("Invalid input.");return false;}
	}
	private boolean validatePassengerType(String pType)
	{
		/**
		 *  validation of input. check if passenger type/class is one of the acceptable option or null
		 *  output error message
		 *  
		 *  @param String passenger
		 *  @return if validation is true or false
		 */
		if(pType == null) {return false;}
		
		if(pType.equalsIgnoreCase("Adult") || pType.equalsIgnoreCase("Child")) {return true;}
		else {System.out.println("Invalid input.");return false;}
	}
	
	
	
	
	
								
	
	public void printReceipt(String transport, int zone, String passenger, double transfare)
	{
		
		/**
		 * This generates and displays a receipt of the completed transaction. It is formatted
		 * using the System.out.printf. 
		 * While using local methods - localtime & localdate, variables and logics.
		 *  
		 * @param String, int, String, double -  Transport Type, Zone Type, Passenger Type, Fare
		 */
		
		
		System.out.println("╔══════════════════════════════════════════╗");
		System.out.println("║\tCOPENHAGEN TRANSIT AUTHORITY\t   ║");
		System.out.printf("║\tDate: %-12s  Time: %-5s    ║\n",getLocalDate(),getLocalTime());
		System.out.println("╠══════════════════════════════════════════╣");
		
		System.out.printf("║  Transport  :  %-25s ║\n",transport.toUpperCase()); /* set to upper case */
		System.out.printf("║  Zone       :  %-25d ║\n",zone);
		System.out.printf("║  Passenger  :  %-25s ║\n",passenger.toUpperCase()); /* set to upper case */
		
		System.out.println("╠══════════════════════════════════════════╣");
		
		System.out.printf("║  BASE FARE  :  %-4s %20.2f ║\n",currency.toUpperCase()/* set to upper case */,transfare);
		System.out.printf("║  TAX (%.0f%%)  :  %-4s %20.2f ║\n",TAX * 100,currency,(transfare * TAX));
		
		System.out.println("╠══════════════════════════════════════════╣");
		
		System.out.printf("║  TOTAL      :  %-4s %20.2f ║\n",currency.toUpperCase()/* set to upper case */,((transfare * TAX) + transfare));
		
		System.out.println("╚══════════════════════════════════════════╝");
		System.out.println("      Thank you for travelling with us!     ");
		    


	}

}
