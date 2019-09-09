package DAO;

import model.Film;

import java.sql.Date;
import java.util.List;

/**
 * Created by пользователь on 18.03.2019.
 */
public interface FilmDAO {
    String ID_FILM="id_film";
    String ID_DIRECTOR="id_director";
    String PREMIERE_DATE="premiere_date";
    String FILM_NAME="film_name";
    void addFilm(Film film);
    List<Film>  getFilms();
    List<Film> getFilms(int dirId);
    List<Film> getFilms(String filmName);
    List<Film> getFilms(Date premiereDate);
    void updateFilm (Film film);
    void deleteFilm (Film film);
    void deleteFilm (int filmId);
    Film getFilm(int filmId);
}
