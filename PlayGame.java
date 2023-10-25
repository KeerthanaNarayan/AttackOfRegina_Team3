// Manages the game (passes variable between the different classes)

public class PlayGame {

    //String to keep track of the game state
    private String GameState;


    // Constructor for PlayGame class. Instantiates the game in an inProgress state.
    public PlayGame() {
        // at construction, we assume the game state is InProgress
        this.GameState = "InProgress";
    }


    // Main method for play game.
    public static void main(String[] args) {


        // GAME CODE CALLING OTHER CLASSES 

        
        // EXAMPLE OF RUNNING ANOTHER CLASS (UserInput.AskWhereToMove)
        String MoveString = UserInput.AskWhereToMove();


        //TEST IF ABOVE FUNCTION ACTUALLY RA
        System.out.println(MoveString);
    }

    }
