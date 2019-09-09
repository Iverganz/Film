package DAO;

/**
 * Created by пользователь on 18.03.2019.
 */
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;

public abstract class DAO {
    protected String driver=null;
    protected String url = null;
    protected Properties properties = null;
    //public DAO(){}
    public DAO(String driver) {
        this.driver = driver;
    }

    protected void registerDriverManager() {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public abstract void setURL(String host, String database, int port);

    public abstract Connection getConnection();

    public void connect(String login, String password) {
        registerDriverManager();
        properties = new Properties();
        properties.setProperty("password", password);
        properties.setProperty("user", login);
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "utf8");
    }
}

