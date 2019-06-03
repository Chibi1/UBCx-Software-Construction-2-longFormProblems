package model;

import java.util.ArrayList;
import java.util.List;

public class Room extends Choice {

    private List<Choice> choices;
    private int id;

    public Room(int id) {
        setOptionMessage("Enter Room " + id + ".");
        this.id = id;
        choices = new ArrayList<>();
        choices.add(0, null);
    }

    //EFFECTS: prints a message representing this possible next choice
    @Override
    public void printOptionMessage() {
        System.out.println(getOptionMessage());
    }

    //EFFECTS: prints all possible next choices
    public void printOutcome() {
        System.out.println("You are now in Room " + id + ".\n");
        System.out.println("You have the following options: ");
        for (int i = 1; i < getChoiceRange(); i++) {
            System.out.print("\tOption " + i + ": ");
            getChoice(i).printOptionMessage();
        }
    }

    public void addChoice(Choice choice) {
        choices.add(choice);
    }

    public Choice getChoice(int i) {
        return choices.get(i);
    }

    public int getChoiceRange() {
        return choices.size();
    }

}
