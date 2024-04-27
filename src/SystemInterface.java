import java.util.Scanner;

public class SystemInterface {

    private SmartCard smartCard1, smartCard2, smartCard3;
    private void run() {

        Scanner keyboard = new Scanner(System.in);
        SmartCard sc = new SmartCard();
        int cardID;
        System.out.print("Card ID? ");
        cardID = keyboard.nextInt();
        sc.setSmartCardID(cardID);
        System.out.println("Card ID = " + sc.getCardID());

        Journey j = new Journey();
        String transportMode;
        System.out.print("Journey's transport Mode? ");
        transportMode = keyboard.next();
        j.setTransportMode(transportMode);
        System.out.println("transportMode= " + j.getTransportMode());

        SmartCard card = new SmartCard();
        card.setType('c');
        JourneySetter(card, keyboard);
    }

    public void JourneySetter(SmartCard card, Scanner keyboard){
        Journey invalidJourney = new Journey();
        invalidJourney.setJourneyID(-1);
        invalidJourney.setTransportMode("NaN");
        invalidJourney.setStartOfJourney(0);
        invalidJourney.setEndOfJourney(0);
        invalidJourney.setDistanceOfJourney();
        if (card.getType() == 'c') {
            card.setJourney2(invalidJourney);
            card.setJourney3(invalidJourney);
            System.out.println("You can set 1 Journey on this card.");
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
            card.setJourney1(j);

        }
    }


    public void CardSetter(Scanner keyboard) {
        int numberOfCards;
        SmartCard sc1 = new SmartCard();
        SmartCard sc2 = new SmartCard();
        SmartCard sc3 = new SmartCard();
        System.out.print("How many cards would you like to add?");
        System.out.print("Input a number of cards between 0 to 3");
        numberOfCards = keyboard.nextInt();
        for (int i = 1; i <= numberOfCards; i++) {
            System.out.print("Card" + i + "type: ");
            char type = keyboard.next();
            if (type = "c") {

            }
            else if (type = "a") {

            }
            else if (type = "S") {

            }
            else {
                System.out.print("Invalid card type, please try again");

            }
        }
    }


    public static void main(String[] args) {
        SystemInterface systemUI = new SystemInterface();
        systemUI.run();

    }
}

