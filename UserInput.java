// Class which prompts the user and returns the user output
// Methods include:
// AskGridDimension, queries the player for an integer n>0 st the grid will be nxn

import java.util.Scanner;
import java.util.Arrays;

public class UserInput {

    // field which holds the "allowed" movement options.
    private static String[] AllowedMovementStringArray = {"u","d","l","r"};
    // private static int[] AllowedGridSizes = {1,2,3,4,5,6,7,8};

    public static int AskGridDimension(){
        Boolean isValidNumber = false;
        while (isValidNumber==false) {

            // instantiate the scanenr class
            Scanner scanner = new Scanner(System.in);
            // Ask the user where to move.
            System.out.println("What is your desired grid size? Enter digit: ");
            // Prompts the user to enter their input via the terminal

            //Error handling for non int value            
            int gridSize = scanner.nextInt();  // Read the user's movement input

            // if the users input is accepted, return that string
            if (gridSize > 0) {
                return gridSize;
            }

            // if the input is not accepted, remind the user of the acceptable input.
            else {
                System.out.print("Invalid user input! Enter a digit! ");
            }

        }
        return 4;
    }


    // prompts the user where to move via the terminal. 
    // User MUST input a character from AllowedMovementStringArray (either "u", "d", "l" or "r").
    public static String AskWhereToMove() {

        // Boolean to keep track of whether the user has inputted an accetable string.
        // No movement has yet been prompted, so set isMovementAccetpable to false.
        boolean isMovementAcceptable = false;

        // while the movement is not acceptable, keep prompting the user for one that is valid!
        while (isMovementAcceptable==false) {

            // instantiate the scanenr class
            Scanner scanner = new Scanner(System.in);
            // Ask the user where to move.
            System.out.println("Where would you like to move?");
            // Prompts the user to enter their input via the terminal
            String MoveString = scanner.next() ;  // Read the user's movement input

            //Checks if the user input is acceptable via the ALlowedMovementStringArray field.
            isMovementAcceptable = ArrayFunctions.CheckIsIn(AllowedMovementStringArray, MoveString);

            // if the users input is accepted, return that string
            if (isMovementAcceptable) {
                return MoveString;
            }

            // if the input is not accepted, remind the user of the acceptable input.
            else {
                System.out.print("Invalid user input! User gave: "+MoveString+". Must be one of: ");
                Arrays.stream(AllowedMovementStringArray).forEach(e -> System.out.print(e + " "));
            }

        }

        return null;
        
    }
}