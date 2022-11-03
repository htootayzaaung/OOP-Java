import java.util.Scanner;
import java.util.*;
public class MeanValue 
{
  public static double meanValue(double[] data) 
  {
      double total = 0;
      double mean_value = 0;
      double meandiv = data.length;

      for (int i = 0; i < data.length; i++)
      {
          total += data[i] ;
      }
      mean_value = total / meandiv;
      return mean_value;
  }

  public static void main(String[] args) 
  { 
    double [] data = new double[args.length];
    if (args.length == 0)
    {
        System.err.println("Usage: java MeanValue <values...>");
        System.exit(1);
    }
    else
    {
        for(int i=0; i<args.length; i++)
        {
            data [i] = Double.parseDouble(args[i]);
        }
    }
    System.out.printf("Mean value = %.3f\n",meanValue(data));
  }
}