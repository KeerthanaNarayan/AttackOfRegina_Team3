/*
=================================================================================================================                                                                                                                 
 ______   ______   ______   __   __   __   ______       ______   ______   __   ______   __   __   __   ______    
/\  == \ /\  ___\ /\  ___\ /\ \ /\ "-.\ \ /\  __ \     /\  __ \ /\  == \ /\ \ /\  ___\ /\ \ /\ "-.\ \ /\  ___\   
\ \  __< \ \  __\ \ \ \__ \\ \ \\ \ \-.  \\ \  __ \    \ \ \/\ \\ \  __< \ \ \\ \ \__ \\ \ \\ \ \-.  \\ \___  \  
 \ \_\ \_\\ \_____\\ \_____\\ \_\\ \_\\"\_\\ \_\ \_\    \ \_____\\ \_\ \_\\ \_\\ \_____\\ \_\\ \_\\"\_\\/\_____\ 
  \/_/ /_/ \/_____/ \/_____/ \/_/ \/_/ \/_/ \/_/\/_/     \/_____/ \/_/ /_/ \/_/ \/_____/ \/_/ \/_/ \/_/ \/_____/ 

=================================================================================================================                                                                                                                 
*/

// Manages the game. When the main method is run, the game runs.


public class PlayGame {
    // Main method to play the game.
    public static void main(String[] args) {

        // Create a variable that keeps track of the game state.
        String GameState = "InProgress";

        // Welcome the player
        System.out.println("Welcome to Regina: Origins");

        // Instantiate the UserInput class
        // Query the user for the grid dimension.
        int gridSize = UserInput.AskGridDimension();
        // Instantiate the GridState class with the gridSize specified by the user.
        GridState CurrentGridState = new GridState(gridSize);
        // Initialise the grid, populating it with chips, donald and reginas.

        while (GameState == "InProgress") {
            // Print the current grid
            CurrentGridState.PrintGrid();

            // ask the player to move
            // Prompt the user to input where to move. Returns either "u", "d", "l" or "r"
            String MoveString = UserInput.AskWhereToMove();

            // update the grid state based on MoveString
            // INCLUDE EDGE CASE FOR PLAYER ON BOUNDS OF BOARD
            CurrentGridState.UpdateGrid(MoveString);

            // evaluate the grid state (to be either Win, lose or In progress)
            GameState =CurrentGridState.FindGameState();

            // if Win, tell the user they have won
            // if lose tell teh user they have lost
            // if neither WIn or Lose, return to the start of the loop

            if (GameState=="Win") {
                System.out.println("YOU WON!");
            }

            else if (GameState=="Lose") {
                System.out.println("YOU LOSE!");
            }

        //}


        }



    }

}

    
