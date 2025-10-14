package model;

import java.time.LocalDateTime;

public class LoanModel {
    private int idLoan;
    private int idUser;
    private int idPartner;
    private int idBook;
    private LocalDateTime dateLoan;
    private LocalDateTime dateReturn;
    private boolean returned;

    public LoanModel(int idLoan, int idUser, int idPartner, int idBook, LocalDateTime dateLoan, LocalDateTime dateReturn, boolean returned) {
        this.idLoan = idLoan;
        this.idUser = idUser;
        this.idPartner = idPartner;
        this.idBook = idBook;
        this.dateLoan = dateLoan;
        this.dateReturn = dateReturn;
        this.returned = returned;
    }

    public int getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(int idLoan) {
        this.idLoan = idLoan;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(int idPartner) {
        this.idPartner = idPartner;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public LocalDateTime getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(LocalDateTime dateLoan) {
        this.dateLoan = dateLoan;
    }

    public LocalDateTime getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDateTime dateReturn) {
        this.dateReturn = dateReturn;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public String getInformation() {
        return "ID Loan: #" + getIdLoan() + " - ID User: #" + getIdUser() + " - ID Partner: #" + getIdPartner() + " - ID Book: #" + getIdBook() + " - Loan Date: " + getDateLoan() + " - Return Date: " + getDateReturn() + " - Returned: " + isReturned();
    }
}
