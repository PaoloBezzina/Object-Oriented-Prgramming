import java.util.ArrayList;

public class Account_Holder extends Person {

    public Account_Holder(String id, String name, String surname, String title, String role, String gender) {
        super(id, name, surname, title, role, gender);
    }

    // Array list of accounts
    ArrayList<Account> userAccounts = new ArrayList<Account>();

    ArrayList<Account> getAccounts() {
        return userAccounts;
    }

    // create new account and add it to array list
    void initAccount(double balance, String currency, boolean type, ArrayList<Account_Holder> owners) {
        Account newAccount = new Account(balance, currency, type, owners);
        userAccounts.add(newAccount);
    }

    // add account to arraylist
    void addAcount(int accNo) {
        userAccounts.add(userAccounts.get(accNo));
    }

    // get balance of all bank accounts linked to this account holder
    void viewBalance() {
        System.out.println("---------------------------");
        for (Account account : userAccounts) {
            System.out.println(account.getAccNo() + ": " + account.getBalance());
        }
        System.out.println("---------------------------");
    }

    // get all bank accounts linked to this account holder
    void viewAccounts() {
        System.out.println("---------------------------");
        for (Account account : userAccounts) {
            System.out.println(account.getAccNo());
        }
        System.out.println("---------------------------");
    }

    // get all bank cards linked to this account holder
    void viewCards() {
        System.out.println("---------------------------");
        for (Account account : userAccounts) {
            System.out.println(account.getAccNo() + ": " + account.getbankCards());
        }
        System.out.println("---------------------------");
    }

    void viewInterest(int accountId) {
        System.out.println(userAccounts.get(accountId).getInterest());
    }

    void withdrawMoney(int accountId, double amount, String currency) {
        userAccounts.get(accountId).withdraw(amount, currency);
    }

    void depositMoney(int accountId, double amount, String currency) {
        userAccounts.get(accountId).deposit(amount, currency);
    }

    void transferMoney(int accountId, int recipientID, double amount, String currency) {
        userAccounts.get(accountId).withdraw(amount, currency);
        userAccounts.get(recipientID).deposit(amount, currency);
    }
}
