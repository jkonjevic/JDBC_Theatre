package rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model;

import java.util.Objects;

public class Konfiguracija {

    private int IDR;
    private int IDK;
    private int komanda;


    public Konfiguracija(int IDR, int IDK, int komanda) {
        this.IDR = IDR;
        this.IDK = IDK;
        this.komanda = komanda;
    }

    public Konfiguracija() {}


    public int getIDR() {
        return IDR;
    }

    public void setIDR(int IDR) {
        this.IDR = IDR;
    }

    public int getIDK() {
        return IDK;
    }

    public void setIDK(int IDK) {
        this.IDK = IDK;
    }

    public int getKomanda() {
        return komanda;
    }

    public void setKomanda(int komanda) {
        this.komanda = komanda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Konfiguracija)) return false;
        Konfiguracija that = (Konfiguracija) o;
        return getIDR() == that.getIDR() && getIDK() == that.getIDK() && getKomanda() == that.getKomanda();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDR(), getIDK(), getKomanda());
    }


    @Override
    public String toString() {
        return String.format("%-6d %-6d %-10s", IDR, IDK, komanda);
    }

    public static String getFormattedHeader() {
        return String.format("%-6d %-6d %-10s", "IDR", "IDK", "KOMANDA");
    }

}
