package rs.ac.uns.ftn.db.jdbc.Zadatak3.dto;

public class RacunarskeKomponenteDTO {

    private int idk;
    private String nazivk;
    private String tip;
    private String proizvodjac;
    private double cena;
    private int idr;
    private String nazivr;
    private int akc;
    private int brKomponenti;

    public int getBrKomponenti() {
        return brKomponenti;
    }

    public void setBrKomponenti(int brKomponenti) {
        this.brKomponenti = brKomponenti;
    }

    public int getIdk() {
        return idk;
    }

    public void setIdk(int idk) {
        this.idk = idk;
    }

    public String getNazivk() {
        return nazivk;
    }

    public void setNazivk(String nazivk) {
        this.nazivk = nazivk;
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

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getNazivr() {
        return nazivr;
    }

    public void setNazivr(String nazivr) {
        this.nazivr = nazivr;
    }

    public int getAkc() {
        return akc;
    }

    public void setAkc(int akc) {
        this.akc = akc;
    }

    public RacunarskeKomponenteDTO(int idk, String nazivk, String tip, String proizvodjac, double cena, int idr, String nazivr, int akc, int brKomponenti) {
        this.idk = idk;
        this.nazivk = nazivk;
        this.tip = tip;
        this.proizvodjac = proizvodjac;
        this.cena = cena;
        this.idr = idr;
        this.nazivr = nazivr;
        this.akc = akc;
        this.brKomponenti = brKomponenti;
    }

    public String toString() {
        return String.format("%-6d %-16s %-15s %-15s %-15f %-6d %-20s  %-6d ", idk, nazivk, tip, proizvodjac, cena, idr, nazivr, akc);
    }

    public static String getFormattedHeader() {
        return String.format("%-6s %-20s %-8s %-15s %-15s %-15s %-6s", "IDK", "NAZIVK", "TIP", "PROIZVODJAC", "VALUTA", "CENA", "AKC");
    }

}