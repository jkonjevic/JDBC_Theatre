package rs.ac.uns.ftn.db.jdbc.Zadatak3.service;


import rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl.*;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dto.KomponenteAkcijaDTO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dto.RacunarskeKomponenteDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplexFuncionalityService {


    private static final KomponentaDAO komponentaDAO = new KomponentaDAOImpl();
    private static final KonfiguracijaDAO konfiguracijaDAO = new KonfiguracijaDAOImpl();
    private static final RacunariDAO racunariDAO = new RacunariDAOImpl();


    public List<KomponenteAkcijaDTO> getAllKomponenteNaAkciji(int id) throws SQLException {
        List<KomponenteAkcijaDTO> komponentaList = new ArrayList<KomponenteAkcijaDTO>();

        komponentaList = komponentaDAO.findAllByAkcijaId(id);
        return komponentaList;
    }

    public List<RacunarskeKomponenteDTO> GetKomponentaByRacunarId(int id) throws SQLException {
        List<RacunarskeKomponenteDTO> komponentaList = new ArrayList<RacunarskeKomponenteDTO>();

        komponentaList = komponentaDAO.findKomponenteByRacunarId(id);
        return komponentaList;
    }

    public int brojRacunara() throws SQLException {
        int rezultat = racunariDAO.ukupanBrRacunara();
        return rezultat;
    }

    public int brojKomponentiRacunara(int id) throws SQLException {
        int rezultat = konfiguracijaDAO.countByRacunarId(id);
        return rezultat;
    }

}
