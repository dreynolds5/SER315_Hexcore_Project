public class UnofficalRaceRegister implements RaceRegister {

    @Override
    public String register(int category, Race race, Racer racer) {
        //check if they are already registered to the race
        if (race.racers.contains(racer)) {
            return "Registration Failed: You are already registered for this race.";
        }
        
        //check if registration is still open
        String deadline = race.getRegistrationDeadline();
        if (date.compareTo(deadline) > 0) {
            return "Registration Failed: Registration deadline has already passed";
        }
       
        //register racer
        race.racers.add(racer);
        return "Registration Successful";
    }
}
