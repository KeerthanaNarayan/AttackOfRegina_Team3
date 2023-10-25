// General functions in an array.
public class ArrayFunctions {

     // function which takes an element, and checks if it is in an array. Returns true if proposed_element is in StringArray, false otherwise
    public static boolean CheckIsIn (String[] stringArray, String proposed_element) {
        for (String element : stringArray) {
            if (element.equals(proposed_element)) {
                return true;
            }
        }
        return false;
    }
}
