package P6.REIZIGER_DAO;

import P6.POJO.OVChipkaart;
import P6.POJO.Reiziger;
import P6.SQLiteBaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReizigerDaoImpl extends SQLiteBaseDao implements ReizigerDao {

    public List<Reiziger> findAll() {
        List<Reiziger> reizigers = new ArrayList<>();
        try (Connection con = super.getConnection()){
            PreparedStatement stmt = con.prepareStatement("" +
                    "SELECT * " +
                    "FROM OV_CHIPKAART");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reiziger reiziger = new Reiziger(
                        rs.getInt("reizigerID"),
                        rs.getString("voorl"),
                        rs.getString("naam")
                );
                reizigers.add(reiziger);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reizigers;
    }


    @Override
    public Reiziger findReizigerWithKaartnummer(int kaartnummer) {
        Reiziger reiziger = null;
        try (Connection conn = super.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("" +
                    "SELECT * " +
                    "FROM REIZIGER r " +
                    "INNER JOIN OV_CHIPKAART o " +
                    "WHERE r.reizigerID = o.reizigerID " +
                    "AND o.kaartnummer = " + kaartnummer);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                reiziger = new Reiziger(
                        rs.getInt("reizigerID"),
                        rs.getString("voorl"),
                        rs.getString("naam")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reiziger;
    }
}
