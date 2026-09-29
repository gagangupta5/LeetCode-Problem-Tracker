class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int res=0, curr=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') curr++;
            else if(s.charAt(i)==')'){
                res=Math.max(res, curr);
                curr--;
            }
        }
        return res;
    }
}
