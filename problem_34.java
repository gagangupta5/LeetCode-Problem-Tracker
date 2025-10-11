class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int start=-1,last=-1;
        int beg=0,end=n-1,mid=-1;
        while(beg<=end){
            mid=(beg+end)/2;
            if(nums[mid]==target){
                start=mid;
                last=mid;
                end=mid-1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                beg=mid+1;
            }
        }
        beg=last+1;
        end=n-1;
        while(beg<=end){
            mid=(beg+end)/2;
            if(nums[mid]==target){
                last=mid;
                beg=mid+1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                beg=mid+1;
            }
        }
        int res[]={start,last};
        return res;
    }
}