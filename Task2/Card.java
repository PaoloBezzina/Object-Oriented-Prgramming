import java.security.acl.Owner;

public class Card {
    
    String cardNo;
    int cvv;
    String expiryDate;
    AccountHolder owner;
    Account acc;

    public void setAcc(Account acc) {
        this.acc = acc;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public void setOwner(AccountHolder owner) {
        this.owner = owner;
    }


    public Account getAcc() {
        return acc;
    }
    public String getCardNo() {
        return cardNo;
    }
    public int getCvv() {
        return cvv;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public AccountHolder getOwner() {
        return owner;
    }

    //...CVV(): void
    //'check' ExpDate: String
    //displayCard(): void
}
