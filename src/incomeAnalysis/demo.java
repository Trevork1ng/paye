package incomeAnalysis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class demo {
    private static JFrame mainFrame;
    private static JLabel headerLabel;
    private static JLabel basicSalaryLabel;
    private static JLabel benefitsLabel;
    private static JTextField payPeriodField;
    private static JTextField basicSalaryField;
    private static JTextField benefitsField;
    private static JButton calculateButton;
    private static JLabel resultLabel;
    private static JCheckBox payPeriodCheckbox;

    public static void main(String[] args) {
        payeUI();
    }
 
    
    private static void payeUI() {
        mainFrame = new JFrame("PAYE CALCULATOR");
        mainFrame.setSize(400, 400);

        headerLabel = new JLabel("PAYE CALCULATOR", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));

        basicSalaryLabel = new JLabel("Basic Salary:");
        basicSalaryLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        basicSalaryField = new JTextField(10);
        basicSalaryField.setFont(new Font("Arial", Font.PLAIN, 14));

        payPeriodField = new JTextField("");
        payPeriodField.setPreferredSize(new Dimension(70, 20));
        payPeriodField.setFont(new Font("Arial", Font.PLAIN, 14));

        payPeriodCheckbox = new JCheckBox("Yearly Pay Period");
        payPeriodCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));

        benefitsLabel = new JLabel("Benefits Allowed:");
        benefitsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        benefitsField = new JTextField(10);
        benefitsField.setFont(new Font("Arial", Font.PLAIN, 14));

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                try {
                    double basicSalary = Double.parseDouble(basicSalaryField.getText());
                    double benefits = Double.parseDouble(benefitsField.getText());
                    String payPeriod = payPeriodField.getText().toLowerCase();

                    double taxableIncome = basicSalary + benefits;

                    double nssfContribution;
                    if (basicSalary <= 10000) {
                        nssfContribution = 360;
                    } else if (basicSalary <= 18000) {
                        nssfContribution = 720;
                    } else {
                        nssfContribution = 1080;
                    }

                    double personalRelief;
                    if (payPeriod.equals("year")) {
                        personalRelief = 288000;
                    } else {
                        personalRelief = 24000;
                    }

                    double taxableIncomeAfterRelief = taxableIncome - personalRelief;
                    double paye;
                    if (taxableIncomeAfterRelief <= 24000) {
                        paye = 0.1 * taxableIncomeAfterRelief;
                    } else if (taxableIncomeAfterRelief <= 40667) {
                        paye = 2400 + 0.15 * (taxableIncomeAfterRelief - 24000);
                    } else if (taxableIncomeAfterRelief <= 57333) {
                        paye = 5400 + 0.20 * (taxableIncomeAfterRelief - 40667);
                    } else if (taxableIncomeAfterRelief <= 74000) {
                        paye = 9600 + 0.25 * (taxableIncomeAfterRelief - 57333);
                    } else if (taxableIncomeAfterRelief <= 90767) {
                        paye = 14900 + 0.30 * (taxableIncomeAfterRelief - 74000);
                    } else if (taxableIncomeAfterRelief <= 107533) {
                        paye = 22400 + 0.35 * (taxableIncomeAfterRelief - 90767);
                    } else {
                        paye = 31467 + 0.40 * (taxableIncomeAfterRelief - 107533);
                    }

                    resultLabel.setText(String.format("PAYE: %.1f", paye));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainFrame, "Please enter valid numbers in the input fields.",
                            "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        payPeriodCheckbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (payPeriodCheckbox.isSelected()) {
                    payPeriodField.setText("year");
                } else {
                    payPeriodField.setText("month");
                }
            }
        });

        resultLabel = new JLabel("", JLabel.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(basicSalaryLabel);
        inputPanel.add(basicSalaryField);
        inputPanel.add(new JLabel("Pay Period:", JLabel.LEFT));
        inputPanel.add(payPeriodField);
        inputPanel.add(benefitsLabel);
        inputPanel.add(benefitsField);
        payPeriodCheckbox = new JCheckBox("Yearly Pay Period");
        inputPanel.add(payPeriodCheckbox);
        
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(inputPanel, BorderLayout.CENTER);
        containerPanel.add(calculateButton, BorderLayout.SOUTH);

        mainFrame.add(headerLabel, BorderLayout.NORTH);
        mainFrame.add(containerPanel, BorderLayout.CENTER);
        mainFrame.add(resultLabel, BorderLayout.SOUTH);

        mainFrame.setVisible(true);

    }
}