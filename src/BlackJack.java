//Benjamin Eric Cohen

import java.util.Scanner;
import java.util.Random;
import java.lang.String;
import java.text.DecimalFormat;

public class BlackJack {
    public static void main(String [] args){

        int gameNum = 0;
        int totalGames;
        int cardDraw; //Integer of card drawn for the player
        int playerHand; //Total value of players hand
        int dealerHand; //Total value of the dealers hand
        int playerWins = 0; //Total player wins
        int dealerWins = 0; //Total dealer wins
        int gameTies = 0; //Total tie games
        boolean playGame = true;
        Random card = new Random();
        Scanner scnr = new Scanner(System.in);

        String pattern = "###.0"; //Set's up the form of the decimal
        DecimalFormat decimalFormat = new DecimalFormat(pattern); //implements the decimal formatter

        while (playGame) {  //Loop will continue as long as playGame is true
            totalGames = gameNum;
            gameNum = gameNum + 1;

            System.out.println("START GAME #" + gameNum + "\n");

            //Starting values for a new game
            playerHand = 0;

            cardDraw = card.nextInt(13) + 1;

            /*Chooses the card name if applicable for the player and
            adds cards value to hand */
            switch (cardDraw) {
                case 1:
                    System.out.println("Your card is an ACE!");
                    playerHand = playerHand + 1;
                    break;
                case 8:
                    System.out.println("Your card is an 8!");
                    playerHand = playerHand + cardDraw;
                    break;
                case 11:
                    System.out.println("Your card is a JACK!");
                    playerHand = playerHand + 10;
                    break;
                case 12:
                    System.out.println("Your card is a QUEEN!");
                    playerHand = playerHand + 10;
                    break;
                case 13:
                    System.out.println("Your card is a KING!");
                    playerHand = playerHand + 10;
                    break;
                default:
                    System.out.println("Your card is a " + cardDraw + "!");
                    playerHand = playerHand + cardDraw;
                    break;
            }

            //Outputs the players total hand value
            System.out.println("Your hand is: " + playerHand);

            boolean menu = true; //menu is set to true at the the beginning for each new iteration of a game
            while (menu) { //Loop will repeat as long as menu is true
                //Menu
                System.out.println("\n1. Get another card\n2. Hold hand\n" +
                        "3. Print game statistics\n4. Exit");

                System.out.print("\nChoose an option: ");

                try {
                    int playerSelect = scnr.nextInt();

                    switch (playerSelect) {
                        case 1:
                            cardDraw = card.nextInt(13) + 1; //Card draw

                            /*Chooses the card name if applicable for the player and
                            adds cards value to hand */
                            switch (cardDraw) {
                                case 1:
                                    System.out.println("Your card is an ACE!");
                                    playerHand = playerHand + 1;
                                    break;
                                case 8:
                                    System.out.println("Your card is an 8!");
                                    playerHand = playerHand + cardDraw;
                                    break;
                                case 11:
                                    System.out.println("Your card is a JACK!");
                                    playerHand = playerHand + 10;
                                    break;
                                case 12:
                                    System.out.println("Your card is a QUEEN!");
                                    playerHand = playerHand + 10;
                                    break;
                                case 13:
                                    System.out.println("Your card is a KING!");
                                    playerHand = playerHand + 10;
                                    break;
                                default:
                                    System.out.println("Your card is a " + cardDraw + "!");
                                    playerHand = playerHand + cardDraw;
                                    break;
                            }

                            //Outputs the players total hand value
                            System.out.println("Your hand is: " + playerHand);

                            //Determines if player automatically loses or wins
                            if (playerHand > 21) {
                                System.out.println("\nYou exceeded 21! You lose :(\n");
                                dealerWins += 1;
                                menu = false; //Exits menu loop
                            }
                            if (playerHand == 21) {
                                System.out.println("\nBLACKJACK! You win!\n");
                                playerWins += 1;
                                menu = false; //Exits menu loop
                            }

                            break;

                        case 2:
                            //Player holds and dealer draws a card
                            dealerHand = card.nextInt(26 - 16) + 16;
                            System.out.println("\nDealer's hand: " + dealerHand);
                            System.out.println("Your hand is: " + playerHand + "\n");

                            if (dealerHand > 21) { //Dealer's hand exceeds 21
                                System.out.println("You win!\n");
                                playerWins += 1;
                            } else if (dealerHand == playerHand) { //Dealer and player's hand match
                                System.out.println("It's a tie! No one wins!\n");
                                gameTies += 1;
                            } else if (playerHand > dealerHand) { //Player hand is greater than dealers
                                System.out.println("You win!\n");
                                playerWins += 1;
                            } else { //Dealer's hand is greater than the players
                                System.out.println("Dealer wins!\n");
                                dealerWins += 1;
                            }
                            menu = false; //Exits menu loop
                            break;

                        case 3:
                            //Display the games statistics
                            System.out.println("Number of Player wins: " + playerWins);
                            System.out.println("Number of Dealer wins: " + dealerWins);
                            System.out.println("Number of tie games: " + gameTies);
                            System.out.println("Total # of games played is: " + totalGames);
                            if (totalGames == 0) {
                                System.out.println("Percentage of Player wins: 0.0%"); //In order to avoid divide by zero
                            }
                            else {
                                float playerPercentWins = (playerWins * 100.0f) / totalGames;
                                String stringPlayerPercentWins = decimalFormat.format((double)playerPercentWins);
                                System.out.println("Percentage of Player wins: " + stringPlayerPercentWins + "%");

                            }
                            break;

                        case 4:
                            //Exits the game
                            playGame = false; //Breaks the codes looping
                            menu = false; //Breaks the menu loop
                            break;

                        default:
                            //In case an invalid input is entered
                            System.out.println("Invalid input!");
                            System.out.println("Please enter an integer value between 1 and 4.");
                            break;
                    }
                }
                catch (Exception InputMismatchException){ //Catches if the input is non-numeric.
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    scnr.nextLine(); //Clears the Scanner
                }


            }
        }
    }

}
