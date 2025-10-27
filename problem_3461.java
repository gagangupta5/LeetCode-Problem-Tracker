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


//Approach 2
class Solution {
    public boolean hasSameDigits(String s) {
        int n=s.length();
        char[] sArr=s.toCharArray();
        for(int i=1;i<n-1;i++){
            for(int j=0;j<n-i;j++){
                int x=sArr[j]-'0';
                int y=sArr[j+1]-'0';
                sArr[j]=(char)((x+y)%10+'0');
            }
        }
        return sArr[0]==sArr[1];
    }
}