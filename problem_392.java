class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        int j=0,c=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            while(j<m){
                if(t.charAt(j)==ch){
                    c++;
                    j++;
                    break;
                }
                j++;
            }
        }
        if(c==n) return true;
        return false;
    }
}