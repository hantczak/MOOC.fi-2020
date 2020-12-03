
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while(true){
            int input = scanner.nextInt();

            if(input<0){
                break;
            }
            list.add(input);
        }

        List<Integer> filteredList = list.stream()
                .filter(value-> value>=1 && value<=5)
                .collect(Collectors.toCollection(ArrayList::new));

        for(int value:filteredList){
            System.out.println(value);
        }
    }
}
