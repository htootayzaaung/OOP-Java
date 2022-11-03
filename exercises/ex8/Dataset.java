import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Dataset
{
    private List<Double> data = new ArrayList<Double>();

    public Dataset(String filename) throws IOException
    {
        Scanner wordsTxtFile = new Scanner(Paths.get(filename));
        while (wordsTxtFile.hasNextDouble())
        {
            Double singleLine = wordsTxtFile.nextDouble();
            data.add(singleLine);
        }
        wordsTxtFile.close();
    }
    public int size()
    {
        return data.size();
    }

    public double meanValue()
    {
        double sum = 0;
        if (data.size() == 0){
            throw new ArithmeticException ("Invalid!");
        }
        else
        {
            for (int i = 0; i < data.size(); i++)
            {
                sum += data.get(i);
            }
            double mean = sum / data.size();
            return mean;
        }
    }
}