[TOC]

<span style='color:black;background:背景颜色;font-size:40px;font-family:字体;'>synthesis_poject</span>

该项目用于日常技术学习与积累，包含了大量的Demo，每个Demo都与node.md知识相对应，可先参考node中学习概念知识，然后在Readme中找到对应练习。为方便日后查询Demo，可参考以下内容。

<span style='color:black;background:背景颜色;font-size:40px;font-family:字体;'>模块描述</span>

|                    模块名称                    |                           描述                           |
| :--------------------------------------------: | :------------------------------------------------------: |
|              **synthesis_poject**              |          父模块队以下模块的依赖进行版本控制管理          |
|            **[bigdata](# bigdata)**            |                        大数据内容                        |
|           [**dtabase**](# database)            |                        数据库内容                        |
|       **[fgosRelation](# fgosRelation)**       |                      项目中技术内容                      |
|         **[java_Basic](# java_Basic)**         |                         jdk内容                          |
|        **[leading_End](# leading_End)**        |                         前端内容                         |
|           **[rabbitMq](# rabbitMq)**           |                          MQ内容                          |
|        **[sping_redis](# sping_redis)**        |                        Redis内容                         |
|        **[spring_boot](# spring_boot)**        |    一个完整的springboot应用，具有启动器，可以web访问     |
|       **[spring_cloud](# spring_cloud)**       | spring_cloud应用包含，服务之间的调用、注册中心、负载均衡 |
| **[spring_httpInvoker](# spring_httpInvoker)** |                    RPC的一种调用方式                     |
|   **[spring_springmvc](# spring_springmvc)**   |         最原始的springmvc定义方式，采用xml的形式         |
|         **[spring_ssh](# spring_ssh)**         |                ssh框架集成（采用xml形式）                |
|         **[spring_ssm](# spring_ssm)**         |                ssm框架集成（采用xml形式）                |
|              **[utils](# utils)**              |  日常中的工具：dorm4j（xml文件解析）、trace（链路追踪）  |
|          **[serverSOA](# serverSAP)**          |                         服务治理                         |

# synthesis_poject

# bigdata

- ***curator-zk***

- ***hadoopClient***

  描述：用于学习Hadoop客户端API

- ***kafkaClient***

  描述：用于学习kafka生成者API与消费者API

  - ***producer***

    - 同步向kafa发送消息

      [ProducerAsync](bigdata/kafkaClient/producer/src/main/java/com/dcy/kafka/ProducerAsync.java)

    - 异步向kafka发送消息

      [ProducerSync](bigdata/kafkaClient/producer/src/main/java/com/dcy/kafka/ProducerSync.java)

  - ***consumer***

    - 消费kafka中消息

      [ConsumerKafka](bigdata/kafkaClient/consumer/src/main/java/com/dcy/kafka/ConsumerKafka.java)

# database

# fgosRelation

# java_Basic

- 阿里巴巴技术

  [AsyncCall](java_Basic/src/test/java/com/dcy/alibaba/AsyncCall.java)：异步非阻塞编程

  

## java_Basic

- Stream特性

  :full_moon:[StreamDemo](java_Basic/src/test/java/com/dcy/util/StreamDemo.java)

- 比较器

  :full_moon:[ComparatorDemo](java_Basic/src/test/java/com/dcy/util/ComparatorDemo.java)

- 虚拟机

  - 静态方法解析

    [StaticMethodResolution](java_Basic/src/main/java/com/dcy/hotspot/executeSystem/stackFrame/StaticMethodResolution.java)
  
  - Java虚拟机类加载以及子系统实战：在服务端执行临时代码
  
    [practice](java_Basic/src/main/java/com/dcy/hotspot/executeSystem/practice)

# leading_End

# rabbitMq

# sping_redis

# spring_boot

- 注解配置Bean

  [BeanDemo](spring_boot/src/main/java/com/springboot/config/beanDemo/BeanDemo.java)

- AOP

  [AccountAspect](spring_boot/src/main/java/com/springboot/config/aspect/AccountAspect.java)

# spring_cloud

# spring_httpInvoker

# spring_springmvc

# **spring_ssh**

# spring_ssm

# utils

##  trace

- 项目预览

  :waxing_crescent_moon:[ReadMe](utils/trace/README.md)

# serverSAP

# message

- 简介

  国际化处理，springboot中使用MessageSource国际化

- 