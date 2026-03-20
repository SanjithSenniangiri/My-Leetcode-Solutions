class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> s = new HashMap<>();

        for(int ele: nums)
        {
            s.put(ele, s.getOrDefault(ele, 0) + 1);
        }
        int ans=0;
        for(int i=0; i<nums.length; i++)
        {
            int target = nums[i] - k;
            if(s.containsKey(target))
            {
                ans+=s.get(target);
            }
        }
        return ans;
    }
}