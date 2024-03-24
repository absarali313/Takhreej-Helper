/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PresentationLayer;

import BusinessLogicLayer.FascadeBLL;
import BusinessLogicLayer.HadithBO;
import BusinessLogicLayer.IFascadeBLL;
import BusinessLogicLayer.RootGeneratorBO;
import CustomException.NoHadithFoundException;
import CustomLogger.Log;
import DataAccessLayer.DBhandler;
import DataAccessLayer.FascadeDAO;
import TransferObject.Hadith;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.oujda_nlp_team.entity.Result;

/**
 *
 * @author ch-sa
 */
public class test {

    public static void main(String[] args) throws NoHadithFoundException {
        FascadeBLL fascadeBLL = new FascadeBLL();
        FascadeDAO fascadeDAO = new FascadeDAO();
        ArrayList<Integer> ids = fascadeDAO.getAllHadithIds();
        ArrayList<Hadith> hadiths = fascadeDAO.getHadiths(ids);
        RootGeneratorBO rootGenerator = new RootGeneratorBO();

        for (Hadith hadith : hadiths) {
            ArrayList<String> roots = rootGenerator.getRoots(hadith.getMatn());
            insertRoot(hadith.getIndex(), roots);
            System.out.println(hadith.getIndex());
        }
    }

    public static boolean insertRoot(int hadithId, ArrayList<String> roots) {
        String query = "INSERT INTO hadithroots(hadithid, root) VALUES (?, ?)";
        try (java.sql.PreparedStatement preparedStatement = DBhandler.getInstance().getConnection().prepareStatement(query)) {
            for (String root : roots) {
                preparedStatement.setInt(1, hadithId);
                preparedStatement.setString(2, root);
                preparedStatement.addBatch(); // Add current insertion to batch
            }
            preparedStatement.executeBatch(); // Execute all insertions in batch
            return true;
        } catch (SQLException e) {
            Log.getLogger().error("Error in inserting roots for hadith with ID: " + hadithId, e.getMessage());
            return false;
        }

    }
}
