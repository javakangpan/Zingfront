package demo.controller;


/*
 * 邀请码监测
 */
public class Test2 {
    
    static int charSum = 0;
    static int numSum = 0;
    // a(97) b c d e f g h i(105)            104 - 96 = 8 % 9 = 8
    // 1     2 3 4 5 6 7 8 9
    // j(106)k l m n o p q r                 106 - 96 = 10 % 9 = 1
    // s(115)t u v w x y z(122)              115 - 96 = 19 % 9 = 1  124 - 96 = 18 % 9 = 0
    // A(65)
    
    //ewrfa99342abcedf
    //2*2+3*2+9*2=18-9
    //f+e+b+f+w
    public static String check(String str) {
        if (str.length() < 16) {
            return "error";
        } else {
            for (int i = str.length() - 1; i >= 0; i--) {
                //15 14 13 12 11 10
                // 1  2  3  4
                System.out.println(str.charAt(i));
                //判断数字 
                if (Character.isDigit(str.charAt(i))) {
                    int n = Integer.parseInt(str.charAt(i) + "");
                    //判断是在偶数位置
                    if(i % 2 == 0) {
                        n = (n*2 > 9 ? n*2 - 9 : n*2);
                        numSum += n;
                    }
                }else {//判断是字符
                    //判断是在奇数位置
                    if(i % 2 != 0) {
                        if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                            int m = (str.charAt(i) - 96) % 9;
                            int n = (m == 0 ? 9 : m);
                            charSum += n;
                        }else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                            int m = (str.charAt(i) - 64) % 9;
                            int n = (m == 0 ? 9 : m);
                            charSum += n;
                        } 
                    }
             
                }
            }
        }
        if(10 / (charSum + numSum)  == 0) {
            System.out.println(numSum + "--" + charSum);
            return "ok";
        }
        return "error";

    }
    public static void main(String[] args) {
        //check("ewrfa99342abcedf");
        //System.out.println(check("6050505050505050"));
        System.out.println(check("AiiAAiiAAiiAAiiA"));//AiA
    }
}
