class LRUCache {

    public class Node{
        int key;
        int val;

        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int capacity;
    private HashMap<Integer,Node> map;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        this.head = new Node(0,0);
        this.tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node element = map.get(key);

        if(element==null){
            return -1;
        }
        remove(element);
        addFirst(element);

        return element.val;
        
    }
    
    public void put(int key, int value) {
        if(capacity < 0){
            return;
        }

        Node element = map.get(key);

        if(element!=null){
            element.val = value;
            remove(element);
            addFirst(element);
            return;
        }

        Node newElement = new Node(key,value);

        map.put(key , newElement);
        addFirst(newElement);

        if(map.size()>capacity){
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
    }

    public void remove(Node n){
        n.next.prev = n.prev;
        n.prev.next = n.next;
    }

    public void addFirst(Node n){
        Node temp = head.next;
        n.prev = head;
        n.next = temp;

        head.next =n;
        temp.prev =n;
    }
}
