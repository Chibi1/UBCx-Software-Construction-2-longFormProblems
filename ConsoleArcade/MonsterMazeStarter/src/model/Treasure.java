package model;

public class Treasure extends Choice {

    private int prize;

    private Monster monster;

    public Treasure(int prize) {
        setOptionMessage("Claim your treasure!");
        this.prize = prize;
    }

    //EFFECTS: prints a message representing this possible next choice
    @Override
    public void printOptionMessage() {
        System.out.println(getOptionMessage());
    }

    //EFFECTS: prints the result of choosing this choice
    public void printOutcome() {
        System.out.println("Your prize is " + prize + " spendibees.");
    }

}
