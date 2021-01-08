
import java.util.Scanner;

public class GiftTax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Value of the gift?");
        int inputValue = Integer.valueOf(scan.nextLine());
        double outputValue;

        if (inputValue < 5000) {
            System.out.println("No tax!");
        } else if (inputValue < 25000) {
            outputValue = 100 + (((double)inputValue-5000)*0.08);
            System.out.println("Tax: " + outputValue);
        } else if (inputValue < 55000) {
            outputValue = 1700 + (((double)inputValue-25000)*0.1);
            System.out.println("Tax: " + outputValue);
        } else if (inputValue < 200000) {
            outputValue = 4700 + (((double)inputValue-55000)*0.12);
            System.out.println("Tax: " + outputValue);
        } else if (inputValue < 1000000) {
            outputValue = 22100 + (((double)inputValue-200000)*0.15);
            System.out.println("Tax: " + outputValue);
        } else if (inputValue > 1000000) {
            outputValue = 142100 + (((double)inputValue-1000000)*0.17);
            System.out.println("Tax: " + outputValue);
        }
    }
}