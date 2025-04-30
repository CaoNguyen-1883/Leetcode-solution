

class LRUCache {
    class Node{
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
        
        public Node(int key, int value, Node head, Node tail){
            this.key = key;
            this.value = value;
            this.prev = head;
            this.next = tail;
        }
    }
    
    private Node[] cache;
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size =  0;
        this.cache = new Node[10_000 + 1];
        this.head = new Node(-1, -1);
        this.tail = new Node(10001, 10001);
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public int get(int key) {
        if(cache[key] == null) return -1;
        Node node = cache[key];
        int res = node.value;
        deleteNode(node);
        addToHead(node);


        return res;
    }
    
    public void put(int key, int value) {
        if(cache[key] != null){
            Node node = cache[key];
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else{
            Node node = new Node(key, value);
            cache[key] = node;

            if(size < capacity){
                ++size;
                addToHead(node);
            } else{
                cache[tail.prev.key] = null;
                deleteNode(tail.prev);
                addToHead(node);
            }
        }

    }
    
}


/* class Node{
    public int key;
    public int value;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private int capacity;
    private Map<Integer, Node> keyToNode = new HashMap<>();
    private Set<Node> cache= new LinkedHashSet<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!keyToNode.containsKey(key)) return -1;
        Node node = keyToNode.get(key);
        
        cache.remove(node);
        cache.add(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if(keyToNode.containsKey(key)){
            keyToNode.get(key).value = value;
            get(key);
            return;
        }

        if(cache.size() == capacity){
            Node lastNode = cache.iterator().next();
            cache.remove(lastNode);
            keyToNode.remove(lastNode.key);
        }

        Node node = new Node(key, value);
        cache.add(node);
        keyToNode.put(key, node);
    }
} */
