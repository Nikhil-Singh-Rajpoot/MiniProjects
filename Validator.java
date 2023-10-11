package ApplicationCollection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	//---------------------------------adharNumber validate method-------------------------------- 
	public static boolean isValidAdhar(Long custAdharNo) throws VerifyAdharException {
	
		String adharNoString = String.valueOf(custAdharNo);
		Pattern adharPattern = Pattern.compile("^[0-9]{4}?[0-9]{4}?[0-9]{4}$");
		Matcher isValid = adharPattern.matcher(adharNoString);
		if (isValid.matches()) {
			
			return true;
		}
		
		throw new VerifyAdharException("\n\tAadhar Number is Not Valid......!!");
	}//------------------------------------------------------------------------------------------------------
	
	
	//---------------------------------mobileNumber validate method---------------------------------
	public static boolean isValidMobile(long custMobileNo) throws VerifyMobileException {
		String mobileString = String.valueOf(custMobileNo);
		Pattern mobilePattern = Pattern.compile("^[0-9]{10}$");
		Matcher isValid = mobilePattern.matcher(mobileString);
		if (isValid.matches()) {
			
			return true;
		}
		
		throw new VerifyMobileException("\n\tInvalid Mobile Number....!!");
	}//------------------------------------------------------------------------------------------------------
	
	
	//---------------------------------Customer Name validate method--------------------------------
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
	}//---------------------------------------------------------------------------------------------------------
	
	
	//------------------------------------Blood group Verification------------------------------------------  
	public static boolean isValidBloodG(String custBloodGroup)throws VerifyBloodGroupException {
		
		Pattern bloodPattern1 = Pattern.compile("(AB)[-+]{1}");
		Pattern bloodPattern2 = Pattern.compile("^[A-B-O][-+]{1,2}$");
		Matcher bloodMatcher1 = bloodPattern1.matcher(custBloodGroup);
		Matcher bloodMatcher2 = bloodPattern2.matcher(custBloodGroup);
		
		if(bloodMatcher1.matches()|| bloodMatcher2.matches()) {
			return true;
		}
		
		throw new VerifyBloodGroupException("\n\t Invalid Blood Group Enter valid Group...!!");
	}//---------------------------------------------------------------------------------------------------------
	
	
	//-----------------------------------------Email verification--------------------------------------------- 
	public static boolean isValidEmail(String custEmail) throws VerifyEmailException {
		
		Pattern emailPattern = Pattern.compile("^[a-z0-9]+@(gmail.com+)$");
		Matcher isValid = emailPattern.matcher(custEmail);
		if (isValid.matches()) {
			
			return true;
		}
		
		throw new VerifyEmailException("\n\t Invalid Email Id! Enter valid Email...!!");
	}//----------------------------------------------------------------------------------------------------------
	
}//end of class body 
