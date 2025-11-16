import java.util.Scanner;

public class RacerView {
    private RacerController racerController = new RacerController();

    public static void main(String[] args) {
        RacerView view = new RacerView();
        view.basePage();
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
                break; 
            } else {
                System.out.println("Login Failed.");
            }
        }
    }

    public void homePage(String username) {
        Scanner scanner = new Scanner(System.in);
        boolean inHomePage = true;

        while(inHomePage) {
            System.out.println("Enter 1 to find races");
            System.out.println("Enter 2 to register for race");
            System.out.println("Enter 3 to log out");
            System.out.println("Enter 4 to exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: //show all races
                    racerController.showRaces();
                    break;
                case 2: //register for a race
                    System.out.println("Enter raceID: ");
                    int raceID = scanner.nextInt();
                    racerController.raceRegister(raceID,username);
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

