/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE, head);
        // ListNode curr = dummy;
        Stack<Integer> st = new Stack<>();
        ListNode ans = recurse(dummy, st);
        return ans.next;
    }

    public ListNode recurse(ListNode dummy, Stack<Integer> st)
    {
        if(dummy.next == null)
        {
            st.push(dummy.val);
            return dummy;
        }

        ListNode curr = recurse(dummy.next, st);

        if(!st.isEmpty() && dummy.val<st.peek())
        {
            return curr;
        }
        else{
            st.push(dummy.val);
            dummy.next = curr;
            return dummy;
        }
    }
}