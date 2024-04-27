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

    private void run() {
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

        smartCard1 = InvalidCard;
        smartCard2 = InvalidCard;
        smartCard3 = InvalidCard;


        Scanner keyboard = new Scanner(System.in);
        CardSetter(keyboard);

        smartCard1 = JourneySetter(smartCard1, keyboard);

        TransportModeFinder("Train");
    }

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
                    smartCard1 = subCard2;
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
            System.out.println("You can set 1 Journey on this card.");
            System.out.print("How many journeys would you like to set? ");
            int numJourneys = keyboard.nextInt();
            if (numJourneys == 1) {
                int JourneyID = 0;
                while (JourneyID < 1) {
                    System.out.print("Journey ID? ");
                    JourneyID = keyboard.nextInt();
                }
                String transportMode = " ";
                while (!transportMode.equals("Train") && !transportMode.equals("Tram") && !transportMode.equals("Bus")) {
                    System.out.print("Journey's transport mode? ");
                    transportMode = keyboard.next();
                }
                int start = 0;
                while (start < 1 || start > 10) {
                    System.out.print("Starting point for journey? (1,10) ");
                    start = keyboard.nextInt();
                }
                int end = 0;
                while (end < 1 || end > 10) {
                    System.out.print("Ending point for journey? (1,10) ");
                    end = keyboard.nextInt();
                }
                Journey j = new Journey();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney1(j);
                return subCard;
            } else if (numJourneys == 0) {
                return subCard;
            } else {
                return JourneySetter(card, keyboard);
            }

        } else if (card.getType() == 'a') {
            System.out.println("You can set 2 Journeys on this card.");
            System.out.print("How many journeys would you like to set? ");
            int numJourneys = keyboard.nextInt();
            if (numJourneys == 2) {
                int JourneyID = 0;
                while (JourneyID < 1) {
                    System.out.print("Journey 1 ID? ");
                    JourneyID = keyboard.nextInt();
                }
                String transportMode = " ";
                while (!transportMode.equals("Train") && !transportMode.equals("Tram") && !transportMode.equals("Bus")) {
                    System.out.print("Journey 1's transport mode? ");
                    transportMode = keyboard.next();
                }
                int start = 0;
                while (start < 1 || start > 10) {
                    System.out.print("Starting point for journey 1? (1,10) ");
                    start = keyboard.nextInt();
                }
                int end = 0;
                while (end < 1 || end > 10) {
                    System.out.print("Ending point for journey 1? (1,10) ");
                    end = keyboard.nextInt();
                }
                Journey i = new Journey();
                i.setJourneyID(JourneyID);
                i.setTransportMode(transportMode);
                i.setStartOfJourney(start);
                i.setEndOfJourney(end);
                i.setDistanceOfJourney();
                subCard.setJourney1(i);

                JourneyID = 0;
                while (JourneyID < 1 || JourneyID == subCard.getJourney1().getJourneyID()) {
                    System.out.print("Journey 2 ID? ");
                    JourneyID = keyboard.nextInt();
                }
                transportMode = " ";
                while (!transportMode.equals("Train") && !transportMode.equals("Tram") && !transportMode.equals("Bus")) {
                    System.out.print("Journey 2's transport mode? ");
                    transportMode = keyboard.next();
                }
                start = 0;
                while (start < 1 || start > 10) {
                    System.out.print("Starting point for journey 2? (1,10) ");
                    start = keyboard.nextInt();
                }
                end = 0;
                while (end < 1 || end > 10) {
                    System.out.print("Ending point for journey 2? (1,10) ");
                    end = keyboard.nextInt();
                }
                Journey j = new Journey();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney2(j);
                return subCard;
            } else if (numJourneys == 1) {
                int JourneyID = 0;
                while (JourneyID < 1) {
                    System.out.print("Journey ID? ");
                    JourneyID = keyboard.nextInt();
                }
                String transportMode = " ";
                while (!transportMode.equals("Train") && !transportMode.equals("Tram") && !transportMode.equals("Bus")) {
                    System.out.print("Journey's transport mode? ");
                    transportMode = keyboard.next();
                }
                int start = 0;
                while (start < 1 || start > 10) {
                    System.out.print("Starting point for journey? (1,10) ");
                    start = keyboard.nextInt();
                }
                int end = 0;
                while (end < 1 || end > 10) {
                    System.out.print("Ending point for journey? (1,10) ");
                    end = keyboard.nextInt();
                }
                Journey j = new Journey();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney1(j);
                return subCard;
            } else if (numJourneys == 0) {
                return subCard;
            } else {
                return JourneySetter(card, keyboard);
            }
        } else {
            System.out.println("You can set 3 journeys on this card.");
            System.out.print("How many journeys would you like to set?");
            int numJourneys = keyboard.nextInt();
            if (numJourneys == 3) {
                int JourneyID = 0;
                while (JourneyID < 1) {
                    System.out.print("Journey 1 ID? ");
                    JourneyID = keyboard.nextInt();
                }
                String transportMode = " ";
                while (!transportMode.equals("Train") && !transportMode.equals("Tram") && !transportMode.equals("Bus")) {
                    System.out.print("Journey 1's transport mode? ");
                    transportMode = keyboard.next();
                }
                int start = 0;
                while (start < 1 || start > 10) {
                    System.out.print("Starting point for journey 1? (1,10) ");
                    start = keyboard.nextInt();
                }
                int end = 0;
                while (end < 1 || end > 10) {
                    System.out.print("Ending point for journey 1? (1,10) ");
                    end = keyboard.nextInt();
                }
                Journey i = new Journey();
                i.setJourneyID(JourneyID);
                i.setTransportMode(transportMode);
                i.setStartOfJourney(start);
                i.setEndOfJourney(end);
                i.setDistanceOfJourney();
                subCard.setJourney1(i);

                JourneyID = 0;
                while (JourneyID < 1 || JourneyID == subCard.getJourney1().getJourneyID()) {
                    System.out.print("Journey 2 ID? ");
                    JourneyID = keyboard.nextInt();
                }
                transportMode = " ";
                while (!transportMode.equals("Train") && !transportMode.equals("Tram") && !transportMode.equals("Bus")) {
                    System.out.print("Journey 2's transport mode? ");
                    transportMode = keyboard.next();
                }
                start = 0;
                while (start < 1 || start > 10) {
                    System.out.print("Starting point for journey 2? (1,10) ");
                    start = keyboard.nextInt();
                }
                end = 0;
                while (end < 1 || end > 10) {
                    System.out.print("Ending point for journey 2? (1,10) ");
                    end = keyboard.nextInt();
                }
                Journey j = new Journey();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney2(j);

                JourneyID = 0;
                while (JourneyID < 1 || JourneyID == subCard.getJourney1().getJourneyID() || JourneyID == subCard.getJourney2().getJourneyID()) {
                    System.out.print("Journey 3 ID? ");
                    JourneyID = keyboard.nextInt();
                }
                transportMode = " ";
                while (!transportMode.equals("Train") && !transportMode.equals("Tram") && !transportMode.equals("Bus")) {
                    System.out.print("Journey 3's transport mode? ");
                    transportMode = keyboard.next();
                }
                start = 0;
                while (start < 1 || start > 10) {
                    System.out.print("Starting point for journey 3? (1,10) ");
                    start = keyboard.nextInt();
                }
                end = 0;
                while (end < 1 || end > 10) {
                    System.out.print("Ending point for journey 3? (1,10) ");
                    end = keyboard.nextInt();
                }
                Journey k = new Journey();
                k.setJourneyID(JourneyID);
                k.setTransportMode(transportMode);
                k.setStartOfJourney(start);
                k.setEndOfJourney(end);
                k.setDistanceOfJourney();
                subCard.setJourney3(k);
                return subCard;
            } else if (numJourneys == 2) {
                int JourneyID = 0;
                while (JourneyID < 1) {
                    System.out.print("Journey 1 ID? ");
                    JourneyID = keyboard.nextInt();
                }
                String transportMode = " ";
                while (!transportMode.equals("Train") && !transportMode.equals("Tram") && !transportMode.equals("Bus")) {
                    System.out.print("Journey 1's transport mode? ");
                    transportMode = keyboard.next();
                }
                int start = 0;
                while (start < 1 || start > 10) {
                    System.out.print("Starting point for journey 1? (1,10) ");
                    start = keyboard.nextInt();
                }
                int end = 0;
                while (end < 1 || end > 10) {
                    System.out.print("Ending point for journey 1? (1,10) ");
                    end = keyboard.nextInt();
                }
                Journey i = new Journey();
                i.setJourneyID(JourneyID);
                i.setTransportMode(transportMode);
                i.setStartOfJourney(start);
                i.setEndOfJourney(end);
                i.setDistanceOfJourney();
                subCard.setJourney1(i);

                JourneyID = 0;
                while (JourneyID < 1 || JourneyID == subCard.getJourney1().getJourneyID()) {
                    System.out.print("Journey 2 ID? ");
                    JourneyID = keyboard.nextInt();
                }
                transportMode = " ";
                while (!transportMode.equals("Train") && !transportMode.equals("Tram") && !transportMode.equals("Bus")) {
                    System.out.print("Journey 2's transport mode? ");
                    transportMode = keyboard.next();
                }
                start = 0;
                while (start < 1 || start > 10) {
                    System.out.print("Starting point for journey 2? (1,10) ");
                    start = keyboard.nextInt();
                }
                end = 0;
                while (end < 1 || end > 10) {
                    System.out.print("Ending point for journey 2? (1,10) ");
                    end = keyboard.nextInt();
                }
                Journey j = new Journey();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney2(j);
                return subCard;
            } else if (numJourneys == 1) {
                int JourneyID = 0;
                while (JourneyID < 1) {
                    System.out.print("Journey ID? ");
                    JourneyID = keyboard.nextInt();
                }
                String transportMode = " ";
                while (!transportMode.equals("Train") && !transportMode.equals("Tram") && !transportMode.equals("Bus")) {
                    System.out.print("Journey's transport mode? ");
                    transportMode = keyboard.next();
                }
                int start = 0;
                while (start < 1 || start > 10) {
                    System.out.print("Starting point for journey? (1,10) ");
                    start = keyboard.nextInt();
                }
                int end = 0;
                while (end < 1 || end > 10) {
                    System.out.print("Ending point for journey? (1,10) ");
                    end = keyboard.nextInt();
                }
                Journey j = new Journey();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney1(j);
                return subCard;
            } else if (numJourneys == 0) {
                return subCard;
            } else {
                return JourneySetter(card, keyboard);
            }
        }
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
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + "journeys.");
            System.out.println("Journey " + sC1jID1 + " has transport mode " + smartCard1.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC1jID2 + " has transport mode " + smartCard1.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC1jID3 + " has transport mode " + smartCard1.getJourney3().getTransportMode() + ".");
        } else if (sC1jID1 != 0 && sC1jID2 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + "journeys.");
            System.out.println("Journey " + sC1jID1 + " has transport mode " + smartCard1.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC1jID2 + " has transport mode " + smartCard1.getJourney2().getTransportMode() + ".");
        } else if (sC1jID1 != 0  && sC1jID3 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + "journeys.");
            System.out.println("Journey " + sC1jID1 + " has transport mode " + smartCard1.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC1jID3 + " has transport mode " + smartCard1.getJourney3().getTransportMode() + ".");
        } else if (sC1jID2 != 0 && sC1jID3 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + "journeys.");
            System.out.println("Journey " + sC1jID2 + " has transport mode " + smartCard1.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC1jID3 + " has transport mode " + smartCard1.getJourney3().getTransportMode() + ".");
        } else if (sC1jID1 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + "journey.");
            System.out.println("Journey " + sC1jID1 + " has transport mode " + smartCard1.getJourney1().getTransportMode() + ".");
        } else if (sC1jID2 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + "journey.");
            System.out.println("Journey " + sC1jID2 + " has transport mode " + smartCard1.getJourney2().getTransportMode() + ".");
        } else if (sC1jID3 != 0) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + "journey.");
            System.out.println("Journey " + sC1jID3 + " has transport mode " + smartCard1.getJourney3().getTransportMode() + ".");
        } else if (smartCard1 != InvalidCard) {
            System.out.println("Smartcard " + smartCard1.getCardID() + " has type " + smartCard1.getType() + " and " + num1 + "journeys.");
        }

        if (sC2jID1 != 0 && sC2jID2 != 0 && sC2jID3 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + "journeys.");
            System.out.println("Journey " + sC2jID1 + " has transport mode " + smartCard2.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC2jID2 + " has transport mode " + smartCard2.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC2jID3 + " has transport mode " + smartCard2.getJourney3().getTransportMode() + ".");
        } else if (sC2jID1 != 0 && sC2jID2 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + "journeys.");
            System.out.println("Journey " + sC2jID1 + " has transport mode " + smartCard2.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC2jID2 + " has transport mode " + smartCard2.getJourney2().getTransportMode() + ".");
        } else if (sC2jID1 != 0  && sC2jID3 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + "journeys.");
            System.out.println("Journey " + sC2jID1 + " has transport mode " + smartCard2.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC2jID3 + " has transport mode " + smartCard2.getJourney3().getTransportMode() + ".");
        } else if (sC2jID2 != 0 && sC2jID3 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + "journeys.");
            System.out.println("Journey " + sC2jID2 + " has transport mode " + smartCard2.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC2jID3 + " has transport mode " + smartCard2.getJourney3().getTransportMode() + ".");
        } else if (sC2jID1 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + "journey.");
            System.out.println("Journey " + sC2jID1 + " has transport mode " + smartCard2.getJourney1().getTransportMode() + ".");
        } else if (sC2jID2 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + "journey.");
            System.out.println("Journey " + sC2jID2 + " has transport mode " + smartCard2.getJourney2().getTransportMode() + ".");
        } else if (sC2jID3 != 0) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + "journey.");
            System.out.println("Journey " + sC2jID3 + " has transport mode " + smartCard2.getJourney3().getTransportMode() + ".");
        } else if (smartCard2 != InvalidCard) {
            System.out.println("Smartcard " + smartCard2.getCardID() + " has type " + smartCard2.getType() + " and " + num2 + "journeys.");
        }

        if (sC3jID1 != 0 && sC3jID2 != 0 && sC3jID3 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + "journeys.");
            System.out.println("Journey " + sC3jID1 + " has transport mode " + smartCard3.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC3jID2 + " has transport mode " + smartCard3.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC3jID3 + " has transport mode " + smartCard3.getJourney3().getTransportMode() + ".");
        } else if (sC3jID1 != 0 && sC3jID2 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + "journeys.");
            System.out.println("Journey " + sC3jID1 + " has transport mode " + smartCard3.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC3jID2 + " has transport mode " + smartCard3.getJourney2().getTransportMode() + ".");
        } else if (sC3jID1 != 0  && sC3jID3 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + "journeys.");
            System.out.println("Journey " + sC3jID1 + " has transport mode " + smartCard3.getJourney1().getTransportMode() + ".");
            System.out.println("Journey " + sC3jID3 + " has transport mode " + smartCard3.getJourney3().getTransportMode() + ".");
        } else if (sC3jID2 != 0 && sC3jID3 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + "journeys.");
            System.out.println("Journey " + sC3jID2 + " has transport mode " + smartCard3.getJourney2().getTransportMode() + ".");
            System.out.println("Journey " + sC3jID3 + " has transport mode " + smartCard3.getJourney3().getTransportMode() + ".");
        } else if (sC3jID1 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + "journey.");
            System.out.println("Journey " + sC3jID1 + " has transport mode " + smartCard3.getJourney1().getTransportMode() + ".");
        } else if (sC3jID2 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + "journey.");
            System.out.println("Journey " + sC3jID2 + " has transport mode " + smartCard3.getJourney2().getTransportMode() + ".");
        } else if (sC3jID3 != 0) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num1 + "journey.");
            System.out.println("Journey " + sC3jID3 + " has transport mode " + smartCard3.getJourney3().getTransportMode() + ".");
        } else if (smartCard3 != InvalidCard) {
            System.out.println("Smartcard " + smartCard3.getCardID() + " has type " + smartCard3.getType() + " and " + num3 + "journeys.");
        }

    }

    private void JourneyLister() {

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

    public static void main(String[] args) {
        SystemInterface systemUI = new SystemInterface();
        systemUI.run();
    }
}