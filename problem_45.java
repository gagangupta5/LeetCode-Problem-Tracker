class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int s=0, e=0, res=0;
        while(s<=e && e<nums.length){
            int nextJump=0;
            res++;
            for(int i=s; i<=e; i++){
                nextJump=Math.max(nextJump, i+nums[i]);
                if(nextJump>=nums.length-1) break;
            }
            if(nextJump>=nums.length-1) break;
            s=e+1;
            e=nextJump;
            
        }       
        return res;
    }
}
