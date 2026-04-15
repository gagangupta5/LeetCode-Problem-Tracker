class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        int i=0;
        int res=Integer.MAX_VALUE;
        while(i<n){
            if(words[i].equals(target)){
                int diff=Math.abs(startIndex-i);
                int circulardist=n-diff;
                res=Math.min(res,Math.min(diff,circulardist));
            }
            i++;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}