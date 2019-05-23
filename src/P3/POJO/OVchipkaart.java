package P3.POJO;

import java.util.ArrayList;

public class OVchipkaart {
    private int kaartnummer;
    private String geldigTot;
    private int klasse;
    private double saldo;
    private int reizigerID;

    private ArrayList<Product> producten = new ArrayList<>();

    public OVchipkaart(int kaartnummer, String geldigTot, int klasse, double saldo, int reizigerID) {
        this.kaartnummer = kaartnummer;
        this.geldigTot = geldigTot;
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

    public String getGeldigTot() {
        return geldigTot;
    }

    public void setGeldigTot(String geldigTot) {
        this.geldigTot = geldigTot;
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

    public void addProduct(Product product) {
        producten.add(product);
    }

    public void deleteProduct(Product product) {
        producten.remove(product);
    }

    public ArrayList<Product> getProducten() {
        return producten;
    }
}
