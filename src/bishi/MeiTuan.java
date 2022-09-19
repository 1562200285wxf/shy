package bishi;

import java.util.Scanner;

public class MeiTuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if(a>=11) {
            System.out.println(b+2-a);
        } else {
            if(b<=9) System.out.println(11-a);
            else System.out.println(b+2-a);
        }
    }
}
