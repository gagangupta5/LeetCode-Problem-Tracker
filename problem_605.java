class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m=flowerbed.length;
        for(int i=0;i<m;i++){
            boolean left=i==0 || flowerbed[i-1]==0;
            boolean right=i==m-1 || flowerbed[i+1]==0;
            if(left && right && flowerbed[i]==0){
                flowerbed[i]=1;
                n--;
            }
        }     
        return n<=0;
    }
}