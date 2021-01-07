import java.util.*;

// 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
// 写入数据 put(key, value) -
// 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

// 进阶:

// 你是否可以在 O(1) 时间复杂度内完成这两种操作？

// 示例:

// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1); // 返回 1
// cache.put(3, 3); // 该操作会使得密钥 2 作废
// cache.get(2); // 返回 -1 (未找到)
// cache.put(4, 4); // 该操作会使得密钥 1 作废
// cache.get(1); // 返回 -1 (未找到)
// cache.get(3); // 返回 3
// cache.get(4); // 返回 4

class LRUCache {
    class ListNode {
        public int key;
        public int val;
        public ListNode next;
        public ListNode pre;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

//  public ListNode head = new ListNode(0, 0), tail = head;
//  private Map<Integer, ListNode> map = new HashMap<>();
//  private int cap = 0;
//
//  public LRUCache(int capacity) {
//    this.cap = capacity;
//  }
//
//  public int get(int key) {
//    if (this.map.containsKey(key)) {
//      ListNode node = this.map.get(key);
//      // 只有一个node
//      if (head.next == node) {
//        return node.val;
//      }
//      // node不是最后一个
//      if (node != tail) {
//        node.next.pre = node.pre;
//      } else {
//        tail = tail.pre;
//      }
//      node.pre.next = node.next;
//      head.next.pre = node;
//      node.next = head.next;
//      node.pre = head;
//      head.next = node;
//
//      return node.val;
//    }
//    return -1;
//  }
//
//  public void put(int key, int value) {
//    if (this.map.containsKey(key)) {
//      // 更新，不删除
//      this.map.computeIfPresent(key, (k, v) -> {
//        v.val = value;
//        return v;
//      });
//      // 放到head后
//      this.get(key);
//      return;
//    }
//    if (this.map.size() >= this.cap) {
//      // 删除最后的key
//      this.map.remove(this.tail.key);
//      this.tail = this.tail.pre;
//    }
//    ListNode node = new ListNode(key, value);
//    this.map.put(key, node);
//    if (this.tail == this.head) {
//      // 为空，直接插入
//      this.head.next = node;
//      node.pre = this.head;
//      tail = tail.next;
//      return;
//    }
//    // 不为空，插到head后
//    node.next = this.head.next;
//    node.pre = this.head;
//    this.head.next.pre = node;
//    this.head.next = node;
//  }
}

public class T146 {
    class LRUCache {
        private LinkedHashMap<Integer, Integer> map = new LinkedHashMap();
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                makeRecent(key);
                return map.get(key);
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.put(key, value);
                makeRecent(key);
                return;
            }
            if (map.size() >= cap) {
                int oldKey = map.entrySet().iterator().next().getKey();
                map.remove(oldKey);
            }
            map.put(key, value);
            cap++;
        }

        private void makeRecent(int key) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
        }
    }


}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */