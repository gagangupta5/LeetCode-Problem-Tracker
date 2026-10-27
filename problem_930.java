// Solution1 : Using prefix sum TC: O(N^2) SC; O(N)
class Solution1 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (preSum[i] == goal) {
                res++;
            }
            int diff = preSum[i] - goal;
            for (int j = 0; j < i; j++) {
                if (preSum[j] == diff) {
                    res++;
                }
            }
        }
        return res;
    }
}


// Solution2 : Using hashmap TC: O(N) SC: O(N)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
