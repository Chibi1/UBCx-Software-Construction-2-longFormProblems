package model;

public class Monster extends Choice {

    private Treasure treasure;

    public Monster() {
        setOptionMessage("Fight a monster.");
        treasure = null;
    }

    //EFFECTS: prints a message representing this possible next choice
    public void printOptionMessage() {
        System.out.println(getOptionMessage());
    }

    //MODIFIES: this
    //EFFECTS: sets the treasure to t
    public void setTreasure(Treasure t) {
        this.treasure = t;
    }

    //EFFECTS: prints the result of choosing this choice
    public void printOutcome() {
        if (treasure == null) {
            System.out.println("Ha! I killed you!");
        } else {
            System.out.println("Ahh! You killed me!");
            treasure.printOutcome();
        }
    }

}
