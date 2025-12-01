class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long l=0,r=0;
        for(int i=0;i<batteries.length;i++){
            r+=batteries[i];
        }
        r/=n;
        while(l<r){
            long mid=(l+r+1)/2;
            long total=0;
            for(int i=0;i<batteries.length;i++){
                total+=Math.min(batteries[i],mid);
            }
            if(total>=mid*n) l=mid;
            else r=mid-1;
        }
        return l;
    }
}