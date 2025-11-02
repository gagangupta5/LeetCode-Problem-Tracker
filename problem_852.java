class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l=0,h=arr.length-1,mid=0;
        while(l<=h){
            mid=(l+h)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                break;
            }
            else if(arr[mid]<arr[mid+1]){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return mid;
    }
}