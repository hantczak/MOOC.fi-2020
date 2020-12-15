import validating.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(null,5);
        System.out.println(person.getName() + person.getAge());
    }
}
