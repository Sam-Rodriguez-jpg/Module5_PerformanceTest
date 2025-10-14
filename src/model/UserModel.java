package model;

public class UserModel extends PersonModel{
    private int idUser;

    // Constructor
    public UserModel(int idPerson, String namePerson, String email, String password, String role, int idUser) {
        super(idPerson, namePerson, email, password, role);
        this.idUser = idUser;
    }

    // Getters & Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getInformation() {
        return "ID Person: #" + getIdPerson() + " - ID User: #" + getIdUser() + " - Rol: " + getRole() + " - Person Name: " + getNamePerson() + " - Email: " + getEmail();
    }
}
