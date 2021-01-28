public class Banking_System {
    
    ArrayList<Regular_User> regularUsers = new ArrayList<Regular_User>();
    ArrayList<Administrator> admins = new ArrayList<Administrator>();
    ArrayList<Account_Holder> accountHolders = new ArrayList<Account_Holder>();
    ArrayList<Account> accounts = new ArrayList<Account>();
    ArrayList<Card> cards = new ArrayList<Card>();
    //boolean disabled;

    /*
    displayAll(String): void
    checkIdNo(int, String): void
    assignAccount(int, int[]): void
    removeAccount(int, int, int): void
    addCard(int, AccountHolder, Account, String): void
    removeCard(int, int, String): void
    findAccHolder(int): void
    findRegUser(int): void
    findAdmin(int): void
    findAccount(int): void
    findCard(String): void
    removeAccFromOwners(Account): void
    removeCardFromAcc(Card): void
    viewAccHolAction(int, int, String): void
    ATM(int, int, String, double): void
    moveMoney(int, int, int, double): void
    cont.....
    */
    public void addNewPerson(String id, String name, String surname, String title, String role, String gender){
        Person person = new Person(id, name, surname, title, role, gender); // Creating a new object
        regularUsers.add(person); // Adding it to the list
    }

    public void addAccount(int, int, int[], int, double, String, String){
        
    }
}
