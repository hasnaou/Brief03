package models;

public class Admin {
    private String gmail;
    private String passWord;

    public Admin() {}

    public Admin(String gmail, String passWord) {
        this.gmail = gmail;
        this.passWord = passWord;
    }

    public String getGmail() { return gmail; }
    public void setGmail(String gmail) { this.gmail = gmail; }

    public String getPassWord() { return passWord; }
    public void setPassWord(String passWord) { this.passWord = passWord; }
}
