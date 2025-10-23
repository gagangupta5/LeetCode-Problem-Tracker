class Solution {
    public int thirdMax(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max=nums[n-1],k=1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]!=max){
                max=nums[i];
                k++;
            }
            if(k==3) return max;
        }
        return nums[n-1];
    }
}