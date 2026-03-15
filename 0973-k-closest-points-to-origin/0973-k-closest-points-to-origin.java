class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        // Map<Double, Integer> m = new HashMap<>();
        for(int i=0; i<points.length; i++)
        {
            int a = points[i][0];
            int b = points[i][1];

            int ans = a*a + b*b;
            // m.put(ans, i);
            pq.add(new int[] {ans, i});
            if(pq.size() > k)
            {
                pq.remove();
            }
        }

        int[][] ret = new int[k][2];
        k--;
        while(!pq.isEmpty() && k>=0)
        {
            int val = pq.peek()[1];
            pq.remove();
            ret[k][0] = points[val][0];
            ret[k][1] = points[val][1];
            k--;
        }

        return ret;

    }
}