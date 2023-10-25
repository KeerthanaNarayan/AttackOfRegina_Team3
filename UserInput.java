// Class which prompts the user and returns the user output
// Methods include:
// AskGridDimension, queries the player for an integer n>0 st the grid will be nxn
// WhereToMove, queries the player where it wants to move (up down left or right), if player presses up arrow, WhereMove = "up" and so on

import java.util.Scanner;
import java.util.Arrays;

public class UserInput {

    // field which holds the "allowed" movement options.
    private static String[] AllowedMovementStringArray = {"u","d","l","r"};


    // TEST FUNCTION TO RUN IN PlayGame.java
    // prompts the user where to move via the terminal. Has input validation to make sure user inputs. u, d, l or r.
    public static String AskWhereToMove() {

        // Boolean to keep track of whether the user has inputted an accetable string.
        // No movement has yet been prompted, so set isMovementAccetpable to false.
        boolean isMovementAcceptable = false;

        // while the movement is not acceptable, keep prompting the user!
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

            // else, remind the user of the acceptable inputs.
            else {
                System.out.print("Invalid user input! User gave: "+MoveString+". Must be one of: ");
                Arrays.stream(AllowedMovementStringArray).forEach(e -> System.out.print(e + " "));
            }

        }

        return null;
        
    }
}