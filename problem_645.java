//Approach 1 Time -> O(nlogn)
class Solution1 {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int[] res=new int[2];
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                res[0]=nums[i];
            }
        }
        if(nums[0]!=1){
            res[1]=1;
            return res;
        }
        if(nums[n-1]!=n){
            res[1]=n;
            return res;
        }
        int x=2;
        for(int i=1;i<n;i++){
            if(nums[i]==x && nums[i]!=nums[i-1]){
                x++;
            }
            else{
                res[1]=x;
            }
        }
        return res;
    }
}

//Approach 2 Time -> O(n)
class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean[] exist = new boolean[nums.length+1];
        int miss=-1,dup=-1;
        for(int i : nums){
            if(exist[i]){
                dup=i;
            }
            else{
                exist[i]=true;
            }
        }

        for(int i=1;i<=nums.length;i++){
            if(!exist[i]){
                miss=i;
                break;
            }
        }
        return new int[] {dup,miss};
    }
}