package P3;

import P3.DAO_OVChipkaart.OVchipkaartOracleDaoImpl;
import P3.DAO_Product.ProductOracleDaoImpl;
import P3.POJO.OVchipkaart;
import P3.POJO.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OVchipkaartOracleDaoImpl ovChipkaartOracleDao = new OVchipkaartOracleDaoImpl();
        ProductOracleDaoImpl productOracleDao = new ProductOracleDaoImpl();

        //Selecteer OV-Chipkaart met kaartnummer 35283
        OVchipkaart ovChipkaart = ovChipkaartOracleDao.selectOVchipkaart(35283);
        System.out.println(ovChipkaart.getKaartnummer() + " " + ovChipkaart.getSaldo());

        //Selecteer Product met productnummer 1
        Product product = productOracleDao.selectProduct(1);
        System.out.println(product.getProductNummer() + " " + product.getPrijs());

        //Selecteer alle OV-Chipkaarten met productnummer 1
        List<OVchipkaart> ovChipkaarten = ovChipkaartOracleDao.selectOVchipkaartenMetProductnummer(1);
        for(OVchipkaart ov : ovChipkaarten) {
            System.out.println(ov.getKaartnummer());
        }

        //Selecteer alle Producten met kaartnummer 35283
        List<Product> producten = productOracleDao.selectProductenMetKaartnummer(35283);
        for(Product p : producten) {
            System.out.println(p.getProductNummer());
        }
    }
}
