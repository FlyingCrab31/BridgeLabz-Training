import java.time.LocalDateTime;
import java.util.*;

// Custom exception for low balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

enum TransactionType {
    DEPOSIT,
    WITHDRAW,
    TRANSFER_IN,
    TRANSFER_OUT,
    BANK_TRANSFER
}

class User {
    private final String id;
    private final String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}

class Transaction {
    private final String id;
    private final String fromWalletId; // null for deposit/bank-in
    private final String toWalletId;   // null for withdraw/bank-out
    private final double amount;
    private final TransactionType type;
    private final LocalDateTime timestamp;

    public Transaction(String id, String fromWalletId, String toWalletId,
                       double amount, TransactionType type) {
        this.id = id;
        this.fromWalletId = fromWalletId;
        this.toWalletId = toWalletId;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getFromWalletId() { return fromWalletId; }
    public String getToWalletId() { return toWalletId; }
    public double getAmount() { return amount; }
    public TransactionType getType() { return type; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Txn{" + id + ", type=" + type +
               ", from=" + fromWalletId +
               ", to=" + toWalletId +
               ", amt=" + amount +
               ", at=" + timestamp + "}";
    }
}

class Wallet {
    private final String id;
    private final User user;
    private double balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Wallet(String id, User user) {
        this.id = id;
        this.user = user;
        this.balance = 0.0;
    }

    public String getId() { return id; }
    public User getUser() { return user; }
    public double getBalance() { return balance; }
    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance in wallet " + id);
        }
        balance -= amount;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }
}

// Abstraction for transfers
interface TransferService {
    void transfer(String sourceWalletId,
                  String targetWalletId,
                  double amount) throws InsufficientBalanceException;
}

// Wallet-to-wallet transfer
class WalletToWalletTransferService implements TransferService {

    private final DigitalWalletPlatform platform;

    public WalletToWalletTransferService(DigitalWalletPlatform platform) {
        this.platform = platform;
    }

    @Override
    public void transfer(String sourceWalletId,
                         String targetWalletId,
                         double amount) throws InsufficientBalanceException {
        Wallet from = platform.getWallet(sourceWalletId);
        Wallet to = platform.getWallet(targetWalletId);

        from.withdraw(amount); // may throw InsufficientBalanceException
        to.deposit(amount);

        String txnId = platform.nextTxnId();
        Transaction outTxn = new Transaction(
                txnId + "-OUT", from.getId(), to.getId(),
                amount, TransactionType.TRANSFER_OUT);
        Transaction inTxn = new Transaction(
                txnId + "-IN", from.getId(), to.getId(),
                amount, TransactionType.TRANSFER_IN);

        from.addTransaction(outTxn);
        to.addTransaction(inTxn);
    }
}

// Bank transfer (e.g., withdraw to bank or load from bank)
class BankTransferService implements TransferService {

    private final DigitalWalletPlatform platform;

    public BankTransferService(DigitalWalletPlatform platform) {
        this.platform = platform;
    }

    // Here: sourceWalletId -> wallet, targetWalletId ignored / bank reference
    @Override
    public void transfer(String sourceWalletId,
                         String targetWalletId,
                         double amount) throws InsufficientBalanceException {
        Wallet from = platform.getWallet(sourceWalletId);
        from.withdraw(amount);  // debit wallet

        String txnId = platform.nextTxnId();
        Transaction bankTxn = new Transaction(
                txnId + "-BANK", from.getId(), null,
                amount, TransactionType.BANK_TRANSFER);
        from.addTransaction(bankTxn);

        // In a real system, call bank API here.
        System.out.println("Bank transfer of " + amount +
                           " from wallet " + sourceWalletId + " initiated.");
    }
}

class DigitalWalletPlatform {
    private final Map<String, Wallet> wallets = new HashMap<>();
    private int txnSequence = 1;

    public Wallet createWallet(String walletId, User user) {
        Wallet wallet = new Wallet(walletId, user);
        wallets.put(walletId, wallet);
        return wallet;
    }

    public Wallet getWallet(String walletId) {
        Wallet w = wallets.get(walletId);
        if (w == null) {
            throw new IllegalArgumentException("Wallet not found: " + walletId);
        }
        return w;
    }

    public String nextTxnId() {
        return "TXN-" + (txnSequence++);
    }

    // Add money (e.g., from bank)
    public void addMoney(String walletId, double amount) {
        Wallet w = getWallet(walletId);
        w.deposit(amount);
        Transaction t = new Transaction(
                nextTxnId(), null, walletId,
                amount, TransactionType.DEPOSIT);
        w.addTransaction(t);
    }

    // Withdraw money (e.g., cash-out)
    public void withdrawMoney(String walletId, double amount)
            throws InsufficientBalanceException {
        Wallet w = getWallet(walletId);
        w.withdraw(amount);
        Transaction t = new Transaction(
                nextTxnId(), walletId, null,
                amount, TransactionType.WITHDRAW);
        w.addTransaction(t);
    }

    // Transaction tracking
    public void printStatement(String walletId) {
        Wallet w = getWallet(walletId);
        System.out.println("=== Statement for wallet " + walletId +
                           " (" + w.getUser().getName() + ") ===");
        System.out.println("Current balance: " + w.getBalance());
        for (Transaction t : w.getTransactions()) {
            System.out.println(t);
        }
        System.out.println("==============================");
    }
}

public class DigitalWallet {
    public static void main(String[] args) {
        DigitalWalletPlatform platform = new DigitalWalletPlatform();

        // User & wallet creation
        User u1 = new User("U1", "Rishabh");
        User u2 = new User("U2", "Aman");
        Wallet w1 = platform.createWallet("W1", u1);
        Wallet w2 = platform.createWallet("W2", u2);

        // Add money to wallet W1
        platform.addMoney("W1", 1000);

        // Transfer services
        TransferService walletTransfer = new WalletToWalletTransferService(platform);
        TransferService bankTransfer = new BankTransferService(platform);

        try {
            // Wallet-to-wallet transfer
            walletTransfer.transfer("W1", "W2", 300);

            // Bank transfer out (from W2 to bank)
            bankTransfer.transfer("W2", "BANK-ACC-123", 100);

            // Attempt to overdraw
            walletTransfer.transfer("W2", "W1", 1000); // should throw InsufficientBalanceException

        } catch (InsufficientBalanceException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        // Transaction tracking
        platform.printStatement("W1");
        platform.printStatement("W2");
    }
}
