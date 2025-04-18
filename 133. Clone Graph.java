
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node){
        System.out.println(node.val);

        for(Node n : node.neighbors){
            System.out.println(n.val);
        }

        return null;
    }

    public Node cloneGraphBFS(Node node) {
        if (node == null) return null;

        
        Queue<Node> q = new ArrayDeque<>(List.of(node));
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        while(!q.isEmpty()){
            Node u = q.poll();
            for(Node v : u.neighbors){
                if(!map.containsKey(v)){
                    map.put(v, new Node(v.val));
                    q.offer(v);
                }
                map.get(u).neighbors.add(map.get(v));
            }
        }
        return map.get(node);
    }

    public Node cloneGraphDFS(Node node){
        if(node == null) return null;

        if(map.containsKey(node)) return map.get(node);

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for(Node neighbor : node.neighbors){
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }

    private Map<Node, Node> map = new HashMap<>();
}