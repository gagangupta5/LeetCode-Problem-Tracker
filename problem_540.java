class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int l=0,h=n-1,mid=-1;
        if(n==1) return nums[0];
        while(l<h){
            mid=(l+h)/2;
            if((mid%2!=0 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1])) l=mid+1;
            else h=mid;
        }
        return nums[l];
    }
}