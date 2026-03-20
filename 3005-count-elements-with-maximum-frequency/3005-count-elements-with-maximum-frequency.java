class Solution {
    public int maxFrequencyElements(int[] nums) {
        int max =0;
        Map<Integer, Integer> m = new HashMap<>();
        for(int e: nums)
        {
            m.put(e, m.getOrDefault(e, 0) + 1);
            max = Math.max(max, m.get(e));
        }

        int sum = 0;
        for(int ele: m.keySet())
        {
            if(m.get(ele) == max)
            {
                sum+=m.get(ele);
            }
        }

        return sum;


    }
}