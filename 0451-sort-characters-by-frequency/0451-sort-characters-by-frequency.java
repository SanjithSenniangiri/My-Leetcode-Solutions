class Cust{
    char c;
    int count;
    public Cust(char c, int n){
        this.c = c;
        this.count = n;
    }
}


class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Cust> pq = new PriorityQueue<>((a,b) -> b.count - a.count);

        Map<Character, Integer> m = new HashMap<>();

        for(int i=0; i<s.length(); i++)
        {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(Character ele: m.keySet())
        {
            pq.add(new Cust(ele, m.get(ele)));
        }

        StringBuffer s1 = new StringBuffer();

        while(!pq.isEmpty())
        {
            Cust a = pq.remove();
            for(int j=0; j<a.count; j++)
            {
                s1.append(a.c);
            }
        }
        return s1.toString();
    }
}