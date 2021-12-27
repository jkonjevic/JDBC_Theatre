package rs.ac.uns.ftn.db.jdbc.Zadatak3.service;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl.KomponentaDAO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl.KomponentaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Akcija;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Komponenta;

import java.sql.SQLException;
import java.util.List;

public class KomponentaService {
    private static final KomponentaDAO komponentaDAO = new KomponentaDAOImpl();

    public int saveAll(List<Komponenta> komponentaList) throws SQLException {
        return komponentaDAO.saveAll(komponentaList);
    }
    public int saveAllDeleteAkcije(int akc) throws SQLException {
        return komponentaDAO.saveAllDelete(akc);
    }


}
