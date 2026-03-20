class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int res=n;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(checkPalindrome(s.substring(i,j+1))) res++;
            }
        }
        return res;
    }
    private boolean checkPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}