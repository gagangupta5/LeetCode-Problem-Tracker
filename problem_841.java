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
