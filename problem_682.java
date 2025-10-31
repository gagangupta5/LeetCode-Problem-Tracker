class Solution {
    public int calPoints(String[] operations) {
        List<Integer> record=new ArrayList<>();
        int n=operations.length;
        for(int i=0;i<n;i++){
            String op=operations[i];
            int m=record.size();
            if(op.equals("+")){
                record.add(record.get(m-1)+record.get(m-2));
            }
            else if(op.equals("D")){
                record.add(record.get(m-1)*2);
            }
            else if(op.equals("C")){
                record.remove(m-1);
            }
            else{
                record.add(Integer.parseInt(op));
            }
        }
        int res=0;
        //sum of all records
        for(int i=0;i<record.size();i++){
            res+=record.get(i);
        }
        return res;
    }
}