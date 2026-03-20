class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        int[][] res=new int[n-k+1][m-k+1];
        for(int i=0;i<n-k+1;i++){
            for(int j=0;j<m-k+1;j++){
                Set<Integer> hs=new HashSet<>();
                for(int x=i;x-i<k;x++){
                    for(int y=j;y-j<k;y++){
                        hs.add(grid[x][y]);
                    }
                }
                List<Integer> l=new ArrayList<>(hs);
                Collections.sort(l);
                int min=Integer.MAX_VALUE;
                for(int x=1;x<l.size();x++){
                    min=Math.min(min,l.get(x)-l.get(x-1));
                }
                res[i][j]=(min==Integer.MAX_VALUE)?0:min;
            }
        }
        return res;
    }
}