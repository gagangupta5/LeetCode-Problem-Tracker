class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int res=Integer.MAX_VALUE,cnt1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) cnt1++;
        }
        if(cnt1>0) return n-cnt1;
        for(int i=0;i<n;i++){
            int n1=nums[i];
            for(int j=i+1;j<n;j++){
                int n2=nums[j];
                n1=findGCD(n1,n2);
                if(n1==1){
                    res=Math.min(res,j-i+n-1);
                    break;
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    private int findGCD(int n1,int n2){
        while(n2!=0){
            int temp=n2;
            n2=n1%n2;
            n1=temp;
        }
        return n1;
    }
}