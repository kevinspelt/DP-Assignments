package P3.DAO_OVChipkaart;

import P3.POJO.OVchipkaart;

import java.util.List;

public interface OVchipkaartDao {
    OVchipkaart selectOVchipkaart(int kaartnummer);
    List<OVchipkaart> selectOVchipkaartenMetProductnummer(int productnummer);
}
