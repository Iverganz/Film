package DAO.impl;

import DAO.DAO;
import model.Director;
import DAO.DirectorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by пользователь on 20.03.2019.
 */
public class DirectorDAOImpl implements DirectorDAO {
    private DAO dao;

    public DirectorDAOImpl(DAO dao){
        this.dao=dao;
    }

    @Override
    public void addDirector(Director director) {
        String query = "INSERT INTO director (id_director,dir_name) VALUES (DEFAULT ,?)";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(1,director.getDirId());
            preparedStatement.setString(1,director.getDirName());
            preparedStatement.execute();
        }
        catch(SQLException e){e.printStackTrace();}
    }

    @Override
    public List<Director> getDirectors() {
        List<Director> directors=new ArrayList<>();
        String query ="select * from director;";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                Director director=new Director(id,name);
                directors.add(director);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return directors;
    }

    @Override
    public List<Director> getDirectors(String dirName) {
        return null;
    }

    @Override
    public Director getDirector(int directorId) {
        String query="SELECT * FROM director WHERE id_director= ?;";
        Director director=null;
        try(Connection connection=dao.getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,directorId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                director=new Director(id,name);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return director;
    }

    @Override
    public void updateDirector(Director director) {
        String query="UPDATE director SET dir_name=? WHERE id_director=?;";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(2,director.getDirId());
            preparedStatement.setString(1,director.getDirName());
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void deleteDirector(Director director) {
        String query="DELETE FROM director WHERE id_director=?;";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,director.getDirId());
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void deleteDirector(int directorId) {
        String query="DELETE FROM director WHERE id_director=?";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,directorId);
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }
}
