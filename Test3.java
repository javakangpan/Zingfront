 package demo.controller;


//游戏币组合 n个游戏币 总面值m
 public class Test3 {
     
     private static int ONE = 1;
     private static int TWO = 2;
     private static int FIVE = 5;
     private static int TEN = 10;
     
     //1*x + 2*y + 5*a + 10*b = m
     // x + y + a + b = n
     // 1 < x(y,a,b) n
     public static int getResultl(int n,int m) {
         int hasOne,hasTwo,hasFive,hasTen,count = 0;
         for(int i = 0; i < n;i++) {
             hasOne = i;
             for(int j = 0; j < n - i;j++) {
                 hasTwo = j;
                 for(int k = 0; k < n - i - j;k++) {
                     hasFive = k;
                     for(int l = 0; l < n - i - j - k; l++) {
                         hasTen = l;
                         if(m == (hasOne*ONE + hasTwo*TWO + hasFive*FIVE + hasTen*TEN)) {
                             System.out.println("ONE:"+hasOne+" TWO:"+hasTwo+" FIVE:"+hasFive+" TEN:"+hasTen);
                             count++;
                         }
                     }
                 }
             }
         }
         return count;
     }
     
     
     public static void main(String[] args) {
         
         System.out.println(getResultl(10,20));//9
    }

}
