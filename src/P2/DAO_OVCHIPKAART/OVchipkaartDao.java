package P2.DAO_OVCHIPKAART;

import P2.POJO.OVchipkaart;
import P2.POJO.Reiziger;

import java.util.List;

public interface OVchipkaartDao {
    List<OVchipkaart> findAll();
    OVchipkaart findByReiziger(int reizigerID);
    OVchipkaart save(OVchipkaart ovChipkaart);
    OVchipkaart update(OVchipkaart ovChipkaart);
    OVchipkaart delete(OVchipkaart ovChipkaart);
}
