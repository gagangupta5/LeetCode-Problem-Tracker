//Approach 1
class Solution1 {
    public boolean isAnagram(String s, String t) {
        int n1=s.length(),n2=t.length();
        if(n1!=n2) return false;
        HashMap<Character, Integer> h1=new HashMap<>();
        HashMap<Character, Integer> h2=new HashMap<>();
        for(int i=0;i<n1;i++){
            if(h1.get(s.charAt(i))==null){
                h1.put(s.charAt(i),1);
            }
            else{
                Integer c=(int)h1.get(s.charAt(i));
                h1.put(s.charAt(i),++c);
            }
        }
        for(int i=0;i<n1;i++){
            if(h2.get(t.charAt(i))==null){
                h2.put(t.charAt(i),1);
            }
            else{
                Integer c=(int)h2.get(t.charAt(i));
                h2.put(t.charAt(i),++c);
            }
        }
        if(h1.equals(h2)) return true;
        return false;
    }
}


//Approach 2
class Solution {
    public boolean isAnagram(String s, String t) {
        int n1=s.length(),n2=t.length();
        if(n1!=n2) return false;
        char[] sarr=s.toCharArray();
        char[] tarr=t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        for(int i=0;i<n1;i++){
            if(sarr[i]!=tarr[i]) return false;
        }
        return true;
   }
}