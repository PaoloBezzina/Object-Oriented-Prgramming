public class Account {
    
    int accNo;
    double balance;
    boolean type;   //t for current, f for savings
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


    /*
    view balance(): void
    viewInterest(): void
    deposit(double, string): void

    directCredit(double, String): void
    directDebit(double, String, String): void
    displayCard(int): void
    displayAllCards(): void
    displayTransactions(): void
    ca...(): double
    addD...(): void
    */
}
