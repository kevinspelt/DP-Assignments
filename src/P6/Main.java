package P6;

import P6.OV_CHIPKAART_DAO.OVChipkaartDaoImpl;
import P6.POJO.OVChipkaart;
import P6.POJO.Reiziger;
import P6.REIZIGER_DAO.ReizigerDaoImpl;

public class Main {
    public static void main(String[] args) {
        OVChipkaartDaoImpl ovChipkaartDao = new OVChipkaartDaoImpl();
        ReizigerDaoImpl reizigerDao = new ReizigerDaoImpl();

        reizigerDao.findAll().forEach(r -> System.out.println(r.getReizigerID() + " " + r.getVoorl() + ". " + r.getNaam()));
        Reiziger r1 = reizigerDao.findReizigerWithKaartnummer(3);
        System.out.println(r1.getReizigerID() + " " + r1.getVoorl() + ". " + r1.getNaam());
    }
}
