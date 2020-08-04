package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import accounts.dao.AccountsDAO;

public class LoginGUI implements ActionListener{

	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel uLabel = new JLabel("Username");
	private static JLabel pLabel = new JLabel("Password");
	private static JTextField userTxt = new JTextField(20);
	private static JPasswordField passwordTxt = new JPasswordField();
	private static JButton login = new JButton("Login");
	private static JButton add = new JButton("Add account");
	
	public static void main(String[] args) {
		
		//Setup
		frame.setSize(280, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.setLayout(null);
		
		
		//Labels
		uLabel.setBounds(10, 20, 80, 25);
		panel.add(uLabel);
		
		pLabel.setBounds(10, 55, 80, 25);
		panel.add(pLabel);
		
		
		//Input
		userTxt.setBounds(80, 20, 182, 25);
		panel.add(userTxt);
		
		passwordTxt.setBounds(80, 55, 182, 25);
		panel.add(passwordTxt);
		
		
		//Buttons
		login.setBounds(78, 90, 80, 25);
		login.addActionListener(new LoginGUI());
		panel.add(login);
		
		add.setBounds(150, 90, 115, 25);
		add.addActionListener(new LoginGUI());
		panel.add(add);

		
		//Visibility
		frame.setVisible(true);
	}

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void actionPerformed(ActionEvent e) {
		
		AccountsDAO dao = new AccountsDAO();
		ErrorGUI error = null;
		
		if(e.getSource() == login) {
			
			String uString = userTxt.getText();
			String pString = passwordTxt.getText();
			
			boolean valid = dao.verifyAccount(uString, pString);
			
			if(!valid) {
				userTxt.setText("");
				passwordTxt.setText("");
				error = new ErrorGUI("Login unsuccessful");
			}
			else {
				error = new ErrorGUI("Login successful!");
				frame.dispose();
			}
		}
		else if(e.getSource() == add) {
			frame.dispose();
			AddGUI.main(null);
		}
		
	}

}
