import java.util.ArrayList;
import java.util.Observable;


public class RacerController extends Observable {
    private ArrayList<Racer> racers;
    private ArrayList<Race> races;
    private RaceRegister raceRegisterStrategy;
    private String registrationState;



    public RacerController() {
        racers = new ArrayList<>();
        races = new ArrayList<>();
        racers.add(new Racer(101, "Alex Morgan", "alex.morgan@example.com", "FastR4cer!"));
        racers.add(new Racer(102, "Shawn Morgan", "shawn.morgan@example.com", "Fast3rR4cer!"));

        races.add(new Race(201, "Desert Dash Classic","12252025", 26.2, "Red Rock Canyon Loop", "criterium", true, 250, "11252025"));
        races.add(new Race(202, "Sunset Fun Ride","11262025", 10.5, "Lakeside Trail Route", "Road Race", false, 100, "10262025"));

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
    public void raceRegister(int category, Race race, Racer racer){
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

    public Racer getRacer(int id){
        for (Racer racer : racers){
            if(racer.getRacerId() == id){
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
            setChanged(); // Mark the Observable object as having been changed
            notifyObservers(this.registrationState); // Notify all registered observers
        }
    }

}
