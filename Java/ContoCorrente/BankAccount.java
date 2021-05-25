import java.util.*;

public class BankAccount {
    //Attributes
    private static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>(); 
    private static double overdraft = 100;
    private double balance;
    private String owner;
    
    //Constructors
    BankAccount() {
        owner = "";
        balance = 0;
        accounts.add(this);
    }

    BankAccount(double balance) {
        owner = "";
        this.balance = Math.floor(balance * 100) / 100;;
        accounts.add(this);
    }

    BankAccount(String owner) {
        this.owner = owner;
        balance = 0;
        accounts.add(this);
    }

    BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = Math.floor(balance * 100) / 100;
        accounts.add(this);
    }

    BankAccount(BankAccount account) {
        owner = account.owner;
        balance = account.balance;
        accounts.add(this);
    }

    //<get> Methods
    String getOwner() {
        return owner;
    }

    double getBalance() {
        return balance;
    }

    //<set> Methods
    void setOwner(String owner) {
        this.owner = owner;
    }
    
    //Methods
    boolean equals(BankAccount account) {
        return account.owner == owner && account.balance == balance;
    }

    BankAccount copy() {
        return new BankAccount(owner, balance);
    }

    double deposit(double amount) {
        if(amount > 0) {
            balance += Math.floor(amount * 100) / 100;
        }
        return balance;
    }

    double withdraw(double amount) {
        if(amount > 0 && amount <= balance + overdraft) {
            balance -= Math.floor(amount * 100) / 100;
        }
        return balance;
    }

    double transfer(BankAccount receiver, double amount) {
        if(amount > 0 && amount <= balance + overdraft && !receiver.getOwner().isEmpty()) {
            this.withdraw(amount);
            receiver.deposit(amount);
        }
        return balance;
    }

    double transfer(String receiver, double amount) {
        if(amount > 0 && amount <= balance + overdraft && !receiver.isEmpty()) {
            for(int i = 0; i < accounts.size(); i++) {
                if(accounts.get(i).owner == receiver) {
                    this.withdraw(amount);
                    accounts.get(i).deposit(amount);
                    break;
                }
            }
        }
        return balance;
    }
}