class Node{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
    }
}
class LRUCache {
    int n;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        n=capacity;
        map=new HashMap<>(capacity);
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public void insert(Node node){
        node.next=head.next;
        node.prev=head;
        node.next.prev=node;
        head.next=node;
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            remove(map.get(key));
            insert(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            remove(n);
            Node newnode=new Node(key,value);
            insert(newnode);
            map.put(key,newnode);
        }else{
            if(map.size()==n){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newnode=new Node(key,value);
            map.put(key,newnode);
            insert(newnode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */