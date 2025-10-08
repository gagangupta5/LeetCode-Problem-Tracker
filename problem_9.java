class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        int temp=x,rev=0,d;
        while(temp!=0)
        {
            d=temp%10;
            rev=rev*10+d;
            temp=temp/10;
        }
        if(rev==x)
        {
            return true;
        }
        return false;
    }
}