
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class LRUCache {
    class Node{
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value){
            this.key= key;
            this.value= value;
        }
    }

    public Node[] map;
    public int count, capacity;
    public Node head, tail;
    
    public LRUCache(int capacity) {
        
        this.capacity= capacity;
        count= 0;
        
        map= new Node[10_000+1];
        
        head= new Node(0,0);
        tail= new Node(0,0);
        
        head.next= tail;
        tail.prev= head;
        
        head.prev= null;
        tail.next= null;
    }
    
    public void deleteNode(Node node){
        node.prev.next= node.next;
        node.next.prev= node.prev;       
        
        return;
    }
    
    public void addToHead(Node node){
        node.next= head.next;
        node.next.prev= node;
        node.prev= head;
        
        head.next= node;      
        
        return;
    }
    
    public int get(int key) {
        
        if( map[key] != null ){
            
            Node node= map[key];
            
            int nodeVal= node.value;
            
            deleteNode(node);
            
            addToHead(node);
            
            return nodeVal;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        
        if(map[key] != null){
            
            Node node= map[key];
            
            node.value= value;
            
            deleteNode(node);
            
            addToHead(node);
            
        } else {
            
            Node node= new Node(key,value);
            
            map[key]= node;
            
            if(count < capacity){
                count++;
                addToHead(node);
            } 
            else {
                
                map[tail.prev.key]= null;
                deleteNode(tail.prev);
                
                addToHead(node);
            }
        }
        
        return;
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
