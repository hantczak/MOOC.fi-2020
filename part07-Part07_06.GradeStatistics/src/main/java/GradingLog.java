import java.util.ArrayList;

public class GradingLog {
    private ArrayList<Integer> pointsList;
    private ArrayList<Integer> gradesList;

    public GradingLog() {
        pointsList = new ArrayList<>();
        gradesList = new ArrayList<>();
    }

    public void addPointsToLog(int points) {
        if (points <= 100 && points >= 0) {
            pointsList.add(points);
        }
    }

    public void pointsToGrades() {
        for (Integer points : pointsList) {
            if (points < 50) {
                gradesList.add(0);
            } else if (points < 60) {
                gradesList.add(1);
            } else if (points < 70) {
                gradesList.add(2);
            } else if (points < 80) {
                gradesList.add(3);
            } else if (points < 90) {
                gradesList.add(4);
            } else {
                gradesList.add(5);
            }
        }
    }

    public void printGrades(){
        for(int i=5;i>=0;i--){
            printStars(i);
            System.out.print("\n");
        }
    }

    private void printStars(int number){
        System.out.print(number + ":" );
        for (Integer grade:gradesList){
            if(grade == number){
                System.out.print("*");
            }
        }
    }

    public double pointsAverage() {
        int sum = 0;
        int numberOfEntries = 0;
        for (Integer points : pointsList) {
            numberOfEntries++;
            sum += points;
        }
        return sum / (numberOfEntries * 1.0);
    }

    public double passingPointsAverage() {
        int sum = 0;
        int numberOfEntries = 0;
        for (Integer points : pointsList) {
            if (points >= 50) {
                numberOfEntries++;
                sum += points;
            }
        }
        return sum / (numberOfEntries * 1.0);
    }

    public double passPercentage(){
        int passedQuantity=0;
        int failedQuantity=0;
        for(Integer points:pointsList){
            if(points>=50){
                passedQuantity++;
            }else {
                failedQuantity++;
            }
        }
        return (passedQuantity/(passedQuantity+failedQuantity*1.0))*100;
    }
}

