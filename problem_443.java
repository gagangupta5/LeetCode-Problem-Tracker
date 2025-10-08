class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int res=1;   
        Integer c=1;  //I take Integer because I convert this into string 
        for(int i=1;i<n;i++){
            c=1;
            while(i<n && chars[i]==chars[i-1]){
                c++;
                i++;
            } 
            if(c==1){     //if only one character is there then we can't write any number 
                if(i<n) chars[res++]=chars[i];
                continue;
            }
            String s=String.valueOf(c);
            if(s.length()==1) chars[res++]=s.charAt(0);
            else{
                for(int j=0;j<s.length();j++){        //for more than one length of digit string
                    chars[res++]=s.charAt(j);
                }
            }
            if(i<n) chars[res++]=chars[i];    //for storing the character not for count of that char
        }
        return res;
    }
}