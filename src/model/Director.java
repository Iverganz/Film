package model;

/**
 * Created by пользователь on 05.03.2019.
 */
public class Director {
    private int dirId;
    private String dirName;

    public Director() {
    }

    public Director(String dirName) {
        this.dirName = dirName;
    }

    public Director(int dirId, String dirName) {
        this.dirId = dirId;
        this.dirName = dirName;
    }

    public int getDirId() {
        return dirId;
    }

    public void setDirId(int dirId) {
        this.dirId = dirId;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }
}
