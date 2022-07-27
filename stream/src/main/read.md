Stream 是 java8 中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作；
使用Stream API 对集合数据进行操作，就类似于使用 SQL 执行数据库查询；
可以使用 Stream Api 来并行执行操作；
简而言之，Stream API 提供一种高效且易于使用的处理数据的方式

 #流是数据渠道，用于操作数据源(集合、数组等)所生成的元素序列。"集合讲的是数据，流讲的是计算！”
 
 #注意：
     ① Stream 自己不会存储元素
     ② Stream 不会改变源对象。相反，会返回一个持有结果的新 Stream
     ③ Stream 操作是延迟执行的。这意味着会等到需要结果的时候才执行
     
 
#Stream 的中间操作：
  #多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理，而在终止操作时一次性全部处理，称为“惰性求值”
  
  #1.筛选与切片：
        
        filter(Predicate p): 接收lambda，从流中排除某些元素
        distinct(): 筛选,通过流所生成的元素的 hashCode() 和 equals() 去除重复元素
        limit(long maxSize): 截断流，使其元素不超过给定数量
        skip(long n): 跳过元素
  #2.映射
     
     map(Function f): 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     mapToDouble(ToDoubleFunction f): 接收一个函数作为参数，该函数会被应用到每个元素上,产生一个新的 DoubleStream
     mapToInt(ToIntFunction f):    接收一个函数作为参数，该函数会被应用到每个元素上,产生一个新的 IntStream
     mapToLong(ToLongFunction f):   接收一个函数作为参数，该函数会被应用到每个元素上,产生一个新的 LongStream
     flatMap(Function f): 接收一个函数作为参数,将流中的每个值都换成另一个流，然后把所有流连接成一个流
  
  #3.排序   
  
     sorted(): 产生一个新流，其中按自然顺序排序
     sorted(Comparator comp): 产生一个新流，其中按比较器顺序排序
  
#Stream 的终止操作
  #终端操作会从流的流水线生成结果，其结果可以是任何不是流的值，例如：list、integer甚至是void；
  
  #1.查找与匹配
   
    allMatch(Predicate p): 检查是否匹配所有的元素
    anyMatch(Predicate p): 检查是否至少匹配一个元素
    noneMatch(Predicate p): 检查是否没有匹配所有元素
    findFirst(): 返回第一个元素
    findAny(): 返回当前流中的任意元素
    count(): 返回流中元素总数
    max(Comparator c): 返回流中最大值
    min(Comparator c): 返回流中最小值
    forEach(Cosumer c): 内部迭代
  
  #2.规约
    
    reduce(T iden,BinaryOperator b): 可以将流中元素反复结合起来，得到一个值，返回T
    reduce(BinaryOperator b): 可以将流中元素反复结合起来，得到一个值，返回Optional<T>;
  
  #3.收集
  
     collect(Collector c): 将流转换为其他形式，接收一个 Collector 接口的实现，用于给 Stream 中元素做汇总的方法
   #Collector 接口中方法的实现决定了如何对流执行收集操作(如收集到List、set、map)。但是Collectors 实用类提供了很多静态方法，
   #可以方便地创建常见收集器实例；具体方法与实例如下：
        
        toList: 把流中元素收集到List
        toSet:  把流中元素收集到Set
        toCollection:  把流中元素收集到Collection
        counting: 计算流中元素的个数
        summingInt: 对流中元素的证书属性求和
        averagingInt: 计算流中元素 Integer 属性的平均值
        summarizingInt: 收集流中 Integer 属性的统计值
        joining: 连接流中每个字符串
        maxBy: 根据比较器选择最大值
        minBy: 根据比较器选择最小值
        reducing: 从一个作为累加器的初始值开始，利用BinaryOperator与流中元素逐个结合，从而规约成单个值
        collectingAndThen: 包裹另一个收集器，对其结果转换函数
        groupingBy: 根据某属性对流分组，属性为K，结果为V
        partitioningBy: 根据true或FALSE进行分区

#并行流与串行流：
  #并行流就是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流
  #java8 中将并行进行了优化，可以声明性地通过 parallel() 与 sequential() 在并行流与顺序流之间进行切换
  
  #Fork/Join 框架
  
   #1.简单概述：在必要的情况下，将一个大任务，进行拆分(fork)成若干个小任务(拆到不可再拆时)，再将一个个的小任务运算的结果进行 join 汇总；
   #2.Fork/Join框架与传统线程池的区别：
       #采用 “工作窃取”模式(work-stealing),当执行新的任务时它可以将其拆分分成更小的任务执行，并将小任务加到线程队列中，然后再从一个随机线程的队列中偷一个并把它放在自己的队列中； 
       #相对于一般的线程池的实现，fork/join 框架的优势体现在对其中包含的任务的处理方式上。在一般的线程池中，如果一个线程正在执行的任务由于某些原因无法继续执行，那么该线程会处于等待状态；
       #而在fork/join 实现中，如果某个子问题由于等待另外一个子问题的完成而无法继续运行，那么处理该子问题的线程会主动寻找其他尚未运行的子问题来执行，这种方式减少了线程等待时间，提高性能；
       
   
       