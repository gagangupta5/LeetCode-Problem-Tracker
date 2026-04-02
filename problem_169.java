class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int res=0,c=1,x=n/2;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1])
                c++;
            else{
                if(c>=x)
                    res=nums[i-1];
                c=1;
            }
        }
        if(c>x)
            res=nums[n-1];
        return res;
    }
}