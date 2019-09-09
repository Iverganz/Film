package DAO;

import model.Director;

import java.util.List;

/**
 * Created by пользователь on 18.03.2019.
 */
public interface DirectorDAO {
        String ID_DIRECTOR="id_directo";
        String DIR_NAME="dir_name";
        void addDirector(Director director);
        List<Director> getDirectors();
        List<Director> getDirectors(String dirName);
        Director getDirector(int directorId);
        void updateDirector(Director director);
        void deleteDirector(Director director);
        void deleteDirector(int directorId);
}
