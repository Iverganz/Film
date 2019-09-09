package DAO.impl;

import DAO.DAO;
import DAO.FilmActorDAO;
import model.Actor;
import model.FilmActor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by пользователь on 22.03.2019.
 */
public class FilmActorDAOImpl implements FilmActorDAO {

    private DAO dao;

    public FilmActorDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void addFilmActor(FilmActor filmActor) {
        String query="INSERT INTO film_actor (id_film,id_actor,role) VALUES(?,?,?)";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,filmActor.getIdFilm());
            preparedStatement.setInt(2,filmActor.getIdActor());
            preparedStatement.setString(3,filmActor.getRole());
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void deleteFilmActor(FilmActor filmActor) {
        String query="DELETE FROM film_actor WHERE id_film=? AND id_actor=?";
        try(Connection connection=dao.getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,filmActor.getIdFilm());
            preparedStatement.setInt(2,filmActor.getIdActor());
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}

    }

    @Override
    public void updateFilmActor(FilmActor filmActor) {
        String query="UPDATE film_actor SET role=? WHERE (id_film=? AND id_actor=?)";
        try(Connection connection=dao.getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,filmActor.getRole());
            preparedStatement.setInt(2,filmActor.getIdFilm());
            preparedStatement.setInt(3,filmActor.getIdActor());
        }
        catch (SQLException e){e.printStackTrace();}
    }

   /* @Override
    public HashMap<Actor,String> getFilmActors(String role) {
        return null;
    }*/

    @Override
    public List<FilmActor> getFilmsByActor(int id) {
        return null;
    }

    @Override
    public  HashMap<Actor,String> getActorsByFilm(int id) {
        String query="SELECT a.id_actor,a.act_name,fa.role FROM actor a, film_actor fa WHERE a.id_actor=fa.id_actor AND fa.id_film=?  ";
        HashMap<Actor,String> filmActors=new HashMap<>();
        try(Connection connection=dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Actor actor=new Actor(resultSet.getInt(1),resultSet.getString(2));
                String role=resultSet.getString(3);
                filmActors.put(actor,role);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return filmActors;

    }

    @Override
    public List<FilmActor> getFimsActors() {
        String query="SELECT * FROM film_actor";
        List<FilmActor> filmActors=new ArrayList<>();
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                FilmActor filmActor=new FilmActor(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3));
                filmActors.add(filmActor);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return filmActors;
    }

    @Override
    public FilmActor getFilmActor(int idF,int idA) {
        String query="SELECT * FROM film_actor WHERE (id_film=? AND id_actor=?)";
        FilmActor filmActor=null;
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,idF);
            preparedStatement.setInt(2,idA);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                filmActor=new FilmActor(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3));

            }
        }
        catch (SQLException e){e.printStackTrace();}
        return filmActor;
    }
}
