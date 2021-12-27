package rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model;

import java.util.Objects;

public class Racunar {
    private int IDR;
    private String nazivR;

    public Racunar(int IDR, String nazivR) {
        this.IDR = IDR;
        this.nazivR = nazivR;
    }

    public Racunar() {}

    public int getIDR() {
        return IDR;
    }

    public void setIDR(int IDR) {
        this.IDR = IDR;
    }

    public String getNazivR() {
        return nazivR;
    }

    public void setNazivR(String nazivR) {
        this.nazivR = nazivR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Racunar)) return false;
        Racunar racunar = (Racunar) o;
        return getIDR() == racunar.getIDR() && Objects.equals(getNazivR(), racunar.getNazivR());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDR(), getNazivR());
    }

    @Override
    public String toString() {
        return String.format("%-6d %-10s", IDR, nazivR);
    }

    public static String getFormattedHeader() {
        return String.format("%-6d %-10s ", "IDR", "NAZIVR");
    }


}
