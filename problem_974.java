class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        int preSum=0, res=0;
        for(int i=0;i<n;i++){
            preSum+=nums[i];
            while(preSum<0) preSum+=k;
            int rem=preSum%k;
            if(map.containsKey(rem)){
                res+=map.get(rem);
                map.put(rem, map.get(rem)+1);
            }
            else{
                map.put(rem, 1);
            }
        }   
        return res;
    }
}
