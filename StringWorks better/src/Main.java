import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    private static String[][]text = new String[12][1];

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("data.txt");
        Scanner scan = new Scanner(file);
        int i = 0;

        while(scan.hasNextLine())
        {
            text[i] = scan.nextLine().split(" ");
            System.out.println(text[i].length);
            i++;
        }

        printWordsStartingWith("ø");
        printWordsOfLength(3);
    }

    private static void printWordsOfLength(int l)
    {
        boolean wordIsValid = true;
        for (int i = 0; i < text.length; i++)
        {
            for (String s:text[i])
            {
                if(s.length() == l)
                {
                    for (int j = 0; j <s.length(); j++)
                    {
                        char c = s.charAt(j);
                        if(c == '.' || c == ',')
                        {
                            wordIsValid = false;
                        }
                    }
                    if (wordIsValid)
                    {
                        System.out.println(s);
                    }
                }
            }
        }
    }

    private static void printWordsStartingWith(String pattern)
    {
        for (int i = 0; i < text.length; i++)
        {
            for (String s:text[i])
            {
                if (s.startsWith(pattern) || s.toLowerCase().startsWith(pattern))
                {
                    System.out.println(s);
                }
            }
        }
    }
}
