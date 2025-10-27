class Solution {
    public String convert(String s, int numRows) {
        int n=s.length();
        String res="";
        if(numRows==1) return s;
        int j=0;
        for(int i=0;i<numRows;i++){
            j=i;
            if(i==0 || i==numRows-1){
                while(j<n){
                    res+=String.valueOf(s.charAt(j));
                    j+=2*(numRows-1);
                }
            }
            else{
                int x=1;
                while(j<n){
                    res+=String.valueOf(s.charAt(j));
                    if(x%2==0) j+=2*i;
                    else j+=2*(numRows-i-1);
                    x++;

                }
            }
        }
        return res;
    }
}