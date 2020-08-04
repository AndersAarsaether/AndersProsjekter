package authentication;

import org.mindrot.jbcrypt.*;

public class Encryption {

	public Encryption() {
		
	}
	
	public String encrypt(String password) {
		
		String hashed = null;
		
		if(password.isBlank() || password == null) {
			
			System.out.println("Invalid password. Must contain letters");
		}
		else {
			try {
				hashed = BCrypt.hashpw(password, BCrypt.gensalt(10));
			
			}catch(Exception e) {
				System.out.println("Something went wrong");
			}
		}
		return hashed;
	}
	
	public boolean verify(String input, String hashedPassword) {
		
	
		if(input == null) {
			
			System.out.println("Input is null");
			return false;
		}
		
		return BCrypt.checkpw(input, hashedPassword);
	}
}
