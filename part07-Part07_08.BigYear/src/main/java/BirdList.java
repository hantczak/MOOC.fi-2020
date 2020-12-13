import java.util.ArrayList;

public class BirdList {
    private ArrayList<Bird> birdList;

    public BirdList() {
        birdList = new ArrayList<>();
    }

    public void add(String name, String latinName) {
        birdList.add(new Bird(name, latinName));
    }

    public String toString() {
        String output = "";
        int i = 0;
        for (Bird bird : birdList) {
            i++;
            if (i == birdList.size()) {
                output += bird.name() + "(" + bird.getLatinName() + "): " + bird.getObservations() + " observations";
                return output;
            }
            output += bird.name() + "(" + bird.getLatinName() + "): " + bird.getObservations() + " observations" + "\n";
        }
        return output;
    }

    public void observation(String name) {
        boolean ifFound = false;
        for (Bird bird : birdList) {
            if (bird.name().equals(name)) {
                bird.observation();
                ifFound = true;
            }
        }
        if (!ifFound) {
            System.out.println("Not a bird!");
        }
    }

    public String getOneBird(String name) {
        for (Bird bird : birdList) {
            if (bird.name().equals(name)) {
                return bird.toString();
            }
        }
        return "No bird in database!";
    }

}
