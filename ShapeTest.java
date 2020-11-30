package Polymorphism;
import java.util.*;

public class ShapeTest{

    // method that creates a new shape and adds it to a Shape array
    public Shape[] create(final int numberShapes) {

        int index = 0;
        final Shape[] shapesArray = new Shape[numberShapes];

        while (index < numberShapes) {
            String shapeName;
            int x, y;
            double r, h;

            final Scanner shapeInput = new Scanner(System.in);
            System.out.printf("Choose your shape: point, circle or cylinder: \n");
            // input requested will be automatically changed to lower case.
            try {
                shapeName = shapeInput.nextLine().toLowerCase();
            } catch (final InputMismatchException e) {
                System.out.println("Something went wrong. Input not accepted. Try inputting a string. \n");
                shapeInput.nextLine();
                break;
            }

            switch (shapeName) {
                case "point":
                    final Scanner pointInput = new Scanner(System.in);

                    System.out.printf("Insert the x and y coordinates: \n");
                    try {
                        x = pointInput.nextInt();
                        pointInput.nextLine();
                        y = pointInput.nextInt();
                    } catch (final InputMismatchException e) {
                        System.out.println("Something went wrong. Input not accepted. Try inputting an integer. \n");
                        pointInput.nextLine();
                        break;
                    }

                    // create new point called point using x and y coordinates inputted
                    final Point point = new Point(x, y);

                    // add new shape to array
                    shapesArray[index] = point;
                    index++;

                    break;

                case "circle":
                    final Scanner circleInput = new Scanner(System.in);

                    System.out.printf("Insert the x and y coordinates and the radius of the circle: \n");
                    // for every case we have a try catch statement that regulates the inputs by the
                    // user and breaks if it is invalid.
                    try {
                        x = circleInput.nextInt();
                        circleInput.nextLine();
                        y = circleInput.nextInt();
                        circleInput.nextLine();
                        r = circleInput.nextInt();
                    } catch (final InputMismatchException e) {
                        System.out.println("Something went wrong. Input not accepted. Try inputting an integer. \n");
                        circleInput.nextLine();
                        break;
                    }
                    // make sure that radius ais positive
                    if (r < 1) {
                        System.out.println("Make sure that the radius is larger than 0. \n");
                        break;
                    }
                    // create new circle
                    final Circle circle = new Circle(x, y, r);

                    // add new shape to array
                    shapesArray[index] = circle;
                    index++;

                    break;

                case "cylinder":
                    final Scanner cylinderInput = new Scanner(System.in);

                    System.out.printf("Insert the x and y coordinates, the radius and the height of the cylinder: \n");
                    try {
                        x = cylinderInput.nextInt();
                        cylinderInput.nextLine();
                        y = cylinderInput.nextInt();
                        cylinderInput.nextLine();
                        r = cylinderInput.nextInt();
                        cylinderInput.nextLine();
                        h = cylinderInput.nextInt();
                    } catch (final InputMismatchException e) {
                        System.out.println("Something went wrong. Input not accepted. Try inputting an integer. \n");
                        cylinderInput.nextLine();
                        break;
                    }
                    // make sure that radius and height are positive
                    if (r < 1 || h < 1) {
                        System.out.println("Make sure that the radius and height are larger than 0. \n");
                        break;
                    }

                    // create new cylinder

                    final Cylinder cylinder = new Cylinder(x, y, r, h);

                    // add new shape to array
                    shapesArray[index] = cylinder;
                    index++;

                    break;

                // default statement in case the user statement doesn't match any of the cases.
                default:
                    System.out.printf("Please insert a valid input! Point, circle or cylinder.\n");
            }

        }

        return shapesArray;

    }

    public void print(final Shape[] sArray, final int numberShapes) {
        // for loop iterates through the number of shapes in a sample array and prints
        // its name, area, volume and characteristics
        for (int i = 0; i < numberShapes; i++) {
            System.out.printf("Name: " + sArray[i].getName() + "\n");
            System.out.printf("Area: " + sArray[i].getArea() + "\n");
            System.out.printf("Volume: " + sArray[i].getVolume() + "\n");
            System.out.printf("Characteristics: " + sArray[i].toString() + "\n\n");
        }
    }

    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);
        Shape[] testArray;
        int n;

        System.out.printf("Please insert the number of shapes you want to create: \n");
        // try and catch block in a while loop. Loops until user inputs valid values.
        while (true) {
            try {
                n = input.nextInt();
            } catch (final InputMismatchException e) {
                System.out.println("Something went wrong. Input not accepted. Try inputting an integer. \n");
                input.nextLine();
                continue;
            }
            if(n<1){
                System.out.println("Please insert a positive number of shapes! \n"); 
                continue;
            }
            break;
        }
        input.nextLine();
        //create a final instance of the shapetest which we will use in order to avoid use of static methods
        final ShapeTest shapemaker = new ShapeTest();
        // create an array of shapes with n elements
        testArray = shapemaker.create(n);
        shapemaker.print(testArray, n);

        input.close();
    }

}