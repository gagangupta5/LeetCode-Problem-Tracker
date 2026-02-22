class Solution {
    public int binaryGap(int n) {
        String s="";
        int res=0;
        while(n!=0){
            s=(char)n%2+s;
            n/=2;
        }
        int j=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(j==-1) j=i;
                else{
                    res=Math.max(res,i-j);
                    j=i;
                }
            }
        }
        return res;
    }
}