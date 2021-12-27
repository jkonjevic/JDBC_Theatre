package rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Racunar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RacunariDAOImpl implements RacunariDAO{

    @Override
    public int count() throws SQLException {
        String query = "select count(*) from racunari";

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return -1;
            }
        }
    }


    @Override
    public boolean delete(Racunar entity) throws SQLException {
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
    public Iterable<Racunar> findAll() throws SQLException {
        return null;
    }

    @Override
    public Iterable<Racunar> findAllById(Iterable<Integer> integers) throws SQLException {
        return null;
    }

    @Override
    public Racunar findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public boolean save(Racunar entity) throws SQLException {
        return false;
    }

    @Override
    public int saveAll(Iterable<Racunar> entities) throws SQLException {
        return 0;
    }


    public int ukupanBrRacunara() throws SQLException {
        String query = "select count(*) from racunar";
        int rezultat = 0;
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return -1;
            }
        }
    }

}
