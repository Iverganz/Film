package model;

/**
 * Created by пользователь on 05.03.2019.
 */
public class Company {
    private int comId;
    private String comName;

    public Company() {
    }

    public Company(String comName) {
        this.comName = comName;
    }

    public Company(int comId, String comName) {
        this.comId = comId;
        this.comName = comName;
    }

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }
}
