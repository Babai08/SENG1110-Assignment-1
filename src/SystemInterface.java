import java.util.Scanner;

public class SystemInterface {

    private SmartCard smartCard1 = new SmartCard();
    private SmartCard smartCard2 = new SmartCard();
    private SmartCard smartCard3 = new SmartCard();
    private Journey InvalidJourney = new Journey();

    private void run() {
        InvalidJourney.setJourneyID(0);
        InvalidJourney.setStartOfJourney(0);
        InvalidJourney.setEndOfJourney(0);
        InvalidJourney.setTransportMode("NaN");
        InvalidJourney.setDistanceOfJourney();

        smartCard1.setJourney1(InvalidJourney);
        smartCard1.setJourney2(InvalidJourney);
        smartCard1.setJourney3(InvalidJourney);
        smartCard2.setJourney1(InvalidJourney);
        smartCard2.setJourney2(InvalidJourney);
        smartCard2.setJourney3(InvalidJourney);
        smartCard3.setJourney1(InvalidJourney);
        smartCard3.setJourney2(InvalidJourney);
        smartCard3.setJourney3(InvalidJourney);


        Scanner keyboard = new Scanner(System.in);

        smartCard1.setType('a');
        smartCard1 = JourneySetter(smartCard1, keyboard);
        JourneyDeleter(smartCard1, keyboard);
    }

    public SmartCard JourneySetter(SmartCard card, Scanner keyboard){
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

    public SmartCard JourneyDeleter(SmartCard card, Scanner keyboard) {
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

    public static void main(String[] args) {
        SystemInterface systemUI = new SystemInterface();
        systemUI.run();
    }
}