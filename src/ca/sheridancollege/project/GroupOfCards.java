package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * @auther: Sujal Rabari
 * @auther: Darshan Jagani
 * @auther: Diya
 * Date: March 01 2024
 * 
 * A concrete class that represents any grouping of cards for a Game.
 * 
 */
public class GroupOfCards {
    private ArrayList<Card> cards;
    private int size;

    public GroupOfCards(int givenSize) {
        this.size = givenSize;
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int givenSize) {
        size = givenSize;
    }
}