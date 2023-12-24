package dao;

import models.Client;

import java.util.List;

public interface IClientDao {
    Client insertClient(Client client);
    List<Client> selectAllClient();
    Client updateClient(Client client, int id);
    Client selectClient(int id);
    void deleteClient(int id);
}
