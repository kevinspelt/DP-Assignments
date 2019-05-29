package P6.REIZIGER_DAO;

import P6.POJO.Reiziger;

import java.util.List;

public interface ReizigerDao {
    List<Reiziger> findAll();
    Reiziger findReizigerWithKaartnummer(int kaartnummer);
}
