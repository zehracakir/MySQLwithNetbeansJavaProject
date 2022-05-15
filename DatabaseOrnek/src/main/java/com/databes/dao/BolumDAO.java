package com.databes.dao;

import com.database.model.Bolum;
import com.database.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zehra
 */
public class BolumDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public void addBolum(Bolum bolum) {
        connection = DBUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into BOLUM(BAdi) values(?)");
            preparedStatement.setString(1, bolum.getBAdi());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBUtil.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }

    public void updateBolum(Bolum bolum) {
        connection = DBUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("update Bolum set BAdi=? where BID=?");
            preparedStatement.setString(1, bolum.getBAdi());
            preparedStatement.setInt(2, bolum.getBID());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBUtil.closeConnection(connection);
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }

    public void deleteBolum(Bolum bolum) {
        connection = DBUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("delete from Bolum where BID=?");
            preparedStatement.setInt(1, bolum.getBID());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBUtil.closeConnection(connection);
            if (connection != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public Bolum getBolumById(int id) {
        Bolum bolum = null;
        ResultSet resultSet = null;
        connection = DBUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("select * from Bolum where BID");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                bolum = new Bolum();
                bolum.setBID(resultSet.getInt("BID"));
                bolum.setBAdi(resultSet.getString("BAdi"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBUtil.closeConnection(connection);
            if (connection != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());                }
            }
        }

        return bolum;
    }

    public List<Bolum> getAllBolum() {
        List<Bolum> bolumler = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;

        connection = DBUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from Bolum");
            while (resultSet.next()) {
                Bolum bolum = new Bolum();
                bolum.setBAdi(resultSet.getNString("BAdi"));
                bolum.setBID(resultSet.getInt("BID"));
                bolumler.add(bolum);
            }

        } catch (SQLException ex) {
          System.out.println(ex.getMessage());                
        } finally {
            DBUtil.closeConnection(connection);
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return bolumler;
    }

}
