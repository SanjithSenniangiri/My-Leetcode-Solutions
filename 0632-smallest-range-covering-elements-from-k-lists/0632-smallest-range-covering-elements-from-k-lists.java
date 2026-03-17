class Cust{
    int ele;
    int listNum;
    int pos;

    public Cust(int e, int l, int p)
    {
        this.ele = e;
        this.listNum = l;
        this.pos = p;
    }

}


class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Cust> pq = new PriorityQueue<>((a,b) -> a.ele - b.ele);
        int max_val = Integer.MIN_VALUE;
        for(int i=0; i<nums.size(); i++)
        {
            max_val = Math.max(max_val, nums.get(i).get(0));
            Cust c = new Cust(nums.get(i).get(0), i, 0);
            pq.add(c);
        }

        int[] ans = new int[] {pq.peek().ele, max_val};
        while(true)
        {
          Cust cur = pq.remove();
          if(cur.pos == nums.get(cur.listNum).size()-1)
          {
            
            break;
          }
          
          Cust next = new Cust(nums.get(cur.listNum).get(cur.pos + 1), cur.listNum, cur.pos + 1);
          pq.add(next);
          max_val = Math.max(max_val, nums.get(next.listNum).get(next.pos));

          if(max_val - pq.peek().ele < ans[1] - ans[0])
          {
            ans[0] = pq.peek().ele;
            ans[1] = max_val;
          }
        }

        return ans;
    }
}