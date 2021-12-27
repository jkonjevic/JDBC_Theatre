package rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Konfiguracija;

import java.sql.SQLException;

public interface KonfiguracijaDAO extends CRUDDao<Konfiguracija,Integer>{

    public int countByRacunarId(int id) throws SQLException;



}
