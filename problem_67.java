class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int i=a.length()-1,j=b.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry==1){
            int numA=i>=0?a.charAt(i)-'0':0;
            int numB=j>=0?b.charAt(j)-'0':0;
            int sum=numA+numB+carry;
            int d=sum%2;
            carry=sum/2;
            sb.append(d);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}