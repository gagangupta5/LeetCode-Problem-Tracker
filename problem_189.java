//Approach 1 space -> O(k)
class Solution1 {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(n<k) k=k%n;
        int i=0,j=n-k;
        if(n==1) return;
        int[] a=new int[k];
        while(j<n){
            a[i++]=nums[j++];
        }
        for(j=n-k-1;j>=0;j--){
            nums[j+k]=nums[j];
        }
        for(i=0;i<k;i++){
            nums[i]=a[i];
        }
    }
}


//Approach 2 (Optimal) no extra space
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        //reverse first n-k elements
        int i=0,j=n-k-1;
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;j--;
        }
        //reverse last k elements
        i=n-k;
        j=n-1;
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;j--;
        }
        //now reverse whole array
        i=0;
        j=n-1;
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;j--;
        }
    }
}