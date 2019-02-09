package org.brough.pretium.Util;

public class Util {

    public static double choose(double n, double k){
        double mn;
        double mx;
        double value;

        if(k < n - k){
            mn = k;
            mx = n - k;
        } else {
            mn = n - k;
            mx = k;
        }

        if(mn < 0){
            value = 0.0;
        } else if (mn == 0) {
            value = 1.0;
        } else {
            value = (double)(mx + 1);
            for (int i = 2; i <= mn; i++) {
                value = (value * (double)(mx + i))/ (double)i;
            }
        }
        return value;
    }

    public static double dbinom(double x, double n, double p){
        double val;

        if(x < 0.0){
            val = 0.0;
        } else if(x <= n){
            val = Util.choose(n, x) * Math.pow(1.0 - p, n - x);
        } else {
            val = 1.0;
        }
        return val;
    }
}