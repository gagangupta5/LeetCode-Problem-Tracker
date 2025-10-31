class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int res=0;
        for(int i=0;i<n-1;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(nums[j]-nums[i]==k){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}