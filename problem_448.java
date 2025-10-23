class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        boolean[] f=new boolean[n+1];
        for(int num:nums) f[num]=true;
        for(int i=1;i<n+1;i++){
            if(f[i]==false) res.add(i);
        }
        return res;
    }
}