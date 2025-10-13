class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n=words.length;
        List<String> res=new ArrayList<>();
        res.add(words[0]);
        String s1=words[0];
        char[] s1arr= s1.toCharArray();
        Arrays.sort(s1arr);
        int n1=s1arr.length;
        for(int i=1;i<n;i++){
            String s2=words[i];
            char[] s2arr=s2.toCharArray();
            Arrays.sort(s2arr);
            int n2=s2arr.length;
            if(n1!=n2){
                s1=words[i];
                res.add(s1);
                s1arr= s1.toCharArray();
                Arrays.sort(s1arr);
                n1=s1arr.length;
            }
            else{
                for(int j=0;j<n1;j++){
                    if(s1arr[j]!=s2arr[j]){
                        s1=words[i];
                        res.add(s1);
                        s1arr= s1.toCharArray();
                        Arrays.sort(s1arr);
                        n1=s1arr.length;
                        break;
                    }
                }
            }
        }
        return res;
    }
}