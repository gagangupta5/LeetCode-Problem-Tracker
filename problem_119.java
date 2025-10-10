class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        if(rowIndex==0) return res.get(0);
        for(int i=1;i<=rowIndex;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res.get(rowIndex);
    }
}