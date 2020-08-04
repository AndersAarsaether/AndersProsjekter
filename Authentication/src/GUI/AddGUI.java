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

public class AddGUI implements ActionListener{
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel fNameLabel = new JLabel("Firstname");
	private static JLabel lNameLabel = new JLabel("Lastname");
	private static JLabel userLabel = new JLabel("Username");
	private static JLabel passLabel = new JLabel("Verify by repeating the password");
	private static JLabel pass1Label = new JLabel("Password");
	private static JLabel pass2Label = new JLabel("Password");
	private static JTextField fNameTxt = new JTextField(20);
	private static JTextField lNameTxt = new JTextField(20);
	private static JTextField userTxt = new JTextField(20);
	private static JPasswordField pass1Txt = new JPasswordField();
	private static JPasswordField pass2Txt = new JPasswordField();
	private static JButton complete = new JButton("Complete");
	
	public static void main(String[] args) {
		
		//Setup
		frame.setSize(280, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.setLayout(null);
		
		
		//Labels
		fNameLabel.setBounds(10, 20, 80, 25);
		panel.add(fNameLabel);

		lNameLabel.setBounds(10, 60, 80, 25);
		panel.add(lNameLabel);
		
		userLabel.setBounds(10, 100, 80, 25);
		panel.add(userLabel);
		
		pass1Label.setBounds(10, 140, 80, 25);
		panel.add(pass1Label);
		
		passLabel.setBounds(10, 180, 210, 25);
		panel.add(passLabel);
		
		pass2Label.setBounds(10, 220, 80, 25);
		panel.add(pass2Label);
		
		
		//Input
		fNameTxt.setBounds(80, 20, 182, 25);
		panel.add(userTxt);
		
		lNameTxt.setBounds(80, 60, 182, 25);
		panel.add(fNameTxt);
		
		userTxt.setBounds(80, 100, 182, 25);
		panel.add(lNameTxt);
		
		pass1Txt.setBounds(80, 140, 182, 25);
		panel.add(pass1Txt);
		
		pass2Txt.setBounds(80, 220, 182, 25);
		panel.add(pass2Txt);
		
		
		//Buttons
		complete.setBounds(166, 260, 100, 30);
		complete.addActionListener(new AddGUI());
		panel.add(complete);
		
		
		//Visibility
		frame.setVisible(true);
	}

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void actionPerformed(ActionEvent e) {
		
		AccountsDAO dao = new AccountsDAO();
		ErrorGUI error = null;
		
		if(e.getSource() == complete) {
			
			boolean verified = pass1Txt.getText().equals(pass2Txt.getText());
			
			if(!verified) {
				error = new ErrorGUI("Passwords doesn't match");
				pass1Txt.setText("");
				pass2Txt.setText("");
			}
			
			if(verified) {
				
				String username = userTxt.getText();
				
				if(username == null) {
					error = new ErrorGUI("Username slot cant be empty");
				}
				
				else if(!dao.available(username)) {
					error = new ErrorGUI("Username already exists");
				}
				else {
					String fName = fNameTxt.getText();
					String lName = lNameTxt.getText();
					String pass = pass1Txt.getText();
					
					if(fName == null) {
						error = new ErrorGUI("Firstname slot cant be empty");
					}
					else if(lName == null) {
						error = new ErrorGUI("Lastname slot cant be empty");
					}
					else if(pass == null) {
						error = new ErrorGUI("Password slot cant be empty");
					}
					else {
						dao.addAccount(username, pass, fName, lName);
						
						LoginGUI.main(null);
						error = new ErrorGUI("The account is made!");
						frame.dispose();
					}
				}
			}
		}
	}
}
