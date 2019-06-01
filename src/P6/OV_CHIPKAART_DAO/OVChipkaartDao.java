package P6.OV_CHIPKAART_DAO;

import P6.POJO.OVChipkaart;
import P6.POJO.Reiziger;

import java.util.List;

public interface OVChipkaartDao {
    boolean saveOVChipkaart(OVChipkaart ovChipkaart);
    OVChipkaart selectOVChipkaart(int kaartnummer);
    boolean updateOVChipkaart(OVChipkaart ovChipkaart);
    boolean deleteOVChipkaart(OVChipkaart ovChipkaart);
    List<OVChipkaart> findAll();
    List<OVChipkaart> findOVChipkaartenMetReizigerID(int reizigerID);
}
