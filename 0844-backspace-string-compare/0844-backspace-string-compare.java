class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '#')
            {
                if(!st.isEmpty()) st.pop();
                continue;
            }
            else{
                st.push(s.charAt(i));
            }
        }

        for(Character c: st)
        {
            s1.append(c);
        }

        st.clear();
        for(int j=0; j<t.length(); j++)
        {
            if(t.charAt(j) == '#')
            {
                if(!st.isEmpty()) st.pop();
                continue;
            }
            st.push(t.charAt(j));
        }

        for(Character d: st)
        {
            s2.append(d);
        }

        boolean res = false;
        // for(int k=s1.length() - 1; k>=0; k--)
        // {
        //     if(!st.isEmpty() && s1.charAt(k) != st.pop())
        //     {
        //         res=false;
        //     }
        // }

        if(s1.toString().equals(s2.toString())) res = true;
        return res;
        
    }
}