// Problem link: https://leetcode.com/problems/lfu-cache/

class LFUCache {

    // tc: O(1) sc: O(capacity)

    final int capacity;
    int cursize;
    int minfreq;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> freqmap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cursize = 0;
        this.minfreq = 0;
        this.cache = new HashMap<>();
        this.freqmap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode curnode = cache.get(key);
        if (curnode == null) return -1;
        UpdateNode(curnode);
        return curnode.val;
    }

    public void UpdateNode(DLLNode curnode) {
        int curfreq = curnode.freq;
        DoubleLinkedList curlist = freqmap.get(curfreq);
        curlist.removeNode(curnode);

        if (curfreq == minfreq && curlist.listsize == 0) {
            minfreq++;
        }
        curnode.freq++;

        DoubleLinkedList newlist = freqmap.getOrDefault(curnode.freq, new DoubleLinkedList());
        newlist.addNode(curnode);
        freqmap.put(curnode.freq, newlist);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            DLLNode curnode = cache.get(key);
            curnode.val = value;
            UpdateNode(curnode);
        } else {
            cursize++;
            if (cursize > capacity) {
                DoubleLinkedList minfreqlist = freqmap.get(minfreq);
                cache.remove(minfreqlist.tail.prev.key);
                minfreqlist.removeNode(minfreqlist.tail.prev);
                cursize--;
            }
            minfreq = 1;
            DLLNode newnode = new DLLNode(key, value);
            DoubleLinkedList curlist = freqmap.getOrDefault(1, new DoubleLinkedList());
            curlist.addNode(newnode);
            freqmap.put(1, curlist);
            cache.put(key, newnode);
        }
    }

    class DLLNode {
        int key, val, freq;
        DLLNode prev, next;

        public DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoubleLinkedList {
        int listsize;
        DLLNode head;
        DLLNode tail;

        public DoubleLinkedList() {
            this.listsize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(DLLNode curnode) {
            DLLNode nextnode = head.next;
            curnode.next = nextnode;
            curnode.prev = head;
            head.next = curnode;
            nextnode.prev = curnode;
            listsize++;
        }

        public void removeNode(DLLNode curnode) {
            DLLNode prevnode = curnode.prev;
            DLLNode nextnode = curnode.next;
            prevnode.next = nextnode;
            nextnode.prev = prevnode;
            listsize--;
        }
    }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */