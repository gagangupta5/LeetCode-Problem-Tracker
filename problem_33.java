//Approach 1 (using linear search)
class Solution1 {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int res=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                res=i;
                break;
            }
        }
        return res;
    }
}


//Approach 2 (using divide and conquer)
class Solution {
    public int search(int[] nums, int target) {
        return helper(nums,target,0,nums.length-1);
    }
    private int helper(int[] nums, int t, int si, int ei){
        if(si>ei) return -1;
        int mid=si+(ei-si)/2;
        if(nums[mid]==t) return mid;
        if(nums[si]<=nums[mid]){
            if(nums[si]<=t && t<=nums[mid]) return helper(nums,t,si,mid-1);
            else return helper(nums,t,mid+1,ei);
        }
        else{
            if(nums[mid]<=t && t<=nums[ei]) return helper(nums,t,mid+1,ei);
            else return helper(nums,t,si,mid-1);
        }
    }
}