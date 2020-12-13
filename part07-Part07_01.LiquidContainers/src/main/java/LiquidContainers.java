
import javax.naming.PartialResultException;
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;

        System.out.println("First: " + first + "/100");
        System.out.println("Second: " + second + "/100");
        while (true) {

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts[0].equals("add")) {
                if (Integer.valueOf(parts[1]) < 0) {
                } else if (first + Integer.valueOf(parts[1]) > 100) {
                    first = 100;
                } else {
                    first += Integer.valueOf(parts[1]);
                }
            }

            if (parts[0].equals("move")) {
                if (Integer.valueOf(parts[1]) < 0) {
                } else if (first <= Integer.valueOf(parts[1])) {
                    second += first;
                    first = 0;
                } else if (second + Integer.valueOf(parts[1]) > 100) {
                    second = 100;
                    first = 0;
                } else {
                    second += Integer.valueOf(parts[1]);
                    first -= Integer.valueOf(parts[1]);
                }
            }

            if (parts[0].equals("remove")){
                if(Integer.valueOf(parts[1])<0){
                }
                if(Integer.valueOf(parts[1])>second){
                    second=0;
                }else {
                    second-=Integer.valueOf(parts[1]);
                }


            }
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");
        }
    }
}


