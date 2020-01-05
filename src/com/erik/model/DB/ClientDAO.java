package com.erik.model.DB;
import com.erik.model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements DAO<Client> {

    @Override
    public List<Client> getAllData() {
        Client client;
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";

        try(Statement statement = connect.createStatement(); ResultSet results = statement.executeQuery(sql);) {
            while (results.next()) {
                client = getClients(results);
                clients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client create(Client client) {
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO clients(cname, csurname, date_reservation, deadline, car_id, address, email)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?);");

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSurName());
            preparedStatement.setTimestamp(3, client.getStartDate());
            preparedStatement.setTimestamp(4, client.getEndDate());
            preparedStatement.setInt(5, client.getCarID());
            preparedStatement.setString(6, client.getAddress());
            preparedStatement.setString(7, client.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Client read(int id) {
        return null;
    }

    @Override
    public Client update(Client obj) {
        return null;
    }

    @Override
    public void delete(Client obj) {

    }

    private Client getClients(ResultSet results) throws SQLException {
        Client client = new Client(
                results.getString(2), results.getString(3),
                results.getTimestamp(4), results.getTimestamp(5),
                results.getString(7), results.getString(8));
        client.setCarID(results.getInt(6));

        return client;
    }
}
