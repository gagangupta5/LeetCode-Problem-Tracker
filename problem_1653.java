class Solution {
    public int minimumDeletions(String s) {
        int tally=0;
        for(char ch:s.toCharArray()){
            if(ch=='a') tally++;
        }
        int res=tally;
        for(char ch:s.toCharArray()){
            if(ch=='a'){
                tally--;
                if(tally<res) res=tally;
            }
            else tally++;
        }
        return res;
    }
}