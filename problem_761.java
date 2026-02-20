class Solution {
    public String makeLargestSpecial(String s) {
        List<String> ls=new ArrayList<>();
        int st=0,c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') c++;
            else c--;
            if(c==0){
                String inner=makeLargestSpecial(s.substring(st+1,i));
                ls.add("1"+inner+"0");
                st=i+1;
            }
        }
        Collections.sort(ls,Collections.reverseOrder());
        StringBuilder res=new StringBuilder();
        for(String str:ls) res.append(str);
        return res.toString();
    }
}