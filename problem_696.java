class Solution {
    public int countBinarySubstrings(String s) {
        int res=0;
        int n=s.length();
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            int ch=s.charAt(i);
            int count=0;
            while(i<n && s.charAt(i)==ch){
                count++;
                i++;
            }
            l.add(count);
            i--;
        }
        for(int i=1;i<l.size();i++){
            res+=Math.min(l.get(i-1),l.get(i));
        }
        return res;
    }
}