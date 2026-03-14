class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones)
        {
            pq.add(ele);
        }

        int ret = 0;
        while(true)
        {   
            int a = pq.peek();
            pq.remove();
            if(pq.isEmpty())
            {
                ret = a;
                break;
            }
            int b = pq.peek();
            pq.remove();
            int ans = Math.abs(a - b);
            pq.add(ans);
        }
        return ret;
    }
}