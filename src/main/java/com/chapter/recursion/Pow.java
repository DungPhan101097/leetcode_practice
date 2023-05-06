/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chapter.recursion;

/**
 *
 * @author dungptm2
 */
public class Pow {
    //-100.0 < x < 100.0
    //-231 <= n <= 231-1
    //x = 2.00000, n = 10
    //1024.00000
    // 10 = 1010
    public double myPow(double x, int n) {
       double pow = 1;
       
       int absN = Math.abs(n);
       while (absN != 0) {
           if ((absN & 1) != 0) {
               // last bit is old
               pow *= x;
           }
           
           x*=x;
           absN >>>= 1;
       }
       
       return n > 0 ? pow : 1/pow;
    }
    
    public double fastpow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double ans = fastpow(x, n / 2);
        if (n % 2 == 0) {
            return ans * ans;
        } else {
            return ans * ans * x;
        }
    }

    public double myPow2(double x, int n) {
        // Your code goes here
        long N = n;
        if (n < 0) {
            N = -n;
            x = 1 / x;
        }
        return fastpow(x, N);

    }
    

    public static void main(String[] args) {

        double ret = new Pow().myPow(0.001f, 2147483647);

        System.out.println("ret = " + ret);

        System.exit(0);
    }
}
