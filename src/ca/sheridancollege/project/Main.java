package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * SYST 17796 Project Base code.
 * @auther: Sujal Rabari
 * @auther: Darshan Jagani
 * @auther: Diya
 * Date: March 01 2024
 * 
 * This is the main class from the go fish game that holds the main method game
 * 
 */
public class Main {

    public static void main(String[] args) {
        final int DECK_COUNT = 52;
        final int BASE_HAND_COUNT = 5;
        Scanner input = new Scanner(System.in);

        ArrayList<Card> tempCards = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            Card tempCard;
            for (int j = 0; j < 4; j++) {
                String suit = "";
                switch (j) {
                    case 0:
                        suit = "Spade";
                        break;
                    case 1:
                        suit = "Club";
                        break;
                    case 2:
                        suit = "Diamond";
                        break;
                    case 3:
                        suit = "Heart";
                        break;
                }
                tempCard = new Card(i + 1, suit);
                tempCards.add(tempCard);
            }
        }

        GroupOfCards tempDeck = new GroupOfCards(DECK_COUNT);
        tempDeck.setCards(tempCards);
        tempDeck.shuffle();
        ArrayList<Card> deck = tempDeck.getCards();

        ArrayList<Player> players = new ArrayList<>();
        System.out.println("How many players?");
        int playerCount = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                playerCount = input.nextInt();
                if (playerCount >= 2 && playerCount <= 6) {
                    validInput = true;
                } else {
                    System.out.print("Pick a number from 2-6: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid input. Pick a number from 2-6: ");
                input.nextLine(); // Clear the buffer
            }
        }

        for (int i = 0; i < playerCount; i++) {
            ArrayList<Card> hand = new ArrayList<>();
            for (int j = 0; j < BASE_HAND_COUNT; j++) {
                hand.add(deck.remove(0)); // Always remove the first card from the deck
            }

            System.out.print("Please enter player name: ");
            String name = input.next();

            players.add(new Player(String.valueOf(i + 1), name, hand, 0));
        }

        GoFish goFish = new GoFish("Go-Fish", players);
        while (deck.size() > 0) {
            int counter = 0;
            boolean activeTurn = true;

            while (counter < playerCount) {
                do {
                    Player currentPlayer = players.get(counter);
                    System.out.println("Current Player Turn: " + currentPlayer.getName());
                    System.out.println("Score: " + currentPlayer.getScore());
                    System.out.println("Current Hand: " + currentPlayer.getHand() + "\n");

                    System.out.print("Please select player to confront from the list using the number beside the name [");
                    for (Player player : players) {
                        System.out.print(" " + player.getName() + " (" + player.getId() + ") ");
                    }
                    System.out.print("]: ");

                    int playerNumber = input.nextInt();
                    while (playerNumber == Integer.parseInt(currentPlayer.getId()) || playerNumber > playerCount
                            || playerNumber != (int) playerNumber) {
                        System.out.println("Can't pick yourself or a non-existing player! Try again: ");
                        playerNumber = input.nextInt();
                    }
                    Player targetPlayer = players.get(playerNumber - 1);

                    System.out.print("What card do you want to ask for? (A 2 3 4 5 6 7 8 9 10 J Q K): ");
                    String targetCard = input.next();

                    int targetCardValue;
                    if (targetCard.equalsIgnoreCase("A")) {
                        targetCardValue = 1;
                    } else if (targetCard.equalsIgnoreCase("J")) {
                        targetCardValue = 11;
                    } else if (targetCard.equalsIgnoreCase("Q")) {
                        targetCardValue = 12;
                    } else if (targetCard.equalsIgnoreCase("K")) {
                        targetCardValue = 13;
                    } else {
                        targetCardValue = Integer.parseInt(targetCard);
                    }

                    int numOfMatches = goFish.askPlayerForCard(targetPlayer, targetCardValue);
                    if (numOfMatches < 1) {
                        goFish.goFishing(currentPlayer, deck);
                        activeTurn = false;
                        counter++;
                    } else {
                        goFish.getCardsFromPlayer(currentPlayer, targetPlayer, targetCardValue);
                        goFish.removeIfHasBook(currentPlayer, targetCardValue);
                    }
                    goFish.removeIfHasBook(currentPlayer, targetCardValue);

                    for (Player player : players) {
                        System.out.println(player.getName());
                        System.out.println(player.getHand());
                    }
                } while (activeTurn);
            }
        }

        goFish.declareWinner(players);

        input.close();
    }
}