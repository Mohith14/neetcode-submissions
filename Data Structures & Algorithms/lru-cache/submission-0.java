class LRUCache {
    private static class Node{
        int key;
        int value;
        Node previous;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Map<Integer,Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        cache = new HashMap<>();

        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        
        head.next=tail;
        tail.previous = head;
    }
    
    public int get(int key) {
        Node val = cache.get(key);

        if(val==null){
            return -1;
        }
        remove(val);
        addfirst(val);

        return val.value;
        
    }
    
    public void put(int key, int value) {
        if(capacity <= 0){
            return;
        }
        Node exist = cache.get(key);
        if(exist != null){
            exist.value = value;
            remove(exist);
            addfirst(exist);
            return;
        }
        Node nw = new Node(key , value);
        cache.put(key, nw);
        addfirst(nw);

        if(cache.size() > capacity){
            Node k = tail.previous;
            remove(k);
            cache.remove(k.key);
        }
    }
    public void remove(Node n){
        Node before = n.previous;
        Node after = n.next;

        before.next =after;
        after.previous=before;
    }

    public void addfirst(Node m){
        Node temp =head.next;
        m.previous =head;
        m.next = temp;

        head.next =m;
        temp.previous =m;

    }
}
