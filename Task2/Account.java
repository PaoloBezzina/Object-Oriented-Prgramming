
// can be abstract?
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {

    int accNo;
    double balance;
    boolean type; // t for current, f for savings
    float interest;
    String currency;
    ArrayList<Account_Holder> owners = new ArrayList<Account_Holder>();
    ArrayList<Card> bankCards = new ArrayList<Card>();

    public static Map<String, Double> currencies = new HashMap<String, Double>();
    static {
        currencies.put("EUR", 1.0);
        currencies.put("USD", 1.18131);
        currencies.put("GBP", 0.85431);
        currencies.put("CAD", 1.49601);
        currencies.put("YEN", 129.26);
        currencies.put("CHF", 1.08582);
    }

    public Account(double balance, String currency, boolean type, ArrayList<Account_Holder> owners) {
        setAccNo((int) ((Math.random() * (99999999) + 1))); // TODO - fix leaves possible duplicate accNo's
        addAccountHolders(owners);
        setBalance(balance);
        setCurrency(currency);
        setType(type);
    }

    public Account(double balance, String currency, boolean type, ArrayList<Account_Holder> owners, float interest) {
        setAccNo((int) ((Math.random() * (99999999) + 1))); // TODO - fix leaves possible duplicate accNo's
        addAccountHolders(owners);
        setInterest(interest);
        setBalance(balance);
        setCurrency(currency);
        setType(type);
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public void addAccountHolders(ArrayList<Account_Holder> users) {
        for (Account_Holder account_Holder : users) {
            this.owners.add(account_Holder);
        }
    }

    public void addAccountHolder(Account_Holder user) {
        this.owners.add(user);
    }

    public void removeAccountHolder(Account_Holder user) {
        this.owners.remove(user);
    }

    public int getAccNo() {
        return accNo;
    }

    public float getInterest() {
        return interest;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Card> getbankCards() {
        return bankCards;
    }

    public String getCurrency() {
        return currency;
    }

    public ArrayList<Account_Holder> getOwners() {
        return owners;
    }

    void viewBalance() {
        System.out.println("Balance: " + balance);
    }

    void viewInterest() {
        System.out.println("Interest: " + interest);
    }

    void displayCard(int index) {
        System.out.println("---------- Card ----------");
        bankCards.get(index).displayCard();
        System.out.println("---------------------------");
    }

    void displayAllCards() {
        System.out.println("---------- Cards ----------");
        for (Card card : bankCards) {
            card.displayCard();
        }
        System.out.println("---------------------------");
    }

    void deposit(double amount, String currency) {
        double exchangeRate;
        try {
            exchangeRate = currencies.get(currency);
        } catch (Exception e) {
            System.out.println("Unkown currency");
            exchangeRate = 1.0;
        }

        double depositAmount = amount * exchangeRate;
        this.balance += depositAmount;
        System.out.println("---------------------------");
        System.out.println("Your new balance is " + balance);
        System.out.println("---------------------------");

        for (Account_Holder owner : owners) {
            owner.addAction("Deposited " + depositAmount + " " + currency);
        }
    }

    void withdraw(double amount, String currency) {
        double exchangeRate;
        try {
            exchangeRate = currencies.get(currency);
        } catch (Exception e) {
            System.out.println("Unkown currency");
            exchangeRate = 1.0;
        }

        double ammountWithdrawn = amount * exchangeRate;
        this.balance -= (ammountWithdrawn);
        System.out.println("---------------------------");
        System.out.println("Your new balance is " + balance);
        System.out.println("Yout withdrew " + ammountWithdrawn + " " + currency);
        System.out.println("---------------------------");

        for (Account_Holder owner : owners) {
            owner.addAction("Withdrew " + ammountWithdrawn + " " + currency);
        }
    }

    // TODO directCredit(double, String): void
    // TODO directDebit(double, String, String): void
    // TODO displayTransactions(): void
    // TODO addCard()
    // TODO ca...(): double addD...(): void

}