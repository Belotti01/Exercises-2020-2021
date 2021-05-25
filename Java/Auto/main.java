import java.util.*;
class main {
    static Scanner scn;

    public static void main(String[] args) {
        String input[], inputString = "";
        boolean repeat = true;
        Car car = new Car(200.0, 100.0, 3, 50);

        printHelpMsg();

        while(repeat) {
            //Create Scanner and reset buffer in future iterations
            scn = new Scanner(System.in);
            input = commandInput();
            if(input.length == 0) continue;

            switch(input[0]) {
                //Quit
                case "exit":
                case "stop":
                case "quit":
                    repeat = false;
                    break;

                //Car Status
                case "status":
                case "info":
                case "car":
                case "cs":
                    printStatus(car);
                    break;

                //Help
                case "h":
                case "cmd":
                case "commands":
                case "help":
                    printHelpMsg();
                    break;

                //Turn on/off
                case "power":
                case "turn":
                case "switch":
                case "pw":
                    if(input.length > 1 && input[1].equals("on")) {
                        if(car.turnOn()) {
                            System.out.print("- The car is now turned on.\n> ");
                        }else{
                            System.out.print("- The car is already turned on.\n> ");
                        }
                    }else if(input.length > 1 && input[1].equals("off")) {
                        if(car.turnOff()) {
                            System.out.print("- The car is now turned off.\n> ");
                        }else{
                            System.out.print("- The car is already turned off.\n> ");
                        }
                    }else {
                        System.out.print("- Would you like to switch the car " + (car.isOn() ? "off" : "on") + "?\n> ");
                        if(stringInput().charAt(0) == 'y') {
                            if(car.isOn()) {
                                car.turnOff();
                                System.out.print("- The car is now turned off.\n> ");
                            }else {
                                car.turnOn();
                                System.out.print("- The car is now turned on.\n> ");
                            }
                        }
                    }
                    break;

                //Increase
                case "increase":
                case "inc":
                case "in":   
                    //Increase gear or speed?
                    if(input.length == 1) {
                        System.out.print("- Do you want to increase SPEED or GEAR?\n> ");
                        inputString = stringInput();
                    }

                    //Increase speed for <time> seconds
                    if(inputString.equals("speed") || (input.length > 1 && input[1].equals("speed"))) {
                        int time = -1;
                        if(input.length > 2) {
                            time = parseInt(input[2]);
                        }
                        if(input.length < 3 || time == -1) {
                            //Request <time>
                            System.out.print("- How long do you want to speed up for? (seconds)\n> ");
                            time = intInput();
                        }
                        //Validate <time> input
                        if(time <= 0) {
                            System.out.print("[!] The entered time amount is invalid.\n> ");
                        }else{
                            if(car.increaseSpeed(time)) {
                                System.out.print("- The speed has been increased to " + car.getSpeed() + ".\n> ");
                            }else{
                                System.out.print("- Couldn't increase speed above " + car.getSpeed() + ".\n> ");
                            }
                        }

                    //Increase gear by 1
                    }else if(inputString.equals("gear") || (input.length > 1 && input[1].equals("gear"))){
                        if(car.increaseGear()) {
                            System.out.print("- The gear has been increased to " + car.getGear() + ".\n> ");
                        }else{
                            System.out.print("- Couldn't increase gear above " + car.getGear() + ".\n> ");
                        }
                    }else{
                        System.out.print("[!] Invalid input.\n> ");
                    }
                    break;

                //Decrease
                case "decrease":
                case "decr":
                case "dec":     
                case "dc":
                    //Decrease gear or speed?
                    if(input.length == 1) {
                        System.out.print("- Do you want to decrease SPEED or GEAR?\n> ");
                        inputString = stringInput();
                    }

                    //Decrease speed for <time> seconds
                    if(inputString.equals("speed") || (input.length > 1 && input[1].equals("speed"))) {
                        int time = -1;
                        if(input.length > 2) {
                            time = parseInt(input[2]);
                        }
                        if(input.length < 3 || time == -1) {
                            //Request <time>
                            System.out.print("- How long do you want to slow down for? (seconds)\n> ");
                            time = intInput();
                        }
                        //Validate <time> input
                        if(time <= 0) {
                            System.out.print("[!] The entered time amount is invalid.\n> ");
                        }else{
                            if(car.decreaseSpeed(time)) {
                                System.out.print("- The speed has been decreased to " + car.getSpeed() + ".\n> ");
                            }else{
                                System.out.print("- Couldn't decrease speed below " + car.getSpeed() + ".\n> ");
                            }
                        }

                    //Decrease gear by 1
                    }else if(inputString.equals("gear") || (input.length > 1 && input[1].equals("gear"))){
                        if(car.decreaseGear()) {
                            System.out.print("- The gear has been decreased to " + car.getGear() + ".\n> ");
                        }else{
                            System.out.print("- Couldn't decrease gear below " + car.getGear() + ".\n> ");
                        }
                    }else{
                        System.out.print("[!] Invalid input.\n> ");
                    }
                    break;

                //Refuel
                case "rf":
                case "refuel":
                    if(car.getFuel() > 99) {
                        System.out.print("- The tank is already full.\n> ");
                        break;
                    }

                    int refuel;
                    if(input.length == 1 || parseInt(input[1]) <= 0 || parseInt(input[1]) > 100) {
                        //Request <refuel>
                        System.out.print("- How much fuel percentage do you want to refuel?\n> ");
                        refuel = intInput();
                        //Validate <refuel> input
                        if(refuel <= 0 || refuel > 100) {
                            System.out.print("[!] The entered fuel percentage is invalid.\n> ");
                            break;
                        }
                    }else{
                        refuel = parseInt(input[1]);
                    }
                    //Refuel
                    if(car.refuel(refuel)) {
                        System.out.print("- Successfully refueled the car up to " + car.getFuel() + "%.\n> ");
                    }else {
                        System.out.print("- Can't refuel now, make sure the car is turned off.\n> ");
                    }
                    break;

                //Set Gear
                case "gear":
                case "g":
                    int gear;
                    if(input.length > 1 && parseInt(input[1]) >= 0 && parseInt(input[1]) <= 5) {
                        gear = parseInt(input[1]);
                    }else{
                        //Request <gear>
                        System.out.print("- What gear do you want to set?");
                        gear = intInput();
                    }
                    
                    //Validate <gear> input
                    if(gear >= 0 && gear <= 5) {
                        if(car.getGear() == gear) {
                            System.out.print("- Gear already set to " + gear + ".\n> ");
                        //Change gear
                        } else if(car.setGear(gear)) {
                            System.out.println("- Set gear to " + gear + ".\n> ");
                        }else{
                            System.out.println("- Turn on the car before changing gear.\n> ");
                        }
                    }else {
                        System.out.println("- The entered gear number is invalid.\n> ");
                    }
                    break;
                
                //Drive
                case "dr":
                case "move":
                case "drive":
                    int time;
                    //Get <time> value
                    if(input.length == 1 || parseInt(input[1]) <= 0) {
                        //Request <time>
                        System.out.print("- How long do you want to drive for? (seconds)\n> ");
                        time = intInput();
                    }else {
                        time = parseInt(input[1]);
                        //Validate <time> input
                        if(time <= 0) {
                            System.out.print("[!] The entered time amount is invalid.\n> ");
                            break;
                        }
                    }

                    if(car.drive(time)) {
                        double distance = car.getSpeed() * time / 3600;
                        distance -= distance % 0.01;
                        System.out.println("- You drove for " + distance + "km.\n> ");
                    }else{
                        System.out.println("- Make sure the car is turned on and you have enough fuel.");
                    }
                    break;

                default:
                    System.out.print("[!] Invalid input.\n> ");
                    break;
            }
        }
        scn.close();
    }

