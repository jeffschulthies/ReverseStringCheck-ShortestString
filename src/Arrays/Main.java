package Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jeff Schulthies
 * .
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        menu();
    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1: Reverse Check");
        System.out.println("Enter 2: Shortest Strings");
        int input = in.nextInt();
        switch(input) {
            case 1: reverseCheckMenu();
                    break;
            case 2: shortestStringMenu();
                    break;
        }
    }

    public static void reverseCheckMenu() {
        Scanner in = new Scanner(System.in);
        String a = "";
        String b = "";
        System.out.println("Enter the first String");
        a = in.nextLine();
        System.out.println("Enter the first String");
        b = in.nextLine();
        System.out.println(ArrayII.arrayReverseCheck(a, b));
    }

    public static void shortestStringMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("How many Strings are being entered: ");
        int phraseNumber = in.nextInt();
        ArrayList<String> strings = new ArrayList<String>();

        for(int i = 0; i <= phraseNumber; i++) {
            String phrase = in.nextLine();
            strings.add(phrase);
            System.out.println("Enter a phrase: ");
        }
        for(int i = 0; i < strings.size(); i++) {
            System.out.print(ArrayII.shortestString(strings.get(i)) + " ");
        }
    }

    @Test
    public void testArrayReverseCheck() {

        Words google1 = new Words("google");
        Words google2 = new Words("GOOGLE");
        Words google3 = new Words("g o o g l e");
        Words google4 = new Words("G O O G L E");

        Words elgoog = new Words("elgoog");

        Assert.assertEquals(ArrayII.arrayReverseCheck(google1.getWord(), elgoog.getWord()), 1);
        Assert.assertEquals(ArrayII.arrayReverseCheck(google2.getWord(), elgoog.getWord()), 1);
        Assert.assertEquals(ArrayII.arrayReverseCheck(google3.getWord(), elgoog.getWord()), 1);
        Assert.assertEquals(ArrayII.arrayReverseCheck(google4.getWord(), elgoog.getWord()), 1);

    }

    @Test
    public void shortestString() {
        Words phrase1 = new Words("Other entries include");
        Words phrase2 = new Words("a historic district");
        Words phrase3 = new Words("in Charlottesville Virginia");
        Words phrase4 = new Words("cutflower greenhouse complex");
        Words equalLength = new Words("four five");
        Words sentence = new Words("Other entries include a historic district in Charlottesville Virginia cutflower greenhouse complex");
    }
}
