import java.lang.Math;

public class StringMessages {

    // UserInput.java string messages.
    private static String AskGridSizeMessage =  "ENTER THE BATTLEFIELD!\nWhat is your desired BATTLEFIELD size? [Enter digit: ]";
    private static String WhereToMoveMessage = "What's your next move, kid?";
    private static String InvalidUserDigitMessage = "ERROR! Invalid user input. [Enter digit: ]";
    private static String[] InvalidUserMoveStringMessage = {"ERROR! User gave: ", ". Must be one of: "};

    // PlayGame.java string messages.
    private static String WinMessage = "CONGRATULATIONS!\nYou have captured the GOLDEN DOUGHNUT and brought prosperity to Britain!\nHumanity is saved, for now...";
    private static String LoseMessage = "CAPTURED!\nDON-ALD has been caught by THE REGINAS and humanity is doomed forever...";

    // GridState.java string messages.
    private static String OutOfBoundsMessage = "You're at the edge of the BATTLEFIELD! Nowhere to run...";


    // Print customised messages on starting the game.
    public static void PrintStartMessages() {
        // Welcome the player - INTRO
        System.out.println("========================================================\n\n\t\tR E G I N A : O R I G I N S\n\n========================================================");
        System.out.println("The year is 2076. You are DON-ALD C-60.");
        System.out.println("You must capture the GOLDEN DOUGHNUT to save humanity...");
        System.out.println("...but it's not gonna be easy, kid!");
        System.out.println("The sinister REGINAS seek the DOUGHNUT for themselves!");
        System.out.println("FIND THE DOUGHNUT. EVADE THE REGINAS. SAVE HUMANITY.");
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
        return "DON-ALD's distance from the DOUGHNUT is: " + Math.round(distDouble);
    }
}
