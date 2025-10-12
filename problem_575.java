class Solution {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length;
        int x=n/2;
        Arrays.sort(candyType);
        int c=1;
        for(int i=1;i<n;i++){
            if(candyType[i]!=candyType[i-1]){
                c++;
                if(c>=x) return x;
            }
        }
        return c;
    }
}