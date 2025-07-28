import java.util.ArrayList;

public class BusinessAcc extends BankAccount {
    
    ArrayList<BankAccount> businessAcc;
    double overdraftLimit = 1000;

    // Constructor to initialize the account holder, balance, and overdraft limit
    BusinessAcc(String accountHolder, double balance, double overdraftLimit) {
        super(accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
        this.businessAcc = new ArrayList<>();
    }

    @Override
    public void withdrawKaching(double amount) {
        if (!isAmountValid(amount)) {
            System.out.println("Invalid Amount!");
            return;
        }

        double currentBalance = getBalance();
        double newBalance = currentBalance - amount;

        
        if (newBalance < -overdraftLimit) {
            System.out.println("Withdrawal exceeds overdraft limit!");
        } else {
            setBalance(newBalance);
            System.out.println("Withdraw Done! New Balance: " + getBalance());
        }
    }

    @Override
    public void accDetails() {
        System.out.println("\nBusiness Account");
        System.out.println("Account Holder  : " + getAccountHolder());
        System.out.println("Balance         : " + getBalance());
        System.out.println("Overdraft Limit : " + overdraftLimit);
    }

    @Override
    public void depositKaching(double amount) {
        if (!isAmountValid(amount)) {
            System.out.println("Invalid Amount!");
            return;
        } else {
          
            double newBalance = getBalance() + amount;
            setBalance(newBalance);
            System.out.println("Deposit Done! New Balance: " + newBalance);
        }
    }
}
