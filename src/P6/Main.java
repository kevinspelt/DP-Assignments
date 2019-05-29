package P6;

import P6.OV_CHIPKAART_DAO.OVChipkaartDaoImpl;
import P6.REIZIGER_DAO.ReizigerDaoImpl;

public class Main {
    public static void main(String[] args) {
        OVChipkaartDaoImpl ovChipkaartDao = new OVChipkaartDaoImpl();
        ReizigerDaoImpl reizigerDao = new ReizigerDaoImpl();
        ovChipkaartDao.findOVChipkaartenMetReizigerID(1).forEach(r -> System.out.println(r.getKaartnummer()));
    }
}
