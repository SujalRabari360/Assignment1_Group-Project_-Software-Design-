package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!

 * @auther: Sujal Rabari
 * @auther: Darshan Jagani
 * @auther: Diya
 * Date: March 01 2024
 * 
 * A class that models each Player in the game. Players have an identifier,
 * that is unique.
 * 
 */
public class Player {
    private String id;
    private String name;
    private ArrayList<Card> hand;
    private int score;

    public Player(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }
        this.name = name;
    }

    public Player(String id, String name, ArrayList<Card> cards, int score) {
        this.id = id;
        this.name = name;
        this.hand = cards;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}