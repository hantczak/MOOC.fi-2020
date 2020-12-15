package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    public int read() {
        double average;
        if(this.isOn()==false){
            throw new IllegalStateException("Sensor is off.");
        }
        if(sensors.isEmpty()){
            throw new IllegalStateException("No sensors added.");
        }
        average = this.sensors.stream()
                .mapToInt(sensor -> sensor.read())
                .average()
                .getAsDouble();
        readings.add((int)(average));
        return (int)average;
    }

    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (sensor.isOn() == false) {
                return false;
            }
        }
        return true;
    }

    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }

    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
    }

    public List<Integer> readings(){
        return readings;
    }
}
