package P3.DAO_Product;

import P3.Connection.OracleBaseDao;
import P3.POJO.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductOracleDaoImpl extends OracleBaseDao implements ProductDao {

    @Override
    public Product selectProduct(int productNummer) {
        Product product = null;

        try (Connection conn = super.getConnection()){
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCTNUMMER=" + productNummer);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                product = new Product(
                        rs.getInt("productnummer"),
                        rs.getString("productnaam"),
                        rs.getString("beschrijving"),
                        rs.getFloat("prijs"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public List<Product> selectProductenMetKaartnummer(int kaartnummer) {
        List<Product> producten = new ArrayList<>();

        try (Connection conn = super.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("" +
                    "SELECT p.productnummer, p.productnaam, p.beschrijving, p.prijs " +
                    "FROM PRODUCT p, OV_CHIPKAART_PRODUCT ocp " +
                    "WHERE p.productnummer = ocp.productnummer and " +
                    "ocp.kaartnummer = " + kaartnummer);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("productnummer"),
                        rs.getString("productnaam"),
                        rs.getString("beschrijving"),
                        rs.getFloat("prijs"));

                producten.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producten;
    }
}
