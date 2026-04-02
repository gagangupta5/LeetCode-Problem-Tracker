class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int res=nums[0],sum=nums[0]; 
        for(int i=1;i<n;i++){
            sum=Math.max(nums[i],nums[i]+sum);
            res=Math.max(res,sum);
        }
        return res;
    }
}