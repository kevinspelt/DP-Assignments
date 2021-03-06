package P6.POJO;

public class Reiziger {
    private int reizigerID;
    private String voorl;
    private String tussenvoegsel;
    private String naam;

    public Reiziger(int reizigerID, String voorl, String tussenvoegsel, String naam) {
        this.reizigerID = reizigerID;
        this.voorl = voorl;
        this.tussenvoegsel = tussenvoegsel;
        this.naam = naam;
    }

    public int getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(int reizigerID) {
        this.reizigerID = reizigerID;
    }

    public String getVoorl() {
        return voorl;
    }

    public void setVoorl(String voorl) {
        this.voorl = voorl;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
