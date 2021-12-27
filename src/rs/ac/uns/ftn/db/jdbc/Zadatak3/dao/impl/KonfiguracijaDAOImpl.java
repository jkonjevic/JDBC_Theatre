package rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Konfiguracija;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KonfiguracijaDAOImpl implements KonfiguracijaDAO {
    @Override
    public int count() throws SQLException {
        return 0;
    }

    @Override
    public boolean delete(Konfiguracija entity) throws SQLException {
        return false;
    }

    @Override
    public int deleteAll() throws SQLException {
        return 0;
    }

    @Override
    public boolean deleteById(Integer integer) throws SQLException {
        return false;
    }

    @Override
    public boolean existsById(Integer integer) throws SQLException {
        return false;
    }

    @Override
    public Iterable<Konfiguracija> findAll() throws SQLException {
        return null;
    }

    @Override
    public Iterable<Konfiguracija> findAllById(Iterable<Integer> integers) throws SQLException {
        return null;
    }

    @Override
    public Konfiguracija findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public boolean save(Konfiguracija entity) throws SQLException {
        return false;
    }

    @Override
    public int saveAll(Iterable<Konfiguracija> entities) throws SQLException {
        return 0;
    }

    public int countByRacunarId(int id) throws SQLException {
        int rezultat = 0;
        String query = "select count(*) \n"
                + "from konfiguracija \n"
                + "where idr = ?";


        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.absolute(1);
            rezultat = resultSet.getInt(1);

            return rezultat;
        }

    }



}
