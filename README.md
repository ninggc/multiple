# 项目简述

## spring-microservice-cloud-demo
整个spring cloud的微服务项目
1. spring-config-demo 配置中心

    需要第一个启动, 启动后其他的微服务会通过配置中心统一获取配置文件.
    
1. micro-discovery-service 发现中心

    需要在配置中心之后启动, 基于Eureka实现.

1. micro-user-service 单个web项目

    在发现中心之后启动, 将自身注册到发现中心, 提供对用户模块的服务.
    
1. micro-manage-service 包括http通信的微服务
    
    通过相应的配置可以通过Feign与其他的微服务中心进行交互, Feign提供了一种相当优雅的Http交互的方式.
    
1. micro-gateway-service 网关(未完成)

    未完成

## other-demo 一些小demo