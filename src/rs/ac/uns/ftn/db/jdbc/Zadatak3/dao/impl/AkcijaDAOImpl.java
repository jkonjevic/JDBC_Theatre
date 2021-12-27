package rs.ac.uns.ftn.db.jdbc.Zadatak3.dao.impl;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Akcija;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AkcijaDAOImpl implements AkcijaDAO {

    @Override
    public int count() throws SQLException {
        String query = "select count(*) from akcija";

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
    public boolean delete(Akcija entity) throws SQLException {
        return deleteById(entity.getIDA());
        }


    @Override
    public int deleteAll() throws SQLException {
        String query = "delete from akcija";

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            int rowsAfffected = preparedStatement.executeUpdate();
            return rowsAfffected;
        }

    }
    @Override
    public boolean deleteById(Integer id) throws SQLException {
        String query = "delete from akcija where ida=?";

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected == 1;
        }

    }

    @Override
    public boolean existsById(Integer id) throws SQLException {
        try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
            return existsByIdTransactional(connection, id);
        }
    }

    @Override
    public Iterable<Akcija> findAll() throws SQLException {
        String query = "select ida, naziva, popust  from akcija";
        List<Akcija> akcijaList = new ArrayList<Akcija>();
        Connection connection = ConnectionUtil_HikariCP.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Akcija theatre = new Akcija(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                akcijaList.add(theatre);
            }

        }
        return akcijaList;
    }

    @Override
    public Iterable<Akcija> findAllById(Iterable<Integer> ids) throws SQLException {
        List<Akcija> akcijaList = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        String queryBegin = "select ida, naziva, popust from akcija where ida in(";
        stringBuilder.append(queryBegin);

        for (@SuppressWarnings("unused")
                Integer id : ids) {
            stringBuilder.append("?,");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1); // delete last ','
        stringBuilder.append(")");

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(stringBuilder.toString());) {

            int i = 0;
            for (Integer id : ids) {
                preparedStatement.setInt(++i, id);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    akcijaList.add(new Akcija(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
                }
            }
        }

        return akcijaList;
    }

    @Override
    public Akcija findById(Integer id) throws SQLException {
        String query = "select ida, naziva,popust  from akcija where ida = ?";
        Akcija akcija = null;

        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.isBeforeFirst()) {
                    resultSet.next();

                    akcija = new Akcija(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                }
            }
        }

        return akcija;
    }

    public boolean deleteTransactionalById(Integer id) throws SQLException {
        String query = "delete from akcija where ida=?";
        Akcija a1 = new Akcija();
        a1 = findById(id);
        try (Connection connection = ConnectionUtil_HikariCP.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            saveTransactionalDelete(connection, a1);

            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected == 1;
        }

    }


    @Override
    public boolean save(Akcija entity) throws SQLException {
        try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
            return saveTransactional(connection, entity);
        }
    }

    @Override
    public int saveAll(Iterable<Akcija> entities) throws SQLException {

        int rowsSaved = 0;

        try (Connection connection = ConnectionUtil_HikariCP.getConnection()) {
            connection.setAutoCommit(false); // transaction start

            // insert or update every theatre
            for (Akcija entity : entities) {
                boolean success = saveTransactional(connection, entity); // changes are visible only to current connection
                if (success) rowsSaved++;
            }

            connection.commit(); // transaction ends successfully, changes are now visible to other connections as well
        }

        return rowsSaved;
    }

    private boolean existsByIdTransactional(Connection connection, Integer id) throws SQLException {
        String query = "select * from akcija where ida=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.isBeforeFirst();
            }
        }
    }
    private boolean saveTransactional(Connection connection, Akcija entity) throws SQLException {
        // id_th intentionally in the last place, so that the order between commands remains the same
        String insertCommand = "insert into akcija (naziva,popust,ida) values (?, ?, ?)";
        String updateCommand = "update akcija set naziva=?, popust=? where ida=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                existsByIdTransactional(connection, entity.getIDA()) ? updateCommand : insertCommand)) {
            int i = 1;

            preparedStatement.setString(i++, entity.getNazivA());
            preparedStatement.setInt(i++, entity.getPopust());
            preparedStatement.setInt(i++, entity.getIDA());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected == 1;
        }
    }

    private void saveTransactionalDelete(Connection connection, Akcija entity) throws SQLException {
        String updateCommand = "update akcija set popust=0 where ida=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                existsByIdTransactional(connection, entity.getIDA()) ? updateCommand : updateCommand)) {

            preparedStatement.setInt(1, entity.getIDA());

            int rowsAffected = preparedStatement.executeUpdate();

        }
    }


}
