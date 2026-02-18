class Solution {
    public boolean hasAlternatingBits(int n) {
        String b="";
        while(n!=0){
            b=(char)(n%2)+b;
            n/=2;
        }
        for(int i=1;i<b.length();i++){
            if(b.charAt(i)==b.charAt(i-1)) return false;
        }
        return true;
    }
}