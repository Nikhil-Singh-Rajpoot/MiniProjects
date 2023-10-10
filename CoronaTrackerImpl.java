
package ApplicationCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CoronaTrackerImpl {

	static {
		System.out.println("\n****************************************************************************\n");
		System.out.println("\t\t Corona Vacination Application");
		System.out.println("\n****************************************************************************");
	}

	// create ArrayList and Iterator
	static List<CoronaTracker> list = new ArrayList<CoronaTracker>();
	static Iterator<CoronaTracker> it = list.iterator();

	// write a display method
	static public void displayList() {
		while (it.hasNext()) {
			CoronaTracker corona = it.next();
			System.out.println("\t" + corona.getCustAdharNo() + "\t" + corona.getCustName() + "\t"
					+ corona.getCustMobileNo() + "\t" + corona.getCustCoronaInjectDose());
		}
	}

	public static void main(String vishu[]) {

		// data member
		long custAdharNo = 0;
		String custName = null;
		long custMobileNo = 0l;
		int custCoronaInjectDose = 0;
		char custVerifyDose;
		boolean end = false;
	    boolean validated = false;

		// create classes obj
		Scanner sc = new Scanner(System.in);
		CoronaTracker ct = new CoronaTracker();

		// while loop
		while (!end) {
			
			int count=0;
			int choice = 0;
			try {
				System.out.println("\n\t 1. For Add New Costumer ");
				System.out.println("\t 2. For Show List of Costumer ");
				System.out.println("\t 3. For Exit Application ");
				System.out.print("\n\t Enter Your Choice :");
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("\n\t\t" + e.getMessage());
			}
			if (choice==1) {
				count++;
			}
			try {
				// switch case
				switch (choice) {
				case 1:
					System.out.print("\n\t Are You Corona Vecinated or Not (Yes/No) : ");
					char vacinatedStatus = sc.next().charAt(0);
					if (vacinatedStatus == 'y' || vacinatedStatus == 'Y') {
						System.out.println("\n\t\t Costumer Serial No : 000"+count);
						System.out.println();
						System.out.print("\n\t Enter Adhar Number :");
						custAdharNo = sc.nextLong();
						sc.nextLine();
						System.out.print("\t Enter Costumer Name :");
						custName = sc.nextLine();
						System.out.print("\t Enter Costumer Mobile No :");
						custMobileNo = sc.nextLong();
						System.out.print("\t How many Dose you are taken :");
						custCoronaInjectDose = sc.nextInt();
						try {
							// validate fields
							validated = ct.validation(custAdharNo, custMobileNo);
							if (validated) {
								ct.setCustAdharNo(custAdharNo);
								ct.setCustMobileNo(custMobileNo);
								ct.setCustName(custName);
								ct.setCustCoronaInjectDose(custCoronaInjectDose);
								ct.setCostumerSerialNo(count);
								// add costumer
								list.add(ct);
								System.out.println("\n\t Record Added Successfull...");
							}
						} catch (Exception e) {
							System.out.println("\t" + e.getMessage());
						}
						
					} else {
						System.out.println("\n\t You are not Vacineted yet :");
						// end = true;
					} // end of if body
					break;
				case 2:
					ct.displayCostumerDetails();
					// displayList();

//print value using for-each loop 
//					for (CoronaTracker c : list) {
//						System.out.println("\t" + c.getCostumerSerialNo() + "\t\t" + c.getCustName() + "\t\t" + c.getCustMobileNo() + "\t" + c.getCustCoronaInjectDose());
//					}

// print value using for loop
					for (Iterator iterator = list.iterator(); iterator.hasNext();) {
						CoronaTracker coronaTracker = (CoronaTracker) iterator.next();
		
						System.out.println("\t"+"000"+ coronaTracker.getCostumerSerialNo() + "\t\t"+coronaTracker.getCustAdharNo() +  "\t" + coronaTracker.getCustName() + "\t" + coronaTracker.getCustMobileNo() + "\t  " + coronaTracker.getCustCoronaInjectDose());
					}

//print value using while loop
//					while (it.hasNext()) {
//						CoronaTracker corona = it.next();
//						System.out.println("\t"+"000"+ corona.getCostumerSerialNo() + "\t" + corona.getCustAdharNo() + "\t" + corona.getCustName() + "\t"
//								+ corona.getCustMobileNo() + "\t" + corona.getCustCoronaInjectDose());
//					}

					System.out.println(
							"\t------------------------------------------------------------------------------");
					break;
				case 3:
					System.exit(0);
					end = true;
				default:
					System.out.println("\t Invalid Choice");
					end = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("Sorry Invalid Statement....!!");
			}
		} // end of while loop
	}
}