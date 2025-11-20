class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int c=0,res=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                c++;
            }
            else{
                if(c>res){
                    res=c;
                }
                c=0;
            }
        }
        if(c>res){
            return c;
        }
        return res;
    }
}