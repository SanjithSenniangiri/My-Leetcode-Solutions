class LRUCache {
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node t = map.get(key);
            delNode(t);
            addNode(t);
            return t.val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node t = map.get(key);
            t.val = value;
            delNode(t);
            addNode(t);
            map.put(key, t);
        }
        else if(map.size() == capacity)
        {
            Node n = new Node(key, value);
            map.remove(tail.prev.key);
            delNode(tail.prev);
            addNode(n);
            map.put(key, n);
        }
        else{
            Node n = new Node(key, value);
            addNode(n);
            map.put(key , n);
        }
    }

    public void addNode(Node t)
    {
        t.next = head.next;
        t.prev = head;
        head.next.prev = t;
        head.next = t;
    }

    public void delNode(Node t)
    {
        t.prev.next = t.next;
        t.next.prev = t.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */