class Solution {
    public int smallestNumber(int n) {
        int res=1;
        if(n==1) return res;
        while(res<n){
            res=res*2+1;
        }
        return res;
    }
}