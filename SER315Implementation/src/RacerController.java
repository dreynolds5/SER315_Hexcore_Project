import java.util.ArrayList;


public class RacerController{
    private ArrayList<Racer> racers;
    private ArrayList<Race> races;
    private ArrayList<Observer> observers;
    private RaceRegister raceRegisterStrategy;
    private String registrationState;

    public RacerController() {
        racers = new ArrayList<>();
        races = new ArrayList<>();
        observers = new ArrayList<>();
        racers.add(new Racer(101, "Alex_Morgan", "alex.morgan@example.com", "FastR4cer!"));
        racers.add(new Racer(102, "Shawn_Morgan", "shawn.morgan@example.com", "Fast3rR4cer!"));

        races.add(new Race(201, "Desert Dash Classic","2025-12-25", 26.2, "Red Rock Canyon Loop", "criterium", true, 250, "2025-11-25"));
        races.add(new Race(202, "Sunset Fun Ride","2026-1-17", 10.5, "Lakeside Trail Route", "Road Race", false, 100, "2026-1-17"));

        raceRegisterStrategy = null;
        registrationState = "";
    }

    /**
     * Funtion to login to the system
     * @param name
     * @param password
     * @return true if the login was successful and false otherwise
     */
    public boolean login(String name, String password) {
        for (Racer racer : racers) {
            if(racer.getRacerName().equals(name) && racer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to register for a race, sets the strategy to the desired race type then notifies the observers about the result of the registration
     * @param username
     * @param raceId
     * @param category
     */
    public void raceRegister(String username, int raceId, int category){
        Race race = this.getRace(raceId);
        Racer racer = this.getRacer(username);
        this.setRaceRegisterStrategy(race);

        setData(raceRegisterStrategy.register(category, race, racer));
    }

    /**
     * Method to return a string of all the races
     * @return string showing all race information for all the races
     */
    public String showRaces(){
        String racesString = "";
        for (Race race : races){
            racesString = racesString + race.displayRace() + "\n";
        }
        return racesString;
    }

    /**
     * Method to return a string of all the race information summaries
     * @return string of all the race information summaries
     */
    public String showRaceSummary(){
        String racesString = "";
        for (Race race : races){
            racesString = racesString + race.displayRaceSummary() + "\n";
        }
        return racesString;
    }

    /**
     * Sets the strategy to the desired strategy
     * @param race
     */
    public void setRaceRegisterStrategy(Race race){
        if (race.isOfficial()){
            raceRegisterStrategy = new OfficalRaceRegister();
            return;
        }
        raceRegisterStrategy = new UnofficalRaceRegister();
    }

    /**
     * Get race object for a race with raceID id
     * @param id
     * @return Race object for race with raceID id
     */
    public Race getRace(int id){
        for (Race race : races){
            if (race.getRaceID() == id){
                return race;
            }
        }
        return null;
    }

    /**
     * Get category of user with name name
     * @param name
     * @return int category of user
     */
    public int getUserCategory(String name){
        Racer racer = this.getRacer(name);
        return racer.getRacerLicense().getLicenseCategory();
    }

    /**
     * Get racer object for a racer with racerID id
     * @param id
     * @return racer object for a racer with racerID id
     */
    public Racer getRacer(int id){
        for (Racer racer : racers){
            if(racer.getRacerId() == id){
                return racer;
            }
        }
        return null;
    }

    /**
     * Get racer object for a racer with racerName name
     * @param name
     * @return racer object for a racer with racerName name
     */
    public Racer getRacer(String name){
        for (Racer racer : racers){
            if(racer.getRacerName().equals(name)){
                return racer;
            }
        }
        return null;
    }

    /**
     * Get License from racer
     * @param racer
     * @return License from Racer
     */
    public License getLicense(Racer racer){
        return racer.getRacerLicense();
    }

    /**
     * Method to notify the observers of the newRegistrationState
     * @param newRegistrationState
     */
    public void setData(String newRegistrationState) {
        // Only notify observers if the data has actually changed
        if (!newRegistrationState.equals(this.registrationState)) {
            this.registrationState = newRegistrationState;
            notifyObservers(this.registrationState); // Notify all registered observers
        }
    }

    /**
     * Adds observers
     * @param o Observer to add
     */
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Removes observers
     * @param o Observer to remove
     */
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Method to send the new state to the observers
     * @param state
     */
    public void notifyObservers(String state) {
        for (Observer observer : observers) {
            observer.sendStatus(state);
        }
    }
}
