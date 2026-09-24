class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(digitSum(nums[i])==i) return i;
        }
        return -1;
    }
    private int digitSum(int n){
        int res=0;
        while(n!=0){
            res+=n%10;
            n/=10;
        }
        return res;
    }
}
