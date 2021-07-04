### Serial收集器

- java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails GCLogAnalysis

- 新生代采用标记复制算法，单线程，STW
- 老年代采用标记整理算法，单线程，STW



### Parallel收集器

- java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails GCLogAnalysis
- 新生代采用标记复制算法，多线程，STW
- 老年代采用标记整理算法，多线程，STW



### CMS收集器

- java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails GCLogAnalysis

- 只适用于老年代

- GC日志

  ```
  [GC (CMS Initial Mark) [1 CMS-initial-mark: 209679K(349568K)] 227522K(506816K), 0.0001946 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  [CMS-concurrent-mark-start]
  [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
  [CMS-concurrent-preclean-start]
  [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  [CMS-concurrent-abortable-preclean-start]
  [CMS-concurrent-abortable-preclean: 0.005/0.190 secs] [Times: user=0.82 sys=0.08, real=0.19 secs]
  [GC (CMS Final Remark) [YG occupancy: 17621 K (157248 K)][Rescan (parallel) , 0.0003240 secs][weak refs processing, 0.0000131 secs][class unloading, 0.0002668 secs][scrub symbol table, 0.0004251 secs][scrub string table, 0.0001868 secs][1 CMS-remark: 346891K(349568K)] 364513K(506816K), 0.0012909 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
  [CMS-concurrent-sweep-start]
  [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  [CMS-concurrent-reset-start]
  [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
  ```

- 由GC日志可看出，CMS GC分为7个阶段
  - Initial Mark（初始标记），标记根对象，以及GC Root直接引用的对象等，STW
  - Concurrent Mark（并发标记），查找所有存活的对象
  - Concurrent Preclean（并发预清理）
  - Concurrent Abortable Preclean（可取消的并发预清理）
  - Final Remark（最终标记），最后一次查找存活的对象，STW
  - Concurrent Sweep（并发清除），删除不用的对象，回收内存
  - Concurrent Reset（并发重置），重置CMS相关的数据结构



### G1收集器

- java -XX:+UseG1GC -Xms512m -Xmx512m -XX:+PrintGCDetails GCLogAnalysis
- 基于Region的内存布局，Region可以是Eden，Survivor，Old任意一种空间
- G1 GC分为5个阶段
  - Initial Mark（初始标记）
  - Root Region Scan（Root区扫描）
  - Concurrent Mark（并发标记）
  - Remark（重新标记）
  - Cleanup（清除）

