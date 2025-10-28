//Approach 1 Time -> O(nlogn)
class Solution1 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return (nums[n-1]-1)*(nums[n-2]-1);
    }
}


//Approach 2 Time -> O(n)
class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int max=-1,sMax=-1;
        for(int i=0;i<n;i++){
            if(max<nums[i]){
                sMax=max;
                max=nums[i];
            }
            else if(sMax<nums[i]){
                sMax=nums[i];
            }
        }
        return (max-1)*(sMax-1);
    }
}