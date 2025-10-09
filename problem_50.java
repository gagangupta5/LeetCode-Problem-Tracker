//APproach 1
class Solution1 {
    public double myPow(double x, int n) {
        double res=1.0;
        if(n<0){
            x=1/x;
            n=-n;
        }
        while(n!=0){
            if(n%2!=0){
                res*=x;
            }
            x*=x;
            n/=2;
        }
        return res;
        
    }
}


//Approach 2
class Solution {
    public double myPow(double x, int n) {
        double res=1.0;
        if(n==0) return res;
        long y=Math.abs((long)n);  //I convert this into long because for Integer.MIN_VALUE (i.e. -2³¹ = -2147483648) abs method can fail and value remains negative 
        while(y>0){
            if((y & 1)!=0) res*=x;
            x*=x;
            y=y>>1;
        }
        if(n<0) return 1/res;
        return res;
    }
}