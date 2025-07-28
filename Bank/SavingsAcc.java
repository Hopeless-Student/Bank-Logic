import java.util.Scanner;
import java.util.ArrayList;
public class SavingsAcc extends BankAccount{
    static Scanner sc = new Scanner(System.in);
    double interestRate;
    ArrayList<BankAccount> savingsAcc;

    SavingsAcc(String accountHolder, double balance, double interestRate){
        super(accountHolder, balance);
        this.interestRate = interestRate;
        this.savingsAcc = new ArrayList<>();
    }

    @Override
    public void withdrawKaching(double amount) {
        double fee = amount * 0.05;  
        double totalWithdrawalAmount = amount + fee;  
    
        
        if (totalWithdrawalAmount >= getBalance()) {
            System.out.println("Insufficient funds. The total amount (including fees) exceeds your balance.");
            return;
        }
    
        if (!isAmountValid(amount)) {
            System.out.println("Withdraw amount is invalid!");
            return;
        }
    
       
        double updatedBalance = getBalance() - totalWithdrawalAmount;
    
       
        if (updatedBalance < 100) {
            System.out.println("Can't go below 100");
        } else {
            setBalance(updatedBalance);
            System.out.println("Withdraw Done!\nAccount Holder: " + getAccountHolder() + 
                               "\nWithdraw Amount: " + amount + 
                               "\nFee: " + fee + 
                               "\nRemaining Balance: " + getBalance());
        }
    }
    @Override
    public void accDetails(){
        System.out.println("\nSavings Account");
        System.out.println("Account Holder: " + getAccountHolder());
        System.out.println("Balance       : " + getBalance());
        System.out.println("Interest      : " + interestRate + "%");
    }
}
