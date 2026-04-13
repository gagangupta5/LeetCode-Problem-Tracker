class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n=nums.length;
        int i=0,res=Integer.MAX_VALUE;
        while(i<n){
            if(nums[i]==target) res=Math.min(res,Math.abs(i-start));
            i++;
        }
        return res;
    }
}