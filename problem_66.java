//Approach 1
class Solution1 {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        List<Integer> l=new ArrayList<>();
        int c=1;
        for(int i=n-1;i>=0;i--){
            int s=digits[i]+c;
            if(digits[i]==9 && c==1){
                l.add(0,0);  //add in front
            }
            else{
                l.add(0,s);
                c=0;
            }
        }
        if(c==1) l.add(0,1);
        int[] res=new int[l.size()];
        //copy list to array
        for(int i=0;i<l.size();i++){
            res[i]=l.get(i);
        }
        return res;
    }
}

//Approach 2
class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
                digits[i]=0;
        }

        //if all digits are 9
        int[] res=new int[n+1];
        res[0]=1;
        return res;
    }
}