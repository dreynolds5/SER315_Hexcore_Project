import java.util.ArrayList;

public class Race {
    private int raceID;
    private String name;
    private String date;
    private double miles;
    private String route;
    private String raceType;
    private boolean isOfficial;
    private int participationLimit;
    private String registrationDeadline;
    ArrayList<Racer> racers;

    public Race(int id, String name, String date, double miles, String route, String type, boolean isOfficial, int participationLimit, String registrationDeadline) {
        this.raceID = id;
        this.name = name;
        this.date = date;
        this.miles = miles;
        this.route = route;
        this.raceType = type;
        this.isOfficial = isOfficial;
        this.participationLimit = participationLimit;
        this.registrationDeadline = registrationDeadline;
        this.racers = new ArrayList<>();
    }

    public String displayRace() {
        StringBuilder displayRace = new StringBuilder();
        displayRace.append("|Race ID: " + raceID);
        displayRace.append("|Race Name: " + name);
        displayRace.append("|Race Date: " + date);
        displayRace.append("|Race Miles: " + miles);
        displayRace.append("|Race Route: " + route);
        displayRace.append("|Race Official: " + isOfficial);
        displayRace.append("|Race Registration Deadline: " + registrationDeadline);
        return displayRace.toString();
    }

    public void addRacer(Racer racer) {
        racers.add(racer);
    }

    public int getRaceID() {
        return raceID;
    }

    public void setRaceID(int raceID) {
        this.raceID = raceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    public int getParticipationLimit() {
        return participationLimit;
    }

    public void setParticipationLimit(int participationLimit) {
        this.participationLimit = participationLimit;
    }

    public String getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(String registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }
}
