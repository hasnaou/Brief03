package models;

import java.util.ArrayList;
import java.util.List;

public class ClientModel {
    private String mc;
    private List<Client> clientList = new ArrayList<>();
    public ClientModel(){}
    public String getMc(){return this.mc;}
    public void setMc(String mc){this.mc = mc;}
    public List<Client> getClientList(){return this.clientList;}
    public void setClientList(List<Client> clientList) { this.clientList = clientList; }
}
