class Solution {
    Map<Integer,Integer> hm=new HashMap<>();
    int res=Integer.MAX_VALUE;
    public int numSquares(int n) {
        return solve(n);
    }
    private int solve(int n){
        if(n==0) return 0;
        if(hm.containsKey(n)) return hm.get(n);
        int i=1;
        while((i*i)<=n){
            res=Math.min(res,1+solve(n-(i*i)));
            i++;
            hm.put(n,res);
        }
        return res;
    }
}