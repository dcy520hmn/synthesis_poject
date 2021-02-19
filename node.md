[TOC]

# AOP

- @Order注解作用

  Springboot中设置初始化的顺序。

- Pointcut注解表达式

  ```java
  //@Around("@annotation(自定义注解)")//自定义注解标注在方法上的方法执行aop方法
  如：@Around("@annotation(org.springframework.transaction.annotation.Transactional)")
  
  //@Around("@within(自定义注解)")//自定义注解标注在的类上；该类的所有方法（不包含子类方法）执行aop方法
  如：@Around("@within(org.springframework.transaction.annotation.Transactional)")
  
  //@Around("within(包名前缀.*)")//com.aop.within包下所有类的所有的方法都会执行(不包含子包) aop方法
  如：@Around("within(com.aop.test.*)")
  
  //@Around("within(包名前缀..*)")//com.aop.within包下所有的方法都会执行(包含子包)aop 方法
  如：@Around("within(com.aop.test..*)")
  
  //@Around("this(java类或接口)")//实现了该接口的类、继承该类、该类本身的类---的所有方法（包括不是接口定义的方法，但不包含父类的方法）都会执行aop方法
  如：@Around("this(com.aop.service.TestService)")
  
  //@Around("target(java类或接口)")//实现了该接口的类、继承该类、该类本身的类---的所有方法（包括不是接口定义的方法，包含父类的方法）
  如：@Around("this(com.aop.service.TestService)")
  
  //@Around("@target(自定义注解)")//springboot项目启动报如下错误，没有解决
  // Caused by: java.lang.IllegalStateException:
  // StandardEngine[Tomcat].StandardHost[localhost].TomcatEmbeddedContext[] failed to start
  ```


- JoinPoint的使用

  ```java
  //JoinPoint的使用，获得对应的注解
  public void before(JoinPoint point) throws Throwable{
      Signature signature = point.getSignature();
  	MethodSignature methodSignature = (MethodSignature) signature;
  	Method method = methodSignature.getMethod();
  	PreAuthorize annotation = method.getAnnotation(PreAuthorize.class);
  }
  ```

- 1

# spring注解

- `@ConditionalOnProperty`

  

- 从

# 多数据源处理

​	https://blog.csdn.net/qq_37502106/article/details/91044952



# Swager2

在后端通过注解的形式用于给前端描述接口信息。

https://blog.csdn.net/qq_37131913/article/details/111151379

# 多线程

- ThreadLocal

  **线程局部变量**：在并发编程的时候，成员变量如果不做任何处理其实是线程不安全的。

  **应用场景**：很多线程需要多次使用同一个对象，并且需要该对象具有相同初始化值的时候最适合使用ThreadLocal

  **原理**：内部维护一个ThreadLocalMap。每个线程都有对应的ThreadLocalMap.Entry，该Entry存着变量的值。

- 

# 日志处理

```java
public static final Logger log = LoggerFactory.getLogger(DataSourceManage.class);
```

# 导出excel

使用的工具包如下

```java
		<dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>${poi.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>${poi.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml-schemas</artifactId>
            <version>${poi.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.xmlbeans</groupId>
            <artifactId>xmlbeans</artifactId>
            <version>${xmlbeans.version}</version>
        </dependency>
```

# Java8新特性

# xss攻击

**XSS 即（Cross Site Scripting）中文名称为：跨站脚本攻击。**

https://www.cnblogs.com/tugenhua0707/p/10909284.html

感觉都是前端的知识

