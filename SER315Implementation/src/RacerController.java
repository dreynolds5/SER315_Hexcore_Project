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
        racers.add(new Racer(101, "Alex Morgan", "alex.morgan@example.com", "FastR4cer!"));
        racers.add(new Racer(102, "Shawn Morgan", "shawn.morgan@example.com", "Fast3rR4cer!"));

        races.add(new Race(201, "Desert Dash Classic","2025-12-25", 26.2, "Red Rock Canyon Loop", "criterium", true, 250, "2025-11-25"));
        races.add(new Race(202, "Sunset Fun Ride","2026-1-17", 10.5, "Lakeside Trail Route", "Road Race", false, 100, "2026-1-17"));

        raceRegisterStrategy = null;
        registrationState = "";
    }


    public boolean login(String name, String password) {
        for (Racer racer : racers) {
            if(racer.getRacerName().equals(name) && racer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public void raceRegister(String username, int raceId, int category){
        Race race = this.getRace(raceId);
        Racer racer = this.getRacer(username);
        this.setRaceRegisterStrategy(race);

        setData(raceRegisterStrategy.register(category, race, racer));
    }

    public String showRaces(){
        String racesString = "";
        for (Race race : races){
            racesString = racesString + race.displayRace() + "\n";
        }
        return racesString;
    }

    public void setRaceRegisterStrategy(Race race){
        if (race.isOfficial()){
            raceRegisterStrategy = new OfficalRaceRegister();
            return;
        }
        raceRegisterStrategy = new UnofficalRaceRegister();
    }

    public Race getRace(int id){
        for (Race race : races){
            if (race.getRaceID() == id){
                return race;
            }
        }
        return null;
    }

    public int getUserCategory(String name){
        Racer racer = this.getRacer(name);
        return racer.getRacerLicense().getLicenseCategory();
    }
    public Racer getRacer(int id){
        for (Racer racer : racers){
            if(racer.getRacerId() == id){
                return racer;
            }
        }
        return null;
    }
    public Racer getRacer(String name){
        for (Racer racer : racers){
            if(racer.getRacerName().equals(name)){
                return racer;
            }
        }
        return null;
    }

    public License getLicense(Racer racer){
        return racer.getRacerLicense();
    }

    public void setData(String newRegistrationState) {
        // Only notify observers if the data has actually changed
        if (!newRegistrationState.equals(this.registrationState)) {
            this.registrationState = newRegistrationState;
            notifyObservers(this.registrationState); // Notify all registered observers
        }
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String state) {
        for (Observer observer : observers) {
            observer.sendStatus(state);
        }
    }
}
