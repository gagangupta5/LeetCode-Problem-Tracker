//Approach 1 (Brute Force)
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


//Approach 2 (Optimised)
class Solution {
    public static int totalMoney(int n) {
        int w = n/7;
        int r = n % 7;
        int sumFull = 28*w + 7*(w*(w-1)/2);
        int SumRem = r*w + r*(r+1)/2;
        return sumFull + SumRem;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(totalMoney(n));
    }
}