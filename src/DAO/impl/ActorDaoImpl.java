package DAO.impl;

import DAO.ActorDao;
import DAO.DAO;
import model.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActorDaoImpl implements ActorDao {
    private DAO dao;

    public ActorDaoImpl(DAO dao) {
        this.dao = dao;
    }



    @Override
    public void addActor(Actor actor) {
        String query = "INSERT INTO actor (id_actor,act_name) VALUES (DEFAULT ,?)";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(1,actor.getActorId());
            preparedStatement.setString(1,actor.getActorName());
            preparedStatement.execute();
        }
        catch(SQLException e){e.printStackTrace();}
    }

    @Override
    public List<Actor> getActors() {
        List<Actor> actors=new ArrayList<>();
        String query ="SELECT * FROM actor;";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Actor actor=new Actor(resultSet.getInt(ID_ACTOR),resultSet.getString(ACT_NAME));
                actors.add(actor);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return actors;
    }

    @Override
    public List<Actor> getActors(String actName) {
        return null;
    }

    @Override
    public Actor getActor(int actorId) {

        String query="SELECT * FROM actor WHERE id_actor= ?";
        Actor actor=null;
        try(Connection connection=dao.getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,actorId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                actor=new Actor(resultSet.getInt(ID_ACTOR),resultSet.getString(ACT_NAME));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return actor;
    }

    @Override
    public void updateActor(Actor actor) {
        String query="UPDATE actor SET act_name=? WHERE id_actor=?";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(2,actor.getActorId());
            preparedStatement.setString(1,actor.getActorName());
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}

    }

    @Override
    public void deleteActor(Actor actor) {
        String query="DELETE FROM actor WHERE id_actor=?";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,actor.getActorId());
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}

    }

    @Override
    public void deleteActor(int actorId) {
        String query="DELETE FROM actor WHERE id_actor=?";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,actorId);
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }
}
