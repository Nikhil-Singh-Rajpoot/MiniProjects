
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
	
	static ArrayList<CoronaTracker> list = new ArrayList<>();
	static Iterator<CoronaTracker> it = list.iterator();
	static  int noOfCust=0;
	
	//-----------------add object into arrayList--------------
	public static void addObject(CoronaTracker corona) {
		list.add(corona);
		}
	
	
	// ---------------write a display method-----------------
	 public static void displayList() {
		for(int i=0; i<list.size(); i++) {
			list.get(i).displayCostumerDetails();;
		}
	}

	 //main method
	public static void main(String vishu[]) {

		// ----------data member----------
		long custAdharNo = 0;
		String custName = null;
		long custMobileNo = 0l;
		int custCoronaInjectDose = 0;
		boolean end = false;
		String custBloodGroupString;
	  	String custEmailId;
	  	String custRegNumber;

		// ----------create classes obj-------------
		Scanner sc = new Scanner(System.in);
		CoronaTracker ct = new CoronaTracker();

		// --------while loop---------
		while (!end) {
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
			try {
				// ---------switch case----------
				switch (choice) {
				case 1:

					System.out.print("\n\t Enter Number of Customer : ");
					noOfCust = sc.nextInt();

					for (int i = 0; i < noOfCust; i++) {
						System.out.print("\n\t Are You Corona Vecinated or Not (Yes/No) : ");
						char vacinatedStatus = sc.next().charAt(0);
						sc.nextLine();
						if (vacinatedStatus == 'y' || vacinatedStatus == 'Y') {

							try {
								System.out.print("\n\t Enter Adhar Number :");
								custAdharNo = sc.nextLong();
								sc.nextLine();
								if (Validator.isValidAdhar(custAdharNo)) {
									ct.setCustAdharNo(custAdharNo);
								}

								System.out.print("\t Enter Costumer Name :");
								custName = sc.nextLine();
								if (Validator.isValidName(custName)) {
									ct.setCustName(custName);
								}
								
								System.out.print("\t Enter Costumer Mobile No :");
								custMobileNo = sc.nextLong();
								if(Validator.isValidMobile(custMobileNo)) {
									ct.setCustMobileNo(custMobileNo);
								}
								
								System.out.print("\t Enter Your Blood Group :");
								custBloodGroupString = sc.next();
								if (Validator.isValidBloodG(custBloodGroupString)) {
									ct.setCustBloodGroupString(custBloodGroupString);
								}
								
								System.out.print("\t Enter Your Email Id :");
								custEmailId = sc.next();
								if (Validator.isValidEmail(custEmailId)) {
									ct.setCustEmailId(custEmailId);
								}
								
								System.out.print("\t How many Dose you are taken :");
								custCoronaInjectDose = sc.nextInt();
								if (custCoronaInjectDose<4) {
								 ct.setCustCoronaInjectDose(custCoronaInjectDose);
								}
								
								 custRegNumber = ct.custRegristrationNo(custAdharNo);
								
								addObject(ct);
								System.out.println("\n\t Record Added successfully....Regstration No : "+custRegNumber);
								
							} catch (Exception e) {
								System.out.println("\t" + e.getMessage());
							}
								}//end of for loop 
						}//end of if condition 
						break;
						
				case 2:
					 displayList();
//print value using for-each loop 
//					for (CoronaTracker c : list) {
//						System.out.println("\t" + c.getCostumerSerialNo() + "\t\t" + c.getCustName() + "\t\t" + c.getCustMobileNo() + "\t" + c.getCustCoronaInjectDose());
//					}

// print value using for loop
//					for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//						CoronaTracker coronaTracker = (CoronaTracker) iterator.next();
//
//						System.out.println("\t" + "000" + coronaTracker.getCostumerSerialNo() + "\t    "
//								+ coronaTracker.getCustAdharNo() + "\t" + coronaTracker.getCustName() + "\t"
//								+ coronaTracker.getCustMobileNo() + "\t  " + coronaTracker.getCustCoronaInjectDose());
//					}

//print value using while loop
//					while (it.hasNext()) {
//						CoronaTracker corona = it.next();
//						System.out.println("\t"+"000"+ corona.getCostumerSerialNo() + "\t" + corona.getCustAdharNo() + "\t" + corona.getCustName() + "\t"
//								+ corona.getCustMobileNo() + "\t" + corona.getCustCoronaInjectDose());
//					}

					System.out.println(
							"\t---------------------------------------------------------------------------------------------------------------------");
					break;
					
				case 3:
					System.exit(0);
					end = true;
				default:
					System.out.println("\n\t Sorry Invalid Choice.......Try Again And Enter Valid Choice  ");
					end = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("\n\tSorry Invalid Statement.......Restart Your Application!!");
			}
		} //------------ end of while loop---------------
	}
}//end of main Class