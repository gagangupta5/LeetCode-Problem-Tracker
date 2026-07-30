// Solution 1 TC=O(N^2) SC=O(N)
class Solution1 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q=new LinkedList<>();
        Stack<Integer> s=new Stack<>();
        int n=students.length;
        for(int i=0;i<n;i++){
            q.add(students[i]);
        }
        for(int i=n-1;i>=0;i--){
            s.push(sandwiches[i]);
        }
        int c=0;
        while(!q.isEmpty()){
            int m=q.size();
            if(m==c) return c;
            int x=q.poll();
            if(x==s.peek()){
                c=0;
                s.pop();
            }
            else{
                c++;
                q.add(x);
            }
        }
        return 0;
    }
}


// Solution 2 TC=O(N) SC=O(1)
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n=students.length;
        int a=0,b=0;
        for(int i=0;i<n;i++){
            if(students[i]==1) a++;
            else b++;
        }
        for(int i=0;i<n;i++){
            if(sandwiches[i]==1 && a>0){
                a--;
            }
            else if(sandwiches[i]==0 && b>0){
                b--;
            }
            else return a+b;
        }
        return 0;
    }
}
