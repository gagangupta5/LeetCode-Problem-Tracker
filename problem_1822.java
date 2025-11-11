//Approach 1 Time -> O(nlogn)
class Solution1 {
    public int arraySign(int[] nums) {
        Arrays.sort(nums);
        int negCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) return 0;
            else if(nums[i]<0) negCount++;
            else break;
        }
        if(negCount%2==0) return 1;
        return -1;
    }
}


//Approach 2 (Optimised) Time -> O(n)
class Solution {
    public int arraySign(int[] nums) {
        int n=nums.length;
        int res=1;
        for(int i=0;i<n;i++){
            if(nums[i]==0) return 0;
            else if(nums[i]<0){
                res*=-1;
            }
        }
        return res;
    }
}