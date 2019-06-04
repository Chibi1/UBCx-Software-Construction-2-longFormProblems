package model;

import model.observer_pattern.Subject;
import model.random.BingoNumber;

import java.util.ArrayList;
import java.util.List;

public class Game extends Subject {

    public static final int CARD_SIZE = 25;
    public static final int SIDE_LENGTH = (int) Math.sqrt(CARD_SIZE);

    private BingoNumber currentCall;
    private List<PlayerCard> cards;
    private boolean gameOver;

    public Game() {
        cards = new ArrayList<>();
        callNext();
    }

    //getters
    public BingoNumber getCurrentCall(){
        return currentCall;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public List<PlayerCard> getCards() {
        List<PlayerCard> playerCards = new ArrayList<>();
        for (PlayerCard o : cards) { //NOTE: refactor this line ONLY.
            if (o.getClass().getSimpleName().equals("PlayerCard"))
                playerCards.add(o);
        }
        return playerCards;
    }

    //EFFECTS: generates the next bingo call and notifies observers
    public void callNext() {
        currentCall = new BingoNumber();
        notifyObservers(this);
    }

    //MODIFIES: this
    //EFFECTS: adds observer to list of observers
    public void addCard(PlayerCard pc) {
        if (!cards.contains(pc)) {
            cards.add(pc);
            addObserver(pc);
        }
    }

    //EFFECTS: sets game over to true if one of the players has bingo
    public void refreshGameOver(){
        for (PlayerCard pc : cards) {
            PlayerCard p = pc;
            if (p.hasBingo()) {
                gameOver = true;
                break;
            }
        }
    }
}
