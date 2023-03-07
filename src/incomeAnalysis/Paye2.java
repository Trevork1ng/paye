package incomeAnalysis;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Paye2 {
	
	   private static JFrame mainFrame;
	private static JLabel headerLabel;
	   public static void main(String[] args) {
		        payeUI();
		    }
		   

		    private static void payeUI() {
		        mainFrame = new JFrame("PAYE CALCULATOR");
		        mainFrame.setSize(400,400);
		        
		        headerLabel = new JLabel("PAYE CALCULATOR", JLabel.CENTER);
		        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
		        
		     // create panel and set layout
		        JPanel panel = new JPanel(new GridLayout(6,2,10,10));

		        // create labels and text fields
		        JLabel payPeriodLabel = new JLabel("Pay Period:");
		        JTextField payPeriodField = new JTextField(10);

		        JLabel basicSalaryLabel = new JLabel("Basic Salary:");
		        JTextField basicSalaryField = new JTextField(10);

		        JLabel benefitsLabel = new JLabel("Benefits Allowed:");
		        JTextField benefitsField = new JTextField(10);

		        JLabel deductionsLabel = new JLabel("Deductions:");
		        JTextField deductionsField = new JTextField(10);

		        JLabel taxLabel = new JLabel("Tax:");
		        JTextField taxField = new JTextField(10);

		        JLabel netPayLabel = new JLabel("Net Pay:");
		        JTextField netPayField = new JTextField(10);

		        // add labels and text fields to panel
		        panel.add(payPeriodLabel);
		        panel.add(payPeriodField);
		        panel.add(basicSalaryLabel);
		        panel.add(basicSalaryField);
		        panel.add(benefitsLabel);
		        panel.add(benefitsField);
		        panel.add(deductionsLabel);
		        panel.add(deductionsField);
		        panel.add(taxLabel);
		        panel.add(taxField);
		        panel.add(netPayLabel);
		        panel.add(netPayField);
		        
		     // create calculate button
		        JButton calbutton = new JButton("CALCULATE");
		        calbutton.setBorder(null);
		        calbutton.setAlignmentX(Component.CENTER_ALIGNMENT);

		        JPanel controlPanel = new JPanel();
		        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		        controlPanel.add(Box.createVerticalGlue());
		        controlPanel.add(panel);
		        controlPanel.add(Box.createVerticalGlue());
		        controlPanel.add(calbutton);
		        controlPanel.add(Box.createVerticalGlue());

		        mainFrame.add(controlPanel);
		        mainFrame.add(headerLabel, BorderLayout.NORTH);
		        mainFrame.setVisible(true);
}
}
