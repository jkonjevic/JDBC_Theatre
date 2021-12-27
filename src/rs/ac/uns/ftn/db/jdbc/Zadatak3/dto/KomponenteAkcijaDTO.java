package rs.ac.uns.ftn.db.jdbc.Zadatak3.dto;

public class KomponenteAkcijaDTO {

    private String nazivAkcije;
    private int popustAkcije;
    private int idKomponente;
    private String nazivKomponente;
    private String tipKomponente;
    private String proizvodjacKomponente;
    private double cenaKomponente;

    public KomponenteAkcijaDTO(String nazivAkcije, int popustAkcije, int idKomponente, String nazivKomponente, String tipKomponente, String proizvodjacKomponente, double cenaKomponente) {
        this.nazivAkcije = nazivAkcije;
        this.popustAkcije = popustAkcije;
        this.idKomponente = idKomponente;
        this.nazivKomponente = nazivKomponente;
        this.tipKomponente = tipKomponente;
        this.proizvodjacKomponente = proizvodjacKomponente;
        this.cenaKomponente = cenaKomponente;
    }

    public String getNazivAkcije() {
        return nazivAkcije;
    }

    public void setNazivAkcije(String nazivAkcije) {
        this.nazivAkcije = nazivAkcije;
    }

    public int getPopustAkcije() {
        return popustAkcije;
    }

    public void setPopustAkcije(int popustAkcije) {
        this.popustAkcije = popustAkcije;
    }

    public int getIdKomponente() {
        return idKomponente;
    }

    public void setIdKomponente(int idKomponente) {
        this.idKomponente = idKomponente;
    }

    public String getNazivKomponente() {
        return nazivKomponente;
    }

    public void setNazivKomponente(String nazivKomponente) {
        this.nazivKomponente = nazivKomponente;
    }

    public String getTipKomponente() {
        return tipKomponente;
    }

    public void setTipKomponente(String tipKomponente) {
        this.tipKomponente = tipKomponente;
    }

    public String getProizvodjacKomponente() {
        return proizvodjacKomponente;
    }

    public void setProizvodjacKomponente(String proizvodjacKomponente) {
        this.proizvodjacKomponente = proizvodjacKomponente;
    }

    public double getCenaKomponente() {
        return cenaKomponente;
    }

    public void setCenaKomponente(double cenaKomponente) {
        this.cenaKomponente = cenaKomponente;
    }

    public String toString() {
        return String.format("%-15s %-6d %-8d %-15s %-15s %-15s %-10f ", nazivAkcije, popustAkcije, idKomponente, nazivKomponente, tipKomponente, proizvodjacKomponente, cenaKomponente);
    }

    public static String getFormattedHeader() {
        return String.format("%-15s %-6s %-8s %-15s %-15s %-15s %-10s ", "NAZIV AKCIJE", "POPUST AKCIJE", "IDK", "NAZIVK", "TIP", "PROIZVODJAC", "CENA");
    }

}
