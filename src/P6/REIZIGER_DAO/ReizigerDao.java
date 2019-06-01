package P6.REIZIGER_DAO;

import P6.POJO.Reiziger;

import java.util.List;

public interface ReizigerDao {
    boolean saveReiziger(Reiziger reiziger);
    Reiziger selectReiziger(int reizigerID);
    boolean updateReiziger(Reiziger reiziger);
    boolean deleteReiziger(Reiziger reiziger);
    List<Reiziger> findAll();
    Reiziger findReizigerWithKaartnummer(int kaartnummer);
}
