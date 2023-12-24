package models;

import java.util.Date;

public class Command {
    private int id;
    private Date dateCmd;
    private double priceTtc;
    private boolean etat;

    public Command() {}

    public Command(int id, Date dateCmd, double priceTtc, boolean etat) {
        this.id = id;
        this.dateCmd = dateCmd;
        this.priceTtc = priceTtc;
        this.etat = etat;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDateCmd() { return dateCmd; }
    public void setDateCmd(Date dateCmd) { this.dateCmd = dateCmd; }

    public double getPriceTtc() { return priceTtc; }
    public void setPriceTtc(double priceTtc) { this.priceTtc = priceTtc; }

    public boolean isEtat() { return etat; }
    public void setEtat(boolean etat) { this.etat = etat; }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", dateCmd=" + dateCmd +
                ", priceTtc=" + priceTtc +
                ", etat=" + etat +
                '}';
    }
}
