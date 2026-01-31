class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[graph.size()];
        queue.add(source);
        visited[source]=true;
        while(!queue.isEmpty()){
            int x=queue.poll();
            if(x==destination) return true;
            for(int neighbor : graph.get(x)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}