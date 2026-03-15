class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i=0; i<nums.length; i++)
        {
            m.put(nums[i], m.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->  a[1] - b[1]);

        for(int key: m.keySet())
        {
            pq.add(new int[] {key, m.get(key)});
            if(pq.size()>k)
            {
                pq.remove();
            }
        }

        int[] res = new int[k];
        k--;
        while(!pq.isEmpty() && k>=0)
        {
            res[k--] = pq.remove()[0];
        }

        return res;
    }
}