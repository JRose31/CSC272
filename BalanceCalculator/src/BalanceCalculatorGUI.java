import javax.swing.*;
import java.awt.GridLayout;

public class BalanceCalculatorGUI {

    // Declare variables for elements
    private JTextField depositInput;

    private JTextField interestInput;

    private JTextField yearsInput;

    private JLabel resultLabel;

    private void calculateBalance() {
        double initialDeposit = Double.parseDouble(
                depositInput.getText()
        );

        double interestRate = Double.parseDouble(
                interestInput.getText()
        ) / 100;

        int years = Integer.parseInt(
                yearsInput.getText()
        );

        BankAccount account = new BankAccount(
                initialDeposit
        );

        account.addAnnualInterest(
                interestRate,
                years
        );

        double finalBalance = account.getBalance();

        resultLabel.setText(
                String.format(
                        "$%.2f",
                        finalBalance
                )
        );
    }

    public BalanceCalculatorGUI() {

        // Define application frame (window)
        JFrame frame = new JFrame(
                "Balance Calculator"
        );

        // Define application layout
        JPanel panel = new JPanel(
                new GridLayout(
                        5,
                        2,
                        10,
                        10
                )
        );

        // Create application elements
        depositInput = new JTextField();

        interestInput = new JTextField();

        yearsInput = new JTextField();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(
                event -> calculateBalance()
        );

        resultLabel = new JLabel("$0.00");

        // Build panel (populate with elements)
        panel.add(
                new JLabel("Initial Deposit:")
        );

        panel.add(depositInput);

        panel.add(
                new JLabel("Annual Interest Rate (%):")
        );

        panel.add(interestInput);

        panel.add(
                new JLabel("Number of Years:")
        );

        panel.add(yearsInput);

        panel.add(
                new JLabel("")
        );

        panel.add(calculateButton);

        panel.add(
                new JLabel("Final Balance:")
        );

        panel.add(resultLabel);

        frame.add(panel);

        frame.setSize(
                500,
                250
        );

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setVisible(true);

    }

}