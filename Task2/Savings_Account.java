import java.util.ArrayList;

public class Savings_Account extends Account {

    static float savingsInterest = 4.1f;

    public Savings_Account(double balance, String currency, boolean type, ArrayList<Account_Holder> owners) {
        super(balance, currency, type, owners, savingsInterest);
    }

    double savingsRate;
}
