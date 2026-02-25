class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> m=new HashMap<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int bits=Integer.bitCount(arr[i]);
            if(m.get(bits)==null) m.put(bits, new ArrayList<>());
            m.get(bits).add(arr[i]);
        }
        int i=0;
        for(Map.Entry<Integer, List<Integer>> entry: m.entrySet()){
            for(Integer n: entry.getValue()) arr[i++]=n;
        }
        return arr;
    }
}