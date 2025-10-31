//Approach 1
class Solution1 {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length;
        int[] res=new int[2];
        int c=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]){
                    res[c++]=nums[i];
                    break;
                }
            }
            if(c==2) break;
        }
        return res;
    }
}


//Approach 2
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] res=new int[2];
        int j=0;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]) res[j++]=nums[i];
            if(j==2) break;
        }
        return res;
    }
}