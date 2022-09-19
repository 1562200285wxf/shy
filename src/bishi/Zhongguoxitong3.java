package bishi;

import java.util.Arrays;
import java.util.Scanner;

//input
//int [] nums = {1,2,5,4,3,10};
//int m = 2;
//int n = 4;

//output
//1 2 3 4 5 10
public class Zhongguoxitong3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] a = in.nextLine().split("=");
        String[] e = in.nextLine().split(" ");
        String[] x = in.nextLine().split(" ");

        String[] b = a[1].split("\\{");
        String[] c = b[1].split("}");
        String[] d = c[0].split(",");
        int[] arr = Arrays.asList(d).stream().mapToInt(Integer::parseInt).toArray();

        String[] f = e[3].split(";");
        int m = Integer.parseInt(f[0]);

        String[] y = x[3].split(";");
        int n = Integer.parseInt(y[0]);

        int[] copyArr = Arrays.copyOfRange(arr, m, n+1);
        Arrays.sort(copyArr);
        for(int i=0;i<m;i++) System.out.println(arr[i]);
        for(int i=0;i<n-m+1;i++) System.out.println(copyArr[i]);
        for(int i=n+1;i<arr.length;i++) System.out.println(arr[i]);
    }
}
