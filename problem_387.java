class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(s.lastIndexOf(ch)==s.indexOf(ch)) return i;
        }
        return -1;
    }
}