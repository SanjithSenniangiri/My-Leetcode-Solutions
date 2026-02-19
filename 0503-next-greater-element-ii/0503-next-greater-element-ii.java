class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length * 2;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n/2];
        for(int i=n-1; i>=0; i--)
        {
            if(i<nums.length)
            {
                while(!st.isEmpty())
                {
                    if(nums[i]<st.peek())
                    {
                        // int val = st.peek();
                        // st.push(nums[i]);
                        // ans[i] = val;
                        break;
                    }
                    else{
                        st.pop();
                    }
                }
                ans[i] = st.isEmpty()? -1 : st.peek();
                st.push(nums[i]);
                // ans[i] = st.isEmpty()? -1 : st.peek();
            }
            else{
                int idx = i % nums.length;
                while(!st.isEmpty())
                {
                    if(nums[idx]<st.peek())
                    {
                        // st.push(nums[i]);
                        break;
                    }
                    else{
                        st.pop();
                    }
                }
                st.push(nums[idx]);
            }
        }
        return ans;
    }
}