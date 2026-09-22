class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n=arr.length;
        List<Integer> res=new ArrayList<>();
        int s=n-1;
        while(!checkSort(arr,n)){
            for(int i=s;i>=0;i--){
                if(arr[i]!=i+1){
                    int j=i;
                    while(j>=0 && arr[j]!=i+1) j--;
                    flip(arr, j);
                    res.add(j+1);
                    flip(arr, i);
                    res.add(i+1);
                    s=i-1;
                    break;
                }
            }
        }
        return res;
    }
    private boolean checkSort(int[] arr, int n){
        for(int i=0;i<n;i++){
            if(arr[i]!=i+1) return false;
        }
        return true;
    }
    private void flip(int[] arr, int idx){
        int st=0;
        while(st<idx){
            int temp=arr[st];
            arr[st]=arr[idx];
            arr[idx]=temp;
            st++;
            idx--;
        }
    }
}
