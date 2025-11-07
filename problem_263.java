//Approach 1 (Brute Force) shows TLE
class Solution1 {
    public boolean isUgly(int n) {
        if(n<1) return false;
        if(n==1) return true;
        for(int i=2;i<=n;i++){
            if(n%i==0 && (i!=2 && i!=3 && i!=5)){
                if(checkPrime(i)) return false;
            }
        }
        return true;
    }
    private boolean checkPrime(int n){
        for(int i=2;i<=n/2;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}


//Approach 2 (Optimised)
class Solution {
    public boolean isUgly(int n) {
        if(n<=0) return false;
        while(n%5==0) n/=5;
        while(n%3==0) n/=3;
        while(n%2==0) n/=2;
        if(n==1) return true;
        return false;
    }
}