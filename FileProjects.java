import java.io.*;
import java.util.Scanner;

public class FileProjects
{
    //this method counts and prints the number of words, lines, and characters in the File f.
    public static void wordCount(File f) throws FileNotFoundException
    {
        //initialize variables
        Scanner console = new Scanner(f);
        int totalwords = 0;
        int totalchars = 0;
        int totallines = 0;

        //go through file until the file ends
        while(console.hasNextLine())
        {
            //read one line of the file, add to totallines
            String templine = console.nextLine();
            totallines++;

            //use another scanner to scan each line
            Scanner console2 = new Scanner(templine);

            //while the line in console2 has not finished
            while(console2.hasNext())
            {
                //read one word (String) from the line, add to totalwords and totalchars
                String x = console2.next();
                totalwords++;
                totalchars += x.length();
            }

            //close scanner
            console2.close();
        }
        //print results
        System.out.println("The file has " + totalwords + " words, " + totalchars + " characters, and " + totallines + " lines.");

        //close scanner
        console.close();
    }

    //this method simulates a Mad Libs game using the File f, which contains formatted markers that will be filled in. 
    //The output will be sent to the file out.txt.
    public static void madLibs(File f) throws FileNotFoundException
    {
        //create a new Scanner variable
        Scanner console = new Scanner(f);
        PrintStream outf = new PrintStream("out.txt"); //OUTPUT HERE!!!!

        //go through file until the file ends
        while(console.hasNextLine())
        {
            //read one line from the file
            String templine = console.nextLine();

            //use another scanner to scan each line
            Scanner console2 = new Scanner(templine);

            //while the line in console2 has not finished
            while(console2.hasNext())
            {
                //read one word (String) from the line
                String tempstr = console2.next();

                //if the word is a regular word, don't ask for input
                if(!(tempstr.charAt(0) == '<' && tempstr.charAt(tempstr.length() - 1) == '>'))
                {
                    //print regular word to output file
                    outf.print(tempstr + " "); 
                }
                //if the word is intended to be replaced, ask for user input
                else
                {
                    //use another scanner to scan user input
                    Scanner console3 = new Scanner(System.in);
                    System.out.print("Please enter an: " + tempstr.substring(1, tempstr.length() - 1));
                    String response = console3.next();

                    //print user response to output file
                    outf.print(response + " ");

                    //close scanner
                    console3.close();
                }
            }
            //close scanner
            console2.close();
        }
        
        //close scanner and output
        console.close();
        outf.close();
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        File samplefile = new File("sample.txt");
        wordCount(samplefile);
        File samplefile2 = new File("madlibs.txt");
        madLibs(samplefile2);
    } 
}