import java.util.ArrayList;

public class CheckingAcc extends BankAccount {
    
    ArrayList<BankAccount> checkingAcc;

    CheckingAcc(String accountHolder, double balance) {
        super(accountHolder, balance);
        this.checkingAcc = new ArrayList<>();
    }

    @Override
    public void withdrawKaching(double amount) {
        if (!isAmountValid(amount)) {
            System.out.println("Invalid Amount!");
            return;
        }
        
        double currentBalance = getBalance();
        double additionalFee = 1.0; 
        double totalDeduction = amount + additionalFee;

        
        if (currentBalance - totalDeduction <= 100) {
            System.out.println("Can't go below 100");
        } else if (totalDeduction > currentBalance) {
            System.out.println("Insufficient funds for this withdrawal, including the fee!");
        } else {
            
            double updatedBalance = currentBalance - totalDeduction;
            setBalance(updatedBalance);
            System.out.println("Withdraw Done! Amount: " + amount + ", New Balance: " + updatedBalance);
        }
    }

    @Override
    public void accDetails() {
        System.out.println("\nChecking Account");
        System.out.println("Account Holder: " + getAccountHolder());
        System.out.println("Balance       : " + getBalance());
    }
}
