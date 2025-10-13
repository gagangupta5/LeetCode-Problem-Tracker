class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(n<k) k=k%n;
        int i=0,j=n-k;
        if(n==1) return;
        int[] a=new int[n];
        while(j<n){
            a[i++]=nums[j++];
        }
        for(j=0;j<n-k;j++){
            a[i++]=nums[j];
        }
        for(i=0;i<n;i++){
            nums[i]=a[i];
        }
    }
}