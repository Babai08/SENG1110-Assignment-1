/*
Author: Lachlan Muddle - c3428808, Jacob Saunders - c3412899
Date: 27/03/2024 - 03/05/2024
Task: SENG1110 Programming Assignment 1
*/
import java.util.Scanner;

public class SystemInterface {

    private SmartCard smartCard1, smartCard2, smartCard3;
    // These are 2 invalid variables that are used in initialising and deleting.
    private final Journey InvalidJourney = new Journey();
    private final SmartCard InvalidCard = new SmartCard();
    private boolean running = false;

    private void run() {
        // Sets up the properties for invalid variables
        InvalidJourney.setJourneyID(0);
        InvalidJourney.setStartOfJourney(0);
        InvalidJourney.setEndOfJourney(0);
        InvalidJourney.setTransportMode("NaN");
        InvalidJourney.setDistanceOfJourney();
        InvalidCard.setJourney1(InvalidJourney);
        InvalidCard.setJourney2(InvalidJourney);
        InvalidCard.setJourney3(InvalidJourney);
        InvalidCard.setType('n');
        InvalidCard.setSmartCardID(0);
        InvalidCard.setBalance(0);

        // Sets uninitialised SmartCards to the invalidCard by default to avoid null Value Errors in functions.
        smartCard1 = InvalidCard;
        smartCard2 = InvalidCard;
        smartCard3 = InvalidCard;

        running = true;
        System.out.println("Welcome to the SmartCard System!");
        Scanner keyboard = new Scanner(System.in);
        // Sets up the loop to keep the function running until requested to end.
        while (running) {
            FunctionSelector(keyboard);
        }
    }

