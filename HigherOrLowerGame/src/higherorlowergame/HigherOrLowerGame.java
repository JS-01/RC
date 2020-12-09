package higherorlowergame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HigherOrLowerGame {

    //make the arrays for the decks
    public static ArrayList<String> CardsInDeck = new ArrayList<>();
    public static ArrayList<String> CardsUsedDeck = new ArrayList<>();

    //have the current card and user points
    public static String CurrentCard;
    public static String NextCard;
    public static double UserTotal;
    public static boolean UserHigher;

    public static void main(String[] args) {
        CreatDeck();
        boolean PlayAgain = false;
        RandomCard();
        System.out.println("The current card is : " + CurrentCard);
        UserGuess();
        GenerateNextCard();
        BuffCheck();
        CheckUserGuess();

        while (PlayAgain == false) {
            //print the current card
            System.out.println("The current card is : " + CurrentCard);
            CheckUsed();
            UserGuess();
            GenerateNextCard();
            BuffCheck();
            CheckUserGuess();
            AddUsed();
            if (CardsUsedDeck.size() <= 54) {
                System.out.println("You have used all the cards in the deck!!");
                System.out.println("Your final score was: " + UserTotal);
            }

            Scanner input = new Scanner(System.in);

            while (true) {
                try {
                    System.out.println("Would you like to play again? (Yes or No)");
                    String Again = input.next();

                    if (Again.equalsIgnoreCase("yes")) {
                        PlayAgain = true;
                        break;
                    }
                    if (Again.equalsIgnoreCase("no")) {
                        PlayAgain = false;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
                System.out.println("Please enter either yes or no");
            }
        }
    }

    //adds all the cards to the deck
    public static void CreatDeck() {
        //add all the cards to the deck
        //clubs
        for (int i = 2; i < 10; i++) {
            String CardNumber = Integer.toString(i);
            CardsInDeck.add(CardNumber + " Clubs");
        }
        CardsInDeck.add("Ace Clubs");
        CardsInDeck.add("Jack Clubs");
        CardsInDeck.add("Queen Clubs");
        CardsInDeck.add("King Clubs");

        //spades
        for (int i = 2; i < 10; i++) {
            String CardNumber = Integer.toString(i);
            CardsInDeck.add(CardNumber + " Spades");
        }
        CardsInDeck.add("Ace Spades");
        CardsInDeck.add("Jack Spades");
        CardsInDeck.add("Queen Spades");
        CardsInDeck.add("King Spades");

        //hearts
        for (int i = 2; i < 10; i++) {
            String CardNumber = Integer.toString(i);
            CardsInDeck.add(CardNumber + " Hearts");
        }
        CardsInDeck.add("Ace Hearts");
        CardsInDeck.add("Jack Hearts");
        CardsInDeck.add("Queen Hearts");
        CardsInDeck.add("King Hearts");

        //diamonds
        for (int i = 2; i < 10; i++) {
            String CardNumber = Integer.toString(i);
            CardsInDeck.add(CardNumber + " Diamonds");
        }
        CardsInDeck.add("Ace Diamonds");
        CardsInDeck.add("Jack Diamonds");
        CardsInDeck.add("Queen Diamonds");
        CardsInDeck.add("King Diamonds");

        //Add the jokers
        CardsInDeck.add("Joker");
        CardsInDeck.add("Joker");
    }

    //generate a random card
    public static void RandomCard() {
        Random random = new Random();

        int CardSelection = random.nextInt((CardsInDeck.size()));
        CurrentCard = CardsInDeck.get(CardSelection);

    }

    //check its not used
    public static void CheckUsed() {
        while (true) {
            for (int i = 0; i < CardsUsedDeck.size(); i++) {
                if (CurrentCard.equalsIgnoreCase(CardsUsedDeck.get(i))) {
                    Random random = new Random();

                    int CardSelection = random.nextInt((CardsInDeck.size()));
                    CurrentCard = CardsInDeck.get(CardSelection);
                } else {
                    break;
                }
            }
        }
    }

    //check for buffs with the current card
    public static void BuffCheck() {
        //check for jokers
        if (CurrentCard.equalsIgnoreCase("Joker")) {
            UserTotal = UserTotal / 2;
            System.out.print(". Your score has been halfed!!");
        }
        if (CurrentCard.equalsIgnoreCase("Ace Hearts") || CurrentCard.equalsIgnoreCase("Ace Diamonds") || CurrentCard.equalsIgnoreCase("Ace Spades") || CurrentCard.equalsIgnoreCase("Ace Clubs")) {
            UserTotal = UserTotal * 2;
            System.out.print(". Your score has been doubled!!");
        }
    }

    //have the user guess a card
    public static void UserGuess() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Do you think the next card is higher or lower than the current?");
                String UserGuess = input.next();

                //check if it valid guess
                if (UserGuess.equalsIgnoreCase("higher")) {
                    UserHigher = true;
                    break;
                }
                if (UserGuess.equalsIgnoreCase("lower")) {
                    UserHigher = false;
                    break;
                }
            } catch (Exception e) {

            }
        }
    }

    //generate next card
    public static void GenerateNextCard() {
        Random random = new Random();

        int CardSelection = random.nextInt((CardsInDeck.size()));
        NextCard = CardsInDeck.get(CardSelection);

    }

    //check if they are correct
    public static void CheckUserGuess() {
        int StartNumberCurrent = 0;
        int StartNumberNext = 0;
        boolean Higher = true;

        //aces
        if (CurrentCard.charAt(0) == 'A') {
            StartNumberCurrent = 1;
        }
        if (NextCard.charAt(0) == 'A') {
            StartNumberNext = 1;
        }

        //jacks
        if (CurrentCard.charAt(0) == 'J') {
            StartNumberCurrent = 11;
        }
        if (NextCard.charAt(0) == 'J') {
            StartNumberNext = 11;
        }

        //queens
        if (CurrentCard.charAt(0) == 'Q') {
            StartNumberCurrent = 12;
        }
        if (NextCard.charAt(0) == 'Q') {
            StartNumberNext = 12;
        }

        //kings
        if (CurrentCard.charAt(0) == 'K') {
            StartNumberCurrent = 13;
        }
        if (NextCard.charAt(0) == 'K') {
            StartNumberNext = 13;
        }

        //normal cards
        for (int i = 1; i < 10; i++) {
            if (CurrentCard.charAt(0) == i) {
                StartNumberCurrent = i;
            }
            if (NextCard.charAt(0) == i) {
                StartNumberNext = i;
            }
        }

        //check if it is higher or lower
        if (StartNumberCurrent < StartNumberNext) {
            Higher = true;
        }
        if (StartNumberCurrent > StartNumberNext) {
            Higher = false;
        }
        if (StartNumberCurrent == StartNumberNext) {
            System.out.println("They were the same card so your total is multplied by 1.5");
            UserTotal = UserTotal * 1.5;
        }

        //if the user guessed correctly
        if (Higher == true && UserHigher == true) {
            System.out.println("Woo you got it correct, your current total is: ");
            UserTotal++;
            System.out.println(UserTotal + " points");
        }
        if (Higher == false && UserHigher == false) {
            System.out.println("Woo you got it correct, your current total is: ");
            UserTotal++;
            System.out.println(UserTotal + " points");
        }

        //if the user guessed wrong
        if (Higher == true && UserHigher == false) {
            System.out.println("Sorry you got it wrong, your current total is: ");
            UserTotal++;
            System.out.println(UserTotal + " points");
        }
        if (Higher == false && UserHigher == true) {
            System.out.println("Sorry you got it wrong, your current total is: ");
            UserTotal++;
            System.out.println(UserTotal + " points");
        }
    }

    //make sure no repeats
    public static void AddUsed() {
        CardsUsedDeck.add(CurrentCard);
        CurrentCard = NextCard;
    }
}