    private static String[] commandInput() {
        String input[];
        try {
            input = scn.nextLine().toLowerCase().split(" ");
        }catch(Exception err) {
            return new String[0];
        }
        return input;
    }

    private static int intInput() {
        int input;
        try {
            input = scn.nextInt();
        }catch(Exception err) {
            return -1;
        }
        return input;
    }

    private static String stringInput() {
        String input;
        try {
            input = scn.nextLine().toLowerCase();
        }catch(Exception err) {
            return "";
        }
        return input;
    }

    private static int parseInt(String string) {
        int integer;
        try {
            integer = Integer.parseInt(string);
        }catch(Exception err) {
            return -1;
        }
        return integer;
    }

    private static void printHelpMsg() {
        System.out.print(
            "\n----- HELP/COMMANDS -----" +
            "\nInfo:\t\tHELP\t\tSTATUS" +
            "\n\nCommands:\tPOWER ON/OFF\tINCREASE SPEED [SECONDS]\tDECREASE SPEED [SECONDS]" +
            "\n\t\tINCREASE GEAR\tDECREASE GEAR\t\t\tDRIVE [SECONDS]" +
            "\n\t\tGEAR [GEAR]\n> "
        );
    }

    private static void printStatus(Car car) {
        System.out.print(
        "\n----- CAR STATUS -----" +
        "\nState: " + (car.isOn() ? "ON" : "OFF") +
        "\nFuel: " + Math.round(car.getFuel()) + "%" +
        "\nGear: " + car.getGear() +
        "\nSpeed/MaxSpeed: " + Math.round(car.getSpeed()) + "/" + Math.round(car.getMaxSpeed()) + "km/h\n> "
        );
    }
}