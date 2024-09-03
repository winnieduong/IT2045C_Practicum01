import java.util.Scanner;

public class SafeInput
{
    // Existing methods...

    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0); // until we have some characters

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y"))
            {
                gotAVal = true;
                retVal = true;
            }
            else if (response.equalsIgnoreCase("N"))
            {
                gotAVal = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must answer [Y/N]! " + response );
            }
        } while (!gotAVal);

        return retVal;
    }

    // New convenience methods that use System.in Scanner
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getNonZeroLenString(String prompt) {
        return getNonZeroLenString(SCANNER, prompt);
    }

    public static int getInt(String prompt) {
        return getInt(SCANNER, prompt);
    }

    public static boolean getYNConfirm(String prompt) {
        return getYNConfirm(SCANNER, prompt);
    }
}
