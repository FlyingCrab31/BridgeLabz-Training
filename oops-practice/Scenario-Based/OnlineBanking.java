import java.util.*;
// Custom exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Abstract base account
abstract class Account {
    private final String accountNumber;
    private final String holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double openingBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = openingBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited: " + amount +
                    ", new balance: " + balance);
        }
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) return;
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance. Available: " + balance);
        }
        balance -= amount;
        System.out.println(holderName + " withdrew: " + amount +
                ", new balance: " + balance);
    }

    public abstract void applyInterest(); // polymorphic
}

// SavingsAccount with interest
class SavingsAccount extends Account {
    private final double interestRate; // e.g. 0.04 = 4% yearly 

    public SavingsAccount(String accountNumber, String holderName,
                          double openingBalance, double interestRate) {
        super(accountNumber, holderName, openingBalance);
        this.interestRate = interestRate;
    }

    @Override
    public synchronized void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println(getHolderName() + " savings interest added: " +
                interest + ", new balance: " + balance);
    }
}

// CurrentAccount (no interest, simple overdraft rule)
class CurrentAccount extends Account {
    private final double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName,
                          double openingBalance, double overdraftLimit) {
        super(accountNumber, holderName, openingBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) return;
        if (balance + overdraftLimit < amount) {
            throw new InsufficientBalanceException(
                    "Overdraft limit exceeded. Available (with overdraft): " + (balance + overdraftLimit));
        }
        balance -= amount;
        System.out.println(getHolderName() + " (current) withdrew: " + amount +
                ", new balance: " + balance);
    }

    @Override
    public void applyInterest() {
        // Typically no interest for current accounts
        System.out.println(getHolderName() + " current account: no interest applied.");
    }
}

interface BankService {
    Account createSavings(String accNo, String name, double openingBalance, double rate);
    Account createCurrent(String accNo, String name, double openingBalance, double overdraftLimit);
    double getBalance(String accNo);
    void transfer(String fromAcc, String toAcc, double amount) throws InsufficientBalanceException;
    void printTransactionHistory(String accNo);
}

// Simple transaction record
class Transaction {
    private final Date time;
    private final String type;
    private final double amount;
    private final double resultingBalance;

    public Transaction(String type, double amount, double resultingBalance) {
        this.time = new Date();
        this.type = type;
        this.amount = amount;
        this.resultingBalance = resultingBalance;
    }

    @Override
    public String toString() {
        return time + " | " + type + " | " + amount + " | balance: " + resultingBalance;
    }
}

// Thread-safe BankService implementation
class SimpleBankService implements BankService {
    private final Map<String, Account> accounts = new HashMap<>();
    private final Map<String, List<Transaction>> history = new HashMap<>();

    @Override
    public synchronized Account createSavings(String accNo, String name,
                                              double openingBalance, double rate) {
        Account acc = new SavingsAccount(accNo, name, openingBalance, rate);
        accounts.put(accNo, acc);
        history.put(accNo, new ArrayList<>());
        return acc;
    }

    @Override
    public synchronized Account createCurrent(String accNo, String name,
                                              double openingBalance, double overdraftLimit) {
        Account acc = new CurrentAccount(accNo, name, openingBalance, overdraftLimit);
        accounts.put(accNo, acc);
        history.put(accNo, new ArrayList<>());
        return acc;
    }

    @Override
    public double getBalance(String accNo) {
        Account acc = accounts.get(accNo);
        return acc != null ? acc.getBalance() : 0.0;
    }

    private void record(String accNo, String type, double amount, double resultingBalance) {
        history.get(accNo).add(new Transaction(type, amount, resultingBalance));
    }

    @Override
    public void transfer(String fromAccNo, String toAccNo, double amount)
            throws InsufficientBalanceException {

        if (fromAccNo.equals(toAccNo)) return;

        Account from = accounts.get(fromAccNo);
        Account to = accounts.get(toAccNo);
        if (from == null || to == null) {
            System.out.println("One of the accounts does not exist.");
            return;
        }

        Account firstLock = fromAccNo.compareTo(toAccNo) < 0 ? from : to;
        Account secondLock = firstLock == from ? to : from;

        synchronized (firstLock) {
            synchronized (secondLock) {
                from.withdraw(amount);
                to.deposit(amount);
                record(fromAccNo, "TRANSFER_OUT", amount, from.getBalance());
                record(toAccNo, "TRANSFER_IN", amount, to.getBalance());
                System.out.println("Transfer of " + amount + " from " +
                        fromAccNo + " to " + toAccNo + " successful.");
            }
        }
    }

    @Override
    public void printTransactionHistory(String accNo) {
        List<Transaction> txList = history.get(accNo);
        if (txList == null) {
            System.out.println("No such account.");
            return;
        }
        System.out.println("Transaction history for account " + accNo + ":");
        for (Transaction tx : txList) {
            System.out.println(tx);
        }
    }
}
public  class OnlineBanking {
    public static void main(String[] args) {
        SimpleBankService bank = new SimpleBankService();

        // Account creation (CRUD - Create)
        bank.createSavings("S1001", "Rishabh", 10000, 0.04);
        bank.createCurrent("C2001", "Amit", 5000, 2000);

        System.out.println("Initial balances:");
        System.out.println("S1001: " + bank.getBalance("S1001"));
        System.out.println("C2001: " + bank.getBalance("C2001"));

        Runnable task1 = () -> {
            try {
                bank.transfer("S1001", "C2001", 2000);
            } catch (InsufficientBalanceException e) {
                System.out.println("Task1 failed: " + e.getMessage());
            }
        };

        Runnable task2 = () -> {
            try {
                bank.transfer("C2001", "S1001", 1500);
            } catch (InsufficientBalanceException e) {
                System.out.println("Task2 failed: " + e.getMessage());
            }
        };

        Thread t1 = new Thread(task1, "T1");
        Thread t2 = new Thread(task2, "T2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal balances:");
        System.out.println("S1001: " + bank.getBalance("S1001"));
        System.out.println("C2001: " + bank.getBalance("C2001"));

        System.out.println("\nTransaction histories:");
        bank.printTransactionHistory("S1001");
        bank.printTransactionHistory("C2001");
    }
}

