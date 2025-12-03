import java.time.LocalDate;
public class UnofficalRaceRegister implements RaceRegister {

    @Override
    public String register(int category, Race race, Racer racer) {
        //check if they are already registered to the race
        if (race.racers.contains(racer)) {
            return "Registration Failed: You are already registered for this race.";
        }

        //check if the participation limit has been reached
        if (race.getNumRacers() >= race.getParticipationLimit()) {
            return "Registration Failed: No more slots left";
        }
        
        //check if registration is still open
        String date = String.valueOf(LocalDate.now());
        String deadline = race.getRegistrationDeadline();
        if (date.compareTo(deadline) > 0) {
            return "Registration Failed: Registration deadline has already passed";
        }
       
        //register racer
        race.racers.add(racer);
        return "Registration Successful";
    }
}
