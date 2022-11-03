import java.util.Scanner;

public class CheckPassword 
{
    
    public static boolean longEnough(String password)
    {
        if (password.length() > 11)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static boolean atLeastTwoDigits(String password)
    {
        boolean check_digit = false;
        char character;
        int digit_count = 0;
        for (int index = 0; index < password.length(); index++)
        {
            character = password.charAt(index);
            if (Character.isDigit(character))
            {
                check_digit = true;
                digit_count++;
            }
            if (digit_count >= 2)
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        String password = " ";
        if (args.length == 0)
        {
            System.err.println("Usage: java CheckPassword <password>");
            System.exit(1);
        }
        else
        {
            password = args[0];
        }
        if (atLeastTwoDigits(password) == true && longEnough(password) == true)
        {
            System.out.println("Password is valid");
            System.exit(0);
        }
        else
        {
            System.out.println("Password is not valid");
            System.exit(1);
        }
    }
}
