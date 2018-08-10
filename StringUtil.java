import java.security.MessageDigest;
//generate a digital signature,
//there are many cryptographic algorithms you can choose from, 
//however SHA256 fits just fine for this example. 
//We can import java.security.MessageDigest; to get access to the SHA256 algorithm.

//We need to use SHA256 later down the line so lets create a handy helper method in a new StringUtil ‘utility’ class :

public class StringUtil {
	//Applies Sha256 to a string and returns the result. 
	public static String applySha256(String input){		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			//Applies sha256 to our input, 
			byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}	
}