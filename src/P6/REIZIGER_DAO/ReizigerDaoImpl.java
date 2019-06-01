package P6.REIZIGER_DAO;

import P6.POJO.OVChipkaart;
import P6.POJO.Reiziger;
import P6.SQLiteBaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReizigerDaoImpl extends SQLiteBaseDao implements ReizigerDao {

    private Reiziger extractReizigerFromResultSet(ResultSet rs) throws SQLException {
        Reiziger reiziger = new Reiziger(
                rs.getInt("reizigerID"),
                rs.getString("naam"),
                rs.getString("voorl"));
        return reiziger;
    }
    private PreparedStatement createReizigerStatement(PreparedStatement stmt, Reiziger reiziger) throws SQLException {
        stmt.setInt(1, reiziger.getReizigerID());
        stmt.setString(2, reiziger.getNaam());
        stmt.setString(3, reiziger.getVoorl());
        return stmt;
    }

    @Override
    public boolean saveReiziger(Reiziger reiziger) {
        try (Connection conn = super.getConnection()){
            PreparedStatement stmt = createReizigerStatement(conn.prepareStatement("" +
                    "INSERT INTO REIZIGER " +
                    "VALUES(?,?,?)"), reiziger);
            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Reiziger selectReiziger(int reizigerID) {
        Reiziger reiziger =  null;
        try (Connection conn = super.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("" +
                    "SELECT FROM REIZIGER " +
                    "WHERE reizigerID=" + reizigerID);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                reiziger = extractReizigerFromResultSet(rs);
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return reiziger;
    }

    @Override
    public boolean updateReiziger(Reiziger reiziger) {
        try (Connection conn = super.getConnection()){
            PreparedStatement stmt = createReizigerStatement(conn.prepareStatement("" +
                    "UPDATE REIZIGER " +
                    "SET reizigerID=?, naam=?, voorl=? " +
                    "WHERE reizigerID=" + reiziger.getReizigerID()), reiziger);
            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteReiziger(Reiziger reiziger) {
        try (Connection conn = super.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("" +
                    "DELETE FROM REIZIGER " +
                    "WHERE reizigerID=" + reiziger.getReizigerID());
            return stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Reiziger> findAll() {
        List<Reiziger> reizigers = new ArrayList<>();
        try (Connection con = super.getConnection()){
            PreparedStatement stmt = con.prepareStatement("" +
                    "SELECT * " +
                    "FROM REIZIGER");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reiziger reiziger = extractReizigerFromResultSet(rs);
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
            if (rs.next()) {
                reiziger = extractReizigerFromResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reiziger;
    }
}
