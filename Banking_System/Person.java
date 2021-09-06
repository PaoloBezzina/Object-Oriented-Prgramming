import java.util.ArrayList;

public class Person {
    
    //int no;
    String id;
    String name;
    String surname;
    String title;
    String role;
    String gender;
    ArrayList<String> actions = new ArrayList<String>();

    //constructor
    public Person(String id, String name, String surname, String title, String role, String gender){
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
        setRole(role);
        setTitle(title);
    }
    
    //Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //Getters
    public String getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getGender() {
        return gender;
    }
    public String getRole() {
        return role;
    }
    public String getTitle() {
        return title;
    }
    public String getFullName() {
        return name + surname;
    }

    public ArrayList<String> getActions() {
        return actions;
    }


    
    public void initActions(){

    }

    public void addAction(){

    }

    public void displayActions(){

    }

    public void personDetails(){

    }
    
}
