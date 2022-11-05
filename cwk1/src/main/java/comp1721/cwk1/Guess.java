package comp1721.cwk1;
import java.util.Scanner;

public class Guess 
{
  private int guessNumber;
  private String chosenWord;
  private static final Scanner INPUT = new Scanner(System.in);
  //creation of an empty string which is later to be used for output and concatenation
  private String outputLine = ""; 

  public Guess(int num)
  {
    guessNumber = num;
    /*
    "guessNumber" should be an "int" value in the range 1-6 which is stored in the "guessNumber"
    field. Otherwise, "GameException" will be thrown.
    */
    if (guessNumber < 1 || guessNumber > 6)
    {
      throw new GameException("Invalid!");
    }
  }

  public Guess(int num, String word)
  {
    guessNumber = num;
    //A guess object stores the word chosen by the player, in the "chosenWord" field. 
    chosenWord = word;
    /*
    Validation is done for the same purpose as previous constructor that takes "num" as it's
    only parameter.
    */
    if (guessNumber < 1 || guessNumber > 6)
    {
      throw new GameException("Invalid!");
    }
    else if (word.length() == 5)
    {
      /* 
      The parameter word can take an input of a string in lowercase and will convert into uppercase,
      only if the length of the word is exactly 5-character long so that it can be compared with 
      target.
      */
      chosenWord = word.toUpperCase();
      for (int i = 0; i < chosenWord.length(); i++)
      {
        /*
        Validating whether every chracter in "chosenWord" is a character or not. If not 
        "GameException" will be thrown.
        */
        if (Character.isLetter(chosenWord.charAt(i)))
        {
          continue;
        }
        else
        {
          throw new GameException("Invalid!");
        }
      }
    }
    /*
    If the conditions: (guessNumber < 1 || guessNumber > 6) OR (word.length() == 5) is false,
    "GameException" will be thrown.
    */
    else
    {
      throw new GameException("Invalid!");
    }
  }

  public int getGuessNumber()
  {
    return guessNumber;
  }
  public String getChosenWord()
  {
    return chosenWord;
  }
  public void readFromPlayer()
  {
    /*
    reads a line which is entered by the user and the stores it in the String variable
    "readLine"
    */
    String readLine = INPUT.nextLine(); 
    //"chosenWord" == user's input
    chosenWord = readLine; 
  }

  public String compareWith(String target)
  {
  /*
  _A single character in "chosenWord" is compared with all the other characters in "target"
  repeating the processs with the next character in "chosenWord"

  1.) if the characters are different and occurs at a different location with the character
      in the target word, the background colour is yellow

  2.) if individual characters are the same, the background colour of a character in "chosenWord"
      is green

  3.) if the character is not present in the target word, the back ground colour is white

  _this will keep concatenating "outPutLine" with next individual characters in "chosenWord" with
   their corresponding background colours
  */
    
    //loops through every index of "targetWord" for each index of "chosenWord" first
    for (int chosenWordIndex = 0; chosenWordIndex < target.length(); chosenWordIndex++)
    {
      /*
      By default, it assumes that a character in "chosenWord" is not present in "target",
      thus a boolean variable "doesContain" is declared and initialised "false"

      In later stages, if a character in "chosenWord" is found in "target", "doesContain"
      will be assigned "true"
      */
      boolean doesContain = false; 
      for (int targetWordIndex = 0; targetWordIndex < target.length(); targetWordIndex++)
      {
        if (chosenWord.charAt(chosenWordIndex) == target.charAt(targetWordIndex) && chosenWordIndex != targetWordIndex)
        {
          // 1.)
          outputLine = outputLine + "\033[30;103m " + chosenWord.charAt(chosenWordIndex) + " \033[0m";
          doesContain = true;

          //A new object "buildString" is created from a class "StringBuilder"
          StringBuilder buildString = new StringBuilder(target);

          /*
          Builds a string but first converting "target.charAt(targetWordIndex)" to lowercase,
          where "targetWordIndex" corresponds to index of a string that is to be buit.

          This is to ensure that the program acknowledges that if the program differentiate the 
          first and second "B" in "chosenWord" of "BASBI", where "BASIC" is "targetWord", thus
          the second "B" is highlighted in white background.
          */

          buildString.setCharAt(targetWordIndex, Character.toLowerCase(target.charAt(targetWordIndex)));
          target = buildString.toString();
          break;
        }
        else if (chosenWord.charAt(chosenWordIndex) == target.charAt(targetWordIndex) && chosenWordIndex == targetWordIndex)
        {
          // 2.)
          outputLine = outputLine + "\033[30;102m " + chosenWord.charAt(chosenWordIndex) + " \033[0m";
          doesContain = true;
          //SAME AS ABOVE
          StringBuilder buildString = new StringBuilder(target);
          buildString.setCharAt(targetWordIndex, Character.toLowerCase(target.charAt(targetWordIndex)));
          target = buildString.toString();
          break;
        }
      }
      if (doesContain == false)
      {
        // 3.)
        outputLine = outputLine + "\033[30;107m " + chosenWord.charAt(chosenWordIndex) + " \033[0m";
      }
    }
    return outputLine;
  }
  
  public boolean matches(String target)
  {
    /*
    if "chosenWord" and "target" strings are equal, this method will return "true", else it will
    return "false".
    */
    if (target.equals(chosenWord))
    {
      return true;
    }
    else 
    {
      return false;
    }
  }
}