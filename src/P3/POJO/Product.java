package P3.POJO;

import java.util.ArrayList;

public class Product {
    private int productNummer;
    private String productNaam;
    private String beschrijving;
    private float prijs;

    private ArrayList<OVchipkaart> ovChipkaarten = new ArrayList<>();

    public Product(int productNummer, String productNaam, String beschrijving, float prijs) {
        this.productNummer = productNummer;
        this.productNaam = productNaam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public int getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public String getProductNaam() {
        return productNaam;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

    public void addOVchipkaart(OVchipkaart ovChipkaart) {
        ovChipkaarten.add(ovChipkaart);
    }

    public void deleteOVchipkaart(OVchipkaart ovChipkaart) {
        ovChipkaarten.remove(ovChipkaart);
    }

    public ArrayList<OVchipkaart> getOVchipkaarten() {
        return ovChipkaarten;
    }
}
