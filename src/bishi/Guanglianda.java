package bishi;

import java.util.Arrays;
import java.util.Scanner;

public class Guanglianda {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(tt(str1, str2, Integer.valueOf(str)));
        
    }

    public static int tt(String str1, String str2, int len) {
        int[] s1 = toInt(str1);
        int[] s2 = toInt(str2);
        int count = 0;
        for(int index=len-1;index>0;index--) {
            count = count + judge(s1[index-1],s1[index],s2);
        }
        return count;
    }

    public static int[] toInt(String s) {
        String[] sstr = s.split(" ");
        int[] array = Arrays.asList(sstr).stream().mapToInt(Integer::parseInt).toArray();
        return array;
    }

    public static int judge(int targetPre, int target, int[] ints) {
        int result = 1;
        int targetPreIndex = 0;
        int targetIndex = 0;
        for(int index=0;index<ints.length;index++) {
            if(ints[index]==targetPre) targetPreIndex = index;
            if(ints[index]==target) targetIndex = index;
        }
        if(targetPreIndex<targetIndex) result = 0;
        return result;
    }
}

