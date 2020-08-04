package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorGUI implements ActionListener{

	private JLabel label; 
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JButton button = new JButton("Ok");
	
	public ErrorGUI() {
		
	}
	
	public ErrorGUI(String label) {
		
		this.label = new JLabel(label);
		
		//Setup
		frame.setSize(280, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		panel.setLayout(null);
		
		//Label
		this.label.setBounds(25, 25, 300, 25);
		panel.add(this.label);
		
		//Button
		button.setBounds(90, 70, 100, 30);
		button.addActionListener(this);
		panel.add(button);
		
		//Visibility
		frame.setVisible(true);
		frame.toFront();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button) {
			frame.dispose();
		}
	}
}
