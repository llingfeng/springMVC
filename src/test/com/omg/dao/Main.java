package com.omg.dao;

/**
 * Created by admin on 2016/10/27.
 */
public class Main {

    public static void main(String[] args) {
//        String str1 = "helloWorld";
//        String str2 = new String("helloWorld");
//        String str3 = "hello" + "World";
//        String demo1 = "hello";
//        String demo2 = "World";
//        String demo3 = demo1 + demo2;
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        System.out.println(str1 == demo3);
//
//        System.out.println("递归:" + f(9));
//        System.out.print(jieCeng(8));
//        test(5);
//        StringBuilder result = new StringBuilder();
//        decimalToBinary(131,result);
//        System.out.println(result);
//        System.out.println(decimalToBinary(131));
        System.out.println(add(5));
    }

    /**
     * 1+2+3+
     * @param num
     * @return
     */
    public static int add(int num){
        if(num == 1){
            return 1;
        }
        return num+add(num-1);
    }

    /**
     * 阶层（递归）
     * @param k
     * @return
     */
    public static int jieCeng(int k){
        if(k==1){
            return 1;
        }
        return k*jieCeng(k-1);
    }

    /**
     * 十进制转二进制(递归)
     * @param num
     */
    public static void decimalToBinary(int num,StringBuilder result) {
        if (num == 0) { // 当num=0时，循环结束
            return;
        } else {
            decimalToBinary(num / 2,result); // 调用递归方法
            result.append(num%2);
        }
    }

    /**
     * 十进制转二进制（while循环）
     * @param num
     * @return
     */
    public static String decimalToBinary(int num){
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            sb.append(num%2);
            num = num/2;
        }
        return sb.reverse().toString();
    }
    /**
     * Fibonacci数列(递归实现)
     *
     * @param i
     * @return
     */
    public static int f(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        return f(i - 1) + f(i - 2);
    }

    /**
     * Fibonacci数列(循环实现)
     *
     * @param k
     * @return
     */
    public static int f2(int k) {
        if (k == 1 && k == 2) {
            return 1;
        }
        int t1 = 1;
        int t2 = 1;
        int t = 0;
        for (int i = 0; i < k - 2; i++) {
            t = t1 + t2;
            t1 = t2;
            t2 = t;
        }
        return t1+t2;
    }

}
