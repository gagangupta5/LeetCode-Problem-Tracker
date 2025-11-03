class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=neededTime.length;
        int m=colors.length();
        int res=0;
        for(int i=1;i<n;i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                int ind=i-1;
                while(neededTime[ind]==-1){
                    ind--;
                }
                if(neededTime[i]<neededTime[ind]){
                    res+=neededTime[i];
                    neededTime[i]=-1;
                }
                else{
                    res+=neededTime[ind];
                    neededTime[ind]=-1;
                }
            }
        }
        return res;
    }
}