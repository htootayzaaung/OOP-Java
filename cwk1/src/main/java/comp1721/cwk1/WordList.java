package comp1721.cwk1;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class WordList 
{
  private List<String> words = new ArrayList<String>();

  public WordList(String filename) throws IOException
  {
    Scanner wordsTxtFile = new Scanner(Paths.get(filename));
    //Every line in a txt file will be loaded and stored as a list of strings called "words"
    while (wordsTxtFile.hasNextLine())
    {
      //Individual line in a txt file will be assigned to a string variable called "singleLine"
      String singleLine = wordsTxtFile.nextLine();
      words.add(singleLine);
    }
    //a txt file will be closed once it detects that it ran out of strings
    wordsTxtFile.close(); 
  }

  public int size()
  {
    return words.size();
  }

  public String getWord(int n)
  {
    /*
    "n" will allow user to retrieve a single word from all the words in a list "words" between 
    "n = 0" and "n = words.size() - 1"
    */
    if (n >= 0 && n <= (words.size() - 1)) 
    {
      return words.get(n); 
    } 
    else
    {
      //will throw a "GameException" if "n" is out of index
      throw new GameException("Invalid");
    }
  }
}
