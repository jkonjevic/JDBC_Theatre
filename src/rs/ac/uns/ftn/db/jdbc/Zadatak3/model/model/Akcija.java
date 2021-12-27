package rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model;

import java.util.Objects;

public class Akcija {
    private int IDA;
    private String nazivA;
    private int popust;


    public Akcija(int IDA, String nazivA, int popust) {
        this.IDA = IDA;
        this.nazivA = nazivA;
        this.popust = popust;
    }

    public Akcija() {}

    public int getIDA() {
        return IDA;
    }

    public void setIDA(int IDA) {
        this.IDA = IDA;
    }

    public String getNazivA() {
        return nazivA;
    }

    public void setNazivA(String nazivA) {
        this.nazivA = nazivA;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Akcija)) return false;
        Akcija akcija = (Akcija) o;
        return getIDA() == akcija.getIDA() && getPopust() == akcija.getPopust() && Objects.equals(getNazivA(), akcija.getNazivA());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIDA(), getNazivA(), getPopust());
    }

    @Override
    public String toString() {
        return String.format("%-6d %-20s %-15d", IDA, nazivA, popust);
    }

    public static String getFormattedHeader() {
        return String.format("%-6s %-20s %-15s", "IDA", "NAZIVA", "POPUST");
    }

}
