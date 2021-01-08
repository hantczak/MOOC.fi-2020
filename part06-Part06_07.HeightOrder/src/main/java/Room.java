import java.util.ArrayList;

public class Room {
    ArrayList<Person> room;

    public Room() {
        room = new ArrayList<>();
    }

    public void add(Person person) {
        this.room.add(person);
    }

    public boolean isEmpty() {
        if (room.isEmpty()) {
            return true;
        }
        return false;
    }

    public ArrayList<Person> getPersons(){
        return room;
    }

    public Person shortest(){
        if(room.isEmpty()){
            return null;
        }

        Person shortest = room.get(0);
        for (Person person:room){
            if(person.getHeight()<shortest.getHeight()){
                shortest = person;
            }
        }
        return shortest;
    }

    public Person take(){
        Person shortest = this.shortest();
        room.remove(shortest);
        return shortest;
    }
}
