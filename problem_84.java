class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] pse=new int[n];
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        for(int i=0;i<n;i++){
            while(st.size()>1 && heights[i]<=heights[st.peek()]) st.pop();
            pse[i]=st.peek();
            st.push(i);
        }
        st.clear();
        st.push(n);
        for(int i=n-1;i>=0;i--){
            while(st.size()>1 && heights[i]<=heights[st.peek()]) st.pop();
            nse[i]=st.peek();
            st.push(i);
        }
        int res=0;
        for(int i=0;i<n;i++){
            int area=heights[i]*(nse[i]-pse[i]-1);
            res=Math.max(res,area);
        }
        return res;
    }
}
