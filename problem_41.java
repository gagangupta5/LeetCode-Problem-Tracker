class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(nums[0]>1) return 1;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]) continue;
            if(nums[i]+1<=0 && nums[i+1]>1) return 1;
            if(nums[i]+1!=nums[i+1] && nums[i]+1>0){
                return nums[i]+1;
            }
        }
        if(nums[n-1]>0) return nums[n-1]+1;
        return 1;
    }
}