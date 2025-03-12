package help;
import java.util.*;

public class Helper 
{
    public static void println(String text)
    {
        System.out.println(text);
    }

    public static void println(String text, String color)
    {
        System.out.println(color + text + "\u001B[0m");
    }

    public static void print(String text)
    {
        System.out.print(text);
    }

    public static void print(String text, String color)
    {
        System.out.print(color + text + "\u001B[0m");
    }

    public static void clearScreen() // clears the terminal
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean containsArr(ArrayList<int[]> list, int[] arr) 
    {
        if(list.isEmpty()){return false;} // returns false if arraylist is empty as no arrays are contained

        for(int[] a : list)
        {
            if(arr.length == a.length) // allows arraylist of arrays with different lengths to be checked as well
            {
                boolean containsAll = true; // temporary boolean for only one array at a time
                for(int i = 0; i < arr.length; i++){if(a[i] != arr[i]){containsAll = false;}}
                if(containsAll){return true;} // if that one array is the same, then it returns true, otherwise nothing happens which makes the loop iterate again
            }
        }
        return false; // if all arrays are checked and nothing is the same, then false is returned
    }
}
