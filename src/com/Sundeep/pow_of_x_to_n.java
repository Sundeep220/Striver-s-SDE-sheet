package com.Sundeep;

public class pow_of_x_to_n {
    public double myPow(double x, int n) {
        //Using Binary exponentiations
        long newN = n;
        if(newN < 0) newN *= -1;
        double ans = 1.0;
        while(newN > 0){
            if(newN % 2 == 1){
                ans *= x;
                newN--;
            }else{
                x *= x;
                newN /= 2;
            }
        }
        if(n < 0)
            ans = (double)1 / (double)ans;
        return ans;
    }
}
