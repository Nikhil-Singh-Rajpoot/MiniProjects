package ApplicationCollection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	//adharNumber validate method 
	public static boolean isValidAdhar(Long custAdharNo) throws VerifyAdharException {
	
		String adharNoString = String.valueOf(custAdharNo);
		Pattern adharPattern = Pattern.compile("^[0-9]{4}?[0-9]{4}?[0-9]{4}$");
		Matcher isValid = adharPattern.matcher(adharNoString);
		if (isValid.matches()) {
			
			return true;
		}
		
		throw new VerifyAdharException("\n\tAadhar Number is Not Valid......!!");
	}
	
	//mobileNumber validate method 
	public static boolean isValidMobile(long custMobileNo) throws VerifyMobileException {
		String mobileString = String.valueOf(custMobileNo);
		Pattern mobilePattern = Pattern.compile("^[0-9]{10}$");
		Matcher isValid = mobilePattern.matcher(mobileString);
		if (isValid.matches()) {
			
			return true;
		}
		
		throw new VerifyMobileException("\n\tInvalid Mobile Number....!!");
	}
	
	//Customer Name validate method
	public static boolean isValidName(String custName) throws VerifyNameException {
		
		Pattern namePattern = Pattern.compile("^[A-Za-z][A-Za-z ]{3,22}$");
		Matcher isValid = namePattern.matcher(custName);
		if (custName.equals("null")) {
			throw new VerifyNameException("\n\t Sorry Invalid Name...!!");
		}
		if (isValid.matches()) {
			
			return true;
		}
		throw new VerifyNameException("\n\t Sorry Invalid Name...!!");
	}
}
