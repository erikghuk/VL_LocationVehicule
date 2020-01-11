package com.erik.model;

import com.erik.model.DB.CarDAO;
import com.erik.model.DB.ClientDAO;
import com.erik.model.DB.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Controller {
    private String startDate;
    private String endDate;
    private Parc requestingCars;
    private SearchingForm searchingForm;
    private CarDAO carsDB;
    private int reservingDays;

    public Controller() {
        searchingForm = new SearchingForm();
    }

    private boolean dateAnalise(String dateRange) throws DAOException {
        if(dateRange == null) {
            throw new DAOException("Saisissez la date de location");
        }
        String[] dateRangeArray = dateRange.split("-");
        String[] endAndHours = dateRangeArray[1].split("<");
        endAndHours[1] = endAndHours[1].substring(0, endAndHours[1].length() - 7);
        reservingDays = Integer.parseInt(endAndHours[1]);
        searchingForm.setReservingDate(dateRangeArray[0]);
        searchingForm.setReturningDate(endAndHours[0]);
        startDate = dateRangeArray[0];
        endDate = endAndHours[0];

        return true;
    }

    private Timestamp dateConverter(String date) {
        Timestamp timestamp = null;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm")
                .withLocale(new Locale("us"));
        LocalDateTime ldt = LocalDateTime.parse(date , f); // 2020-01-16T11:02
        timestamp = Timestamp.valueOf(ldt);
        return timestamp;
    }

    public void getSearchResult(HttpServletRequest request) throws DAOException {
        carsDB = new CarDAO();
        searchingForm.getSearchFormParams(request);
        if (dateAnalise(searchingForm.getDateRange())) {
            requestingCars = carsDB.getAvailableData(searchingForm.getType().toUpperCase(), searchingForm.getReservingDate(), searchingForm.getReturningDate());
            if(requestingCars.getVehicles().size() == 0 || requestingCars == null) {
                searchingForm = null;
                carsDB = null;
                throw new DAOException("On a trouvé aucun vehicule disponible avec les critères que vous avez rentré.");
            }
        }
        else
            requestingCars = null;
    }

    public Client getRegisteredClient(HttpServletRequest request, Vehicle vehicle) throws DAOException {
        DAO<Client> clientDAO = new ClientDAO();
        searchingForm.getLastReservingForm(request);

        if(searchingForm.getClientName().equals("") ||
                searchingForm.getClientSurname().equals("") ||
                searchingForm.getEmail().equals("") ||
                searchingForm.getClientAddress().equals("") ||
                searchingForm.getReturningDate().equals("") ||
                searchingForm.getReservingDate().equals("")) {
            throw new DAOException("Invalid form");
        }
        Client client = new Client(searchingForm.getClientName(), searchingForm.getClientSurname(),
                                    dateConverter(searchingForm.getReservingDate().trim()), dateConverter(searchingForm.getReturningDate().trim()),
                                    searchingForm.getClientAddress(), searchingForm.getEmail());
        client.setCarID(vehicle.getID());

        if(clientDAO.create(client) == null) {
            throw new DAOException("Vous avez déja loué une voiture.");
        }
        return client;
    }
    public Vehicle getRequestingCarFromParc(HttpServletRequest request) throws DAOException {
        Vehicle car = null;
        int selectedCarID = -1;
        searchingForm.getReservingFormParams(request);
        try {
            selectedCarID = Integer.parseInt(searchingForm.getId());
        } catch(NumberFormatException e) {
            throw new DAOException("The selected car has a wrong id, please try again");
        }
        Parc parc = (Parc) request.getSession().getAttribute("parcOfRequestingCars");
        if(parc != null) {
            for (Vehicle vehicle : parc.getVehicles()) {
                if (vehicle.getID() == selectedCarID) {
                    car = vehicle;
                }
            }
        } else {
            throw new DAOException("On a trouvé aucun vehicule disponible avec les criteries que vous avez rentré.");
        }
        return car;
    }

    public Parc getRequestingCars() {
        return requestingCars;
    }

    public int getReservingDays() {
        return reservingDays;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

}
