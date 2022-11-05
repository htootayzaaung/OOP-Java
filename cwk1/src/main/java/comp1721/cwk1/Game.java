package comp1721.cwk1;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;  
import java.time.format.DateTimeFormatter; 
import java.nio.file.Paths;
import java.time.Duration;
import java.io.IOException;     
import java.util.List;
import java.io.FileWriter;

public class Game 
{
  private int gameNumber;
  private String target;

  //Creation of two empty lists of "String" type
  private List<String> wordList = new ArrayList<String>();
  private List<String> outputLineList = new ArrayList<String>();  

  public Game(String filename) throws IOException
  {
    Scanner wordsTxtFile = new Scanner(Paths.get(filename));
    
    //Every line in a txt file will be loaded and stored as a list of strings called "words"
    while (wordsTxtFile.hasNextLine())
    {
      //Individual line in a txt file will be assigned to a string variable called "singleLine"
      String singleLine = wordsTxtFile.nextLine();

      //String temporarily stored in the variable "singleLine" will be appended to the "wordList"
      wordList.add(singleLine);
    }
    //a txt file will be closed once it detects that it ran out of strings
    wordsTxtFile.close();

    //Setting the "startingDate" as "2021-06-19" by default
    LocalDate startingDate = LocalDate.parse("2021-06-19", DateTimeFormatter.ISO_LOCAL_DATE);

    //"endingDate" corresponds to today's date
    LocalDate endingDate = LocalDate.now();

    //"timeDiff" is the time difference between "startingDate" and "endingDate"
    Duration timeDiff = Duration.between(startingDate.atStartOfDay(), endingDate.atStartOfDay());

    //Obtaining tifference in time (number of days) in a variable "timeDiffLong" of "long" data-type
    long timeDiffLong = timeDiff.toDays();

    //Casting/Converting "timeDiffLong" of what was a "long" data-type to "int" data-type
    gameNumber = (int) timeDiffLong;

    //"target" will be assigned with a string from a list "wordList" using "gameNumber" as an index
    target = wordList.get(gameNumber);
  }
  
  public Game(int num, String filename) throws IOException
  {
    Scanner wordsTxtFile = new Scanner(Paths.get(filename));
    //Every line in a txt file will be loaded and stored as a list of strings called "words"
    while (wordsTxtFile.hasNextLine())
    {
      //Individual line in a txt file will be assigned to a string variable called "singleLine"
      String singleLine = wordsTxtFile.nextLine();
      wordList.add(singleLine);
    }
    //a txt file will be closed once it detects that it ran out of strings
    wordsTxtFile.close();

    //"gameNumber" will be assigned to "num" which is taken by a method as a parameter
    gameNumber = num;

    //"target" will be assigned with a string from a list "wordList" using "gameNumber" as an index
    target = wordList.get(gameNumber);
  }

  public void play()
  {
    int i = 1;
    //Creating an object "guessNum" from class "Guess"
    Guess guessNum = new Guess (i);
    int trialNum = 0;

    System.out.printf("WORDLE " + gameNumber + "\n");

    for(i = 1; i < 7; i++)
    {
      //Prints "Enter guess (1/6):", "Enter guess (2/6):", "Enter guess (3/6):", and so on
      System.out.printf("Enter guess" + "(" + i + "/6): ");

      //Guesses the num for the 1st, 2nd, 3rd, ..., 6th time
      guessNum.readFromPlayer();

      //gets "chosenWord"
      String getGuessNum = guessNum.getChosenWord();

      //Once "chosenWord" has been retrieved it will be converted to uppercase
      String getGuessNumUpperCase = getGuessNum.toUpperCase();

      //"guessNum" becomes a new object of a class "Guess"
      guessNum = new Guess(i, getGuessNum);

      //"guessNum" compares with "target"
      String guessNumberCompareWithTarget = guessNum.compareWith(target);
      
      //appending every "outputLine" into a "outputLineList" list 
      outputLineList.add(guessNumberCompareWithTarget);

      //printing the string returned by "compareWith(string target)" method
      System.out.println(guessNumberCompareWithTarget);
      
      //keep tracks of number of trials
      trialNum++;

      if (getGuessNumUpperCase.matches(target)) 
      {
        /*
        _the loop will terminate and print out the either one of the statements below
         once "chosenWord" matches "target".

        _"trialNum" determines which statement will be printed
        */
        break;
      }
    }
    if (trialNum == 1)
    {
      System.out.println("Superb - Got it in one!");
    }
    else if (trialNum >= 2 && trialNum <= 5)
    {
      System.out.println("Well done!");
    }
    else if (trialNum == 6)
    {
      System.out.println("That was a close call!");
    }
  }

  public void save(String filename)throws IOException
  {
    FileWriter saveFile = new FileWriter(filename);
    //for every element in a list "outputLineList"
    for (int i = 0; i < outputLineList.size(); i++) 
    {
      /*
      gets every element in "outputLineList" and writes it in "saveFile" with
      a newline after each element
      */
      saveFile.write(outputLineList.get(i) + "\n");
    }
    saveFile.close();
  }
}

