// Bank Account Class
public class BankAccount {
    private double balance;

    // Constructor (accepts assigning amount on object initiation)
    public BankAccount(double initialDeposit) {
        balance = initialDeposit;
    }
    
    public void addAnnualInterest(
            double annualInterestRate,
            int years
    ) {
        for (int year = 0; year < years; year++) {
            balance += balance * annualInterestRate;
        }
    }

    public double getBalance() {
        return balance;
    }
}