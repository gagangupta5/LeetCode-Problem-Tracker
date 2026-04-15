class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        if(n%2!=0) return false;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[') st.push(ch);
            else{
                if(st.isEmpty()) return false;
                char ch1=st.pop();
                if((ch==')' && ch1!='(')||(ch=='}' && ch1!='{')||(ch==']' && ch1!='[')) return false;
            }
        }
        return st.isEmpty()?true:false;
    }
}