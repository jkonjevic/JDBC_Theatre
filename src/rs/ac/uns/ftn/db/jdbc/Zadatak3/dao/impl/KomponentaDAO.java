package rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl;


import rs.ac.uns.ftn.db.jdbc.Zadatak3.dto.KomponenteAkcijaDTO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dto.RacunarskeKomponenteDTO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Komponenta;

import java.sql.SQLException;
import java.util.List;

public interface KomponentaDAO extends CRUDDao<Komponenta,Integer>{

    public List<KomponenteAkcijaDTO> findAllByAkcijaId(int id) throws SQLException;

    public List<RacunarskeKomponenteDTO> findKomponenteByRacunarId(int id) throws SQLException;

    public int saveAllDelete(int akc) throws SQLException;


}
