package accounts.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import accounts.entities.Accounts;
import authentication.Encryption;

public class AccountsDAO {

	private EntityManagerFactory emf;
	
	public AccountsDAO() {
		emf = Persistence.createEntityManagerFactory("AuthenticationPersistenceUnit");
	}
	
	public void addAccount(String username, String password, String fname, String lname) {
	
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		Encryption BCrypt = new Encryption();
		
		try {
			
			String hashedPassword = BCrypt.encrypt(password);
			Accounts account = new Accounts(username, hashedPassword, fname, lname);
			
			t.begin();
			em.persist(account);
			t.commit();
			
		}catch(Throwable e) {
			
			e.printStackTrace();
			if(t.isActive()) {
				t.rollback();
			}
		}finally {
			em.close();
		}
	}
	
	public boolean verifyAccount(String username, String password) {
		
		EntityManager em = emf.createEntityManager();
		Encryption BCrypt = new Encryption();
		Accounts a = null;
		String hash = null;
		boolean b = false;
		try {
			
			a = em.find(Accounts.class, username);
			hash = a.getPassword();
			b = BCrypt.verify(password, hash);
		
		}catch(Throwable e){
			
		}finally {
			em.close();
		}
		return b;
	}
	
	public boolean available(String username) {
		
		EntityManager em = emf.createEntityManager();
		Accounts a = null;
		
		try {
			a = em.find(Accounts.class, username);
		}catch(Throwable e) {
			
		}finally {
			em.close();
		}
		return (a == null);
	}
}
