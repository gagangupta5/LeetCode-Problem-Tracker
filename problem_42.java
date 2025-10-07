class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n<=2) return 0;
        int lmax[]=new int[n];
        int rmax[]=new int[n];
        int res=0;
        lmax[0]=height[0];
        rmax[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            if(height[i]>lmax[i-1]) lmax[i]=height[i];
            else lmax[i]=lmax[i-1];
        }
        for(int i=n-2;i>=0;i--){
            if(height[i]>rmax[i+1]) rmax[i]=height[i];
            else rmax[i]=rmax[i+1];
        }
        for(int i=0;i<n;i++){
            int m=Math.min(lmax[i],rmax[i]);
            int twater=m-height[i];
            if(twater>0) res+=twater; 
        }
        return res;
    }
}