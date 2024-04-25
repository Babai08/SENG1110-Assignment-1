public class Journey {

    private int journeyID;
    private String transportMode;
    private int startOfJourney;
    private int endOfJourney;
    private int distanceOfJourney;


    public void setTransportMode(String transportMode)
    {
        this.transportMode = transportMode;
    }

    public String getTransportMode()
    {
        return transportMode;
    }

    public int getJourneyID() {
        return journeyID;
    }

    public int getDistanceOfJourney() {
        return distanceOfJourney;
    }

    public int getEndOfJourney() {
        return endOfJourney;
    }

    public int getStartOfJourney() {
        return startOfJourney;
    }

    public void setDistanceOfJourney() {
        if (endOfJourney > startOfJourney) {
            this.distanceOfJourney = endOfJourney - startOfJourney;
        }
        else {
            this.distanceOfJourney = startOfJourney - endOfJourney;
        }
    }

    public void setJourneyID(int journeyID) {
        this.journeyID = journeyID;
    }

    public void setEndOfJourney(int endOfJourney) {
        this.endOfJourney = endOfJourney;
    }

    public void setStartOfJourney(int startOfJourney) {
        this.startOfJourney = startOfJourney;
    }
}