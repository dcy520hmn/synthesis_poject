本例为链路追踪学习

# 概念

##  分布式追踪系统

随着大量公司把单体应用重构为微服务，对于运维人员的责任就更加重大了。架构更复杂、应用更多，要从中快速诊断出问题、找到性能瓶颈，并不是一件容易的事。因此，也随着诞生了一系列面向`DevOps`的诊断与分析系统，主要是以下三个系统：

- 集中式日志系统（Logging）
- 集中式度量系统（Metrics）
- 分布式追踪系统（Tracing）

三者相互交织重叠如下：![image-20210202170029240](https://cdn.jsdelivr.net/gh/dcy520hmn/image01/20210202170036.png)

loggin_metrics_tracing

技术栈上的成熟框架有，

Logging：Log4j、ELK等，

Metrics：Prometheus、InfluxDB、Grafana等

Tracing：Jaeger和Zipkin等。

分布式追踪系统在Google发表一篇文章Dapper, a Large-Scale Distributed Systems Tracing Infrastructure后快速发展。Tracing系统一般核心步骤有三个：代码埋点、数据存储、查询展示。

历史洪流滚滚向前，大浪淘沙，现在比较流行的有`Jaeger`和`Zipkin`。

## OpenTracing

由于`Tracing`的技术发展迅速，为了解决兼容性问题，有了OpenTracing规范。它是一个轻量级的标准化层，连接应用、类库和追踪系统。

![img](https://cdn.jsdelivr.net/gh/dcy520hmn/image01/20210202170116.jpeg)OpenTracing的优势：

（1）OpenTracing已经进入`CNCF`（云原生计算基金会，口号是坚持和整合开源技术来编排容器作为微服务架构的一部分），正在为全球的分布式追踪，提供统一的概念和数据标准。

（2）OpenTracing通过提供平台无关、厂商无关的`API`，使得开发人员能够方便添加和更换追踪系统的实现。



## 相关概念

`Trace`：贯穿一个分布式系统的事务追踪描述，其实就是由许多个`Span`组成的有向无环图。

`Span`：被命名的与记录时间的调用操作，如一个Http GET请求；`Span`有嵌套关系，如果一个请求会调用其它服务，就会生成子`Span`。

`Tag`：一组由键值对构成的标签集合，键值类型必须为字符串。它可以带上许多有用信息，如请求方法、请求URL、返回状态码等。

`Log`：一组`Span`的日志集合。

## OpenTracing的实现

`Jaeger`是`Uber`推出的一款开源分布式追踪系统，兼容`OpenTracing API`。架构如下：

![img](https://cdn.jsdelivr.net/gh/dcy520hmn/image01/20210202170141.jpeg)

`Zipkin`是由`Twitter`推出的开源的分布式追踪系统，架构图如下：

![img](https://cdn.jsdelivr.net/gh/dcy520hmn/image01/20210202170515.jpeg)

# 实战整合

本文以Springboot为Web项目，分别整合`Jaeger`和`Zipkin`。

##  Springboot项目准备

项目中的`Controller`，提供了两个Endpoint，`tracing`和`open`；在访问`open`时，代码会调用`tracing`。

```java
@RestController
public class TracingController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private int port;

    @RequestMapping("/tracing")
    public String tracing() throws InterruptedException {
        Thread.sleep(100);
        return "tracing";
    }

    @RequestMapping("/open")
    public String open() throws InterruptedException {
        ResponseEntity<String> response = 
          restTemplate.getForEntity("http://localhost:" + port + "/tracing", 
                                    String.class);
        Thread.sleep(200);
        return "open " + response.getBody();
    }
}
```

为了能够方便看出调用时长信息，特别在代码中增加了延时`Thread.sleep()`。

配置Web应用的端口和服务名字：

```
server:
  port: 8080
spring:
  application:
    name: opentracing-demo
opentracing:
  jaeger:
    enabled: true
    udp-sender:
      host: 192.168.61.132
      port: 6831
```

### Docker运行Jaeger

为了方便，使用`docker`来运行`Jaeger`：

```
# 拉取jaeger镜像
docker pull jaegertracing/all-in-one:1.17
# 运行jaeger实例，
docker run -d --name jaeger \
  -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
  -p 5775:5775/udp \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 14268:14268 \
  -p 14250:14250 \
  -p 9411:9411 \
  jaegertracing/all-in-one:1.17
```

### 运行与访问UI

启动Web应用和Jaeger后，访问服务：

http://localhost/open

http://localhost/tracing

访问Jaeger UI界面http://localhost:16686/，设置好查询条件后点击`Find Traces`，就能查看到Trace信息了。

# 参考链接

https://zhuanlan.zhihu.com/p/125700427