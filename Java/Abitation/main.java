import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner;
        List<Flat> flats = new ArrayList<Flat>();
        House house;
        double totalFlatsPrice = 0;

        for(var i = 0; i < 3; i++) {
            scanner = new Scanner(System.in);
            System.out.print("\nFlat " + (i+1) + "\nPrice:\t");
            var price = scanner.nextDouble();
            System.out.print("Size:\t");
            var size = scanner.nextDouble();
            try {
                flats.add(new Flat(price, size));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.close();
                return;
            }
        }

        scanner = new Scanner(System.in);
        System.out.print("\nHouse:\nPrice:\t");
        var price = scanner.nextDouble();
        System.out.print("Size:\t");
        var size = scanner.nextDouble();
        System.out.print("Floors:\t");
        var floors = scanner.nextInt();
        try {
            house = new House(price, size, floors);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            scanner.close();
            return;
        }
        scanner.close();

        for(var i = 0; i < flats.size(); i++) {
            totalFlatsPrice += flats.get(i).getPrice();
            System.out.println(
                "\nFlat " + (i+1) + ":\n" + flats.get(i).toString()
            );
        }

        System.out.println(
            "\nHouse:\n" + house.toString()
        );

        System.out.println(
            "\nTotal pricing of all flats:\t$" + totalFlatsPrice
        );
    }
}