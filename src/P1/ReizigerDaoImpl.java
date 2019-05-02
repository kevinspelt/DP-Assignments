/*
Implements ReizigerDao
Adds values in reizigers

*/

package P1;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ReizigerDaoImpl implements ReizigerDao{
    private List<Reiziger> reizigers = new ArrayList<>();

    public ReizigerDaoImpl() {
        //Add values in reizigers
        Reiziger r1 = new Reiziger();
        Reiziger r2 = new Reiziger();
        Reiziger r3 = new Reiziger();

        r1.setNaam("Kevin");
        r1.setGbdatum(Date.valueOf("2002-06-15"));

        r2.setNaam("Fayssal");
        r2.setGbdatum(Date.valueOf("2001-01-16"));

        r3.setNaam("Djurryen");
        r3.setGbdatum(Date.valueOf("2001-07-13"));
    }

    @Override
    public List<Reiziger> findAll() {
        //Return all reizigers
        return reizigers;
    }

    @Override
    public List<Reiziger> findByGBdatum(String gbdatum) {
        //Make a temporary (t) list of reizigers
        List<Reiziger> tReizigers = new ArrayList<>();
        //Loop through all reizigers
        for(Reiziger reiziger : reizigers) {
            //If date of current reiziger equals the parameter gbdatum add it to tReizigers
            if(reiziger.getGbdatum().equals(Date.valueOf(gbdatum))) {
                tReizigers.add(reiziger);
            }
        }
        //Return temporary list of reizigers
        return tReizigers;
    }

    @Override
    public Reiziger save(Reiziger reiziger) {
        //Add parameter reiziger to reizigers
        reizigers.add(reiziger);
        //Return added reiziger
        return reiziger;
    }

    @Override
    public Reiziger update(Reiziger reiziger) {
        reizigers.add(reiziger);
        return reiziger;
    }

    @Override
    public boolean delete(Reiziger reiziger) {
        //Delete parameter reiziger from reizigers
        return reizigers.remove(reiziger);
    }
}
