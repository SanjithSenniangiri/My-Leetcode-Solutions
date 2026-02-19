class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = 0;
        int sum = 0;

        int i=0;
        int j = height.length - 1;

        while(i<j)
        {
            if(height[i] <= height[j])
            {
                if(height[i]< left)
                {
                // left = Math.max(left, height[i]);
                sum+= left - height[i];
                // continue;
                }
                left = Math.max(left, height[i]);
                i++;
            }
            else{
                if(height[j]< right)
                {
                    sum+= right - height[j];
                }
                right = Math.max(right, height[j]);
                j--;
            }
        }
        return sum;
    }
}