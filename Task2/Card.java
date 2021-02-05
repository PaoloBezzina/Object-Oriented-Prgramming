import java.util.Date;
import java.util.Calendar;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  

public class Card {
    
    String cardNo;
    Account account;
    String owner;
    int cvv;
    String expiryDate;

    public Card(Account acc, String name){
        numberOfCards++;
        DateFormat dateFormat = new SimpleDateFormat("yy-mm");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 4);
        Date date = c.getTime();
        expiryDate = dateFormat.format(date);
        cvv = (Math.random() * (999) +1);
        cardNo = (Math.random() * (99999999) +1);
        cardNo += String.format("%04d", numberOfCards);
        account = acc;
        owner = name;
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
    public String getExpiryDate() {
        return expiryDate;
    }
    public AccountHolder getOwner() {
        return owner;
    }

    //'check' ExpDate: String
    //displayCard(): void
}
