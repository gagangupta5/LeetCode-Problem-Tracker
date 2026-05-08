class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int area=0;
        int[] row=new int[c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                row[j]=matrix[i][j]=='1' ? row[j]+1 : 0;
            }
            area=Math.max(area,largestRectangleArea(row));
        }
        return area;
    }

    public int largestRectangleArea(int[] heights){
        int maxArea=0;
        int n=heights.length;
        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<n;i++){
            int st=i;
            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int[] arr=stack.pop();
                maxArea=Math.max(maxArea,arr[1]*(i-arr[0]));
                st=arr[0];
            }
            stack.add(new int[]{st,heights[i]});
        }
        while(!stack.isEmpty()){
            int[] arr=stack.pop();
            maxArea=Math.max(maxArea,arr[1]*(n-arr[0]));
        }
        return maxArea;
    }
}abc