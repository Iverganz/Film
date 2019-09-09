package DAO;

import model.Actor;
import model.FilmActor;

import java.util.HashMap;
import java.util.List;

/**
 * Created by пользователь on 18.03.2019.
 */
public interface FilmActorDAO {
    String ID_FILM="id_film";
    String ID_ACTOR="id_actor";
    String ROLE="role";
    void addFilmActor(FilmActor filmActor);
    void deleteFilmActor(FilmActor filmActor);
    void updateFilmActor(FilmActor filmActor);
    //HashMap<Actor,String> getFilmActors(String role);
    List<FilmActor> getFilmsByActor(int id);
    HashMap<Actor,String> getActorsByFilm(int id);
    List<FilmActor> getFimsActors();
    FilmActor getFilmActor(int idF,int idA);
}
