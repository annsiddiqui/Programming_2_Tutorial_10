import java.util.*;
import java.io.*;
/*Side note, to read an etire line from a file, text = inFile.nextLine();
Text will read the entire line as a whole string "___ ____ ____"                                                   string  int double
[0], [1], [2], ...
U need to actually split the string, and do that by:
Data = text.split()
Data is actually an array of items. 
Turn array string to integer by:
numMarks = Integer.parseInt(data[1])

 */
public class ExcTut1Start
{
    public static void main() 
    {
        final int MAX = 6;
        String [] data = new String [MAX];;
        int i;
        int numRec = 0;
        int k;
        String id_num = "";
        int num_marks;
        String str_marks;
        double marks;
        double sum;
        double aver;
        int count;
        String fname;

        Scanner read = new Scanner (System.in);
        System.out.print ("Please enter the filename  >  ");
        fname = read.nextLine();

        try{
            Scanner inFile = new Scanner (new File (fname + ".txt"));

            while (inFile.hasNext())
            {
                //Another try catch should be here, to find InputMisMatch bc file is
                //processed here, in the while loop.
                try
                {
                    id_num = inFile.next();
                    num_marks = inFile.nextInt();
                    sum = 0;
                    for (i = 0; i < num_marks; i++)
                    {
                        marks = inFile.nextDouble();
                        sum = sum + marks;
                    }
                    aver = sum / num_marks;

                    System.out.println ("Student " + id_num + " has an average of " + aver); 
                }
                catch (InputMismatchException e)
                {
                    System.out.println("Student" + id_num + " has an ilegal value.");
                }
            }
            //Close the scanner file here technically...
            //AFTER you've done all the processing.
            inFile.close();

            catch (FileNotFoundException e)
            {
            System.out.println("The file" + fname + ".txt does not exist.");            
        }
        //Can do whatever u want after the try catch and itll still process it
        System.out.println("Thank you.");
    }
}
