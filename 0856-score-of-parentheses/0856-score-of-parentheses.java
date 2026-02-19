class Solution {
    public int scoreOfParentheses(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> st = new Stack<>();
        // map.put(')', '(');
        int score = 0;
        int depth = 0;
        for(int i=0; i< s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                st.push(s.charAt(i));
                depth++;
            }
            else {
                st.pop();
                depth--;
                if(s.charAt(i-1) == '(')
                {
                    int ans = 1;
                    for(int j =0; j<depth; j++)
                    {
                        ans*=2;
                    }
                    score+=ans;
                }
            }
        }
        return score;
        
    }
}