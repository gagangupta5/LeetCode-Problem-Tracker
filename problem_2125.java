class Solution {
    public int numberOfBeams(String[] bank) {
        int n=bank.length;
        int res=0,x=0;
        for(int i=0;i<n;i++){
            String s=bank[i];
            if(s.indexOf('1')==-1) continue;
            else{
                int c=0;
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j)=='1') c++;
                }
                res+=c*x;
                x=c;
            }
        }
        return res;
    }
}