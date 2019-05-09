package P1;

import java.util.List;

public interface ReizigerDao {
    List<Reiziger> findAll();
    List<Reiziger> findByGBdatum(String gbdatum);
    void save(Reiziger reiziger);
    void update(Reiziger reiziger);
    boolean delete(Reiziger reiziger);
}
