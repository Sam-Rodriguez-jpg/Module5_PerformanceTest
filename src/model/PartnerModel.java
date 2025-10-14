package model;

public class PartnerModel extends PersonModel{
    private int idPartner;
    private String status;

    // Constructor
    public PartnerModel(int idPerson, String namePerson, String email, String password, String role, int idPartner, String status) {
        super(idPerson, namePerson, email, password, role);
        this.idPartner = idPartner;
        this.status = status;
    }

    // Getters & Setters
    public int getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(int idPartner) {
        this.idPartner = idPartner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getInformation() {
        return "ID Person: #" + getIdPerson() + " - ID Partner: #" + getIdPartner() + " - Rol: " + getRole() + " - Name: " + getNamePerson() + " - Email: " + getEmail();
    }
}
