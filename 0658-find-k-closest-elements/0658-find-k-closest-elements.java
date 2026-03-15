class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return b.get(0) - a.get(0);
            }
            return b.get(1) - a.get(1);
        });

        for(int i = 0; i<arr.length; i++)
        {
            int ans = Math.abs(arr[i] - x);
            List<Integer> l = new ArrayList<>();
            l.add(ans);
            l.add(arr[i]);
            pq.add(l);

            if(pq.size() > k)
            {
                pq.remove();
            }
        }

        List<Integer> res = new ArrayList<>();
       while (!pq.isEmpty()) {
            res.add(pq.remove().get(1));
        }

        Collections.sort(res);
        return res;
    }
}