package P6.OV_CHIPKAART_DAO;

import P6.POJO.OVChipkaart;
import P6.SQLiteBaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartDaoImpl extends SQLiteBaseDao implements OVChipkaartDao {

    private OVChipkaart extractOVChipkaartFromResultSet(ResultSet rs) throws SQLException {
        OVChipkaart ovChipkaart = new OVChipkaart(
                rs.getInt("kaartnummer"),
                rs.getInt("klasse"),
                rs.getDouble("saldo"),
                rs.getInt("reizigerID"));
        return ovChipkaart;
    }

    private PreparedStatement createOVChipkaartStatement(PreparedStatement stmt, OVChipkaart ovChipkaart) throws SQLException {
        stmt.setInt(1, ovChipkaart.getKaartnummer());
        stmt.setInt(2, ovChipkaart.getKlasse());
        stmt.setInt(3, ovChipkaart.getReizigerID());
        return stmt;
    }

    @Override
    public boolean saveOVChipkaart(OVChipkaart ovChipkaart) {
        try (Connection conn = super.getConnection()){
            PreparedStatement stmt = createOVChipkaartStatement(conn.prepareStatement("" +
                    "INSERT INTO OV_CHIPKAART " +
                    "VALUES(?,?,?,?)"), ovChipkaart);
            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public OVChipkaart selectOVChipkaart(int kaartnummer) {
        OVChipkaart ovChipkaart = null;
        try (Connection conn = super.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("" +
                    "SELECT * " +
                    "FROM OV_CHIPKAART " +
                    "WHERE kaartnummer=" + kaartnummer);
            ResultSet rs = stmt.executeQuery();
            ovChipkaart = extractOVChipkaartFromResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ovChipkaart;
    }

    @Override
    public boolean updateOVChipkaart(OVChipkaart ovChipkaart) {
        try (Connection conn = super.getConnection()){
            PreparedStatement stmt = createOVChipkaartStatement(conn.prepareStatement("" +
                    "UPDATE OV_CHIPKAART " +
                    "SET kaartnummer=?, klasse=?, saldo=?, reizigerID=? " +
                    "WHERE kaartnummer="+ovChipkaart.getKaartnummer()), ovChipkaart);
            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOVChipkaart(OVChipkaart ovChipkaart) {
        try (Connection conn = super.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("" +
                    "DELETE FROM OV_CHIPKAART " +
                    "WHERE kaartnummer="+ovChipkaart.getKaartnummer());
            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<OVChipkaart> findAll() {
        List<OVChipkaart> ovChipkaarten = new ArrayList<>();
        try (Connection con = super.getConnection()){
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM OV_CHIPKAART");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OVChipkaart ovChipkaart = extractOVChipkaartFromResultSet(rs);
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
                    "AND r.reizigerID=" + reizigerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OVChipkaart ovChipkaart = extractOVChipkaartFromResultSet(rs);
                ovChipkaarten.add(ovChipkaart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ovChipkaarten;
    }
}
