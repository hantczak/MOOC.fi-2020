
import java.util.Scanner;

public class NumberOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while(true){
            System.out.println("Give a number:");
            int input = scanner.nextInt();
            if (input==0){
                break;
            }else{
                i++;
            }
        }
        System.out.println("Number of numbers: " + i);
    }
}
