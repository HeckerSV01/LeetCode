class Node{
    int key;
    int value;
    Node next;
    Node prev;
    int freq;

    public Node(int key,int value){
        this.key=key;
        this.value=value;
        this.next=null;
        this.prev=null;
        this.freq=1;
    }
}

class Dll{
    Node head;
    Node tail;
    int size;

    public Dll(){
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        size=0;
    }

    public void insert(Node node){
        node.next=head.next;
        node.prev=head;
        node.next.prev=node;
        head.next=node;
        size++;
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        size--;
    }
}

class LFUCache {
    HashMap<Integer,Dll> freqMap;
    HashMap<Integer,Node> map; 
    int n;
    int minfreq;
    public LFUCache(int capacity) {
        n=capacity;
        freqMap=new HashMap<>();
        map=new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node currnode=map.get(key);
            update(currnode);
            return currnode.value;
        }
        return -1;
    }
    
    public void update(Node currnode){
        int currfreq=currnode.freq;
        Dll list=freqMap.get(currfreq);
        list.remove(currnode);
        if(currfreq==minfreq&&list.size==0){
            minfreq++;
        }
        currnode.freq++;
        freqMap.putIfAbsent(currnode.freq,new Dll());
        freqMap.get(currnode.freq).insert(currnode);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node currnode=map.get(key);
            currnode.value=value;
            update(currnode);
            return;
        }else{
            if(map.size()==n){
                Dll list=freqMap.get(minfreq);
                map.remove(list.tail.prev.key);
                list.remove(list.tail.prev);
            }
            Node newnode=new Node(key,value);
            minfreq=1;
            map.put(key,newnode);
            freqMap.putIfAbsent(1,new Dll());
            freqMap.get(1).insert(newnode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */