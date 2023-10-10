package ApplicationCollection;

public class CoronaTracker {

	// data member
	private long custAdharNo;
	private String custName;
	private long custMobileNo;
	private int custCoronaInjectDose;
	private int  costumerSerialNo;

	@Override
	public String toString() {
		return "\t" +costumerSerialNo + "\t" + custAdharNo + "\t" + custName + "\t" + custMobileNo + "\t" + custCoronaInjectDose + "";
	}

	// Geter/Seter for Adhar Number
	public long getCustAdharNo() {
		return custAdharNo;
	}

	public void setCustAdharNo(long custAdharNo) {
		this.custAdharNo = custAdharNo;
	}

	// Geter/Seter for Name
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	// Geter/Seter for Mobile number
	public long getCustMobileNo() {
		return custMobileNo;
	}

	public void setCustMobileNo(long custMobileNo) {
		this.custMobileNo = custMobileNo;
	}

	// Geter/Seter for Dose
	public int getCustCoronaInjectDose() {
		return custCoronaInjectDose;
	}

	public void setCustCoronaInjectDose(int custCoronaInjectDose) {
		this.custCoronaInjectDose = custCoronaInjectDose;
	}

	// Geter/Seter dose verification
	public int getCostumerSerialNo() {
		return costumerSerialNo;
	}

	public void setCostumerSerialNo(int costumerSerialNo) {
		this.costumerSerialNo = costumerSerialNo;
	}

	// Printing costumer Information
	void displayCostumerDetails() {
		System.out.println();
		System.out.println();
		System.out.println("\t***********************Costumer Corona Dose Information************************");
		System.out.println();
		System.out.println("\tSerial No\tAdhar No\t Name\t\tMobile No\tInjected Dose");
		System.out.println();
	}

	// validate AdharNo validate Mobile Number
	public boolean validation(long custAdharNo, long custMobileNo) throws VerifyAdharException {
		int mobileLength = String.valueOf(custMobileNo).length();
		int adharLength = String.valueOf(custAdharNo).length();
		if (adharLength != 12) {
			throw new VerifyAdharException("\n\t Please Enter valid Adhar Number!!");
		
		} else if (mobileLength != 10) {
			throw new VerifyAdharException("\n\t Please Enter valid Mobile Number!!");
		}
		return true;
	}// end of method

//	// validate Mobile Number
//	public long validateMobile(long custMobileNo) {
//			int len = String.valueOf(this.custMobileNo).length();
//			if (custMobileNo < 10 && custMobileNo > 10) {
//				return -1;
//				// break;
//			}
//			return custMobileNo;
//		}//end of method 

}
