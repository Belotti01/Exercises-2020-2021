public class Car {
    //Attributes
    private double gearSpeed[], speedPerSecond;
    private boolean isOn;
    private double maxSpeed, speed, fuel;
    private int gear;

    //Constructors
    Car() {
        maxSpeed = 160;
        speed = 0;
        fuel = 50;
        gear = 0;
        speedPerSecond = 1;
        isOn = false;
        setupGearSpeed();
    }

    Car(Car car) {
        maxSpeed = car.getMaxSpeed();
        speed = car.getSpeed();
        fuel = car.getFuel();
        gear = car.getGear();
        speedPerSecond = 1;
        isOn = car.isOn();
        setupGearSpeed();
    }

    Car(double maxSpeed) {
        this.maxSpeed = maxSpeed;
        speed = 0;
        fuel = 50;
        gear = 0;
        isOn = false;
        speedPerSecond = 1;
        setupGearSpeed();
    }

    Car(double maxSpeed, double fuel) {
        this.maxSpeed = maxSpeed;
        speed = 0;
        this.fuel = fuel < 0 ? 0 : fuel > 100 ? 100 : fuel;
        gear = 0;
        isOn = false;
        speedPerSecond = 1;
        setupGearSpeed();
    }

    Car(double maxSpeed, double fuel, int gear, double speed) {
        this.maxSpeed = maxSpeed;
        this.gear = gear > 6 ? 6 : gear < 0 ? 0 : gear;
        setupGearSpeed();
        this.fuel = fuel < 0 ? 0 : fuel > 100 ? 100 : fuel;
        this.speed = speed > gearSpeed[gear] ? gearSpeed[gear] : speed;
        speedPerSecond = 1;
        isOn = fuel >= 1;
    }

    //Private Methods
    private void setupGearSpeed() {
        gearSpeed = new double[7];
        gearSpeed[0] = 0;
        for(int i = 1; i <= 5; i++) {
            gearSpeed[i] = Math.round(maxSpeed / (6 - i));
        }
        gearSpeed[6] = maxSpeed / 4;
    }

    //<get> Methods
    double getSpeed() {
        return speed;
    }

    double getMaxSpeed() {
        return maxSpeed;
    }

    int getGear() {
        return gear;
    }

    double getFuel() {
        return fuel;
    }

    boolean isOn() {
        return isOn;
    }
    
    //<set> Methods
    boolean setMaxSpeed(double newMaxSpeed) {
        if(newMaxSpeed > 1 && newMaxSpeed < 400) {
            maxSpeed = newMaxSpeed;
            speedPerSecond = maxSpeed / 30;
            setupGearSpeed();
            if(isOn) {
                speed = gearSpeed[gear];
            }
            return true;
        }else {
            return false;
        }
    }

    boolean setGear(int newGear) {
        if(!isOn || newGear >= 0 && newGear <= 6) {
            gear = newGear;
            return true;
        } else {
            return false;
        }
    }

    //Methods
    boolean turnOn() {
        if(isOn) return false;
        isOn = true;
        return true;
    }

    boolean turnOff() {
        if(!isOn) return false;
        gear = 0;
        speed = 0;
        isOn = false;
        return true;
    }

    boolean increaseGear() {
        if(!isOn || gear == 5) {
            return false;
        }else {
            gear++;
            return true;
        }
    }

    boolean decreaseGear() {
        if(!isOn || gear == 0) {
            return false;
        }else {
            gear--;
            if(speed > gearSpeed[gear]) {
                speed = gearSpeed[gear];
            }
            return true;
        }
    }

    boolean increaseSpeed(int seconds) {
        if(!isOn || seconds <= 0) return false;
        double newSpeed = speed + seconds * speedPerSecond;
        double oldSpeed = speed;
        if(fuel >= (oldSpeed + newSpeed) / 200) {
            speed = newSpeed > gearSpeed[gear] ? gearSpeed[gear] : newSpeed;
            fuel -= (oldSpeed + newSpeed) / 200; 
        }else {
            return false;
        }
        if(fuel < 1) turnOff();
        return oldSpeed != speed;
    }

    boolean decreaseSpeed(int seconds) {
        if(!isOn || seconds <= 0) return false;
        double newSpeed = speed - seconds * speedPerSecond > 0 ? speed - seconds * speedPerSecond : 0;
        double oldSpeed = speed;
        if(fuel >= (oldSpeed + newSpeed) / 200) {
            speed = newSpeed > gearSpeed[gear] ? gearSpeed[gear] : newSpeed;
            fuel -= (oldSpeed + newSpeed) / 200; 
        }else {
            return false;
        }
        if(fuel < 1) isOn = false;
        return oldSpeed != speed;
    }

    boolean drive(int seconds) {
        if(!isOn || seconds <= 0 || fuel < speed / 100 * seconds) return false;
        fuel -= speed / 100 * seconds;
        if(fuel < 1) isOn = false;
        return true;
    }

    boolean refuel(int amount) {
        if(fuel > 100 || amount <= 0 || isOn()) return false;
        fuel = fuel + amount > 100 ? 100 : fuel + amount;
        return true;
    }
}