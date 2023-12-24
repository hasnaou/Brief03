package models;

public class Client {
    private int id;
    private String firstName;
    private String lastName;
    private int tele;
    private String mail;

    public Client(){}
    public Client(String firstName, String lastName, int tele, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tele = tele;
        this.mail = mail;
    }


    public Client(int id, String firstName, String lastName, int tele, String mail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tele = tele;
        this.mail = mail;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getTele() { return tele; }
    public void setTele(int tele) { this.tele = tele; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tele=" + tele +
                ", mail='" + mail + '\'' +
                '}';
    }
}
