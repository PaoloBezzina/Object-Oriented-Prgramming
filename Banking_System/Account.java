//package BankingSystem;

public class Account {
    protected int accountId;
    protected double balance;
    protected Client owner;
    protected static int idGen = 1000;

    public Account() {
        balance = 0;
        accountId = idGen++;
    }

    public Account(double balance) {
        this.balance = balance;
        accountId = idGen++;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static int getidGen() {
        return idGen;
    }

    public static void setidGen(int idGen) {
        Account.idGen = idGen;
    }

    public boolean withdraw(double amountOfMoney) {

        if (amountOfMoney < 0) {
            System.err.println("invalid amount");
            return false;
        }
        if (amountOfMoney > balance) {
            System.err.println("balance is not sufficient");
            return false;
        }
        balance -= amountOfMoney;
        return true;
    }

    public boolean deposit(double amountOfMoney) {
        if (amountOfMoney <= 0) {
            System.err.println("invalid amount");
            return false;
        }
        balance += amountOfMoney;
        return true;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public void view() {
        System.out.println("account Id : " + accountId);
        System.out.println("balance : " + balance);
        owner.view();
    }
}