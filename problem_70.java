// Solution1: Iterative Approach
class Solution1 {
    public int climbStairs(int n) {
        if(n<4)
            return n;
        int curr=0,prev1=3,prev2=2;
        for(int i=4;i<=n;i++){
            curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
}


// Solution2: Recursive Approach
class Solution {
    Map<Integer, Integer> map=new HashMap<>();
    public int climbStairs(int n) {
        if(n<0) return 0;
        if(n==0) return 1;
        if(map.containsKey(n)) return map.get(n);
        map.put(n, climbStairs(n-1)+climbStairs(n-2));
        return map.get(n);
    }
}
