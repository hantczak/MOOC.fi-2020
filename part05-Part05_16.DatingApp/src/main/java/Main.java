
public class Main {

    public static void main(String[] args) {
        // test your program here!
        SimpleDate date = new SimpleDate(30,12,1996);
        SimpleDate date1 = new SimpleDate(15,12,1996);
        SimpleDate date2 = new SimpleDate(30,10,1996);

        date.advance(5);
        date1.advance();
        date2.advance();

        System.out.println(date.toString());
        System.out.println(date1.toString());
        System.out.println(date2.toString());

        SimpleDate newDate = date.afterNumberOfDays(20);
        System.out.println(newDate);
        System.out.println(date);


    }
}
