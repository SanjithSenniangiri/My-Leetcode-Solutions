class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele: nums)
        {
            pq.add(ele);
        }

        for(int i = 0; i<nums.length; i++)
        {
            nums[i] = pq.remove();
        }
        return nums;
    }
}