class Solution {
    public int concatenatedBinary(int n) {
        List<Integer> bits=new ArrayList<>();
        // Build concatenated binary
        for(int i=1;i<=n;i++){
            int x=i;
            List<Integer> temp=new ArrayList<>();
            while (x>0){
                temp.add(x%2);
                x/=2;
            }
            // store in correct order
            for(int j=temp.size()-1;j>=0;j--){
                bits.add(temp.get(j));
            }
        }
        int mod=1_000_000_007;
        long pow2=1;
        long ans=0;
        // Evaluate decimal value
        for(int i=bits.size()-1;i>=0;i--){
            ans=(ans+pow2*bits.get(i)) % mod;
            pow2=(pow2*2)%mod;   // next power of 2
        }
        return (int)ans;
    }
}