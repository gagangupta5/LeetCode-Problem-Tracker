class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase(); //for making all char into lowercase
        s=s.replaceAll("[^a-z0-9]","");  //for removing all character except alphabet and numbers
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        }
        return true;
    }
}