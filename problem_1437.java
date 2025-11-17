class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int lastind=-100000000;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                if(i-lastind-1<k) return false;
                lastind=i;
            }
        }   
        return true;
    }
}