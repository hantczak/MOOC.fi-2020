
import java.util.Objects;

public class Person {

    private String name;
    private SimpleDate birthday;
    private int height;
    private int weight;

    public Person(String name, SimpleDate birthday, int height, int weight) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
    }

    // implement an equals method here for checking the equality of objects

    public boolean equals(Person compared) {

        if (this == compared) {
            return true;
        }


        if (this.weight == compared.weight &&
                this.birthday.equals((compared.birthday)) &&
                        this.height == compared.height &&
                        this.name.equals(compared.name)){
            return true;
        }
        return false;
    }
}
