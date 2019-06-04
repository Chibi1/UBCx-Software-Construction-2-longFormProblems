package model.observer_pattern;

import model.Game;
import model.PlayerCard;

public interface GameObserver {

    //EFFECTS: updates observer
    public void update(Game Game);

}
