class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int s=0,res=-1;
        for(int i=0;i<n;i++){
            s+=nums[i];
        }
        int s1=0;
        for(int i=0;i<n;i++){
            s-=nums[i];
            if(s==s1){
                res=i;
                break;
            }
            s1+=nums[i];
        }
        return res;
    }
}