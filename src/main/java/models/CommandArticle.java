package models;

public class CommandArticle {
    private int idCmd;
    private int idArt;
    private int quantity;

    public CommandArticle() {}

    public CommandArticle(int idCmd, int idArt, int quantity) {
        this.idCmd = idCmd;
        this.idArt = idArt;
        this.quantity = quantity;
    }

    public int getIdCmd() { return idCmd; }
    public void setIdCmd(int idCmd) { this.idCmd = idCmd; }

    public int getIdArt() { return idArt; }
    public void setIdArt(int idArt) { this.idArt = idArt; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "CommandArticle{" +
                ", idCmd=" + idCmd +
                ", idArt=" + idArt +
                ", quantity=" + quantity +
                '}';
    }
}
