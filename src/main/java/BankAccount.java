public class BankAccount {
    int balance;

    // 1. CONSTRUCTOR: Set the starting money
    public BankAccount(int openingBalance) {
        balance = openingBalance;
    }

    // 2. VOID METHOD: Add money
    public void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }

    // 3. RETURN METHOD: Send the balance back to main
    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        // Open account with 1000
        BankAccount myAcc = new BankAccount(250000);

        // Deposit 500
        myAcc.deposit(500);

        // Check Balance
        System.out.println("Final Balance: " + myAcc.getBalance());
    }
}