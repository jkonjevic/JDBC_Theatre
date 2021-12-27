package rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Akcija;

import java.sql.SQLException;

public interface AkcijaDAO extends CRUDDao<Akcija,Integer> {
    public boolean deleteTransactionalById(Integer id) throws SQLException;
}
