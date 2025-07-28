import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends BankAccount{
    Scanner sc = new Scanner(System.in);

    private ArrayList<BankAccount> accounts;
     

    Admin(String accountHolder, double balance, double interestRate){
        super(accountHolder, balance);
        this.accounts = new ArrayList<>();
        
    }

    public void addAcc(BankAccount account){
        accounts.add(account);
    }

   
}