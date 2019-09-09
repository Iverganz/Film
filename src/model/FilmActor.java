package model;

/**
 * Created by пользователь on 06.03.2019.
 */
public class FilmActor {
    private int idFilm;
    private int idActor;
private String role;

    public FilmActor(int idFilm, int idActor, String role) {
        this.idFilm = idFilm;
        this.idActor = idActor;
        this.role = role;
    }

    public String getRole() {

        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public FilmActor() {
    }

    public int getIdFilm() {

        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public FilmActor(int idFilm, int idActor) {
        this.idFilm = idFilm;
        this.idActor = idActor;
    }
}
