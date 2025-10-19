class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int x=1;
        for(int i=0;i<n;i++){
            int m=k*x;
            if(m<nums[i]){
                return m;
            }
            else if(nums[i]==m) x++;
        }
        return k*x;
    }
}