class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            if(!st.isEmpty() && s.charAt(i) == st.peek())
            {
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }

        StringBuilder s1 = new StringBuilder();
        for(Character c: st)
        {
            s1.append(c);
        }
        return s1.toString();
    }
}