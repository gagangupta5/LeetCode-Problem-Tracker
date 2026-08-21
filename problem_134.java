class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int total=0, curr=0, idx=0;
        for(int i=0;i<n;i++){
            total+=gas[i]-cost[i];
            curr+=gas[i]-cost[i];
            if(curr<0){
                curr=0;
                idx=i+1;
            }
        }
        if(total<0) return -1;
        return idx;
    }
}
