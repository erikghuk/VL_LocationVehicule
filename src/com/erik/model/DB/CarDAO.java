package com.erik.model.DB;

import com.erik.model.Parc;
import com.erik.model.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements DAO<Vehicle> {
    @Override
    public List<Vehicle> getAllData() {
        Vehicle vehicle;
        List<Vehicle> cars = new ArrayList<>();
        String sql = "SELECT * FROM cars";

        try(Statement statement = connect.createStatement(); ResultSet results = statement.executeQuery(sql);) {
            while (results.next()) {
                vehicle = getVehicle(results);
                cars.add(vehicle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Vehicle create(Vehicle obj) {
        return null;
    }

    @Override
    public Vehicle read(int id) {
        return null;
    }

    @Override
    public Vehicle update(Vehicle obj) {
        return null;
    }

    @Override
    public void delete(Vehicle obj) {

    }

    public Parc getAvailableData(String type, String dateReserving, String dateDeadline) {
        Parc parcOfRequestingCars = new Parc();
        Vehicle vehicle = null;
        String sql= "SELECT * FROM cars WHERE car_type = '"+type+"'" +
                " AND (car_id IN (SELECT car_id FROM clients WHERE deadline < '"+dateReserving+"'"+
                " OR date_reservation > '"+dateDeadline+"') OR car_id NOT IN (SELECT car_id FROM clients))";
        try(Statement statement = connect.createStatement(); ResultSet results = statement.executeQuery(sql);) {

            while (results.next()) {
                vehicle = getVehicle(results);
                parcOfRequestingCars.addInParc(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return parcOfRequestingCars;
    }

    private Vehicle getVehicle(ResultSet results) throws SQLException {
        Vehicle vehicle;
        vehicle = new Vehicle();
        vehicle.setID(results.getInt(1));
        vehicle.setModel(results.getString(3));
        vehicle.setMarque(results.getString(2));
        vehicle.setColor(results.getString(4));
        vehicle.setAvailability(results.getBoolean(6));
        vehicle.setType(results.getString(5));
        vehicle.setCarburant(results.getString(7));
        vehicle.setPrice(results.getFloat(9));
        vehicle.setChevaux(results.getInt(11));
        vehicle.setTransmission(results.getBoolean(10));
        vehicle.setPortCount(results.getShort(14));
        vehicle.setConsummation(results.getShort(12));
        vehicle.setSiegeCount(results.getShort(15));
        vehicle.setBodyType(results.getString(16));
        vehicle.setYear(results.getInt(17));
        vehicle.setImageURL(results.getString(8));
        return vehicle;
    }

}
