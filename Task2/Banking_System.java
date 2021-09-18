import java.util.ArrayList;

public class Banking_System {

    ArrayList<Regular_User> regularUsers = new ArrayList<Regular_User>();
    ArrayList<Administrator> admins = new ArrayList<Administrator>();
    ArrayList<Account_Holder> accountHolders = new ArrayList<Account_Holder>();
    ArrayList<Account> accounts = new ArrayList<Account>();
    ArrayList<Card> cards = new ArrayList<Card>();
    boolean disabled; // for bank holidays

    public void addNewPerson(String id, String name, String surname, String title, String role, String gender) {
        Regular_User person = new Regular_User(id, name, surname, title, role, gender); // Creating a new object
        this.regularUsers.add(person); // Adding it to the list
    }

    // public void addAccount(int, int, int[], int, double, String, String){
    public void initAccount(double balance, String currency, boolean type, ArrayList<Account_Holder> owners) {
        Account account = new Account(balance, currency, type, owners);
        addAccount(account);
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    // TODO addAccount(int, int, int[], int, double, String, String): void
    // TODO displayAll(String): void
    // TODO checkIdNo(int, String): void
    // TODO assignAccount(int, int[]): void
    // TODO removeAccount(int, int, int): void
    // TODO addCard(int, AccountHolder, Account, String): void
    // TODO removeCard(int, int, String): void
    // TODO findAccHolder(int): void
    // TODO findRegUser(int): void
    // TODO findAdmin(int): void
    // TODO findAccount(int): void
    // TODO findCard(String): void
    // TODO removeAccFromOwners(Account): void
    // TODO removeCardFromAcc(Card): void
    // TODO viewAccHolAction(int, int, String): void
    // TODO ATM(int, int, String, double): void
    // TODO moveMoney(int, int, int, double): void

}
