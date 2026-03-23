class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = 0;

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int count = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    grid[i][j] = 0;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        count++;

                        for(int[] d : dir){
                            int x = cur[0] + d[0];
                            int y = cur[1] + d[1];

                            if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1){
                                q.offer(new int[]{x,y});
                                grid[x][y] = 0;
                            }
                        }
                    }
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }
}