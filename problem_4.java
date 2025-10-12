class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        int[] res=new int[n+m];
        int i=0,j=0,k=0;
        double med=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                res[k]=nums1[i];
                i++;
            }
            else{
                res[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<n){
            res[k]=nums1[i];
            i++;
            k++;
        }
        while(j<m){
            res[k]=nums2[j];
            j++;
            k++;
        }
        if((m+n)%2==0){
            int x=(0+(m+n-1))/2;
            int y=x+1;
            med=(float)(res[x]+res[y])/2;
        }
        else{
            int x=(0+(m+n-1))/2;
            med=res[x];
        }
        return med;
    }
}