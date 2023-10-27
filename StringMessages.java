import java.lang.Math;

public class StringMessages {

    // UserInput.java string messages.
    private static String AskGridSizeMessage =  "What is your desired grid size? Enter digit:";
    private static String WhereToMoveMessage = "Where would you like to move?";
    private static String InvalidUserDigitMessage = "Invalid user input! Enter a digit! ";
    private static String[] InvalidUserMoveStringMessage = {"Invalid user input! User gave: ", ". Must be one of: "};

    // PlayGame.java string messages.
    private static String WinMessage = "YOU WON!";
    private static String LoseMessage = "YOU LOSE!";

    // GridState.java string messages.
    private static String OutOfBoundsMessage = "You're at the edge of the board! Moving nowhere.";


    // Print customised messages on starting the game.
    public static void PrintStartMessages() {
        // Welcome the player
        System.out.println("Welcome to Regina: Origins");
        System.out.println("You are Donald, and your task is to find the GOLDEN DOUGHNUT!");
        System.out.println("But it's not gonna be easy kid ...");
        System.out.println("You're ARCH NEMISIS Regina lurks in the darkness.");
        System.out.println("FIND THE DOUGHNUT, EVADE REGINA!");
    }

    /*
    Below are "getters" for all the private fields containing the string messages.
    */
   
    public static String getAskGridSizeMessage () {
        return AskGridSizeMessage;
    }

    public static String getInvalidUserDigitMessage() {
        return InvalidUserDigitMessage;
    }

    public static String getWhereToMoveMessage(){
        return WhereToMoveMessage;
    }

    public static String getInvalidUserMoveStringMessage(String MoveString) {
        return InvalidUserMoveStringMessage[0]+MoveString+InvalidUserMoveStringMessage[1];
    }

    public static String getWinMessage() {
        return WinMessage;
    }

    public static String getLoseMessage(){
        return LoseMessage;
    }

    public static String getOutOfBoundsMessage(){
        return OutOfBoundsMessage;
    }

    public static String getDistanceFromDougnutMessage(double distDouble){
        return "Donald's distance from the doughnut is: " + Math.round(distDouble);
    }
}
