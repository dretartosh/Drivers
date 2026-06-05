/**
 * Class method Engine
 * @author: Tye Tosh
 * Description:
 * 		To help in the development of Kuze the Module series
 * 		will show where I started from and where I am going
 * 		this will be used to called different drivers in the
 * 		future.
 * 	
 * 		Version 1.0.1
 * 
 *  
 * */

import java.util.Scanner;

public class KuzeDriver {

	public static void main(String[] args) 
	{
		
		CopenhagenTransit processTransaction = new CopenhagenTransit();
		Scanner scnr = new Scanner(System.in);
		
		/**
		 * 		- playground step by step testing - 
		 * 
		 * step 1: processTransaction.populateArr();
		 * step 2: processTransaction.getPassengerType(scnr);
		 * step 3: processTransaction.getZoneNumber(scnr);
		 * step 4: processTransaction.getTransportType(scnr);
		 * step 5: processTransaction.getTransportationFare(passType, zNum, transType)
		 * 
		 * 			String transport = "airplane";
		 * 			int zone = 3;
		 * 			String passenger = "adult";
		 * 			double fare = 1036.25; 
		 * 
		 * step 6: processTransaction.printReceipt(transport, zone, passenger, fare);
		 */

		
		
				String passType = processTransaction.getPassengerType(scnr);
				int zNum = processTransaction.getZoneNumber(scnr);
				String transType = processTransaction.getTransportType(scnr);
						transType = transType.toLowerCaser();
				double transFare = processTransaction.getTransportationFare(passType, zNum, transType);
						
		
			processTransaction.printReceipt(transType, zNum, passType, transFare);
		
		scnr.close();
	}

}
