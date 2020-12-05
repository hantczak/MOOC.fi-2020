public class Checker {

    public boolean isDayOfWeek(String string){
        if(string.matches("mon|tue|wed|thu|fri|sat|sun")){
            System.out.println("The form is correct.");
            return true;
        }else {
            System.out.println("The form is incorrect.");
            return false;
        }
    }

    public boolean allVowels(String string){
        String regex = "[a|e|i|o|u]*";
        for (int i=0;i<string.length();i++) {
            if(!(string.matches(regex))){
                System.out.println("The form is incorrect.");
                return false;
            }
        }
        System.out.println("The form is correct.");
        return true;

    }

    public boolean timeOfDay(String string){
        if(string.matches("([0-1][0-9]|[0-2][0-3]):[0-5][0-9]:[0-5][0-9]")){
            System.out.println("Form is correct.");
            return true;
        }else {
            System.out.println("Form is incorrect.");
            return false;
        }

    }
}
