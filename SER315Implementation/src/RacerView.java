import java.util.Observable;
import java.util.Scanner;

public class RacerView {
    RacerController racerController = new RacerController();
    Observer successfulRegistration = new SuccessObserver();
    Observer failedRegistration =  new FailedObserver();

    public static void main(String[] args) {
        RacerView view = new RacerView();
        view.initObservers();
        view.basePage();
    }

    public void initObservers(){
        this.racerController.addObserver(successfulRegistration);
        this.racerController.addObserver(failedRegistration);
    }
    public void basePage() {
        Scanner scanner = new Scanner(System.in);
        boolean loginStatus = false;

        while (true) {
            System.out.println("Enter username to login:");
            String username = scanner.nextLine();

            System.out.println("Enter password to finish logging in:");
            String password = scanner.nextLine();

            loginStatus = racerController.login(username, password);
            if (loginStatus) {
                homePage(username);
            } else {
                System.out.println("Login Failed.");
            }
        }
    }

    public void homePage(String username) {
        Scanner scanner = new Scanner(System.in);
        boolean inHomePage = true;
        int cat;

        while(inHomePage) {
            System.out.println("Enter 1 to find races");
            System.out.println("Enter 2 to register for race");
            System.out.println("Enter 3 to view current category");
            System.out.println("Enter 4 to log out");
            System.out.println("Enter 5 to exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: //show all races
                    System.out.println(racerController.showRaces());
                    break;
                case 2: //register for a race
                    System.out.println("Enter raceID: ");
                    int raceID = scanner.nextInt();
                    System.out.println("Enter your current category: ");
                    cat = scanner.nextInt();
                    racerController.raceRegister(username,raceID,cat);
                    break;
                case 3:
                    cat = racerController.getUserCategory(username);
                    System.out.println("Current Category: " + cat);
                    break;
                case 4: //log out
                    System.out.println("logging out");
                    inHomePage = false;
                    break;
                case 5: //exit system
                    System.exit(0);
                    break;
                default: //invalid choice
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}



