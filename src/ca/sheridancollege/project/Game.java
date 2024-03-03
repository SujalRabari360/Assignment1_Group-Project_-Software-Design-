package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * SYST 17796 Project Base code.
 * @auther: Sujal Rabari
 * @auther: Darshan Jagani
 * @auther: Diya
 * Date: March 01 2024
 * The class that models the game.
 * 
 */
/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 */
public abstract class Game {

    //the title of the game
    private final String gameName;
    // the players of the game
    private ArrayList<Player> players;

    /**
     * constructor for given name and player
     * @param givenName
     * @param players
     */
    public Game(String givenName, ArrayList<Player> players) {
        this.gameName = givenName;
        this.players = players;
    }

    /**
     * @return the gameName
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * This method to declare and display a winning
     * player and end the game.
     * @param players
     */
    public abstract void declareWinner(ArrayList<Player> players);

}// end class
