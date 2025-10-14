class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> fm=new HashMap<>();
        int res=0;
        for(int n:nums){
            if(fm.containsKey(n)){
                fm.put(n,fm.get(n)+1);
            }
            else{
                fm.put(n,1);
            }
        }
        int maxfreq=Collections.max(fm.values());
        for(Map.Entry<Integer,Integer> e: fm.entrySet()){
            if(e.getValue()==maxfreq) res+=maxfreq;
        }
        return res;
    }
}