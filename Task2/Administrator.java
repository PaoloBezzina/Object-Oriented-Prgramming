public class Administrator extends User {

    public Administrator(String id, String name, String surname, String title, String role, String gender) {
        super(id, name, surname, title, role, gender);
    }

    // method to change the status of an open account request to approved
    void approveOpenAccount(Request_Open_Account request) {
        request.approved = true;
        request.approvedBy = this.getID();
    }

    // method to change the status of a close account request to approved
    void approveCloseAccount(Request_Close_Account request) {
        request.approved = true;
        request.approvedBy = this.getID();
    }

    // method to change the status of a new card request to approved
    void approveNewCard(Request_New_Card request) {
        request.approved = true;
        request.approvedBy = this.getID();
    }

    // method to change the status of a close card request to approved
    void approveCloseCard(Request_Close_Card request) {
        request.approved = true;
        request.approvedBy = this.getID();
    }
}
