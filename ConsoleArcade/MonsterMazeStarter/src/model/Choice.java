package model;

public abstract class Choice {
    private String optionMessage;

    public Choice() {
        this.optionMessage = "Fight a monster.";

//        treasure = null;
    }

    public String getOptionMessage() {
        return optionMessage;
    }

    public void setOptionMessage(String optionMessage) {
        this.optionMessage = optionMessage;
    }

    //EFFECTS: prints a message representing this possible next choice
    public void printOptionMessage() {
        System.out.println(optionMessage);
    }

    //EFFECTS: prints the result of choosing this choice
    public abstract void printOutcome();
}
