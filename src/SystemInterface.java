import java.util.Scanner;

public class SystemInterface {

    private SmartCard smartCard1, smartCard2, smartCard3;
    private void run() {

        Scanner keyboard = new Scanner(System.in);

        SmartCard card = new SmartCard();
        card.setType('a');
        card = JourneySetter(card, keyboard);
        System.out.println(card.getJourney1());
    }

    public SmartCard JourneySetter(SmartCard card, Scanner keyboard){
        SmartCard subCard = card;
        if (card.getType() == 'c') {
            System.out.println("You can set 1 Journey on this card.");
            System.out.print("How many journeys would you like to set");
            int numJourneys = keyboard.nextInt();
            if (numJourneys == 1) {
                System.out.print("Journey ID? ");
                int JourneyID = keyboard.nextInt();
                System.out.print("Journey's transport mode? ");
                String transportMode = keyboard.next();
                System.out.print("Starting point? (1,10) ");
                int start = keyboard.nextInt();
                System.out.print("Ending point? (1,10) ");
                int end = keyboard.nextInt();
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
                System.out.print("Journey 1 ID? ");
                int JourneyID = keyboard.nextInt();
                System.out.print("Journey 1's transport mode? ");
                String transportMode = keyboard.next();
                System.out.print("Starting point for journey 1? (1,10) ");
                int start = keyboard.nextInt();
                System.out.print("Ending point for journey 1? (1,10) ");
                int end = keyboard.nextInt();
                Journey j = new Journey();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney1(j);

                System.out.print("Journey 2 ID? ");
                JourneyID = keyboard.nextInt();
                System.out.print("Journey 2's transport mode? ");
                transportMode = keyboard.next();
                System.out.print("Starting point for journey 2? (1,10) ");
                start = keyboard.nextInt();
                System.out.print("Ending point for journey 2? (1,10) ");
                end = keyboard.nextInt();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney2(j);
                return subCard;
            } else if (numJourneys == 1) {
                System.out.print("Journey ID? ");
                int JourneyID = keyboard.nextInt();
                System.out.print("Journey's transport mode? ");
                String transportMode = keyboard.next();
                System.out.print("Starting point? (1,10) ");
                int start = keyboard.nextInt();
                System.out.print("Ending point? (1,10) ");
                int end = keyboard.nextInt();
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
                System.out.print("Journey 1 ID? ");
                int JourneyID = keyboard.nextInt();
                System.out.print("Journey 1's transport mode? ");
                String transportMode = keyboard.next();
                System.out.print("Starting point for journey 1? (1,10) ");
                int start = keyboard.nextInt();
                System.out.print("Ending point for journey 1? (1,10) ");
                int end = keyboard.nextInt();
                Journey j = new Journey();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney1(j);

                System.out.print("Journey 2 ID? ");
                JourneyID = keyboard.nextInt();
                System.out.print("Journey 2's transport mode? ");
                transportMode = keyboard.next();
                System.out.print("Starting point for journey 2? (1,10) ");
                start = keyboard.nextInt();
                System.out.print("Ending point for journey 2? (1,10) ");
                end = keyboard.nextInt();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney2(j);

                System.out.print("Journey 3 ID? ");
                JourneyID = keyboard.nextInt();
                System.out.print("Journey 3's transport mode? ");
                transportMode = keyboard.next();
                System.out.print("Starting point for journey 3? (1,10) ");
                start = keyboard.nextInt();
                System.out.print("Ending point for journey 3? (1,10) ");
                end = keyboard.nextInt();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney3(j);
                return subCard;
            } else if (numJourneys == 2) {
                System.out.print("Journey 1 ID? ");
                int JourneyID = keyboard.nextInt();
                System.out.print("Journey 1's transport mode? ");
                String transportMode = keyboard.next();
                System.out.print("Starting point for journey 1? (1,10) ");
                int start = keyboard.nextInt();
                System.out.print("Ending point for journey 1? (1,10) ");
                int end = keyboard.nextInt();
                Journey j = new Journey();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney1(j);

                System.out.print("Journey 2 ID? ");
                JourneyID = keyboard.nextInt();
                System.out.print("Journey 2's transport mode? ");
                transportMode = keyboard.next();
                System.out.print("Starting point for journey 2? (1,10) ");
                start = keyboard.nextInt();
                System.out.print("Ending point for journey 2? (1,10) ");
                end = keyboard.nextInt();
                j.setJourneyID(JourneyID);
                j.setTransportMode(transportMode);
                j.setStartOfJourney(start);
                j.setEndOfJourney(end);
                j.setDistanceOfJourney();
                subCard.setJourney2(j);
                return subCard;
            } else if (numJourneys == 1) {
                System.out.print("Journey ID? ");
                int JourneyID = keyboard.nextInt();
                System.out.print("Journey's transport mode? ");
                String transportMode = keyboard.next();
                System.out.print("Starting point? (1,10) ");
                int start = keyboard.nextInt();
                System.out.print("Ending point? (1,10) ");
                int end = keyboard.nextInt();
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

    public static void main(String[] args) {
        SystemInterface systemUI = new SystemInterface();
        systemUI.run();

    }
}