// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    static Scanner sc = new Scanner(System.in);
    private String accountHolder;
    private double balance;
    private ArrayList<SavingsAcc> savingsAccounts;
    private ArrayList<CheckingAcc> checkingAccounts;
    private ArrayList<BusinessAcc> businessAccounts;
    

    BankAccount(String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.savingsAccounts = new ArrayList<>();
        this.checkingAccounts = new ArrayList<>();
        this.businessAccounts = new ArrayList<>();   
    }

    

    public String getAccountHolder(){
        return accountHolder;
    }

    public double getBalance(){
        return balance;
    }

    

    public void setBalance(double amount){
        this.balance = amount;
    }

    public void depositKaching(double amount){
        if(isAmountValid(amount)== false){
            System.out.println("Invalid Amount!");
        } else {
            balance += amount;
            System.out.println("Deposit Done!\nAccount Holder: " + getAccountHolder() + "\nBalance: " + getBalance());
            System.out.println();
        }
    }

    public void withdrawKaching(double amount){

    }

    public void accDetails(){
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance       : " + balance);
    }

    public boolean isAmountValid(double amount){
        if(amount <= 0 ){
            return false;
        } 
        else {
            return true;
        }
    }

    public void adminControl(){
        System.out.println("\nAdmin Control");
        System.out.println("1. Add account");
        System.out.println("2. Exit");
    }

    public void createSaveAcc() {
        int cont = 1;  
    
        while (cont == 1) {
            sc.nextLine();  
            System.out.println("\nSavings Acc");
            System.out.print("Account Holder: ");
            String savingsAccName = sc.nextLine();
            System.out.print("Account Password: ");
            int pass1 = sc.nextInt();
            double saveAccBal = 100;  
            setBalance(saveAccBal);
    
            double interest = 5;
    
            
            SavingsAcc saveAcc = new SavingsAcc(savingsAccName, saveAccBal, interest);
            savingsAccounts.add(saveAcc);
    
            System.out.println("Savings Account has been created!");
            
           
            System.out.print("Do you want to create another acc? Y(1) N(0): ");
            cont = sc.nextInt();  
        }
    }

    public void createCheckAcc(){
        int cont = 1;

        while (cont == 1) {
            sc.nextLine();
            System.out.println("\nChecking Account");
            System.out.print("Account Holder: ");
            String checkingAccName = sc.nextLine();
            System.out.print("Account Password: ");
            int pass2 = sc.nextInt();
            double checkingBalance = 100;
            setBalance(checkingBalance);

            CheckingAcc checkAcc = new CheckingAcc(checkingAccName, checkingBalance);
            checkingAccounts.add(checkAcc);
            System.out.println("Checking Account has been created!");
            System.out.print("Do you want to create another acc? Y(1) N(0): ");
            cont = sc.nextInt();  
        }
    }
    
    public void createBussAcc(){
        int cont = 1;

        while (cont ==1) {
            sc.nextLine();
            System.out.println("\nBusiness Account");
            System.out.print("Account Holder: ");
            String bussAccName = sc.nextLine();
            System.out.print("Account Password: ");
            int pass3 = sc.nextInt();
            double businessBalance = 100;
            double overdraftLimit = 1000;
            setBalance(businessBalance);
            sc.nextLine();
            BusinessAcc bussAcc = new BusinessAcc(bussAccName, businessBalance, overdraftLimit);
            businessAccounts.add(bussAcc);
            System.out.println("Business Account has been created!"); 
            System.out.print("Do you want to create another acc? Y(1) N(0): ");
                cont = sc.nextInt();  
        }
        
    }
            public static void accType(){
                System.out.println("Account Types");
                System.out.println("1. Savings Account");
                System.out.println("2. Checking Account");
                System.out.println("3. Business Account");
                System.out.println("4. Exit");
            }
            public static void Menu(){
                System.out.println("Bank Actions");
                System.out.println("1. Deposit money");
                System.out.println("2. Withdraw money");
                System.out.println("3. Print Account Details");
                System.out.println("4. Exit");
            }
            
            public void displaySavingsAccounts(){
                System.out.println("\nSavings Accounts:");
                for (SavingsAcc acc : savingsAccounts) {
                    acc.accDetails();
                }
            }

            public void displayCheckingAccounts(){
                System.out.println("\nChecking Accounts:");
                for (CheckingAcc acc : checkingAccounts) {
                    acc.accDetails();
                }
            }

            public void displayBusinessAccounts(){
                System.out.println("\nBusiness Accounts:");
                for (BusinessAcc acc : businessAccounts) {
                    acc.accDetails();
                }
            }

            public void person(){
                System.out.println("1. Admin");
                System.out.println("2. User");
                System.out.println("3. Exit");
            }
        
            public void processTransaction(BankAccount account, String transactionType, double amount){
                
                System.out.println("Transaction is ongoing....");

                if (transactionType.equals("Deposit")) {
                    processTransaction(account, "Deposit", amount);
                    account.depositKaching(amount);
                } else if (transactionType.equals("Withdraw")) {
                    account.withdrawKaching(amount);
                } else {
                    System.out.println("Invalid transaction type!");
                }
                   
            }
            public void chooseAndProcessAccount(ArrayList<? extends BankAccount> accounts) {
                System.out.println("Please choose an account:");
                for (int i = 0; i < accounts.size(); i++) {
                    System.out.println((i + 1) + ". Account Holder: " + accounts.get(i).getAccountHolder() + " | Balance: " + accounts.get(i).getBalance());
                }
                System.out.print("Enter the number of the account: ");
                int choice = sc.nextInt();
                
                if (choice > 0 && choice <= accounts.size()) {
                    processSingleAccountActions(accounts.get(choice - 1));
                } else {
                    System.out.println("Invalid selection.");
                }
            }
            public void processSingleAccountActions(BankAccount account) {
                int atmAction;
                
                do {
                    Menu();  
                    System.out.print("ATM Actions: ");
                    atmAction = sc.nextInt();
            
                    switch (atmAction) {
                        case 1:  
                            System.out.print("Deposit Amount: ");
                            double depositAmount = sc.nextDouble();
                            account.depositKaching(depositAmount);
                            break;
            
                        case 2: 
                            System.out.print("Withdraw Amount: ");
                            double withdrawAmount = sc.nextDouble();
                            account.withdrawKaching(withdrawAmount);
                            break;
            
                        case 3: 
                            account.accDetails();
                            break;
            
                        case 4: 
                            System.out.println("Exiting ATM actions...");
                            break;
            
                        default:
                            System.out.println("Invalid action.");
                            break;
                    }
                } while (atmAction != 4);  
            }
            public void selectAndProcessAccount(ArrayList<? extends BankAccount> accounts) {
                if (accounts.size() == 1) {
                    
                    processSingleAccountActions(accounts.get(0));
                } else if (accounts.size() > 1) {
                 
                    System.out.println("Multiple accounts found. Please select an account to process:");
            
                    for (int i = 0; i < accounts.size(); i++) {
                        System.out.println((i + 1) + ". Account Holder: " + accounts.get(i).getAccountHolder() + ", Balance: " + accounts.get(i).getBalance());
                    }
            
                    System.out.print("Select account number: ");
                    int choice = sc.nextInt();
            
                    if (choice > 0 && choice <= accounts.size()) {
                        processSingleAccountActions(accounts.get(choice - 1)); 
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                } else {
                    System.out.println("No accounts available.");
                }
            }
            
            public void userActions() {
                int accountType;
                do {
                    System.out.println("Select Account Type:");
                    System.out.println("1. Savings Account");
                    System.out.println("2. Checking Account");
                    System.out.println("3. Business Account");
                    System.out.println("4. Exit");
            
                    accountType = sc.nextInt();
            
                    switch (accountType) {
                        case 1:
                            selectAndProcessAccount(savingsAccounts);
                            break;
            
                        case 2:
                            selectAndProcessAccount(checkingAccounts);
                            break;
            
                        case 3:
                            selectAndProcessAccount(businessAccounts);
                            break;
            
                        case 4:
                            System.out.println("Exiting...");
                            break;
            
                        default:
                            System.out.println("Invalid account type!");
                            break;
                    }
                } while (accountType != 4);
            }
            
            

    public static void main(String[] args){

        int input = 0;
        BankAccount bank = new BankAccount("", 0.0);
        
        do {
            bank.person();
            System.out.print("Action: ");
            input = sc.nextInt();

            switch (input) {
                case 1:
                sc.nextLine(); 
                bank.adminControl();
                System.out.print("Choices: ");
                int choices = 0;
                choices = sc.nextInt();

                if (choices == 1) {
                    int type;
                    do {
                        accType();
                        System.out.print("Type of Acc: ");
                        type = sc.nextInt();

                        switch (type) {
                            case 1:
                                bank.createSaveAcc();
                                break;
                            case 2:
                                bank.createCheckAcc();
                                break;
                            case 3:
                                bank.createBussAcc();
                                break;
                            case 4:
                                System.out.println("Exiting...");
                                break;
                            default:
                                System.out.println("Invalid account type!");
                                break;
                        }
                    } while (type != 4);
                }
                break;

                case 2:
                    sc.nextLine();
                    //String transac;
                    bank.userActions();
                    
                break;
                case 3:
                System.out.println("Thank you run again!");
                break;
                default: System.out.println("Invalid input!");
                    break;
            }
        } while (input != 3);
        

    }
}
