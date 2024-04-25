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
        System.out.print("transportMode= " + j.getTransportMode());
    }

    public void JourneySetter(SmartCard card){
        Journey invalidJourney = new Journey();
        invalidJourney.setJourneyID(-1);
        invalidJourney.setTransportMode("NaN");
        invalidJourney.setStartOfJourney(0);
        invalidJourney.setEndOfJourney(0);
        invalidJourney.setDistanceOfJourney();
        if (card.getType() == 'c') {
            card.setJourney2(invalidJourney);
            card.setJourney3(invalidJourney);
        }
    }

    public static void main(String[] args) {
        SystemInterface systemUI = new SystemInterface();
        systemUI.run();

    }
}