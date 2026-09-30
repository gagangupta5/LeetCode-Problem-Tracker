class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int[] res=new int[n];
        int currGrp=1;
        for(int i=0;i<n;i++){
            char ch=seq.charAt(i);
            if(ch=='(') res[i]=1-currGrp;
            else res[i]=currGrp;
            currGrp^=1;
        }   
        return res;
    }
}
