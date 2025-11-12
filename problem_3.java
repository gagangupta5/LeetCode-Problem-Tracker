class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int res=0;
        if(n<=1) return n;
        for(int i=0;i<n-1;i++){
            String s1=String.valueOf(s.charAt(i));
            for(int j=i+1;j<n;j++){
                if(s1.indexOf(s.charAt(j))!=-1) break;
                else s1+=s.charAt(j);
            }
            res=Math.max(res,s1.length());
        }
        return res;
    }
}