package userInterface;

import methods.Randomizer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener{

	private JLabel label;	
	private JFrame frame;
	private JButton add;
	private JButton finish;
	private JPanel panel;
	private JTextField textField;
	private String input = "";
	
	public GUI() {
		
		frame = new JFrame();
		label = new JLabel("Write the different alternatives:");
		
		add = new JButton("Add option");
		add.addActionListener(this);
		finish = new JButton("Get result");
		finish.addActionListener(this);
		
		textField = new JTextField(8);
		textField.setFont(textField.getFont().deriveFont(12f));
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(label);
		panel.add(textField);
		panel.add(add);
		panel.add(finish);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Randomizer");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == add) {
			
			input += textField.getText() + ":";
			textField.setText("");
		}
		else {
			
			frame.dispose();
			
			frame = new JFrame();
			label = new JLabel();
			String result = null;
			
			try {
				Randomizer r = new Randomizer(input, ":");
				result = r.randomize();
				
				if(!result.equals("")) {
					label.setText("Randomizer returned " + result);
				}
				else {
					label.setText("Make sure to write alternatives.");
				}
			}catch(Exception a) {
				a.getStackTrace();
				label.setText("Make sure to write alternatives.");
			}
						
			panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
			panel.setLayout(new GridLayout(0, 1));
			panel.add(label);
						
			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Randomizer");
			frame.pack();
			frame.setVisible(true);
		}
	}
}
