public class Account {

    int accNo;
    double balance;
    boolean type; // t for current, f for savings
    String currency;
    ArrayList<String> userAccounts = new ArrayList<String>();
    ArrayList<Integer> owners = new ArrayList<Integer>();
    ArrayList<Card> bankCard = new ArrayList<Card>();

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

    public int getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Card> getBankCard() {
        return bankCard;
    }

    public String getCurrency() {
        return currency;
    }

    public ArrayList<Integer> getOwners() {
        return owners;
    }

    public ArrayList<String> getUserAccounts() {
        return userAccounts;
    }

    // TODO view balance(): void
    // TODO viewInterest(): void
    // TODO deposit(double, string): void
    // TODO directCredit(double, String): void
    // TODO directDebit(double, String, String): void
    // TODO displayCard(int): void
    // TODO displayAllCards(): void
    // TODO displayTransactions(): void
    // TODO ca...(): double addD...(): void

}