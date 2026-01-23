
import java.util.*;

class WithdrawalRequest {

    private String accountNumber;
    private double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Withdrawal{" + accountNumber + ", amount=" + amount + "}";
    }
}

public class BankingSystem {

    // AccountNumber -> Balance
    private Map<String, Double> accounts = new HashMap<>();

    // Queue for withdrawal requests
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Create or update account
    public void createOrUpdateAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    // Enqueue a withdrawal request
    public void requestWithdrawal(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Unknown account: " + accountNumber);
            return;
        }
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    }

    // Process all withdrawal requests in FIFO order
    public void processWithdrawals() {
        System.out.println("Processing withdrawals (FIFO):");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.remove();
            String acc = req.getAccountNumber();
            double amount = req.getAmount();
            double balance = accounts.getOrDefault(acc, 0.0);

            if (balance >= amount) {
                accounts.put(acc, balance - amount);
                System.out.println("Approved " + req
                        + " | New balance: " + accounts.get(acc));
            } else {
                System.out.println("Declined " + req
                        + " | Insufficient funds. Current balance: " + balance);
            }
        }
        System.out.println();
    }

    // Display customers sorted by balance (ascending) using TreeMap
    public void displayCustomersSortedByBalance() {
        TreeMap<Double, List<String>> balanceMap = new TreeMap<>();

        for (Map.Entry<String, Double> e : accounts.entrySet()) {
            String accountNumber = e.getKey();
            double balance = e.getValue();
            balanceMap
                    .computeIfAbsent(balance, k -> new ArrayList<>())
                    .add(accountNumber);
        }

        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, List<String>> e : balanceMap.entrySet()) {
            double balance = e.getKey();
            for (String acc : e.getValue()) {
                System.out.println(acc + " -> " + balance);
            }
        }
        System.out.println();
    }

    // Simple view of accounts (HashMap)
    public void displayAccounts() {
        System.out.println("All accounts (HashMap view):");
        for (Map.Entry<String, Double> e : accounts.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // 1. Create accounts (HashMap)
        bank.createOrUpdateAccount("A100", 1000.0);
        bank.createOrUpdateAccount("A200", 2500.0);
        bank.createOrUpdateAccount("A300", 1500.0);

        bank.displayAccounts();

        // 2. Queue withdrawal requests (Queue)
        bank.requestWithdrawal("A100", 300.0);
        bank.requestWithdrawal("A200", 3000.0); // should fail
        bank.requestWithdrawal("A300", 500.0);
        bank.requestWithdrawal("A100", 800.0);  // may fail depending on balance

        // 3. Process withdrawals in FIFO
        bank.processWithdrawals();

        // 4. Show accounts after withdrawals
        bank.displayAccounts();

        // 5. Show customers sorted by balance (TreeMap)
        bank.displayCustomersSortedByBalance();
    }
}
