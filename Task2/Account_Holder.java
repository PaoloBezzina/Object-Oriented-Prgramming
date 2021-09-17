import java.util.ArrayList;

public class Account_Holder extends Person {

    public Account_Holder(String id, String name, String surname, String title, String role, String gender) {
        super(id, name, surname, title, role, gender);
        // TODO Auto-generated constructor stub
    }

    // Array list of accounts
    ArrayList<Account> userAccounts = new ArrayList<Account>();

    ArrayList<Account> getAccounts() {
        return userAccounts;
    }

    void initAccount() {
        // TODO init account(): void
        // create new account and add it to array list
        // addAcount();
        //Request_Open_Account
    }

    void addAcount(int accNo) {
        // TODO add account(): void
        // add account to arraylist
        Banking_System.accounts.get();
        userAccounts.add();
    }

    void viewBalance() {
        // TODO view balance(int): void
        // get balance of all bank accounts linked to this account holder
    }

    void viewInterest(int accountId) {
        System.out.println(userAccounts.get(accountId).getInterest());
    }

    void withdrawMoney(int accountId, double amount, String currency) {
        userAccounts.get(accountId).withdraw(amount, currency);
    }

    // TODO withdraw money(int, double): void
    // TODO deposit money(int, double): void
    // TODO move money(int, double, int): void
    // TODO directDebit(int, AccountHolder, double): void
    // TODO display accounts(int): void
    // TODO display account's cards(int): void
    // TODO display account transactions(int): void
    // TODO displayAllAccounts(): void
    // TODO findAccount(int): Account

}
