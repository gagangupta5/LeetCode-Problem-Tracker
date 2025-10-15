//Approach 1 
class Solution1 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int res=1;
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>(); 
        int i=0;
        //for first subarray
        while(i<n-1 && nums.get(i)<nums.get(i+1)){
            l1.add(nums.get(i));
            i++;
        }
        l1.add(nums.get(i));
        i++;
        res=Math.max(res,l1.size()/2);        
        while(i<n-1){
            l2.clear();  //clear the second list
            //for second subarray
            while(i<n-1 && nums.get(i)<nums.get(i+1)){
                l2.add(nums.get(i));
                i++;
            }
            l2.add(nums.get(i));
            i++;
            res=Math.max(res,l2.size()/2);
            res=Math.max(res,Math.min(l1.size(),l2.size()));
            l1=new ArrayList<>(l2);
        }
        return res;
    }
}


//Approach 2 (same but easy to understand)
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int res=0;             // Stores the maximum possible adjacent increasing subarray length
        int currLen=1;            // Length of the current increasing subarray
        int prevLen=0;            // Length of the previous increasing subarray
        
        for (int i = 1; i < nums.size();i++) {
            // If current number continues the increasing trend
            if (nums.get(i) > nums.get(i-1)) {
                currLen++;
            } 
            else {
                // Reset when the increasing sequence breaks
                prevLen = currLen;
                currLen = 1;
            }
            
            // Case 1: Take half of the current sequence length (for overlapping parts)
            res=Math.max(res,currLen/2);
            
            // Case 2: Adjacent sequences — choose the smaller of the two lengths
            res=Math.max(res,Math.min(prevLen,currLen));
        }
        
        return res;
    }
}