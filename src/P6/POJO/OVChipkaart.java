package P6.POJO;

public class OVChipkaart {
    private int kaartnummer;
    private int klasse;
    private int reizigerID;

    public OVChipkaart(int kaartnummer, int klasse, int reizigerID) {
        this.kaartnummer = kaartnummer;
        this.klasse = klasse;
        this.reizigerID = reizigerID;
    }

    public int getKaartnummer() {
        return kaartnummer;
    }

    public void setKaartnummer(int kaartnummer) {
        this.kaartnummer = kaartnummer;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public int getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(int reizigerID) {
        this.reizigerID = reizigerID;
    }
}
