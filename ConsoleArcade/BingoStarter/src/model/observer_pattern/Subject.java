package model.observer_pattern;

import model.Game;
import model.PlayerCard;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<GameObserver> gameObservers;

    public Subject(){
        gameObservers = new ArrayList<>();
    }

    public List<GameObserver> getGameObservers() {
        return gameObservers;
    }

    //MODIFIES: this
    //EFFECTS: adds observer to list of gameObservers
    public void addObserver(GameObserver o) {
        if (!gameObservers.contains(o)) {
            gameObservers.add(o);
        }
    }

    //EFFECTS: notifies gameObservers of state change
    public void notifyObservers(Game game){
        for (GameObserver gameObserver : gameObservers) {
            gameObserver.update(game);
        }
    }

}
