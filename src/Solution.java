import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3)
    {
        //initiate 3 stacks, each stack contains sums
        Stack<Integer> stack01 = new Stack<>();
        Stack<Integer> stack02 = new Stack<>();
        Stack<Integer> stack03 = new Stack<>();
        int sum01=0,sum02=0,sum03=0;
        //after initiate sums, push sums into stacks, stack contains : 0, 0+h1[0], 1+h1[0] + h1[1], ... , 0+h1[0]+...+h1[h1.size()-2]
        for(int i=h1.size()-1;i>=0;i--)
        {
            stack01.push(sum01);
            sum01+=h1.get(i);
        }
        for(int i=h2.size()-1;i>=0;i--)
        {
            stack02.push(sum02);
            sum02+=h2.get(i);
        }
        for(int i=h3.size()-1;i>=0;i--)
        {
            stack03.push(sum03);
            sum03+=h3.get(i);
        }
        //while 3 sums are not equals each pair
        while(sum01!=sum02 || sum02!=sum03 || sum01!=sum03)
        {
            if(sum01>=sum02 && sum01>=sum03)
            {
                sum01=stack01.pop();
            }else if(sum02>=sum01 && sum02>=sum03)
            {
                sum02=stack02.pop();
            }else
            {
                sum03=stack03.pop();
            }
        }
        return sum01; // 3 sums is equals each pair
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
