java7 与 java8 中的hashmap
     · JDK7 HashMap 结构为数组 + 链表 (发生元素碰撞时，会将新元素添加到链表的开头)
     · JDK8 HashMap 结构为数组 + 链表 + 红黑树 (发生元素碰撞时，会将新元素添加到链表末尾，当 HashMap 总容量大于等于 64，
       并且某个链表的大小大于等于 8,会将链表转化为红黑树(注意：红黑树是二叉树的一种))
       
JDK8 HashMap 重排序：

   如果删除了 HashMap 中红黑树的某个元素导致元素重排序时，不需要计算待重排序的 HashCode 码，只需要将当前元素放到
   (HashMap总长度 + 当前元素在HashMapzh中的位置)的位置即可       