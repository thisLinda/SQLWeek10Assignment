package dao;

import entity.Med;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedDao {

    private Connection connection;
    private final String CREATE_NEW_MED_QUERY = "INSERT INTO meds(med_id, generic_name) VALUES(?,?)";
//    private final String GET_MED_BY_ID_QUERY = "SELECT * FROM meds WHERE med_id = ?";
    private final String GET_MED_BY_NAME_QUERY = "SELECT * FROM meds WHERE generic_name = ?";
    private final String GET_ALL_MEDS = "SELECT * FROM meds";
    private final String UPDATE_MED_NAME_QUERY = "UPDATE meds SET generic_name = ? WHERE generic_name = ?";
    private final String DELETE_MED_QUERY = "DELETE FROM meds WHERE generic_name = ?";

    public MedDao() {
        connection  = DbConnection.getConnection();
    }

    public void createNewMed(int medId, String genericName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(CREATE_NEW_MED_QUERY);
        ps.setInt(1, medId);
        ps.setString(2, genericName);
        ps.executeUpdate();
    }

    public Med getMedByName(String genericName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(GET_MED_BY_NAME_QUERY);
        ps.setString(1, genericName);
        ResultSet displayOneMed = ps.executeQuery();
        if (displayOneMed.next()) {
            Med newMed = new Med(displayOneMed.getInt(1), displayOneMed.getString(2));
            return newMed;
        } else {
            return null;
        }
    }

    public List<Med> getAllMeds() throws SQLException {
        ResultSet rs = connection.prepareStatement(GET_ALL_MEDS).executeQuery();
        List<Med> meds = new ArrayList<Med>();

        while (rs.next()) {
            meds.add(addMedToMedsList(rs.getInt(1), rs.getString(2)));
        }
        return meds;
    }

    private Med addMedToMedsList(int medId, String genericName) {
        return new Med(medId, genericName);
    }

    public void updateMedName(String inputName, String updatedName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(UPDATE_MED_NAME_QUERY);
        ps.setString(1, updatedName);
        ps.setString(2, inputName);
        ps.executeUpdate();
    }

    public void deleteMedByName(String genericName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(DELETE_MED_QUERY);
        ps.setString(1, genericName);
        ps.executeUpdate();
    }

}

