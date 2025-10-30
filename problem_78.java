class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            int m=res.size();
            for(int j=0;j<m;j++){
                List<Integer> l=new ArrayList<>(res.get(j));
                l.add(nums[i]);
                res.add(l);
            }
        }
        return res;
    }
}