class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[] prevWith = new long[n + 1];
        long[] prevWithout = new long[n + 1];

        long[] prev_prefix = get_prefix(grid, 0);

        for (int i = 1; i < n; i++){
            long[] curr_prefix = get_prefix(grid, i);

            long[] currWith = new long[n + 1];
            long[] currWithout = new long[n + 1];

            for (int prev_height = 0; prev_height <= n; prev_height++){
                for (int state = 0; state < 2; state++){
                    for (int curr_height = 0; curr_height <= n; curr_height++){
                        if (state == 0) {
                            currWithout[curr_height] = Math.max(currWithout[curr_height],
                                                                prevWith[prev_height]);
                            currWith[curr_height] = Math.max(currWith[curr_height],
                                                             prevWith[prev_height] + query(curr_prefix, prev_height, curr_height));
                        }
                        else {
                            long qry = query(prev_prefix, curr_height, prev_height);

                            currWithout[curr_height] = Math.max(currWithout[curr_height],
                                                                qry + prevWithout[prev_height]);
                            currWith[curr_height] = Math.max(currWith[curr_height],
                                                            qry + prevWithout[prev_height] +
                                                            query(curr_prefix, prev_height, curr_height));
                        }
                    }
                }
            }

            prev_prefix = curr_prefix;
            prevWith = currWith;
            prevWithout = currWithout;
        }

        long max_score = 0;

        for (int i = 0; i <= n; i++){
            max_score = Math.max(max_score, Math.max(prevWith[i], prevWithout[i]));
        }

        return max_score;
    }

    private long query(long[] prefix, int a, int b){
        if (b >= a || a == 0) return 0L;
        else if (b == 0) return prefix[a - 1];

        return prefix[a - 1] - prefix[b - 1];
    }

    private long[] get_prefix(int[][] grid, int col){
        long[] prefix = new long[grid.length];
        prefix[0] = grid[0][col];
        for (int i = 1; i < grid.length; i++){
            prefix[i] = prefix[i - 1] + grid[i][col];
        }

        return prefix;
    }
}