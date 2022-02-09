import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
public class PasswordCheckerUtility {

	public static void comparePasswords(String pass, String passCom) throws UnmatchedException {
	
		if(!pass.equalsIgnoreCase(passCom)) 
		throw new UnmatchedException(); 
		}
	
	
	
	public static boolean comparePasswordsWithReturn(String pass, String passCom) {
		boolean res = false;
		if(pass.equals(passCom)) {
			res = true;
		} 
		return res;
	
	}
	
	public static boolean isValidLength(String pass) throws LengthException {
		boolean res = false;
		if (pass.length() > 6)
	    res =  true;
		else
		throw new LengthException();	
		return res;
	}

	public static boolean hasUpperAlpha(String pass) throws NoUpperAlphaException{
		boolean res = false;
	
		String s = "[A-Z]";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(s);
		if(m.matches()) {
			res = true;
		} else {
			throw new NoUpperAlphaException();
		}
		return res;
	}
	
	public static boolean hasLowerAlpha(String pass) throws NoLowerAlphaException{
		boolean res = false;
	
		String s = "[a-z]";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(s);
		if(m.matches()) {
			res = true;
		} else {
			throw new NoLowerAlphaException();
		}
		return res;
	}
	
	public static boolean hasDigit(String pass) throws NoDigitException{
		boolean res = false;
	
		String s = "[0-9]";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(s);
		if(m.matches()) {
			res = true;
		} else {
			throw new NoDigitException();
		}
		return res;
	}
	
	public static boolean hasSpecialCharacter(String pass) throws NoSpecialCharacterException{
		boolean res = false;
	
		String s = "[^A-Za-z0-9]";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(s);
		if(m.matches()) {
			res = true;
		} else {
			throw new NoSpecialCharacterException();
		}
		return res;
	}
	
	public static boolean NoSpecialCharacterException(String pass) throws NoSpecialCharacterException{
		boolean res = true;
	
		String s = "[^A-Za-z0-9]";
		Pattern p = Pattern.compile(s);
		Matcher m = p.matcher(s);
		if(m.matches()) {
			res = false;
		} else {
			throw new NoSpecialCharacterException();
		}
		return res;
	}
	
	public static boolean noSameCharInSequence(String pass) throws InvalidSequenceException{
	

		boolean res = false;
		for (int i = 0; i < pass.length(); i++) {
			if (!(pass.substring(i) == pass.substring(i,i+1))) {
				res = true;
			} else {
				throw new InvalidSequenceException();
			}
		}
	
		
			
			return res;
	}
	
	
	
	public static boolean isValidPassword(String pass) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException  {
		boolean res = false;
		if(hasDigit(pass) && noSameCharInSequence(pass) && hasSpecialCharacter(pass) && hasLowerAlpha(pass) && hasUpperAlpha(pass) && isValidPassword(pass)) {
			res = true;
		}
	     return res;
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> pass) {
	
		ArrayList<String> passw =  new ArrayList<String>();
		for(int i = 0; i < pass.size(); i++) {
		
		}
			
		return passw;
	}
	
	public static boolean isWeakPassword(String pass) throws WeakPasswordException {
		boolean res = false;
		if (!(pass.length() >= 6 && pass.length() <= 9))
	    res =  true;
		else
		throw new  WeakPasswordException();	
		return res;
	}

	public static boolean hasBetweenSixAndNineChars(String pass) throws WeakPasswordException {
		boolean res = false;
		if ((pass.length() >= 6 && pass.length() <= 9))
	    res =  true;
		else
		throw new  WeakPasswordException();	
		return res;
	}
}
