package bishi;

import java.util.Scanner;

public class Guanglianda2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] list = new int[n];
        for(int i=0;i<m;i++) {
            String[] str1 = in.nextLine().split(" ");
            int a = Integer.parseInt(str1[0]);
            int b = Integer.parseInt(str1[1]);
            int c = Integer.parseInt(str1[2]);
            int count=0;
            for(int j=a;j<=b;j++) {
                if(list[a-1]==0 && count<c) {
                    count++;
                    list[a-1]=1;
                }
            }
        }



    }
}

