import java.util.*;

public class main {

    static Scanner scn;
    public static void main(String args[]) {
        boolean repeat = true;
        String[] input;
        double value;
        boolean isPercentage;

        //Input product values
        System.out.print("- Input the product's name:\n> ");
        String name = stringInput();
        System.out.print("- Input the product's brand:\n> ");
        String brand = stringInput();
        System.out.print("- Input the product's price:\n> ");
        int price = intInput();

        //Create product
        Product product = new Product(name, brand, price);
        while(repeat) {
            input = commandInput();
            if(input.length == 0) continue;

            switch(input[0]) {
                case "quit":
                case "exit":
                    repeat = false;
                    break;
                
                case "inc":
                case "increment":
                    if(input.length > 1) {
                        value = Double.parseDouble(input[1]);
                        isPercentage = input[1].charAt(input[1].length() - 1) == '%';
                    }else{
                        //Input <value>
                        System.out.print("- Enter the increment value (price or percentage).\n> ");
                        String valueInput;
                        valueInput = stringInput();
                        isPercentage = valueInput.charAt(valueInput.length() - 1) == '%';
                        value = Double.parseDouble(valueInput);
                    }

                    //Validate <value>
                    if(value <= 0) {
                        System.out.print("- Invalid input.\n> ");
                        break;
                    }else {
                        if(isPercentage) product.incrementPricePercent((int)Math.round(value));
                        else product.incrementPrice(value);
                        System.out.print("- The price has been raised to " + product.getPrice() + ".\n> ");
                    }
                    break;
                
                case "dec":
                case "decrement":
                    if(input.length > 1) {
                        value = Double.parseDouble(input[1]);
                        isPercentage = input[1].charAt(input[1].length() - 1) == '%';
                    }else{
                        //Input <value>
                        System.out.print("- Enter the decrement value (price or percentage).\n> ");
                        String valueInput;
                        valueInput = stringInput();
                        isPercentage = valueInput.charAt(valueInput.length() - 1) == '%';
                        value = Double.parseDouble(valueInput);
                    }

                    //Validate <value>
                    if(value <= 0) {
                        System.out.print("- Invalid input.\n> ");
                        break;
                    }else {
                        if(isPercentage) product.decrementPricePercent((int)Math.round(value));
                        else product.decrementPrice(value);
                        System.out.print("- The price has been reduced to " + product.getPrice() + ".\n> ");
                    }
                    break;

                case "rename":
                case "name":
                case "rn":
                    String newName = "";
                    if(input.length > 1) {
                        for(int i = 1; i < input.length; i++) {
                            newName += input[i] + " ";
                        }
                    }else {
                        System.out.print("- Enter the new product name.\n> ");
                        newName = stringInput();
                    }
                    product.setName(newName.trim());
                    System.out.print("- Product name set to \"" + product.getName() + "\".\n> ");
                    break;

                case "rebrand":
                case "brand":
                case "rb":
                    String newBrand = "";
                    if(input.length > 1) {
                        for(int i = 1; i < input.length; i++) {
                            newBrand += input[i] + " ";
                        }
                    }else {
                        System.out.print("- Enter the new brand name.\n> ");
                        newBrand = stringInput();
                    }
                    product.setBrand(newBrand.trim());
                    System.out.print("- Product brand set to \"" + product.getBrand() + "\".\n> ");
                    break;
                
                default:
                    System.out.print("[!] Invalid Input");
                    break;
            }
        }
    }

    private static String stringInput() {
        scn = new Scanner(System.in);
        String input;
        try {
            input = scn.nextLine().toLowerCase();
        }catch(Exception e) {
            return "";
        }
        return input;
    }

    private static int intInput() {
        scn = new Scanner(System.in);
        int input;
        try {
            input = scn.nextInt();
        }catch(Exception e) {
            return -1;
        }
        return input;
    }
    
    private static String[] commandInput() {
        scn = new Scanner(System.in);
        String input[];
        try {
            input = scn.nextLine().toLowerCase().split(" ");
        }catch(Exception e) {
            return new String[0];
        }
        return input;
    }
}
