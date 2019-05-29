package P6.OV_CHIPKAART_DAO;

import P6.POJO.OVChipkaart;
import P6.SQLiteBaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartDaoImpl extends SQLiteBaseDao implements OVChipkaartDao {

    @Override
    public List<OVChipkaart> findAll() {
        List<OVChipkaart> ovChipkaarten = new ArrayList<>();
        try (Connection con = super.getConnection()){
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM OV_CHIPKAART");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OVChipkaart ovChipkaart = new OVChipkaart(
                        rs.getInt("kaartnummer"),
                        rs.getInt("klasse"),
                        rs.getInt("reizigerID")
                );
                ovChipkaarten.add(ovChipkaart);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ovChipkaarten;
    }

    @Override
    public List<OVChipkaart> findOVChipkaartenMetReizigerID(int reizigerID) {
        List<OVChipkaart> ovChipkaarten = new ArrayList<>();
        try (Connection conn = super.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("" +
                    "SELECT * " +
                    "FROM OV_CHIPKAART o " +
                    "INNER JOIN REIZIGER r " +
                    "WHERE o.reizigerID = r.reizigerID " +
                    "AND r.reizigerID = " + reizigerID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OVChipkaart ovChipkaart = new OVChipkaart(
                        rs.getInt("kaartnummer"),
                        rs.getInt("klasse"),
                        rs.getInt("reizigerID")
                );
                ovChipkaarten.add(ovChipkaart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ovChipkaarten;
    }
}
