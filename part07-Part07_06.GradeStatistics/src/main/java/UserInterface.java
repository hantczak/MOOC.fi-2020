import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private GradingLog gradingLog;

    public UserInterface(Scanner scanner, GradingLog gradingLog) {
        this.scanner = scanner;
        this.gradingLog = gradingLog;
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == -1) {
                break;
            }
            processPoints(input);
        }
        System.out.println("Point average (all): " + getAverage());
        System.out.println("Point average (passing): " + getPassingAverage());
        System.out.println("Pass percentage: " + getPassPercentage());
        printGradesDistribution();
    }

    public void processPoints(int input) {
        gradingLog.addPointsToLog(input);
    }

    public double getAverage() {
        return gradingLog.pointsAverage();
    }

    public double getPassingAverage() {
        return gradingLog.passingPointsAverage();
    }

    public double getPassPercentage() {
        return gradingLog.passPercentage();
    }

    public void printGradesDistribution() {
        gradingLog.pointsToGrades();
        gradingLog.printGrades();
    }
}
