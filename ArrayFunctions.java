import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// General functions in an array.
public class ArrayFunctions {

     // function which takes an element, and checks if it is in an array. Returns true if proposed_element is in StringArray, false otherwise
    public static boolean CheckIsIn (String[] stringArray, String proposed_element) {

        // basically loop through stringArray, and for each element test if proposed_element is equal to it.
        for (String element : stringArray) {
            if (element.equals(proposed_element)) {
                // return true if we find a match
                return true;
            }
        }
        // if we don't find a match, return false
        return false;
    }


    // function which outputs an array of N random integers in a specified range [min,max]
    public static int[] GenerateRandomIntegerArray(int min, int max, int N){
        //unpack the random class
        Random random = new Random();

        // define ana array to hold the random integers
        int[] RandomIntArray = new int[N];

        // populate RandomIntArray with random integers
        for (int i=0; i<N; i++) {
            int randomNumber = random.nextInt(max-min)+min;
            RandomIntArray[i] = randomNumber;
        }
        // return the array
        return RandomIntArray;
    }


    // Function that returns a list of N distinct coordinates
    public static ArrayList<int[]> generateDistinctCoordinates(int N, int gridSize) {
        Set<String> existingCoordinates = new HashSet<>();
        ArrayList<int[]> coordinatesList = new ArrayList<>();

        while (coordinatesList.size() < N) {
            int[] newCoord = ArrayFunctions.GenerateRandomIntegerArray(0, gridSize, 2);
            String coordString = newCoord[0] + "," + newCoord[1];

            if (!existingCoordinates.contains(coordString)) {
                existingCoordinates.add(coordString);
                coordinatesList.add(newCoord);
            }
        }

        return coordinatesList;
        }
}

