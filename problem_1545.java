class Solution {
    public char findKthBit(int n, int k) {
        if(n==1) return '0';
        else{
            int length=(int)(Math.pow(2,n))-1;
            int mid=(length/2)+1;
            if(mid==k) return '1';
            else if(k<mid) return findKthBit(n-1,k);
            else return findKthBit(n-1,length-k+1)=='0'?'1':'0';
        }
    }
}