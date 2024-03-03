package ca.sheridancollege.project;

/**
 * 
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 *
 * @auther: Sujal Rabari
 * @auther: Darshan Jagani
 * @auther: Diya
 * Date: March 01 2024
 *
 * A class is be used as the base Card class for the go-fish game.
 * 
 */
/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 *
 */
public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        if (value < 1 || value > 13) {
            throw new IllegalArgumentException("Card value must be between 1 and 13.");
        }
        if (!suit.equals("Spade") && !suit.equals("Club") && !suit.equals("Diamond") && !suit.equals("Heart")) {
            throw new IllegalArgumentException("Invalid card suit. Use 'Spade', 'Club', 'Diamond', or 'Heart'.");
        }
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }
 /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a
     * regular playing card etc.
     */
    @Override
    public String toString() {
        String cardValue;
        String cardSuitSymbol;

        if (value == 1) {
            cardValue = "A";
        } else if (value == 11) {
            cardValue = "J";
        } else if (value == 12) {
            cardValue = "Q";
        } else if (value == 13) {
            cardValue = "K";
        } else {
            cardValue = String.valueOf(value);
        }

        switch (suit) {
            case "Spade":
                cardSuitSymbol = "\u2660";
                break;
            case "Club":
                cardSuitSymbol = "\u2663";
                break;
            case "Diamond":
                cardSuitSymbol = "\u2666";
                break;
            case "Heart":
                cardSuitSymbol = "\u2665";
                break;
            default:
                cardSuitSymbol = "";
                break;
        }

        return cardValue + cardSuitSymbol;
    }
}