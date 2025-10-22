import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int i, j, sum;

        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }

        public int compareTo(Pair other) {
            return Integer.compare(this.sum, other.sum);
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Start by pairing first element in nums2 with first k elements in nums1
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.offer(new Pair(i, 0, nums1[i] + nums2[0]));
        }

        while (k-- > 0 && !pq.isEmpty()) {
            Pair current = pq.poll();
            int i = current.i;
            int j = current.j;
            res.add(Arrays.asList(nums1[i], nums2[j]));

            // Push the next element from nums2 with the same nums1[i]
            if (j + 1 < nums2.length) {
                pq.offer(new Pair(i, j + 1, nums1[i] + nums2[j + 1]));
            }
        }

        return res;
    }
}
