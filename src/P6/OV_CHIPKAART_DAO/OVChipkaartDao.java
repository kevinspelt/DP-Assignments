package P6.OV_CHIPKAART_DAO;

import P6.POJO.OVChipkaart;
import P6.SQLiteBaseDao;

import java.util.List;

public interface OVChipkaartDao {
    List<OVChipkaart> findAll();
    List<OVChipkaart> findOVChipkaartenMetReizigerID(int reizigerID);
}
