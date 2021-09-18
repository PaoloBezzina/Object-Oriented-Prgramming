import java.util.Date;
import java.lang.Math;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Card {

    private String cardNo;
    private Account account;
    private String ownerName;
    private Account_Holder owner;
    private int cvv;
    private String expiryDateString;
    private Date expiryDate;

    public Card(Account acc, String name) {
        DateFormat dateFormat = new SimpleDateFormat("yy-mm");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 4);
        expiryDate = c.getTime();
        expiryDateString = dateFormat.format(expiryDate);
        cvv = (int) (Math.random() * (999) + 1);
        cardNo = String.valueOf((Math.random() * (99999999) + 1)); // TODO - fix leaves possible duplicate cardNo's
        cardNo += String.format("%04d", acc.bankCards.size());
        account = acc;
        ownerName = acc.owners.get(0).getFullName(); // TODO - fix only gets the name of the first owner
    }

    public Account getAccount() {
        return account;
    }

    public String getCardNo() {
        return cardNo;
    }

    public int getCvv() {
        return cvv;
    }

    public String getexpiryDateString() {
        return expiryDateString;
    }

    public Account_Holder getOwner() {
        return owner;
    }

    public String getOwnerName() {
        return ownerName;
    }

    boolean isValid() {
        Calendar today = Calendar.getInstance();
        Date todayDate = today.getTime();
        if (todayDate.compareTo(this.expiryDate) <= 0) {
            return true;
        } else {
            return false;
        }
    }

    void displayCard() {
        System.out.println("---------------------------");
        System.out.println("Account :" + getAccount());
        System.out.println("Card Number :" + getCardNo());
        System.out.println("CVV :" + getCvv());
        System.out.println("Expiry Date :" + getexpiryDateString());
        System.out.println("Owner :" + getOwnerName());
        System.out.println("---------------------------");
    }
}
