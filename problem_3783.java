class Solution {
    public int mirrorDistance(int n) {
        int x=n;
        int rev=0;
        while(x!=0){
            int d=x%10;
            rev=rev*10+d;
            x/=10;
        }
        return Math.abs(rev-n);
    }
}