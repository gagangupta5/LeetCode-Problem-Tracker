class Solution {
    public int reverse(int x) {
        int res=0,d=0,n=Math.abs(x);
        while(n!=0){
            d=n%10;
            if(res>(Integer.MAX_VALUE-d)/10) return 0;
            res=res*10+d;
            n/=10;
        }
        return (x<0)?-res:res;
    }
}z