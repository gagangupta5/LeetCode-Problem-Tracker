class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            int m=res.size();
            for(int j=0;j<m;j++){
                List<Integer> l=new ArrayList<>(res.get(j));
                l.add(nums[i]);
                if(res.contains(l)) continue;
                res.add(l);
            }
        }
        return res;
    }
}