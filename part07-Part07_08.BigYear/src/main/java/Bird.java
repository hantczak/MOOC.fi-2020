public class Bird {
    private String name;
    private String latinName;
    private int observations;

    public Bird(String name, String latinName){
        this.name = name;
        this.latinName = latinName;
        this.observations = 0;
    }

    public String name() {
        return name;
    }

    public int getObservations() {
        return observations;
    }

    public String getLatinName() {
        return latinName;
    }

    public void observation(){
        this.observations++;
    }

    public String toString(){
        return this.name() + "(" + this.getLatinName() + "): " + this.getObservations() + " observations";
    }
}
