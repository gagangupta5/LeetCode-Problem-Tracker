//Approach 1 Time -> O(nlogn) and Space -> O(1)
class Solution1 {
    public int repeatedNTimes(int[] nums) {
       Arrays.sort(nums);
       int n=nums.length;
       int i=1;
       for(i=1;i<n;i++){
            if(nums[i]==nums[i-1]) break;
       }
       return nums[i];
    }
}

//Approach 2 Time -> O(n) and Space -> O(n/2)
class Solution 
{
    public int repeatedNTimes(int[] nums) 
    {
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums)
        {
            if(!set.add(n))
            {
                return n;
            }
        }
        return -1;
    }
}
        
