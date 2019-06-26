/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

    public int balance;
    public Account parentAccount;

    /** Initialize an account with the given balance. */
    public Account(int balance) {
        this.balance = balance;
        this.parentAccount = null;
    }
    public Account(int balance, Account parentAccount) {
        this.balance = balance;
        this.parentAccount = parentAccount;

    }
    /** Deposits amount into the current account. */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract amount from the account if possible. If subtracting amount
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) {
        // TODO
        if (amount < 0) {
            System.out.println("Cannot withdraw negative amount.");
            return false;
        } else if (this.parentAccount == null && this.balance < amount) {
            System.out.println("Insufficient funds");
            return false;
        } else if (this.balance < amount) {
            if (parentAccount.balance >= amount - this.balance) {
                System.out.println("Thank your parents");
                amount -= this.balance;
                this.balance = 0;
                parentAccount.withdraw(amount);
                return true;
            } else {
              parentAccount.withdraw(amount);
              return false;
            }
        } else {
            this.balance -= amount;
            return true;
        }
    }

    /**
     * Merge account other into this account by removing all money from other
     * and depositing it into this account.
     */
    public void merge(Account other) {
        // TODO
        this.balance += other.balance;
        other.balance = 0;
    }
}
