class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        char res=letters[0];
        int low=0,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if((int)letters[mid]>(int)target){
                res=letters[mid];
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
}