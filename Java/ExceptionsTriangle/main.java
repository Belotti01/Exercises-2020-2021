import java.util.*;

class main {

    public static void main(String args[]) {
        boolean success = false;
        Scanner scn;

        while(!success) {
            System.out.println("\n- Pick an exercise:\n\t|1| isOfAge\n\t|2| trianglePerimeter");
            try {
                scn = new Scanner(System.in);
                int pick = scn.nextInt();
                switch(pick) {
                    case 1:
                        isOfAgeExercise();
                        break;
                    case 2:
                        trianglePerimeterExercise();
                        break;
                    default:
                        throw new Exception();
                }
                success = true;
                scn.close();
            }catch(Exception e) {
                System.out.println("Please enter a valid exercise number");
            }
        }
    }

    static void trianglePerimeterExercise() {
        Scanner scn;
        double[] sides = new double[3];

        System.out.print("Enter the triangle's sides: \n- ");
        for(int i = 0; i < sides.length; i++) {
            try {
                scn = new Scanner(System.in);
                System.out.print("\n- Side " + (i+1) + ": ");
                sides[i] = scn.nextDouble();
                if(sides[i] <= 0) throw new Exception();
            }catch(Exception e) {
                System.out.println("Invalid Input; enter a valid number.");
                i--;
            }
        }

        try {
            System.out.println("- Perimeter: " + trianglePerimeter(sides));
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static double trianglePerimeter(double[] sides) throws Exception{
        if(sides.length != 3) throw new Exception("Shape is not a triangle");
        Arrays.sort(sides);
        if(sides[0] + sides[1] < sides[2]) throw new Exception("Longest side longer than the sum of the other sides");
        
        return sides[0] + sides[1] + sides[2];
    }

    static void isOfAgeExercise() {
        Scanner scn;
        boolean success = false;

        System.out.print("Enter your age: ");
        while(!success) {
            scn = new Scanner(System.in);
            try {
                System.out.println("The user is " + (isOfAge(scn.nextLine()) ? "underage." : "of age."));
                success = true;
                scn.close();
            }catch(Exception e) {
                if(e instanceof UnrealAgeException) {
                    System.out.print("Please enter a realistic age: ");
                }else {
                    System.out.print("Invalid Input; please enter a valid age: ");
                }
            }
        }
    }

    static boolean isOfAge(String age) throws Exception {
        int ageInt = Integer.parseInt(age);
        if(ageInt > 150 || ageInt < 1) throw new UnrealAgeException("Unrealistic Age");
        return ageInt > 17;
    }

}