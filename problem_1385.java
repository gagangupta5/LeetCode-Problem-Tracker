class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n=arr1.length;
        int m=arr2.length;
        int res=0;
        for(int i=0;i<n;i++){
            int flag=0;
            for(int j=0;j<m;j++){
                int diff=Math.abs(arr1[i]-arr2[j]);
                if(diff<=d){
                    flag=1;
                    break;
                }
            }
            if(flag==0) res++;
        }
        return res;
    }
}