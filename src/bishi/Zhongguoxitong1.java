package bishi;
import java.util.Scanner;

//一个n位的正整数，0<n<10，该正整数每一位的n次方之和等于该正整数。要求：输入n，输出所有符合条件的正整数
//input
//n = 3
//output
//153
//370
//371
//407

public class Zhongguoxitong1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] str=sc.nextLine().split(" ");
        int num = Integer.parseInt(str[2]);
        int max = (int)Math.pow(10,num);
        int init = num>1?max/10:0;
        int[] a = new int[1000];
        int p;
        for(int i=init;i<max;i++)
        {
            p=am(i,a);
            int sum=0;
            for(int j=0;j<p;j++)
                sum=sum+(int)Math.pow(a[j],p);
            if(sum==i) System.out.println(i);
        }
    }
    public static int am(int n,int a[])
    {
        int p=0;
        int[] lp = new int[1000];
        for(int i=0;;i++)
        {
            a[i]=n%10;
            n=n/10;
            lp[i]=n;
            p++;
            if(lp[i]==0)
                break;
        }
        return p;
    }
}
