import java.time.LocalDate;
public class OfficalRaceRegister implements RaceRegister{

    @Override
    public String register(int category, Race race, Racer racer) {
        //check if they have a valid license
        License license = racer.getRacerLicense();
        String date = String.valueOf(LocalDate.now());
        if (license.isExpired(date)) {
            return "Registration Failed: License is expired";
        }

        //check if the participation limit has been reached
        if (race.getNumRacers() >= race.getParticipationLimit()) {
            return "Registration Failed: No more slots left";
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
        int cat = license.getLicenseCategory();
        if (cat != category) {
            return "Registration Failed: Incorrect category";
        }
        
        //register racer
        race.racers.add(racer);
        return "Registration Successful";
    }
}
