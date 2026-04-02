class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int min=nums[i],ind=i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<=min){
                    min=nums[j];
                    ind=j;
                }
            }
            if(i!=ind){
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
            }
        }
    }
}