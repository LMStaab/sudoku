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

    public static boolean containsArr(ArrayList<int[]> list, int[] arr) //needs arrays to be 2 ints, will improve for the future
    {
        if(list.isEmpty()) return false;

        for(int[] a : list)
        {
            if((a[0] == arr[0]) && (a[1] == arr[1]))
            {
                return true;
            }
        
        }

        return false;
    }
}
