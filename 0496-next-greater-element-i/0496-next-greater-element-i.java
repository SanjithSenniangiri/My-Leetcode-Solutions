class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=nums2.length-1; i>=0; i--)
        {
            while(!st.isEmpty())
            {
                int val = st.peek();
                if(nums2[i] > val)
                {
                    st.pop();
                }
                else{
                    // map.put(nums2[i], val);
                    // st.push(nums2[i]);
                    break;
                }
            }
            map.put(nums2[i], st.isEmpty()? -1 : st.peek());
            st.push(nums2[i]);

        }

        int[] ans = new int[nums1.length];
        for(int j=0; j<nums1.length; j++)
        {
            ans[j] = map.get(nums1[j]);
        }
        return ans;
    }
}