class Solution1 {
    public int totalMoney(int n) {
        int res=0;
        int x=28,c=1;
        while(n>0){
            if(n>=7){
                res+=x;
                x+=7;
                n-=7;
                c++;
            }
            else{
                res+=c;
                c++;
                n--;
            }
        }
        return res;
    }
}