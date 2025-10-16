//Approach 1 Time Complexity -> O(nlogn) and Space -> O(1)
class Solution1 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(nums[0]>1) return 1;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]) continue;
            if(nums[i]+1<=0 && nums[i+1]>1) return 1;
            if(nums[i]+1!=nums[i+1] && nums[i]+1>0){
                return nums[i]+1;
            }
        }
        if(nums[n-1]>0) return nums[n-1]+1;
        return 1;
    }
}

//Approach 2 Time Complexity -> O(n) and Space -> O(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
         int n = nums.length;

        // Step 1: Place numbers in correct positions
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // swap nums[i] with nums[nums[i]-1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}