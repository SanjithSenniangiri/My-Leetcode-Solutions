class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> out = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return out;

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
        
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            List<Integer> ls = new ArrayList<>();
            ls.add(nums1[i] + nums2[0]);
            ls.add(i);
            ls.add(0);
            pq.add(ls);
        }

        while (!pq.isEmpty() && k > 0) {
            List<Integer> in = pq.remove();
            int i = in.get(1);
            int j = in.get(2);

            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[j]);
            out.add(pair);
            k--;

            if (j + 1 < nums2.length) {
                List<Integer> next = new ArrayList<>();
                next.add(nums1[i] + nums2[j + 1]);
                next.add(i);
                next.add(j + 1);
                pq.add(next);
            }
        }

        return out;
    }
}