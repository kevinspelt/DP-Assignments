package P2.DAO_OVCHIPKAART;

import P2.OracleBaseDao;
import P2.POJO.OVchipkaart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OVchipkaartOracleDaoImpl extends OracleBaseDao implements OVchipkaartDao {

    @Override
    public List<OVchipkaart> findAll() {
        ArrayList<OVchipkaart> ovChipkaarten = new ArrayList<>();

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM OV_CHIPKAART");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OVchipkaart ovChipkaart = new OVchipkaart(
                        rs.getInt("kaartnummer"),
                        rs.getString("geldigtot"),
                        rs.getInt("klasse"),
                        rs.getDouble("saldo"),
                        rs.getInt("reizigerID"));
                ovChipkaarten.add(ovChipkaart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ovChipkaarten;
    }
    @Override
    public OVchipkaart findByReiziger(int reizigerID) {
        OVchipkaart ovChipkaart = null;
        try (Connection con = OracleBaseDao.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM OV_CHIPKAART WHERE REIZIGERID=?");
            stmt.setInt(1, reizigerID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                ovChipkaart = new OVchipkaart(
                        rs.getInt("kaartnummer"),
                        rs.getString("geldigtot"),
                        rs.getInt("klasse"),
                        rs.getFloat("saldo"),
                        rs.getInt("reizigerID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ovChipkaart;
    }

    @Override
    public OVchipkaart save(OVchipkaart ovChipkaart) {
        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO OV_CHIPKAART VALUES (?,?,?,?,?)");
            stmt.setInt(1, ovChipkaart.getKaartnummer());
            stmt.setDate(2, Date.valueOf(ovChipkaart.getGeldigTot()));
            stmt.setInt(3, ovChipkaart.getKlasse());
            stmt.setDouble(4, ovChipkaart.getSaldo());
            stmt.setInt(5, ovChipkaart.getReizigerID());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ovChipkaart;
    }

    @Override
    public OVchipkaart update(OVchipkaart ovChipkaart) {
        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE OV_CHIPKAART SET geldigtot=?, klasse=?, saldo=?, reizigerID=? where kaartnummer=?");
            stmt.setString(1, ovChipkaart.getGeldigTot());
            stmt.setInt(2, ovChipkaart.getKlasse());
            stmt.setDouble(3, ovChipkaart.getSaldo());
            stmt.setInt(4, ovChipkaart.getReizigerID());
            stmt.setInt(5, ovChipkaart.getKaartnummer());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ovChipkaart;    }

    @Override
    public OVchipkaart delete(OVchipkaart ovChipkaart) {
        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM OV_CHIPKAART WHERE reizigerID=?");
            stmt.setInt(1, ovChipkaart.getReizigerID());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ovChipkaart;
    }
}
