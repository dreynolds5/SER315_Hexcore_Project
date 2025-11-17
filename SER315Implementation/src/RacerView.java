import java.util.Observable;
import java.util.Scanner;

public class RacerView {
    //the objects, connections to controller classes
    RacerController racerController = new RacerController();
    Observer successfulRegistration = new SuccessObserver();
    Observer failedRegistration =  new FailedObserver();
    //main, create necessary objects
    public static void main(String[] args) {
        RacerView view = new RacerView();
        view.initObservers();
        view.basePage();
    }
    //initialize observer
    public void initObservers(){
        this.racerController.addObserver(successfulRegistration);
        this.racerController.addObserver(failedRegistration);
    }

    public void basePage() {
        Scanner scanner = new Scanner(System.in);
        boolean loginStatus = false;

        while (true) {
            System.out.println("1: log in");
            System.out.println("2: exit");
            System.out.println("Enter your choice\n");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1: //log in
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
                    break;
                case 2: //exit system
                    System.exit(0);
            }

        }
    }

    public void homePage(String username) {
        Scanner scanner = new Scanner(System.in);
        boolean inHomePage = true;
        int cat;

        while(inHomePage) {
            System.out.println("1: to find races");
            System.out.println("2: to register for race");
            System.out.println("4: to log out");
            System.out.println("5: to exit");
            System.out.println("Enter your choice\n");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: //show all races
                    System.out.println(racerController.showRaces());
                    break;
                case 2: //register for a race
                    System.out.println(racerController.showRaceSummary());
                    System.out.println("Enter raceID: ");
                    int raceID = scanner.nextInt();
                    System.out.println("Enter your current category: ");
                    cat = racerController.getUserCategory(username);
                    racerController.raceRegister(username,raceID,cat);
                    break;
                case 3: //log out
                    System.out.println("logging out");
                    inHomePage = false;
                    break;
                case 4: //exit system
                    System.exit(0);
                    break;
                default: //invalid choice
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}



