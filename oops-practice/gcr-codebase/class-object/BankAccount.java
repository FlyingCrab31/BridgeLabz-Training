class BankAccount {
    // Attributes
    String accountHolder;
    String accountNumber;
    double balance;
    
    // Constructor to initialize the BankAccount object
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    // Method to deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    
    // Method to withdraw money (only if sufficient balance exists)
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
    // Method to display the current balance
    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("\nState of Chennai\n");
        
        // Create a bank account object
        BankAccount account = new BankAccount("John Doe", "ACC001", 700.0);
        
        // Display initial balance
        account.displayBalance();
        
        // Deposit money
        account.deposit(200.0);
        account.displayBalance();
        
        // Withdraw money (sufficient balance)
        account.withdraw(100.0);
        account.displayBalance();
        
        // Try to withdraw more than available balance
        account.withdraw(1000.0);
    }
}
