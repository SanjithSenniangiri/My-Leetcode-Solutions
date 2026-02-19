class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length ==1) return heights[0];
        Stack<Integer> st = new Stack<>();
        int max = 0;
        // st.push(-1);
        for(int i=0; i<heights.length; i++)
        {
            while(!st.isEmpty() && heights[i] < heights[st.peek()])
            {
                int nse = i;
                int val = st.pop();
                int pse = st.isEmpty()?-1:st.peek();
                max = Math.max(max, heights[val] * (nse - pse - 1));
                continue;
            }
            st.push(i);
        }

        while(!st.isEmpty())
        {
            int nse = heights.length;
            int val = st.pop();
            int pse = st.isEmpty()?-1:st.peek();
            max = Math.max(max, heights[val] * (nse - pse - 1));
            continue;
        }
        return max;
    }
}