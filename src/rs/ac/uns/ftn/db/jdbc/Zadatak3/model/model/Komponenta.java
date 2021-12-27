package rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model;

import java.util.Objects;

public class Komponenta {
    private int IDK;
    private String nazivK;
    private String tip;
    private String proizvodjac;
    private double cena;
    private int AKC;

    public Komponenta(int IDK, String nazivK, String tip, String proizvodjac, double cena, int AKC) {
        this.IDK = IDK;
        this.nazivK = nazivK;
        this.tip = tip;
        this.proizvodjac = proizvodjac;
        this.cena = cena;
        this.AKC = AKC;
    }

    public Komponenta() {}

    public int getIDK() {
        return IDK;
    }

    public void setIDK(int IDK) {
        this.IDK = IDK;
    }

    public String getNazivK() {
        return nazivK;
    }

    public void setNazivK(String nazivK) {
        this.nazivK = nazivK;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getAKC() {
        return AKC;
    }

    public void setAKC(int AKC) {
        this.AKC = AKC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Komponenta)) return false;
        Komponenta that = (Komponenta) o;
        return getIDK() == that.getIDK() && getAKC() == that.getAKC() && Objects.equals(getNazivK(), that.getNazivK()) && Objects.equals(getTip(), that.getTip()) && Objects.equals(getProizvodjac(), that.getProizvodjac()) && Objects.equals(getCena(), that.getCena());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDK(), getNazivK(), getTip(), getProizvodjac(), getCena(), getAKC());
    }

    @Override
    public String toString() {
        return String.format("%-6d %-10s %-10s %-10s %-10f %-6d", IDK, nazivK, tip, proizvodjac, cena, AKC);
    }

    public static String getFormattedHeader() {
        return String.format("%-6d %-10s %-10s %-10s %-10f %-6d", "IDK", "NAZIVK", "TIP", "PROIZVODJAC", "cena", "AKC");
    }
}
