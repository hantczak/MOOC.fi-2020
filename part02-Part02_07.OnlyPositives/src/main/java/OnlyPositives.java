
import java.util.Scanner;

public class OnlyPositives {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Give a number:");
            int input = scanner.nextInt();
            if ( input < 0){
                System.out.println("Unsuitable number");
                continue;
            }else if (input==0){
                break;
            }else{
                double power = Math.pow((double)input,2.0);
                System.out.println((int)power);
            }

        }
    }
}
