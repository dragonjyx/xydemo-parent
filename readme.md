#xydemo-parent 工程

[SpringMVC](http://www.springmvc.cn/) -以[Spring](https://spring.io/)为核心的SSM(SpringMVC,Spring,Mybatis)工程
### xydemo-dao-common
     数据库持久层依赖整理

### xydemo-mybatis
    jdbc->jdbcTemplate->iBatic->mybatis->hibernate
    单例设计模式、模板设计模式、责任链设计模式、线程池

### xydemo-spring
    Spring IOC AOP 原理，xml配置方式 & 注解模式
    工厂设计模式、代理设计模式、动态代理设计模式

### xydemo-startweb
    简单的spring Boot WebMVC工程

### xydemo-utils
    工具类，基本搭建工程都能使用到
    
### xydemo-web
    完整的J2EE 工程，基于springBoot  
    SSM三层架构
    页面后端渲染(集成freemarker) & 前后端分离（api交互，token校验）
    Api文档管理
    日志管理
    异常捕捉
    参数校验
    认证授权
 #
 [RPC](https://www.jianshu.com/p/7d6853140e13) —以[dubbo](http://dubbo.apache.org/)为案例，使用[nacos](https://nacos.io)作为注册中心
 ![image](http://dubbo.apache.org/img/architecture.png)

### xydemo-dubbo-common
       dubbo引入整理
 
### xydemo-dubbo-service-api
       dubbo api接口层
        
### xydemo-dubbo-service
       dubbo api实现（提供者）
       基于nacos注册中心
       
### xydemo-dubbo-client
       dubbo api调用（消费者）
       基于nacos注册中心
 
### xydemo-dubbo-sentinel-client
       dubbo 限流熔断（未完成）
       基于nacos注册中心
   
 
#
 [Spring Cloud](https://www.springcloud.cc/) -使用[OpenFeign](https://spring.io/projects/spring-cloud-openfeign)作为客户端，[Sentinel](https://github.com/alibaba/Sentinel)作为限流熔断服务，使用[nacos](https://nacos.io)作为注册中心

### xydemo-springcloud-provider
       基于SpringBoot Web服务提供者 
       基于nacos注册中心  

### xydemo-springcloud-consumer
       基于SpringBoot Web服务消费者
       基于nacos注册中心
       集成OpenFeign
       集成Sentinel 熔断功能
       
### xydemo-nacos-properties-seperate
      基于nacos注册中心
      使用nacos作配置分离
          

