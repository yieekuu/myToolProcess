  //
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 3212 👎 0


  package liye.carlos.myToolProcess.leetcode.editor.cn;

  import java.util.HashMap;
  import java.util.LinkedList;

  public class LruCache{
      public static void main(String[] args) {

      }
      //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
          //LinkedList 删除节点时间复杂度不够，需要实现一个双向链表，从而达到o(1)时间复杂度的删除
          private int capacity;
          private int size;
          private LinkedList<Integer> list;
          private HashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.list = new LinkedList<>();
        this.cache = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        Integer value = cache.get(key);
        if (value == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        list.remove((Integer) key);
        list.addFirst(key);
        return value;
    }
    
    public void put(int key, int value) {
        Integer oldValue = cache.get(key);
        if (oldValue == null) {
            // 如果 key 不存在，创建一个新的节点

            // 添加进哈希表
            cache.put(key, value);
            // 添加至双向链表的头部
            list.addFirst(key);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
               Integer oldKey = list.removeLast();
               cache.remove(oldKey);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            cache.put(key,value);
            list.remove((Integer)key);
            list.addFirst(key);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }