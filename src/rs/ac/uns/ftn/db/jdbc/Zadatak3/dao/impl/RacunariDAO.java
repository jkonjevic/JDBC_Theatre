package rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Racunar;

import java.sql.SQLException;

public interface RacunariDAO extends CRUDDao<Racunar,Integer>{

    public int ukupanBrRacunara() throws SQLException;
}
