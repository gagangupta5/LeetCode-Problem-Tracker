class Solution {
    public int reverseBits(int n) {
        String rev="";
        while(n!=0){
            rev+=(char)n%2;
            n/=2;
        }
        while(rev.length()!=32) rev+='0';
        return Integer.parseInt(rev,2);
    }
}