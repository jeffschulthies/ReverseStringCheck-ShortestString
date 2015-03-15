package Arrays;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;

/**
 * Created by Jeff Schulthies
 */
/* Design and implement algorithms that compare two strings and check if they are
reversed. For instance, if the two strings are google and elgoog, then the method
returns 1. If the two strings are “data”, “ata” then the method returns 0. The algorithm
should ignore white spaces, lower/upper cases. */

public class ArrayII {

    @Test
    public void testIndexWhitespace() {
        ArrayList<Integer> whitespace = indexWhitespace("This should be");
        int test = whitespace.get(0);
        Assert.assertEquals(test, 0, "Should return 0");
        test = whitespace.get(1);
        Assert.assertEquals(test, 4, "Should return 4");
        test = whitespace.get(2);
        Assert.assertEquals(test, 11, "Should return 4");
    }

    @Test
    public void testShortestStringIndex() {
        ArrayList<Integer> whitespace = indexWhitespace("This should be");
        int[] indexes = shortestStringIndex(whitespace);
        Assert.assertEquals(indexes[0], 11, "Should return 11");
        Assert.assertEquals(indexes[1], 13, "Should return 13");
    }

    @Test
    public void testShortestString() {
        String test = "This should be red";
        String test2 = "broo two yes dead dedd";
        String test3 = "hippo talks regul";
        Assert.assertEquals(shortestString(test), "be");
        Assert.assertEquals(shortestString(test2), "two");
        Assert.assertEquals(shortestString(test3), "hippo");


    }
    public static int arrayReverseCheck(String a, String b) {
        //ADD IT HERE
        a = a.toUpperCase();
        b = b.toUpperCase();
        a = a.replaceAll("\\s", "");
        b = b.replaceAll("\\s", "");

        //Compares Lengths
        if (a.length() != b.length()) {
            return 0;
        }

        //Changes strings into Character Arrays
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int size = aChar.length - 1;

        //Comparison
        for (int i = 0; i < size; i++) {
            if (aChar[i] != bChar[size - i]) {
                return 0;
            }
        }

        return 1;
    }

    //One sentence
    public static String shortestString(String a) {
        int[] stringIndexes = shortestStringIndex(indexWhitespace(a));
        String shortestString = a.substring(stringIndexes[0], stringIndexes[1] + 1);
        //Removes whitespace;
        shortestString = shortestString.replaceAll("\\s", "");
        return shortestString;
    }

    public static ArrayList<Integer> indexWhitespace(String a) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        int curIndex = 0;
        int prevIndex = 0;
        //adds 0 to the start
        indexes.add(0);
        while (true) {
            curIndex = a.indexOf(' ', prevIndex + 1);
            if (curIndex != -1) {
                indexes.add(curIndex);
                prevIndex = curIndex;
            } else {
                break;
            }
        }
        //Adds end length
        indexes.add(a.length() - 1);
        return indexes;
    }

    public static int[] shortestStringIndex(ArrayList<Integer> indexes) {
        int size = indexes.size() - 1;
        int min = 1000000;
        int[] wordIndex = new int[2];
        for (int i = size; i >= 0; i--) {
            //Not necessary to calculate final value.
            if (i == 1) {
                //Added one to fix the subtraction at the starting index
                if (min >= indexes.get(i) + 1) {
                    wordIndex[0] = 0;
                    wordIndex[1] = indexes.get(i);
                    return wordIndex;
                } else {
                    break;
                }
            } else if(i == size) {
                int difference = (indexes.get(i) - indexes.get(i - 1) + 1);
                if (difference <= min) {
                    min = difference;
                    //First letter
                    wordIndex[0] = indexes.get(i - 1);
                    //Last letter
                    wordIndex[1] = indexes.get(i);
                }
            } else {
                //Finds the smallest index.
                int difference = (indexes.get(i) - indexes.get(i - 1));
                if (difference <= min) {
                    min = difference;
                    //First letter
                    wordIndex[0] = indexes.get(i - 1);
                    //Last letter
                    wordIndex[1] = indexes.get(i);
                }
            }
        }
        return wordIndex;
    }
}


