// Solution1: It shows TLE because Time Complexity is O(2^N)
class Solution1 {
    int res=Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        solve(nums, 0, 1);
        return res;
    }
    private void solve(int[] nums, int i, int currProd){
        if(i==nums.length) return;
        res=Math.max(currProd*nums[i], res);
        solve(nums, i+1, currProd*nums[i]);
        solve(nums, i+1, 1);
    }
}


// Solution2: Optimized Solution Time Complexity: O(N)
class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int maxProd=nums[0];
        int minProd=nums[0];
        int res=nums[0];
        for(int i=1; i<n; i++){
            int currProd=nums[i];
            if(currProd<0){
                int temp=maxProd;
                maxProd=minProd;
                minProd=temp;
            }
            maxProd=Math.max(currProd, maxProd*currProd);
            minProd=Math.min(currProd, minProd*currProd);
            res=Math.max(res, maxProd);
        }
        return res;
    }
}
