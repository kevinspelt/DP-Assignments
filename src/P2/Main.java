package P2;

import P2.DAO_OVCHIPKAART.OVchipkaartOracleDaoImpl;
import P2.DAO_REIZIGER.ReizigerOracleDaoImpl;
import P2.POJO.OVchipkaart;
import P2.POJO.Reiziger;

public class Main {
    public static void main(String[] args) {
        ReizigerOracleDaoImpl reizigerOracleDao = new ReizigerOracleDaoImpl();
        OVchipkaartOracleDaoImpl ovChipkaartOracleDao = new OVchipkaartOracleDaoImpl();

        Reiziger r1 = new Reiziger(6, "K", null, "Spelt", "2002-06-15");
        OVchipkaart o1 = new OVchipkaart(73919, "2021-08-12", 2, 25.30, 6);

        //Insert r1 into database
        System.out.println("Insert r1 into database");
        reizigerOracleDao.save(r1);
        reizigerOracleDao.findAll().forEach(reiziger -> System.out.println(reiziger.getVoorletters() + " " + reiziger.getAchternaam()));

        //Update r1
        System.out.println("Update r1");
        r1.setAchternaam("Berends");
        reizigerOracleDao.update(r1);
        reizigerOracleDao.findAll().forEach(reiziger -> System.out.println(reiziger.getVoorletters() + " " + reiziger.getAchternaam()));

        //Print all reizigers with gbdatum 2002-06-15
        System.out.println("Print all reizigers with gbdatum 2002-06-15");
        reizigerOracleDao.findByGBdatum("2002-06-15").forEach(reiziger -> System.out.println(reiziger.getVoorletters() + " " + reiziger.getAchternaam()));

        //Insert o1 into database
        System.out.println("Insert o1 into database");
        ovChipkaartOracleDao.save(o1);
        ovChipkaartOracleDao.findAll().forEach(ovChipkaart -> System.out.println(ovChipkaart.getKaartnummer()));

        //Update o1
        System.out.println("Update o1");
        o1.setKlasse(1);
        ovChipkaartOracleDao.update(o1);
        ovChipkaartOracleDao.findAll().forEach(ovChipkaart -> System.out.println(ovChipkaart.getKaartnummer()));

        //Get ovchipkaart met reizigerid
        System.out.println("Get ovchipkaart met reizigerid");
        System.out.println(ovChipkaartOracleDao.findByReiziger(6));

        //Delete o1
        System.out.println("Delete o1");
        ovChipkaartOracleDao.delete(o1);
        ovChipkaartOracleDao.findAll().forEach(ovChipkaart -> System.out.println(ovChipkaart.getKaartnummer()));

        //Delete r1
        System.out.println("Delete r1");
        reizigerOracleDao.delete(r1);
        reizigerOracleDao.findAll().forEach(reiziger -> System.out.println(reiziger.getVoorletters() + " " + reiziger.getAchternaam()));
    }
}

