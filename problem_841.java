//Solution 1 Using DFS
class Solution1 {
    HashSet<Integer> visit=new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        solve(0,rooms);
        if(visit.size()==rooms.size()) return true;
        return false;
    }
    private void solve(int i,List<List<Integer>> rooms){
        if(visit.contains(i)) return;
        visit.add(i);
        for(int x:rooms.get(i))
            solve(x,rooms);
    }
}


//Solution 2 Using BFS
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue=new LinkedList<>();
        HashSet<Integer> visit=new HashSet<>();
        queue.add(0);
        visit.add(0);
        while(!queue.isEmpty()){
            int x=queue.poll();
            for(int i:rooms.get(x)){
                if(!visit.contains(i)){
                    queue.add(i);
                    visit.add(i);
                }
                if(visit.size()==rooms.size()) return true;
            }
        }
        return false;
    }
}