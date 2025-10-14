package model;

public class PersonModel {
    protected int idPerson;
    protected String namePerson;
    protected String email;
    protected String password;
    protected String role;

    // Constructors
    public PersonModel(String namePerson, String email, String password, String role) {
        this.namePerson = namePerson;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public PersonModel(int idPerson, String namePerson, String email, String password, String role) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters & Setters
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
