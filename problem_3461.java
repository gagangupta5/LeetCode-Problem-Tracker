//Approach 1 
class Solution1 {
    public boolean hasSameDigits(String s) {
        int n=s.length();
        while(n!=2){
            int i=0;
            String newS="";
            while(i<n-1){
                int x=((int)s.charAt(i)+(int)s.charAt(i+1))%10;
                newS+=String.valueOf(x);
                i++;
            }
            n=newS.length();
            s=newS;
        }
        if(s.charAt(0)==s.charAt(1)) return true;
        return false;
    }
}