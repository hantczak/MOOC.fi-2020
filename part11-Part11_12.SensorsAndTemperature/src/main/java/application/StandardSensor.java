package application;

public class StandardSensor implements Sensor {
    private int reading;

    public StandardSensor(int number) {
        this.reading = number;
    }

    public int read() {
        return this.reading;
    }

    public boolean isOn() {
        return true;
    }

    public void setOn() {
    }

    public void setOff() {
    }


}
