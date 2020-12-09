package JavaCore;

import java.util.Scanner;


/*Su dung nap chong toan tu va de no tu dong chuyen doi kieu du lieu*/
public class Solution
{
    public static void main(String[] args)
    {
        OverloadMethod overload=new OverloadMethod();
        int a=5,b=6;
        System.out.println(overload.add(a,b)); // o day, b tuy la kieu int nhung dua vao no se tu dong chuyen sang kieu long duoc (tu dong chuyen kieu nhung kieu moi phai to hon kieu cu)
    }
}
class OverloadMethod
{
    int add(int a, long b)
    {
        return a + (int)b;
    }
    int add(long a,long b)
    {
        return (int)a+(int)b+100;
    }
}