    // This function allows users to set up SmartCards. It contains a large amount of logic to ensure that any already used SmartCard is not overwritten.
    private void CardSetter(Scanner keyboard) {
        int C1 = smartCard1.getCardID();
        int C2 = smartCard2.getCardID();
        int C3 = smartCard3.getCardID();
        SmartCard subCard1 = new SmartCard();
        SmartCard subCard2 = new SmartCard();
        SmartCard subCard3 = new SmartCard();
        int cardID;
        char cardType;
        double balance;
        if (C1 == 0 && C2 == 0 && C3 == 0) {
            System.out.print("How many cards would you like to set (0-3)? ");
            int numCards = keyboard.nextInt();
            switch (numCards) {
                case 0:
                    System.out.println("No SmartCards were set.");
                    break;
                case 1:
                    cardID = 0;
                    while (cardID == smartCard2.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card ID: ");
                        cardID = keyboard.nextInt();
                        if (cardID == smartCard2.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                            System.out.println("Invalid Card ID.");
                        }
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard1.setSmartCardID(cardID);
                    subCard1.setType(cardType);
                    subCard1.setBalance(balance);
                    subCard1.setJourney1(InvalidJourney);
                    subCard1.setJourney2(InvalidJourney);
                    subCard1.setJourney3(InvalidJourney);
                    smartCard1 = subCard1;
                    break;
                case 2:
                    cardID = 0;
                    while (cardID == smartCard2.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card 1's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 1's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 1: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard1.setSmartCardID(cardID);
                    subCard1.setType(cardType);
                    subCard1.setBalance(balance);
                    subCard1.setJourney1(InvalidJourney);
                    subCard1.setJourney2(InvalidJourney);
                    subCard1.setJourney3(InvalidJourney);
                    smartCard1 = subCard1;

                    cardID = 0;
                    while (cardID == smartCard1.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card 2's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 2's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 2: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard2.setSmartCardID(cardID);
                    subCard2.setType(cardType);
                    subCard2.setBalance(balance);
                    subCard2.setJourney1(InvalidJourney);
                    subCard2.setJourney2(InvalidJourney);
                    subCard2.setJourney3(InvalidJourney);
                    smartCard2 = subCard2;
                    break;
                case 3:
                    cardID = 0;
                    while (cardID == smartCard2.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card 1's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 1's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 1: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard1.setSmartCardID(cardID);
                    subCard1.setType(cardType);
                    subCard1.setBalance(balance);
                    subCard1.setJourney1(InvalidJourney);
                    subCard1.setJourney2(InvalidJourney);
                    subCard1.setJourney3(InvalidJourney);
                    smartCard1 = subCard1;

                    cardID = 0;
                    while (cardID == smartCard1.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card 2's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 2's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 2: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard2.setSmartCardID(cardID);
                    subCard2.setType(cardType);
                    subCard2.setBalance(balance);
                    subCard2.setJourney1(InvalidJourney);
                    subCard2.setJourney2(InvalidJourney);
                    subCard2.setJourney3(InvalidJourney);
                    smartCard2 = subCard2;

                    cardID = 0;
                    while (cardID == smartCard1.getCardID() || cardID == smartCard2.getCardID() || cardID < 1) {
                        System.out.print("Card 3's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 3's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 3: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard3.setSmartCardID(cardID);
                    subCard3.setType(cardType);
                    subCard3.setBalance(balance);
                    subCard3.setJourney1(InvalidJourney);
                    subCard3.setJourney2(InvalidJourney);
                    subCard3.setJourney3(InvalidJourney);
                    smartCard3 = subCard3;
                    break;
                default:
                    System.out.println("Invalid input.");
                    CardSetter(keyboard);
                    break;
            }
        } else if (C1 == 0 && C2 == 0) {
            System.out.print("How many cards would you like to set (0-2)? ");
            int numCards = keyboard.nextInt();
            switch (numCards) {
                case 0:
                    System.out.println("No SmartCards were set.");
                    break;
                case 1:
                    cardID = 0;
                    while (cardID == smartCard2.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard1.setSmartCardID(cardID);
                    subCard1.setType(cardType);
                    subCard1.setBalance(balance);
                    subCard1.setJourney1(InvalidJourney);
                    subCard1.setJourney2(InvalidJourney);
                    subCard1.setJourney3(InvalidJourney);
                    smartCard1 = subCard1;
                    break;
                case 2:
                    cardID = 0;
                    while (cardID == smartCard2.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card 1's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 1's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 1: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard1.setSmartCardID(cardID);
                    subCard1.setType(cardType);
                    subCard1.setBalance(balance);
                    subCard1.setJourney1(InvalidJourney);
                    subCard1.setJourney2(InvalidJourney);
                    subCard1.setJourney3(InvalidJourney);
                    smartCard1 = subCard1;

                    cardID = 0;
                    while (cardID == smartCard1.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card 2's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 2's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 2: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard2.setSmartCardID(cardID);
                    subCard2.setType(cardType);
                    subCard2.setBalance(balance);
                    subCard2.setJourney1(InvalidJourney);
                    subCard2.setJourney2(InvalidJourney);
                    subCard2.setJourney3(InvalidJourney);
                    smartCard2 = subCard2;
                    break;
                default:
                    System.out.println("Invalid input.");
                    CardSetter(keyboard);
                    break;
            }
        } else if (C1 == 0 && C3 == 0) {
            System.out.print("How many cards would you like to set (0-2)? ");
            int numCards = keyboard.nextInt();
            switch (numCards) {
                case 0:
                    System.out.println("No SmartCards were set.");
                    break;
                case 1:
                    cardID = 0;
                    while (cardID == smartCard2.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard1.setSmartCardID(cardID);
                    subCard1.setType(cardType);
                    subCard1.setBalance(balance);
                    subCard1.setJourney1(InvalidJourney);
                    subCard1.setJourney2(InvalidJourney);
                    subCard1.setJourney3(InvalidJourney);
                    smartCard1 = subCard1;
                    break;
                case 2:
                    cardID = 0;
                    while (cardID == smartCard2.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card 1's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 1's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 1: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard1.setSmartCardID(cardID);
                    subCard1.setType(cardType);
                    subCard1.setBalance(balance);
                    subCard1.setJourney1(InvalidJourney);
                    subCard1.setJourney2(InvalidJourney);
                    subCard1.setJourney3(InvalidJourney);
                    smartCard1 = subCard1;

                    cardID = 0;
                    while (cardID == smartCard1.getCardID() || cardID == smartCard2.getCardID() || cardID < 1) {
                        System.out.print("Card 2's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 2's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 2: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard3.setSmartCardID(cardID);
                    subCard3.setType(cardType);
                    subCard3.setBalance(balance);
                    subCard3.setJourney1(InvalidJourney);
                    subCard3.setJourney2(InvalidJourney);
                    subCard3.setJourney3(InvalidJourney);
                    smartCard3 = subCard3;
                    break;
                default:
                    System.out.println("Invalid input.");
                    CardSetter(keyboard);
                    break;
            }
        } else if (C2 == 0 && C3 == 0) {
            System.out.print("How many cards would you like to set (0-2)? ");
            int numCards = keyboard.nextInt();
            switch (numCards) {
                case 0:
                    System.out.println("No SmartCards were set.");
                    break;
                case 1:
                    cardID = 0;
                    while (cardID == smartCard2.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard2.setSmartCardID(cardID);
                    subCard2.setType(cardType);
                    subCard2.setBalance(balance);
                    subCard2.setJourney1(InvalidJourney);
                    subCard2.setJourney2(InvalidJourney);
                    subCard2.setJourney3(InvalidJourney);
                    smartCard2 = subCard2;
                    break;
                case 2:
                    cardID = 0;
                    while (cardID == smartCard1.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card 1's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 1's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 1: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard2.setSmartCardID(cardID);
                    subCard2.setType(cardType);
                    subCard2.setBalance(balance);
                    subCard2.setJourney1(InvalidJourney);
                    subCard2.setJourney2(InvalidJourney);
                    subCard2.setJourney3(InvalidJourney);
                    smartCard2 = subCard2;

                    cardID = 0;
                    while (cardID == smartCard1.getCardID() || cardID == smartCard2.getCardID() || cardID < 1) {
                        System.out.print("Card 2's ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard 2's type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance 2: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard3.setSmartCardID(cardID);
                    subCard3.setType(cardType);
                    subCard3.setBalance(balance);
                    subCard3.setJourney1(InvalidJourney);
                    subCard3.setJourney2(InvalidJourney);
                    subCard3.setJourney3(InvalidJourney);
                    smartCard3 = subCard3;
                    break;
                default:
                    System.out.println("Invalid input.");
                    CardSetter(keyboard);
                    break;
            }
        } else if (C1 == 0) {
            System.out.print("How many cards would you like to set (0-1)? ");
            int numCards = keyboard.nextInt();
            switch (numCards) {
                case 0:
                    System.out.println("No SmartCards were set.");
                    break;
                case 1:
                    cardID = 0;
                    while (cardID == smartCard2.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard1.setSmartCardID(cardID);
                    subCard1.setType(cardType);
                    subCard1.setBalance(balance);
                    subCard1.setJourney1(InvalidJourney);
                    subCard1.setJourney2(InvalidJourney);
                    subCard1.setJourney3(InvalidJourney);
                    smartCard1 = subCard1;
                    break;
                default:
                    System.out.println("Invalid input.");
                    CardSetter(keyboard);
                    break;
            }
        } else if (C2 == 0) {
            System.out.print("How many cards would you like to set (0-1)? ");
            int numCards = keyboard.nextInt();
            switch (numCards) {
                case 0:
                    System.out.println("No SmartCards were set.");
                    break;
                case 1:
                    cardID = 0;
                    while (cardID == smartCard1.getCardID() || cardID == smartCard3.getCardID() || cardID < 1) {
                        System.out.print("Card ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard2.setSmartCardID(cardID);
                    subCard2.setType(cardType);
                    subCard2.setBalance(balance);
                    subCard2.setJourney1(InvalidJourney);
                    subCard2.setJourney2(InvalidJourney);
                    subCard2.setJourney3(InvalidJourney);
                    smartCard2 = subCard2;
                    break;
                default:
                    System.out.println("Invalid input.");
                    CardSetter(keyboard);
                    break;
            }
        } else if (C3 == 0) {
            System.out.print("How many cards would you like to set (0-1)? ");
            int numCards = keyboard.nextInt();
            switch (numCards) {
                case 0:
                    System.out.println("No SmartCards were set.");
                    break;
                case 1:
                    cardID = 0;
                    while (cardID == smartCard1.getCardID() || cardID == smartCard2.getCardID() || cardID < 1) {
                        System.out.print("Card ID: ");
                        cardID = keyboard.nextInt();
                    }
                    cardType = 'n';
                    while (cardType != 'c' && cardType != 'a' && cardType != 's') {
                        System.out.print("SmartCard type: ");
                        cardType = keyboard.next().toLowerCase().charAt(0);
                        if (cardType != 'c' && cardType != 'a' && cardType != 's') {
                            System.out.println("Invalid type, correct types are: C, A and S.");
                        }
                    }
                    balance = -1;
                    while (balance < 5) {
                        System.out.print("Balance: ");
                        balance = keyboard.nextDouble();
                        if (balance < 5) {
                            System.out.println("Please input a value above 5.");
                        }
                    }
                    subCard3.setSmartCardID(cardID);
                    subCard3.setType(cardType);
                    subCard3.setBalance(balance);
                    subCard3.setJourney1(InvalidJourney);
                    subCard3.setJourney2(InvalidJourney);
                    subCard3.setJourney3(InvalidJourney);
                    smartCard3 = subCard3;
                default:
                    System.out.println("Invalid input.");
                    CardSetter(keyboard);
                    break;
            }
        } else {
            System.out.println("You already have the maximum amount of SmartCards.");
        }
    }

    private SmartCard JourneySetter(SmartCard card, Scanner keyboard) {
        SmartCard subCard = card;
        if (card.getType() == 'c') {
            if (card.getJourney1() == InvalidJourney) {
                System.out.println("You can set 1 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1) {
                    System.out.print("How many journeys would you like to set (0-1)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j1 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        /* For the line below, I am unsure if you want us to make sure the stations aren't the same,
                        obviously round trips can exist, but this seems on in this case because everything else we
                        have done has been strictly linear, furthermore, if we didn't actually go anywhere, we just
                        charge someone for standing there which is not something we should do.*/
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            // I'm not sure if this is required, I'm going to leave it in, however it could be commented out.
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);
                        return subCard;
                }
            } else {
                System.out.println("The max amount of Journeys are already set on this SmartCard.");
                return card;
            }
        } else if (card.getType() == 'a') {
            if (card.getJourney1() == InvalidJourney && card.getJourney2() == InvalidJourney) {
                System.out.println("You can set 2 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1 && numJourneys != 2) {
                    System.out.print("How many journeys would you like to set (0-2)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1 && numJourneys != 2) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j1 = new Journey();
                Journey j2 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);
                        return subCard;
                    case 3:
                        while (journeyID < 1) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }

                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);

                        journeyID = 0;
                        transportMode = "";
                        startOfJourney = 0;
                        endOfJourney = 0;
                        while (journeyID < 1 || journeyID == j1.getJourneyID()) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == j1.getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j2.setJourneyID(journeyID);
                        j2.setTransportMode(transportMode);
                        j2.setStartOfJourney(startOfJourney);
                        j2.setEndOfJourney(endOfJourney);
                        j2.setDistanceOfJourney();
                        subCard.setJourney2(j2);
                        return subCard;
                }
            } else if (card.getJourney1() == InvalidJourney) {
                System.out.println("You can set 1 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1) {
                    System.out.print("How many journeys would you like to set (0-1)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j1 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1 || journeyID == card.getJourney2().getJourneyID()) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney2().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);
                        return subCard;
                }
            } else if (card.getJourney2() == InvalidJourney) {
                System.out.println("You can set 1 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1) {
                    System.out.print("How many journeys would you like to set (0-1)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j2 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1 || journeyID == card.getJourney1().getJourneyID()) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney1().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j2.setJourneyID(journeyID);
                        j2.setTransportMode(transportMode);
                        j2.setStartOfJourney(startOfJourney);
                        j2.setEndOfJourney(endOfJourney);
                        j2.setDistanceOfJourney();
                        subCard.setJourney2(j2);
                        return subCard;
                }
            } else {
                System.out.println("The max amount of Journeys are already set on this SmartCard.");
                return card;
            }
        } else if (card.getType() == 's') {
            if (card.getJourney1() == InvalidJourney && card.getJourney2() == InvalidJourney && card.getJourney3() == InvalidJourney) {
                System.out.println("You can set 3 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1 && numJourneys != 2 && numJourneys != 3) {
                    System.out.print("How many journeys would you like to set (0-3)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1 && numJourneys != 2 && numJourneys != 3) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j1 = new Journey();
                Journey j2 = new Journey();
                Journey j3 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);
                        return subCard;
                    case 3:
                        while (journeyID < 1) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }

                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);

                        journeyID = 0;
                        transportMode = "";
                        startOfJourney = 0;
                        endOfJourney = 0;
                        while (journeyID < 1 || journeyID == j1.getJourneyID()) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == j1.getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j2.setJourneyID(journeyID);
                        j2.setTransportMode(transportMode);
                        j2.setStartOfJourney(startOfJourney);
                        j2.setEndOfJourney(endOfJourney);
                        j2.setDistanceOfJourney();
                        subCard.setJourney2(j2);
                        return subCard;
                    case 4:
                        while (journeyID < 1) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }

                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);

                        journeyID = 0;
                        transportMode = "";
                        startOfJourney = 0;
                        endOfJourney = 0;
                        while (journeyID < 1 || journeyID == j1.getJourneyID()) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == j1.getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j2.setJourneyID(journeyID);
                        j2.setTransportMode(transportMode);
                        j2.setStartOfJourney(startOfJourney);
                        j2.setEndOfJourney(endOfJourney);
                        j2.setDistanceOfJourney();
                        subCard.setJourney2(j2);
                        journeyID = 0;
                        transportMode = "";
                        startOfJourney = 0;
                        endOfJourney = 0;
                        while (journeyID < 1 || journeyID == j1.getJourneyID() || journeyID == j2.getJourneyID()) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == j1.getJourneyID() || journeyID == j2.getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j3.setJourneyID(journeyID);
                        j3.setTransportMode(transportMode);
                        j3.setStartOfJourney(startOfJourney);
                        j3.setEndOfJourney(endOfJourney);
                        j3.setDistanceOfJourney();
                        subCard.setJourney3(j3);
                        return subCard;
                }
            } else if (card.getJourney1() == InvalidJourney && card.getJourney2() == InvalidJourney) {
                System.out.println("You can set 2 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1 && numJourneys != 2) {
                    System.out.print("How many journeys would you like to set (0-2)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1 && numJourneys != 2) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j1 = new Journey();
                Journey j2 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1 || journeyID == card.getJourney3().getJourneyID()) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney3().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);
                        return subCard;
                    case 3:
                        while (journeyID < 1 || journeyID == card.getJourney3().getJourneyID()) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney3().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }

                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);

                        journeyID = 0;
                        transportMode = "";
                        startOfJourney = 0;
                        endOfJourney = 0;
                        while (journeyID < 1 || journeyID == j1.getJourneyID() || journeyID == card.getJourney3().getJourneyID()) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == j1.getJourneyID() || journeyID == card.getJourney3().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j2.setJourneyID(journeyID);
                        j2.setTransportMode(transportMode);
                        j2.setStartOfJourney(startOfJourney);
                        j2.setEndOfJourney(endOfJourney);
                        j2.setDistanceOfJourney();
                        subCard.setJourney2(j2);
                        return subCard;
                }
            } else if (card.getJourney1() == InvalidJourney && card.getJourney3() == InvalidJourney) {
                System.out.println("You can set 2 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1 && numJourneys != 2) {
                    System.out.print("How many journeys would you like to set (0-2)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1 && numJourneys != 2) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j1 = new Journey();
                Journey j3 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1 || journeyID == card.getJourney2().getJourneyID()) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney2().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);
                        return subCard;
                    case 3:
                        while (journeyID < 1 || journeyID == card.getJourney2().getJourneyID()) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney2().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }

                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);

                        journeyID = 0;
                        transportMode = "";
                        startOfJourney = 0;
                        endOfJourney = 0;
                        while (journeyID < 1 || journeyID == j1.getJourneyID() || journeyID == card.getJourney2().getJourneyID()) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == j1.getJourneyID() || journeyID == card.getJourney2().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j3.setJourneyID(journeyID);
                        j3.setTransportMode(transportMode);
                        j3.setStartOfJourney(startOfJourney);
                        j3.setEndOfJourney(endOfJourney);
                        j3.setDistanceOfJourney();
                        subCard.setJourney3(j3);
                        return subCard;
                }
            } else if (card.getJourney2() == InvalidJourney && card.getJourney3() == InvalidJourney) {
                System.out.println("You can set 2 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1 && numJourneys != 2) {
                    System.out.print("How many journeys would you like to set (0-2)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1 && numJourneys != 2) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j2 = new Journey();
                Journey j3 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1 || journeyID == card.getJourney1().getJourneyID()) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney1().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j2.setJourneyID(journeyID);
                        j2.setTransportMode(transportMode);
                        j2.setStartOfJourney(startOfJourney);
                        j2.setEndOfJourney(endOfJourney);
                        j2.setDistanceOfJourney();
                        subCard.setJourney2(j2);
                        return subCard;
                    case 3:
                        while (journeyID < 1 || journeyID == card.getJourney1().getJourneyID()) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney1().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }

                        j2.setJourneyID(journeyID);
                        j2.setTransportMode(transportMode);
                        j2.setStartOfJourney(startOfJourney);
                        j2.setEndOfJourney(endOfJourney);
                        j2.setDistanceOfJourney();
                        subCard.setJourney2(j2);

                        journeyID = 0;
                        transportMode = "";
                        startOfJourney = 0;
                        endOfJourney = 0;
                        while (journeyID < 1 || journeyID == j2.getJourneyID() || journeyID == card.getJourney1().getJourneyID()) {
                            System.out.print("Journey 1's ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == j2.getJourneyID() || journeyID == card.getJourney1().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode 1: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey 1 (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey 1 (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j3.setJourneyID(journeyID);
                        j3.setTransportMode(transportMode);
                        j3.setStartOfJourney(startOfJourney);
                        j3.setEndOfJourney(endOfJourney);
                        j3.setDistanceOfJourney();
                        subCard.setJourney3(j3);
                        return subCard;
                }
            } else if (card.getJourney1() == InvalidJourney) {
                System.out.println("You can set 1 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1) {
                    System.out.print("How many journeys would you like to set (0-1)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j1 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1 || journeyID == card.getJourney2().getJourneyID() || journeyID == card.getJourney3().getJourneyID()) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney2().getJourneyID() || journeyID == card.getJourney3().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j1.setJourneyID(journeyID);
                        j1.setTransportMode(transportMode);
                        j1.setStartOfJourney(startOfJourney);
                        j1.setEndOfJourney(endOfJourney);
                        j1.setDistanceOfJourney();
                        subCard.setJourney1(j1);
                        return subCard;
                }
            } else if (card.getJourney2() == InvalidJourney) {
                System.out.println("You can set 1 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1) {
                    System.out.print("How many journeys would you like to set (0-1)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j2 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1 || journeyID == card.getJourney1().getJourneyID() || journeyID == card.getJourney3().getJourneyID()) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney1().getJourneyID() || journeyID == card.getJourney3().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j2.setJourneyID(journeyID);
                        j2.setTransportMode(transportMode);
                        j2.setStartOfJourney(startOfJourney);
                        j2.setEndOfJourney(endOfJourney);
                        j2.setDistanceOfJourney();
                        subCard.setJourney2(j2);
                        return subCard;
                }
            } else if (card.getJourney3() == InvalidJourney) {
                System.out.println("You can set 1 journey on this card.");
                int numJourneys = -1;
                while (numJourneys != 0 && numJourneys != 1) {
                    System.out.print("How many journeys would you like to set (0-1)? ");
                    numJourneys = keyboard.nextInt();
                    if (numJourneys != 0 && numJourneys != 1) {
                        System.out.println("Please input a valid selection.");
                    }
                }
                numJourneys++;
                int journeyID = 0;
                String transportMode = "";
                int startOfJourney = 0;
                int endOfJourney = 0;
                Journey j3 = new Journey();
                switch (numJourneys) {
                    case 1:
                        System.out.println("No Journeys were set.");
                        return card;
                    case 2:
                        while (journeyID < 1 || journeyID == card.getJourney1().getJourneyID() || journeyID == card.getJourney2().getJourneyID()) {
                            System.out.print("Journey ID: ");
                            journeyID = keyboard.nextInt();
                            if (journeyID < 1 || journeyID == card.getJourney1().getJourneyID() || journeyID == card.getJourney2().getJourneyID()) {
                                System.out.println("Please input a unique ID greater than 0.");
                            }
                        }
                        while (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                            System.out.print("Transport mode: ");
                            transportMode = keyboard.next().toLowerCase();
                            if (!transportMode.equals("train") && !transportMode.equals("tram") && !transportMode.equals("bus")) {
                                System.out.println("Please input a valid transport mode (train, tram or bus).");
                            }
                        }
                        while (startOfJourney < 1 || startOfJourney > 10) {
                            System.out.print("Starting point for journey (1-10): ");
                            startOfJourney = keyboard.nextInt();
                            if (startOfJourney < 1 || startOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                        }
                        while (endOfJourney < 1 || endOfJourney > 10 || endOfJourney == startOfJourney) {
                            System.out.print("Ending point for journey (1-10): ");
                            endOfJourney = keyboard.nextInt();
                            if (endOfJourney < 1 || endOfJourney > 10) {
                                System.out.println("Please input a valid station/stop.");
                            }
                            if (endOfJourney == startOfJourney) {
                                System.out.println("Please input a different station/stop. Cannot start and stop at the same station.");
                            }
                        }
                        j3.setJourneyID(journeyID);
                        j3.setTransportMode(transportMode);
                        j3.setStartOfJourney(startOfJourney);
                        j3.setEndOfJourney(endOfJourney);
                        j3.setDistanceOfJourney();
                        subCard.setJourney3(j3);
                        return subCard;
                }
            } else {
                System.out.println("The max amount of Journeys are already set on this SmartCard.");
                return card;
            }
        }
        System.out.println("Invalid Card");
        return card;
    }

    private void CardDeleter(Scanner keyboard) {
        int C1 = smartCard1.getCardID();
        int C2 = smartCard2.getCardID();
        int C3 = smartCard3.getCardID();
        if (C1 != 0 && C2 != 0 && C3 !=0) {
            System.out.println("The available SmartCard's are: " + C1 + ", " + C2 + " and " + C3 + ".");
            int deleted = 0;
            while (deleted != C1 && deleted != C2 && deleted != C3) {
                System.out.print("Which card would you like to delete?");
                deleted = keyboard.nextInt();
            }
            if (deleted == C1) {
                smartCard1 = InvalidCard;
            } else if (deleted == C2) {
                smartCard2 = InvalidCard;
            } else {
                smartCard3 = InvalidCard;
            }

        } else if (C1 != 0 && C2 != 0) {
            System.out.println("The available SmartCard's are: " + C1 + " and " + C2 + ".");
            int deleted = 0;
            while (deleted != C1 && deleted != C2) {
                System.out.print("Which card would you like to delete?");
                deleted = keyboard.nextInt();
            }
            if (deleted == C1) {
                smartCard1 = InvalidCard;
            } else {
                smartCard2 = InvalidCard;
            }
        } else if (C1 != 0 && C3 != 0) {
            System.out.println("The available SmartCard's are: " + C1 + " and " + C3 + ".");
            int deleted = 0;
            while (deleted != C1 && deleted != C3) {
                System.out.print("Which card would you like to delete?");
                deleted = keyboard.nextInt();
            }
            if (deleted == C1) {
                smartCard1 = InvalidCard;
            } else {
                smartCard3 = InvalidCard;
            }
        } else if (C2 != 0 && C3 != 0) {
            System.out.println("The available SmartCard's are: " + C2 + " and " + C3 + ".");
            int deleted = 0;
            while (deleted != C2 && deleted != C3) {
                System.out.print("Which card would you like to delete?");
                deleted = keyboard.nextInt();
            }
            if (deleted == C2) {
                smartCard2 = InvalidCard;
            } else {
                smartCard3 = InvalidCard;
            }
        } else if (C1 != 0) {
            System.out.println("The available SmartCard's are: " + C1 + ".");
            int deleted = 0;
            while (deleted != C1) {
                System.out.print("Which card would you like to delete?");
                deleted = keyboard.nextInt();
            }
            smartCard1 = InvalidCard;
        } else if (C2 != 0) {
            System.out.println("The available SmartCard's are: " + C2 + ".");
            int deleted = 0;
            while (deleted != C2) {
                System.out.print("Which card would you like to delete?");
                deleted = keyboard.nextInt();
            }
            smartCard2 = InvalidCard;
        } else if (C3 != 0) {
            System.out.println("The available SmartCard's are: " + C3 + ".");
            int deleted = 0;
            while (deleted != C3) {
                System.out.print("Which card would you like to delete?");
                deleted = keyboard.nextInt();
            }
            smartCard3 = InvalidCard;
        } else {
            System.out.println("There are no SmartCard's to delete.");
        }
    }

    private SmartCard JourneyDeleter(SmartCard card, Scanner keyboard) {
        SmartCard subCard = card;
        int J1 = card.getJourney1().getJourneyID();
        int J2 = card.getJourney2().getJourneyID();
        int J3 = card.getJourney3().getJourneyID();
        if (J1 != 0 && J2 != 0 && J3 != 0) {
            System.out.println("The journeys on this card are: " + J1 + ", " + J2 + " and " + J3 + ".");
            System.out.print("Which journey would you like to delete?");
            int deletion = keyboard.nextInt();
            if (deletion == J1) {
                subCard.setJourney1(InvalidJourney);
                System.out.println("Journey " + J1 + " has been deleted.");
                return subCard;
            }
            if (deletion == J2) {
                subCard.setJourney2(InvalidJourney);
                System.out.println("Journey " + J2 + " has been deleted.");
                return subCard;
            }
            if (deletion == J3) {
                subCard.setJourney3(InvalidJourney);
                System.out.println("Journey " + J3 + " has been deleted.");
                return subCard;
            }
            return JourneyDeleter(card, keyboard);
        } else if (J1 != 0 && J2 != 0) {
            System.out.println("The journeys on this card are: " + J1 + " and " + J2);
            System.out.print("Which journey would you like to delete?");
            int deletion = keyboard.nextInt();
            if (deletion == J1) {
                subCard.setJourney1(InvalidJourney);
                System.out.println("Journey " + J1 + " has been deleted.");
                return subCard;
            }
            if (deletion == J2) {
                subCard.setJourney2(InvalidJourney);
                System.out.println("Journey " + J2 + " has been deleted.");
                return subCard;
            }
            return JourneyDeleter(card, keyboard);
        } else if (J1 != 0 && J3 != 0) {
            System.out.println("The journeys on this card are: " + J1 + " and " + J3);
            System.out.print("Which journey would you like to delete?");
            int deletion = keyboard.nextInt();
            if (deletion == J1) {
                subCard.setJourney1(InvalidJourney);
                System.out.println("Journey " + J1 + " has been deleted.");
                return subCard;
            }
            if (deletion == J3) {
                subCard.setJourney2(InvalidJourney);
                System.out.println("Journey " + J3 + " has been deleted.");
                return subCard;
            }
            return JourneyDeleter(card, keyboard);
        } else if (J2 != 0 && J3 != 0) {
            System.out.println("The journeys on this card are: " + J2 + " and " + J3);
            System.out.print("Which journey would you like to delete?");
            int deletion = keyboard.nextInt();
            if (deletion == J2) {
                subCard.setJourney1(InvalidJourney);
                System.out.println("Journey " + J2 + " has been deleted.");
                return subCard;
            }
            if (deletion == J3) {
                subCard.setJourney2(InvalidJourney);
                System.out.println("Journey " + J3 + " has been deleted.");
                return subCard;
            }
            return JourneyDeleter(card, keyboard);
        } else if (J1 != 0) {
            System.out.println("The journeys on this card are: " + J1);
            System.out.print("Which journey would you like to delete?");
            int deletion = keyboard.nextInt();
            if (deletion == J1) {
                subCard.setJourney1(InvalidJourney);
                System.out.println("Journey " + J1 + " has been deleted.");
                return subCard;
            }
            return JourneyDeleter(card, keyboard);
        } else if (J2 != 0) {
            System.out.println("The journeys on this card are: " + J2);
            System.out.print("Which journey would you like to delete?");
            int deletion = keyboard.nextInt();
            if (deletion == J2) {
                subCard.setJourney1(InvalidJourney);
                System.out.println("Journey " + J2 + " has been deleted.");
                return subCard;
            }
            return JourneyDeleter(card, keyboard);
        } else if (J3 != 0) {
            System.out.println("The journeys on this card are: " + J3);
            System.out.print("Which journey would you like to delete?");
            int deletion = keyboard.nextInt();
            if (deletion == J3) {
                subCard.setJourney1(InvalidJourney);
                System.out.println("Journey " + J3 + " has been deleted.");
                return subCard;
            }
            return JourneyDeleter(card, keyboard);
        }
        System.out.println("There are no journeys on this card.");
        return card;
    }

    private void CardLister() {
        int num1, num2, num3;
        int sC1jID1 = smartCard1.getJourney1().getJourneyID();
        int sC1jID2 = smartCard1.getJourney2().getJourneyID();
        int sC1jID3 = smartCard1.getJourney3().getJourneyID();
        int sC2jID1 = smartCard2.getJourney1().getJourneyID();
        int sC2jID2 = smartCard2.getJourney2().getJourneyID();
        int sC2jID3 = smartCard2.getJourney3().getJourneyID();
        int sC3jID1 = smartCard3.getJourney1().getJourneyID();
        int sC3jID2 = smartCard3.getJourney2().getJourneyID();
        int sC3jID3 = smartCard3.getJourney3().getJourneyID();
        if (sC1jID1 != 0 && sC1jID2 != 0 && sC1jID3 != 0) {
            num1 = 3;
        } else if (sC1jID1 != 0 && sC1jID2 != 0) {
            num1 = 2;
        } else if (sC1jID1 != 0 && sC1jID3 != 0) {
            num1 = 2;
        } else if (sC1jID2 != 0 && sC1jID3 != 0) {
            num1 = 2;
        } else if (sC1jID1 != 0) {
            num1 = 1;
        } else if (sC1jID2 != 0) {
            num1 = 1;
        } else if (sC1jID3 != 0) {
            num1 = 1;
        } else {
            num1 = 0;
        }
        if (sC2jID1 != 0 && sC2jID2 != 0 && sC2jID3 != 0) {
            num2 = 3;
        } else if (sC2jID1 != 0 && sC2jID2 != 0) {
            num2 = 2;
        } else if (sC2jID1 != 0 && sC2jID3 != 0) {
            num2 = 2;
        } else if (sC2jID2 != 0 && sC2jID3 != 0) {
            num2 = 2;
        } else if (sC2jID1 != 0) {
            num2 = 1;
        } else if (sC2jID2 != 0) {
            num2 = 1;
        } else if (sC2jID3 != 0) {
            num2 = 1;
        } else {
            num2 = 0;
        }
        if (sC3jID1 != 0 && sC3jID2 != 0 && sC3jID3 != 0) {
            num3 = 3;
        } else if (sC3jID1 != 0 && sC3jID2 != 0) {
            num3 = 2;
        } else if (sC3jID1 != 0 && sC3jID3 != 0) {
            num3 = 2;
        } else if (sC3jID2 != 0 && sC3jID3 != 0) {
            num3 = 2;
        } else if (sC3jID1 != 0) {
            num3 = 1;
        } else if (sC3jID2 != 0) {
            num3 = 1;
        } else if (sC3jID3 != 0) {
            num3 = 1;
        } else {
            num3 = 0;
        }
        if (sC1jID1 != 0 && sC1jID2 != 0 && sC1jID3 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + " journeys.");
            System.out.println("Journey " + sC1jID1 + " has transport mode " + smartCard1.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC1jID2 + " has transport mode " + smartCard1.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC1jID3 + " has transport mode " + smartCard1.getJourney3().getTransportMode() + ".");
        } else if (sC1jID1 != 0 && sC1jID2 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + " journeys.");
            System.out.println("Journey " + sC1jID1 + " has transport mode " + smartCard1.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC1jID2 + " has transport mode " + smartCard1.getJourney2().getTransportMode() + ".");
        } else if (sC1jID1 != 0  && sC1jID3 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + " journeys.");
            System.out.println("Journey " + sC1jID1 + " has transport mode " + smartCard1.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC1jID3 + " has transport mode " + smartCard1.getJourney3().getTransportMode() + ".");
        } else if (sC1jID2 != 0 && sC1jID3 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + " journeys.");
            System.out.println("Journey " + sC1jID2 + " has transport mode " + smartCard1.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC1jID3 + " has transport mode " + smartCard1.getJourney3().getTransportMode() + ".");
        } else if (sC1jID1 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + " journey.");
            System.out.println("Journey " + sC1jID1 + " has transport mode " + smartCard1.getJourney1().getTransportMode() + ".");
        } else if (sC1jID2 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + " journey.");
            System.out.println("Journey " + sC1jID2 + " has transport mode " + smartCard1.getJourney2().getTransportMode() + ".");
        } else if (sC1jID3 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + " journey.");
            System.out.println("Journey " + sC1jID3 + " has transport mode " + smartCard1.getJourney3().getTransportMode() + ".");
        } else if (smartCard1 != InvalidCard) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + " journeys.");
        }

        if (sC2jID1 != 0 && sC2jID2 != 0 && sC2jID3 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + " journeys.");
            System.out.println("Journey " + sC2jID1 + " has transport mode " + smartCard2.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC2jID2 + " has transport mode " + smartCard2.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC2jID3 + " has transport mode " + smartCard2.getJourney3().getTransportMode() + ".");
        } else if (sC2jID1 != 0 && sC2jID2 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + " journeys.");
            System.out.println("Journey " + sC2jID1 + " has transport mode " + smartCard2.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC2jID2 + " has transport mode " + smartCard2.getJourney2().getTransportMode() + ".");
        } else if (sC2jID1 != 0  && sC2jID3 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + " journeys.");
            System.out.println("Journey " + sC2jID1 + " has transport mode " + smartCard2.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC2jID3 + " has transport mode " + smartCard2.getJourney3().getTransportMode() + ".");
        } else if (sC2jID2 != 0 && sC2jID3 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + " journeys.");
            System.out.println("Journey " + sC2jID2 + " has transport mode " + smartCard2.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC2jID3 + " has transport mode " + smartCard2.getJourney3().getTransportMode() + ".");
        } else if (sC2jID1 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + " journey.");
            System.out.println("Journey " + sC2jID1 + " has transport mode " + smartCard2.getJourney1().getTransportMode() + ".");
        } else if (sC2jID2 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + " journey.");
            System.out.println("Journey " + sC2jID2 + " has transport mode " + smartCard2.getJourney2().getTransportMode() + ".");
        } else if (sC2jID3 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + " journey.");
            System.out.println("Journey " + sC2jID3 + " has transport mode " + smartCard2.getJourney3().getTransportMode() + ".");
        } else if (smartCard2 != InvalidCard) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + " journeys.");
        }

        if (sC3jID1 != 0 && sC3jID2 != 0 && sC3jID3 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + " journeys.");
            System.out.println("Journey " + sC3jID1 + " has transport mode " + smartCard3.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC3jID2 + " has transport mode " + smartCard3.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC3jID3 + " has transport mode " + smartCard3.getJourney3().getTransportMode() + ".");
        } else if (sC3jID1 != 0 && sC3jID2 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + " journeys.");
            System.out.println("Journey " + sC3jID1 + " has transport mode " + smartCard3.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC3jID2 + " has transport mode " + smartCard3.getJourney2().getTransportMode() + ".");
        } else if (sC3jID1 != 0  && sC3jID3 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + " journeys.");
            System.out.println("Journey " + sC3jID1 + " has transport mode " + smartCard3.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC3jID3 + " has transport mode " + smartCard3.getJourney3().getTransportMode() + ".");
        } else if (sC3jID2 != 0 && sC3jID3 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + " journeys.");
            System.out.println("Journey " + sC3jID2 + " has transport mode " + smartCard3.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC3jID3 + " has transport mode " + smartCard3.getJourney3().getTransportMode() + ".");
        } else if (sC3jID1 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + " journey.");
            System.out.println("Journey " + sC3jID1 + " has transport mode " + smartCard3.getJourney1().getTransportMode() + ".");
        } else if (sC3jID2 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + " journey.");
            System.out.println("Journey " + sC3jID2 + " has transport mode " + smartCard3.getJourney2().getTransportMode() + ".");
        } else if (sC3jID3 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num1 + " journey.");
            System.out.println("Journey " + sC3jID3 + " has transport mode " + smartCard3.getJourney3().getTransportMode() + ".");
        } else if (smartCard3 != InvalidCard) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + " journeys.");
        }

    }

    private void JourneyLister() {
        Journey sC1J1 = smartCard1.getJourney1();
        Journey sC1J2 = smartCard1.getJourney2();
        Journey sC1J3 = smartCard1.getJourney3();
        Journey sC2J1 = smartCard2.getJourney1();
        Journey sC2J2 = smartCard2.getJourney2();
        Journey sC2J3 = smartCard2.getJourney3();
        Journey sC3J1 = smartCard3.getJourney1();
        Journey sC3J2 = smartCard3.getJourney2();
        Journey sC3J3 = smartCard3.getJourney3();
        if (sC1J1 != InvalidJourney) {
            System.out.println("Journey " + sC1J1.getJourneyID() + " has transport mode " + sC1J1.getTransportMode() + " starting from " + sC1J1.getStartOfJourney() + " and ending at " + sC1J1.getEndOfJourney() + " with journey distance of " + sC1J1.getDistanceOfJourney() + " station(s)/stop(s)");
        }
        if (sC1J2 != InvalidJourney) {
            System.out.println("Journey " + sC1J2.getJourneyID() + " has transport mode " + sC1J2.getTransportMode() + " starting from " + sC1J2.getStartOfJourney() + " and ending at " + sC1J2.getEndOfJourney() + " with journey distance of " + sC1J2.getDistanceOfJourney() + " station(s)/stop(s)");
        }
        if (sC1J3 != InvalidJourney) {
            System.out.println("Journey " + sC1J3.getJourneyID() + " has transport mode " + sC1J3.getTransportMode() + " starting from " + sC1J3.getStartOfJourney() + " and ending at " + sC1J3.getEndOfJourney() + " with journey distance of " + sC1J3.getDistanceOfJourney() + " station(s)/stop(s)");
        }
        if (sC2J1 != InvalidJourney) {
            System.out.println("Journey " + sC2J1.getJourneyID() + " has transport mode " + sC2J1.getTransportMode() + " starting from " + sC2J1.getStartOfJourney() + " and ending at " + sC2J1.getEndOfJourney() + " with journey distance of " + sC2J1.getDistanceOfJourney() + " station(s)/stop(s)");
        }
        if (sC2J2 != InvalidJourney) {
            System.out.println("Journey " + sC2J2.getJourneyID() + " has transport mode " + sC2J2.getTransportMode() + " starting from " + sC2J2.getStartOfJourney() + " and ending at " + sC2J2.getEndOfJourney() + " with journey distance of " + sC2J2.getDistanceOfJourney() + " station(s)/stop(s)");
        }
        if (sC2J3 != InvalidJourney) {
            System.out.println("Journey " + sC2J3.getJourneyID() + " has transport mode " + sC2J3.getTransportMode() + " starting from " + sC2J3.getStartOfJourney() + " and ending at " + sC2J3.getEndOfJourney() + " with journey distance of " + sC2J3.getDistanceOfJourney() + " station(s)/stop(s)");
        }
        if (sC3J1 != InvalidJourney) {
            System.out.println("Journey " + sC3J1.getJourneyID() + " has transport mode " + sC3J1.getTransportMode() + " starting from " + sC3J1.getStartOfJourney() + " and ending at " + sC3J1.getEndOfJourney() + " with journey distance of " + sC3J1.getDistanceOfJourney() + " station(s)/stop(s)");
        }
        if (sC3J2 != InvalidJourney) {
            System.out.println("Journey " + sC3J2.getJourneyID() + " has transport mode " + sC3J2.getTransportMode() + " starting from " + sC3J2.getStartOfJourney() + " and ending at " + sC3J2.getEndOfJourney() + " with journey distance of " + sC3J2.getDistanceOfJourney() + " station(s)/stop(s)");
        }
        if (sC3J3 != InvalidJourney) {
            System.out.println("Journey " + sC3J3.getJourneyID() + " has transport mode " + sC3J3.getTransportMode() + " starting from " + sC3J3.getStartOfJourney() + " and ending at " + sC3J3.getEndOfJourney() + " with journey distance of " + sC3J3.getDistanceOfJourney() + " station(s)/stop(s)");
        }
    }

    private void TransportModeFinder(String mode) {
        if (smartCard1.getJourney1().getTransportMode().equals(mode)){
            System.out.println("Journey " + smartCard1.getJourney1().getJourneyID() + " has that transport mode, and it belongs to smartcard " + smartCard1.getCardID() + ".");
        }
        if (smartCard1.getJourney2().getTransportMode().equals(mode)){
            System.out.println("Journey " + smartCard1.getJourney2().getJourneyID() + " has that transport mode, and it belongs to smartcard " + smartCard1.getCardID() + ".");
        }
        if (smartCard1.getJourney3().getTransportMode().equals(mode)){
            System.out.println("Journey " + smartCard1.getJourney3().getJourneyID() + " has that transport mode, and it belongs to smartcard " + smartCard1.getCardID() + ".");
        }
        if (smartCard2.getJourney1().getTransportMode().equals(mode)){
            System.out.println("Journey " + smartCard2.getJourney1().getJourneyID() + " has that transport mode, and it belongs to smartcard " + smartCard2.getCardID() + ".");
            System.out.println(smartCard2.getJourney1().getJourneyID() + smartCard2.getJourney2().getTransportMode());
        }
        if (smartCard2.getJourney2().getTransportMode().equals(mode)){
            System.out.println("Journey " + smartCard2.getJourney2().getJourneyID() + " has that transport mode, and it belongs to smartcard " + smartCard2.getCardID() + ".");
        }
        if (smartCard2.getJourney3().getTransportMode().equals(mode)){
            System.out.println("Journey " + smartCard2.getJourney3().getJourneyID() + " has that transport mode, and it belongs to smartcard " + smartCard2.getCardID() + ".");
        }
        if (smartCard3.getJourney1().getTransportMode().equals(mode)){
            System.out.println("Journey " + smartCard3.getJourney1().getJourneyID() + " has that transport mode, and it belongs to smartcard " + smartCard3.getCardID() + ".");
        }
        if (smartCard3.getJourney2().getTransportMode().equals(mode)){
            System.out.println("Journey " + smartCard3.getJourney2().getJourneyID() + " has that transport mode, and it belongs to smartcard " + smartCard3.getCardID() + ".");
        }
        if (smartCard3.getJourney3().getTransportMode().equals(mode)){
            System.out.println("Journey " + smartCard3.getJourney3().getJourneyID() + " has that transport mode, and it belongs to smartcard " + smartCard3.getCardID() + ".");
        }
    }

    private void FareCalculator() {
        if (smartCard1 != InvalidCard && smartCard2 != InvalidCard && smartCard3 != InvalidCard) {
            double TrainTotal ;
            double TramTotal;
            double BusTotal;
            double card1TrainTotal = 0;
            double card1TramTotal = 0;
            double card1BusTotal = 0;
            double card1PriceFactor;
            double card2TrainTotal = 0;
            double card2TramTotal = 0;
            double card2BusTotal = 0;
            double card2PriceFactor;
            double card3TrainTotal = 0;
            double card3TramTotal = 0;
            double card3BusTotal = 0;
            double card3PriceFactor;
            if (smartCard1.getType() == 'c') {
                card1PriceFactor = 1.86;
            } else if (smartCard1.getType() == 'a') {
                card1PriceFactor = 2.24;
            } else {
                card1PriceFactor = 1.6;
            }
            if (smartCard2.getType() == 'c') {
                card2PriceFactor = 1.86;
            } else if (smartCard2.getType() == 'a') {
                card2PriceFactor = 2.24;
            } else {
                card2PriceFactor = 1.6;
            }
            if (smartCard3.getType() == 'c') {
                card3PriceFactor = 1.86;
            } else if (smartCard3.getType() == 'a') {
                card3PriceFactor = 2.24;
            } else {
                card3PriceFactor = 1.6;
            }
            String card1Mode1 = smartCard1.getJourney1().getTransportMode();
            String card1Mode2 = smartCard1.getJourney2().getTransportMode();
            String card1Mode3 = smartCard1.getJourney3().getTransportMode();
            String card2Mode1 = smartCard2.getJourney1().getTransportMode();
            String card2Mode2 = smartCard2.getJourney2().getTransportMode();
            String card2Mode3 = smartCard2.getJourney3().getTransportMode();
            String card3Mode1 = smartCard3.getJourney1().getTransportMode();
            String card3Mode2 = smartCard3.getJourney2().getTransportMode();
            String card3Mode3 = smartCard3.getJourney3().getTransportMode();

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            TrainTotal = card1TrainTotal + card2TrainTotal + card3TrainTotal;
            TramTotal = card1TramTotal + card2TramTotal + card3TramTotal;
            BusTotal = card1BusTotal + card2BusTotal + card3BusTotal;
            if (TrainTotal == TramTotal && TramTotal == BusTotal && BusTotal == 0) {
                System.out.println("No Journeys are being completed yet.");
            } else {
                System.out.println("Total transport mode journeys cost/fare:");
                System.out.println("---------------------------------------------------------");
                if (card1TrainTotal != 0) {
                    System.out.println("Total cost of train journeys is $" + TrainTotal);
                }
                if (card1TramTotal != 0) {
                    System.out.println("Total cost of tram journeys is $" + TramTotal);
                }
                if (card1BusTotal != 0) {
                    System.out.println("Total cost of bus journeys is $" + BusTotal);
                }
                System.out.println("---------------------------------------------------------");
                System.out.println();
                System.out.println("Breakdown by smartcard:");
                System.out.println("---------------------------------------------------------");
                if (card1TrainTotal != 0 || card1TramTotal != 0 || card1BusTotal != 0) {
                    System.out.println("SmartCard " + smartCard1.getCardID());
                    if (card1TrainTotal != 0) {
                        System.out.println("    Total cost of train journeys is $" + card1TrainTotal);
                    }
                    if (card1TramTotal != 0) {
                        System.out.println("    Total cost of tram journeys is $" + card1TramTotal);
                    }
                    if (card1BusTotal != 0) {
                        System.out.println("    Total cost of bus journeys is $" + card1BusTotal);
                    }
                }
                if (card2TrainTotal != 0 || card2TramTotal != 0 || card2BusTotal != 0) {
                    System.out.println("SmartCard " + smartCard2.getCardID());
                    if (card2TrainTotal != 0) {
                        System.out.println("    Total cost of train journeys is $" + card2TrainTotal);
                    }
                    if (card2TramTotal != 0) {
                        System.out.println("    Total cost of tram journeys is $" + card2TramTotal);
                    }
                    if (card2BusTotal != 0) {
                        System.out.println("    Total cost of bus journeys is $" + card2BusTotal);
                    }
                }
                if (card3TrainTotal != 0 || card3TramTotal != 0 || card3BusTotal != 0) {
                    System.out.println("SmartCard " + smartCard3.getCardID());
                    if (card3TrainTotal != 0) {
                        System.out.println("    Total cost of train journeys is $" + card3TrainTotal);
                    }
                    if (card3TramTotal != 0) {
                        System.out.println("    Total cost of tram journeys is $" + card3TramTotal);
                    }
                    if (card3BusTotal != 0) {
                        System.out.println("    Total cost of bus journeys is $" + card3BusTotal);
                    }
                }
            }
        } else if (smartCard1 != InvalidCard && smartCard2 != InvalidCard) {
            double TrainTotal ;
            double TramTotal;
            double BusTotal;
            double card1TrainTotal = 0;
            double card1TramTotal = 0;
            double card1BusTotal = 0;
            double card1PriceFactor;
            double card2TrainTotal = 0;
            double card2TramTotal = 0;
            double card2BusTotal = 0;
            double card2PriceFactor;
            if (smartCard1.getType() == 'c') {
                card1PriceFactor = 1.86;
            } else if (smartCard1.getType() == 'a') {
                card1PriceFactor = 2.24;
            } else {
                card1PriceFactor = 1.6;
            }
            if (smartCard2.getType() == 'c') {
                card2PriceFactor = 1.86;
            } else if (smartCard2.getType() == 'a') {
                card2PriceFactor = 2.24;
            } else {
                card2PriceFactor = 1.6;
            }
            String card1Mode1 = smartCard1.getJourney1().getTransportMode();
            String card1Mode2 = smartCard1.getJourney2().getTransportMode();
            String card1Mode3 = smartCard1.getJourney3().getTransportMode();
            String card2Mode1 = smartCard2.getJourney1().getTransportMode();
            String card2Mode2 = smartCard2.getJourney2().getTransportMode();
            String card2Mode3 = smartCard2.getJourney3().getTransportMode();

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            TrainTotal = card1TrainTotal + card2TrainTotal;
            TramTotal = card1TramTotal + card2TramTotal;
            BusTotal = card1BusTotal + card2BusTotal;
            if (TrainTotal == TramTotal && TramTotal == BusTotal && BusTotal == 0) {
                System.out.println("No Journeys are being completed yet.");
            } else {
                System.out.println("Total transport mode journeys cost/fare:");
                System.out.println("---------------------------------------------------------");
                if (card1TrainTotal != 0) {
                    System.out.println("Total cost of train journeys is $" + TrainTotal);
                }
                if (card1TramTotal != 0) {
                    System.out.println("Total cost of tram journeys is $" + TramTotal);
                }
                if (card1BusTotal != 0) {
                    System.out.println("Total cost of bus journeys is $" + BusTotal);
                }
                System.out.println("---------------------------------------------------------");
                System.out.println();
                System.out.println("Breakdown by smartcard:");
                System.out.println("---------------------------------------------------------");
                if (card1TrainTotal != 0 || card1TramTotal != 0 || card1BusTotal != 0) {
                    System.out.println("SmartCard " + smartCard1.getCardID());
                    if (card1TrainTotal != 0) {
                        System.out.println("    Total cost of train journeys is $" + card1TrainTotal);
                    }
                    if (card1TramTotal != 0) {
                        System.out.println("    Total cost of tram journeys is $" + card1TramTotal);
                    }
                    if (card1BusTotal != 0) {
                        System.out.println("    Total cost of bus journeys is $" + card1BusTotal);
                    }
                }
                if (card2TrainTotal != 0 || card2TramTotal != 0 || card2BusTotal != 0) {
                    System.out.println("SmartCard " + smartCard2.getCardID());
                    if (card2TrainTotal != 0) {
                        System.out.println("    Total cost of train journeys is $" + card2TrainTotal);
                    }
                    if (card2TramTotal != 0) {
                        System.out.println("    Total cost of tram journeys is $" + card2TramTotal);
                    }
                    if (card2BusTotal != 0) {
                        System.out.println("    Total cost of bus journeys is $" + card2BusTotal);
                    }
                }
            }
        } else if (smartCard1 != InvalidCard && smartCard3 != InvalidCard) {
            double TrainTotal ;
            double TramTotal;
            double BusTotal;
            double card1TrainTotal = 0;
            double card1TramTotal = 0;
            double card1BusTotal = 0;
            double card1PriceFactor;
            double card3TrainTotal = 0;
            double card3TramTotal = 0;
            double card3BusTotal = 0;
            double card3PriceFactor;
            if (smartCard1.getType() == 'c') {
                card1PriceFactor = 1.86;
            } else if (smartCard1.getType() == 'a') {
                card1PriceFactor = 2.24;
            } else {
                card1PriceFactor = 1.6;
            }
            if (smartCard3.getType() == 'c') {
                card3PriceFactor = 1.86;
            } else if (smartCard3.getType() == 'a') {
                card3PriceFactor = 2.24;
            } else {
                card3PriceFactor = 1.6;
            }
            String card1Mode1 = smartCard1.getJourney1().getTransportMode();
            String card1Mode2 = smartCard1.getJourney2().getTransportMode();
            String card1Mode3 = smartCard1.getJourney3().getTransportMode();
            String card3Mode1 = smartCard3.getJourney1().getTransportMode();
            String card3Mode2 = smartCard3.getJourney2().getTransportMode();
            String card3Mode3 = smartCard3.getJourney3().getTransportMode();

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            TrainTotal = card1TrainTotal + card3TrainTotal;
            TramTotal = card1TramTotal + card3TramTotal;
            BusTotal = card1BusTotal + card3BusTotal;
            if (TrainTotal == TramTotal && TramTotal == BusTotal && BusTotal == 0) {
                System.out.println("No Journeys are being completed yet.");
            } else {
                System.out.println("Total transport mode journeys cost/fare:");
                System.out.println("---------------------------------------------------------");
                if (card1TrainTotal != 0) {
                    System.out.println("Total cost of train journeys is $" + TrainTotal);
                }
                if (card1TramTotal != 0) {
                    System.out.println("Total cost of tram journeys is $" + TramTotal);
                }
                if (card1BusTotal != 0) {
                    System.out.println("Total cost of bus journeys is $" + BusTotal);
                }
                System.out.println("---------------------------------------------------------");
                System.out.println();
                System.out.println("Breakdown by smartcard:");
                System.out.println("---------------------------------------------------------");
                if (card1TrainTotal != 0 || card1TramTotal != 0 || card1BusTotal != 0) {
                    System.out.println("SmartCard " + smartCard1.getCardID());
                    if (card1TrainTotal != 0) {
                        System.out.println("    Total cost of train journeys is $" + card1TrainTotal);
                    }
                    if (card1TramTotal != 0) {
                        System.out.println("    Total cost of tram journeys is $" + card1TramTotal);
                    }
                    if (card1BusTotal != 0) {
                        System.out.println("    Total cost of bus journeys is $" + card1BusTotal);
                    }
                }
                if (card3TrainTotal != 0 || card3TramTotal != 0 || card3BusTotal != 0) {
                    System.out.println("SmartCard " + smartCard3.getCardID());
                    if (card3TrainTotal != 0) {
                        System.out.println("    Total cost of train journeys is $" + card3TrainTotal);
                    }
                    if (card3TramTotal != 0) {
                        System.out.println("    Total cost of tram journeys is $" + card3TramTotal);
                    }
                    if (card3BusTotal != 0) {
                        System.out.println("    Total cost of bus journeys is $" + card3BusTotal);
                    }
                }
            }
        } else if (smartCard2 != InvalidCard && smartCard3 != InvalidCard) {
            double TrainTotal ;
            double TramTotal;
            double BusTotal;
            double card2TrainTotal = 0;
            double card2TramTotal = 0;
            double card2BusTotal = 0;
            double card2PriceFactor;
            double card3TrainTotal = 0;
            double card3TramTotal = 0;
            double card3BusTotal = 0;
            double card3PriceFactor;
            if (smartCard2.getType() == 'c') {
                card2PriceFactor = 1.86;
            } else if (smartCard2.getType() == 'a') {
                card2PriceFactor = 2.24;
            } else {
                card2PriceFactor = 1.6;
            }
            if (smartCard3.getType() == 'c') {
                card3PriceFactor = 1.86;
            } else if (smartCard3.getType() == 'a') {
                card3PriceFactor = 2.24;
            } else {
                card3PriceFactor = 1.6;
            }
            String card2Mode1 = smartCard2.getJourney1().getTransportMode();
            String card2Mode2 = smartCard2.getJourney2().getTransportMode();
            String card2Mode3 = smartCard2.getJourney3().getTransportMode();
            String card3Mode1 = smartCard3.getJourney1().getTransportMode();
            String card3Mode2 = smartCard3.getJourney2().getTransportMode();
            String card3Mode3 = smartCard3.getJourney3().getTransportMode();

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            TrainTotal = card2TrainTotal + card3TrainTotal;
            TramTotal = card2TramTotal + card3TramTotal;
            BusTotal = card2BusTotal + card3BusTotal;
            if (TrainTotal == TramTotal && TramTotal == BusTotal && BusTotal == 0) {
                System.out.println("No Journeys are being completed yet.");
            } else {
                System.out.println("Total transport mode journeys cost/fare:");
                System.out.println("---------------------------------------------------------");
                if (card2TrainTotal != 0) {
                    System.out.println("Total cost of train journeys is $" + TrainTotal);
                }
                if (card2TramTotal != 0) {
                    System.out.println("Total cost of tram journeys is $" + TramTotal);
                }
                if (card2BusTotal != 0) {
                    System.out.println("Total cost of bus journeys is $" + BusTotal);
                }
                System.out.println("---------------------------------------------------------");
                System.out.println();
                System.out.println("Breakdown by smartcard:");
                System.out.println("---------------------------------------------------------");
                if (card2TrainTotal != 0 || card2TramTotal != 0 || card2BusTotal != 0) {
                    System.out.println("SmartCard " + smartCard2.getCardID());
                    if (card2TrainTotal != 0) {
                        System.out.println("    Total cost of train journeys is $" + card2TrainTotal);
                    }
                    if (card2TramTotal != 0) {
                        System.out.println("    Total cost of tram journeys is $" + card2TramTotal);
                    }
                    if (card2BusTotal != 0) {
                        System.out.println("    Total cost of bus journeys is $" + card2BusTotal);
                    }
                }
                if (card3TrainTotal != 0 || card3TramTotal != 0 || card3BusTotal != 0) {
                    System.out.println("SmartCard " + smartCard3.getCardID());
                    if (card3TrainTotal != 0) {
                        System.out.println("    Total cost of train journeys is $" + card3TrainTotal);
                    }
                    if (card3TramTotal != 0) {
                        System.out.println("    Total cost of tram journeys is $" + card3TramTotal);
                    }
                    if (card3BusTotal != 0) {
                        System.out.println("    Total cost of bus journeys is $" + card3BusTotal);
                    }
                }
            }
        } else if (smartCard1 != InvalidCard) {
            double card1TrainTotal = 0;
            double card1TramTotal = 0;
            double card1BusTotal = 0;
            double card1PriceFactor;
            if (smartCard1.getType() == 'c') {
                card1PriceFactor = 1.86;
            } else if (smartCard1.getType() == 'a') {
                card1PriceFactor = 2.24;
            } else {
                card1PriceFactor = 1.6;
            }
            String card1Mode1 = smartCard1.getJourney1().getTransportMode();
            String card1Mode2 = smartCard1.getJourney2().getTransportMode();
            String card1Mode3 = smartCard1.getJourney3().getTransportMode();

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("train")) {
                card1TrainTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("train")) {
                card1TrainTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("tram")) {
                card1TramTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("tram")) {
                card1TramTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card1Mode1.equals(card1Mode2) && card1Mode2.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 4.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode2) && card1Mode2.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode1.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode2.equals(card1Mode3) && card1Mode3.equals("bus")) {
                card1BusTotal = 3 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney() + smartCard1.getJourney3().getDistanceOfJourney());
            } else if (card1Mode1.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney1().getDistanceOfJourney());
            } else if (card1Mode2.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney2().getDistanceOfJourney());
            } else if (card1Mode3.equals("bus")) {
                card1BusTotal = 1.5 + card1PriceFactor * (smartCard1.getJourney3().getDistanceOfJourney());
            }

            if (card1TrainTotal == card1TramTotal && card1TramTotal == card1BusTotal && card1BusTotal == 0) {
                System.out.println("No Journeys are being completed yet.");
            } else {
                System.out.println("Total transport mode journeys cost/fare:");
                System.out.println("---------------------------------------------------------");
                if (card1TrainTotal != 0) {
                    System.out.println("Total cost of train journeys is $" + card1TrainTotal);
                }
                if (card1TramTotal != 0) {
                    System.out.println("Total cost of tram journeys is $" + card1TramTotal);
                }
                if (card1BusTotal != 0) {
                    System.out.println("Total cost of bus journeys is $" + card1BusTotal);
                }
                System.out.println("---------------------------------------------------------");
                System.out.println();
                System.out.println("Breakdown by smartcard:");
                System.out.println("---------------------------------------------------------");
                System.out.println("SmartCard " + smartCard1.getCardID());
                if (card1TrainTotal != 0) {
                    System.out.println("    Total cost of train journeys is $" + card1TrainTotal);
                }
                if (card1TramTotal != 0) {
                    System.out.println("    Total cost of tram journeys is $" + card1TramTotal);
                }
                if (card1BusTotal != 0) {
                    System.out.println("    Total cost of bus journeys is $" + card1BusTotal);
                }
            }

        } else if (smartCard2 != InvalidCard) {
            double card2TrainTotal = 0;
            double card2TramTotal = 0;
            double card2BusTotal = 0;
            double card2PriceFactor;
            if (smartCard2.getType() == 'c') {
                card2PriceFactor = 1.86;
            } else if (smartCard2.getType() == 'a') {
                card2PriceFactor = 2.24;
            } else {
                card2PriceFactor = 1.6;
            }
            String card2Mode1 = smartCard2.getJourney1().getTransportMode();
            String card2Mode2 = smartCard2.getJourney2().getTransportMode();
            String card2Mode3 = smartCard2.getJourney3().getTransportMode();

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("train")) {
                card2TrainTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("train")) {
                card2TrainTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("tram")) {
                card2TramTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("tram")) {
                card2TramTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card2Mode1.equals(card2Mode2) && card2Mode2.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 4.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode2) && card2Mode2.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode1.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode2.equals(card2Mode3) && card2Mode3.equals("bus")) {
                card2BusTotal = 3 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney() + smartCard2.getJourney3().getDistanceOfJourney());
            } else if (card2Mode1.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney1().getDistanceOfJourney());
            } else if (card2Mode2.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney2().getDistanceOfJourney());
            } else if (card2Mode3.equals("bus")) {
                card2BusTotal = 1.5 + card2PriceFactor * (smartCard2.getJourney3().getDistanceOfJourney());
            }

            if (card2TrainTotal == card2TramTotal && card2TramTotal == card2BusTotal && card2BusTotal == 0) {
                System.out.println("No Journeys are being completed yet.");
            } else {
                System.out.println("Total transport mode journeys cost/fare:");
                System.out.println("---------------------------------------------------------");
                if (card2TrainTotal != 0) {
                    System.out.println("Total cost of train journeys is $" + card2TrainTotal);
                }
                if (card2TramTotal != 0) {
                    System.out.println("Total cost of tram journeys is $" + card2TramTotal);
                }
                if (card2BusTotal != 0) {
                    System.out.println("Total cost of bus journeys is $" + card2BusTotal);
                }
                System.out.println("---------------------------------------------------------");
                System.out.println();
                System.out.println("Breakdown by smartcard:");
                System.out.println("---------------------------------------------------------");
                System.out.println("SmartCard " + smartCard2.getCardID());
                if (card2TrainTotal != 0) {
                    System.out.println("    Total cost of train journeys is $" + card2TrainTotal);
                }
                if (card2TramTotal != 0) {
                    System.out.println("    Total cost of tram journeys is $" + card2TramTotal);
                }
                if (card2BusTotal != 0) {
                    System.out.println("    Total cost of bus journeys is $" + card2BusTotal);
                }
            }
        } else if (smartCard3 != InvalidCard) {
            double card3TrainTotal = 0;
            double card3TramTotal = 0;
            double card3BusTotal = 0;
            double card3PriceFactor;
            if (smartCard3.getType() == 'c') {
                card3PriceFactor = 1.86;
            } else if (smartCard3.getType() == 'a') {
                card3PriceFactor = 2.24;
            } else {
                card3PriceFactor = 1.6;
            }
            String card3Mode1 = smartCard3.getJourney1().getTransportMode();
            String card3Mode2 = smartCard3.getJourney2().getTransportMode();
            String card3Mode3 = smartCard3.getJourney3().getTransportMode();

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("train")) {
                card3TrainTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("train")) {
                card3TrainTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("tram")) {
                card3TramTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("tram")) {
                card3TramTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            if (card3Mode1.equals(card3Mode2) && card3Mode2.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 4.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode2) && card3Mode2.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode1.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode2.equals(card3Mode3) && card3Mode3.equals("bus")) {
                card3BusTotal = 3 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney() + smartCard3.getJourney3().getDistanceOfJourney());
            } else if (card3Mode1.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney1().getDistanceOfJourney());
            } else if (card3Mode2.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney2().getDistanceOfJourney());
            } else if (card3Mode3.equals("bus")) {
                card3BusTotal = 1.5 + card3PriceFactor * (smartCard3.getJourney3().getDistanceOfJourney());
            }

            if (card3TrainTotal == card3TramTotal && card3TramTotal == card3BusTotal && card3BusTotal == 0) {
                System.out.println("No Journeys are being completed yet.");
            } else {
                System.out.println("Total transport mode journeys cost/fare:");
                System.out.println("---------------------------------------------------------");
                if (card3TrainTotal != 0) {
                    System.out.println("Total cost of train journeys is $" + card3TrainTotal);
                }
                if (card3TramTotal != 0) {
                    System.out.println("Total cost of tram journeys is $" + card3TramTotal);
                }
                if (card3BusTotal != 0) {
                    System.out.println("Total cost of bus journeys is $" + card3BusTotal);
                }
                System.out.println("---------------------------------------------------------");
                System.out.println();
                System.out.println("Breakdown by smartcard:");
                System.out.println("---------------------------------------------------------");
                System.out.println("SmartCard " + smartCard3.getCardID());
                if (card3TrainTotal != 0) {
                    System.out.println("    Total cost of train journeys is $" + card3TrainTotal);
                }
                if (card3TramTotal != 0) {
                    System.out.println("    Total cost of tram journeys is $" + card3TramTotal);
                }
                if (card3BusTotal != 0) {
                    System.out.println("    Total cost of bus journeys is $" + card3BusTotal);
                }
            }
        } else {
            System.out.println("No Journeys are being completed yet.");
        }
    }

    private void FunctionSelector(Scanner keyboard) {
        String mode;
        int cardJourneySet = 0;
        System.out.println("Options:");
        System.out.println("(1) Set SmartCards");
        System.out.println("(2) Set Journeys");
        System.out.println("(3) Delete SmartCard");
        System.out.println("(4) Delete Journey");
        System.out.println("(5) List SmartCards");
        System.out.println("(6) List Journeys");
        System.out.println("(7) Find Journeys with specific transport type");
        System.out.println("(8) Calculate Fares");
        System.out.println("(9) Exit");
        System.out.print("What would you like to do (1-9)? ");
        int choice = keyboard.nextInt();
        switch (choice) {
            case 1:
                CardSetter(keyboard);
                break;
            case 2:
                if (smartCard1 != InvalidCard && smartCard2 != InvalidCard && smartCard3 != InvalidCard) {
                    while (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard2.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to set journeys on are: " + smartCard1.getCardID() + ", " + smartCard2.getCardID() + " and " + smartCard3.getCardID() + ".");
                        System.out.print("Which card would you like to set journeys on? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard2.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard1.getCardID()) {
                        smartCard1 = JourneySetter(smartCard1, keyboard);
                    } else if (cardJourneySet == smartCard2.getCardID()) {
                        smartCard2 = JourneySetter(smartCard2, keyboard);
                    } else if (cardJourneySet == smartCard3.getCardID()) {
                        smartCard3 = JourneySetter(smartCard3, keyboard);
                    }
                } else if (smartCard1 != InvalidCard && smartCard2 != InvalidCard) {
                    while (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard2.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to set journeys on are: " + smartCard1.getCardID() + " and " + smartCard2.getCardID() + ".");
                        System.out.print("Which card would you like to set journeys on? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard2.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard1.getCardID()) {
                        smartCard1 = JourneySetter(smartCard1, keyboard);
                    } else if (cardJourneySet == smartCard2.getCardID()) {
                        smartCard2 = JourneySetter(smartCard2, keyboard);
                    }
                } else if (smartCard1 != InvalidCard && smartCard3 != InvalidCard) {
                    while (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to set journeys on are: " + smartCard1.getCardID() + " and " + smartCard3.getCardID() + ".");
                        System.out.print("Which card would you like to set journeys on? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard1.getCardID()) {
                        smartCard1 = JourneySetter(smartCard1, keyboard);
                    } else if (cardJourneySet == smartCard3.getCardID()) {
                        smartCard3 = JourneySetter(smartCard3, keyboard);
                    }
                } else if (smartCard2 != InvalidCard && smartCard3 != InvalidCard) {
                    while (cardJourneySet != smartCard2.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to set journeys on are: " + smartCard2.getCardID() + " and " + smartCard3.getCardID() + ".");
                        System.out.print("Which card would you like to set journeys on? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard2.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard2.getCardID()) {
                        smartCard2 = JourneySetter(smartCard2, keyboard);
                    } else if (cardJourneySet == smartCard3.getCardID()) {
                        smartCard3 = JourneySetter(smartCard3, keyboard);
                    }
                } else if (smartCard1 != InvalidCard) {
                    while (cardJourneySet != smartCard1.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to set journeys on are: " + smartCard1.getCardID() + ".");
                        System.out.print("Which card would you like to set journeys on? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard1.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard1.getCardID()) {
                        smartCard1 = JourneySetter(smartCard1, keyboard);
                    }
                } else if (smartCard2 != InvalidCard) {
                    while (cardJourneySet != smartCard2.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to set journeys on are: " + smartCard2.getCardID() + ".");
                        System.out.print("Which card would you like to set journeys on? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard2.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard2.getCardID()) {
                        smartCard2 = JourneySetter(smartCard2, keyboard);
                    }
                } else if (smartCard3 != InvalidCard) {
                    while (cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to set journeys on are: " + smartCard3.getCardID() + ".");
                        System.out.print("Which card would you like to set journeys on? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard3.getCardID()) {
                        smartCard3 = JourneySetter(smartCard3, keyboard);
                    }
                } else {
                    System.out.println("There are no cards to set journeys on.");
                }
                break;
            case 3:
                CardDeleter(keyboard);
                break;
            case 4:
                if (smartCard1 != InvalidCard && smartCard2 != InvalidCard && smartCard3 != InvalidCard) {
                    while (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard2.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to delete journeys from are: " + smartCard1.getCardID() + ", " + smartCard2.getCardID() + " and " + smartCard3.getCardID() + ".");
                        System.out.print("Which card would you like to delete journeys from? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard2.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard1.getCardID()) {
                        smartCard1 = JourneyDeleter(smartCard1, keyboard);
                    } else if (cardJourneySet == smartCard2.getCardID()) {
                        smartCard2 = JourneyDeleter(smartCard2, keyboard);
                    } else if (cardJourneySet == smartCard3.getCardID()) {
                        smartCard3 = JourneyDeleter(smartCard3, keyboard);
                    }
                } else if (smartCard1 != InvalidCard && smartCard2 != InvalidCard) {
                    while (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard2.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to delete journeys from are: " + smartCard1.getCardID() + " and " + smartCard2.getCardID() + ".");
                        System.out.print("Which card would you like to delete journeys from? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard2.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard1.getCardID()) {
                        smartCard1 = JourneyDeleter(smartCard1, keyboard);
                    } else if (cardJourneySet == smartCard2.getCardID()) {
                        smartCard2 = JourneyDeleter(smartCard2, keyboard);
                    }
                } else if (smartCard1 != InvalidCard && smartCard3 != InvalidCard) {
                    while (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to delete journeys from are: " + smartCard1.getCardID() + " and " + smartCard3.getCardID() + ".");
                        System.out.print("Which card would you like to delete journeys from? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard1.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard1.getCardID()) {
                        smartCard1 = JourneyDeleter(smartCard1, keyboard);
                    } else if (cardJourneySet == smartCard3.getCardID()) {
                        smartCard3 = JourneyDeleter(smartCard3, keyboard);
                    }
                } else if (smartCard2 != InvalidCard && smartCard3 != InvalidCard) {
                    while (cardJourneySet != smartCard2.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to delete journeys from are: " + smartCard2.getCardID() + " and " + smartCard3.getCardID() + ".");
                        System.out.print("Which card would you like to delete journeys from? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard2.getCardID() && cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard2.getCardID()) {
                        smartCard2 = JourneyDeleter(smartCard2, keyboard);
                    } else if (cardJourneySet == smartCard3.getCardID()) {
                        smartCard3 = JourneyDeleter(smartCard3, keyboard);
                    }
                } else if (smartCard1 != InvalidCard) {
                    while (cardJourneySet != smartCard1.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to delete journeys from are: " + smartCard1.getCardID() + ".");
                        System.out.print("Which card would you like to delete journeys from? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard1.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard1.getCardID()) {
                        smartCard1 = JourneyDeleter(smartCard1, keyboard);
                    }
                } else if (smartCard2 != InvalidCard) {
                    while (cardJourneySet != smartCard2.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to delete journeys from are: " + smartCard2.getCardID() + ".");
                        System.out.print("Which card would you like to delete journeys from? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard2.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard2.getCardID()) {
                        smartCard2 = JourneyDeleter(smartCard2, keyboard);
                    }
                } else if (smartCard3 != InvalidCard) {
                    while (cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                        System.out.println("The available cards to delete journeys from are: " + smartCard3.getCardID() + ".");
                        System.out.print("Which card would you like to delete journeys from? ");
                        cardJourneySet = keyboard.nextInt();
                        if (cardJourneySet != smartCard3.getCardID() && cardJourneySet < 1) {
                            System.out.println("Please input a valid value.");
                        }
                    }
                    if (cardJourneySet == smartCard3.getCardID()) {
                        smartCard3 = JourneyDeleter(smartCard3, keyboard);
                    }
                } else {
                    System.out.println("There are no cards to delete journeys from.");
                }
                break;
            case 5:
                CardLister();
                break;
            case 6:
                JourneyLister();
                break;
            case 7:
                System.out.print("What transport mode would you like to know about? ");
                mode = keyboard.next().toLowerCase();
                TransportModeFinder(mode);
                break;
            case 8:
                FareCalculator();
                break;
            case 9:
                running = false;
                break;
            default:
                System.out.println("Not a valid input.");
                break;
        }
    }

    public static void main(String[] args) {
        SystemInterface systemUI = new SystemInterface();
        systemUI.run();
    }
}