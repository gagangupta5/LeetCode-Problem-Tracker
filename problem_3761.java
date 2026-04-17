//Solution 1 : Brute Force
class Solution1 {
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]==-1) continue;
            int rev=reverse(nums[i]);
            for(int j=i+1;j<n;j++){
                if(nums[j]==rev){
                    res=Math.min(res,j-i);
                    break;
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
    private int reverse(int n){
        int rev=0;
        while(n!=0){
            int d=n%10;
            rev=rev*10+d;
            n/=10;
        }
        return rev;
    }
}

//Solution 2 : Optimised
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                res=Math.min(res,i-map.get(nums[i]));
                map.put(reverse(nums[i]),i);
            }
            else map.put(reverse(nums[i]),i);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
    private int reverse(int n){
        int rev=0;
        while(n!=0){
            int d=n%10;
            rev=rev*10+d;
            n/=10;
        }
        return rev;
    }
}