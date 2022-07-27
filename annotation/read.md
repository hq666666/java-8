#JDK5中的注解：
 #1.注解 ： 相当于一种标记，在程序中加了注解就等于为程序加了某种标记
 #2.作用：  告诉javac编译器或者java开发工具……向其传递某种信息，作为一个标记
 #3.如何理解注解： 
       · 一个注解就是一个类
       · 标记可以加在包、类、字段、方法，方法参数以及局部变量上。可以同时存在多个注解
   #注意：
        1. 添加注解需要有注解类，RetentionPolicy 是一个枚举类
        2. Target 中可以存放数组，它的默认值为任何元素
            
            · ElementType.METHOD: 只能标记在方法上
            · ElementType.TYPE:   只能标记定义在类上、接口上、枚举上等
        
        3. ElementType 也是枚举类。成员包括：ANNOTATION_TYPE(注解)、CONSTRUCTOR(构造方法)、FIELD(成员变量)、LOCAL_VARIABLE(变量)
           METHOD(方法)、PACKAGE(包)、PARAMETER(参数)、TYPE。
        
        4. 关于注解
            
            · 元注解：注解的注解
            · 元数据：数据的数据
            · 元信息：信息的信息
        
        5. 注解分为三个阶段：java源文件 -> class文件 -> 内存中的字节码
           Retention的注解有三种取值：(分别对应注解的三个阶段)
           
               · RetentionPolicy.SOURCE
               · RetentionPolicy.CLASS
               · RetentionPolicy.RUNTIME
            注意：注解的默认阶段是Class;
        
        6. 注解的属性类型：原始类型(八个基本数据类型)、String类型、Class类型、数组类型、枚举类型、注解类型
        
        7. 注解增加属性：
               
               value：是一个特殊的属性，若在设置值时只有一个value属性需要设置或者其他属性都采用默认值时，那么value=可以省略，直接写所设置的值即可
        
#JDK8中的注解               
 #1.类型注解：
    1.1 java 8 的类型注解扩展了使用的范围
        · 在 java8 里面，当类型转化甚至分配新对象的时候，都可以在声明变量或参数的时候使用注解；
        · java 注解可以支持任意类型，类型注解只有语法而不是语义，并不会影响 java 的编译时间，加载时间，以及运行时间，也就是说，编译成 class 文件的时候并不包含类型注解
    
    1.2 新增ElementType.TYPE_USE 和 ElementType.TYPE_PARAMETER:
         · ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中
         · ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中
 
 #2.重复注解：同一声明类型上可以多次使用同一个注解，需要使用@Repeatable
                
                    
                           
      