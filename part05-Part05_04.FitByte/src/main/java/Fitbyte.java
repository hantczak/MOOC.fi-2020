public class Fitbyte {
    private int age;
    private double restingHeartRate;

    public Fitbyte(int age, int restingHeartRate) {
        this.age = age;
        this.restingHeartRate = restingHeartRate;
    }

    public double maxHeartRate(int age) {
        return 206.3 - (0.711 * age);
    }

    public double targetHeartRate(double percentageOfMaximum) {
      return  (this.maxHeartRate(this.age) - restingHeartRate)*percentageOfMaximum+restingHeartRate;
    }
}
