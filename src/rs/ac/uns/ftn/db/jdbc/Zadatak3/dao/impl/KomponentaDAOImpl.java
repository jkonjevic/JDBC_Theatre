package rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dto.KomponenteAkcijaDTO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dto.RacunarskeKomponenteDTO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Akcija;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Komponenta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KomponentaDAOImpl implements KomponentaDAO{
    @Override
    public int count() throws SQLException {
        return 0;
    }

    @Override
    public boolean delete(Komponenta entity) throws SQLException {
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
    public Iterable<Komponenta> findAll() throws SQLException {
        return null;
    }

    @Override
    public Iterable<Komponenta> findAllById(Iterable<Integer> integers) throws SQLException {
        return null;
    }

    @Override
    public Komponenta findById(Integer integer) throws SQLException {
        return null;
    }

    @Override
    public boolean save(Komponenta entity) throws SQLException {
        return false;
    }

    private boolean saveTransactional(Connection connection, int akc) throws SQLException {
        String updateCommand = "update komponenta set akc=null where akc=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateCommand)) {
            int i = 1;

            preparedStatement.setInt(1, akc);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected == 1;
        }
    }

    private boolean existsByIdTransactional(Connection connection, Integer id) throws SQLException {
        String query = "select * from komponenta where idk=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.isBeforeFirst();
            }
        }
    }

    public int saveAllDelete(int akc) throws SQLException {

        int rowsSaved = 0;

        try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
            connection.setAutoCommit(false); // transaction start

            // insert or update every theatre

                boolean success = saveTransactional(connection, akc); // changes are visible only to current connection
                if (success) rowsSaved++;


            connection.commit(); // transaction ends successfully, changes are now visible to other connections as well
        }

        return rowsSaved;
    }


    @Override
    public int saveAll(Iterable<Komponenta> entities) throws SQLException {

        int rowsSaved = 0;

        try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
            connection.setAutoCommit(false); // transaction start

            // insert or update every theatre
            for (Komponenta entity : entities) {
                boolean success = saveTransactional(connection, entity.getAKC()); // changes are visible only to current connection
                if (success) rowsSaved++;
            }

            connection.commit(); // transaction ends successfully, changes are now visible to other connections as well
        }

        return rowsSaved;
    }




    public List<KomponenteAkcijaDTO> findAllByAkcijaId(int id) throws SQLException{
            List<KomponenteAkcijaDTO> listaKomponenti = new ArrayList<KomponenteAkcijaDTO>();
        String query = "select a1.ida, a1.naziva,a1.popust, k1.cena, k1.idk, k1.nazivk, k1.proizvodjac, k1.tip \n"
                + "from komponenta k1, akcija a1 \n"
                +"where k1.akc = a1.ida and a1.ida = ?";



        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);)
             {
                 preparedStatement.setInt(1, id);
                 ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                KomponenteAkcijaDTO komponentaDTO = new KomponenteAkcijaDTO(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(5),
                        resultSet.getString(6),resultSet.getString(8),resultSet.getString(7),resultSet.getDouble(4));
                listaKomponenti.add(komponentaDTO);
            }

        }


        return listaKomponenti;
    }



    public List<RacunarskeKomponenteDTO> findKomponenteByRacunarId(int id) throws SQLException{
        List<RacunarskeKomponenteDTO> listaKomponenti = new ArrayList<RacunarskeKomponenteDTO>();
        String query = "select p.idk, p.nazivk, p.tip, p.proizvodjac, p.cena, k.idr, r.nazivr, p.akc, k.komada \n"
                + "from konfiguracija k, komponenta p, racunar r \n"
                +"where k.idk = p.idk and k.idr = ? and r.idr = k.idr";



        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);)
        {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                RacunarskeKomponenteDTO komponentaDTO = new RacunarskeKomponenteDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4),resultSet.getDouble(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getInt(8),resultSet.getInt(9));
                listaKomponenti.add(komponentaDTO);
            }

        }


        return listaKomponenti;
    }


}
