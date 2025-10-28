class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int res=0;
        int n=nums.length;
        while(k!=0){
            Arrays.sort(nums);
            nums[0]=0-nums[0];
            k--;
        }
        for(int i=0;i<n;i++){
            res+=nums[i];
        }
        return res;
    }
}