package company;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheMain {
    //https://leetcode.com/problems/lru-cache/

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }

}

class LRUCache{
    int capacity;
    Map<Integer, DDLNode> cacheMap;
    DDLNode headNode;
    DDLNode tailNode;

    @Override
    public String toString() {
        return "LRUCache{" +
                "headNode=" + headNode +
                ", tailNode=" + tailNode +
                '}';
    }

    public LRUCache(int n) {
        cacheMap = new HashMap<>(n);
        this.capacity = n;
    }

    class DDLNode {
        DDLNode prevNode;
        DDLNode nextNode;
        int key;
        int value;

        public DDLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "DDLNode{" +
                    "key=" + key +
                    '}';
        }
    }

    public void put(int key, int value){
        DDLNode newNode = new DDLNode(key,value);
        if(cacheMap.containsKey(key)){
            this.remove(cacheMap.get(key));
        }
        else if(cacheMap.size() == capacity){
            DDLNode currTail = this.tailNode;
            this.tailNode = currTail.prevNode;
            this.remove(currTail);
        }
        this.add(newNode);
//        System.out.println("PUT: "+key);
//        System.out.println("Map size: "+cacheMap.size());
//        System.out.println(this);
    }

    public Integer get(int key){
        DDLNode getNode = cacheMap.get(key);
//        System.out.println("GET: "+key);
        if(null == getNode){
//            System.out.println(this);
            return -1;
        }
        else {
            //Remove the getNode and add it at the head
            this.remove(getNode);
            this.add(getNode);
//            System.out.println(this);
            return getNode.value;
        }
    }

    private void remove(DDLNode removeNode) {
        DDLNode beforeNode = removeNode.prevNode;
        DDLNode afterNode = removeNode.nextNode;
        if(beforeNode != null)
        beforeNode.nextNode = afterNode;
        if (afterNode!=null)
        afterNode.prevNode = beforeNode;
        cacheMap.remove(removeNode.key);
    }

    private void add(DDLNode newNode)
    {
        DDLNode prevHead = this.headNode;
        this.headNode = newNode;
        this.headNode.nextNode = prevHead;

        if(prevHead != null)
        prevHead.prevNode = this.headNode;

        if(null == tailNode){
            tailNode = prevHead;
        }
        this.cacheMap.put(newNode.key, newNode);
    }
}
