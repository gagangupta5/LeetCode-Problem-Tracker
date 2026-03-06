class Solution {
    public boolean checkOnesSegment(String s) {
        int n=s.length();
        boolean res=false;
        int i=0;
        while(i<n && s.charAt(i)=='1') i++;
        while(i<n && s.charAt(i)=='0') i++;
        return i==n;
    }
}