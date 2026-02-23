class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k) return false;
        int totalNeeded=1<<k;
        HashSet<String> seen=new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            seen.add(s.substring(i,i+k));
            if(seen.size()==totalNeeded) return true;
        }
        return false;
    }
}