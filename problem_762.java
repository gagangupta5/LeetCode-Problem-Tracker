class Solution {
    public int countPrimeSetBits(int left, int right) {
        int res=0;
        while(left<=right){
            String s="";
            s=Integer.toBinaryString(left);
            int c=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1') c++;
            }
            if(checkPrime(c)) res++;
            left++;
        }
        return res;
    }

    private boolean checkPrime(int n){
        if(n<=1) return false;
        int i=2;
        while(i<=Math.sqrt(n)){
            if(n%i==0) return false;
            i++;
        }
        return true;
    }
}