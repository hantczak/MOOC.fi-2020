package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean ifOn;

    public TemperatureSensor(){
        this.ifOn = false;
    }

    public int read() {
        if(this.ifOn=false) {
            throw new IllegalStateException("This temperature sensor is off.");
        }
        return new Random().nextInt(61)-30;
    }

    public boolean isOn() {
        return this.ifOn;
    }

    public void setOn() {
        this.ifOn=true;
    }

    public void setOff() {
        this.ifOn=false;
    }


}
