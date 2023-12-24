package dao;

import models.Client;
import tools.TonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements IClientDao{

    private static final String INSERT_CLIENT = "INSERT INTO client (firstName, lastName,tele, mail) VALUES (?,?,?,?);";
    private static final String SELECT_CLIENT_BY_ID = "SELECT id, firstName, lastName, tele, mail FROM client WHERE id = ?";
    private static final String SELECT_ALL_CLIENT = "SELECT * FROM client";
    private static final String DELETE_CLIENT = "DELETE FROM client WHERE id = ?;";
    private static final String UPDATE_CLIENT = "UPDATE client SET firstName = ?, lastName = ?, tele = ?, mail = ? WHERE id = ?;";

    public ClientDao() {
    }

    // insert client
    public Client insertClient(Client client) {
        Connection connection = TonConnection.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT)){
            preparedStatement.setString(1,client.getFirstName());
            preparedStatement.setString(2,client.getLastName());
            preparedStatement.setInt(3,client.getTele());
            preparedStatement.setString(4,client.getMail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    // select all client
    public List<Client> selectAllClient() {
        List<Client> clients = new ArrayList<>();
        Connection connection = TonConnection.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENT)){
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int tele = rs.getInt("tele");
                String mail = rs.getString("mail");
                clients.add(new Client(id, firstName, lastName, tele, mail));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clients;
    }

    // update client
    public Client updateClient(Client client, int id) {
        Connection connection = TonConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT)){
            statement.setString(1,client.getFirstName());
            statement.setString(2,client.getLastName());
            statement.setInt(3,client.getTele());
            statement.setString(4,client.getMail());
            statement.setInt(5, id);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    public Client selectClient(int id){
        Client client = null;
        Connection connection = TonConnection.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int tele = rs.getInt("tele");
                String mail = rs.getString("mail");
                client = new Client(id, firstName, lastName, tele, mail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return client;
    }

    // delete client
    public void deleteClient(int id){
        Connection connection = TonConnection.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT)){
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
