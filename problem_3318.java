class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            Map<Integer,Integer> c=new HashMap<>();
            for(int j=i;j<i+k;j++){
                c.put(nums[j],c.getOrDefault(nums[j],0)+1);
            }
            List<int[]> freq=new ArrayList<>();
            for(Map.Entry<Integer,Integer> e:c.entrySet()){
                freq.add(new int[] {e.getValue(),e.getKey()});
            }

            freq.sort((a,b) -> b[0]!=a[0]?b[0]-a[0]:b[1]-a[1]);
            int xSum=0;
            for(int j=0;j<x && j<freq.size();j++){
                xSum+=freq.get(j)[0]*freq.get(j)[1];
            }
            res[i]=xSum;
        }
        return res;
    }
}