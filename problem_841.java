class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[rooms.size()];
        queue.add(0);
        visited[0]=true;
        while(!queue.isEmpty()){
            int x=queue.poll();
            List<Integer> l=rooms.get(x);
            for(Integer y: l){
                if(visited[y]==true) continue;
                if(queue.contains(y)) continue;
                queue.add(y);
                visited[y]=true;
            }
        }   
        for(int i=0;i<rooms.size();i++){
            if(visited[i]==false) return false;
        }
        return true;
    }
}