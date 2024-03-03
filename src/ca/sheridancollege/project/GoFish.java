package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * SYST 17796 Project Base code.
 * @auther: Sujal Rabari
 * @auther: Darshan Jagani
 * @auther: Diya
 * Date: March 01 2024
 * This class is for the Go-fish methods used to play the game
 * 
 */
public class GoFish extends Game {

    public GoFish(String gameName, ArrayList<Player> players) {
        super(gameName, players);
    }

    public int askPlayerForCard(Player player, int cardValue) {
        int numMatch = 0;

        for (Card card : player.getHand()) {
            if (card.getValue() == cardValue) {
                numMatch++;
            }
        }

        return numMatch;
    }

    public void removeIfHasBook(Player currentPlayer, int targetCardValue) {
        if (hasBook(currentPlayer)) {
            currentPlayer.setScore(currentPlayer.getScore() + 1);

            ArrayList<Card> currentPlayerHand = currentPlayer.getHand();
            for (int i = currentPlayerHand.size() - 1; i >= 0; i--) {
                if (currentPlayerHand.get(i).getValue() == targetCardValue) {
                    currentPlayerHand.remove(i);
                }
            }
        }
    }

    public void goFishing(Player player, ArrayList<Card> cards) {
        if (!cards.isEmpty()) {
            player.getHand().add(cards.remove(cards.size() - 1));
        }
    }

    public void getCardsFromPlayer(Player currentPlayer, Player targetPlayer, int targetCardValue) {
        ArrayList<Card> currentPlayerHand = currentPlayer.getHand();
        ArrayList<Card> targetPlayerHand = targetPlayer.getHand();

        for (int j = 0; j < targetPlayerHand.size(); j++) {
            if (targetPlayerHand.get(j).getValue() == targetCardValue) {
                currentPlayerHand.add(targetPlayerHand.remove(j));
                j = -1;
            }
        }
    }

    @Override
    public void declareWinner(ArrayList<Player> players) {
        int maxScore = -1;
        String winnerName = "";
        for (Player player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
                winnerName = player.getName();
            }
        }
        System.out.println("The winner is " + winnerName + " with a score of " + maxScore);
    }

    public boolean hasBook(Player player) {
        int[] ranks = new int[13];

        for (Card card : player.getHand()) {
            ranks[card.getValue() - 1]++;
        }

        for (int rank : ranks) {
            if (rank == 4) {
                return true;
            }
        }
        return false;
    }
}
