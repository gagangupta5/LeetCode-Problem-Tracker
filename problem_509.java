//Iterative Approach
class Solution {
    public int fib(int n) {
        int prev=0,curr=1,sum=0,last=0;
        for(int i=0;i<=n;i++){
            last=prev;
            sum=prev+curr;
            prev=curr;
            curr=sum;
        }
        return last;
    }
}

//Recursive Approach
class Solution1 {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1)+fib(n-2);
    }
}