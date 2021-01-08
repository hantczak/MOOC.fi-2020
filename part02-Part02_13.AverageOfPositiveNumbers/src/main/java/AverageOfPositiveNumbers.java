
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double average = 0;
        int i = 0;
        int sum = 0;
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            if (number > 0) {
                i++;
                sum = sum + number;
            }
        }
        if (i==0){
            System.out.println("Cannot calculate the average");
        }else{
            average = (double)sum/i;
            System.out.println(average);
        }
    }
}
