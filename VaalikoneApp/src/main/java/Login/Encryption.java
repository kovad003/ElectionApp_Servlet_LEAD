package Login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The Encryption class houses the static crypt method used to encrypt
 * passwords input by users and stored in the DB.
 * 
 * @version 1.0
 * @author HAMK's Finest
 * Date: April 14, 2021
 */

public class Encryption {
	
	/**
	 * A static method that hashes the provided password. Encryption is one-way, all
	 * data is intended to remain stored in encrypted format. Method is housed in 
	 * Encryption class. 
	 * 
	 * @param str takes String arg of value to be hashed.
	 * @return String of hashed value.
	 */
	
	public static String crypt(String str) {

	      if (str == null || str.length() == 0) {
	          throw new IllegalArgumentException("String to encript cannot be null or zero length");
	      }

	      MessageDigest digester;
	      try {
	          digester = MessageDigest.getInstance("MD5");

	          digester.update(str.getBytes());
	          byte[] hash = digester.digest();
	          StringBuffer hexString = new StringBuffer();
	          for (int i = 0; i < hash.length; i++) {
	              if ((0xff & hash[i]) < 0x10) {
	                  hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
	              } else {
	                  hexString.append(Integer.toHexString(0xFF & hash[i]));
	              }
	          }
	          return hexString.toString();
	      } catch (NoSuchAlgorithmException e) {
	          e.printStackTrace();
	      }
	      return "";
	  }

}
