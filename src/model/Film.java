package model;

import java.sql.Date;

/**
 * Created by пользователь on 05.03.2019.
 */
public class Film {
private int idFilm;
private int idDir;
private Date premier;
private String filmName;
private int idCompany;

    public Film(int idFilm, int idDir, Date premier, String filmName, int idCompany) {
        this.idFilm = idFilm;
        this.idDir = idDir;
        this.premier = premier;
        this.filmName = filmName;
        this.idCompany = idCompany;
    }


    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public Film() {
    }

    public Film(int idDir, Date premier, String filmName) {

        this.idDir = idDir;
        this.premier = premier;
        this.filmName = filmName;
    }

    public Film(int idFilm, int idDir, Date premier, String filmName) {

        this.idFilm = idFilm;
        this.idDir = idDir;
        this.premier = premier;
        this.filmName = filmName;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    public Date getPremier() {
        return premier;
    }

    public void setPremier(Date premier) {
        this.premier = premier;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
}
