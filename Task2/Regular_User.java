import java.util.ArrayList;

public class Regular_User extends User {

    public Regular_User(String id, String name, String surname, String title, String role, String gender) {
        super(id, name, surname, title, role, gender);
    }

    ArrayList<Request> requests = new ArrayList<Request>();

    // requests open account
    void requestOpenAccount() {
        Request_Open_Account req = new Request_Open_Account();
        req.requestedBy = this.id;
        requests.add(req);
    }

    // requests close account
    void requestCloseAccount() {
        Request_Close_Account req = new Request_Close_Account();
        req.requestedBy = this.id;
        requests.add(req);
    }

    // requests new card
    void requestNewCard() {
        Request_New_Card req = new Request_New_Card();
        req.requestedBy = this.id;
        requests.add(req);
    }

    // request cancel card
    void requestCancelCard() {
        Request_Close_Card req = new Request_Close_Card();
        req.requestedBy = this.id;
        requests.add(req);
    }
}
