import java.time.LocalDateTime;
public class OfficalRaceRegister implements RaceRegister{

    @Override
    public String register(int category, Race race, Racer racer) {
        //check if they are signed up with the system?

        //check if they have a valid license
        License license = racer.getRacerLicense();
        String date = String.valueOf(LocalDateTime.now());
        if (license.isExpired(date)) {
            return "Registration Failed: License is expired";
        }

        //check if they are already registered to the race
        if (race.racers.contains(racer)) {
            return "Registration Failed: You are already registered for this race";
        }
        
        //check if registration is still open
        String deadline = race.getRegistrationDeadline();
        if (date.compareTo(deadline) > 0) {
            return "Registration Failed: Registration deadline has already passed";
        }

        //check racers cat level
        //TODO: cat level needs to be added to racer and race
        //in order to show the race requirement and racers current level

        //register racer
        race.racers.add(racer);
        return "Registration Successful";
    }
}
