//Approach 1 (Brute Force)
class Solution1 {
    public int countPrimes(int n) {
        int res=0,i=2;
        while(i<n){
            if(checkPrime(i)) res++;
            i++;
        }
        return res;
    }
    boolean checkPrime(int n){
        if(n<=1) return false;
        int i=2;
        while(i<=(int)Math.sqrt(n)){
            if(n%i==0) return false;
            i++;
        }
        return true;
    }
}

//Approach 2 (Optimised Solution)
public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}