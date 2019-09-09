package DAO.impl;

import DAO.DAO;
import DAO.FilmDAO;
import model.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by пользователь on 20.03.2019.
 */
public class FilmDAOImpl implements FilmDAO {
    private DAO dao;

    public FilmDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void addFilm(Film film) {
        String query = "insert into film (id_film,id_director,premiere_date,film_name,id_company)\n" +
                "VALUES(DEFAULT,?,?,?,?);";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,film.getIdDir());
            //preparedStatement.setString(1,film.getFilmName());
            preparedStatement.setDate(2,film.getPremier());
            preparedStatement.setString(3,film.getFilmName());
            preparedStatement.setInt(4,film.getIdCompany());
            preparedStatement.execute();
        }
        catch(SQLException e){e.printStackTrace();}
    }

    @Override
    public List<Film> getFilms() {
        List<Film> films=new ArrayList<>();
        String query="SELECT * FROM film";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            Film film=new Film(resultSet.getInt(1),resultSet.getInt(2),resultSet.getDate(3),resultSet.getString(4),resultSet.getInt(5));
            films.add(film);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return films;
    }

    @Override
    public List<Film> getFilms(int dirId) {
        return null;
    }

    @Override
    public List<Film> getFilms(String filmName) {
        return null;
    }

    @Override
    public List<Film> getFilms(Date premiereDate) {
        return null;
    }

    @Override
    public void updateFilm(Film film) {
        String query="UPDATE film SET id_director=?,premiere_date=?,film_name=?,id_company=? WHERE id_film=?;";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,film.getIdDir());
            preparedStatement.setDate(2,film.getPremier());
            preparedStatement.setString(3,film.getFilmName());
            preparedStatement.setInt(5,film.getIdFilm());
            preparedStatement.setInt(4,film.getIdCompany());
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}



    }

    @Override
    public void deleteFilm(Film film) {
        String query="DELETE FROM film WHERE id_film=?;";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,film.getIdFilm());
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void deleteFilm(int filmId) {
        String query="DELETE FROM film WHERE id_film=?;";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,filmId);
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public Film getFilm(int filmId) {
        String query="SELECT * FROM film WHERE id_film=?;";
        Film film=null;
        try(Connection connection=dao.getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,filmId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int dir=resultSet.getInt(2);
                Date pr=resultSet.getDate(3);
                String title=resultSet.getString(4);
                int co=resultSet.getInt(5);

                film=new Film(filmId,resultSet.getInt(2),resultSet.getDate(3),resultSet.getString(4),resultSet.getInt(5));
            }
        }

        catch (SQLException e){e.printStackTrace();}
        return film;
    }
}
