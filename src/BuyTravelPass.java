import java.util.InputMismatchException;
import java.util.Scanner;

public class BuyTravelPass {

	public void travelPassMenu(CreditInfo creditOptions) {
		Scanner scan = new Scanner(System.in);
		try {
			int timePeriodChoice; // Time Period Menu choice

			System.out.println("***** Choose Time Period *****");
			System.out.println("2 Hours      1");
			System.out.println("All Day      2");
			System.out.println("Cancel       3");
			System.out.println();

			System.out.print("Enter your choice: ");
			timePeriodChoice = scan.nextInt();
			System.out.println();

			char zoneChoice; // Zone Menu choice

			System.out.println("***** Choose Zone *****");
			System.out.println("Zone 1          a");
			System.out.println("Zone 1 and 2    b");
			System.out.println("Cancel          c");
			System.out.println();

			System.out.print("Enter your choice: " + '\n');
			zoneChoice = scan.next().charAt(0);
			
			PassTypes chargeType; //Reference variable to get the type of pass
			double passPrice = 0.0; 
			
			switch (timePeriodChoice) {
			case 1: { //2 hour Pass for both type of zones.
				chargeType = new TwoHourPass(creditOptions);
				
				if (zoneChoice == 'a') { //Zone 1 Pass
					passPrice = chargeType.getZone1Price();
					chargeType.deductAmount(passPrice, "Zone 1", "2 Hour pass");

				} else if (zoneChoice == 'b') { //Zone 1 and 2 Pass
					passPrice = chargeType.getZone1and2Price();
					chargeType.deductAmount(passPrice, "Zones 1 and 2", "2 Hour pass");

				} else {
					System.out.println("Transaction cancelled. Travel pass was not purchased." + '\n');
				}
				break;
			}
			case 2: { //All day pass for both types of zones.
				 chargeType = new TwentyFourHourPass(creditOptions);
				
				if (zoneChoice == 'a') { //Zone 1 Pass
					passPrice = chargeType.getZone1Price();
					chargeType.deductAmount(passPrice, "Zone 1", "All Day pass");

				} else if (zoneChoice == 'b') { //Zone 1 and 2 Pass
					passPrice = chargeType.getZone1and2Price();
					chargeType.deductAmount(passPrice, "Zones 1 and 2", "All Day Pass");

				} else {
					System.out.println("Transaction cancelled. Travel pass was not purchased." + '\n');
				}
				break;
			}
			case 3: {
				System.out.println("Transaction cancelled. Travel pass was not purchased." + '\n');
				break;
			}

			default: {
				System.out.println("Incorrect choice. Please enter the choice between 1 to 3" + '\n');
			}
			}
		} catch (InputMismatchException ex) {
			System.out.println("Entered choice is invalid" + '\n');
		}

	}

}
