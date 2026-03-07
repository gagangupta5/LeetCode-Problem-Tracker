class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String s2 = s+s;
        int diff1 = 0;
        int diff2 = 0;
        int res = Integer.MAX_VALUE;

        for(int i=0;i<s2.length();i++)
        {
            char expected1 = (i%2==0)? '1' : '0';
            char expected2 = (i%2==0)? '0' : '1';

            // Count mismatches for pattern1
            if(s2.charAt(i)!=expected1) 
            {
                diff1++;
            }
            // Count mismatches for pattern2
            if(s2.charAt(i)!=expected2) 
            {
                diff2++;
            }

             // If window size becomes greater than n, remove the leftmost character
            if(i>=n)
            {
                char prevExpected1 = (i-n) %2 == 0 ? '1' : '0';
                char prevExpected2 = (i-n) %2 == 0 ? '0' : '1';

                // Remove mismatches for pattern1
                if(s2.charAt(i-n) != prevExpected1)
                {
                    diff1--;
                }
                // Remove mismatches for pattern2
                if(s2.charAt(i-n) != prevExpected2)
                {
                    diff2--;
                }
            }

            // When window size reaches n, update the minimum flips
            if(i>=n-1)
            {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }
    return res;
    }
}