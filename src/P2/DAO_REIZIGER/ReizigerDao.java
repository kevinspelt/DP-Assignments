package P2.DAO_REIZIGER;

import P2.POJO.Reiziger;

import java.util.List;

public interface ReizigerDao {
    List<Reiziger> findAll();
    List<Reiziger> findByGBdatum(String gbDatum);
    Reiziger save(Reiziger reiziger);
    Reiziger update(Reiziger reiziger);
    Reiziger delete(Reiziger reiziger);
}
