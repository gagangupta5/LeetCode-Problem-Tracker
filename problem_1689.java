class Solution {
    public int minPartitions(String n) {
        int len=n.length(),ans=1;
        for(int i=0;i<len;i++){       // 🔹 Find the highest digit
            int digit=(int)(n.charAt(i)-'0');
            if(digit>ans) ans=digit;
            if(ans==9) return ans; //Early exit → best possible answer
        }
        return ans;
    }
}