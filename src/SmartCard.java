public class SmartCard {

    // Sets up the private variables.
    private int cardID;
    private char type;
    private double balance;
    private Journey journey1;
    private Journey journey2;
    private Journey journey3;

    // Getters and Setters.
    public void setSmartCardID(int cardID) {
        this.cardID = cardID;
    }

    public int getCardID() {
        return cardID;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setJourney1(Journey journey1) {
        this.journey1 = journey1;
    }

    public Journey getJourney1() {
        return journey1;
    }

    public void setJourney2(Journey journey2) {
        this.journey2 = journey2;
    }

    public Journey getJourney2() {
        return journey2;
    }

    public void setJourney3(Journey journey3) {
        this.journey3 = journey3;
    }

    public Journey getJourney3() {
        return journey3;
    }
}