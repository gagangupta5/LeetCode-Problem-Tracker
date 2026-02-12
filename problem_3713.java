class Solution {
    public int longestBalanced(String s) {
        int res=1;
        int n=s.length();
        for(int i=0;i<n;i++){
            int[] arr=new int[26];
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                arr[ch-'a']++;
                if(isArrayBalanced(arr)) res=Math.max(res,j-i+1);
            }
        }
        return res;
    }

    private boolean isArrayBalanced(int[] arr){
        int val=-1;
        for(int i:arr){
            if(i!=0 && val==-1) val=i;
            else if(i!=0 && i!=val) return false;
        }
        return true;
    }
}