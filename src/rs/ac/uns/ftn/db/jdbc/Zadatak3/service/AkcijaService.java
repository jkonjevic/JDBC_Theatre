package rs.ac.uns.ftn.db.jdbc.Zadatak3.service;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl.AkcijaDAO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl.AkcijaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl.KomponentaDAO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl.KomponentaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dto.KomponenteAkcijaDTO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Akcija;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AkcijaService {

    private static final AkcijaDAO akcijaDAO = new AkcijaDAOImpl();
    private static final KomponentaDAO komponentaDAO = new KomponentaDAOImpl();

    public ArrayList<Akcija> getAll() throws SQLException {
        return (ArrayList<Akcija>) akcijaDAO.findAll();
    }

    public Akcija getById(int id) throws SQLException {
        return akcijaDAO.findById(id);
    }

    public boolean existsById(int id) throws SQLException {
        return akcijaDAO.existsById(id);
    }

    public boolean save(Akcija p) throws SQLException {
        return akcijaDAO.save(p);
    }

    public boolean deleteById(int id) throws SQLException {
        return akcijaDAO.deleteById(id);
    }

    public int saveAll(List<Akcija> pozoristeList) throws SQLException {
        return akcijaDAO.saveAll(pozoristeList);
    }
    public boolean deleteTransactional(int id) throws SQLException {
        return akcijaDAO.deleteTransactionalById(id);
    }
    public List<KomponenteAkcijaDTO> getAllKomponenteNaAkcijiAndDelete(int id) throws SQLException {
        List<KomponenteAkcijaDTO> komponentaList = new ArrayList<KomponenteAkcijaDTO>();

        komponentaList = komponentaDAO.findAllByAkcijaId(id);
        return komponentaList;
    }

}
