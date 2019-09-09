package DAO;

import model.Actor;

import java.util.List;

/**
 * Created by пользователь on 18.03.2019.
 */
public interface ActorDao {
    String ID_ACTOR="id_actor";
    String ACT_NAME="act_name";
    void addActor(Actor actor);
    List<Actor> getActors();
    List<Actor> getActors(String actName);
    Actor getActor(int actorId);
    void updateActor(Actor actor);
    void deleteActor(Actor actor);
    void deleteActor(int actorId);
}
