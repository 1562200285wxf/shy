//package bishi;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Scanner;
//import java.util.Set;
//
//public class MeiTuan2 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        int n = Integer.parseInt(str);
//        String str1 = in.nextLine();
//        String str2 = in.nextLine();
//        int[] ints = Arrays.stream(str1.split("")).mapToInt(Integer::parseInt).toArray();
//        String[] strings = str2.split("");
//        for(int anInt:ints) {
//            ttt(ints,anInt,strings);
//        }
//        for(Integer integer:map.keySet()) {
//            System.out.println(map.get(integer).size());
//        }
//    }
//
//    public static void ttt(int[] ints,int index, String[] strings) {
//        int init = 0;
//        while(init<ints.length) {
//            if(ints[init]==index) {
//                ttt(ints,init,strings);
//                if(map.containsKey(index)) {
//                    map.get(index).add(string[index]);
//                } else {
//                    Set<String> set = new HashMap<>();
//                    set.add(strings[index]);
//                    map.put(index,set);
//                }
//            }
//        }
//    }
//}
