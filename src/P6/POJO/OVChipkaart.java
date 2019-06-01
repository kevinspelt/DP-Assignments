package P6.POJO;

public class OVChipkaart {
    private int kaartnummer;
    private int klasse;
    private double saldo;
    private int reizigerID;

    public OVChipkaart(int kaartnummer, int klasse, double saldo, int reizigerID) {
        this.kaartnummer = kaartnummer;
        this.klasse = klasse;
        this.saldo = saldo;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(int reizigerID) {
        this.reizigerID = reizigerID;
    }
}
