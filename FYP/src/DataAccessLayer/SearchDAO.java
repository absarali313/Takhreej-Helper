/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessLayer;

import CustomLogger.Log;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ch-sa
 */
public class SearchDAO implements ISearchDAO {

    
    @Override
    public ArrayList<Integer> getFilteredHadithIds(String expression) {
        ArrayList<Integer> hadiths = new ArrayList<>();

        String query = "SELECT serial FROM hadith where " + expression;
        System.out.println(query);
        try (PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int serial = resultSet.getInt("serial");

                hadiths.add(serial);
            }

            if (hadiths.isEmpty()) {
                Log.getLogger().info("No Hadith found in the database.");
            }

        } catch (SQLException e) {
            Log.getLogger().error("Error in retrieving Hadith", e.getMessage());
        } catch (Exception e) {
            Log.getLogger().error("Error while getting hadith from database: " + e.getMessage());
        }

        return hadiths;
    }

}
