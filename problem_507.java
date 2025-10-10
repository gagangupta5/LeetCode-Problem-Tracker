class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1) return false;
        int div_sum=1,i=2;
        while(i<=(num/2)){
            if(num%i==0) div_sum+=i;
            i++;
        }
        if(div_sum==num) return true;
        return false;
    }
}