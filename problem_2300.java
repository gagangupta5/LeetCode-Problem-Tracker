//Approach 1 (show TLE)
class Solution1 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length,m=potions.length;
        Arrays.sort(potions);
        int[] res=new int[n];
        int i=0,j=0;
        for(i=0;i<n;i++){
            j=0;
            for(j=0;j<m;j++){
                if(((long)potions[j]*(long)spells[i])>=success) break;
            }
            res[i]=m-j;
        }
        return res;
    }
}


//Approach 2 (Optimise solution)
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length,m=potions.length;
        Arrays.sort(potions);
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            long need=(success+spells[i]-1)/spells[i];
            int index=lower_bound(potions,need);
            res[i]=m-index;
        }
        return res;
    }
    
    private int lower_bound(int[] potions,long target){
        int l=0,h=potions.length;
        while(l<h){
            int mid=(l+h)/2;
            if(potions[mid]<target) l=mid+1;
            else h=mid;
        }
        return l;
    }
}