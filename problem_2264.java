class Solution {
    public String largestGoodInteger(String num) {
        int n=num.length();
        String res="";
        int maxNum=0;
        for(int i=1;i<n-1;i++){
            if(num.charAt(i)==num.charAt(i-1) && num.charAt(i)==num.charAt(i+1)){
                String s=num.substring(i-1,i+2);
                int x=Integer.parseInt(s);
                if(x>=maxNum){
                    maxNum=x;
                    res=s;
                }
            }
        }
        return res;
    }
}