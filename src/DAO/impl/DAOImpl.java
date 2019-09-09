package DAO.impl;


import DAO.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOImpl extends DAO {

    private static DAO dao;
    public static final String DEFAULT_HOST = "localhost";
    public static final String DEFAULT_DATABASE = "films";
    public static final String DEFAULT_LOGIN = "postgres";
    public static final String DEFAULT_PASSWORD = "1234";
    public static final int DEFAULT_PORT = 5432;
    public static final String DEFAULT_URL= "jdbc:postgresql://localhost:5432/films";

    public DAOImpl() {
        super("org.postgresql.Driver");
    }

    @Override
    public void setURL(String host, String database, int port) {
        if (database.length() > 0)
            this.url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        else
            this.url = "jdbc:postgresql://" + host + ":" + port;
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }
        Connection connection=null;
        try {
             connection = DriverManager.getConnection(url,DEFAULT_LOGIN, DEFAULT_PASSWORD);
            //return connection;

        }
        catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();

        }
        return connection;
    }

    @Override
    public void connect(String login, String password) {
        super.connect(login, password);
    }

    public static void initInstance() {
        if (dao == null) {
            dao = new DAOImpl();
        }
    }
    public static DAO getInstance(){
        return dao;
    }
}
