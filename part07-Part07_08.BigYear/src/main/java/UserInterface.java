import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private BirdList birdList;

    public UserInterface(Scanner scanner, BirdList birdList) {
        this.scanner = scanner;
        this.birdList = birdList;
    }

    public void start() {
        while (true) {
            System.out.print("? ");
            String command = scanner.nextLine();
            if (command.equals("Quit")) {
                break;
            }
            this.processCommand(command);
        }
    }

    public void processCommand(String command) {
        switch (command) {
            case "Add":
                this.add();
                break;

            case "Observation":
                this.observation();
                break;

            case "All":
                System.out.println(birdList.toString());
                break;

            case "One":
                this.one();
                break;

        }
    }

    public void add() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Name in Latin: ");
        String latinName = scanner.nextLine();
        birdList.add(name, latinName);
    }

    public void observation(){
        System.out.print("Bird? ");
        birdList.observation(scanner.nextLine());
    }

    public void one(){
        System.out.print("Bird? ");
        System.out.println(birdList.getOneBird(scanner.nextLine()));
    }
}
