import java.util.ArrayList;

public class Current_Account extends Account {

    static float currentInterest = 0.0f;

    public Current_Account(double balance, String currency, boolean type, ArrayList<Account_Holder> owners) {
        super(balance, currency, type, owners, currentInterest);
        this.setcheckBookNo((int) ((Math.random() * (99999999) + 1)));
    }

    int checkBookNo;

    public void setcheckBookNo(int checkBookNo) {
        this.checkBookNo = checkBookNo;
    }

    public int getcheckBookNo() {
        return checkBookNo;
    }
}
