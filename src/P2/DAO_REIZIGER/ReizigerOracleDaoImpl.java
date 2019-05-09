package P2.DAO_REIZIGER;

import P2.OracleBaseDao;
import P2.POJO.Reiziger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {

    @Override
    public List<Reiziger> findAll() {
        ArrayList<Reiziger> reizigers = new ArrayList<>();

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM REIZIGER");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reiziger reiziger = new Reiziger(
                        rs.getInt("reizigerID"),
                        rs.getString("voorletters"),
                        rs.getString("tussenvoegsel"),
                        rs.getString("achternaam"),
                        rs.getString("gebortedatum"));
                reizigers.add(reiziger);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reizigers;
    }

    @Override
    public List<Reiziger> findByGBdatum(String gbDatum) {
        ArrayList<Reiziger> reizigers = new ArrayList<>();

        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM REIZIGER WHERE gebortedatum=?");
            stmt.setDate(1, Date.valueOf(gbDatum));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reiziger reiziger = new Reiziger(
                        rs.getInt("reizigerID"),
                        rs.getString("voorletters"),
                        rs.getString("tussenvoegsel"),
                        rs.getString("achternaam"),
                        rs.getString("gebortedatum"));
                reizigers.add(reiziger);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reizigers;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO REIZIGER VALUES(?,?,?,?,?)");
            stmt.setInt(1, reiziger.getReizigerID());
            stmt.setString(2, reiziger.getVoorletters());
            stmt.setString(3, reiziger.getTussenvoegsel());
            stmt.setString(4, reiziger.getAchternaam());
            stmt.setDate(5, Date.valueOf(reiziger.getGeboortedatum()));

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reiziger;
    }

    @Override
    public Reiziger update(Reiziger reiziger) {
        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(
                    "UPDATE REIZIGER SET voorletters=?, tussenvoegsel=?, achternaam=?, gebortedatum=? WHERE reizigerID=?");
            stmt.setString(1, reiziger.getVoorletters());
            stmt.setString(2, reiziger.getTussenvoegsel());
            stmt.setString(3, reiziger.getAchternaam());
            stmt.setDate(4, Date.valueOf(reiziger.getGeboortedatum()));
            stmt.setInt(5, reiziger.getReizigerID());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reiziger;
    }

    @Override
    public Reiziger delete(Reiziger reiziger) {
        try (Connection con = super.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM REIZIGER WHERE reizigerID=?");
            stmt.setInt(1, reiziger.getReizigerID());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reiziger;
    }
}