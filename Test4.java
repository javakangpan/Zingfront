 package demo.controller;

import java.util.ArrayList;
import java.util.List;

//34 * 86 = 43 * 68 
 public class Test4 {
     
     private static int swap(int n) {
         return n % 10 * 10 + n / 10;
     }
     
     private static Integer[] getResult(int n, int m) {
        if(n * m == (swap(n) * swap(m))) {
            return new Integer[] {n,m};
        }
        return null;
     }
     
     public static List<Integer[]> getResult() {
         List<Integer[]> list = new ArrayList<Integer[]>();
         for(int i = 10; i < 99 ; i++) {
             for(int j = i + 1; j < 100; j++) {
                 if(getResult(i,j) != null) {
                     list.add(getResult(i,j));
                 }
             }
         }
         return list;
     }
     
     public static void main(String[] args) {
         
         getResult().forEach(c ->{
                 System.out.println(c[0] + " " + c[1]);
         });
    }
//     11 22
//     11 33
//     11 44
//     11 55
//     11 66
//     11 77
//     11 88
//     11 99
//     12 21
//     12 42
//     12 63
//     12 84
//     13 31
//     13 62
//     13 93
//     14 41
//     14 82
//     15 51
//     16 61
//     17 71
//     18 81
//     19 91
//     21 24
//     21 36
//     21 48
//     22 33
//     22 44
//     22 55
//     22 66
//     22 77
//     22 88
//     22 99
//     23 32
//     23 64
//     23 96
//     24 42
//     24 63
//     24 84
//     25 52
//     26 31
//     26 62
//     26 93
//     27 72
//     28 41
//     28 82
//     29 92
//     31 39
//     32 46
//     32 69
//     33 44
//     33 55
//     33 66
//     33 77
//     33 88
//     33 99
//     34 43
//     34 86
//     35 53
//     36 42
//     36 63
//     36 84
//     37 73
//     38 83
//     39 62
//     39 93
//     42 48
//     43 68
//     44 55
//     44 66
//     44 77
//     44 88
//     44 99
//     45 54
//     46 64
//     46 96
//     47 74
//     48 63
//     48 84
//     49 94
//     55 66
//     55 77
//     55 88
//     55 99
//     56 65
//     57 75
//     58 85
//     59 95
//     64 69
//     66 77
//     66 88
//     66 99
//     67 76
//     68 86
//     69 96
//     77 88
//     77 99
//     78 87
//     79 97
//     88 99
//     89 98

     
     
     
     

}
