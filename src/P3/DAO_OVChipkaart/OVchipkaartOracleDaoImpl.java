package P3.DAO_OVChipkaart;

import P3.Connection.OracleBaseDao;
import P3.POJO.OVchipkaart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OVchipkaartOracleDaoImpl extends OracleBaseDao implements OVchipkaartDao {

    @Override
    public OVchipkaart selectOVchipkaart(int kaartnummer) {
        OVchipkaart ovChipkaart = null;

        try (Connection conn = super.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM OV_CHIPKAART WHERE KAARTNUMMER=" + kaartnummer);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
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
    public List<OVchipkaart> selectOVchipkaartenMetProductnummer(int productnummer) {
        List<OVchipkaart> ovChipkaarten = new ArrayList<>();

        try (Connection conn = super.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("" +
                    "SELECT oc.kaartnummer, oc.geldigtot, oc.klasse, oc.saldo, oc.reizigerid " +
                    "FROM OV_CHIPKAART oc, OV_CHIPKAART_PRODUCT ocp " +
                    "WHERE ocp.kaartnummer = oc.kaartnummer AND " +
                    "ocp.productnummer = " + productnummer);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                OVchipkaart ovChipkaart = new OVchipkaart(
                        rs.getInt("kaartnummer"),
                        rs.getString("geldigtot"),
                        rs.getInt("klasse"),
                        rs.getFloat("saldo"),
                        rs.getInt("reizigerID"));
                ovChipkaarten.add(ovChipkaart);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ovChipkaarten;
    }
}
