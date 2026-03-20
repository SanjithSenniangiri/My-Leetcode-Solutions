class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int ele: nums)
        {
            m.put(ele, m.getOrDefault(ele, 0) + 1);
        }

        int sum = 0;
        for(int e: m.keySet())
        {
            if(m.get(e) == 1)
            {
                sum+=e;
            }
        }
        return sum;
    }
}