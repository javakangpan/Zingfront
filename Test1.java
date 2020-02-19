package demo.controller;


public class Test1 {
    // 10 7 5 4
    //  7 8 6 5  == 1
    //  8 5 7 6  == 2
    //  5 6 8 7  == 3
    //  6 7 5 8  == 4
    //  7 8 6 5  == 5
    
    //统计周期
    private static int count = 0;
    //标识不是第一次进去
    private static boolean flag = false;
    //默认值
    private static int A = 10,B = 7,C = 5,D = 4;
    //第一次进去A的值
    private static int FLAG = 0;
    
    
    //按月计算
    public static void getCircle(int num) {
        
        if(num > 0) {
            //第一次调整优化
           int max = getFirst();
           int a = A,b = B,c = C,d = D;
           getCircle(A,B,C,D,max);
           if (num > 1) {
               int n = num;
                if(num > count) {
                    n = num % count; 
                    //整除的话=0 不计算 直接跟第一次调整一样 一个周期4 整除说明是4的倍数
                    if(n != 0) {
                        getResult(n-1,a,b,c,d,max);
                    }
                }else {  
                    //余数 进入计算 计算次数（余数 - 1）
                    getResult(n-1,a,b,c,d,max);
                }
            }
        }
    }
    
    //第一次调整
    private static int getFirst() {
        int max = getMax(getMax(A,B), getMax(C,D));
        A = A < max ? A + 1 : A -3;
        B = B < max ? B + 1 : B -3;
        C = C < max ? C + 1 : C -3;
        D = D < max ? D + 1 : D -3;
        FLAG = A;
        return getMax(getMax(A,B), getMax(C,D));
    }

    //最大值
    private static int getMax(int a, int b) {
        return a < b ? b : a;
    }
    

    //算出周期
    private static int getCircle(int a, int b, int c, int d, int max) {
        if (flag && a == FLAG) {
            return count;
        }
        if (a == max) {
            A = a -= 3;
            B = b += 1;
            C = c += 1;
            D = d += 1;
            count++;
            flag = true;
            getCircle(a, b, c, d, max);

        } else if (b == max) {
            B = b -= 3;
            A = a += 1;
            C = c += 1;
            D = d += 1;
            count++;
            flag = true;
            getCircle(a, b, c, d, max);
        } else if (c == max) {
            C = c -= 3;
            B = b += 1;
            A = a += 1;
            D = d += 1;
            count++;
            flag = true;
            getCircle(a, b, c, d, max);
        } else if (d == max) {
            D = d -= 3;
            B = b += 1;
            C = c += 1;
            A = a += 1;
            count++;
            flag = true;
            getCircle(a, b, c, d, max);
        }
        return -1;

    }
    
    //得出结果
    public static void getResult(int n,int a,int b,int c,int d,int max) {
        while(n != 0) {
            if (a == max) {
                A = a -= 3;
                B = b += 1;
                C = c += 1;
                D = d += 1;
                System.out.println(A + " " + B + " " + C + " " + D);
                n--;
                getResult(n,a, b, c, d, max);

            } else if (b == max) {
                B = b -= 3;
                A = a += 1;
                C = c += 1;
                D = d += 1;
                System.out.println(A + " " + B + " " + C + " " + D);
                n--;
                getResult(n,a, b, c, d, max);
            } else if (c == max) {
                C = c -= 3;
                B = b += 1;
                A = a += 1;
                D = d += 1;
                System.out.println(A + " " + B + " " + C + " " + D);
                n--;
                getResult(n,a, b, c, d, max);
            } else if (d == max) {
                D = d -= 3;
                B = b += 1;
                C = c += 1;
                A = a += 1;
                System.out.println(A + " " + B + " " + C + " " + D);
                n--;
                getResult(n,a, b, c, d, max);
            }
            break;
        }
    }


    public static void main(String[] args) {
        //10年 120个月
        getCircle(120);
        System.out.println("调整优化后 A:" + A + "   B:" + B + "   C:" + C + "   D:" + D ) ;

    }

}
