class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int d=n/3;
        List<Integer> res=new ArrayList<>();
        Arrays.sort(nums);
        int c=1;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]) c++;
            else {
                if(c>d) res.add(nums[i-1]);
                c=1;
            }
        }
        if(c>d) res.add(nums[n-1]);
        return res;
    }
}