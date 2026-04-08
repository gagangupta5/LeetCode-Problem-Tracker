// Using BFS
class Solution1 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> res=new ArrayList<>();
        Queue<List<Integer>> q=new LinkedList<>();
        q.offer(new ArrayList<>(Arrays.asList(0)));
        while(!q.isEmpty()){
            List<Integer> path=q.poll();
            int node=path.get(path.size()-1);
            if(node==n-1){
                res.add(path);
            }
            else{
                for(int i:graph[node]){
                    List<Integer> newPath=new ArrayList<>(path);
                    newPath.add(i);
                    q.offer(newPath);
                }
            }
        }
        return res;
    }
}
